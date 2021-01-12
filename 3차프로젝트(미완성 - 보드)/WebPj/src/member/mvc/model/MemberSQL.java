package member.mvc.model;

class MemberSQL {
	static final String LIST2 = "select * from MEMBER order by SEQ desc";
	static final String INSERT2 = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE)";
}
