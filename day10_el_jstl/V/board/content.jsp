<%@ page contentType="text/html; charset=utf-8" import="mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:if test="${empty board}">
    <c:redirect url="board.do"/>
</c:if>

  <!DOCTYPE html>
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
	<meta charset="utf-8">
	<center>
		<font color='gray' size='4' face='휴먼편지체'>
		<hr width='600' size='2' color='gray' noshade>
		<h3>MVC Board with JSTL+EL</h3>
		<font color='gray' size='4' face='휴먼편지체'>
		<a href='board.do?m=write'>글쓰기</a>
		</font>
		<hr width='600' size='2' color='gray' noshade>
		</font>
		
		<table border='2' width='600' align='center' noshade>
		<tr>
		<td width='20%' align='center'>No</td>
		<td>${board.seq}</td>
		</tr>
		<tr>
		<td width='20%' align='center'>Writer</td>
		<td>${board.writer}</td>
		</tr>
		<tr>
		<td align='center'>E-mail</td>
		<td>${board.email}</td>
		</tr>
		<tr>
		<td align='center'>Subject</td>
		<td>${board.subject}</td>
		</tr>
		<tr>
		<td align='center'>Contents</td>
		<td>${board.content}</td>
		</tr>
		</table>
		
		<hr width='600' size='2' color='gray' noshade>
		<font color='gray' size='4' face='휴먼편지체'>
		<a href='board.do?m=update&seq=${board.seq}'>수정</a>
		 &nbsp;&nbsp;| 
		<a href='board.do?m=del&seq=${board.seq}'>삭제</a>
		 &nbsp;&nbsp;| 
		<a href='board.do?m=list'>목록</a>
		</font>
		<hr width='600' size='2' color='gray' noshade>
	</center>   
