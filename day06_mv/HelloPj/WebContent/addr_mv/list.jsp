<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, soo.mv.model.AddrDTO"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>

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
Address List JSP in Model1 
</h1>
<a href='../'>index</a>
&nbsp;&nbsp;&nbsp;
<a href='input.jsp'>write</a>
<table border='1' cellpadding='7' cellspacing='2' width='50%'>
<tr>
<th>번호</th>
<th>이름</th>
<th>주소</th>
<th>날짜</th>
<th>삭제</th>
</tr>
<%
	ArrayList<AddrDTO> list = addrDao.list();
    if(list.size() != 0){
    	for(AddrDTO dto : list){
%>
        <tr>
			<td align='center'><%=dto.getSeq()%></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getAddr() %></td>
			<td><%=dto.getRdate() %></td>
			<td align='center'><a href='del.jsp?seq=<%=dto.getSeq()%>'>삭제</a></td>
		</tr>
<%    		
    	}
    }else{
%>
         <tr>
			<td align='center' colspan='5'>데이터가 하나도 없음</td>
		 </tr>
<%    	
    }
%>
    
</table>
</center>

