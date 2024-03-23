-- 대회신청
DROP TABLE IF EXISTS event_applicants RESTRICT;

-- 대회정보
DROP TABLE IF EXISTS events RESTRICT;

-- 신청자
DROP TABLE IF EXISTS applicants RESTRICT;

-- 벨트
DROP TABLE IF EXISTS beltes RESTRICT;

-- 체급
DROP TABLE IF EXISTS classes RESTRICT;

-- 대회
DROP TABLE IF EXISTS TABLE6 RESTRICT;

-- 대회
DROP TABLE IF EXISTS TABLE7 RESTRICT;

-- 심판
DROP TABLE IF EXISTS referees RESTRICT;

-- 경기장
DROP TABLE IF EXISTS arenas RESTRICT;

-- 심판소속
DROP TABLE IF EXISTS referee_teames RESTRICT;

-- 심판배정
DROP TABLE IF EXISTS referee_assignes RESTRICT;

-- 회원
DROP TABLE IF EXISTS useres RESTRICT;

-- 후원사
DROP TABLE IF EXISTS sponsores RESTRICT;

-- 벨트규칙
DROP TABLE IF EXISTS belt_rules RESTRICT;

-- 팀
DROP TABLE IF EXISTS teames RESTRICT;

-- 대회후원사
DROP TABLE IF EXISTS event_sponsores RESTRICT;

-- 기술
DROP TABLE IF EXISTS skilles RESTRICT;

-- 심판유형
DROP TABLE IF EXISTS referee_types RESTRICT;

-- 대회신청
CREATE TABLE event_applicants (
	event_applicant_no INT      NOT NULL, -- 신청번호
	event_no           INT      NOT NULL, -- 대회번호
	applicant_no       INT      NOT NULL, -- 신청자번호
	created_at         DATETIME NOT NULL, -- 신청일
	status             TINYINT  NOT NULL  -- 신청상태
);

-- 대회신청
ALTER TABLE event_applicants
	ADD CONSTRAINT PK_event_applicants -- 대회신청 기본키
	PRIMARY KEY (
	event_applicant_no -- 신청번호
	);

-- 대회신청 유니크 인덱스
CREATE UNIQUE INDEX UIX_event_applicants
	ON event_applicants ( -- 대회신청
		event_no ASC,     -- 대회번호
		applicant_no ASC  -- 신청자번호
	);

ALTER TABLE event_applicants
	MODIFY COLUMN event_applicant_no INT NOT NULL AUTO_INCREMENT;

-- 대회정보
CREATE TABLE events (
	event_no INT          NOT NULL, -- 대회번호
	arena_no INT          NOT NULL, -- 경기장번호
	name     varchar(30)  NOT NULL, -- 대회명
	rule     MEDIUMTEXT   NOT NULL, -- 경기규칙
	host     varchar(50)  NOT NULL, -- 주최자
	member   INT          NOT NULL, -- 모집인원
	now_at   DATETIME     NOT NULL, -- 대회날짜
	place    VARCHAR(255) NOT NULL, -- 대회장위치
	money    INT          NULL,     -- 참가비
	phone    INT          NOT NULL, -- 전화번호
	ended_at DATETIME     NOT NULL  -- 신청마감일
);

-- 대회정보
ALTER TABLE events
	ADD CONSTRAINT PK_events -- 대회정보 기본키
	PRIMARY KEY (
	event_no -- 대회번호
	);

ALTER TABLE events
	MODIFY COLUMN event_no INT NOT NULL AUTO_INCREMENT;

-- 신청자
CREATE TABLE applicants (
	applicant_no INT NOT NULL, -- 신청자번호
	team_no      INT NULL      -- 소속팀번호
);

-- 신청자
ALTER TABLE applicants
	ADD CONSTRAINT PK_applicants -- 신청자 기본키
	PRIMARY KEY (
	applicant_no -- 신청자번호
	);

ALTER TABLE applicants
	MODIFY COLUMN applicant_no INT NOT NULL AUTO_INCREMENT;

-- 벨트
CREATE TABLE beltes (
	belt_no INT         NOT NULL, -- 벨트번호
	name    VARCHAR(50) NOT NULL  -- 벨트명
);

-- 벨트
ALTER TABLE beltes
	ADD CONSTRAINT PK_beltes -- 벨트 기본키
	PRIMARY KEY (
	belt_no -- 벨트번호
	);

