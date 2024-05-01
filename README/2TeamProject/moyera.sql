-- 모여라 샘플 데이터--

--댓글--
Insert into comments(content, created_at, user_no, post_no) 
values(’댓글내용입니다1’,2024-01-01,1,1);
Insert into comments(content, created_at, user_no, post_no) 
values(’댓글내용입니다2’,2024-02-01,2,2);
Insert into comments(content, created_at, user_no, post_no) 
values(’댓글내용입니다3’,2024-03-01,3,2);
Insert into comments(content, created_at, user_no, post_no) 
values(’댓글내용입니다4’,2024-04-01,2,3);
Insert into comments(content, created_at, user_no, post_no) 
values(’댓글내용입니다5’,2024-05-01,4,1);

-- 일정--
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set)
values (1, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', 2024-05-09,2024-01-01,2024-01-10,11,0,test1);
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set)
values (1, 2, '야구모임', 1, '재밌는 야구하실 분 모집', '비트야구장', 2024-04-09,2024-02-1,2024-02-10,9,1,test2);
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set)
values (2, 3, '등산모임', 0, '재밌는 등산하실 분 모집', '비트산', 2024-06-09,2024-03-01,2024-03-10,11,0,test3);
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set)
values (3, 4, '공부모임', 1, '재밌는 공부하실 분 모집', '비트스터디', 2024-07-09,2024-06-01,2024-06-10,11,0,test4);
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set)
values (4, 5, '농구모임', 0, '재밌는 농구하실 분 모집', '비트농구장', 2024-08-09,2024-07-01,2024-0-10,11,0,test5);

-- 일정 참여 멤버 --
insert into class_users
(user_no, school_no, class_no) values (1, 1, 1);
insert into class_users
(user_no, school_no, class_no) values (2, 1, 2);
insert into class_users
(user_no, school_no, class_no) values (3, 2, 1);
insert into class_users
(user_no, school_no, class_no) values (4, 2, 2);
insert into class_users
(user_no, school_no, class_no) values (5, 3, 1);


--게시글 상세페이지
select
p.post_no,
p.title,
p.content,
f.file_no,
f.name,
f.path,
(select count(*) from likes as l where p.post_no = l.post_no),
c.user_no,
c.comment_no,
c.content,
c.created_at
from posts as p
left outer join comments as c on p.post_no = c.post_no
left outer join files as f on p.post_no = f.post_no
inner join school_users as s on c.user_no = s.user_no
where p.post_no = 3 and p.category_no=4 order by c.created_at asc;
--약속 상세페이지
select * from classes as c left outer join
class_users as u on c.class_no = u.class_no where c.class_no=2;

-- 유저 구매내역


-- 개인 구매내역
select
u.user_no,
u.name,
u.phone,
u.email,
u.nickname,
u.grade,
p.price,
p.purchase_at,
p.payment_type,
p.vigo,
p.expiration_date
from purchases as p left outer join users as u on p.user_no=u.user_no
where u.user_no =1
order by u.user_no desc;


-- 단체 구매내역(left join)
select
u.user_no,
u.name,
u.phone,
u.email,
u.nickname,
u.grade,
p.price,
p.purchase_at,
p.payment_type,
p.vigo,
p.expiration_date
from purchases as p left outer join users as u on p.user_no=u.user_no
order by u.user_no desc;

-- 단체 구매내역(join)
select
u.user_no,
u.name,
u.phone,
u.email,
u.nickname,
u.grade,
p.price,
p.purchase_at,
p.payment_type,
p.vigo,
p.expiration_date
from users as u, purchases as p where u.user_no = p.user_no
order by u.user_no desc;

-- 유저 등급 보기
select 
u.user_no,
u.name,
u.email,
g.name
from users as u inner join
school_users as s on u.user_no = s.user_no
inner join 
grades as g on s.grade_no = g.grade_no
where s.school_no = 1;

-- 스쿨 채팅
select
s.school_no,
u.user_no,
u.nickname,
g.message,
g.created_at,
g.photo
from users as u inner join
school_users as s on u.user_no = s.user_no
inner join
gm as g on g.school_no = s.school_no
where s.school_no = 1;

-- 스쿨채팅 스쿨번호, 유저번호 안나오는거
select
u.nickname,
g.message,
g.created_at,
g.photo
from users as u inner join
school_users as s on u.user_no = s.user_no
inner join
gm as g on g.school_no = s.school_no
where s.school_no = 1;


