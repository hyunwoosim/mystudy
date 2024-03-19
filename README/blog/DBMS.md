# 데이터베이스

## DBMS(DataBase Management System)
- 데이터 저장소를 관리하는게 DBMS이다.
- DBMS의 하는 일은 
  * 데이터 정의
  * 업데이트
  * 검색
  * 관리 : 사용자 등록/모니터링, 데이터 보안, 성능 모니터링, 무결성 유지,   
  동시성 제어, 오류제어

- DataBase 
  * 데이터 모음(저장소)이다

- 오버헤드
 * 쓸데없이 데이터를 주고 받는 것

## DBMS API
- DBMS는 DBMS전용API와 통신한다.
- DBMS는 만든 회사마다 API사용법이 다르다.

### API
- API는 DBMS전용 프로토콜이다. 규칙이다. 
- API안에는 function(=method)가 들어가 있다.
- API는 vendor API(native API)라고 부른다.
- API는 C/C++로 만들어졌다.
- API 안에는 fuction(=method)가 들어 있다.
- API는 DBMS를 만든 회사에서 제공한다.

- 문제점 : API사용법이 다 다르기 때문에 프로그래밍에 일관성이 없다.   
          따로 작성해야하기 때문에 개발비가 증가한다.

## ODBC API
- 문제점을 해결하기위해 나왔다.
- API의 설계 규칙이다.
- 호출 규칙이 동일하기 때문에 app을 한번만 작성하면된다.
- 이것도 C/C++로 만들어졌다.

## Java - DBMS와 통신
- 자바는 JDBC Driver를 통해 DBMS와 통신한다.

### Type 1
- ODBC- JDBC Bridge
- JRE에 기본 포함되어있다.
- Local에 설치된 ODBC드라이버를 사용한다.
- 실행 속도가 느리다.

### Type 2
- Native API를 call 한다.
- Vendor 에서 다운로드 해야함
- Local에 설치된 Native API를 사용한다.
- Type1보다 속도가 빠르다.

### Type 4
- native 드라이버
- vendor 에서 다운로드 해야한다.
- Local c/c++ API설치 불필요
- 순수 자바 드라이버(pure Java)
- DBMS를 교체하면 로컬에 설치된 JDBC도 교체해야한다.(Type2,4모두 해당)

### Type 3
- 네트워크 드라이버
- 3rd-party에 다운로드
- 미들웨어 서버 구매비용 발생
- 특정 DBMS에 종속안됨
- DBMS교체 ===> 미들웨어 서버측만 JDBC드라이버 파일만 교체하면 된다


## JDBC API 프로그래밍
1. JDBC 드라이버준비 java.sql.Driver구현체를 생성하여   
DriverManager에 등록한다.   
("ServiceProvider" 명세에 따라 JDBC Driver파일에 들어있는 설정대로 객체를 자동으로 생성하고 등록한다. 생략!)
  - Driver driver =new com.mysql.jdbc.Driver();
  - DriverManager.registerDriver(Driver)

2. DriverManager를 통해 DBMS 연결을 요청
  - Connection con = DriverManager.getConnection(...);

3. SQL을 DBMS에 전달해줄 객체를 준비한다.
  - Statement stml = con.creatStatement();

4. SQL을 DBMS에 전달
  - Resultset rs = stmt.executeQuery(SQL문);

5. select 실행결과 데이터중 한개의 데이터를 서버에서 가져오기
  - 한개의 데이터 = record(=row =tuple)
  - rs.next();

6. 서버에서 가져온 레코드에서 컬럼 값 꺼내기
  - rs.getString(컬럼이름 또는 컬럼 번호);
  - rs.getInt(컬럼이름 또는 컬럼 번호); 

## CRUD
 - Creat            = insert
 - Retrieve(=Read)  = select
 - Update           = update
 - Delete           = delete