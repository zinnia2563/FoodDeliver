package com.example.food_deliver;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_deliver.model.FoodData;

import com.example.food_deliver.model.Popular;
import com.example.food_deliver.retrofit.ApiInterface;
import com.example.food_deliver.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    //setup data in rv

    RecyclerView popularRecyclerView;

     Popular_Adapter popular_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);


       //fetched data from server
        Call<List<FoodData>> call = apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {
                List<FoodData> foodDataList = response.body();

                getPopularData(foodDataList.get(0).getPopular());


                // show data in rv;
                // rv in adapter


            }


            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Server is not responding", Toast.LENGTH_SHORT).show();
            }
        });

        }

    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recyclerview);
        popular_adapter = new Popular_Adapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popular_adapter);

    }


       }


