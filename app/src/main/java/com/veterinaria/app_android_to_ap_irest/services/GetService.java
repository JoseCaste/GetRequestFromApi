package com.veterinaria.app_android_to_ap_irest.services;

import com.veterinaria.app_android_to_ap_irest.models.Servicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {
    @GET("/allServices")
    Call<List<Servicio>>getServices();
   /*String API_ROUTE = "/posts";

    @GET(API_ROUTE)
    Call< List<Servicio> > getPost();*/
}
