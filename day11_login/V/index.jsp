<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>MvcPj Index</title> 
	</head>
	<body>
		<div style="text-align:center">
		   <h1>MvcPj Index</h1>
		   <c:if test="${!empty loginPassUser}">
		   		${loginPassUser.name} 님 환영해요*^^*
		   </c:if>
		   
		   <p>
			   <a href="addr/addr.do">주소록(MVC)</a><br/>
			   <a href="board/board.do?cp=1&ps=3">게시판(MVC)</a><br/><br/>
			   
			   
			   <a href="scope/session_test.jsp">세션ID확인</a><br/><br/><br/>
			   
			   <c:choose>
	               <c:when test="${empty loginPassUser}">
	                  <a href="login/login.do?m=form">로그인</a>
	               </c:when>
		           <c:otherwise>
		              <a href="login/login.do?m=out">로그아웃</a>
		           </c:otherwise>
	           </c:choose>
			   
		   </p>
		</div>
	</body>
</html>