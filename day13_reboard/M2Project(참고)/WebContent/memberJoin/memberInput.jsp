<%@ page contentType="text/html;charset=euc-kr" 
               info="memberInput.jsp" import="soo.mb.controller.MbForm"
%>

<%
      /*String name = (String)request.getParameter("name");
      name = Han.toKor(name);
      String ssn = (String)request.getParameter("ssn");
      
      if(name == null || name.equals("") || ssn == null || ssn.equals(""))
         response.sendRedirect("/M2Project/mb-ssn.do"); */
         
      MbForm mf = (MbForm)session.getAttribute("mf");
      if(mf == null)
      {
           response.sendRedirect("/M2Project/mb-ssn.do"); 
      }
      else
      {    
	      String name = mf.getName();
	      String ssn1 = mf.getSsn1();
	      String ssn2 = mf.getSsn2();
	      if(name == null || name.equals("") || ssn1 == null || ssn1.equals("")
	           || ssn2 == null || ssn2.equals(""))
	               response.sendRedirect("/M2Project/mb-ssn.do");
	  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>memberInput.jsp</title>
   <script language="javascript">
      function check()
	  {
	     if(f.name.value == "")
		 {
		    alert("이름을 입력해 주세요..");
			return false;
		 }
		 if(f.id.value == "")
		 {
		    alert("아이디를 입력해 주세요..");
			return false;
		 }
		 if(f.pwd.value == "")
		 {
		    alert("비밀번호를 입력해 주세요..");
			return false;
		 }if(f.pwd2.value != f.pwd.value)
		 {
		    alert("비밀번호가 일치하지 않습니다..");
			return false;
		 }
		 if(f.email.value == "")
		 {
		    alert("이메일을 입력해 주세요..");
			return false;
		 }
		 f.submit();
      }
      function idCheck()
      {
          alert("당신이 해봐~!");
      }
   </script>
</head>
<body>
   <center>
     <hr align="center" width="500" size="2" noshade color="Maroon">
	     <strong><font color="Navy" size="5" >회원 가입 </font></strong>
	 <hr align="center" width="500" size="2" noshade color="Maroon">
	 
     <form name="f" method="post" action="/M2Project/mb-insert.do">
	   <!--<input type="hidden" name="name" value="<%--<%=name%>--%>"> -->
	   <!--<input type="hidden" name="ssn" value="<%--<%=ssn%>--%>">-->
       <table width="500" border="1" align="center" cellpadding="7" cellspacing="1" bordercolor="Maroon">
         <tr>
           <td colspan="2"><div align="center"><strong><font size="4">회원가입 폼</font></strong></div></td>
         </tr>
         <tr>
           <th scope="row">아이디</th>
           <td><input name="id" type="text" size="30" maxlength="30">
              &nbsp;
              <input type="button" value="중복확인" onclick="idCheck()">
           </td>
         </tr>
         <tr>
           <th scope="row">비밀번호</th>
           <td><input name="pwd" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <th scope="row">비밀번호확인</th>
           <td><input name="pwd2" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <th scope="row">이메일</th>
           <td><input name="email" type="text" size="45" maxlength="45"></td></td>
         </tr>
         <tr>
           <th scope="row">연락처</th>
           <td><input name="phone" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <td colspan="2"><div align="center">
		     <input name="" type="button" value="가입" onclick="check()">
		     <input name="" type="reset" value="다시쓰기">
	       </div></td>
         </tr>
       </table>
     </form>
   </center>
</body>
</html>
