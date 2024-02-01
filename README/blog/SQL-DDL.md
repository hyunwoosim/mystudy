## SQL(Structured Query Language)
- DBMS에게 내릴 명령을 작성하는 프로그래밍 언어
- 표준문법 + DBMS 전용 문법 = 실무 SQL
  - 표준 문법 = DBMS에 따라 지원율이 다르다.
  - DBMS마다 다르다.
```
      ==> DDL : 테이블, 뷰, , 함수 등을 정의, 삭제 ,변경
SQL   ==> DML : 데이터, 입력, 변경, 삭제
      ==> DQL : 데이터 조회
```

### key column
- 데이터를 구분할 때 사용하는 값

### Key
- 데이터를 구분할 때 사용하는 컬럼들의 집합
```
예)
 {email}, {jumin}, {id}, {name, tel}, {tel, basic_addr, gender, name}
  {name, jumin}, {email, id}, {id, name, email} ...
```

### Primary key (주 키)
- 데이터 구분하는 키!!
- candiate key중에 DBMS 관리자가 사용하기 결정한 키
- 주 키로 선택 되지 않은 모든 candiate key는 alternate key가 된다.
- 테이블의 데이터를 구분할 때 사용하는 컬럼들이다.
- PK라고 표시한다.
- PK컬럼을 지정하지 않으면 중복될 수도 있다.

### Candidate key (후보키 == 최소키)
- key들 중에서 최소 항목으로 줄인 키
- {jumin}, {email}, {id}, {name, tel}

### Alternate key(대안 키)
- Primary key를 제외한 나머지 키들을 말한다.
- 주로 사용되는 키는 아니지만 데이터를 구분하는 용도로 대신 사용할 수 있다.
- 그래서 **대안 키 ** 라고 부른다.

### artificial key (인공키)
- Primary key로 사용하기에 적절한 컬럼을 찾을 수 없을 때 컬럼을 추가하는 용도로 사용한다.
- 보통 일련번호를 저장할 수 있는 정수 타입을 추가한다.
  - 예) 게시글 번호
- 대부분 SNS서비스들은 일련번호를 Primary key로 사용한다.


## PK 지정
- 두 개 이상의 컬럼을 묶어서 PK로 선언하고 싶다면 개별적으로 지정해선 안된다.
- 별도의 문법 사용
- 제약조건 이름은 생략가능 
- 제약조건 이름을 정하지 않으면 자동으로 부여된다.
  - 나중에 제약 조건을 찾기가 힘들다. (지정하자)
- 제약 조건 이름은 자유롭게 설정가능하다.
```
ex)
constraint 제약조건 이름 primary key(컬럼명,컬럼명,...)
```

- 하지만 여러 개의 컬럼을 묶어서 PK로 사용하면 데이터를 다루기가 불편한다.
- 찾을때마다 name과 age 값을 지정해야 한다.
- **그래서 '학번', '게시글 번호'처럼 임의의 값을 지정하는 컬럼을 만들어 PK로 사용한다.**

## Unique 문법
- PK를 지정했지만 다른 것들이 겹치는 것을 막기위해 사용하는 키를 **대안키(alternate key)**라고 부른다.
- 대안키는 DBMS에서 unique 컬럼으로 지정한다.
```
constraint 제약조건이름 unique(컬럼명, 컬럼명...)
```
- 모든 컬럼 선언 뒤에 놓을 수 있다.

## index
- 조회목적으로 사용하는 컬럼에 A-Z 또는 Z-A까지 정렬시키는 문법이 인덱스다.
- 인덱스 컬럼을 사용하면 DBMS가 인덱스 테이블을 만든다.
- where 값을 찾을 때 인덱스로 정렬되어있기 때문에 보다 빠르게 찾을 수 있다.
  - 단 입력,변경,삭제할 때마다 인덱스를 갱신해야하기때문에
  - 입력,변경,삭제를 사용할땐 인덱스 컬럼은 좋지 않다.
- 조회 위주의 작업을 하는 테이블을 사용할 때 사용하면 좋다.

