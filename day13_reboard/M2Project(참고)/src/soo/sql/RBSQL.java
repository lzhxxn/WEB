package soo.sql;

public class RBSQL {
	
	// 1. listing관련 SQL 
	public final static String RB_SELECT_TN_0
	  = " select * from (select rownum rnum , aa.* from " +
	  		"(select * from jsp_board order by refer desc, sunbun asc ) aa ) " +
	  		    "where rnum > ? and rnum <= ?";
	
	public final static String  RB_SELECT_TN_1
	  = " select * from (select rownum rnum , aa.* from " +
		"(select * from jsp_board1 order by refer desc, sunbun asc ) aa ) " +
		    "where rnum > ? and rnum <= ?";
	
	public final static String  RB_SELECT_TN_2
	  = " select * from (select rownum rnum , aa.* from " +
		"(select * from jsp_board2 order by refer desc, sunbun asc ) aa ) " +
		    "where rnum > ? and rnum <= ?";
	
	
	public final static String RB_TOTALCOUNT_TN_0
	   = "SELECT rownum FROM jsp_board ORDER BY rownum DESC";
	
	public final static String RB_TOTALCOUNT_TN_1
	   = "SELECT rownum FROM jsp_board1 ORDER BY rownum DESC";
	
	public final static String RB_TOTALCOUNT_TN_2
	   = "SELECT rownum FROM jsp_board2 ORDER BY rownum DESC";
	
	
	//2. writeOk 관련 SQL 
	public final static String RB_WRITEOK_TN_0 
	     = "INSERT INTO jsp_board VALUES(JSP_BOARD_IDX.NEXTVAL," +
	     		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
	public final static String RB_WRITEOK_TN_1 
         = "INSERT INTO jsp_board1 VALUES(JSP_BOARD1_IDX.NEXTVAL," +
    		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
	public final static String RB_WRITEOK_TN_2 
         = "INSERT INTO jsp_board2 VALUES(JSP_BOARD2_IDX.NEXTVAL," +
    		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
	
	//2_1. MAXREF가져오기 
	public final static String RB_MAXREF_TN_0 
	    = "SELECT Max(refer) FROM jsp_board";
	public final static String RB_MAXREF_TN_1 
	    = "SELECT Max(refer) FROM jsp_board1";
	public final static String RB_MAXREF_TN_2 
	    = "SELECT Max(refer) FROM jsp_board2";
	
	//2_2. 파일이름 업데이트 관련 SQL 
	public final static String RB_FNUPDATE_TN_0
	     = "UPDATE jsp_board SET filename=? WHERE filename=? AND filesize=?";
	public final static String RB_FNUPDATE_TN_1
         = "UPDATE jsp_board1 SET filename=? WHERE filename=? AND filesize=?";
	public final static String RB_FNUPDATE_TN_2
         = "UPDATE jsp_board2 SET filename=? WHERE filename=? AND filesize=?";
	
	// 2_2_1. DATE값 가져오기 
	public final static String RB_GETDATE_TN_0
	     = "SELECT TO_CHAR(writedate, 'YYYYMMDDHH24MISS') " +
	     		"FROM jsp_board WHERE filename=? AND filesize=?";
	public final static String RB_GETDATE_TN_1
         = "SELECT TO_CHAR(writedate, 'YYYYMMDDHH24MISS') " +
         		"FROM jsp_board1 WHERE filename=? AND filesize=?";
	public final static String RB_GETDATE_TN_2
         = "SELECT TO_CHAR(writedate, 'YYYYMMDDHH24MISS') " +
         		"FROM jsp_board2 WHERE filename=? AND filesize=?";
	
	
	// 3. content관련 sql 
	public final static String RB_CONTENT_TN_0
	     = "SELECT * FROM jsp_board WHERE idx=?";
	public final static String RB_CONTENT_TN_1
         = "SELECT * FROM jsp_board1 WHERE idx=?";
	public final static String RB_CONTENT_TN_2
         = "SELECT * FROM jsp_board2 WHERE idx=?";
	
	// 3_1. 조회수증가 sql
	public final static String RB_READNUM_TN_0
	     = "UPDATE jsp_board SET readnum=readnum+1 WHERE idx=?";
	public final static String RB_READNUM_TN_1
    	 = "UPDATE jsp_board1 SET readnum=readnum+1 WHERE idx=?";
	public final static String RB_READNUM_TN_2
    	 = "UPDATE jsp_board2 SET readnum=readnum+1 WHERE idx=?";
	
	// 3_2. reply 저장 sql 
	public final static String RB_REPLY_SAVE_TN_0
	     = "INSERT INTO reply VALUES(" +
	     		"REPLY_IDX_REPLY.NEXTVAL,?,?,?,SYSDATE,?,?)";
	public final static String  RB_REPLY_SAVE_TN_1
	     = "INSERT INTO reply1 VALUES(" +
	    		"REPLY1_IDX_REPLY.NEXTVAL,?,?,?,SYSDATE,?,?)";
	public final static String  RB_REPLY_SAVE_TN_2
	     = "INSERT INTO reply2 VALUES(" +
	    		"REPLY2_IDX_REPLY.NEXTVAL,?,?,?,SYSDATE,?,?)";
	
