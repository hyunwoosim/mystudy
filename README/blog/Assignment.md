# 과제 CRUD 구현하기 24.02.02

- 주제 : 주짓수 대회 신청 시스템
  - sql과 인텔리 제이를 사용해서 만들기

1. 테이블 생성
  - 테이블 명 jjmember
  - 컬럼 : belt, name, age, weight, team
- 5가지로 구성하였다.
```
create table jjmember (
no int primary key auto_increment,
belt varchar(50) not null,
name varchar(50) not null,
age int not null,
weight int not null,
team varchar(50) default '무소속'
);
	
```
- no를 프라이머리 키로 지정하고 자동으로 값 증가를 시켰다.
- 팀은 없을 수 도 있기 때문에 default 값으로 '무소속'을 두었다.

2. 값 집어 넣기
```
insert into jjmember(belt,name,age,weight,team) 	
  values('white','kim',20,60,'qwe');
insert into jjmember(belt,name,age,weight,team) 	
  values('blue','sim',20,70,'abc');
insert into jjmember(belt,name,age,weight,team) 	
  values('purple','lim',30,90,'cc');
insert into jjmember(belt,name,age,weight,team) 	
  values('brown','park',40,50,'tt');
insert into jjmember(belt,name,age,weight,team) 	
  values('black','lee',50,80,'oo');
insert into jjmember(belt,name,age,weight) 
	values('black','ku',25,'56');
```
- 여기서 첫 번째 문제가 생겼다.
- 값이 들어가지 않고 error가 계속 뜨는 것이다. 
- 이유는 문자 값에 ('')작은 따옴표를 붙이지 않아서이다.
  - **sql에서는 문자열입력은 ('')작은 따옴표안에 넣어야한다.**

3. 컬럼명 타입 변경
- wight을 숫자로 적으니 너무 많은 종류의 값이 들어와 분류가 어렵다
- 그래서 처음부터 값을 문자열로 바꾸기로 결정
- 더 쉽게 조회가 가능하기 때문에 바꿨다.
```
alter table jjmember
modify column weight varchar(50);
```
- 체급은 5등급으로 나눴다.
  - fly,feather,light,middle,heavy

4. 그 후 다시 업데이트를 하였다
```
update jjmember set weight='middle' where no=1;
update jjmember set weight='feather' where no=2;
update jjmember set weight='light' where no=3;
update jjmember set weight='fly' where no=4;
update jjmember set weight='middle' where no=5;
update jjmember set weight='heavy' where no=6;
```
5. 생각해보니 신청일도 있어야해서 신청일 추가
- 하나하나 치기보단 자동으로 그 날을 저장할 수 있는 기능을 넣고 싶어 찾아봤다.
- 바로 current_date()문을 쓰면된다.
```
alter table jjmember
   add column jd date default current_date();
```
- 하지만 error가 계속 떴다 분명 제대로 적었는데 챗 gpt에게도 물어보고 했지만 실패
- 강사님도 잘 모르셨다 그래서 강사님과 함께 mysql documentation을 찾아봤다.
- 거기에 정답이 있었다.
```
alter table jjmember
   add column jd date default (current_date);
```
- 바로 ()괄호 안에 current_date를 넣으면 되는것이다.
- **(current_date)** 잘 기억하자
- 자동으로 날짜도 추가되었다.
- sql은 끝

6. 인텔리 제이 코드 copy & paste, 맞춰서 수정하기
  - 만들어뒀던걸 수정것이기때문에 간단할줄 알았지만
  - 하지만 생각보다 어려웠다

7.  제일 어려웠던 부분
- sql에서 default 값을 지정했던 '무소속'이 인텔리제이에서는 실행이 안되는 것이었다.
- 인텔리제에서 따로 코드를 만들어서 실행 해야 했던 것이다.

- 문제점 공백을 주면 '무소속'으로 값이 저장되어야 하는데
- 공백이 값으로 저장되었다.
- **해결방법**
```
   "insert into jjmember(belt,name,age,weight,team) values('%s','%s','%s','%s','%s')",
          member.getBelt(), member.getName(), member.getAge(),member.getWeight(),
          (member.getTeam().length() > 0) ? member.getTeam(): "무소속"));
```
- 팀에 값을 저장하는 부분에 삼항연산자를 사용하여 문자열의 길이가 0보다 작으면
- 무소속 이라는 값이 지정되게 만들었다

- **삼항연산자**
```
(조건식) ? (값 또는 연산식) : (값 또는 연산식)
			          true		         false

```

- 이로써 모든 문제를 해결하고 정상적인 실행이 완료되었다.

## 느낀점
- copy & paste를 해서 수정을 한거지만 생각보다 시간이 많이 걸렸다
- 생각보다 막히는 부분이 많고 배웠던것들이긴 하지만 막상 사용하려고 하니 
- 생각처럼 쉽지 않았다.
- 삼항연산자 같은 경우 별 생각 없이 넘겼는데 
- 생각보다 많이 유용하다. 쫌 더 기본적인 부분을 많이 연습해야할 듯.

- 다음엔 EXRD를 사용하여 구체적으로 만들어 봐야겠다 무턱대고 만드니
- 하나 만들기는 쉬웠지만 그 뒤로 다른 테이블과 join하기도 어렵고 공통부분을 만들기 어려웠다.
- 구체적으로 그림을 그리고 만들자
- 2024.02.02