<%@ page language="java" contentType="text/html;charset=euc-kr"%>


<%
        String returnPage = (String)session.getAttribute("returnPage"); //�߰� 
        //out.println("returnPage : " + returnPage); //Ȯ�� !! 
%>
<html>
  <head>
    <title>login.jsp</title>
	<style type="text/css">
	   table{text-align: center} 
	</style>
	<script language="javascript">
	   function check()
	   {
	      if(f.id.value == "")
		  {
		      alert("���̵� �Է��ϼž� �մϴ�.");
			  f.id.focus();
			  return false;
		  }
		  if(f.pwd.value == "")
		  {
		      alert("��й�ȣ�� �Է��ϼž� �մϴ�.");
			  f.pwd.focus();
			  return false;
		  }
		  f.submit();
	   }
	   function rewrite()
	   {
	      f.id.focus();
	   }
	</script>
  </head>
  <body onload="f.id.focus();">
     <form name="f" action="/M2Project/login-ok.do" method="post">
	    <input type="hidden" name="fp" value="/soo.jsp">
	    <table align="center" cellpadding="3" cellspacing="1" 
		                          border="1" bordercolor="Maroon">
           <tr>
		     <td colspan="2" align="center">
			   <font size="4"><B>�α���</B></font>
			 </td>
		   </tr>
		   <tr>
		     <td>���̵�</td>
			 <td><input type="text" name="id" size="20"></td>
		   </tr>
		   <tr>
		     <td>��й�ȣ</td>
			 <td><input type="password" name="pwd" size="20"></td>
		   </tr>
		   <tr>
		     <td colspan="2" align="center"> 
			    <input type="button" value="�α���" onclick="check()">
				<input type="reset" value="�ٽ��Է�" onclick="rewrite()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="�ݱ�" onclick="self.close()">
			 </td>
		   </tr>
		</table>
	 </form>
  </body>
</html> 

