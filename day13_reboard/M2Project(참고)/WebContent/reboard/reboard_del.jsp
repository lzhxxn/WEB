<%@ page language="java" contentType="text/html;charset=euc-kr"%>

<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
    <title>reboard_del.jsp</title>
    <script language="javascript">
	  function checkValue()
	  {
		  if(document.input.pwd.value == "")
		  {
			  alert("������ ���� ��й�ȣ�� �Է����ּ���.");
			  return false;
		  }
		  document.input.submit();
	  }
	</script>
  </head>
  <body onload="input.pwd.focus()">
    <center>
	  <hr width="500" color="Maroon" size="2">
	    <font face="����" color="navy" size="5">
		  <b>�� ����</b>
		</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="rb-list.do?method=list">���</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='main.do'>����</a>
	  <hr width="500" color="Maroon" size="2">

      <!----------------------- re ��ȭ 2 ---------------------------->
	  <form name="input" action="rb-del-ok.do">
	     <input type="hidden" name="method" value="delOk">
	     <!---------------------------------------------------------->
	    <table>
		  <tr>
		    <td width="20%" align="center">��й�ȣ</td>
			<td><input type="password" name="pwd" size="50"></td>
		  </tr>
		  <tr>
		    <td colspan="2" align="right">
			  <input type="button" value="�����ϱ�" onClick="checkValue()">
			</td>
		  </tr>
		</table>
	  </form>
	</center>
  </body>
</html>