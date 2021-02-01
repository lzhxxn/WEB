package soo.sv.addr;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddrServletDel extends HttpServlet 
{
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	public void init(){ 
	    String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		String sql = "delete from ADDRESS where SEQ=?";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "servlet", "java");
			pstmt = con.prepareStatement(sql);
		}catch(ClassNotFoundException cnfe){
		}catch(SQLException se){
		}
	}
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException { 
		int seq = -1;
		String seqStr = req.getParameter("seq");
        if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					seq = Integer.parseInt(seqStr);
				}catch(NumberFormatException ne){
				}
			}
		}

        //res.setContentType("text/html;charset=utf-8");
		//PrintWriter pw = res.getWriter();
		try{
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
            //pw.println("<h2>삭제 성공</h2>");
			//pw.println("<a href='addr_list.do'>주소록 리스트</a><br/>");
			//pw.println("<a href='./'>인덱스</a>");
		}catch(SQLException se){
		}

		res.sendRedirect("list.do");
	}
	public void destroy(){ 
        try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){
		}
	}
}