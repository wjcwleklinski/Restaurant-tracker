package com.wjcwleklinski.restauranttracker.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wjcwleklinski.restauranttracker.api.ZomatoApi;
import com.wjcwleklinski.restauranttracker.config.ApiConfig;
import com.wjcwleklinski.restauranttracker.retrofit.CityData;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
@Service
public class ZomatoService {

    private ZomatoApi zomatoApi;


    public ZomatoService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create(customGson()))
                .client(client)
                .build();

        zomatoApi = retrofit.create(ZomatoApi.class);
    }

    public CityData getCity(String city) throws IOException {
        Response<CityData> response= zomatoApi.getCity(city, ApiConfig.API_KEY).execute();

        return response.body();
    }

    private Gson customGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
