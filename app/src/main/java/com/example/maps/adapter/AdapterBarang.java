package com.example.maps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.BarangFragment;
import com.example.maps.R;
import com.example.maps.model.Barang;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.HolderData> {

    private List<Barang> mList;
    private Context ctx;

    public AdapterBarang(Context ctx, List<Barang> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    public void setListBarang(List<Barang> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterBarang.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarang.HolderData holder, int position) {
        Barang dm = mList.get(position);
        holder.kode.setText(dm.getId_brg_keluar());
        holder.status.setText(dm.getStatus_otb());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        if (mList == null) return 0;
        return mList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView kode, status;
        Barang dm;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            kode = itemView.findViewById(R.id.kd_brg);
            status = itemView.findViewById(R.id.status_otb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx, BarangFragment.class);
                    goInput.putExtra("kode", dm.getId_brg_keluar());
                    goInput.putExtra("status", dm.getStatus_otb());
                }
            });
        }
    }
}
