--conn system/java1019
--create user BIT identified by CAMP;
--grant CONNECT, RESOURCE to BIT;
--conn BIT/CAMP


drop table MEMBER;
drop sequence MEMBER_SEQ;

CREATE TABLE MEMBER( 
   SEQ NUMBER constraint MEMBER_PK PRIMARY KEY, 
   NAME VARCHAR2(20),
   EMAIL VARCHAR2(20),
   PHONE VARCHAR2(13),
   ADDR VARCHAR2(60),
   GRADE CHAR(1),
   JOINDATE DATE default SYSDATE);
   
CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into MEMBER values(MEMBER_SEQ.nextval, '박지훈',  'lzhxxn@naver.com', '01077778543', '서울시 서대문구 북가좌동', 'A', '20151202');
insert into MEMBER values(MEMBER_SEQ.nextval, '이옥석',  'lee@hanmail.net', '01030503953', '서울시 마포구 염리동', 'B', '2016.01.01');
insert into MEMBER values(MEMBER_SEQ.nextval, '유진복',  'bok@hanmail.net', '01022182421', '서울시 강남구 대치동', 'C', '2018.05.05');
insert into MEMBER values(MEMBER_SEQ.nextval, '최우재',  'choi@hanmail.net', '01095323424', '서울시 영등포구 문래동', 'D', '2020.10.19');
commit;

select * from MEMBER order by SEQ desc;


drop table MONEY;
drop sequence MONEY_SEQ;

CREATE TABLE MONEY( 
   SEQ NUMBER constraint MONEY_PK PRIMARY KEY,  --custno
   PRICESUM NUMBER);

insert into money values (2, 490000);
insert into money values (3, 120000);
insert into money values (4, 90000);
insert into money values (5, 20000);
insert into money values (6, 340000);
insert into money values (7, 150000);
insert into money values (8, 774000);
insert into money values (9, 994000);
insert into money values (10, 374000);
update money set pricesum=890000 where seq=12;

commit;

select * from MONEY order by SEQ desc;

ALTER TABLE MONEY ADD CONSTRAINT FK_member_TO_money FOREIGN KEY (seq) REFERENCES member(seq);



drop table ADMIN;
drop sequence ADMIN_SEQ;

CREATE TABLE ADMIN( 
   SEQ NUMBER, 
   NAME VARCHAR2(30),
   EMAIL VARCHAR2(50) constraint ADMIN_PK PRIMARY KEY,
   PWD VARCHAR2(30), 
   PHONE VARCHAR2(50), 
   RDATE DATE default SYSDATE, 
   UDATE DATE default SYSDATE); 
   
CREATE SEQUENCE ADMIN_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into ADMIN values(ADMIN_SEQ.nextval, '지훈',  'lee@naver.com', '1234', '01075358543', SYSDATE, SYSDATE);
insert into ADMIN values(ADMIN_SEQ.nextval, '종범',  'park@naver.com', '1234',  '01030503953', SYSDATE, SYSDATE);
commit;

select * from ADMIN order by SEQ desc;




drop table GOODS;
drop sequence GOODS_SEQ;

CREATE TABLE GOODS( 
   SEQ NUMBER constraint GOODS_PK PRIMARY KEY, 
   NAME VARCHAR2(30),
   ETC VARCHAR2(50),
   FNAME VARCHAR2(30),
   OFNAME VARCHAR2(30),
   FSIZE number,
   RDATE VARCHAR2(30));
   
CREATE SEQUENCE GOODS_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into GOODS values(GOODS_SEQ.nextval, '엄마는외계인',  '초코', 'fname1', 'ofname1', null, SYSDATE);
commit;

select * from GOODS order by SEQ desc;


drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
   SEQ number constraint BOARD_PK primary key, 
   WRITER varchar2(15), 
   EMAIL varchar2(20),
   SUBJECT varchar2(50), 
   CONTENT varchar2(50),
   FNAME varchar2(20),
   OFNAME varchar2(20),
   FSIZE number,
   RDATE date default SYSDATE,
   COUNT number
); 
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'ymhur@hanmail.net','제목1', '내용1', 'fname1', 'ofname1', null, SYSDATE , 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'seongcap@hanmail.net','제목2', '내용2', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', '0hoo@hanmail.net','제목3', '내용3', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'chacap@hanmail.net','제목4', '내용4', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'parkcap@hanmail.net','제목5', '내용5', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'zero@hanmail.net','제목6', '내용6', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'oak@hanmail.net','제목7', '내용7', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'boku@hanmail.net','제목8', '내용8', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'woojae@hanmail.net','<공지>테이크아웃시 -1000원할인!', '내용9', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'hello@hanmail.net','<공지>코로나2.5단계, 매장 내 취식불가', '내용10', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'world@hanmail.net','<공지>엄마는외계인 품절!', '내용11', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'soos@hanmail.net','<공지>아빠는딸바봉 출시!', '내용12', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'bitcamp@hanmail.net','<공지>2021-03-31일에 영업종료합니다.', '내용13', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'welcome@hanmail.net','안녕하세요? 설빙입니다.', '내용14', 'fname1', 'ofname1', null, SYSDATE, 0);
insert into BOARD values(BOARD_SEQ.nextval, '관리자', 'lecture@hanmail.net','설빙에 오신것을 환영합니다.', '내용15', 'fname1', 'ofname1', null, SYSDATE, 0);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;




