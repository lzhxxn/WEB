package board.mvc.model;

class BoardSQL {
	final static String LIST="select * from BOARD order by SEQ desc";
	final static String INSERT
	    ="insert into BOARD values(BOARD_SEQ.nextval, ?,?,?,?, SYSDATE)";
	final static String CONTENT="select * from BOARD where SEQ=?";
	final static String UPDATE
	    ="update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
	final static String DEL= "delete from BOARD where SEQ=?";
}
