package com.example.maps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLocation {

    @SerializedName("result")
    private List<Location> result;

    @SerializedName("kode")
    private String kode;

    public List<Location> getResult() {
        return result;
    }

    public void setResult(List<Location> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
