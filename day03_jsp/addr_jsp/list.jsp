<%@page contentType="text/html;charset=utf-8" import="java.sql.*"%>

<%!
    Connection con;
	Statement stmt;
	public void jspInit(){
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "servlet", "java");
			stmt = con.createStatement();
		}catch(ClassNotFoundException cnfe){
			System.out.println("init() cnfe: 드라이버(ojbc8.jar)를 못찾음");
		}catch(SQLException se){
			System.out.println("init() se: " + se);
		}
	}
	public void jspDestroy(){
		try{
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException se){
		}
	}
%>
<meta charset='utf-8'>
<style>
table, th, td {
border: 1px solid black;
border-collapse: collapse;
}
th, td {
padding: 5px;
}
a { text-decoration:none }
</style>
<center>
<h1>
Address List JSP 
</h1>
<a href='../'>index</a>
&nbsp;&nbsp;&nbsp;
<a href='input.html'>write</a>
<table border='1' cellpadding='7' cellspacing='2' width='50%'>
<tr>
<th>번호</th>
<th>이름</th>
<th>주소</th>
<th>날짜</th>
<th>삭제</th>
</tr>
<%
    ResultSet rs = null;
		String sql = "select * from ADDRESS order by SEQ desc";
		try{
			rs = stmt.executeQuery(sql);
			boolean flag = false;
			while(rs.next()){
				flag = true;
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				Date rdate = rs.getDate(4);
%> 
                <tr>
					<td align='center'><%=seq%></td>
					<td><%=name%></td>
					<td><%=addr%></td>
					<td><%=rdate%></td>
					<td align='center'><a href='del.jsp?seq=<%=seq%>'>삭제</a></td>
				</tr>
<%
			}

			if(!flag){
				out.println("<tr>");
					out.println("<td colspan='5' align='center'>데이터 없음</a>");
				out.println("</tr>");
			}
		}catch(SQLException se){
		}finally{
			try{
				if(rs != null) rs.close();
			}catch(SQLException se){}
		}
%>

</table>
</center>

