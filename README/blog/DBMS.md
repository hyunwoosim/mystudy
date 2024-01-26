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
- DBMS는 API와 통신한다.
- DBMS는 만든 회사마다 API사용법이 다르다.
### API
- API는 vendor API(native API)라고 부른다.
- API는 C/C++로 만들어졌다.
- API 안에는 fuction(=method)가 들어 있다.
- API는 DBMS를 만든 회사에서 제공한다.

- 문제점 : API사용법이 다 다르기 때문에 프로그래밍에 일관성이 없다.

## ODBC API
- 문제점을 해결하기위해 나왔다.
- API의 설계 규칙이다.
- 호출 규칙이 동일하기 때문에 app을 한번만 작성하면된다.
- 이것도 C/C++로 만들어졌다.