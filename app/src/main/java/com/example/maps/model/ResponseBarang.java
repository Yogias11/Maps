package com.example.maps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBarang {

    @SerializedName("result")
    private List<Barang> result;

    @SerializedName("kode")
    private String kode;

    public List<Barang> getResult() {
        return result;
    }

    public void setResult(List<Barang> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
