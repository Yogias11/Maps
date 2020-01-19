package com.example.maps;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.maps.adapter.AdapterBarang;
import com.example.maps.api.ApiRequest;
import com.example.maps.api.RetroClient;
import com.example.maps.model.Barang;
import com.example.maps.model.ResponseBarang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BarangFragment extends Fragment {


    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<ResponseBarang> mItems = new ArrayList<>();
    private ProgressDialog loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_barang, container, false);

        loading = new ProgressDialog(getActivity());
        mRecycler = view.findViewById(R.id.rv);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        callBarang();
        return view;
    }

    private void callBarang(){
        loading.setMessage("Loading...");
        loading.setCancelable(true);
        loading.show();
        ApiRequest apiService = RetroClient.getUrl().create(ApiRequest.class);
        Call<ResponseBarang> getData = apiService.barang();
        getData.enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    List<Barang> barangList = response.body().getResult();
                    if (barangList.size() == 0) {
                        Log.i("TAG", "Data Barang Kosong");
                        Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_LONG).show();
                    } else {
                        AdapterBarang barang = new AdapterBarang(getActivity(), barangList);
                        barang.setListBarang(barangList);
                        barang.notifyDataSetChanged();
                        mRecycler.setAdapter(barang);
                    }
                } else {
                    loading.dismiss();
                    Toast.makeText(getActivity(), "Gagal mendapatkan data barang", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getActivity(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