-- 스쿨 일정 상셍보기
select
c.class_no,
u.name,
c.name,
c.photo,
c.content,
c.location,
c.now_at,
c.created_at,
c.ended_at,
c.member,
c.repeat_set
from classes as c inner join
school_users as s on s.school_no = c.school_no
inner join 
users as u on u.user_no = s.user_no
where s.school_no =1 and u.user_no =2;

-- 메인페이지 스쿨 일정 보기
select
c.class_no,
c.name,
u.name,
c.photo,
c.content,
c.location,
c.member,
c.repeat_set,
date_format(c.now_at, '%y-%m-%d'),
date_format(c.created_at, '%y-%m-%d'),
date_format(c.ended_at, '%y-%m-%d'),
concat(counter, '/', total)
from classes as c inner join
school_users as s on s.school_no = c.school_no
inner join 
users as u on u.user_no = s.user_no
from(select
@counter := @counter + 1 as counter,
(select count(*) from class_users) as total
 from class_users
 cross join (select @counter : 0) as init) as counts
where s.school_no =1 and u.user_no =2;


SELECT
    c.class_no,
    c.name,
    u.name,
    c.photo,
    c.content,
    c.location,
    c.member,
    c.repeat_set,
    DATE_FORMAT(c.now_at, '%y-%m-%d') AS formatted_now_at,
    DATE_FORMAT(c.created_at, '%y-%m-%d') AS formatted_created_at,
    DATE_FORMAT(c.ended_at, '%y-%m-%d') AS formatted_ended_at,
    CONCAT(counter, '/', total) AS count_format
FROM
    classes AS c
INNER JOIN
    school_users AS s ON s.school_no = c.school_no
INNER JOIN
    users AS u ON u.user_no = s.user_no
CROSS JOIN (
    SELECT
        @counter := @counter + 1 AS counter,
        (SELECT COUNT(*) FROM c.member) AS total
    FROM
        class_users as cu
    CROSS JOIN (SELECT @counter := 0) AS init
) AS counts
WHERE
    s.school_no = 1
    AND u.user_no = 2
  and c.class_no =1;





SELECT
    c.class_no,
    c.name,
    u.name,
    c.photo,
    c.content,
    c.location,
    c.member,
    c.repeat_set,
    DATE_FORMAT(c.now_at, '%y-%m-%d') AS formatted_now_at,
    DATE_FORMAT(c.created_at, '%y-%m-%d') AS formatted_created_at,
    DATE_FORMAT(c.ended_at, '%y-%m-%d') AS formatted_ended_at,
    CONCAT(counter, '/', total) AS count_format
FROM
    classes AS c
INNER JOIN
    school_users AS s ON s.school_no = c.school_no
INNER JOIN
    users AS u ON u.user_no = s.user_no
CROSS JOIN (
    SELECT
        @counter := @counter + 1 AS counter,
        (SELECT COUNT(*) FROM class_users WHERE cu.class_no = c.class_no) AS total
    FROM
        class_users AS cu
    CROSS JOIN (SELECT @counter := 0) AS init
) AS counts
WHERE
    s.school_no = 1
    AND u.user_no = 2
    AND c.class_no = 1;


SELECT
    c.class_no,
    c.school_no,
    c.name,
    u.name AS user_name,
    c.photo,
    c.content,
    c.location,
    c.member,
    c.repeat_set,
    DATE_FORMAT(c.created_at, '%y-%m-%d') AS formatted_created_at,
    DATE_FORMAT(c.start_at, '%y-%m-%d') AS formatted_start_at,
    DATE_FORMAT(c.ended_at, '%y-%m-%d') AS formatted_ended_at,
    CONCAT(cu.user_no,'/', total_members) AS count_format
FROM
    school_classes AS c
INNER JOIN
    school_users AS su ON su.school_no = c.school_no
INNER JOIN
    users AS u ON u.user_no = su.user_no
LEFT JOIN (
    SELECT
        class_no,
        COUNT(*) AS total_members
    FROM
        class_users
    GROUP BY
        class_no
) AS cu ON cu.class_no = c.class_no
WHERE
    c.class_no = 1;




