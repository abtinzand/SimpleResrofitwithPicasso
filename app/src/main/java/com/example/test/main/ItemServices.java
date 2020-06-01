package com.example.test.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemServices {

    @GET("/feeds/flowers.json")
    Call<List<Item>> getAllItems();

}
