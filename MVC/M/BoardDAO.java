package board.mvc.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Board;
import static board.mvc.model.BoardSQL.*;

class BoardDAO {
	private DataSource ds;
	
	BoardDAO() {
		try {
		  Context initContext = new InitialContext();
		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
		  ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Board> list(){
		ArrayList<Board> dtos = new ArrayList<Board>();
		String sql = LIST;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;	
		try{
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			boolean flag = false;
			while(rs.next()){
				flag = true;
				int seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				java.sql.Date rdate = rs.getDate(6);
			
				dtos.add(new Board(seq, writer, email, subject, content, rdate));
			}
		}catch(SQLException se) {
			System.out.println("list() se: " + se);	
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		return dtos;
	}
	void insert(Board dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.executeUpdate();
		}catch(SQLException se){
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	Board content(int seq){
		String sql = CONTENT;
		Board dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("content() se : " + se);
		}
		try{
			rs = pstmt.executeQuery();
			boolean flag = false;
			if(rs.next()){
				flag = true;
				seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				java.sql.Date rdate = rs.getDate(6);
			dto = new Board(seq, writer, email, subject, content, rdate);
			}
		   }catch(SQLException se){
		         try{
		            if(pstmt != null) pstmt.close();
		            if(con != null) con.close();
		         }catch(SQLException sse){}
		      }
		return dto;
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
	void delAll() {
		Connection con = null;
		Statement stmt = null;
		String sql = DEL_ALL;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException se) {
		}finally{
			try{
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se){}
		}
	}
	Board update1(int seq) {
		Board dto = null;
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
              String writer = rs.getString(2);
              String email = rs.getString(3);
              String subject = rs.getString(4);
              String content = rs.getString(5);
              java.sql.Date rdate = rs.getDate(6);
              
        dto = new Board(seq, writer, email, subject, content, rdate);

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
	void update2(Board dto) {
		String sql2 = UPDATE2;
		Connection con = null;
	    PreparedStatement pstmt2 = null;
	    try{
	         con = ds.getConnection();
	         pstmt2 = con.prepareStatement(sql2);
	         pstmt2.setString(1, dto.getWriter());
	         pstmt2.setString(2, dto.getEmail());
	         pstmt2.setString(3, dto.getSubject());
	         pstmt2.setString(4, dto.getContent());
	         pstmt2.setInt(5, dto.getSeq());
	         pstmt2.executeUpdate();
	      }catch(NumberFormatException ne){
	      }catch(SQLException se){
	      }finally{
	         try{
	            if(pstmt2 != null) pstmt2.close();
	            if(con != null) con.close();
	         }catch(SQLException sse){}
	      }
	   }
	}
	