--------


  SELECT
      cu.class_no,
      c.name,
      u.name,
      c.photo,
      c.content,
      c.location,
      c.member,
      c.repeat_set,
      DATE_FORMAT(c.now_at, '%y-%m-%d') AS formatted_now_at,
      DATE_FORMAT(c.created_at, '%y-%m-%d') AS formatted_created_at,
      DATE_FORMAT(c.ended_at, '%y-%m-%d') AS formatted_ended_at
  FROM
      classes AS c
  INNER JOIN
      class_users as cu ON cu.school_no = c.school_no
       inner join 
      users as u on cu.user_no = u.user_no
  WHERE
      c.class_no = 6
      and
      c.school_no = 2;


    
CONCAT((SELECT COUNT(*) FROM class_users as cu WHERE cu.class_no = c.class_no), '/', c.member) AS count_format

-- 회원 태그 
select 
u.user_no






insert into gm(school_no, user_no, message, created_at, photo)
values(1, 1, '실시간채팅','2024-01-01 10:00:00','photo');
insert into gm(school_no, user_no, message, created_at, photo)
values(1, 2, '하이','2024-01-01 10:00:01','photo2');
insert into gm(school_no, user_no, message, created_at, photo)
values(2, 1, '바이','2024-01-01 10:00:01','photo3');
insert into gm(school_no, user_no, message, created_at, photo)
values(1, 3, '안녕','2024-01-01 10:00:02','photo4');
insert into gm(school_no, user_no, message, created_at, photo)
values(4, 4, '잘가' ,'2024-01-01 10:00:01','photo5');
insert into gm(school_no, user_no, message, created_at, photo)
values(5, 5, '가나다','2024-01-01 10:00:02','photo6');
insert into gm(school_no, user_no, message, created_at, photo)
values(6, 6, '마바사','2024-01-01 10:00:03','photo7');
insert into gm(school_no, user_no, message, created_at, photo)
values(7, 7, '쿠쿠쿠','2024-01-01 10:00:04','photo8');


insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('김김김', '123456', '제주도', 
'010-4444-3333', 'qwer@naver.com', 
'qwr', '20241129',1,0,0,'2024-02-01','qwer',40,'test');
insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('강강강', '123456', '제부도', 
'010-2222-4444', 'asdf@naver.com', 
'asdf', '20240129',1,0,0,'2024-03-01','asdf',10,'test');
insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('영영영', '123456', '마파도', 
'010-0000-9999', 'zxcv@naver.com', 
'zxcv', '20240202',1,0,0,'2024-04-01','zxcv',15,'test');


