package com.choay.library.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.choay.library.adapter.BookViewAdapter;
import com.choay.library.config.NaverAPI;
import com.choay.library.model.NaverBookDTO;
import com.choay.library.model.NaverParent;
import com.choay.library.service.NaverBookService;
import com.choay.library.service.RetrofitAPIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverBookServiceImplV1 implements NaverBookService {

    protected RecyclerView recyclerView;
    public NaverBookServiceImplV1( RecyclerView recyclerView) {
        this.recyclerView = recyclerView ;
    }

    public NaverBookDTO getBooks(String search){

        /**
         1. Retrofit을 사용하여 네이버에서 데이터 가져오기
            RetrofitAPIClient의 getApiClient() method는
            Retrofit interface에 선언된 method를 동반한다
            동반된 method( getBook() ) 를 호출하면서
            필요한 매개변수를 전달하면
            Retrofit은 naver server에 요청을 하고 그 요청을
            "비동기 방식"으로 기다리게 된다.

         2. 비동기 방식
            호출하는 곳과 응답을 처리하느 곳이 다르다
            호출하는 곳에서는 호출만 하고 즉시, 자신의 다른 일을 수행하는 것을 계속한다.
            응답이 오면 그 응답을 처리할 CallBack을 적절히 처리해 주어야 한다.

            == event 핸들링 처리

         3. 동기 방식
            어떤 요청을 호출하고, 결과를 마냥 기다리가
            결과가 오면 변수에 담고 이후에 처리하는 코드가 수행된다.
         */
        Call<NaverParent> retrofitReturn = 
                RetrofitAPIClient.getApiClient()
                        .getBook(NaverAPI.CLIENET_ID, NaverAPI.CLIENET_SECRET,
                                search, 1, 10);

        /*
        Retofit의 요청을 받은 Naver가 데이터를 보내면
        Retrofit이 응답을 받아서 처리할 event(call back)
        
        Call Back Event 핸들링 코드
        Call Back interface 익명 클래스로 선언하는 코드
            Skeletone Code
         */
        retrofitReturn.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                
                // 응답을 받았을 때 Http Code가 무엇인지 확인하기위하여
                // Http response code를 가져오기
                int resCode = response.code();
                
                if(resCode < 300) {
                    Log.d("네이버 응답 데이터 : ", response.body().toString());

                    // 네이버에서 수신한 전체 데이터
                    NaverParent naverParent = response.body();

                    // 네이버에서 수신한 전체 데이터에서 도서 리스트 정보만 추출하기
                    List<NaverBookDTO> bookList = naverParent.items;

                    // 도서 리스트를 사용하여 RecyclerView에 데이터를 표현하기 위한 Adapter를 생성하기
                    BookViewAdapter bookViewAdapter = new BookViewAdapter(bookList);

                    // MainActivity에서 전달받은 recyclerView에 Adapter를 setting
                    recyclerView.setAdapter(bookViewAdapter);

                    // 화면에 데이터들을 표현하는데 리스트를 관리할
                    // Layout Manager를 설정하기
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);


                } else {
                    Log.d("오류 발생 : ", response.toString());
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

        return null ;
        
    }

}
