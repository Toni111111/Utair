package com.example.tony.kodeutair;

import android.app.Application;

import com.example.tony.kodeutair.network.DaggerRetrofitComponent;
import com.example.tony.kodeutair.network.RetrofitComponent;


public class CustomApplication extends Application {
    private static RetrofitComponent retrofitComponent;

    public static RetrofitComponent getRetrofitComponent() {
        return retrofitComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitComponent = DaggerRetrofitComponent.create(); // это   RetrofitComponent


    }
}