insert into school_users
(user_no, school_no, grade_no,created_at) 
values(4,4,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(5,5,1,'2024-02-03');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(6,6,1,'2024-03-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(7,7,2,'2024-01-01');

insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school6', '이것은 스쿨입니다6', 30,'test1',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school7', '이것은 스쿨입니다7', 50,'test2',1);








drop table if exists users restrict;
drop table if exists comments restrict;
drop table if exists likes restrict;
drop table if exists logs restrict;
drop table if exists schools restrict;
drop table if exists tags restrict;
drop table if exists member_tags restrict;
drop table if exists school_users restrict;
drop table if exists tokens restrict;
drop table if exists categories restrict;
drop table if exists classes restrict;
drop table if exists class_users restrict;
drop table if exists school_tags restrict;
drop table if exists logIndexes restrict;
drop table if exists purchases restrict;
drop table if exists grades restrict;
drop table if exists follows restrict;
drop table if exists dm restrict;
drop table if exists gm restrict;
drop table if exists files restrict;
drop table if exists alerts restrict;
drop table if exists posts restrict;




insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('가가가', '123456', '충청남도 보령시', 
'010-3245-1391', 'rlatmdcjf10@naver.com', 
'fkfkfkfk', '20241119',0,0,0,'2024-01-01','asdewfssdfdsfdsfd',36,'test');

insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('김승철', '123456', '충청남도 익산시', 
'010-3245-1321', 'godstoryyy@naver.com', 
'fkfkfkfeewfk', '20231119',0,0,0,'2023-05-01','asdewfssdfdwefewfewfsfdsfd',37,'test2');

insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('임꺽정', '123456', '충청남도 아산시', 
'010-3245-1321', 'aaa@test.com', 
'fkfkfkfefk', '20231119',0,0,0,'2023-05-01','asdewfssdfdwefewfewfsfdsfd',37,'test3');

insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('유관순', '123456', '충청남도 천안시', 
'010-3245-1321', 'aaa2@test.com', 
'fkfkfkfewfewfk', '20231119',0,0,0,'2023-05-01','asdewfssdfdwefewfewfsfdsfd',37,'test4');

insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('이순신', '123456', '충청남도 공주시', 
'010-3245-1321', 'aaa3@test.com', 
'kfkfewfewfk', '20231119',0,0,0,'2023-05-01','asdewfssdfdwefewfewfsfdsfd',37,'test5');



insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school1', '이것은 스쿨입니다1', 30,'test1',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school2', '이것은 스쿨입니다2', 30,'test2',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school3', '이것은 스쿨입니다3', 30,'test3',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school4', '이것은 스쿨입니다4', 30,'test4',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school5', '이것은 스쿨입니다5', 30,'test5',1);



insert into grades
(name) values ('블랙리스트');
insert into grades
(name) values ('회원');
insert into grades
(name) values ('부매니저');
insert into grades
(name) values ('매니저');


insert into school_users
(user_no, school_no, grade_no,created_at) 
values(5,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(6,2,2,'2024-01-03');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(7,2,3,'2024-01-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(8,2,2,'2024-01-01');


insert into tags
(name) values ('외식');
insert into tags
(name) values ('운동');
insert into tags
(name) values ('피크닉');
insert into tags
(name) values ('술');

insert into school_tags 
(tag_no, school_no) values (1,1);
insert into school_tags 
(tag_no, school_no) values (1,2);
insert into school_tags 
(tag_no, school_no) values (1,3);
insert into school_tags 
(tag_no, school_no) values (2,1);
insert into school_tags
(tag_no, school_no) values (3,1);


insert into member_tags
(user_no, tag_no) values (1,1);
insert into member_tags
(user_no, tag_no) values (1,2);
insert into member_tags
(user_no, tag_no) values (1,3);
insert into member_tags
(user_no, tag_no) values (2,1);
insert into member_tags
(user_no, tag_no) values (3,1);


  insert into logIndexes
  (name) values ('글쓰기');
  insert into logIndexes
  (name) values ('좋아요');
  insert into logIndexes
  (name) values ('스쿨가입');


insert into categories
(name) values ('번개');
insert into categories
(name) values ('정모');
insert into categories
(name) values ('공지');
insert into categories
(name) values ('게시판');




insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (1, 1, 4, '타이틀입니다1', '번개 내용입니다1', '2023-04-01');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (1, 1, 4, '타이틀입니다2', '번개 내용입니다2', '2024-01-01');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (2, 1, 4, '1번과 다른 스쿨의 타이틀입니다1', '1번과 다른 스쿨의 번개 내용입니다1', '2024-01-04');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (3, 1, 1, '3번 스쿨 타이틀입니다1', '3번 스쿨 번개 내용입니다1', '2024-02-01');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (1, 2, 1, '1번과 다른 유저 타이틀입니다1', '1번과 다른 유저 번개 내용입니다1', '2024-03-01');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (1, 3, 1, '1번과 또 다른 유저 타이틀입니다1', '1번과 또 다른 유저 번개 내용입니다1', '2024-04-01');
insert into posts
(school_no, user_no, category_no, title, content, created_at)
values (1, 1, 1, '타이틀입니다1', '정모 내용입니다1', '2024-03-21');


insert into files(post_no,name,path,size,created_at,type)
  values(1,'가가가','test1','100','2023-05-01','jgp');
insert into files(post_no,name,path,size,created_at,type)
  values(1,'임꺽정','test2','100','2023-05-01','jgp');
insert into files(post_no,name,path,size,created_at,type)
  values(1,'이순신','test3','100','2023-05-01','jgp');


Insert into comments(content, created_at, user_no, post_no)
values('댓글내용입니다1','2024-01-01',1,1);
Insert into comments(content, created_at, user_no, post_no)
values('댓글내용입니다2','2024-02-01',2,4);
Insert into comments(content, created_at, user_no, post_no)
values('댓글내용입니다3','2024-03-01',3,3);
Insert into comments(content, created_at, user_no, post_no)
values('댓글내용입니다4','2024-04-01',2,2);
Insert into comments(content, created_at, user_no, post_no)
values('댓글내용입니다5','2024-05-01',4,2);


insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (1, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-05-09','2024-01-01','2024-01-10',11,0,'test1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (1, 1, '야구모임', 1, '재밌는 야구하실 분 모집', '비트야구장', '2024-04-09','2024-02-01','2024-02-10',9,1,'test2');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (1, 1, '등산모임', 0, '재밌는 등산하실 분 모집', '비트산', '2024-06-09','2024-03-01','2024-03-10',11,0,'test3');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (1, 1, '공부모임', 1, '재밌는 공부하실 분 모집', '비트스터디', '2024-03-23','2024-06-01','2024-06-10',11,0,'test4');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (1, 1, '농구모임', 0, '재밌는 농구하실 분 모집', '비트농구장', '2024-08-09','2024-07-01','2024-10-10',11,0,'test5');


insert into class_users
(user_no, school_no, class_no) values (1, 1, 1);
insert into class_users
(user_no, school_no, class_no) values (2, 1, 2);
insert into class_users
(user_no, school_no, class_no) values (3, 1, 2);
insert into class_users
(user_no, school_no, class_no) values (1, 2, 2);
insert into class_users
(user_no, school_no, class_no) values (3, 1, 1);


insert into likes(user_no,post_no)
  values(1,1);
insert into likes(user_no,post_no)
  values(1,2);
insert into likes(user_no,post_no)
  values(2,1);

insert into follows(user_no2,user_no)
  values(1,1);
insert into follows(user_no2,user_no)
  values(1,2);
insert into follows(user_no2,user_no)
  values(2,1);

insert into logs(action_no,user_no,created_at)
  values(1,1,'2023-05-01');
insert into logs(action_no,user_no,created_at)
  values(2,1,'2023-05-01');
insert into logs(action_no,user_no,created_at)
  values(3,2,'2023-05-01');

insert into purchases(purchase_no, user_no, price, purchase_at, payment_type, expiration_date)
	values(1, 1, 100000, '2023-10-01', 'kakao_pay', '2024-10-01');
insert into purchases(purchase_no, user_no, price, purchase_at, payment_type, expiration_date)
	values(2, 2, 100000, '2023-11-01', 'card', '2024-11-01');
insert into purchases(purchase_no, user_no, price, purchase_at, payment_type, expiration_date)
	values(3, 3, 100000, '2023-11-10', 'naver_pay', '2024-11-10');
insert into purchases(purchase_no, user_no, price, purchase_at, payment_type, expiration_date)
	values(4, 4, 100000, '2023-12-01', 'card', '2024-12-01');
insert into purchases(purchase_no, user_no, price, purchase_at, payment_type, expiration_date)
	values(5, 5, 100000, '2023-12-15', 'kakao_pay', '2024-12-15');
    

insert into alerts(alert_no, user_no, name, type, content, created_at, is_read, redirect_path)
	values(1, 1, '댓글이 등록되었습니다.', 1, '안녕하세요', '2023-10-01', 0, '1');
insert into alerts(alert_no, user_no, name, type, content, created_at, is_read, redirect_path)
	values(2, 2, '회원님의 프로필을 좋아합니다.', 2, '', '2023-10-11', 0, '1');
insert into alerts(alert_no, user_no, name, type, content, created_at, is_read, redirect_path)
	values(3, 3, '스쿨에 가입했습니다.', 3, '', '2023-11-10', 0, '1');
insert into alerts(alert_no, user_no, name, type, content, created_at, is_read, redirect_path)
	values(4, 4, '구독 종료일이 임박했습니다.', 4, '', '2024-11-20', 0, '1');
insert into alerts(alert_no, user_no, name, type, content, created_at, is_read, redirect_path)
	values(5, 1, '일정이 등록되었습니다.', 5, '공부모임', '2024-3-23', 1, '4');
    
    

insert into dm(dm_no, user_no2, user_no, message, created_at)
	values(1, 1 ,2 , '안녕하세요', '2023-10-01 10:00:00');
insert into dm(dm_no, user_no2, user_no, message, created_at)
	values(2, 1 ,2 , '채팅입니다.', '2023-10-01 10:00:01');
insert into dm(dm_no, user_no2, user_no, message, created_at)
	values(3, 2 ,1 , '네. 안녕하세요.', '2023-10-01 10:01:00');
insert into dm(dm_no, user_no2, user_no, message, created_at, photo)
	values(4, 3 ,4 , '우산챙기세요.', '2023-10-01 11:02:01', '/photo/rain.jpg');
insert into dm(dm_no, user_no2, user_no, message, created_at)
	values(5, 4 ,3 , '고맙습니다.', '2023-10-01 11:02:11');
insert into dm(dm_no, user_no2, user_no, message, created_at, photo)
	values(6, 1 ,2 , '아이바오 귀여워.', '2023-10-01 11:03:01', '/photo/aibao.jpg');
insert into dm(dm_no, user_no2, user_no, message, created_at, photo)
	values(7, 2 ,1 , '러바오 귀여워.', '2023-10-01 11:03:10', '/photo/lebao.jpg');
insert into dm(dm_no, user_no2, user_no, message, created_at, photo)
	values(8, 1 ,2 , '바오가족 귀여워.', '2023-10-01 11:03:20', '/photo/baofamily.jpg');



insert into gm(school_no, user_no, message, created_at, photo)
values(1, 1, '실시간채팅','2024-01-01 10:00:00','photo');
insert into gm(school_no, user_no, message, created_at, photo)
values(1, 2, '하이','2024-01-01 10:00:01','photo2');
insert into gm(school_no, user_no, message, created_at, photo)
values(2, 1, '바이','2024-01-01 10:00:01','photo3');
insert into gm(school_no, user_no, message, created_at, photo)
values(1, 3, '안녕','2024-01-01 10:00:02','photo4');
insert into gm(school_no, user_no, message, created_at, photo)
values(4, 4, '잘가' ,'2024-01-01 10:00:01','photo5');
insert into gm(school_no, user_no, message, created_at, photo)
values(5, 5, '가나다','2024-01-01 10:00:02','photo6');
insert into gm(school_no, user_no, message, created_at, photo)
values(6, 6, '마바사','2024-01-01 10:00:03','photo7');
insert into gm(school_no, user_no, message, created_at, photo)
values(7, 7, '쿠쿠쿠','2024-01-01 10:00:04','photo8');


insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('김김김', '123456', '제주도', 
'010-4444-3333', 'qwer@naver.com', 
'qwr', '20241129',1,0,0,'2024-02-01','qwer',40,'test');
insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('강강강', '123456', '제부도', 
'010-2222-4444', 'asdf@naver.com', 
'asdf', '20240129',1,0,0,'2024-03-01','asdf',10,'test');
insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('영영영', '123456', '마파도', 
'010-0000-9999', 'zxcv@naver.com', 
'zxcv', '20240202',1,0,0,'2024-04-01','zxcv',15,'test');


insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school1', '이것은 스쿨입니다1', 30,'test1',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school2', '이것은 스쿨입니다2', 30,'test2',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school3', '이것은 스쿨입니다3', 30,'test3',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school4', '이것은 스쿨입니다4', 30,'test4',1);
insert into schools 
(name, content, limited_man, photo, open_range) 
values ('school5', '이것은 스쿨입니다5', 30,'test5',1);



insert into class_users
(user_no, school_no, class_no)
values(5, 2, 6);
insert into class_users
(user_no, school_no, class_no)
values(6, 2, 6);
insert into class_users
(user_no, school_no, class_no)
values(7, 2, 6);
insert into class_users
(user_no, school_no, class_no)
values(8, 2, 6);



insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');
insert into classes
(school_no, user_no, name, security, content, location, now_at, created_at, ended_at, member, repeat_set,photo)
values (2, 1, '축구모임', 0, '재밌는 축구하실 분 모집', '비트축구장', '2024-03-29','2024-01-01','2024-01-10',11,0,'photo1');






insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('일일일', '12', '제주도', 
'010-1111-1111', 'qwer@naver.com', 
'qwr', '20241129',1,0,0,'2024-02-01','qwer',40,'test');
insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('이이이', '34', '제주도', 
'010-2222-2222', 'asdf@naver.com', 
'asdf', '20241129',1,0,0,'2024-02-01','qwer',40,'test');insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('삼삼삼', '56', '제주도', 
'010-3333-3333', 'zxcv@naver.com', 
'zxcv', '20241129',1,0,0,'2024-02-01','qwer',40,'test');



insert into schools 
(name, content, limited_man, photo, open_range,created_at) 
values ('11111', '이것은 스쿨입니다1', 30,'test1',1,'2024-01-01');
insert into schools 
(name, content, limited_man, photo, open_range,created_at) 
values ('22222', '이것은 스쿨입니다2', 30,'test2',1,'2024-02-02');
insert into schools 
(name, content, limited_man, photo, open_range,created_at) 
values ('3333', '이것은 스쿨입니다3', 30,'test3',1,'2024-03-03');

insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('사사사사', '34', '제주도', 
'010-2222-2222', 'qwerqwer@naver.com', 
'qqqqqqq', '20241129',1,0,0,'2024-02-01','qwer',40,'test');insert into users
(name, pwd, address, phone, email, nickname, birth, 
gender, grade, login_type, created_at, profile, manner_point, photo) 
values('오오오오', '56', '제주도', 
'010-3333-3333', 'asdfasdf@naver.com', 
'wwwwww', '20241129',1,0,0,'2024-02-01','qwer',40,'test');



insert into school_users
(user_no, school_no, grade_no,created_at) 
values(12,1,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(12,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(12,3,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(13,1,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(13,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(13,3,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(14,1,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(14,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(14,3,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(15,1,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(15,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(15,3,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(16,1,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(16,2,1,'2023-04-01');
insert into school_users
(user_no, school_no, grade_no,created_at) 
values(16,3,1,'2023-04-01');


select * from user_no  from school_users where user_no =12;

select 
s.school_no,
s.name,
u.user_no,
u.name,
su.created_at
from 
schools as s
inner join
school_users as su on s.school_no = su.school_no
inner join
users as u on u.user_no = su.user_no
where s.school_no = 3;

select 
s.name,
s.school_no,
u.name,
u.nickname,
su.created_at
from
schools as s 
inner join 
school_users as su on s.school_no = su.school_no
inner join
users as u on u.user_no = su.user_no
where u.user_no = 12;



// 초대하기 


insert into alerts 
(user_no,name, type, content,photo,redirect_path, to_user_no, school_no)
values (#{user_no},#{name},#{type},#{content},#{photo},#{redirect_path},#{to_user_no},#{school_no});


insert into alerts 
(user_no,name, type, content,photo,redirect_path, to_user_no, school_no)
values (1,'test',1,'teset1','qwerqwer','qwerq',3,1);



// 일정 상세보기

select
  sc.class_no,
  sc.school_no,
  sc.user_no,
  sc.name,
  sc.content,
  sc.location,
  sc.location_detail,
  sc.start_at,
  sc.ended_at,
  sc.photo,
  sc.member,
  u.nickname,
  su.level_no,
  l.name as level_name,
  cu.user_no
from
  school_classes as sc
inner join
  users as u on sc.user_no = u.user_no
inner join
  school_users as su on sc.user_no= su.user_no
  and sc.school_no = su.school_no
inner join
  levels as l on su.level_no = l.level_no
inner join
  class_users as cu on sc.class_no = cu.class_no
  and sc.school_no = cu.school_no
where
  sc.class_no = 48;

// 일정 상세보기 최종

SELECT
  sc.class_no,
  sc.school_no,
  sc.user_no,
  sc.name,
  sc.content,
  sc.location,
  sc.location_detail,
  sc.start_at,
  sc.ended_at,
  sc.photo,
  sc.member,
  COUNT(cu.user_no) AS user_count,
  u.user_no,
  u.nickname,
  su.user_no,
  su.level_no,
  l.name AS level_name
FROM
  school_classes AS sc
INNER JOIN
  users AS u ON sc.user_no = u.user_no
INNER JOIN
  school_users AS su ON sc.user_no = su.user_no AND sc.school_no = su.school_no
INNER JOIN
  levels AS l ON su.level_no = l.level_no
INNER JOIN
  class_users AS cu ON sc.class_no = cu.class_no AND sc.school_no = cu.school_no
WHERE
  sc.class_no = 48
GROUP BY
  sc.class_no,
  sc.school_no,
  sc.user_no,
  sc.name,
  sc.content,
  sc.location,
  sc.location_detail,
  sc.start_at,
  sc.ended_at,
  sc.photo,
  sc.member,
  u.nickname,
  su.level_no,
  l.name;
  








  
