package com.example.tony.kodeutair;

import com.example.tony.kodeutair.model.modelcities.CitiesModel;
import com.example.tony.kodeutair.model.modelweather.WeatherCities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tony on 31/07/17.
 */

public interface API {

    @GET("cities.json")
    Call<CitiesModel> getModelCity(@Query("country") String state,
                                   @Query("key") String key);

    @GET("forecast")
    Call<WeatherCities> getWeatherCities(@Query("q") String country,
                                         @Query("appid") String appId);


}
