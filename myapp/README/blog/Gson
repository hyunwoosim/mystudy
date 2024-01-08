# Gson
## 24.1.8

### Gson ,Json
1. GSON
  - Json 변환해주는 라이브러리이다.
  - java Object를 Json 문자열로 변환할 수 있고, Json 문자열을 Object로 변환할 수 있다.
  
2. 변환 방법
  - 1. 객체를 준비
    - ex) Member m = new Member();
  - 2. Json 처리 객체준비 
    - ex) Gson gson = new Gson();
  - 3. 객체의 값을 JSON 문자열로 얻기
    - ex) String jsonStr = gson.toJson(m)

3. GoF의 빌더 패턴 (복합 객체의 생성과정을 캡슐화)
  - 여러객체를 조립해서 만들어야할 경우 복잡한 생성과정을 감추기위해 빌더(외부객체)에 의뢰해서 객체를 얻는기법
  
  1. 빌더(외부객체)를 생성한다.
    - GsonBuiler builder = new GsonBuilder();
  2. 객체 생성에 필요한 옵션을 설정한다.
    - builder.setDateFormat("yyyy-MM-dd");    (month는 대문자 M으로 적는다.)
  3. 객체 생성
    - Gson gson = builder.creat();
  4. 리펙토링
    - Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

  - Adapter 각 변환시킬 데이터 타입에 맞는 어뎁터를 사용하여 쫌 더 편하게 변환시킨다.

# JSON
1. JSON 정의
  - 객체를 표현하는 방법이다.
  - 다양한 프로그래밍언에에서 데이터를 주고받기위해 사용된다.
  - XML등과 같은 데이터를 표현하는 방법

2. Gson 라이브러리 사용법
    - gradle로 사용한다면 build.gradle에 dependencies 안에 명령어를 적으면 된다.
    - 그 후  명령창에 gradle eclipes 명령어를 사용한다.

3. Json의 문법
  - 객체는 {} 증괄호
  - 배열은 [] 대괄호를 사용한다.
  - key dhk value 쌍으로 이루어져 있으면 : 콜른을 사용한다.
  - 속성이 여러개일 땐 , 쉼표로 구분한다.
  - Gson은 Gson 기본 생성자 혹은 GsonBuilder을 통해 이용한다.


4. toJson()
  - 객체를 직렬화 한다.
  - toJson()을 사용하여 원하는 타입의 배열을 호출하여 Json의 문자열을 생성한다.

5. fromJson()
  - fromJson(jsonString,000.class)
    - 메서드 안 첫번째에는 Json 구조의 String을 넘겨주고
    - 메서드 안 두번째에는 변환을 원하는 class를 넘겨주면 된다.  

6. TypeToken 
  - TypeToken클래스에는 Type 인터페이스의 구현체를 만드는 메서드가 있기때문에 사용한다.
  - 타입 파라미터에 컬렉션 타입을 전달하는 목적 이외에는 다른 이유가 없다.



  5. 사용하는 이유는?
  - 가독성이 좋다 파악하기 쉬운 구조이다.
  - Json의 형식만 지킨다면 어떤 시스템간이든 데이터 교환이 가능하다.