drop table MEMBER;
drop sequence MEMBER_SEQ;

CREATE TABLE MEMBER( 
   SEQ NUMBER, 
   NAME VARCHAR2(30),
   EMAIL VARCHAR2(50) constraint MEMBER_PK PRIMARY KEY,
   PWD VARCHAR2(30), 
   PHONE VARCHAR2(50), 
   RDATE DATE default SYSDATE, 
   UDATE DATE default SYSDATE); 
   
CREATE SEQUENCE MEMBER_SEQ INCREMENT BY 1 START WITH 1 nocache; 

insert into MEMBER values(MEMBER_SEQ.nextval, '홍길동',  'hong@hanmail.net', '1234', '0101231234', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '이순신',  'lee@hanmail.net', '1234',  '0101231235', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '강감찬',  'gang@hanmail.net', '1234',  '0101231236', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '한예슬',  'han@hanmail.net', '1234',  '0101231237', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '장동건', 'jang@hanmail.net', '1234',  '0101231238', SYSDATE, SYSDATE);
insert into MEMBER values(MEMBER_SEQ.nextval, '손님',  'guest@hanmail.net','1234',  '0101231239', SYSDATE, SYSDATE);
commit;

select * from MEMBER order by SEQ desc;