	// 3_3. reply 리스트 sql 
	public final static String  RB_REPLY_LIST_TN_0
	      = "SELECT * FROM reply WHERE reply_idx_fk=? ORDER BY idx_reply DESC";
	public final static String  RB_REPLY_LIST_TN_1
    	  = "SELECT * FROM reply1 WHERE reply_idx_fk=? ORDER BY idx_reply DESC";
	public final static String  RB_REPLY_LIST_TN_2
    	  = "SELECT * FROM reply2 WHERE reply_idx_fk=? ORDER BY idx_reply DESC";
	
	
	//3_4. reply 삭제 sql 
	public final static String RB_REPLY_SEL_ID_TN_0
	      = "SELECT reply_id_fk FROM reply WHERE idx_reply=?";
	public final static String RB_REPLY_SEL_PWD_TN_0
	      = "SELECT pwd FROM reply WHERE idx_reply=?";
	public final static String RB_REPLY_DEL_TN_0
	      = "DELETE FROM reply WHERE idx_reply=?";
	
	public final static String RB_REPLY_SEL_ID_TN_1
    	  = "SELECT reply_id_fk FROM reply1 WHERE idx_reply=?";
	public final static String RB_REPLY_SEL_PWD_TN_1
    	  = "SELECT pwd FROM reply1 WHERE idx_reply=?";
	public final static String RB_REPLY_DEL_TN_1
	      = "DELETE FROM reply1 WHERE idx_reply=?";
	
	public final static String RB_REPLY_SEL_ID_TN_2
		  = "SELECT reply_id_fk FROM reply2 WHERE idx_reply=?";
	public final static String RB_REPLY_SEL_PWD_TN_2
	      = "SELECT pwd FROM reply2 WHERE idx_reply=?";
	public final static String RB_REPLY_DEL_TN_2
		  = "DELETE FROM reply2 WHERE idx_reply=?";
	
	
	// 4. edit 관련 sql 
	public final static String RB_EDIT_TN_0
	      = "SELECT * FROM jsp_board WHERE idx=?";
	public final static String RB_EDIT_TN_1
    	  = "SELECT * FROM jsp_board1 WHERE idx=?";
	public final static String RB_EDIT_TN_2
    	  = "SELECT * FROM jsp_board2 WHERE idx=?";
	
	// 4_1. editOk 관련 sql 
	public final static String RB_EDIT_PWD_TN_0
	      = "SELECT pwd FROM jsp_board WHERE idx=?";
	public final static String RB_EDITOK_TN_0
	      = "UPDATE jsp_board SET content=?, subject=?, " +
	      		"writer=?, email=?, homepage=? WHERE idx=?";
	
	public final static String RB_EDIT_PWD_TN_1
          = "SELECT pwd FROM jsp_board1 WHERE idx=?";
	public final static String RB_EDITOK_TN_1
          = "UPDATE jsp_board1 SET content=?, subject=?, " +
    		    "writer=?, email=?, homepage=? WHERE idx=?";
	
	public final static String RB_EDIT_PWD_TN_2
          = "SELECT pwd FROM jsp_board2 WHERE idx=?";
	public final static String RB_EDITOK_TN_2
          = "UPDATE jsp_board2 SET content=?, subject=?, " +
    		    "writer=?, email=?, homepage=? WHERE idx=?";
	
	
	// 5. del관련 sql 
	public final static String RB_DEL_PWD_TN_0
		  = "SELECT pwd FROM jsp_board WHERE idx=?"; 
	public final static String RB_DELOK_TN_0
	      = "DELETE FROM jsp_board WHERE idx=?";
	public final static String  RB_REPLY_DEL_IDX_TN_0
	      = "DELETE FROM reply WHERE reply_idx_fk=?";
	
	public final static String RB_DEL_PWD_TN_1
	      = "SELECT pwd FROM jsp_board1 WHERE idx=?"; 
	public final static String RB_DELOK_TN_1
	      = "DELETE FROM jsp_board1 WHERE idx=?";
	public final static String  RB_REPLY_DEL_IDX_TN_1
          = "DELETE FROM reply1 WHERE reply_idx_fk=?";
	
	public final static String RB_DEL_PWD_TN_2
	      = "SELECT pwd FROM jsp_board2 WHERE idx=?"; 
	public final static String RB_DELOK_TN_2
	      = "DELETE FROM jsp_board2 WHERE idx=?";
	public final static String  RB_REPLY_DEL_IDX_TN_2
          = "DELETE FROM reply2 WHERE reply_idx_fk=?";
	
	
	// 6. rewrite 관련 sql 
	public final static String RB_REWRITE_SEL_TN_0
	      = "SELECT refer, lev, sunbun FROM jsp_board WHERE idx=?";
	public final static String RB_REWRITE_UP_TN_0
	      = "UPDATE jsp_board SET sunbun=sunbun+1 WHERE sunbun>? AND refer=?";
	public final static String RB_REWRITE_IN_TN_0
	      = "INSERT INTO jsp_board VALUES(JSP_BOARD_IDX.NEXTVAL, " +
	      		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
	
	public final static String RB_REWRITE_SEL_TN_1
	     = "SELECT refer, lev, sunbun FROM jsp_board1 WHERE idx=?";
	public final static String RB_REWRITE_UP_TN_1
	     = "UPDATE jsp_board1 SET sunbun=sunbun+1 WHERE sunbun>? AND refer=?";
	public final static String RB_REWRITE_IN_TN_1
	     = "INSERT INTO jsp_board1 VALUES(JSP_BOARD_IDX.NEXTVAL, " +
	    		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
	
	public final static String RB_REWRITE_SEL_TN_2
	     = "SELECT refer, lev, sunbun FROM jsp_board2 WHERE idx=?";
	public final static String RB_REWRITE_UP_TN_2
	     = "UPDATE jsp_board2 SET sunbun=sunbun+1 WHERE sunbun>? AND refer=?";
	public final static String RB_REWRITE_IN_TN_2
	     = "INSERT INTO jsp_board2 VALUES(JSP_BOARD_IDX.NEXTVAL, " +
	    		"?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?)";
}
