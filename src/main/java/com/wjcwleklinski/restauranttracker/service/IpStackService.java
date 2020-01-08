package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.IpStackApi;
import com.wjcwleklinski.restauranttracker.config.IpStackConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class IpStackService {

    private IpStackApi ipStackApi;


    @Autowired
    private Logger logger;

    public IpStackService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IpStackConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ipStackApi = retrofit.create(IpStackApi.class);
    }

    /**
     * Synchronous method
     * @param ip
     * @return
     * @throws IOException
     */
    public IpStackData getIpStackDataByIp(String ip){

        Call<IpStackData> call = ipStackApi.getDataByIp(ip, IpStackConfig.ACCESS_KEY);
        try {
            IpStackData ipStackData = call.execute().body();
            return ipStackData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }






}