-- 벨트 유니크 인덱스
CREATE UNIQUE INDEX UIX_beltes
	ON beltes ( -- 벨트
		name ASC -- 벨트명
	);

ALTER TABLE beltes
	MODIFY COLUMN belt_no INT NOT NULL AUTO_INCREMENT;

-- 체급
CREATE TABLE classes (
	belt_no INT         NOT NULL, -- 체급번호
	name    VARCHAR(50) NOT NULL  -- 체급명
);

-- 체급
ALTER TABLE classes
	ADD CONSTRAINT PK_classes -- 체급 기본키
	PRIMARY KEY (
	belt_no -- 체급번호
	);

-- 체급 유니크 인덱스
CREATE UNIQUE INDEX UIX_classes
	ON classes ( -- 체급
		name ASC -- 체급명
	);

ALTER TABLE classes
	MODIFY COLUMN belt_no INT NOT NULL AUTO_INCREMENT;

-- 대회
CREATE TABLE TABLE6 (
);

-- 대회
CREATE TABLE TABLE7 (
	event_applicant_no INT NULL -- 신청번호
);

-- 심판
CREATE TABLE referees (
	referee_no INT NOT NULL, -- 심판번호
	team_no    INT NOT NULL, -- 소속번호
	career     INT NOT NULL, -- 경력
	money      INT NOT NULL  -- 심판비
);

-- 심판
ALTER TABLE referees
	ADD CONSTRAINT PK_referees -- 심판 기본키
	PRIMARY KEY (
	referee_no -- 심판번호
	);

ALTER TABLE referees
	MODIFY COLUMN referee_no INT NOT NULL AUTO_INCREMENT;

-- 경기장
CREATE TABLE arenas (
	arena_no INT         NOT NULL, -- 경기장번호
	name     VARCHAR(50) NULL      -- 경기장이름
);

-- 경기장
ALTER TABLE arenas
	ADD CONSTRAINT PK_arenas -- 경기장 기본키
	PRIMARY KEY (
	arena_no -- 경기장번호
	);

-- 경기장 유니크 인덱스
CREATE UNIQUE INDEX UIX_arenas
	ON arenas ( -- 경기장
		name ASC -- 경기장이름
	);

ALTER TABLE arenas
	MODIFY COLUMN arena_no INT NOT NULL AUTO_INCREMENT;

-- 심판소속
CREATE TABLE referee_teames (
	team_no INT         NOT NULL, -- 소속번호
	name    VARCHAR(50) NOT NULL  -- 소속명
);

-- 심판소속
ALTER TABLE referee_teames
	ADD CONSTRAINT PK_referee_teames -- 심판소속 기본키
	PRIMARY KEY (
	team_no -- 소속번호
	);

-- 심판소속 유니크 인덱스
CREATE UNIQUE INDEX UIX_referee_teames
	ON referee_teames ( -- 심판소속
		name ASC -- 소속명
	);

ALTER TABLE referee_teames
	MODIFY COLUMN team_no INT NOT NULL AUTO_INCREMENT;

-- 심판배정
CREATE TABLE referee_assignes (
	event_no   INT NOT NULL, -- 대회번호
	referee_no INT NOT NULL, -- 심판번호
	type_no    INT NOT NULL  -- 심판유형번호
);

-- 심판배정
ALTER TABLE referee_assignes
	ADD CONSTRAINT PK_referee_assignes -- 심판배정 기본키
	PRIMARY KEY (
	event_no,   -- 대회번호
	referee_no  -- 심판번호
	);

ALTER TABLE referee_assignes
	MODIFY COLUMN event_no INT NOT NULL AUTO_INCREMENT;

-- 회원
CREATE TABLE useres (
	user_no INT         NOT NULL, -- 회원번호
	name    VARCHAR(50) NOT NULL, -- 이름
	age     INT         NOT NULL, -- 나이
	gender  TINYINT     NOT NULL, -- 성별
	phone   INT         NULL,     -- 전화번호
	belt_no INT         NOT NULL  -- 벨트번호
);

-- 회원
ALTER TABLE useres
	ADD CONSTRAINT PK_useres -- 회원 기본키
	PRIMARY KEY (
	user_no -- 회원번호
	);

ALTER TABLE useres
	MODIFY COLUMN user_no INT NOT NULL AUTO_INCREMENT;

-- 후원사
CREATE TABLE sponsores (
	sponsor_no INT         NOT NULL, -- 후원사번호
	name       VARCHAR(50) NULL,     -- 후원업체명
	phone      INT         NULL      -- 전화번호
);

