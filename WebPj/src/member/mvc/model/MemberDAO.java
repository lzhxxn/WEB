package member.mvc.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Member;

import static member.mvc.model.MemberSQL.*;

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
	ArrayList<Member> list(int currentPage, int pageSize){ //첫번째 SQL 현재페이지&페이지사이즈
		ArrayList<Member> list = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = PAGE;
		
		int startRow = (currentPage-1)*pageSize;//0(1) 3(2)      // (현재 3-1)*사이즈3 = 6개. 
		int endRow = currentPage*pageSize;//3(1) 6(2)            // 현재페이지3x페이지사이즈3 = 9개.
		try {					
			con = ds.getConnection();						
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);  //첫번째 물읖표
			pstmt.setInt(2, endRow);	//두번째 물음표					
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String addr = rs.getString("addr");
				String grade = rs.getString("grade");
				Date joindate = rs.getDate("joindate");
				Member b = new Member(seq, name, email, phone, addr, grade, joindate);
				list.add(b);
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
	
	long getTotalCount() { // 전체 글의 개수
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = SELECT_COUNT;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt(1);
				return count;
			}else {
				return -1;
			}
		}catch(SQLException se) {
			return -1;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void insert(Member dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT2;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getGrade());
			pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println(se);
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
}
	
