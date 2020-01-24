package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.ZomatoApi;
import com.wjcwleklinski.restauranttracker.config.ZomatoConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.Restaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.ZomatoSearchResponse;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.*;

@Service
public class ZomatoService {

    private ZomatoApi zomatoApi;

    public ZomatoService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ZomatoConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        zomatoApi = retrofit.create(ZomatoApi.class);
    }


    private ZomatoSearchResponse getZomatoResponseInRadiusFromLatLon(Map<String, String> queryMap) throws IOException {

        return zomatoApi.getRestaurantsInRadiusFromLatLon(queryMap).execute().body();
    }

    public Optional<List<Restaurant>> getRestaurantsInRadiusFromLatLon(String lat, String lon, String start) {

        Optional<List<Restaurant>> result = Optional.empty();
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("apikey", ZomatoConfig.API_KEY);
        queryMap.put("entity_type", ZomatoConfig.SEARCH_ENTITY_TYPE);
        queryMap.put("start", start);
        queryMap.put("count", ZomatoConfig.SEARCH_COUNT);
        queryMap.put("lat", lat);
        queryMap.put("lon", lon);
        queryMap.put("radius", "30000");
        queryMap.put("sort", ZomatoConfig.SEARCH_SORT);
        queryMap.put("order", ZomatoConfig.SEARCH_ORDER);

        try {
            ZomatoSearchResponse response = getZomatoResponseInRadiusFromLatLon(queryMap);
            result = Optional.ofNullable(response.getRestaurants());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  result;
    }
}
