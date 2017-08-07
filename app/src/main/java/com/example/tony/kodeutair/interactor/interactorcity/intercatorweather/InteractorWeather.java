package com.example.tony.kodeutair.interactor.interactorcity.intercatorweather;

import com.example.tony.kodeutair.presenter.presenterweather.WeatherPresenter;

/**
 * Created by tony on 6/08/17.
 */

public interface InteractorWeather {
    void spendRequestWeatherCities(String city, WeatherPresenter weatherPresenter);
}
