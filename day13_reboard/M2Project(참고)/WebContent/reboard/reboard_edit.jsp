<%@ page language="java" contentType="text/html;charset=euc-kr"
               import="soo.rb.model.RBDTO"
%>

<%
      RBDTO dto = (RBDTO)request.getAttribute("dto");
      //out.println("edit.jsp�� dto : " + dto);
      if(dto == null)
      {
          response.sendRedirect("rb-list.do?method=list");       
      }
%>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
	<title>reboard_edit.jsp</title>
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
		  alert("ó�� ���� ��й�ȣ�� �Է����ּ���");
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
	  <!------------------------ re ��ȭ 1 --------------------------->
	  <form name="input" action="rb-edit-ok.do?method=editOk" method="post">
	  <!------------------------------------------------------------->
	   <!-- ������ �̿��Ͽ� �� ��ȣ�� �ѱ��. -->
	   <!-- <input type="hidden" name="idx" value="14"> --> 

		<table align="center" width="600" cellspacing="1" 
										  cellpadding="3" border="1">
		  <tr>
			<td align="center" width="20%">����</td>
			<td align="center" width="80%">
			  <input type="text" name="subject" size="60" value="<%=dto.getSubject()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">����</td>
			<td align="center" width="80%">
<%
      String content = dto.getContent();
      if(content == null) content = "";
%>
			  <textarea name="content" rows="10" cols="60"><%=content%></textarea>
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">�ۼ���</td>
			<td align="center" width="80%">
			  <input type="text" name="writer" size="60" value="<%=dto.getWriter()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">�̸���</td>
			<td align="center" width="80%">
			  <input type="text" name="email" size="60" value="<%=dto.getEmail()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">Ȩ������</td>
			<td align="center" width="80%">
			  <input type="text" name="homepage" size="60" value="<%=dto.getHomepage()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">�н�����</td>
			<td align="center" width="80%">
			  <input type="text" name="pwd" size="60">
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







