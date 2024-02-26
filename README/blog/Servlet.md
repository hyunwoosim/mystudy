# 서블릿

## 클라이언트로 출력하기
- 출력할 때 사용할 문자표(charset)를 지정하지않으면
- 기본 문자표 ISO-8859-1을 리턴한다.
- 자바 유니코드를문자를 ISO-8859-1로 변환하여 출력된다.
- 한글은 ISO-8859-1 문자표에 없기 때문에 '?'로 출력된다.

- 해결방법
  - 출력 스트림 사용전에 문자표(charset)를 지정하라
  - !! 반드시 출력 스트림을 얻기 전에 설정해야한다.
  - **res.setContentType("MIME Type;charset=문자표이름");**
  - **res.setContentType("text/plain;charset=UTF-8");**

- MIME Type : Multi-purpose Internet Mail Extension
  - 콘텐트의 형식을 표현한다.
  - 콘텐트 타입/ 상세 타입
  - 예) text/plain, text/css, text/html
- 웹 브라우저는 콘텐트를 출력할 때 서버가 알려준 MIME 타입을 보고 어떤 방식으로 출력할 지 결정한다.
  - 만약 HTML타입인데 HTML을 지정하지 않으면 그냥 그대로 출력해 버린다.

- 바이너리 데이터 타입 역시 MIME 타입을 지정해야한다. (ex: image/jpeg)

# GET 요청 데이터 읽기
- 웹 브라우저에서 URL을 입력한 후 엔터를 치면 GET 요청을 보낸다.

- 웹 브라우저가 보낸 데이터 읽기
  - 타입 이름 = getParameter("파라미터이름")를 사용한다.


## HTTP 요청 형식 web browser와 web server 사이에 데이터를 주고 받는 규칙
1. 요청
```
mehtod sp request-URI sp http_version CRLF
((general header | request header | entity header) CRLF)
CRLF
message-body
```
- Method: GET, POST, HEAD, PUT, DELETE, OPTIONS, TRACE
- general - header ==>> 요청, 응답에 모두 사용 :  Date, Connection 등
- reguest - header ==>> 요청에서 사용 : Accept, Host, user-Agent 등
- entity - header ==>> 서버어ㅔ 보내는 데이터 정보 : Content - Typem, Content - Lenght 등
- message - body ==>> 서버에 보내는 데이터(POST요청)

2. 응답
```
HTTP-Version sp Status-Code sp Response-Phrase CRLF
```
response - header ==>> 응답할때 사용 : Server, Location 등

# GET 요청으로 데이터 보내기
- Request-URI에 Query String으로 보낸다.
```
- 예) htt:// 서버:포트번호/ex04/s1?name=aaa&age=20
name~20 까지가 Qurey String이다.
```

# POST 요청으로 데이터 보내기
- message-body에 데이터를 실어 보낸다.
- POST 역시 ISO-8859-1로 간주하기 때문에 문자(Character)을 지정해야 한다.

# GET VS POST

|  |Get|post|
|:---:|:---:|:---:|
|데이터전송|URL포함|message-body|
|binary 데이터전송| X 단 binary 데이터를 base64로 인코딩해서 텍스트로 변환한다면 가능| multipart/form-date 포맷으로 인코딩 한다면 가능|
|전송크기 | 웹서버에 설정된 크기 보통64KB 또는 8K | 제한 없음(단 서블릿에서 제한할 수 있다.) |
|보안| 웹브라우저는 URL을 보관한다.==> 데이터가 노출된다. | 데이터 노출안됨|
|용도| URL에 데이터를 포함해야 하는경우 ==>> 게시글 조회 URL| 게시글 등록과 같은 대량의 데이터 전송, binary 데이터 전송|

1. 데이터 전송 방식
  - GET
    * request uri에 데이터를 포함한다.
  - POST
    * message body에 데이터를 포함한다.
2. 전송 데이터 용량
  - GET
    * 대부분의 웹서버가 request-line과 헤더의 크기를 8KB로 제한하고 있다.
    * 따라서 큰 용량의 데이터를 GET방식으로 전송할 수 없다.
  - POST
    * HTTP 요청 헤더 다음에 message-body 부분에 데이이터를 두기 때문에   
