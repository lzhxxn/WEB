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
<body style="text-align:center;">
<hr style='width:600px;'>
<h1>
MVC Board with JSTL+EL
</h1>
<a href='board.do?m=write'>글쓰기</a>
<hr style='width:600px;'>
<div style='width:600px;margin:0 auto;text-align:center;'>
<table style='width:100%;'>
<tr>
<td style='width:100px;'>글번호</td>
<td>${dto.seq}</td>
</tr>
<tr>
<td style='width:100px;'>글쓴이</td>
<td>${dto.writer}</td>
</tr>
				
<tr>
<td style='width:100px;'>이메일</td>
<td>${dto.email}</td>
</tr>

<tr>
<td style='width:100px;'>글제목</td>
<td>${dto.subject}</td>
</tr>

<tr>
<td style='width:100px;'>글내용</td>
<td>${dto.content}</td>
</tr>
<tr>
<td style='width:100px;'>첨부파일</td>
<td><a href="board.do?m=download&fname=${dto.fname}">${dto.fname}</a></td>
</tr>
<tr>
<td style='width:100px;'>원래파일</td>
<td>${dto.ofname}</td>
</tr>
<tr>
<td style='width:100px;'>파일크기</td>
<td>${dto.fsize}</td>
</tr>

</table>
</div>
<hr style='width:600px;'>
<a href='board.do?m=update1&seq=${dto.seq}'>수정</a>
<a href='board.do?m=del&seq=${dto.seq}'>삭제</a>
<a href='board.do'>목록</a>
</body>
    