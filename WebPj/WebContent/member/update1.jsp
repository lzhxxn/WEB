<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:if test="${empty dto}">
</c:if>

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
MVC Board with JSTL+EL
</h3>
<a href='board.do'>글목록</a>
<hr style='width:600px;'>
<form name='f' method='post' action="board.do?m=update2&seq=${dto.seq}" enctype="multipart/form-data">
<input type='hidden' name='seq' value='${dto.seq}'>
<div style='text-align:center;max-width:600px;margin:0 auto;'>
<table style='width:600px;'>
<tr>
<td style='width:20%;' align='center'>글쓴이</td>
<td><input name='writer' value='${dto.writer}' readonly='readonly' size='67'/></td>
</tr>


<tr>
<td align='center'>이메일</td>
<td><input name='email' value='${dto.email}' size='67'/></td>
</tr>

<tr>
<td align='center'>글제목</td>
<td><input name='subject' value='${dto.subject}' size='67'/></td>
</tr>

<tr>
<td align='center'>글내용</td>
<td><textarea id='ta' name='content' style='width:-webkit-fill-available;min-height:100px;resize:none;'>${dto.content}</textarea></td>
</tr>

<tr>
	<td align="center">첨부파일</td>
	<td>
		<input name="ofname" value="${dto.fname}" size="50"/><a href="board.do?m=delf&fname=${dto.fname}">삭제</a><br>
		파일: <input type="file" name="fname"><br/>
	</td>
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