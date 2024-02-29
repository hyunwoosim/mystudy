# JSP

## JSP생성과정
- JSP는 직접 실행되는게 아니다. 
- JSP 엔진에 의해 컴파일되어 자바 서블리스 소스가 만들어지고
- 자바 컴파일러가 컴파일하여 자바 클래스가 만들어져 실행되는것이다

## Servlet과 JSP 역할

## Servlet 
1. 입력 데이터를 작업하기 적합하게 가공
2. 모델 객체를 통해 요청한 작업을 처리
3. JSP가 출력하기 적합하게 작업한 데이터를 가공
4. 클라이언트로 보낼 화면을 만들 JSP를 실행

## JSP
1. Servlet이 준비한 데이터를 가지고 화면을 만든다.(HTML,CSS,Java Script등)

## JSP 태그
### directive element
1. <%@ page --- %> : JSP 페이지 설정
2. <%@ indude --- %> : 다른 파일의 콘텐트를 삽입
3. <%@ taglib --- %> : 외부 태그 가져오기

### scriptlet
1. <% 자바 코드%> : 서블릿 클래스에 삽입할 코드

### expression element
1. <%= 표현식 %> : 표현식의 리턴값을 출력

### declaration element
1. <%! 필드 및 메서드 %> : 서블릿 클래스에 필드 및 메서드 삽입

### JSP action tag
1.<jsp:xxx ----/> : 특정 자바 코드 삽입

# EL (Expression Language)
## ${객체.프로퍼티.프로퍼티...}
- 프로퍼티 부분은 OGNL표기법을 이용하여 값을 다룬다.
- 값을 표현하는 문법으로 JSP의 기본 문법을 보완하는 역할을 한다.

##  OGNL
- Object Graph Navigation Language

## JSTL (JSP Standard Tag Libray)
- JSP 확장 태그
- JSP의 표준 라이브러리이다.
- JSP에서 (반복과 조건, 데이타 관리 포맷, XML 조작, 데이타베이스 액세스)을 구현하는 커스텀 태그 라이브러리 모음이다.
-  시간, 날짜, 숫자의 포맷이나 문자열 가공등의 처리에서 비즈니스로직과 프리젠테이션 로직을 분리할 수 있게 해준다.
- EL을 사용하여 표현한다.