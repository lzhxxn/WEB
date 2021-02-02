<%@page contentType="text/html;charset=utf-8" import="java.sql.*"%>
<jsp:useBean id="pool" class="soo.db.ConnectionPoolBean" scope="application"/>

<%
    //request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	System.out.println("#insert.jsp name: "+name+", addr: " + addr);

    Connection con = null;
	PreparedStatement pstmt = null;
	String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	try{
        con = pool.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		pstmt.executeUpdate();
	}catch(SQLException se){
	}finally{
		try{
			if(pstmt != null) pstmt.close();
			if(con != null) pool.returnConnection(con);
		}catch(SQLException se){
		}
	}

	response.sendRedirect("list.jsp");
%>