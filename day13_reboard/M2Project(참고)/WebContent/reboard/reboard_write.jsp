<%@ page language="java" contentType="text/html;charset=euc-kr"%>

<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
    <title>reboard_write.jsp</title>
	<script language="javascript">
	  function checkValue()
	  {
	    if(document.input.subject.value == "")
		{
		  alert("������ �Է����ּ���");
		  return false;
		}
		if(document.input.content.value == "")
		{
		  alert("������ �Է����ּ���");
		  return false;
		}
		if(document.input.writer.value == "")
		{
		  alert("�̸��� �Է����ּ���");
		  return false;
		}
		if(document.input.email.value == "")
		{
		  alert("�̸����� �Է����ּ���");
		  return false;
		}
		if(document.input.pwd.value == "")
		{
		  alert("��й�ȣ�� �Է����ּ���");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body>
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy"><b>�� �� ��</b></font>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="rb-list.do?method=list">���</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='main.do'>����</a>
	  <hr width="600" color="Maroon" size="2" noshade>
      <!-------------------- re ��ȭ 1 ------------------------------->
	  <form name="input" action="rb-write-ok.do" method="post"
	                                     enctype="multipart/form-data">
	  <!-------------------------------------------------------------->
	    <!-- <input type="hidden"  name="method" value="writeOk"> -->
	    <table align="center" width="600" cellspacing="1" 
		                                  cellpadding="3" border="1">
		  <tr>
		    <td align="center" width="20%">����</td>
			<td align="center" width="80%">
			  <input type="text" name="subject" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">����</td>
			<td align="center" width="80%">
			  <textarea name="content" rows="10" cols="60"></textarea>
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">�ۼ���</td>
			<td align="center" width="80%">
			  <input type="text" name="writer" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">�̸���</td>
			<td align="center" width="80%">
			  <input type="text" name="email" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">Ȩ������</td>
			<td align="center" width="80%">
			  <input type="text" name="homepage" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">�н�����</td>
			<td align="center" width="80%">
			  <input type="text" name="pwd" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">÷������</td>
			<td align="center" width="80%">
			  <input type="file" name="filename" size="46">
			</td>
		  </tr>
		  <tr>
		    <td align="center" colspan="2">
			  <input type="button" value="�����ϱ�" onclick="checkValue()">
			  <input type="reset" value="�ٽþ���">
			</td>
		  </tr>
		</table>
	  </form>
	  <hr width="600" color="Maroon" size="2" noshade>
	</center>
  </body>
</html>

<!-- board�������� board_write.html�� �����Ͽ� 
     ROOT�ȿ� reboard�� ������ ����� �� ������ �����Ѵ�.-->