## 컬럼 값 자동 증가
- 숫자 타입의 PK컬럼, Unique 컬럼은 자동으로 값을 1씩 증가시킬 수 있다.
- 단 삭제를 통해 중간에 있는 데이터는 채우지 않고 계속 증가된다.
- 숫자는 테이블 맨마지막에 있는 숫자부터 1씩 증가한다.
- Primary key, Unique 밖에 사용하지 못한다.
- PK 또는 unique컬럼이 지정된 후에 증가시킬 수 있다. 
```
ex)
alter table test1
  modify column no int not null auto_increment;
```

## View 뷰
- 조회 결과를 테이블처럼 사용하는 문법이다.
- select 문장이 복잡할 때 사용한다.
```
조회 결과를 위한 가상테이블 만들기
create view 가상테이블 이름
  as select 컬럼명,컬럼명.. from 테이블이름 where 가상테이블='값';

조회할 때
select * from 가상테이블명;

뷰를 삭제할 때
drop view 가상테이블명;
- 가상테이블이기때문에 테이블이 아니라 view이다.
```

# DML
- 데이터 등록, 변경, 삭제를 다루는 SQL 문법

## Update
- update 테이블명 set 컬럼명=값, 컬럼명=값... where 조건..;
- ex) update test1 set pstno='11111', fax='222' where no=3;
- 주의! 조건을 지정하지 않으면, 모든 데이터가 변경된다.

## delete
- delete from 테이블명 where 조건;
- ex) delete from test1 where no=2 or no=3;
- 주의 ! 조건을 지정하지 않으면, 모든 데이터가 변경된다.

## autocommit
- mysql은 autocommit의 기본 값이 true이다.
- 명령창에서 실행하면 바로 테이블에 적용된다.
- 이러면 잘못 실행한 데이터도 바로 적용되기 때문에   
다시 원상복구가 어렵다
- 이럴땐 autocommit을 false로 설정하여 수동처리해라
```
set autocommit=false;

작업 수행 후 commit을 실행하면 지금까지의 작업 내용이 테이블에 적용된다. 
commit; 

마지막 commit 상태로 되돌고 싶다면 롤백 시키면된다.
rollback;
```


# DQL
- 데이터를 조회할 때 사용하는 문법

## select
- 테이블을 조회할 때 사용하는 명령어이다.
- ex) select  * from 테이블;

## 프로젝션(projection) ==> 특정 컬럼 값 조회
- select 컬럼명, 컬럼명 from 테이블;

## 조회하는 컬럼에 별명 붙이기
- 별명을 붙이지 않으면 원래의 컬럼명이 조회 결과의 컬럼이름으로 사용된다.
- 복잡한 컬럼이름이라면 조회하기도 어렵다
-  select 컬럼명 as 별명...
- ex) select name 

## 셀렉션(Selection) ==> 조회할 때 조건을 지정하는 것
- where절과 연사자를 이요하여 조회 조건을 지정할 수 있다.
- select ... from ... where 조건..
- ex) select * from test1 where no > 5;

## 프로젝션 , 셀렉션
### where절을 통해 결과 데이터를 먼저 선택(selection)한 다음   
### 결과 데이터에서 가져올 컬럼을 선택(projection)한다.

# FK(Foreign Key)
- 다른 테이블의 PK를 참조하는 컬럼이다.
- 다른 테이블의 데이터와 연관된 데이터를 저장할 때 무효한 데이터가 입력되지 않도록 제어하는 문법.
- 다른 테이블의 데이터가 참조하는 데이터를 임의의 지우지 못하도록 제어하는 문법이다.
- 그래서 데이터의 무결성(data integrity 결함이 없는 상태)을 유지하게 도와주는 문법이다.
- 문법) alter talbe 테이블명   
        add constraint 제약조건 이름 foregin key (컬럼명) references 테이블명(컬럼명);

## distinct(중복값을 한개만 추출할 때)
- select distinct 컬럼명 from 테이블;

- 두개의 컬럼값
  - select distinct 컬럼명,컬럼명 from 테이블;
  - 컬럼들의 값이 중복된 경우 한개로 간주

