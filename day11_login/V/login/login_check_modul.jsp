<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<c:if test="${empty loginPassUser}">
   <script>
	  alert("회원 서비스 입니다. 로긴 먼저 하고 오세요~");
	  location.href="../login/login.do?m=form";
	  
	  //history.back();
	  //history.forward();
	  //history.go(-1);
   </script>
</c:if>