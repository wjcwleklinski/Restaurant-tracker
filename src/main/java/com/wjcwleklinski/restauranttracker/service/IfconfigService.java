package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.IfconfigApi;
import com.wjcwleklinski.restauranttracker.config.IfconfigConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.ifconfig.IfconfigData;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class IfconfigService {

    IfconfigApi api;

    public IfconfigService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IfconfigConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(IfconfigApi.class);
    }

    public IfconfigData getIfconfigData() throws IOException {
        Response<IfconfigData> response = api.getIfconfigData().execute();
        return response.body();
    }
}
