package member.mvc.model;

class MemberSQL {
	static final String LIST2 = "select * from MEMBER order by SEQ desc";
	static final String INSERT2 = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	static final String CONTENT = "select * from MEMBER where SEQ=?";
	static final String DEL = "delete from MEMBER where SEQ=?";
	static final String UPDATE1 = "select * from MEMBER where SEQ=?";
	static final String UPDATE2 = "update MEMBER set NAME=?, EMAIL=?, PHONE=?, ADDR=?, GRADE=? where SEQ=?";
	
}
