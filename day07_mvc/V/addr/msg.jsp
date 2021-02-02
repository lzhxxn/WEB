<%@page contentType="text/html;charset=utf-8" %>
<%
    boolean flag = (Boolean)request.getAttribute("flag");
%>
<script language="javascript">
    if(<%=flag%>){
    	alert("삭제 성공");
    }else {
    	alert("삭제 실패");
    }
    
    location.href="addr.do"; //redirect 시킴 by js 
</script>