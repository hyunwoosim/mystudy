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

### SW SCM -소프트웨어 형상관리
  - SCM 형상관리 , 버전관리
    - 소스 관리(공유, 접근 제어)
    - 버전을 관리(변경 기록, 되돌림, 제품에 사용되는 소스 관리)
    - 빌드 구조, 개발환경, 문서 
    - QA(QM) S/W품질보증(품질관리)

### 형상관리, 버전관리 ,변경관리
  - 변경관리 ⊆ 버전관리 ⊆ 형상관리 
1. 형상관리 - 모두 관리할 수 있는 통합 시스템  
2. 버전관리 - 변경을 관리하기 위한 효과적인 방법
3. 변견항 상황을 관리하는 문서
  - 문서변경 이력, 복원등 기능이 제공된다.


### 버전 관리 시스템 (소스관리와 변경관리를 처리하는 프로그램)
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
14. 로컬 깃 사용자의 이름,이메일 - $git config

### GIT 용어
1. Untraked 
  -작업 디렉토리에 새로 파일을 추가한 경우
  -아직 $git add를 통해 스냅샷,Staging Area 등록되지 않은 파일
2. Unmodified
  - 마지막 Commit 이후 아무것도 수정하지 않은 상태
3. Modified
  - 파일의 내용이 변경된 상태
4. Staged 
  - Staging Area에 등록된 상태
5. Staging Area(스냅 샷) ?
  - 백업 전 파일들을 올리는 곳
  - 상태들이 위에 용어들로 표시된다.


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
    - 포토샵, 엑셀 프리미어, 파워포인트 등등

  - 바이너리 파일 종류
    - .jpg .png .mp4 .pdf 등등
    
## 4일차 

### 충돌과 해결

  - 예시 
    개발자 1,2 가 똑같은 파일을 Clone 후 편집하고 서버에 Push 할 때 충돌이 일어남
  - 그때 merge(병합)을 통해 서로 대화 후 내용을 편집하고
  - 다시 Push 하면 된다.

### ignore?(gitignore.io)
  - 버전관리 시스템의 관리대상이 아닌 것들을 제외 시키는 명령어

- 버전관리의 관리대상
  - 관리대상 : 소스파일, 문서, 설정파일

- 버전관리의 관리대상 X
  - 개발도구 설정파일, 빌드(컴파일) 결과파일
    - 개발자의 환경에따라 달라지는 파일은 관리대상 X
    - 빌드 결과물(.class  .exe  .jar 등)

### 인터프리터, 컴파일, 하이브리드 방식

1. 인터프리트 방식(인터프리터 = 실행 프로그램)
  - 소스파일을 읽고 문법검사후 해석하여 인터프리터로 실행한다.
- 특징
  1. 소스파일을 직접 읽어서 실행
  2. 실행할 때 소스파일 필요
  3. 인터프리터가 있어야 한다.
  4. 실행할때마다 매번 문법검사
- 단점
  1. 컴파일 방식에 비해 속도가 느리다
  2. 코드에 오류가 있더라도 실행 전까지 알 수가없다.
- 인터프리터 방식 파일
    - .jS ---> Node js
    - .py ---> python
    - .php ---> PHP엔진

2. 컴파일 방식 (C언어)
  - 소스파일을 컴파일러로(문법검사 -->기계어 변환) 실행파일을 바로 실행
- 특징
  1. 컴파일 할 때 문법검사를 수행
  2. 실행할때 바로 실행- 인터프리터X 컴파일러X
  3. 기계어이기때문에 실행속도 빠르다 (인터프리터 방식 보다)
  4. 소스코드를 노출하지 않는다 (자산 보호)

3. Hybird 방식 (자바)

```
소스파일 --(자바컴파일러)-->바이트코드(P-Code)-->(JVM)-->OS
<----------컴파일방식---------><------하이브리드방식----->
```


- 특징
  1. 컴파일 방식의 이점을 취한다.
    - 소스 코드 비노출 (자산 보호)
    - 컴파일 과정에 문법 검사 완료-> 실행 속도 향상
  2. 가상의 기계어로 번역
    - 특정 CPU에 비종속 -> CPU마다 컴파일 X
    - OS에 JVM 설치되어 있으면 실행 가능
- 단점
  - 진짜 기계어 실행하는 것 보다 느리다.

- OS 상관없이 실행 할 수 있다는 것이 더 이득이기 때문에 사용!


### JIt AOT

