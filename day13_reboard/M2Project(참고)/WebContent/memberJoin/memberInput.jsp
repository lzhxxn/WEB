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
		    alert("�̸��� �Է��� �ּ���..");
			return false;
		 }
		 if(f.id.value == "")
		 {
		    alert("���̵� �Է��� �ּ���..");
			return false;
		 }
		 if(f.pwd.value == "")
		 {
		    alert("��й�ȣ�� �Է��� �ּ���..");
			return false;
		 }if(f.pwd2.value != f.pwd.value)
		 {
		    alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
			return false;
		 }
		 if(f.email.value == "")
		 {
		    alert("�̸����� �Է��� �ּ���..");
			return false;
		 }
		 f.submit();
      }
      function idCheck()
      {
          alert("����� �غ�~!");
      }
   </script>
</head>
<body>
   <center>
     <hr align="center" width="500" size="2" noshade color="Maroon">
	     <strong><font color="Navy" size="5" >ȸ�� ���� </font></strong>
	 <hr align="center" width="500" size="2" noshade color="Maroon">
	 
     <form name="f" method="post" action="/M2Project/mb-insert.do">
	   <!--<input type="hidden" name="name" value="<%--<%=name%>--%>"> -->
	   <!--<input type="hidden" name="ssn" value="<%--<%=ssn%>--%>">-->
       <table width="500" border="1" align="center" cellpadding="7" cellspacing="1" bordercolor="Maroon">
         <tr>
           <td colspan="2"><div align="center"><strong><font size="4">ȸ������ ��</font></strong></div></td>
         </tr>
         <tr>
           <th scope="row">���̵�</th>
           <td><input name="id" type="text" size="30" maxlength="30">
              &nbsp;
              <input type="button" value="�ߺ�Ȯ��" onclick="idCheck()">
           </td>
         </tr>
         <tr>
           <th scope="row">��й�ȣ</th>
           <td><input name="pwd" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <th scope="row">��й�ȣȮ��</th>
           <td><input name="pwd2" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <th scope="row">�̸���</th>
           <td><input name="email" type="text" size="45" maxlength="45"></td></td>
         </tr>
         <tr>
           <th scope="row">����ó</th>
           <td><input name="phone" type="text" size="45" maxlength="45"></td>
         </tr>
         <tr>
           <td colspan="2"><div align="center">
		     <input name="" type="button" value="����" onclick="check()">
		     <input name="" type="reset" value="�ٽþ���">
	       </div></td>
         </tr>
       </table>
     </form>
   </center>
</body>
</html>
