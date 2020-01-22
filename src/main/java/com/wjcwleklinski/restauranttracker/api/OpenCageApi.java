package com.wjcwleklinski.restauranttracker.api;

import com.wjcwleklinski.restauranttracker.retrofit.resources.opencage.OpenCageResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OpenCageApi {

    @GET("json")
    Call<OpenCageResponse> getAllDataFromApi(@Query("key") String key,
                                             @Query("q") String cityName,
                                             @Query("limit") String limit,
                                             @Query("no_annotations") String noAnnotations);
}
