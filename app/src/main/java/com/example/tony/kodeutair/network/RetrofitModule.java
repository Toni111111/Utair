package com.example.tony.kodeutair.network;

import dagger.Module;
import dagger.Provides;


@Module
public class RetrofitModule {
    @Provides
    public MyRetrofit getRetrofit() {
        return new MyRetrofit();
    }
}
