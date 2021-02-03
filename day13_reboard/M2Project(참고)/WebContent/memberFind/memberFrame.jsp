<%@ page language="java" contentType="text/html;charset=euc-kr"%>
<jsp:include page="/login/loginCheckModul.jsp"/>

<html>
  <head>
    <title>memberFrame.jsp</title>
  </head>
  <frameset rows="150,*">
      <frame src="/M2Project/memberFind/search.jsp" scrolling="no" NORESIZE name="t">
	  <frame src="/M2Project/memberFind/result.jsp" name="r">
  </frameset>
</html>