# order by
1. 기본 인덱스 컬럼 기준 정렬
  - select 컬럼명1, 컬럼명2,컬럼명3 from 테이블명;
    -  1 2 3 순서대로 나온다.

2. 오름차순(ascending) : 오름 차순으로 정렬
  - select 컬럼명1, 컬럼명2, 컬러명 from 테이블명   
    order by 컬럼명3 (asc)
  - 컬럼명 3의 오름차순으로 정렬(a~z)
  - asc는 생략 가능

3. 내림차순(desceding) : 내림 차순으로 정렬
  - select 컬럼명1, 컬럼명2, 컬러명 from 테이블명   
    order by 컬럼명3 desc
  - 컬럼명3의 내림 차순으로 정렬(z~a)

4. 오름 차순, 내림차순 둘다 사용
- select 컬럼명1, 컬럼명2, 컬러명 from 테이블명   
    order by 컬럼명1(asc) , 컬럼명3 desc;

# 실행 순서
- 실행 순서: from -> where -> select -> order by
- 1) from 또는 join : 테이블의 전체 데이터 또는 조인 데이터 
- 2) where : 조건에 따라 결과로 뽑을 데이터를 selection 한다.
- 3) group by : 조건에 따라 뽑은 데이터를 특정 컬럼을 기준으로 데이터를 묶는다.
- 4) having : 그룹으로 묶은 데이터를 조건에 따라 선별한다.
- 5) select : 최종 결과로 뽑을 컬럼을 표시(projection)한다. 표현식으로 계산한 컬럼도 포함시킨다.
- 6) order by : select 절에서 추가한 임의 컬럼이나 테이블 컬럼을 기준으로 정렬한다.
- 7) limit : 결과 데이터에서 지정한 범위의 데이터를 선택한다.
- 8) 결과 추출: 7번을 수행한 결과 데이터에서 5번에 표시된 컬럼만 추출한다.

# ad로 컬럼에 별명(라벨명) 붙이기
- 라벨명을 지정하지 않으면 컬럼명이 라벨명이 된다.
- 문법) select 컬럼명1 (as) 라벨명1, 컬럼명2 (as) 라벨명2, 컬럼명3 from 테이블명
  - 출력했을 때 라벨명1, 라벨명2, 컬럼명3으로 출력된다.
  - as는 생략 가능

# count를 사용하여 데이터 카운트하기
- 문법) select count(컬럼명) 라벨명   
  from 테이블명;
    - 테이블안 컬럼에 몇개가 있는지 개수가 세진다.
    - count안 컬럼명을 집어넣으면 null이 아닌 데이터만 카운트한다.

- where절(조건) 사용가능
- 문법) select count(컬럼명) 라벨명   
  from 테이블명;   
  where 컬럼명 = '조건';
  - 테이블 안 컬럼안의 조건의 개수를 라벨명으로 출력하라.

# union 과 union all
## union : 중복값 자동제거
- select 결과 합치기
- union : 중복 값 자동 제거*/
```
select distinct 컬럼명 from 테이블명
union
select distinct 컬럼명 from 테이블명;
```

## union all : 중복 값 제거 안함
```
select distinct 컬럼명 from 테이블명
union all
select distinct 컬럼명 from 테이블명;
```

# 조인
- 서로 관련된 테이블의 데이터를 연결하여 추출하는 방법
- 기법 
1) CROSS 조인(=Cartesian product)
2) NATURAL 조인
3) JOIN ~ USING(컬럼명)
4) JOIN ~ ON
5) OUTER JOIN

## Cross 조인(Cartesian product) 
- 두 테이블의 데이터를 1:1로 모두 연결한다.
  - 두 테이블의 같은 컬럼명이 있다면   
  select를 할 때 컬럼명을 구분하지 않으면 어떤것 인지 알수가 없다.

  - 구분을 위해 컬럼명 앞에 테이블명을 적어라
  - ex) 테이블명.컬럼명
  - 하지만 테이블명이 너무 길수도 있기 때문에 라벨명을 지정해서 붙인다.
    - ex) 라벨명.컬럼명