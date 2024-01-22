# 네트워크 기초

## 네트워크란?
- 여러 컴퓨터들의 통신 회선을 연결한 것
- LAN, WAN이있다.
  - LAN : 가정, 회사 , 건물, 특정영역
  - WAN : 우리가 흔히 말하는 인터넷이다.

## Server , Client
- 서버 Server : 서비스를 제공하는 프로그램
- 클라이언트 Client : 서비스를 요청하는 프로그램
- 요청 응답과정
  - 1. 클라이언트가 서버에게 서비스를 요청한다.
  - 2. 서버에서 처리를 한다.
  - 3. 서버는 클라이언트에게 응답(처리 결과)한다

## IP( Internet Protocl)
- 컴퓨터의 고유한 주소이다.
- IP 주소는 LAN 카드(네트워크 어뎁터)마다 할당된다.
- IP주소를 java.net패키지의 InetAddress로 표현한다.
```
로컬 컴퓨터의 IP주소를 얻는 법
InetAddress ia = InetAddress.getLocalHost();

도메인 이름을 알고 있을 때
InetAddress ia = InetAddress.getByName(String domainName);
InetAddress ia = InetAddress.getAllByName(String domainName);

- getByName은 DNS에서 도메인 이름으로 등록된 단 하나의 IP 주소를 가져온다.
- getAllByName은 등록된 모든 IP주소를 가져온다.
```

## DNS(Domain Name System)
- 상대방의 IP주소를 모르면 프로그램들은 서로 통신할 수 없다.
- 프로그램은 DNS를 이용하여 IP주소를 검색한다.
- DNS는 도메인 이름으로, IP를 등록하는 저장소이다.
- ex) 도메인 - www.naver.com

## Port번호
- Port 번호는 운영체제가 관리하는 서버 프로그램 연결번호이다
- 다양한 프로그램이 실행될 수 있기때문에 어떤 서버와 통신할지 모르기 때문이다.
- Port 번호는 중복되서는 안된다.
- 전체 Port번호의 범위는 0 ~ 65535로 3가지의 사용목적으로 나뉜다.
- 1. 특정 애플리케션용 미리 예약한 Prot : 0 ~1023
- 2. 회사에서 등록해서 사용할 수 있는 Prot : 1024 ~ 49151
- 3. 운영체제가 부여하는 동적Port, 개인적 목적 Port : 49152 ~ 65535
- 3번의 경우 OS가 자동으로 Port번호를 발급해준다. 개발자가 정하는게 아니다.

## 전송용 프로토콜 TCP 와 UDP
- IP프로그램들이 통신할 때 약속된 데이터 전송규약을 = 전송용 프로토콜 이라 부른다.
- 전송프로토콜은 TCP 와 UDP가 있다.

## TCP
- TCP는 연결형 프로토콜이다.
- Connetion - Oriented 라고 한다.
- 상대방이 연결된 상태로 데이터를 주고 받는다.
- 데이터가 순서대로 전달되며 손실이 발생하지 않는다.
- 데이터 송수신을 보장하여 신뢰성이 높다.
- 연결이 조금 걸린다는 단점이 있다.
- ex) 전화,등기

## TCP/IP
- TCP는 IP와 함께 사용하기 때문에 TCP/IP라 부르기도 한다.
- TCP는 웹브라우저가 웹 서버에 연결할 때 사용된다.
- 이메일 전송, 파일 전송, DB 연동에도 사용된다.

## ServerSocket 과 Socket
- TCP 네트워킹을 위해 jvav.net 패키지에서는 ServerSocket,Socket클래스를 제공한다.

- ServerSocket 은 서버가 클라이언트 연결을 수락하는 클래스이다.
  - accept()메서드로 연결을 수락하고 통신용 Socket을 생성한다.

```
ServerSocket의 Port번호 바인딩
prot 번호 : 8888

ServerSocket serverSocket = new ServerSocket(8888);

연결 요청 수락을 위한 accept() 메서드

Socket socket = serverSocket.accept();

port 번호 재사용을 위한 close();

serverSocket.close();

```

- Socket은 클라이언트가 연결을 요청할때, 클라이언트와 서버 양쪽에서 데이터를 주고받을 때 사용한다.
```
클라이언트가 서버에 연결요청을 하려면 Socket 객체에 생성자 매개값으로 서버 IP,Port 번호를 주면된다.

Socket socket = new Socket("IP,8888);

```

## UDP
- 발시자가 수시자에게 일방적으로 데이터를 보낸다.
- 연결과정이 없기때문에 TCP보다 빠르지만 
- 데이터 송신을 보장하지 않는다. 신뢰성이 낮다.
- 이유는 TCP처럼 고정회선이 아닌 여려회선으로 보내기 때문에
- 데이터가 순선대로 전달되지 않거나, 잘못된 회선으로 데이터 손실이 발생 할 수 있다.
- 예) 편지, 실시간 영상 스트리밍

- UDP 서버를 위한 DatagramSocket 객체를 생성할 때는 port번호를 생성자 매개값으로 제공해야한다.

## receive()
- 데이터를 수신할 때까지 블로킹되고, 데이터가 수신되면 저장한다.

## DatagramSocket 
- 발신점과 수신점

## DatagramPacket
- 주고 받는 데이터