-- 후원사
ALTER TABLE sponsores
	ADD CONSTRAINT PK_sponsores -- 후원사 기본키
	PRIMARY KEY (
	sponsor_no -- 후원사번호
	);

ALTER TABLE sponsores
	MODIFY COLUMN sponsor_no INT NOT NULL AUTO_INCREMENT;

-- 벨트규칙
CREATE TABLE belt_rules (
	rule_no INT NOT NULL, -- 기술번호
	belt_no INT NOT NULL  -- 벨트번호
);

-- 벨트규칙
ALTER TABLE belt_rules
	ADD CONSTRAINT PK_belt_rules -- 벨트규칙 기본키
	PRIMARY KEY (
	rule_no, -- 기술번호
	belt_no  -- 벨트번호
	);

ALTER TABLE belt_rules
	MODIFY COLUMN rule_no INT NOT NULL AUTO_INCREMENT;

-- 팀
CREATE TABLE teames (
	team_no INT         NOT NULL, -- 팀번호
	name    VARCHAR(50) NOT NULL  -- 팀명
);

-- 팀
ALTER TABLE teames
	ADD CONSTRAINT PK_teames -- 팀 기본키
	PRIMARY KEY (
	team_no -- 팀번호
	);

-- 팀 유니크 인덱스
CREATE UNIQUE INDEX UIX_teames
	ON teames ( -- 팀
		name ASC -- 팀명
	);

ALTER TABLE teames
	MODIFY COLUMN team_no INT NOT NULL AUTO_INCREMENT;

-- 대회후원사
CREATE TABLE event_sponsores (
	event_sponsor_no INT        NOT NULL, -- 후원사번호
	event_no         INT        NOT NULL, -- 대회번호
	content          MEDIUMTEXT NULL      -- 후원내용
);

-- 대회후원사
ALTER TABLE event_sponsores
	ADD CONSTRAINT PK_event_sponsores -- 대회후원사 기본키
	PRIMARY KEY (
	event_sponsor_no, -- 후원사번호
	event_no          -- 대회번호
	);

ALTER TABLE event_sponsores
	MODIFY COLUMN event_sponsor_no INT NOT NULL AUTO_INCREMENT;

-- 기술
CREATE TABLE skilles (
	skill_no INT         NOT NULL, -- 기술번호
	name     VARCHAR(50) NOT NULL  -- 기술명
);

-- 기술
ALTER TABLE skilles
	ADD CONSTRAINT PK_skilles -- 기술 기본키
	PRIMARY KEY (
	skill_no -- 기술번호
	);

-- 기술 유니크 인덱스
CREATE UNIQUE INDEX UIX_skilles
	ON skilles ( -- 기술
		name ASC -- 기술명
	);

ALTER TABLE skilles
	MODIFY COLUMN skill_no INT NOT NULL AUTO_INCREMENT;

-- 심판유형
CREATE TABLE referee_types (
	type_no INT         NOT NULL, -- 심판유형번호
	name    VARCHAR(40) NOT NULL  -- 심판유형명
);

-- 심판유형
ALTER TABLE referee_types
	ADD CONSTRAINT PK_referee_types -- 심판유형 기본키
	PRIMARY KEY (
	type_no -- 심판유형번호
	);

-- 심판유형 유니크 인덱스
CREATE UNIQUE INDEX UIX_referee_types
	ON referee_types ( -- 심판유형
		name ASC -- 심판유형명
	);

ALTER TABLE referee_types
	MODIFY COLUMN type_no INT NOT NULL AUTO_INCREMENT;

-- 대회신청
ALTER TABLE event_applicants
	ADD CONSTRAINT FK_events_TO_event_applicants -- 대회정보 -> 대회신청
	FOREIGN KEY (
	event_no -- 대회번호
	)
	REFERENCES events ( -- 대회정보
	event_no -- 대회번호
	);

-- 대회신청
ALTER TABLE event_applicants
	ADD CONSTRAINT FK_applicants_TO_event_applicants -- 신청자 -> 대회신청
	FOREIGN KEY (
	applicant_no -- 신청자번호
	)
	REFERENCES applicants ( -- 신청자
	applicant_no -- 신청자번호
	);

-- 대회정보
ALTER TABLE events
	ADD CONSTRAINT FK_arenas_TO_events -- 경기장 -> 대회정보
	FOREIGN KEY (
	arena_no -- 경기장번호
	)
	REFERENCES arenas ( -- 경기장
	arena_no -- 경기장번호
	);