1. JIt (Just In Time)
  - 실행 시점에 자주 실행하는 코드를 진짜 기계어로 바꿔놓고 그 기계어를 실행하여 실행속도를 높이는 방식

  - 이전 방식
  ```
          명령어 하나씩           실행
  Bytecode --------------> JVM ----------> OS
             읽어서 
  
  Bytecode를 JVM으로 하나씩 읽어서 실행하였다

  ```
  - JIT 컴파일 방식
  ```

            명령어 읽기         실행(기존방식)
  Bytecode ------------> JVM ------------------->  
                                                           OS
    
    자주실행되는 명령어 실행시점에 기계어로 바꾸어 보관
                        기계어(Cache) ----------------->
                                실행(직접실행) 
  - 기존방식과 새로운 방식으로 인해 속도 개선
  - 캐시에 보관 기계어는 실행 완료 시점에 제거된다 (영구보관 X)
  
  ```

2. AOT (Ahead Of Time) 
  - JIT 방식은 실행 시점에 컴파일 하기 때문에 일시적 실행이 느려지는 문제가 있다
  - 이를 해결할 목적으로 AOT 만들어졌다

```
--Playstore--          ----------Andorid-------------

       1 -> 2                3                      4
App -----------------> App-----------기계어 -------->실행

 1. 다운로드
 2. 설치
 3. 설치과정중에 미리 컴파일
 4. 실행

```
  - 장점 
    - 실행속도가 빠르다
    - 설치 과정에 기계어로 바꾸기 때문에 설치 시간이 길어짐

### 빌드 (Build) 도구

1. 빌드
```
컴파일 --> 테스트 --> 보고서/문서작성 -->배포 파일준비 --> 배포

<---------------- S/W 제작 전체과정 ------------------------>
```

2. 빌드 도구
  - Build 작업을 수행하는 도구
    - 테스트 도구 --> 테스트 수행
    - 컴파일러 --> 컴파일 수행
    - 디버거 --> 디버깅 수행
    - 문서생성기 --> 문서 생성
    - 배포파일 생성기 --> 배포 파일 생성

3. 빌드 스크립트 파일
  - 빌드의 자동화
  - 사람이 일일이 빌드과정에 개입 필요 X
  - 전체 과정을 자동화 시킬 수 있다.
    - ex 소스폴더 경로, 배포파일 이름, 빌드 순서, 빌드할때 사용할 도구

4. 대표적 빌드 도구

```

Ant ---------------> Maven -------------> gradle

build.xml          pom.xml             build.gradle
  
```
- Maven 등장이유
  - 의존라이브러리 관리기능 포함
    - 의존라이브러리(다른개발자가 만든 코드)
    - 관리기능 : 자동 다운로드

- Gradle 등자이유
  - Xml --> Groovy 언어
    - 프로그래밍 언어를 사용함으로 정밀하게 빌드과정 제어 가능
    - 프로그래밍 언어에는 조건문 반복문이 있기 때문에

### 소프트웨어 라이브러리 
- 인간의 도서관 --> 책
- S/W 도서관 --> 컴파일된 코드 or 날 것의 코드

## 5일차(11.20)

### Gradle

- 자바 컴파일
  - $java -d bin src/Hello.java (소스파일 경로)
    - -d bin (zjavkdlf) 

- 바이트코드 파일
  - $java -cp(-classpath) bin Hello(.class파일 있는 경로)

### git 저장소

- 프로젝트 폴더
```
한가지 폴더의 하나의 프로젝트

-mystudy/
     -src/

```

- 여러개의 프로젝트 폴더
```
메인 프로젝트 1 서브프로젝트 여러개

 mystudy/
    - 프로젝트 A/    <--- main 프로젝트
        -src/
    - 프로젝트 B/    <--- Sub 프로젝트 1
        -src/
    - 프로젝트 C/    <--- Sub 프로젝트 2
        -src/
```

- Maven 표준 프로젝트 디렉토리(폴더) 구조
  - 자동생성 - $gradle init
```
- 자동생성 명령어 - $gradle init

프로젝트 폴더/
          -src/
            -main/   <--- app 소스파일 두는 폴더
              -java/   <--- 자바 소스파일 (.java)
              -resources/ <--- 설정파일 (.xml, .properties)
              -kotlin/ <--- 코틀린 소스 파일(.kt)

            -test/  <--- 단위 테스트 소스 파일 폴더
              -java/
              -resources/
```
- DSL(Domain-Specific Language)
- build.gradle(빌드 스크립트) 
  - 특정 영역에서 사용하는 언어 
  - ex - java, kotlin

### gradle 사용법
 - Gradle로 수행할 수 있는 작업 목록 출력
  - gradle tasks
  - gradle tasks --all

- Gradle
  - settings.gradle, build.gradle 파일을 일고
  - 설정된 것을 바탕으로 실행

