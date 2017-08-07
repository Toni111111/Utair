package com.example.tony.kodeutair.presenter.citiespresenter;

import com.example.tony.kodeutair.model.modelcities.CityModel;

import java.util.ArrayList;

/**
 * Created by tony on 1/08/17.
 */

public interface CityPresenter {

    void onSuccessCities(ArrayList<CityModel> cities, String whereCity);

    void onValidate(String whereCity);
}
