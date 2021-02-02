<%@ page language="java" contentType="text/html; charset=utf-8" 
         import="javax.naming.*, javax.sql.*, java.sql.*"%>
<center>
     <h2> Connection Object from DBCP</h2>
<%
     Context initContext = new InitialContext();
     Context envContext  = (Context)initContext.lookup("java:/comp/env");
     DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
     Connection con = ds.getConnection();
%>
     생성된 con: <%=con.hashCode() %>
</center>
