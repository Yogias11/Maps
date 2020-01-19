package com.example.maps.api;

import com.example.maps.model.ResponseApiModel;
import com.example.maps.model.ResponseBarang;
import com.example.maps.model.ResponseLocation;
import com.example.maps.model.ResponseLokasi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @GET("get_barang.php")
    Call<ResponseBarang> barang();

    @GET("get_barang.php")
    Call<ResponseLocation> location();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseApiModel> login (@Field("username") String username,
                                  @Field("password") String password);

    @FormUrlEncoded
    @POST("longlat.php")
    Call<ResponseLokasi> sendlokasi (@Field("longitude") Double longitude,
                                     @Field("latitude") Double latitude);
}