## 네트워크에서 많이 사용되는 용어 문법
## 대기열(Queue)?
- 클라이언트가 접속을 요청하면 대기열에 클라이언트 정보를 저장한다.
- 대기열의 크기가 클라이언트의 연결을 허락하는 최대 개수이다.
- 대기열을 초과하여 클라이언트 요청을 들어 왔을 때 서버는 응답하지 않는다.
- 클라이언트는 내부에 설정된 시간(timeout)동안 기다리다 응답을 받지 못하면
- 예외를 던지고 연결 요청을 취소한다.

## new ServerSocket(포트번호, 대기열크기);
- 다음과 같이 대기열의 개수를 지정하지 않으면, 기본이 50개이다.

## character stream 클래스의 경우(PrintWriter)
- 출력 데이터를 내부 버퍼에 보관하고 있다가
- out.flush()를 호출할 때 출력을 수행한다.


## Stateful , Stateless 통신 방식

### Stateful
- Client와 Server가 연결을 한 후 연결을 끊을 때까지 요청/응답을 계속 수행한다.
  - 장점 : Client의 작업 요청에 대한 작업결과를 계속 유지할 수 있다.
  - 단점 : 1. 서버의 메모리를 계속 차지한다. 2.접속 클라이언트의 수가 제한된다.


### stateless
- Client와 Server가 연결 후 요청/응답을 수행한 후 연결이 끊어진다.
  - 장점 : 1.서버의 메모리가 덜 차지 된다. 2.Sateteful 방식보다 더 많은 클라이언트 연결 가능
  - 단점 : 1.요청을 하려면 매번 서버와 연결을 해야한다.(소요시간 증가) 2. 서버에 요청 결과를 남기지 못한다.
  - 예) 게임서버 연결 : 게임을 끄기전까지 계속 서버와 데이터를 주고 받는다.


### Stateless에서 클라이언트 구분 방법
- 웹서비스에서는 많은 클라이언트와 연결을 위해 Stateless 방법을 사용한다.
- 하지만 Stateless방법은 요청/응답 후 연결이 끊기기 때문에 결과를 남기지 못하는 단점이 있다.
- 그것을 해결하기위해 세션ID를 사용한다.
  - 세션ID란 클라이언트에 ID를 부여하여 ID와 결과값을 저장하고 돌려주는것이다.
  - 예)
```
stateless의 클라이언트 구분법
HashMap을 사용하여 ClientID 부여
ResultMap을 사용하여 ID,결과값을 저장한다.

Ex) 계산기stateless이다 
  - op ==> +,-,*,/
  - value ==> 값
ClientID,OP,Value 순서이다.

1. Client가 Server에게 요청을 한다.
==> 0,+,100     - 0 인 이유는 처음 연결 후 요청했을땐 ID가 없다 
ID는 서버가 할당해주는 것이다.

2.Server은 ClientID를 발급하고 ResultMap에 ID와 결과값을 저장한다.
ID = 123 결과값 = 100

3.Server은 저장한 후 ID와 결과값을 Client에게 응답한다.

4. Client는 발급 받은 ID를 가지고 다시 요청한다.
123, + , 200

5.Server은 기존ID를 찾아 결과값을 저장한다.
123, 300

이런 방식으로 클라이언트르 찾을 수 있다.
```

## HTTP(Hyper-Text Transfer Protocol)
- 클라이언트와 서버사이의 일어나는 요청/응답 프로토콜이다.
  - 프로토콜이란? 
    - 클라이언트와 서버간의 통신 규칙
    - 데이터를 주고받는 규칙
- 전달되는 자료는 URL로 조회할 수 있다.
- 자료는 HTML형식이다.

## HTTP = web
- 요청하는 곳 : HTTP Client = Web Browsers
  - 대표적으로 : Chorme, Edge, Safari, Firefox ---> GUI
  -           wget, curl ---> CLI

- 응답하는 곳 : HTTP Server = Web Server
  - Apache HTTP Server, IIS, NginX

## HTTPS(Hyper Text Transfer Protocol over Secure Socket Layer)
- HTTP의 보안이 강화된 버전이다.
- HTTP를 통해 주고받는 HTML정보를 암호화시켜 데이터를 보호하는 것이다.


## URI/URL/URN
- URL,URN을 합쳐 URI라고 부른다.
```
URI - URL
    - URN
```
## URL(Uniform Resource Locator)
- 웹 상에서 자원의 위치를 표현하는 방법
  - [프로토콜]://서버주소:포트번호/자원의경로?파라미터명=값&파라미터명=값
  - 프로토콜 : http(80),https(443)를 말한다.
  - 서버 주소 : IP주소, 도메인명(www.naver.com)
  - 포트 번호 : 프로토콜의 포트 번호이다. 생략가능하다.
  - 자원의 경로 : board list, search naver
  - 파라미터명 = 값 : 서버에 보내는 파라미터

- 자원이란?
    - 정적자원(static) 요청할 때 마다 결과가 변경되지않는 자원
      - ex) HTML,JPEG,GIF
    - 동적자원(dynamic) 요청할 때 마다 결과가 변할 수 있는 자원
      - ex) 카페 전체글 게시판

## Base 64란
- 바이너리 데이터를 문자화 시키는 방식
- URL은 텍스트이다.
- 그렇기 때문에 바이너리 데이터를 포함할 수 없다.
- 바이너리 데이터는 JPEG, MP3, PPT등이 있다.
- 바이너리 데이터를 Base64를 사용하여 문자화 시킨다.
- Base 64는 (영어대소문자, 숫자 , +, /)로 변환 가능하다.
- 64진수를 만들어 Base 64표를 보고 문자화 시킨다.
```
데이터 --인코딩--> Base 64 --디코딩--> 데이터
```
