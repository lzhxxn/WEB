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
	
	LoginDAO() { // DB �����Ϸ��� ����Ѵ�.
		try {
		  Context initContext = new InitialContext();
		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
		  ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}

	//���Ŭ����Ÿ���� ��ȯ�ϴ� getM �޼���.
	Admin getAdmin(String email) { //pwd ���ϴ°� DAO�����ϴ°Ǿƴϴ�. 
		//�����ͺ��̽��� �ڵ鸵�ϴ� �����̱� ������. ���񽺿��� ���ϸ�ȴ�. ����Ͻ�������.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //select�ϱ� �ʿ�.
		String sql = ADMIN;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email); //�̹���ȿ���̰����Ǿ��־����.
			// [1. �������ִ��� ? ] [2. �̸��������̾ƴ��� ? ]
			//�ڹٽ�ũ��Ʈ & ��Ʈ�ѷ����� �������ִ��� ���� üũ�� ������Ѵ�. trim ��������. ��Ʈ�ѿ����ѹ���.
			//<1. Client Side ��ȿ�� üŷ by js> 
			//<2. Server Side ��ȿ�� üŷ by java in Controller > 
			rs = pstmt.executeQuery();
			//primary key �̱� ������ 0�� �Ǵ� 1���̴�. while�� X if�� O
			if(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				//String email = rs.getString(3); �̹� �Ѿ�Ա⶧����
				String pwd = rs.getString(4);
				String phone = rs.getString(5);
				Date rdate = rs.getDate(6);
				Date udate = rs.getDate(7);
				
				//new Member(seq, name, email, pwd, phone, rdate, udate); 
				//��ü�� ���� �����ϰڴٴ� �ǹ�
				
	// ((==)) Member m = new Member(seq, name, email, pwd, phone, rdate, udate);
				//return m; ������ �����Ծƴϴϱ� �̷��ԾȽ��൵�ȴ�. ������.
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

