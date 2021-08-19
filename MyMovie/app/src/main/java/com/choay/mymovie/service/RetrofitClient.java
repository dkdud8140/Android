package com.choay.mymovie.service;

import com.choay.mymovie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit getInstance() {
        return new Retrofit.Builder().baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NaverRetrofit getApiClient() {
        return  getInstance().create(NaverRetrofit.class);
    }

}