용량 제한 없이 웹 서버에 전송할 수 있다.
    * 용량 제한은 웹서에서 게시글의 크기나 첨부파일의 크기에 제한을 둔다.
3. 보안 
  - GET
    * URI에 전송 데이터가 포함되어 있기 떄문에   
    사용자 아이디나 암호 같은 데이터를 GET방식으로 전송하는 건 위험하다.
    * 게시물 번호 같은 데이터는 URL에 포함되어야 한다.
  - POST
    * message-body 부분에 데이터가 있기 때문에 POST 방식을 사용한다.
    * 특정 페이지를 조회하는 방식이 URL일 경우 GET 방식을 사용하는 방식이 적합하다.
4. 바이너리 데이터 전송(실행파일, 멀티 미디어 파일)
  - GET
    * request-URI가 텍스트로 되어 있다.   
    따라서 바이너리 데이터를 request-URI에 붙여서 전송할 수 없다.
    * get 요청으로 보내고 싶다면 base64로 인코딩하여 텍스트로 만든 후   
    "이름=값"으로 보내면 된다
  - POST
    * multipart 형식을 사용하면 바이너리 데이터를 보낼 수 있다.
    * 보통 파일 업로드를 구현할 때 이 multipart 전송 방식으로 사용한다.
5. 용도 
  - GET
    * 게시글 조회나 검색어 입력 같은 간단한 데이터 전송할 때 사용
  - POST
    * 게시글 등록이나 첨부파일 같은 큰 데이터 전송에 사용

# POST multipart 형식
- 별도의 처리과정이 필요하다. 대신해주는 라이브러리 피룡
- Apache 소프트웨어의 fileupload 라이브러리 사용
- @MultipartConfig(maxFileSize = 값 * 값 * 값)을 사용하여 크기를 제한한다.


# POST
- 웹 페이지의 폼(method='post'일때 ) 버튼을 클릭하면 POST 요청을 보낸다.

# HTTPServletRequest HTTP프로토콜의 요청 방식
1. GET
  - 링크를 눌러서 request(요청)하면 GET방식이다.
2. POST
  - 버튼을 눌러서 request(요청)하면 POST방식이다.

## HTTP클래스를 만들어 서브클래스이 사용하기 쉽게 만들기
- 서브 클래스를 오버라이딩 할 메서드라면 private으로 선언하지 말라.
- ==> 서브 클래스에서 이 메서드를 오버라이딩하지 않으면 오류를 출력하도록 한다.

- 클라이언트의 요청이들어오면 실행순서
1. serivce(ServletRequset, ServletResponse) 호출
  2. serivce(HttpServletRequest, ServletResponse)호출
    3. doXxx(HttpServletRequest,HttpServletResponse)호출
- 서브클래스부터 위로 찾아서 호출한다.


# forwarding(위임)
- URL은 "+" 연산을 수행하지 못한다.
- 서버에 "+" 문자를 전송하면 URL 디코딩할 때 문자가 공백으로 반환된다.
- 직접 인코딩해야 한다.( + ==>> %2b)

## 서블릿의 PrintWriter
- PrintWriter을 통해 값을 출력하면 클라이언트로 바로 출력되는 것이 아니라   
내부에 마련된 버퍼로 출력된다.
- 출력 결과는 호출이 끝났을때 버퍼의 내용이 출력된다.
- 만약 버퍼가 꽉 차면 service() 메서드 호출이 끝나기 전에 자동으로 출력된다.

1. 자신이 일이 아니라면 다른 서블릿으로 위임할 수 있다.   
==>> 요청으로 다른 서블릿으로 전달할 수 있다.   
요청배달자 = request.getRequestDispathcer(다른 서블릿 URL)

2. 서블릿이 지금까지 출력한 것은 모두 취소된다.
- PrintWriter 객체를 통해 출력하는 내용은 즉시 웹 브라우저로 전달 되는 것이 아니다.   
내부 출력 버퍼(보통8KB)에 보관된다.
- 서블릿의 service()호출이 종료된 다음에 버퍼의 내용이 웹브라우저로 전송된다.
- 그 전에 버퍼가 꽉 차면 자동으로 출력된다.

