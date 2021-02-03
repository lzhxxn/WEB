drop table REPLY;
drop sequence REPLY_IDX_REPLY;
drop table JSP_BOARD;
drop sequence JSP_BOARD_IDX;

CREATE TABLE JSP_BOARD(
  IDX NUMBER PRIMARY KEY,
  WRITER VARCHAR2(30),
  EMAIL VARCHAR2(50),
  HOMEPAGE VARCHAR2(100),
  PWD VARCHAR2(30),
  SUBJECT VARCHAR2(22),
  CONTENT VARCHAR2(2000),
  WRITEDATE DATE,
  READNUM NUMBER,
  FILENAME VARCHAR2(200),
  OFILENAME VARCHAR2(200),
  FILESIZE NUMBER,
  REFER NUMBER,
  LEV NUMBER,
  SUNBUN NUMBER
);

CREATE SEQUENCE JSP_BOARD_IDX
INCREMENT BY 1
START WITH 1
nocache;


CREATE TABLE REPLY(
  IDX_REPLY NUMBER PRIMARY KEY, 
  WRITER VARCHAR2(30),
  PWD VARCHAR2(30),
  CONTENT VARCHAR2(1000),
  WRITEDATE DATE,
  REPLY_ID_FK REFERENCES JSP_MEMBER(ID),
  REPLY_IDX_FK REFERENCES JSP_BOARD(IDX)
);

CREATE SEQUENCE REPLY_IDX_REPLY
INCREMENT BY 1
START WITH 1
nocache;

insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '������1','na1@naver.com','www.na.co.kr','1234','ù��° ��','����', SYSDATE, 0, '', '', 0, 0, 0, 0);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '������2','na2@naver.com','www.na2.co.kr','1234','�ι�° ��','����', SYSDATE, 0, '', '', 0, 1, 0, 0);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '������','an@naver.com','www.an.co.kr','1234','����° ��','����', SYSDATE, 0, '', '', 0, 2, 0, 0);

insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '�輼��1','in1@naver.com','www.in1.co.kr','1234','ù���� ��1','����', SYSDATE, 0, '', '', 0, 0, 1, 1);

insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '�躸��1','kuk1@naver.com','www.kuk1.co.kr','1234','������ ��1','����', SYSDATE, 0, '', '', 0, 1, 1, 3);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '�躸��2','kuk2@naver.com','www.kuk2.co.kr','1234','������ ��1�� ��1','����', SYSDATE, 0, '', '', 0, 1, 2, 5);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '�ѳ���','choi@naver.com','www.choi.co.kr','1234','������ ��2','����', SYSDATE, 0, '', '', 0, 1, 1, 1);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '��Ҵ�','hon@naver.com','www.hon.co.kr','1234','������ ��2�� ��1','����', SYSDATE, 0, '', '', 0, 1, 2, 2);
insert into JSP_BOARD values(JSP_BOARD_IDX.nextval, '����','se@naver.com','www.se.co.kr','1234','������ ��1�� ��2','����', SYSDATE, 0, '', '', 0, 1, 2, 4);

commit;

select subject, refer, lev, sunbun from JSP_BOARD ORDER BY refer DESC, sunbun ASC;

select subject, refer, lev, sunbun from (select rownum rnum , aa.* from (select * from jsp_board order by refer desc, sunbun asc ) aa ) where rnum > 0 and rnum <= 3;
select subject, refer, lev, sunbun from (select rownum rnum , aa.* from (select * from jsp_board order by refer desc, sunbun asc ) aa ) where rnum > 3 and rnum <= 6;
select subject, refer, lev, sunbun from (select rownum rnum , aa.* from (select * from jsp_board order by refer desc, sunbun asc ) aa ) where rnum > 6 and rnum <= 9;
