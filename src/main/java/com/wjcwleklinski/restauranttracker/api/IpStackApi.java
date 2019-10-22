package com.wjcwleklinski.restauranttracker.api;

import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IpStackApi {

    @GET("{ip}")
    Call<IpStackData> getDataByIp(@Path("ip") String ip, @Query("access_key") String accessKey);
}
