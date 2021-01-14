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

insert into MEMBER values(MEMBER_SEQ.nextval, '������',  'lzhxxn@naver.com', '01077778543', '����� ���빮�� �ϰ��µ�', 'A', '20151202');
insert into MEMBER values(MEMBER_SEQ.nextval, '�̿���',  'lee@hanmail.net', '01030503953', '����� ������ ������', 'B', '2016.01.01');
insert into MEMBER values(MEMBER_SEQ.nextval, '������',  'bok@hanmail.net', '01022182421', '����� ������ ��ġ��', 'C', '2018.05.05');
insert into MEMBER values(MEMBER_SEQ.nextval, '�ֿ���',  'choi@hanmail.net', '01095323424', '����� �������� ������', 'D', '2020.10.19');
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
insert into money values (12, 900000);
insert into money values (13, 400000);
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

insert into ADMIN values(ADMIN_SEQ.nextval, '������',  'lee@naver.com', '1234', '01075358543', SYSDATE, SYSDATE);
insert into ADMIN values(ADMIN_SEQ.nextval, '������',  'park@naver.com', '1234',  '01030503953', SYSDATE, SYSDATE);
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

insert into GOODS values(GOODS_SEQ.nextval, '����Ų���',  '����1', 'fname1', 'ofname1', null, SYSDATE);
commit;

select * from GOODS order by SEQ desc;


drop table BOARD;
drop sequence BOARD_SEQ;
drop table REPLY;
drop sequence REPLY_SEQ_REPLY;
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

insert into BOARD values(BOARD_SEQ.nextval, '������', 'ymhur@hanmail.net','����1', '����1', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'seongcap@hanmail.net','����2', '����2', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ڿ���', '0hoo@hanmail.net','����3', '����3', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'chacap@hanmail.net','����4', '����4', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'parkcap@hanmail.net','����5', '����5', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�չμ�', 'zero@hanmail.net','����6', '����6', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�̿���', 'oak@hanmail.net','����7', '����7', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'boku@hanmail.net','����8', '����8', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ֿ���', 'woojae@hanmail.net','����9', '����9', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'hello@hanmail.net','����10', '����10', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'world@hanmail.net','����11', '����11', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ŵ���', 'soos@hanmail.net','����12', '����12', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ӿ���', 'bitcamp@hanmail.net','����13', '����13', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ǿ���', 'welcome@hanmail.net','����14', '����14', 'fname1', 'ofname1', null, SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�̹ο�', 'lecture@hanmail.net','����15', '����15', 'fname1', 'ofname1', null, SYSDATE);

--alter table BOARD drop column FNAME;
--alter table BOARD drop column OFNAME;
alter table BOARD add(FNAME varchar2(30) default '', OFNAME varchar2(30) default '');
commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;