-- 신청자
ALTER TABLE applicants
	ADD CONSTRAINT FK_useres_TO_applicants -- 회원 -> 신청자
	FOREIGN KEY (
	applicant_no -- 신청자번호
	)
	REFERENCES useres ( -- 회원
	user_no -- 회원번호
	);

-- 신청자
ALTER TABLE applicants
	ADD CONSTRAINT FK_teames_TO_applicants -- 팀 -> 신청자
	FOREIGN KEY (
	team_no -- 소속팀번호
	)
	REFERENCES teames ( -- 팀
	team_no -- 팀번호
	);

-- 체급
ALTER TABLE classes
	ADD CONSTRAINT FK_beltes_TO_classes -- 벨트 -> 체급
	FOREIGN KEY (
	belt_no -- 체급번호
	)
	REFERENCES beltes ( -- 벨트
	belt_no -- 벨트번호
	);

-- 대회
ALTER TABLE TABLE7
	ADD CONSTRAINT FK_event_applicants_TO_TABLE7 -- 대회신청 -> 대회
	FOREIGN KEY (
	event_applicant_no -- 신청번호
	)
	REFERENCES event_applicants ( -- 대회신청
	event_applicant_no -- 신청번호
	);

-- 심판
ALTER TABLE referees
	ADD CONSTRAINT FK_referee_teames_TO_referees -- 심판소속 -> 심판
	FOREIGN KEY (
	team_no -- 소속번호
	)
	REFERENCES referee_teames ( -- 심판소속
	team_no -- 소속번호
	);

-- 심판
ALTER TABLE referees
	ADD CONSTRAINT FK_useres_TO_referees -- 회원 -> 심판
	FOREIGN KEY (
	referee_no -- 심판번호
	)
	REFERENCES useres ( -- 회원
	user_no -- 회원번호
	);

-- 심판배정
ALTER TABLE referee_assignes
	ADD CONSTRAINT FK_referees_TO_referee_assignes -- 심판 -> 심판배정
	FOREIGN KEY (
	referee_no -- 심판번호
	)
	REFERENCES referees ( -- 심판
	referee_no -- 심판번호
	);

-- 심판배정
ALTER TABLE referee_assignes
	ADD CONSTRAINT FK_events_TO_referee_assignes -- 대회정보 -> 심판배정
	FOREIGN KEY (
	event_no -- 대회번호
	)
	REFERENCES events ( -- 대회정보
	event_no -- 대회번호
	);

-- 심판배정
ALTER TABLE referee_assignes
	ADD CONSTRAINT FK_referee_types_TO_referee_assignes -- 심판유형 -> 심판배정
	FOREIGN KEY (
	type_no -- 심판유형번호
	)
	REFERENCES referee_types ( -- 심판유형
	type_no -- 심판유형번호
	);

-- 회원
ALTER TABLE useres
	ADD CONSTRAINT FK_beltes_TO_useres -- 벨트 -> 회원
	FOREIGN KEY (
	belt_no -- 벨트번호
	)
	REFERENCES beltes ( -- 벨트
	belt_no -- 벨트번호
	);

-- 벨트규칙
ALTER TABLE belt_rules
	ADD CONSTRAINT FK_beltes_TO_belt_rules -- 벨트 -> 벨트규칙
	FOREIGN KEY (
	belt_no -- 벨트번호
	)
	REFERENCES beltes ( -- 벨트
	belt_no -- 벨트번호
	);

-- 벨트규칙
ALTER TABLE belt_rules
	ADD CONSTRAINT FK_skilles_TO_belt_rules -- 기술 -> 벨트규칙
	FOREIGN KEY (
	rule_no -- 기술번호
	)
	REFERENCES skilles ( -- 기술
	skill_no -- 기술번호
	);

-- 대회후원사
ALTER TABLE event_sponsores
	ADD CONSTRAINT FK_sponsores_TO_event_sponsores -- 후원사 -> 대회후원사
	FOREIGN KEY (
	event_sponsor_no -- 후원사번호
	)
	REFERENCES sponsores ( -- 후원사
	sponsor_no -- 후원사번호
	);

-- 대회후원사
ALTER TABLE event_sponsores
	ADD CONSTRAINT FK_events_TO_event_sponsores -- 대회정보 -> 대회후원사
	FOREIGN KEY (
	event_no -- 대회번호
	)
	REFERENCES events ( -- 대회정보
	event_no -- 대회번호
	);