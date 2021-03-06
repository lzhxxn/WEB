package board.mvc.model;

class BoardSQL {
	static final String LIST = "select * from BOARD order by SEQ desc";
	static final String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, SYSDATE, 0)";
	static final String CONTENT = "select * from BOARD where SEQ=?";
	static final String DEL = "delete from BOARD where SEQ=?";
	static final String DEL_ALL = "delete from BOARD";
	static final String UPDATE1 = "select * from BOARD where SEQ=?";
	static final String UPDATE2 = "update BOARD set WRITER=?, EMAIL=?, SUBJECT=?, CONTENT=?, FNAME=?, OFNAME=?, FSIZE=? where SEQ=?";
	static final String PAGE = "select * from (select ROWNUM rnum, aa.* from (select * from BOARD order by SEQ desc) aa) where rnum>? and rnum<=?";
	static final String SELECT_COUNT = "select count(*) from BOARD"; //"select max(ROWNUM) from BOARD"; "select count(SEQ) from BOARD";
	static final String READCOUNT = "update BOARD set COUNT = COUNT+1 where SEQ=?";

}
