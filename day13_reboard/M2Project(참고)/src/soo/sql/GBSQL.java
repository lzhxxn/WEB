package soo.sql;

public class GBSQL {
	
    public final static String GB_INSERT  
	= "INSERT INTO guestbook VALUES(GUESTBOOK_IDX.NEXTVAL,?,?,?,?,SYSDATE)";
    
    public final static String GB_SELECT
	= "SELECT * FROM guestbook ORDER BY idx DESC";
    
    public final static String GB_SELECT_IDX
	= "SELECT * FROM guestbook WHERE idx=?";
    
    public final static String GB_DELETE_IDX
	= "DELETE FROM guestbook WHERE idx=?";
    
    public final static String GB_UPDATE_IDX
	= "UPDATE guestbook SET writer=?, email=?, subject=?, content=?, " +
			"writedate=SYSDATE WHERE idx=?";
    
}