- forward는 다른 서블릿으로 위임할 때 현재 서블릿의 출력을 취소한다.
- forward는 현재 서블릿에서 설정한 setContetType()이 무시된다.

# including
- 인클루딩은 인클루드 전에 수행했던 출력을 그대로 유지한다.   
리턴된 후에도 전의 수행 결과를 출력할 수 있다.
- 인클루드의 예시로 계산기를 생각하면 쉽다
- "+"는 
- 인클루드는 현재 서블릿에서 setContentType()을 설정해야 한다.

# forwarding/including 응용
- include는 머릿말,꼬리말(Header,Footer)를 출력할 때 적합하고
- forward는 실행오류를 출력할때 적합하다.

# 리프레시
- 서버로부터 응답을 받고 "내용을 출력" 한 후   
===> 지정된 시간이 경과되면 특정 URL을 자동으로 요청하도록 만들 수 있다.
- 보통 로그인 한 후 웹 페이지를 이동 시키고 싶을 때 사용한다.
- 

- 실행 순서
 1. 웹브라우저에서 요청을 한다.
 2. 서블릿에서 작업을 한다.
 3. 서블릿은 작업결과를 웹브라우저에게 다시 요청할 URL을 포함하여 응답한다.
 4. 웹 브라우저는 결과를 출력하고 다른 서블릿에게 요청을한다.


# 리다이렉트
- 웹 브라우저는 응답 받는 즉시 해당 페이지를 요청한다.
- 웹 서버로부터 콘텐트를 받지 않았기 때문에 어떤 것도 출력하지 않는다.
- 예) 결제 완료 후 결과를 출력하지 않고 즉시 결제 상태 페이지로 보내고 싶을 때
- 실행순서
 1. 웹브라우저에서 요청을 한다.
 2. 서블릿에서 작업을 한다.
 3. 서블릿은 작업결과를 웹브라우저에게 응답한다.
 4. 응답 받은 즉시 알려준 URL로 요청한다.


# 한글이 깨지는 이유와 해결법
- POST 요청으로 보낸 데이터는 서블릿 컨테이너 측에서 영어(ISO-8859-1)로 간주한다.
- 그래서 한글 코드 값도 영어라고 간주하고 UCS2(UTF-16) 문자 코드로 변환하기 때문에
- getParameter()가 리턴하면 한글은 깨진다.

## 해결법
- request.setCharacterEncoding("UTF-8")을 적용한다.
- getparameter()를 호출하기전 데이터의 인코딩 형식이 어떤 문자표로 되어 있는지 알려줘야한다.
- !!! 반드시 getParameter()을 최초 호출하기 전에 적어야한다.


# POST 요청으로 파일 전송
- multipart/form-data 형식으로 데이터를 전송하지 않으면 첨부 파일의 데이터는 받을 수 없다.
- <form> 태그에 enctype 속성을 multipart/form-data로 설정해야한다.
```
 ex) <form enctype="multipart/form-data></form>
```
- 멀티 파트 형식으로 데이터가 넘어온 경우에는 getParameter()로 값을 꺼낼 수 없다.

# Http Cookie
- 사용자의 기록정보를 저장한다.
- 로컬에 저장된다.

## cookie.setMaxage(기록을 보관할 시간 초)
```
ex)cookie.setMaxage(60 * 60 * 24 * 7)
일주일동안 보관한다는 뜻이다.
60초 * 60 분 * 24시간 * 7일
하면 7일동안의 시간초가 나온다.
```

## 문법
1. getParts();
  * 호출하면 모든 정보가 다 넘어온다.

2. 파일을 저장할 때 오리지널 파일명을 쓰면안된다.
  * 다른 클라이언트가 작업할 때 덮어 저장될 수 있기 때문이다.

3. UUID
 * 범용 고유 식별자이다.
 * 국제기구에서 표준으로 지정하고 있다.
 * 중복될 가능성이 거의 없다.
 * 네트워크상에서 개체들의 고유성(유일성)이 가장중요하다.   
 이름이 같으면 구별을 할수 없기때문이다.
 * 고유성을 보장하려면 중앙관리시스템이 일련번호를 부여해 주어야하는데   
 동시다발적으로 개발되는 시스템 경우는 불가능하다. 그래서 UUID를 사용한다.


