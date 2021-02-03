<%@ page language="java" contentType="text/html;charset=euc-kr"
              info="loginCheckModul.jsp" import="soo.mb.model.MbDTO"
%>


<%
     MbDTO dto =  (MbDTO)session.getAttribute("loginOkUser");
     //out.println("loginCheckModul.jsp의 dto : " + dto);
     if(dto == null)
     {
%>
         <script language="javascript">
             alert("먼저 로그인을 하세요.");
             location.href="/M2Project/main.do";
         </script>
<%
         return;
     }
%>
