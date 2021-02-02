package board.mvc.model;

import mvc.domain.Board;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

import static board.mvc.model.BoardSQL.*;

class BoardDAO {
	private DataSource ds;
	BoardDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Board> list(){
		ArrayList<Board> list = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;		
		String sql = LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				java.sql.Date rdate = rs.getDate(6);
				
				Board b = new Board(seq, writer, email, subject, content, rdate);
				list.add(b);
			}
		}catch(SQLException se) {
			System.out.println("BoardDAO list() se: " + se);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		return list;
	}
	void insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("BoardDAO insert() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	Board getBoard(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CONTENT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//long seq = rs.getLong(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				String content = rs.getString(5);
				java.sql.Date rdate = rs.getDate(6);
				
				Board b = new Board(seq, writer, email, subject, content, rdate);
				return b;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("BoardDAO getBoard() se: " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void update(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = UPDATE;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getEmail());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setLong(4, board.getSeq());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("BoardDAO update() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void del(long seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("BoardDAO del() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
