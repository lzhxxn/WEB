package board.mvc.model;

import java.sql.*;
import java.sql.Date;
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
				String fname = rs.getString("fname");
				String ofname = rs.getString("ofname");
				long fsize = rs.getInt("fsize");
				java.sql.Date rdate = rs.getDate("rdate");
				int count = rs.getInt("count");
			
				dtos.add(new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate, count));
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
	
	ArrayList<Board> list(int currentPage, int pageSize){ //첫번째 SQL 현재페이지&페이지사이즈
		ArrayList<Board> list = new ArrayList<Board>();
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
				String writer = rs.getString("writer");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String fname = rs.getString("fname");
				String ofname = rs.getString("ofname");
				long fsize = rs.getInt("fsize");
				Date rdate = rs.getDate("rdate");
				int count = rs.getInt("count"); 
				Board b = new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate, count);
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
			pstmt.setString(5, dto.getFname());
			pstmt.setString(6, dto.getOfname());
			pstmt.setLong(7, dto.getFsize());
			pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
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
				String fname = rs.getString("fname");
				String ofname = rs.getString("ofname");
				int fsize = rs.getInt("fsize");
				java.sql.Date rdate = rs.getDate("rdate");
				int count = rs.getInt("count");
			dto = new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate, count);
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
              String fname = rs.getString("fname");
			  String ofname = rs.getString("ofname");
			  long fsize = rs.getInt("fsize");
              java.sql.Date rdate = rs.getDate("rdate");
              int count = rs.getInt("count");
              
        dto = new Board(seq, writer, email, subject, content, fname, ofname, fsize, rdate, count);
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
				pstmt2.setString(5, dto.getFname());
				pstmt2.setString(6, dto.getOfname());
				pstmt2.setLong(7, dto.getFsize());
				pstmt2.setInt(8, dto.getSeq());
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
	 void upcount(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = READCOUNT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
	}
	}
	
