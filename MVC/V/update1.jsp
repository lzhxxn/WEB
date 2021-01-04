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
<body style='text-align:center;'>
<hr style='width:600px;'>
<h3>
BOARD List JSP in Model2
</h3>
<a href='board.do'>글목록</a>
<hr style='width:600px;'>
<form name='f' method='post' action="board.do?m=update2">
<input type='hidden' name='seq' value='<%=dto.getSeq()%>'>
<div style='text-align:center;max-width:600px;margin:0 auto;'>
<table style='width:600px;'>
<tr>
<td style='width:20%;' align='center'>글쓴이</td>
<td><input name='writer' value='<%=dto.getWriter()%>' readonly='readonly' size='67'/></td>
</tr>


<tr>
<td align='center'>글쓴이</td>
<td><input name='email' value='<%=dto.getEmail()%>' size='67'/></td>
</tr>

<tr>
<td align='center'>글제목</td>
<td><input name='subject' value='<%=dto.getSubject()%>' size='67'/></td>
</tr>

<tr>
<td align='center'>글내용</td>
<td><textarea id='ta' name='content' style='width:-webkit-fill-available;min-height:100px;resize:none;'><%=dto.getContent()%></textarea></td>
</tr>

<tr>
<td colspan='2' align='center'>
<input type='submit' value='수정'>
</td>
</tr>
		
</table>
</div>
</form>
<hr style='width:600px;'>
</body>