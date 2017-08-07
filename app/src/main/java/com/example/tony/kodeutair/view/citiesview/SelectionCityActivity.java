package com.example.tony.kodeutair.view.citiesview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.tony.kodeutair.R;
import com.example.tony.kodeutair.adapters.citiesadapter.CitiesAdapter;
import com.example.tony.kodeutair.adapters.citiesadapter.SearchCitiesAdapter;
import com.example.tony.kodeutair.model.modelcities.CityModel;
import com.example.tony.kodeutair.presenter.citiespresenter.CityPresenter;
import com.example.tony.kodeutair.presenter.citiespresenter.CityPresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectionCityActivity extends AppCompatActivity implements SelectionCityView {

    @BindView(R.id.recycler_view_cities)
    RecyclerView recyclerViewCities;
    @BindView(R.id.edit_text_toolbar)
    EditText editTextToolbar;
    ArrayList<CityModel> citiesNames = new ArrayList<>();
    private String whereCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_city);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar_selection);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null) {
            whereCity = intent.getStringExtra("whereCity");
        }


        CityPresenter cityPresenter = new CityPresenterImpl(this);


        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewCities.setHasFixedSize(true);

        recyclerViewCities.setLayoutManager(linearLayoutManager);

        cityPresenter.onValidate(whereCity);


        textWatcherListner(editTextToolbar);


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showCities(ArrayList<CityModel> cities, String whereCity) {
        recyclerViewCities.setAdapter(new CitiesAdapter(this, cities, whereCity));
        addCityInArrayList(cities);
    }


    public void searchCity(String city) {

        ArrayList<String> oldCities = new ArrayList<>();

        for (int i = 0; i < citiesNames.size(); i++) {

            if (citiesNames.get(i).getCity().toLowerCase().contains(city.toLowerCase()) == false) {
            } else {
                oldCities.add(citiesNames.get(i).getCity());
            }
            recyclerViewCities.setAdapter(new SearchCitiesAdapter(this, oldCities, whereCity));


        }

    }

    public void addCityInArrayList(ArrayList<CityModel> cityModelArrayList) {
        for (CityModel cityModel : cityModelArrayList
                ) {
            citiesNames.add(cityModel);
        }

    }

    @Override
    public void textWatcherListner(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchCity(s.toString());
            }
        });
    }


}
