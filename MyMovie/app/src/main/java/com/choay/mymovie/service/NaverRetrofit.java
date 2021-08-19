package com.choay.mymovie.service;

import com.choay.mymovie.model.NaverParents;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface NaverRetrofit {

    @GET("movie.json")
    public Call<NaverParents> getMovie(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Header("query") String query,
            @Header("start") int start,
            @Header("display") int display
    );

}
