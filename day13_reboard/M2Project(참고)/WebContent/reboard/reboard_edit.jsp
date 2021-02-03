<%@ page language="java" contentType="text/html;charset=euc-kr"
               import="soo.rb.model.RBDTO"
%>

<%
      RBDTO dto = (RBDTO)request.getAttribute("dto");
      //out.println("edit.jsp의 dto : " + dto);
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
		  alert("제목을 입력해주세요");
		  return false;
		}
		if(document.input.content.value == "")
		{
		  alert("내용을 입력해주세요");
		  return false;
		}
		if(document.input.writer.value == "")
		{
		  alert("이름을 입력해주세요");
		  return false;
		}
		if(document.input.email.value == "")
		{
		  alert("이메일을 입력해주세요");
		  return false;
		}
		if(document.input.pwd.value == "")
		{
		  alert("처음 글의 비밀번호를 입력해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body>
	<center>
	  <hr width="600" color="Maroon" size="2" noshade>
		<font size="5" color="Navy"><b>글 편 집</b></font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="rb-list.do?method=list">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='main.do'>메인</a>
	  <hr width="600" color="Maroon" size="2" noshade>
	  <!------------------------ re 변화 1 --------------------------->
	  <form name="input" action="rb-edit-ok.do?method=editOk" method="post">
	  <!------------------------------------------------------------->
	   <!-- 히든을 이용하여 글 번호를 넘긴다. -->
	   <!-- <input type="hidden" name="idx" value="14"> --> 

		<table align="center" width="600" cellspacing="1" 
										  cellpadding="3" border="1">
		  <tr>
			<td align="center" width="20%">제목</td>
			<td align="center" width="80%">
			  <input type="text" name="subject" size="60" value="<%=dto.getSubject()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">내용</td>
			<td align="center" width="80%">
<%
      String content = dto.getContent();
      if(content == null) content = "";
%>
			  <textarea name="content" rows="10" cols="60"><%=content%></textarea>
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">작성자</td>
			<td align="center" width="80%">
			  <input type="text" name="writer" size="60" value="<%=dto.getWriter()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">이메일</td>
			<td align="center" width="80%">
			  <input type="text" name="email" size="60" value="<%=dto.getEmail()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">홈페이지</td>
			<td align="center" width="80%">
			  <input type="text" name="homepage" size="60" value="<%=dto.getHomepage()%>">
			</td>
		  </tr>
		  <tr>
			<td align="center" width="20%">패스워드</td>
			<td align="center" width="80%">
			  <input type="text" name="pwd" size="60">
			</td>
		  </tr>
		  <tr>
			<td align="center" colspan="2">
			  <input type="button" value="전송하기" onclick="checkValue()">
			  <input type="reset" value="다시쓰기">
			</td>
		  </tr>
		</table>
	  </form>
	  <hr width="600" color="Maroon" size="2" noshade>
	</center>
  </body>
</html>







