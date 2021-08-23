package com.choay.mymovie.model;

import com.choay.mymovie.model.MovieDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NaverParents {

    private String rss;      //	-	디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너이며 그 외의 특별한 의미는 없다.
    private String channel;  //	-	검색 결과를 포함하는 컨테이너이다. 이 안에 있는 title, link, description 등의 항목은 참고용으로 무시해도 무방하다.
    private String lastBuildDate;//	datetime	검색 결과를 생성한 시간이다.
    //item/
    public List<MovieDTO> items;    //	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, image, subtitle, pubDate, director, actor, userRating을 포함한다.

    private String query;    //	string (필수)	Y	-	검색을 원하는 질의. UTF-8 인코딩이다.
    private String display;  //	integer	N	기본값 10, 최대 100	검색 결과 출력 건수를 지정한다. 최대 100까지 가능하다.
    private String start;    //	integer	N	기본값 1, 최대 1000	검색의 시작 위치를 지정할 수 있다. 최대 1000까지 가능하다.
    private String genre;    //	string	N	-	검색을 원하는 장르 코드를 의미한다. 영화 코드는 다음과 같다.

    private String country;  //	string	N	-	검색을 원하는 국가 코드를 의미한다. 국가코드는 대문자만 사용 가능하며,분류는 다음과 같다.

    private String yearfrom; //	integer(ex : 2000)	N	-	검색을 원하는 영화의 제작년도(최소)를 의미한다.
    //   yearfrom은 yearto와 함께 사용되어야 한다.
    private String yearto;   //	integer(ex : 2008)	N	-	검색을 원하는 영화의 제작년도(최대)를 의미한다

    @Override
    public String toString() {
        return "NaverParentDTO{" +
                "rss='" + rss + '\'' +
                ", channel='" + channel + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", items=" + items +
                ", query='" + query + '\'' +
                ", display='" + display + '\'' +
                ", start='" + start + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", yearfrom='" + yearfrom + '\'' +
                ", yearto='" + yearto + '\'' +
                '}';
    }
}