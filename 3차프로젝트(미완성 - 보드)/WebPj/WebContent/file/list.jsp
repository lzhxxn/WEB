<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset='utf-8'>
<center>
	<h1>
		File List MVC  
	</h1>
	<table border='1' cellpadding='7' cellspacing='2' width='50%'>
	    <tr>
		    <th>파일이름</th>
		    <th>파일크기</th>
			<th>삭제</th>
		</tr>
		<c:if test="${fList.size() == 0}">
		    <tr>
			    <td align="center" colspan="3">파일 없음</td>
			</tr>
		</c:if>
		<c:forEach items="${fList}" var="kid">
	        <tr>
			    <td align="center">
			        <a href="file.do?m=download&fname=${kid.name}">${kid.name}</a>
			    </td>
			    <td align="center">${kid.length()}</td>
				<td align="center"><a href="file.do?m=del&fname=${kid.name}">삭제</a></td>
			</tr>
		</c:forEach>
		
    </table>
    <br/>
    <a href="file.do?m=form">업로드 폼</a>
    &nbsp;&nbsp;&nbsp;
    <a href="../index.do">인덱스</a>
</center>	