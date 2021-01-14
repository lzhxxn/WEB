<%@page import="login.mvc.model.LoginCase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
   if(${rCode} == <%=LoginCase.NO_ID%>){
	   alert("관리자로그인 실패( 없는 아이디 )");
	   location.href="../index.do";
   }else if(${rCode} == <%=LoginCase.NO_PWD%>){
	   alert("관리자로그인 실패( 틀린 비밀번호 )");
	   location.href="../index.do";
   }else{
	   alert("관리자로그인 성공");
	   location.href="../context/context.jsp";
   }
</script>