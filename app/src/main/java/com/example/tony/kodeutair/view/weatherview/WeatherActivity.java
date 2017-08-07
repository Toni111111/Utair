package com.example.tony.kodeutair.view.weatherview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.tony.kodeutair.R;
import com.example.tony.kodeutair.SlidingTabLayout;
import com.example.tony.kodeutair.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    int Numboftabs = 2;
    String cityThither;
    String cityBack;

    @BindView(R.id.tool_bar_weather)
    Toolbar toolbarWeather;
    @BindView(R.id.thither_city_toolbar)
    TextView thitherCityToolbarTv;
    @BindView(R.id.back_city_toolbar)
    TextView backCityToolbarTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);


        Intent intent = getIntent();

            if(intent!=null) {
                cityThither = intent.getStringExtra("cityThither");
                cityBack = intent.getStringExtra("cityBack");
            }


        toolbarWeather = (Toolbar) findViewById(R.id.tool_bar_weather);
        setSupportActionBar(toolbarWeather);
        thitherCityToolbarTv.setText(cityThither);
        backCityToolbarTv.setText(cityBack);


        String Titles[] = {"Туда", "Обратно"};
        String cityNames[] = {cityThither, cityBack};


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getFragmentManager(), Titles, Numboftabs, cityNames);
        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }


}


