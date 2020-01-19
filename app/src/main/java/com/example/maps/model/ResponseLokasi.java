package com.example.maps.model;

import com.google.gson.annotations.SerializedName;

public class ResponseLokasi {
    @SerializedName("kode")
    String kode;
    @SerializedName("pesan")
    String pesan;

    public ResponseLokasi() {}

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
