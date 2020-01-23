package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.ZomatoApi;
import com.wjcwleklinski.restauranttracker.config.ZomatoConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.collections.CollectionsData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.user_rating.UserRating;
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


    //------------------------------------------------------------------------------------
    private ZomatoSearchResponse getZomatoResponseInRadiusFromLatLon(Map<String, String> queryMap) throws IOException {

        ZomatoSearchResponse response = zomatoApi.getRestaurantsInRadiusFromLatLon(queryMap).execute().body();
        return response;
    }

    public List<Restaurant> getRestaurantsInRadiusFromLatLon(String lat, String lon) {
        List<Restaurant> result = new ArrayList<>();
        Map<String, String> queryMap = new HashMap<>();

        queryMap.put("apikey", ZomatoConfig.API_KEY);
        queryMap.put("entity_type", ZomatoConfig.SEARCH_ENTITY_TYPE);
        queryMap.put("start", "0");
        queryMap.put("count", ZomatoConfig.SEARCH_COUNT);
        queryMap.put("lat", lat);
        queryMap.put("lon", lon);
        queryMap.put("radius", "30000");
        queryMap.put("sort", ZomatoConfig.SEARCH_SORT);
        queryMap.put("order", ZomatoConfig.SEARCH_ORDER);

        try {
            ZomatoSearchResponse response = getZomatoResponseInRadiusFromLatLon(queryMap);
            result = response.getRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  result;
    }
}
