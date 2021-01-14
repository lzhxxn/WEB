package goods.mvc.model;

class GoodsSQL {
	static final String LIST= "select * from GOODS order by SEQ desc";
	static final String INSERT = "insert into GOODS values(?, ?, ?, ?, ?, ?, ?)";
	static final String DEL = "delete from GOODS where SEQ=?";
	//인증된사람을 세션에 넣기위해 전부 *로 한다. pwd가아니라.
}

