package soo.mv.model;

import java.sql.*;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AddrDAO { //Data Access Object
	private DataSource ds;
	
	public AddrDAO() {
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	public ArrayList<AddrDTO> list() {
		ArrayList<AddrDTO> list = new ArrayList<AddrDTO>();
		String sql = "select * from ADDRESS order by SEQ desc";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				java.sql.Date rdate = rs.getDate(4);
				
				AddrDTO dto = new AddrDTO(seq, name, addr, rdate);
				list.add(dto);
			}
			//return list;
		}catch(SQLException se) {
			System.out.println("list() se: " + se);
			//return list;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
		return list;
	}
	//public void insert(String name, String addr) {
	public void insert(AddrDTO dto) {
		String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("insert() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	public void delete(int seq) {
		String sql = "delete from ADDRESS where SEQ=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("delete() se: " + se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
