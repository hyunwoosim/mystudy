-- 대회 정보
-- Competition
--cno 대회번호(pk)
-- prom promoter 주최자
-- nop Number of people 모집인원
-- cdt competition daytime 대회 당일
-- clo Competition location 대회장소
-- cf Competition fee 대회참가비
-- cpn Competition phone number 대회전화번호
-- edt end day time   마감일
-- sno Stadium number 경기장 번호 (fk)

drop table c_info

create table c_info(
cno  int not null,
titl varchar(255) not null,
rule text not null,
prom int not null,
nop int not null,
cdt datetime not null,
clo varchar(255) not null,
cf int not null,
cpn int not null,
edt datetime not null,
sno int not null
);

alter table c_info
 add constraint primary key (con),
 modify column c_info int not null auto_increment,
 add constraint c_info_fk foreign key (sno) references stadium(sno);

-- 대회 신청
-- afc Apply for competition 대회신청
-- acno 신청 번호(pk)
--cno 대회번호 (fk, index)
--ap  Applicant number 신청자번호 (fk, index)
-- adt 신청일
-- stat status 상태

create table afc(
acno  int not null,
cno int not null,
ap int not null,
adt datetime null default now(),
stat char(1) not null
);

alter table afc
 add constraint primary key (acno),
 modify column acno int not null auto_increment,
 add constraint afc_fk foreign key (cno) references c_info(cno),
 add fulltext index afe_cno_idx (cno);

-- 경기장
-- Stadium 경기장
-- sno 경기장 번호(pk)
-- sname 경기장이름 (Unique)
create table stadium(
sno int not null;
sname varchar(50) not null
);

alter table stadium
 add constraint primary key (sno),
 modify column sno int not null auto_increment,
 add constraint sname stadium_uk unique (sanme);