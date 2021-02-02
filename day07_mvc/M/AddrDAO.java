package addr.mvc.model;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Address;
import static addr.mvc.model.AddrSQL.*;

class AddrDAO {
	private DataSource ds;
	AddrDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Address> list(){
		ArrayList<Address> dtos = new ArrayList<Address>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				java.sql.Date rdate = rs.getDate(4);
				
				dtos.add(new Address(seq, name, addr, rdate));
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
	void insert(Address dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
		}catch(SQLException se) {	
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
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
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
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
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
