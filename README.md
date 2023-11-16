# mystudy
## cpu와 기계어

 ### 기본 원리

1. APP은 H/W에게 명령 입력(기계어) 한다.
2. H/W는 실행
3. H/W는 APP에게 결과를 전송한다.
- CPU마다 이해하는 기계어 다름
- CPU가 같고 OS가 다르면 호환 불가
   - OS의 포맷이 다르기 때문이다.
    - window -PE 운영체제
    - MAC Mach-O 운영체제
- OS가 같아도 CPU가 다르면 호환 불가
   - 기계어가 다르기 때문이다.

### Assembly언어와 C언어 

- Aseembly 언어
  - 기계어 형식과 흡사한 문법
  - Low-Level-Language
  - Assembly언어를 기계어로 Compiler하여 CPU와 호환
    * OS에 종속적, OS마다 다르다 불편함이 크다
- C언어
  - OS와 상관없이 동일한 문법
  - 좀 더 인간에게 친숙한 문법
  - High-Level-Language

### JAVA APP
  
1. 개발자가 JAVA 언어로 작성  (.JAVA)
2. JAVA Compiler 사용
3. P-CODE(BYTECODE)로 변환
  - 기계어와 흡사한 중간상태 명령어
4. OS체제에 맞는 JVM을 사용
  - JVM - 특정형식 명령,데이터를 받아 해독하여 실행
5. 출력 후 CPU에게 공급
- 단점 기계어를 직접실행 방법이 아니어서 실행속도 느림

### REPL Jshell

- REPL (Read Evaluation Print Loop)
  - 읽고 실행하고 출력하고 반복한다
  - 소스코드 실행결과를 빠르게 확인하기 위해 사용
- Jshell
  - 간단히 자바 명령을 실행 테스트 하는 용도
### JAVA 개발도구
- Java SE 
  - JDK (웹 개발자용 )
  - JRE
- Java EE 
  -기업용 서버 APP 제작에 필요한 도구
- Java ME
  - 인베디드 APP 제작에 필요한 도구

### GIT 저장소
- git sever에 소스파일을 저장하고 개발자local로 가져와서 사용하는 방식

- SW SCM 소프트웨어 형상관리
  - SCM 형상관리 = 버전관리
    - 소스 관리(공유, 접근 제어)
    - 버전을 관리(변경 기록, 되돌림, 제품에 사용되는 소스 관리)
    - 빌드 구조, 개발환경, 문서 
    - QA(QM) S/W품질보증(품질관리)

- 버전 관리 시스템 (소스관리와 변경관리를 처리하는 프로그램)
1. 로컬 버전 관리 시스템(RCS)
  - PC(Local)에서 개발도구 편집(생성,변경,삭제)함
  - 특정 폴더에 보관
  - 단점 팀원간의 공유가 불가

2. 중앙 집중식 버전 관리 시스템
  - 팀원끼리 소스파일 공유 가능
   - 서버에 소스파일을 기록 관리한다.
     * EX 개발자가 서버 소스파일을 chekout(가져와) 각자가 편집하다 서버에 (check in) 한다.
  - 모든 변경 기록이 서버에 보관된다.
* CVS
  - 서버에 소스파일을 Check in 할 때 소스파일을 통째로 업로드
  - 단점 네트워크가 주고받은 데이터양이 크다
* SVN
  - Chek in 할 때 변경한 부분만 업로드
  - 데이터 통신양이 줄어든다.

- 단점
  - 모든 기록을 서버에 보관 하기 때문에 서버에 문제가 생기면 기록 삭제됨
  - 로컬에는 소스파일만 있기 때문에 기록은 복구가 불가능 하다.

3. 분산 버전 관리 시스템
  - GIT
    - 기록을 여러 컴퓨터에 분산해서 백업
    - 서버에 문제가 생겨도 소스, 기록 복구 가능

### GIT 사용법, 명령어
1. git bash 설치 후 git 폴더 생성 -  $mkdir git
2. 복제(clone) - $git clone http://이름/폴더
3. 현재 위치 - $pwd
4. 경로이동 - $cd 이동하고싶은 폴더이름
5. 파일 상태,간략하기 보기 - $status , $status --short
6. 대상 파일을 백업 명단 추가,전체추가 - $add 파일이름 , $add .
7. 백업 - $git commit -m "내용"
8. githube에 보내기 - $git push
9. gitbue에서 가져오기 - $git pull
10. 디렉터리에 있는 모든것 보기 - $dir, $ls
    - ls는 리눅스 운영체제만 가능 예외-gitbash에서 사용가능
11. 로그 보기,한줄로 보기 - $git log , $ git log oneline
12. 로그 기록으로 돌아가기 - $git checkout 로그(커밋)ID
13. 지금 최신상태로 돌아가기 - $git checkout main

### 텍스트 파일
- 텍스트 파일이란 일반적으로 메모장에서 편집이 가능한 것

1. Plain text(순수한 텍스트)
  - Hello!
  - 이것은 테스트
  - 이미지 불가

2. MD(Mark Down)
  - 텍스트 + 간단한 명령을 Compile해 HTML 변환 후 Web브라우저에 출력
  - Web브라우저는 MD파일을 모른다. (github는 MD를 중간에서 변환해줌)
  - 샾 Hello!
  - 이것은 테스트
  - ![이미지가 깨질시] (/이미지)

3. HTML(문법 <>시작해서 끝남)
  - h1 Hello! /h1  
  - p 이것은 테스트 /p
  - img alt="이미지깨질시" src="/이미지"

### 텍스트 파일 VS 바이너리 파일
- 텍스트 파일(일반적으로 메모장에서 편집이 가능한 것)
  - 텍스트 편집기 종류
    - 메모장, VI/Nano/emacs , VScode
  
  - 텍스트 파일 종류
    - .yml .xml .rtf 소스파일(.java .css .js .html)

- 바이너리 파일 (전용편집기가 필요한 것)
  - 전용 편집기 종류
    - 포토샵, 엑셀 프리미어, 파워포인트

  - 바이너리 파일 종류
    - .jpg .png .mp4 .pdf
    