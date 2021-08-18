package com.choay.movie;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.choay.movie.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        /*
        content_view.xml애 설정된 fragment view를 NavController로 등록하여
        fragment간의 이동을 쉽게 하곘다.
         */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        
        // 뒤로가기 버튼 등이 있을 떄 처러리르 쉽게 하기 위한 설정
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
    Action Bar에 메뉴 등을 표현하기 위해 작성되는 코드
    res/menu/menu_main.xml 파일을 읽어서
    ActionBar에 메뉴를 그리는 코드가 작성된다.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*
        액션바에 구현된 검색창을 활성화 하기 위한 코드
        android.widget.SearchView를 
         */
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search);
        
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화명 검색");

        // 검색창이 활성화괴었을 때 실해오디는 event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //키보드의 검색 버튼 클릭
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("검색어 : ",s);

                /*
                검색창에 입력한 검색어를 SecondFragment에게 보내고
                SecondFragment에서는 전달 받은 검색어를 사용하여
                Naver Open API 영화 검색을 수행하여
                RecyclerView에 표시하기기
                */

                if( !s.isEmpty() ) {

                }



                return false;
            }

            //
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            /*
            MainActivity에 firstFragment가 열린 상태에서
            Action Bar의 Settings 메뉴를 클릭하면
            firstFragment가 있던 공간에
            SettingsFragment를 보여주기

            1. content_main.xml의 fragment view를 NavController로 설정하고
            2. navController에 navigatemfㄹ 실행하는데 그 떄
                navGraph.xml에서 설정된 action을 사용하여 실행한다.

             */
            NavController controller =
            Navigation.findNavController(MainActivity.this,
                    R.id.nav_host_fragment_content_main);

            controller.navigate(R.id.action_FirstFragment_to_SettingsFragment);

            Toast.makeText(MainActivity.this, "설정메뉴클릭",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    안드로이드의 물리적 버튼 
    뒤로 가기, 위로 가기, 어플 종료, 어플리스트 보기 등의 기능을
    수행하는 event 핸들러

    안드로이드 Up 버튼을 눌렀을 때
    Navigation에 설정된 대로 뒤로가기를 수행하다가
    가장 먼저 열린 화면에 도달했을 때 up 버튼을 누르면 어플을 종료하는 코드가 자동 실행된다.
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}