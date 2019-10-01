package com.wjcwleklinski.restauranttracker.api;

import com.wjcwleklinski.restauranttracker.retrofit.resources.ifconfig.IfconfigData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IfconfigApi {

    @GET("json")
    Call<IfconfigData> getIfconfigData();
}
