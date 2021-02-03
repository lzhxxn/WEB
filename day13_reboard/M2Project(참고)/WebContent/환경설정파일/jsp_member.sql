CREATE TABLE JSP_MEMBER( 
   NO NUMBER, 
   NAME VARCHAR2(30),
   SSN VARCHAR2(13),
   ID VARCHAR2(30) PRIMARY KEY, 
   PWD VARCHAR2(30), 
   EMAIL VARCHAR2(50), 
   PHONE VARCHAR2(50), 
   JOINDATE DATE); 
   
CREATE SEQUENCE JSP_MEMBER_NO INCREMENT BY 1 START WITH 1 nocache; 

insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '홍길동', '1234561234567', 'hong', '1234', 'hong@hanmail.net', '0101231234', SYSDATE);
insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '이순신', '1234561234568', 'lee', '1234', 'lee@hanmail.net', '0101231235', SYSDATE);
insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '강감찬', '1234561234569', 'gang', '1234', 'gang@hanmail.net', '0101231236', SYSDATE);
insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '한예슬', '1234562234560', 'han', '1234', 'han@hanmail.net', '0101231237', SYSDATE);
insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '장동건', '1234561234561', 'jang', '1234', 'jang@hanmail.net', '0101231238', SYSDATE);
insert into JSP_MEMBER values(JSP_MEMBER_NO.nextval, '손님', '1234561234561', 'guest', '1234', 'guest@hanmail.net', '0101231239', SYSDATE);

commit;
