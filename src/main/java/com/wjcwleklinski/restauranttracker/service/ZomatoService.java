package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.ZomatoApi;
import com.wjcwleklinski.restauranttracker.config.ZomatoConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.collections.CollectionsData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
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
                .baseUrl(ZomatoConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        zomatoApi = retrofit.create(ZomatoApi.class);
    }

    public CityData getCityDataByName(String city) throws IOException {

        Response<CityData> response= zomatoApi.getCityDataByName(city, ZomatoConfig.API_KEY).execute();
        return response.body();
    }

    public CityData getCityDataByLatLon(String lat, String lon) throws IOException{

        Response<CityData> response = zomatoApi.getCityDataByLatLon(lat, lon, ZomatoConfig.API_KEY).execute();
        return response.body();
    }

    public LocationDetails getLocationDetailsById(String entityId) throws IOException{

        Response<LocationDetails> response = zomatoApi
                .getLocationDetailsById(entityId, ZomatoConfig.ENTITY_TYPE, ZomatoConfig.API_KEY)
                .execute();

        return response.body();
    }

    public CollectionsData getCollectionsDataById(String cityId) throws IOException{

        Response<CollectionsData> response = zomatoApi.getCollectionsDataByID(cityId, ZomatoConfig.API_KEY).execute();
        return response.body();
    }
}
