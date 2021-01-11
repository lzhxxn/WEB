package member.mvc.model;

class MemberSQL {
	static final String LIST = "select * from MEMBER order by SEQ desc";
	static final String PAGE = "select * from (select ROWNUM rnum, aa.* from (select * from MEMBER order by SEQ desc) aa) where rnum>? and rnum<=?";
	static final String SELECT_COUNT = "select count(*) from MEMBER"; //"select max(ROWNUM) from BOARD"; "select count(SEQ) from BOARD";
	static final String INSERT2 = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE)";
}
