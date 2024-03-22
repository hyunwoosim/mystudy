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

