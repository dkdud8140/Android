package com.choay.mymovie.service;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.mymovie.adapter.NaverAdapter;
import com.choay.mymovie.config.NaverAPI;
import com.choay.mymovie.model.MovieDTO;
import com.choay.mymovie.model.NaverParents;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverApiService{

    private RecyclerView recyclerView ;
    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView ;
    }

    public MovieDTO getNaverData(String search) {

        Log.d("Naver","접속완료");
        Call<NaverParents> retrofitReturn = RetrofitClient.getApiClient().getMovie(
                NaverAPI.NAVER_CLIENT_ID, NaverAPI.NAVER_CLIENT_SECRET,search, 1, 10);
        retrofitReturn.enqueue(new Callback<NaverParents>() {
            @Override
            public void onResponse(Call<NaverParents> call, Response<NaverParents> response) {
                int resCode = response.code();

                if( resCode < 300 ) {
                    Log.d("Response Data : ",response.body().toString());

                    NaverParents naverParents = response.body();
                    List<MovieDTO> movieList = naverParents.items;
                    NaverAdapter movieAdapter = new NaverAdapter(movieList);
                    recyclerView.setAdapter(movieAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                } else {
                    Log.d("오류 발생:", response.toString());
                }
            }
            @Override
            public void onFailure(Call<NaverParents> call, Throwable t) {}
        });
        return null;
    }


}
