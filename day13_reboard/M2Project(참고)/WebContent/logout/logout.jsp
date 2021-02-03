<%@ page language="java" contentType="text/html;charset=euc-kr"
              info="logout.jsp"
%>

<%
      session.removeAttribute("loginOkUser");
      response.sendRedirect("/M2Project/main.do");
%>
