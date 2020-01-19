package com.example.maps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.LocationFragment;
import com.example.maps.R;
import com.example.maps.model.Location;

import java.util.List;

public class AdapterLocation extends RecyclerView.Adapter<AdapterLocation.HolderData> {

    private List<Location> mList;
    private Context ctx;

    public AdapterLocation(Context ctx, List<Location> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    public void setListBarang(List<Location> mList) {
        this.mList = mList;
    }


    @NonNull
    @Override
    public AdapterLocation.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist2,parent, false);
        AdapterLocation.HolderData holder = new AdapterLocation.HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLocation.HolderData holder, int position) {
        Location dm = mList.get(position);
        holder.kode.setText(dm.getId_brg_keluar());
        holder.longi.setText(dm.getLongitude());
        holder.lati.setText(dm.getLatitude());
        holder.status.setText(dm.getStatus_otb());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        if (mList == null) return 0;
        return mList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView kode, longi, lati, status;
        Location dm;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            kode = itemView.findViewById(R.id.kd_brg);
            longi = itemView.findViewById(R.id.longitude);
            lati = itemView.findViewById(R.id.latitude);
            status = itemView.findViewById(R.id.status_otb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx, LocationFragment.class);
                    goInput.putExtra("kode", dm.getId_brg_keluar());
                    goInput.putExtra("longitude", dm.getLongitude());
                    goInput.putExtra("latitude", dm.getLatitude());
                    goInput.putExtra("status", dm.getStatus_otb());
                }
            });
        }
    }
}
