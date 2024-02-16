# 웹 에플리케이션 서버 아키텍쳐

## 톰캣 서버
- WebServer 와 Servlet container로 나뉜다.

### webServer
- 정적 자원 서비스이다.
  - 정적자원이란? -요청에 대한 응답결과가 항상 같다.
  - Ex) 웹사이트의 로고(Naver,Daum), HTML형식
- HTTP에서 요청을 받아 Servle Container에 요청을 위임하여 
- 결과를 HTTP에 응답하는 역할을 한다.

### Servlet Container
- 동적 자원 서비스이다.
  - 서비스할 때 마다 결과가 달라질 수 있다.
  - Ex) 실시간으로 변하는 뉴스 로고, 일기예보, 유트븡실시간 업로드
- web Server의 요청을 위임받아 JavaApp을 관리(생성, 실행, 소멸)하여 결과를 받는다.

### Servlet?
  - serverApp + let(작은것)
  - 작은 서버 app
  - 서버의 작은 기능dmf EMtgksek.
  - Ex) 인사관리시스템의 (직원등록, 휴가신청, 퇴사, 급여관리) 

### <interface>Servlet
- 인터페이스 서블릿을 만들어 사용한다.
  * init() <<== 객체 생성 후 호출됨 (생성)
  * service() <<== 요청이 들어올때 마다 (실행)
  * destory()  <<== app을 종료할때 (소멸)

- 인터페이스를 구현하는 클래스는 사용에 맞게 재정의 하고
- **@Webservlet(경로)**를 반드시 지정해야한다.
  * 클라이언트가 서블릿 실행을 위해 요청할때 사용할 경로이기 때문이다.