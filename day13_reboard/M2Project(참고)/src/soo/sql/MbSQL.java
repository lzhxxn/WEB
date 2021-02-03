package soo.sql;

public class MbSQL {
	// memberJoin관련 SQL 
    public static final String MB_SELECT_SSN
	= "SELECT * FROM jsp_member WHERE ssn=?";
    public static final String MB_INSERT
	= "INSERT INTO jsp_member VALUES(" +
			"JSP_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";
    
    // memberFind관련 SQL 
    public static final String MB_SEARCH_SSN 
	= "SELECT * FROM jsp_member WHERE ssn=?";
    public static final String MB_SEARCH_ID 
	="SELECT * FROM jsp_member WHERE id=?";
    public static final String MB_SEARCH_NAME 
	="SELECT * FROM jsp_member WHERE name=?";
}
