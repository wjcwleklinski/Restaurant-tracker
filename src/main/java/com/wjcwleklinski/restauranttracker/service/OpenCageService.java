package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.OpenCageApi;
import com.wjcwleklinski.restauranttracker.config.OpenCageConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.opencage.Geometry;
import com.wjcwleklinski.restauranttracker.retrofit.resources.opencage.OpenCageResponse;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class OpenCageService {

    private OpenCageApi openCageApi;

    public OpenCageService() {
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OpenCageConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        openCageApi = retrofit.create(OpenCageApi.class);
    }

    private OpenCageResponse getAllDataFromApi(String cityName) throws IOException {

        Response<OpenCageResponse> response = openCageApi.getAllDataFromApi(OpenCageConfig.API_KEY,
                cityName,
                OpenCageConfig.LIMIT,
                OpenCageConfig.NO_ANNOTATIONS
        ).execute();

        return response.body();
    }

    public String getLatLongByCityName(String cityName) {
        String result = "";
        try {
            OpenCageResponse response = getAllDataFromApi(cityName);
            Geometry geometryLocation = response.getResults().get(0).getGeometry();
            result = geometryLocation.getLat() + ", " + geometryLocation.getLng();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
