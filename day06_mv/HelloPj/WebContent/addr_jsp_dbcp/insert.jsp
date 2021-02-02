<%@page contentType="text/html;charset=utf-8" 
        import="java.sql.*, javax.sql.*"%>
<jsp:useBean id="dbcp" class="soo.dbcp.DbcpBean" scope="application"/>

<%
    //request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");

	DataSource ds = dbcp.getDs();
    Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	try{
        con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		pstmt.executeUpdate();
	}catch(SQLException se){
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se){
		}
	}

	response.sendRedirect("list.jsp");
%>