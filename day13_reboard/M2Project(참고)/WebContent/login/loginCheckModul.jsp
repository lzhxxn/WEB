<%@ page language="java" contentType="text/html;charset=euc-kr"
              info="loginCheckModul.jsp" import="soo.mb.model.MbDTO"
%>


<%
     MbDTO dto =  (MbDTO)session.getAttribute("loginOkUser");
     //out.println("loginCheckModul.jsp�� dto : " + dto);
     if(dto == null)
     {
%>
         <script language="javascript">
             alert("���� �α����� �ϼ���.");
             location.href="/M2Project/main.do";
         </script>
<%
         return;
     }
%>
