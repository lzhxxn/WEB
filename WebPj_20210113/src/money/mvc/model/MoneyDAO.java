package money.mvc.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Money;
import mvc.domain.Member;


class MemberDAO {
	private DataSource ds;
	
	MemberDAO() {
		try {
		  Context initContext = new InitialContext();
		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
		  ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Money> list(){
		ArrayList<Money> list = new ArrayList<Money>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		//Money m = null;
		try {
			con = ds.getConnection();
			sql = "select seq , name , grade , pricesum from member natural join money order by pricesum desc";
			//sql = "select m2.seq as k1, m2.name as k2, m2.grade as k3, m1.pricesum as k4 from MONEY m1 join MEMBER m2 on m1.seq = m2.seq order by pricesum desc";
			pstmt = con.prepareStatement(sql);			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				int pricesum = rs.getInt("pricesum");
				Money m = new Money(seq, name, grade, pricesum);
				list.add(m);
				System.out.println("수행완료 DAO");
			}
			return list;
		}catch(SQLException se) {
			System.out.println("SQLException : "+se);
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

	
