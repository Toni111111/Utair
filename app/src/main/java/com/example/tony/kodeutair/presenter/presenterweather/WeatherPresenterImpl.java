package com.example.tony.kodeutair.presenter.presenterweather;

import com.example.tony.kodeutair.interactor.interactorcity.intercatorweather.InteractorWeather;
import com.example.tony.kodeutair.interactor.interactorcity.intercatorweather.InteractorWeatherImpl;
import com.example.tony.kodeutair.model.modelweather.WeatherCities;
import com.example.tony.kodeutair.view.weatherview.WeatherCityOneFragment;

/**
 * Created by tony on 6/08/17.
 */

public class WeatherPresenterImpl implements WeatherPresenter {
    InteractorWeather interactorWeather;
    WeatherCityOneFragment weatherCityOneFragment;


    public WeatherPresenterImpl(WeatherCityOneFragment weatherCityOneFragment) {
        this.interactorWeather = new InteractorWeatherImpl();
        this.weatherCityOneFragment = weatherCityOneFragment;

    }

    @Override
    public void onSuccessCities(WeatherCities weatherCities) {
        if (weatherCities != null) {
            weatherCityOneFragment.showWeather(weatherCities);
        }
    }

    @Override
    public void onValidateWeather(String city) {
        interactorWeather.spendRequestWeatherCities(city, this);
    }
}
