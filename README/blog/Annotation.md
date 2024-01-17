# 어노테이션 Annotation
24.01.10
## 어노테이션이란
- 컴파일하거나 실행할 때 어떻게 처리해야 할 것인지를 알려주는 설정 정보이다.
  - 컴파일 시 사용하는 정보 전달
  - 빌드 툴이 코드를 자동으로 생성할 때 사용하는 정보 전달
  - 실행시 특정 기능을 처리할 때 사용하는 정보 전달

## 어노테이션 정의
- @interface 어느테이션이름(프로퍼티 = 값)
- 소스 코드에서 주석을 읽어 다른 소스 파일을 생성할 때 사용

## 어노테이션의 유지 범위
```
.java --컴파일--> .class --실행 --> JVM(Method Area)
@소스             
@클래스           @클래스           
@런타임           @런타임           @ 런타임

```
- Source
  - 컴파일할 때 제거된다.
  - 보통 소스파일에서 에노테이션 값을 꺼내 
  - 다른 파일을 자동 생성하는 도구를 만들때 많이 사용한다.

- Class
  - .class파일 까지 유지된다.
  - 에노테이션을 정의할 때 유지범위를 지정하지 않으면 기본이 classd이다.

- Runtime
  - 실행중 에노테이션을 참조해야 할 경우에 많이 사용한다.

  ## 어노테이션 프로퍼티
- @interface 어느테이션이름(프로퍼티 = 값)
- default 값을 지정하지 않으면 필수 프로퍼티가 된다.
- value 혼자 값을 지정했을때 value 생략가능
- vlaue 이외에 다른 값도 저장할 경우는 value 생략 불가

## @Target
- @Target(value = {ElementType.000})
- @Target을 사용하여 에노테이션 범위를 제어할 수 있다.
- 한 개의 값만 설정할 땐 value ,{}를 생략할 수 있다.

- @Target(ElementType.TYPE)은 인터페이스와 클래스에만 붙일 수 있다.
- FIELD 는 필드에만 
``` 
@Target({ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})

value하나에 제어하는 것이다.
@Target(value = {ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.FIELD})
```
- 여러개의 값을 저장하여 제어할 수 있다. 
- 여러개 값을 저장할땐 생략하지 못한다.

## 에노테이션 중복 사용
- 에노테이션을 중복해서 사용할 수 있게하려면
- @Repeatable 로 표시해야한다.
- 다른 에노테이션 클래스가 필요하다.
```
현재 Employee 클래스
중복 사용하기위해 Employees 클래스 생성

@Repatable(value = Employees.class)

@Employee("홍길동")
@Employee("임꺽정")
public class MyClass2 
이런식의 중복 사용 가능
```
