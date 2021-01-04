<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board"%>
    
 <%
 	Board dto = (Board)request.getAttribute("dto");
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
<body style="text-align:center;">
<hr style='width:600px;'>
<h1>
BOARD List JSP in Model2
</h1>
<a href='writer.jsp'>글쓰기</a>
<hr style='width:600px;'>
<div style='width:600px;margin:0 auto;text-align:center;'>
<table style='width:100%;'>
<tr>
<td style='width:100px;'>글번호</td>
<td><%=dto.getSeq()%></td>
</tr>
<tr>
<td style='width:100px;'>글쓴이</td>
<td><%=dto.getWriter()%></td>
</tr>
				
<tr>
<td style='width:100px;'>이메일</td>
<td><%=dto.getEmail()%></td>
</tr>

<tr>
<td style='width:100px;'>글제목</td>
<td><%=dto.getSubject()%></td>
</tr>

<tr>
<td style='width:100px;'>글내용</td>
<td><%=dto.getContent()%></td>
</tr>
</table>
</div>
<hr style='width:600px;'>
<a href='board.do?m=update1&seq=<%=dto.getSeq()%>'>수정</a>
<a href='board.do?m=del&seq=<%=dto.getSeq()%>'>삭제</a>
<a href='board.do'>목록</a>
</body>
    