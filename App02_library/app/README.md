# DataBinding Activity
* 기존의 Activity 에서 *.xml에 정의된 Component(view)를 사용하기 위해서는
각 View를 객체로 선언하고 findByViewId() 함수를 사용하여 객체와 Component를 연결하는 작업이 필요해다

* Rollipop(5.0)버전부터 findByViewId()를 사용하지 않고 Component를 사용할 수 있게 되었다.
이 때 도입돈 개념이 DataBinding이다

* 원래 DataBinding 개념은 View Component와 데이터를 연동하기 쉽도록 하기 위해서 도입되었다.
* 이 개념이 확장되면서 findByViewId()를 사용하지 않고 Component를 쓸 수 있도록 만들어졌다.
* 초기에 도입된 DataBinding과 현재(2021년) 사용하는 방법에는 다소 차이가 있다
만드는 방법, 프로젝트에 설정하는 방법에서 차이가 있지만 기본 개념은 같다

## app build.gradle에 속성 추가
* app build.gradle의 android 항목에 다음 속성을 추가한다.
    buildFeatures {
        viewBinding true
    }

* old Android에서는 *.xml 파일에 직접 binding하는 속성을 추가해야 한다.


# Fragment Activity
* 초기에 Android에서는 모든 화면을 Activity 단위로 만들고 사용을 했다.
* Activity는 만들고 화면에 보여지기까지 많은 resource(메인 메모리)를 사용한다.
* App에 보여주고자 하는 화면이 많으면 App 자체가 느려지거나 오류가 발생하는 경우가 점점 많아진다.
* 이런 문제들 때문에 Android에서는 Fragment라는 개념을 도입하게 된다.
* 여러개의 화면(UI)이 있는 App에서는 화면과 화면 사이에 빠른 전환이 이루어져야 하고
화면이 전환되는 과정에서 App에 오류가 발생하지 않아야 한다.
* 하지만 Activity는 이러한 문제를 해결하는데 많은 개발자의 노력이 필요했다.
* Android에서는 Fragment를 도입하여 작은 화면을 구현하고, 필요할 경우 바꿔가면서
보여주는 개념을 만들게 된 것이다.
* 사용자에게는 Activity인지 Fragment인지 관계없이 같은 방식으로 화면ㅇ르 전환 하지만
개발자(시스템적) 입장에서는 상당히 유리한 방법이 된다.
* 기존의 Activity 방식에 익숙한 개발자에게는 다소 생소한 개념이 되기도 하였다.

* Fragment를 한 마디로 정의하면 동적인 작은 Activity다 라고 할 수 있다.



# RetroFit을 사용한 Open API 핸들링
* openAPI를 사용하여 다른 서버에서 제공하는 데이터를 가져와 사용하는 경우  
데이터를 수신한 후 parsing하는 과정을 거치는데  
  여러 툴이 있지만 그 중 안드로이드에서 많이 사용하는 툴(라이브러리)이다
  
* 수신되는 데이터 구조에 맞는 VO(DTO)를 만들고, 데이터를 수신한 후 자동으로 Mapping을 할 수 있다
* 데이터 수신한 후에 GSON 라이브러리를 사용하여 내부에서 자동 pasing이 이루어진다.

* Retrofit을 사용하기 위하여 다음의 두가지 Dpendency를 설정한다
  
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
  
* API 요청과 Mapping을 하기 위한 interface를 선언해주어야한다.

