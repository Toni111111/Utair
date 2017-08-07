package com.example.tony.kodeutair.network;


import com.example.tony.kodeutair.interactor.interactorcity.interactorcity.InteractorCityImpl;
import com.example.tony.kodeutair.interactor.interactorcity.intercatorweather.InteractorWeatherImpl;

import dagger.Component;

@Component(modules = {RetrofitModule.class})
public interface RetrofitComponent {

    void injectInteractorCity(InteractorCityImpl interactorCity);

    void injectInteractorWeather(InteractorWeatherImpl interactorWeather);
}
