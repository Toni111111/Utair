package com.example.tony.kodeutair.network;

import com.example.tony.kodeutair.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    private static API api;
    private Retrofit retrofit;
    private String url;


    private void setupClient(String url) {

        retrofit = new Retrofit.Builder()
                .baseUrl(url) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(API.class); //Создаем объект, при помощи которого будем выполнять запросы

    }

    public API getApi(String url) {
            setupClient(url);
        return api;
    }
}
