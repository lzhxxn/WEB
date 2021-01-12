package login.mvc.model;

import java.lang.reflect.Member;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import mvc.domain.*;

import static login.mvc.model.LoginSQL.*;

class LoginDAO {
	private DataSource ds;
	
	LoginDAO() { // DB 접근하려면 써야한다.
		try {
		  Context initContext = new InitialContext();
		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
		  ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}

	//멤버클래스타입을 반환하는 getM 메서드.
	Admin getAdmin(String email) { //pwd 비교하는건 DAO에서하는건아니다. 
		//데이터베이스를 핸들링하는 역할이기 때문에. 서비스에서 비교하면된다. 비즈니스로직을.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select니까 필요.
		String sql = ADMIN;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email); //이미유효성이검증되어있어야함.
			// [1. 공백이있는지 ? ] [2. 이메일형식이아닌지 ? ]
			//자바스크립트 & 컨트롤러에서 공백이있는지 먼저 체크를 해줘야한다. trim 쓰는이유. 컨트롤에서한번더.
			//<1. Client Side 유효성 체킹 by js> 
			//<2. Server Side 유효성 체킹 by java in Controller > 
			rs = pstmt.executeQuery();
			//primary key 이기 때문에 0개 또는 1개이다. while문 X if문 O
			if(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				//String email = rs.getString(3); 이미 넘어왔기때문에
				String pwd = rs.getString(4);
				String phone = rs.getString(5);
				Date rdate = rs.getDate(6);
				Date udate = rs.getDate(7);
				
				//new Member(seq, name, email, pwd, phone, rdate, udate); 
				//객체를 만들어서 리턴하겠다는 의미
				
	// ((==)) Member m = new Member(seq, name, email, pwd, phone, rdate, udate);
				//return m; 변수에 담을게아니니까 이렇게안써줘도된다. 같은것.
				return new Admin(seq, name, email, pwd, phone, rdate, udate);
			}else {
				return null;
			}
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}

