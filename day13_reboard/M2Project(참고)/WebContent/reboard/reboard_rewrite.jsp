<%@ page language="java" contentType="text/html;charset=euc-kr"%>

<%
     String subject = (String)request.getAttribute("subject");
     subject = "(Re)" + subject;
     
     //out.println("subject : " + subject);
%>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
    <title>reboard_rewrite.jsp</title>
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
		  alert("비밀번호를 입력해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body onload="input.content.focus()">
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy"><b>답 변 쓰 기</b></font>
	  <hr width="600" color="Maroon" size="2" noshade>
      
	  <form name="input" action="rb-rewrite-ok.do" 
	                 method="post" enctype="multipart/form-data">

	    <table align="center" width="600" cellspacing="1" 
		                                  cellpadding="3" border="1">
		  <tr>
		    <td align="center" width="20%">제목</td>
			<td align="center" width="80%">
			  <input type="text" size="60" name="subject" value="<%=subject%>">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">내용</td>
			<td align="center" width="80%">
			  <textarea name="content" rows="10" cols="60"></textarea>
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">작성자</td>
			<td align="center" width="80%">
			  <input type="text" name="writer" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">이메일</td>
			<td align="center" width="80%">
			  <input type="text" name="email" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">홈페이지</td>
			<td align="center" width="80%">
			  <input type="text" name="homepage" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">패스워드</td>
			<td align="center" width="80%">
			  <input type="text" name="pwd" size="60">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">첨부파일</td>
			<td align="center" width="80%">
			  <input type="file" name="filename" size="46">
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