- Gradle 빌드 스크립트 파일(build.gradle)
  
  - plugins{} <--실행할때 사용할 플러그인 (ID'플러그인명') // application = java + 실행과 관련된 테스크
  - repositories{} <-- 외부 라이브러리를 다운로드 받은 서버정보
  - dependemcies{} <-- 외부 라이브러리 정보
    - java플러그인 --> 자바소스 빌드작업을 수행
    - Eclipse플러그인 --> Eclipse ID 관련 작업 수행

- Gradle 구동
```
        컴파일러 사용법알아야함 (-d, -classpath)
개발자 --------->                  ---> 컴파일 수행
                  Java 컴파일러
     --Gradle-->
  Gradle의 빌드스크립트 작성방법 알아야함
  - Gradle은 자바 컴파일러가 아니다
```
### Gradle 'Java' 플러그인 사용법

```
Tasks -명령
- compileJava, ProcessResources, Classes
- CompileTestJava, ProcessTestResource, TestClasses
- Test, jar, build, clean
```
1. CompileJava 
  - 애플리케이션 소스 컴파일
```
프로젝트 폴더/
        -app
          -src/
            -main/
              -java/    <---이 폴더에 있는 자바소스를 컴파일

        -build/
          -classes/
            -java/
              -main/  <--이 폴더에 .class 파일을 둔다
```

2. ProcessResoures
  - 실행할 때 사용한 설정파일을 빌드 폴더에 복사
```
프로젝트 폴더/
        -app/
          -src/
            main/
              resources/  <--이 폴더에 있는 파일을
          
        -build/
          -resources/
            -main/     <---그대로 복사
```

3. classes
  - application 실행할 수 있도록 컴파일
    1. compileJava 실행
    2. ProcessResources 실행

4. CompileTestJava
  - 단위 테스트 소스 컴파일
    1. compileJava
    2. ProcessResources
    3. classes
```
    4. src/test/java
          컴파일
       build/classes/java/test <--단위 테스트 .class 파일 둔다.
```

5. ProcessTestResources
  - 단위 테스트 설정 파일 복사
```
/src/test/resources/*
                              그대로 복사
/build/resources/test/*
```

6. TestClasses
  - 단위 테스트 관련 파일을 컴파일
    1. compileJava
    2. ProcessResources
    3. classes
    4. compileTestJava
    5. ProcessTestResources

7. Test
  - 단위 테스트 수행
    1. compileJava
    2. ProcessResources
    3. Classes
    4. compileTestJava
    5. ProcessTestResoures
    6. TestClasses
    7. Test  ---> 단위 테스트 실행후 보고서 생성 bueil/reports/tests/보고서

