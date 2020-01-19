package com.example.maps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("id_brg_keluar")
    @Expose
    private String id_brg_keluar;

    @SerializedName("status_brg")
    @Expose
    private String status_otb;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    public Location(){}

    public String getId_brg_keluar() {
        return id_brg_keluar;
    }

    public void setId_brg_keluar(String id_brg_keluar) {
        this.id_brg_keluar = id_brg_keluar;
    }

    public String getStatus_otb() {
        return status_otb;
    }

    public void setStatus_otb(String status_otb) {
        this.status_otb = status_otb;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
