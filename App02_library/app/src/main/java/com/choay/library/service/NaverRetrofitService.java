package com.choay.library.service;

import com.choay.library.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetrofitService {

    /*
    Retrofit을 사용할 때 URL 정의
    만약 URL이 http://naver.com/aaa/bbb/ccc/book.json 형태로 되어 있을 떄
    URL의 끝의 end point인 book.json은 @GET("book.json")으로 설정한다

    RetroService에서 Instance를 만들 때 사용한 코드
            Retrofit.Build().baseUrl() 부분에 매개변수로
            htpp://naver.com/aaa/bbb/ccc/ 를 전달해준다
            
    실제 Connection 객체를 만들 때
    baseUrl과 @Get()에 설정된 EndPoint를 합성하여
    htpp://naver.com/aaa/bbb/ccc/book.json와 같은 URL을 생성하게 된다
    
    또한 @Query("query") 설정된 부분이 있으면
    ?query=변수값 형식으로 queryString을 생성한다
    /book.json?query=자바 형식으로 최종 queryString이 생성된다

    @Header()로 선언된 부분은 http protocol의 header에 정보를 실어서 보낼 때 사용한다.
     */

    // Retrofit을 사용하여 GET method를 OpenAPI에 접속하라
    @GET("book.json")
    Call<NaverParent>  getNaverBook(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String clientSecret,
            @Query("query") String query
//            @Query("display") int display,
//            @Query("start") int start

    );
    // 최종 생성되는 queryString
    // book.json?query=자바&display=10&start=1
}
