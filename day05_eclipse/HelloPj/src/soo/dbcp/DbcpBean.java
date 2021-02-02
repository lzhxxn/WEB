package soo.dbcp;

import javax.naming.*;
import javax.sql.*;

public class DbcpBean {
	private DataSource ds;
	
	public DbcpBean() {
		System.out.println("DbcpBean() 호출 완료!");
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	public DataSource getDs() {
		return ds;
	}
}
