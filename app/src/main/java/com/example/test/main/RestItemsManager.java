package com.example.test.main;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestItemsManager {


    ItemServices mItemService;

    public ItemServices getmItemService() {
        if (mItemService == null) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://services.hanselandpetal.com")
                    .addConverterFactory(GsonConverterFactory
                            .create()).
                            build();
            mItemService = retrofit.create(ItemServices.class);

        }
        return mItemService;
    }


}
