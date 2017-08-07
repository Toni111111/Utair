package com.example.tony.kodeutair.presenter.presenterweather;

import com.example.tony.kodeutair.model.modelweather.WeatherCities;

/**
 * Created by tony on 6/08/17.
 */

public interface WeatherPresenter {
    void onSuccessCities(WeatherCities weatherCities);

    void onValidateWeather(String city);


}
