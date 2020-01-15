package com.wjcwleklinski.restauranttracker.service;

import com.wjcwleklinski.restauranttracker.api.ZomatoApi;
import com.wjcwleklinski.restauranttracker.config.ZomatoConfig;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.collections.CollectionsData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.Restaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.user_rating.UserRating;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

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

    public List<BestRatedRestaurant> getBestRatedRestaurantsByLatLon(Double latitude, Double longitude) {
        try {
            CityData cityData = getCityDataByLatLon(String.valueOf(latitude), String.valueOf(longitude));

            // get first suggestion
            int cityId = cityData.getLocationSuggestions().get(0).getId();

            LocationDetails locationDetails = getLocationDetailsById(String.valueOf(cityId));
            return locationDetails.getBestRatedRestaurant();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method called after post in controller.
     * Change output to Optional<>
     */
    public List<BestRatedRestaurant> getBestRatedRestaurantsByCityName(String cityName) {
        try {
            CityData cityData = getCityDataByName(cityName);
            int cityId = cityData.getLocationSuggestions().get(0).getId();
            LocationDetails ld = getLocationDetailsById(String.valueOf(cityId));
            return ld.getBestRatedRestaurant();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
