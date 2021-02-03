<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="soo.mb.model.MbDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<script language="javascript">
       function f_login()
       {
           baby_login = window.open(
           "/M2Project/login.do", "login_name", 
                "width=300, height=150, top=100, left=100");
       }
    </script>
</head>
<body>
	<center>
		<strong>Eclipse Project01</strong>
		<br><br>
		 <a href="rb-list.do?method=list&tn=0">답변형 게시판 0</a> |
		 <a href="rb-list.do?method=list&tn=1">답변형 게시판 1</a> |
		 <a href="rb-list.do?method=list&tn=2">답변형 게시판 2</a>
		 <br><br>
		 <br>
<%
       MbDTO dto =  (MbDTO)session.getAttribute("loginOkUser");
       //out.println("main.jsp의 dto : " + dto);
       if(dto == null)
       {
%>
		 <a href="javascript:f_login()">로그인</a>
<%
       }
       else
       {
%>
		 <a href="/M2Project/logout.do">로그아웃</a> 
		 <br><br>
         <font color="blue"><%=dto.getName()%></font>님 어솨~!
<%
       }
%>
       <br><br>
	</center>
	
</body>
</html>