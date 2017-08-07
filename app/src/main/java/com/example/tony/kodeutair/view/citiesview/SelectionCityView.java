package com.example.tony.kodeutair.view.citiesview;

import android.widget.EditText;

import com.example.tony.kodeutair.model.modelcities.CityModel;

import java.util.ArrayList;

/**
 * Created by tony on 31/07/17.
 */

public interface SelectionCityView {

    void showProgress();

    void showCities(ArrayList<CityModel> cities, String whereCity);

    void textWatcherListner(EditText editText);
}
