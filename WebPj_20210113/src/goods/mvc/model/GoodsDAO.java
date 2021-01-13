package goods.mvc.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Board;
import mvc.domain.Goods;

import static goods.mvc.model.GoodsSQL.*;


class GoodsDAO {
	private DataSource ds;
	
	GoodsDAO() {
		try {
		  Context initContext = new InitialContext();
		  Context envContext  = (Context)initContext.lookup("java:/comp/env");
		  ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<Goods> list(){
		ArrayList<Goods> list = new ArrayList<Goods>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = LIST;
		//Goods m = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String fname = rs.getString("fname");
				String ofname = rs.getString("ofname");
				int fsize = rs.getInt("fsize"); 
				String etc = rs.getString("etc");
				String rdate = rs.getString("rdate");
				Goods m = new Goods(seq, name, etc, fname, ofname, fsize, rdate);
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
	void insert(Goods dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (int) dto.getSeq());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEtc());
			pstmt.setString(4, dto.getFname());
			pstmt.setString(5, dto.getOfname());
			pstmt.setLong(6, dto.getFsize());
			pstmt.setString(7, dto.getRdate());
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
}
	
