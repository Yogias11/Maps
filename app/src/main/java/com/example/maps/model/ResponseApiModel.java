package com.example.maps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseApiModel {

    @SerializedName("kode")
    String kode;
    @SerializedName("pesan")
    String pesan;
    @SerializedName("result")
    List<User> result;

    public ResponseApiModel() {}

    public List<User> getResult() { return result; }

    public void setResult(List<User> result) {
        this.result = result;
    }

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

    }

}
