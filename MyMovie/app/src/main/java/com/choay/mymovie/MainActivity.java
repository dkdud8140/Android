package com.choay.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;


import com.choay.mymovie.model.MovieDTO;
import com.choay.mymovie.service.NaverApiService;
import com.choay.mymovie.service.NaverMovieServiceImplV1;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar main_toolbar = findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);

        recyclerView = findViewById((R.id.movie_list_view));
        NaverApiService naverMovieSer = new NaverMovieServiceImplV1(recyclerView);

        naverMovieSer.getNaverData("모가디슈");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);

        SearchView searchView =
                (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화명 검색");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                NaverApiService naverApiService =
                        new NaverMovieServiceImplV1(recyclerView);
                naverApiService.getNaverData(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {return false;}
        });
        return super.onCreateOptionsMenu(menu);
    }
}