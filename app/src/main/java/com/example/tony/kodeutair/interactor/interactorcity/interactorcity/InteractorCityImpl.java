package com.example.tony.kodeutair.interactor.interactorcity.interactorcity;

import android.util.Log;

import com.example.tony.kodeutair.Constant;
import com.example.tony.kodeutair.CustomApplication;
import com.example.tony.kodeutair.model.modelcities.CitiesModel;
import com.example.tony.kodeutair.model.modelcities.CityModel;
import com.example.tony.kodeutair.network.MyRetrofit;
import com.example.tony.kodeutair.presenter.citiespresenter.CityPresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InteractorCityImpl implements InteractorCity {

    ArrayList<CityModel> cities = new ArrayList<>();

    @Inject
    MyRetrofit retrofit;


    @Override
    public void spendRequestCities(String country, final CityPresenter cityPresenter, final String whereCity) {
        CustomApplication.getRetrofitComponent().injectInteractorCity(this);


        retrofit.getApi("https://api.meetup.com/").getModelCity(country, Constant.API_KEY_CITIES).enqueue(new Callback<CitiesModel>() {
            @Override
            public void onResponse(Call<CitiesModel> call, Response<CitiesModel> response) {
                for (CityModel cityModel : response.body().getCities()
                        ) {
                    cities.add(cityModel);
                }
                cityPresenter.onSuccessCities(cities, whereCity);
            }

            @Override
            public void onFailure(Call<CitiesModel> call, Throwable t) {
                Log.d("NotResponse", t.toString());

            }
        });

    }
}



