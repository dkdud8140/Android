package com.choay.library.service;

import com.choay.library.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Retrogfit 을 사용하여 API 접속을 할 떄
 * 최종 end point, header값, method type, parameter 등을
 * 설정하는 인터페이스
 */
public interface NaverRetrofit {

    /**
     * method의 return 타입을 void 형식이 아닌
     * Call 클래스 타입으로 설정
     * */
    // 1. 가장 기본 타입 아무것도 할 수 없다
    public Call getBook();

    /**
     *  2. Naver open API를 사용하기 위해서는
     *  반드시 header에 Client ID 와 CLIENT SECRET 값을 전달해주어야한다
     *
     *  header에 Clent ID와 CLENT SECRET을 전달해주기 위해서
     *   가. 메소드의 매개변수에 해당 속성을 지정해준다
     *   나. @Header() 어노테이션을 부착
     *   다. @Header() 어노테이션 헤더의 이름을 지정한다
     *          X-Naver-Client-Id = asdfasdf형식으로
     *
     *  3. methodㅇ에 end point와 요청 메소드 타입을 지정한다
     *      @GET, @POST, @PUT, @DELETE
     *
     *  4. open API를 통해 데이터를 요청할 때
     *      값 또는 변수 등을 보내고 싶을 때
     *      queryString을 만드는데
     *      여기에서는 @Query()를 사용하여 지정한다
     *  
     *  5. return type인 Call 클래스에
     *      data를 mapping할 DTO(VO) 클래스를
     *      Generic으로 설정해준다
     */
    @GET("book.json")
    public Call<NaverParent> getBook(@Header("X-Naver-Client-Id") String clientId,
                                     @Header("X-Naver-Client-Secret") String clientSecret,
                                     @Query("query") String query,
                                     @Query("start") int start,
                                     @Query("display") int display);

}
