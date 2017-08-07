package com.example.tony.kodeutair.presenter.citiespresenter;

import com.example.tony.kodeutair.interactor.interactorcity.interactorcity.InteractorCity;
import com.example.tony.kodeutair.interactor.interactorcity.interactorcity.InteractorCityImpl;
import com.example.tony.kodeutair.model.modelcities.CityModel;
import com.example.tony.kodeutair.view.citiesview.SelectionCityView;

import java.util.ArrayList;


public class CityPresenterImpl implements CityPresenter {

    InteractorCity interactorCity;
    private SelectionCityView selectionCityView;

    public CityPresenterImpl(SelectionCityView selectionCityView) {
        this.selectionCityView = selectionCityView;
        this.interactorCity = new InteractorCityImpl();
    }


    @Override
    public void onSuccessCities(ArrayList<CityModel> cities, String whereCity) {
        selectionCityView.showCities(cities, whereCity);
    }

    @Override
    public void onValidate(String whereCity) {
        interactorCity.spendRequestCities("ru", this, whereCity);
    }


}
