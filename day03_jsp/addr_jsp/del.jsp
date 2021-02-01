<%@page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<%!
    Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	public void jspInit(){ 
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
	public void jspDestroy(){ 
        try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){
		}
	}
%>
<%
    int seq = -1;
	String seqStr = request.getParameter("seq");
	if(seqStr != null){
		seqStr = seqStr.trim();
		if(seqStr.length() != 0){
			try{
				seq = Integer.parseInt(seqStr);
			}catch(NumberFormatException ne){
			}
		}
	}

	try{
		pstmt.setInt(1, seq);
		pstmt.executeUpdate();
	}catch(SQLException se){
	}

	response.sendRedirect("list.jsp");
%>