8. jar
  - 애플리케이션 패킹
    1. compileJava
    2. ProcessResources
    3. classes
    4. jar --> .jar 파일 생성  -build/libs/*.jar

9. build
  1. test <-- 애플리케이션 컴파일 및 단위 테스트 실행
  2. jar <-- 배포파일 생성

10. clean <-- build 폴더 삭제

11. run
  1. CompileJava
  2. ProcessResources
  3. Classes
  4. Run   <--- build 스크립트 파일에 지정도니 메인클래스 실행

## 자바 문법 기초

### 클래스 블록
  - 클래스 블록당 .class 파일생성
  - 컴파일 기본단위는 클래스 블록이다.
  - 소스파일 X
```
                     compile
A.java     class A{} ------> A.class
B.java     class B1{} -----> B1.class

C.java     class C1{} -----> C1.class
           class C2{} -----> C2.class
           class C3{} -----> C3.class

- 클래스 블록당 .class 파일이 생성된다
```

1. 소스 파일과 클래스 블럭, .Class 파일 
```
컴파일 명령어
$ javac -d build/classes/java/main - .class파일을 만들 목적폴더
           src/main/java/com/eomcs/D.java - 현재 폴더

com/eomcs 폴더에 있는 자바 소스를 컴파일 했는데
목적폴더 com/eomcs 폴더에 .class 파일이 없다.

-이유 : 특정 폴더에 소속된다고 지정하지 않았기 때문이다
        루트 디렉토리의 클래스로 간주된다
        위 명령어 처럼 목적 폴더를 메인으로 지정했기때문에

```
### 패키지
  - 클래스가 소속된 그룹
  - 디렉토리로 다룬다
  - 클래스 역할에 따라 관리하기 위해서
  - 소스 코드 정리정돈
    - 도서관에서 분류에 따라 책을 찾기 쉽게
```
패키지 문법
package 파일명; ex) com.eomcs;
class E1{}
class E2{}

JVM 실행할 때 classpath를 실행한다.
class 파일 경로는 목적파일까지만 지정
실핼 할때 반드시 패키지명 지정

JVM명령어
$java -d (목적폴더 생성지점까지) -->.class파일 만들곳
  ex)java -d build/classes/java/main

$java -classpath (.class파일이 있는 목적폴더 까지) (패키지명 .으로 표시)
  ex)java -classpath build/classes/java main com.eomcs.E1

```
1. 패키지 작성 관례
  - 패키지 이름은 도메인명을 보통 사용
    - 개발자간,회사간, 이름충돌 방지
  - 도메인명을 거꾸로 사용
    - 상위에서 하위로 분류하기 쉽게
```
  도메인명 ----->제품명----->역할명
com.microsoft.   msword.    checker
```
2. 패키지와 공개 여부
- 공개여부와 상관없이 같은 패키지에 소속된 경우 접근 가능
  - 패키지 멤버 클래스

-접근 가능 예시
```
- 같은 eomcs 패키지에 있기 때문에 공개여부 상관없이 접근가능

src/main/java/
           |-com
             |-eomcs/
                |-F.java
                     classF1{}
                     classF2{}
                |-Test.java
                     classTest{}

```
- 접근 불가 예시
```
- 다른 패키지에서 공개되지않은 클래스는 접근 불가

src/main/java/
           |  |-com
           |    |-eomcs/
           |       |-F.java
           |            classF1{}
           |            classF2{}
           |
           |-Test.java
                   class Test{}

```

3. 패키지와 공개여부,파일명
  - 공개 클래스는 소스 파일명이 반드시 같아야한다
    - 유지보수할때 소스파일을 찾기 쉽도록 하기위해
  - 공개클래스는 파일당 하나
```
src/main/java/
           |  |-com
           |    |-eomcs/
           |       |-F1.java      <-- 공개클래스와 파일명 같아야함
           |            pubilc classF1{}
           |            classF2{}
           |
           |-Test.java
                   class Test{}

```
4. 패키지 결론
- 1개 소스파일 - 1개의 클래스 블록(공개여부 상관없이) <= 일반적경우
- 소스파일명 = 클래스 블록 이름
  - 유지보수가 쉽고, 클래스가 정의된 소스파일을 찾기 쉽다

### main() 메서드 -프로그램 entry point(진입점,입구)
$java Hello
  1. Classpath에 지정된 경로에서 Hello.class 파일을 찾는다
  2. .class 파일의 Bytecode를 검증한다.
  3. main() 메서드 실행

```
문구
class Test3 {
  public static void main(String[] args){
    //프로그램 엔트리 포인트(entry point; 진입점)
    System.out.println("Hello!");
  }
}
```
## Java 기초 문법
  - 리터럴, 변수, 연산자, 조건문, 반복

- Literal (리터럴)
  - 데이터를 표기한 것

```
- 숫자 :   - 정수 : 12
          - 부동소수점(실수) : 3.14
- 문자   :  'A', '가'
- 문자열 :  "A", "abc"
- 논리   : true, false
```
### 주석 사용법
- Comments / JavadocComments / Annotation

- java doc 주석
  - 표기 /**     */
  - API문서 ->개발자가 작성한 코드의 사용법을 설명한 문서
```
문법

/** 클래스설명 */
class A{                 javadoc실행
/** 변수설명 */         ----------->      HTML문서
int a;
/** 메서드 본명 */                         
void m(){___}
}

```
- javadoc 등장전

```
개발자 
1. 소스파일 작성 ex) .java .c
2. API 문서 작성 ex) .doc .ppt
3. 소스파일 변경
4. API 문서 변경
```
  - 문제점: 
    - 소스코드를 바꾸면 API문서도 그에 맞춰 변경해야하지만 개발자들이 귀찮아서 안하는게 현실
    - 코드와 문서가 일치하지 않는 문제 발생!

  - 해결 방법
    - 소스+문서 결합 -->문서 생성 자동화 ex)Javadoc

- Annotaion(애노테이션)
  1. 컴파일할때 사용
  2. 실행할 때 사용
  3. 다른 문서 생성할 때 사용
```
문법 예시

 소스파일                      컴파일             .class파일

/* 일반주석 */               버린다

/** javadoc 주석*/    -->   javadoc->HTML삽입

@애노테이션 주석        ----------------------------->포함


```
### IDE(Intergratde Development Environment : 통합 개발 환경)
- IDE 
  - 편집기
  - 위저드기능의 자동화 도구
  - Ex) Eclipse, Inteli J, NetBeans
-단순 에디터
  - Ex) 메모장, VI,Nano
- VS Code
  - 플러그인을 사용한 반자동 IDE도구
```
ex)

메모장,vi         VSCODE               Eclipse

단순 에디터  -------------------------> IDE---> JDk, git,개발도구
                    |                                                    |                                             
                    |----> +컴파일,실행,디버깅,테스팅,패킹,버전관리 등 개발의 전반적 작업을 해당도구를 사용해서 처리해준다                                                   

단순에디터
Ex)메모장,VI,Nano
```