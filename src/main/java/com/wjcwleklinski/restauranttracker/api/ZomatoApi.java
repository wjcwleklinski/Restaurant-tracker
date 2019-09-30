package com.wjcwleklinski.restauranttracker.api;

import com.wjcwleklinski.restauranttracker.retrofit.CityData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ZomatoApi {

    @GET("cities")
    Call<CityData> getCity(@Query("q") String city, @Query("apikey") String apikey);


}
