--alter table BOARD drop column FNAME;
--alter table BOARD drop column OFNAME;
alter table BOARD add(FNAME varchar2(30) default '', OFNAME varchar2(30) default '', FSIZE number default 0);