package com.wjcwleklinski.restauranttracker.api;

import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.collections.CollectionsData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.ZomatoSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ZomatoApi {

    @GET("cities")
    Call<CityData> getCityDataByName(@Query("q") String city, @Query("apikey") String apikey);

    @GET("cities")
    Call<CityData> getCityDataByLatLon(@Query("lat") String lat, @Query("lon") String lon, @Query("apikey") String apikey);

    @GET("location_details")
    Call<LocationDetails> getLocationDetailsById(@Query("entity_id") String entityId, @Query("entity_type") String entityType, @Query("apikey") String apikey);

    @GET("collections")
    Call<CollectionsData> getCollectionsDataByID(@Query("city_id") String cityId, @Query("apikey") String apikey);

    @GET("collections")
    Call<CollectionsData> getCollectionsDataByLatLon(@Query("lat") String lat, @Query("lon") String lon, @Query("apikey") String apikey);

    //--------------------------------------------
    @GET("search")
    Call<ZomatoSearchResponse> getRestaurantsInRadiusFromLatLon(@Query("apikey") String apikey,
                                                                @Query("entity_type") String entityType,
                                                                @Query("start") String start,
                                                                @Query("count") String count,
                                                                @Query("lat") String lat,
                                                                @Query("lon") String lon,
                                                                @Query("radius") String radius,
                                                                @Query("sort") String sort,
                                                                @Query("order") String order);

    @GET("search")
    Call<ZomatoSearchResponse> getRestaurantsInRadiusFromLatLon(@QueryMap Map<String, String> queryMap);
}
