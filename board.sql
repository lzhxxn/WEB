--create user spring identified by java;
--grant resource, connect to spring;
--conn spring/java;

drop table BOARD;
drop sequence BOARD_SEQ;
drop sequence BOARD_ORIGIN_NO;
purge recyclebin;

create table BOARD(
   SEQ number constraint BOARD_PK primary key, 
   ORIGIN_NO number,
   GROUP_ORD number,
   GROUP_LAYER number,
   WRITER varchar2(15), 
   EMAIL varchar2(20),
   SUBJECT varchar2(20), 
   CONTENT varchar2(20), 
   RDATE date default SYSDATE,
   FNAME varchar2(50),
   OFNAME varchar2(50),
   FSIZE number
); 
create sequence BOARD_SEQ increment by 1 start with 1 nocache;
create sequence BOARD_ORIGIN_NO increment by 1 start with 1 nocache; 

insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '공병찬', 'kim@hanmail.net','제목1', '내용1', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '김보라', 'lee@hanmail.net','제목2', '내용2', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '김성태', 'han@hanmail.net','제목3', '내용3', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '김세영', 'oh@hanmail.net','제목4', '내용4', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '김소담', 'chm@hanmail.net','제목5', '내용5', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '남철호', 'kim@hanmail.net','제목6', '내용6', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '모건일', 'lee@hanmail.net','제목7', '내용7', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '손영빈', 'han@hanmail.net','제목8', '내용8', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '송승훈', 'oh@hanmail.net','제목9', '내용9', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0,'안정은', 'chm@hanmail.net','제목10', '내용10', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '윤별', 'kim@hanmail.net','제목11', '내용11', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '임성지', 'lee@hanmail.net','제목12', '내용12', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '장현봉', 'han@hanmail.net','제목13', '내용13', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '전세환', 'oh@hanmail.net','제목14', '내용14', SYSDATE, '파일', '원본파일', -1);
insert into BOARD values(BOARD_SEQ.nextval, BOARD_ORIGIN_NO.nextval, 0, 0, '조예진', 'chm@hanmail.net','제목15', '내용15', SYSDATE, '파일', '원본파일', -1);


commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;