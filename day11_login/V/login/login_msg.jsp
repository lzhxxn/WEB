<%@page import="login.mvc.model.LoginCase"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<script>
   if(${rCode} == <%=LoginCase.NO_ID%>){
	   alert("로긴 실패( 없는 아이디 )");
   }else if(${rCode} == <%=LoginCase.NO_PWD%>){
	   alert("로긴 실패( 틀린 비번 )");
   }else{
	   alert("로긴 성공");
   }
   
   location.href="../index.do";
</script>