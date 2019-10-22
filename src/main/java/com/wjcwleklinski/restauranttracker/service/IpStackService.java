package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.IpStackApi;
import com.wjcwleklinski.restauranttracker.config.IpStackConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class IpStackService {

    private IpStackApi ipStackApi;

    public IpStackService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IpStackConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ipStackApi = retrofit.create(IpStackApi.class);
    }

    public IpStackData getDataByIp(String ip) throws IOException {
        Response<IpStackData> response = ipStackApi.getDataByIp(ip, IpStackConfig.ACCESS_KEY).execute();
        return response.body();
    }
}
