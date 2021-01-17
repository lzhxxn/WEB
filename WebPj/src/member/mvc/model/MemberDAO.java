package member.mvc.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Member;
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
	ArrayList<Member> list(){
		ArrayList<Member> list = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql = LIST2;
		try {
			con = ds.getConnection();						
			pstmt = con.prepareStatement(sql);			
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
			pstmt.setDate(6, dto.getJoindate());
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
	boolean del(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			int i = pstmt.executeUpdate();
			if(i>0) return true;
			else return false;
		}catch(SQLException se) {
			return false;
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	Member content(int seq){
		String sql = CONTENT;
		Member dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("addr() se : " + se);
		}
		try{
			rs = pstmt.executeQuery();
			boolean flag = false;
			if(rs.next()){
				flag = true;
				//seq = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String addr = rs.getString(5);
				String grade = rs.getString("grade");
				java.sql.Date joindate = rs.getDate("joindate");
			dto = new Member(seq, name, email, phone, addr, grade, joindate);
			}
		   }catch(SQLException se){
		         try{
		            if(pstmt != null) pstmt.close();
		            if(con != null) con.close();
		         }catch(SQLException sse){}
		      }
		return dto;
	}
	Member update1(int seq) {
		Member dto = null;
		ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt1 = null;
        String sql1 = UPDATE1;
        try{
           con = ds.getConnection();
           pstmt1 = con.prepareStatement(sql1);
           pstmt1.setInt(1, seq);
           rs = pstmt1.executeQuery();
           boolean flag = false;
           while(rs.next()){
              flag = true;
              String name = rs.getString(2);
              String email = rs.getString(3);
              String phone = rs.getString(4);
              String addr = rs.getString(5);
              String grade = rs.getString("grade");
              java.sql.Date joindate = rs.getDate("joindate");
              
          	dto = new Member(seq, name, email, phone, addr, grade, joindate);
           }
        }catch(SQLException se){
        }finally{
           try{
              if(pstmt1 != null) pstmt1.close();
              if(con != null) con.close();
           }catch(SQLException sse){}
     }
        return dto;
  }
	void update2(Member dto) {
		String sql2 = UPDATE2;
		Connection con = null;
	    PreparedStatement pstmt2 = null;
	    try{
	         con = ds.getConnection();
	         pstmt2 = con.prepareStatement(sql2);
	         pstmt2.setString(1, dto.getName());
			 pstmt2.setString(2, dto.getEmail());
			 pstmt2.setString(3, dto.getPhone());
			 pstmt2.setString(4, dto.getAddr());
		  	 pstmt2.setString(5, dto.getGrade());
		  	 pstmt2.setInt(6, dto.getSeq());
		     pstmt2.executeUpdate();
	      }catch(NumberFormatException ne){
	      }catch(SQLException se){
	    	  se.printStackTrace();
	      }finally{
	         try{
	            if(pstmt2 != null) pstmt2.close();
	            if(con != null) con.close();
	         }catch(SQLException sse){}
	      }
	   }
}
	
