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
   NAME VARCHAR2(30), --custname
   GRADE VARCHAR2(30),
   PRICESUM VARCHAR2(30));

CREATE SEQUENCE MONEY_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into MONEY values(MONEY_SEQ.nextval, '최우재', 'A', '90000');
commit;

select * from MONEY order by SEQ desc;



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

insert into ADMIN values(ADMIN_SEQ.nextval, '이지훈',  'lee@naver.com', '1234', '01075358543', SYSDATE, SYSDATE);
insert into ADMIN values(ADMIN_SEQ.nextval, '박종범',  'park@naver.com', '1234',  '01030503953', SYSDATE, SYSDATE);
commit;

select * from ADMIN order by SEQ desc;




drop table GOODS;
drop sequence GOODS_SEQ;

CREATE TABLE GOODS( 
   SEQ NUMBER constraint GOODS_PK PRIMARY KEY, 
   NAME VARCHAR2(30),
   ETC VARCHAR2(200),
   FNAME varchar2(20),
   OFNAME varchar2(20),
   FSIZE number,
   RDATE DATE default SYSDATE);
   
CREATE SEQUENCE GOODS_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into GOODS values(GOODS_SEQ.nextval, '샌드위치',  '내용1', 'fname1', 'ofname1', null, SYSDATE);
commit;

select * from GOODS order by SEQ desc;


drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
   SEQ number constraint BOARD_PK primary key, 
   WRITER varchar2(15), 
   EMAIL varchar2(20),
   SUBJECT varchar2(20), 
   CONTENT varchar2(20),
   FNAME varchar2(20),
   OFNAME varchar2(20),
   FSIZE number,
   RDATE date default SYSDATE
); 
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(BOARD_SEQ.nextval, '허유민', 'ymhur@hanmail.net','제목1', '내용1', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '성진희', 'seongcap@hanmail.net','제목2', '내용2', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '박영후', '0hoo@hanmail.net','제목3', '내용3', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '차지현', 'chacap@hanmail.net','제목4', '내용4', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '박종범', 'parkcap@hanmail.net','제목5', '내용5', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '손민수', 'zero@hanmail.net','제목6', '내용6', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이옥석', 'oak@hanmail.net','제목7', '내용7', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '유진복', 'boku@hanmail.net','제목8', '내용8', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '최우재', 'woojae@hanmail.net','제목9', '내용9', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이정원', 'hello@hanmail.net','제목10', '내용10', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이지훈', 'world@hanmail.net','제목11', '내용11', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '신동오', 'soos@hanmail.net','제목12', '내용12', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '임연지', 'bitcamp@hanmail.net','제목13', '내용13', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '권연주', 'welcome@hanmail.net','제목14', '내용14', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '이민용', 'lecture@hanmail.net','제목15', '내용15', 'fname1', 'ofname1', null, SYSDATE);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;






