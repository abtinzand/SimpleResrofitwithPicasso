package com.example.test.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapter adapter;
    RestItemsManager restItemsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        restItemsManager = new RestItemsManager();
        Call<List<Item>> listCall = restItemsManager.getmItemService().getAllItems();
        listCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

                if (response.isSuccessful()) {

                    List<Item> itemList = response.body();

                    for (int i = 0; i < itemList.size(); i++)
                    {
                        Item item = itemList.get(i);
                        adapter.addItem(item);
                    }

                } else {
                    int sc = response.code();
                    switch (sc) {
                        case 400:
                            Log.e("Error 400", "Bad Request");
                            break;
                        case 404:
                            Log.e("Error 404", "Not Found");
                            break;
                        default:
                            Log.e("Error", "Generic Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }


}

