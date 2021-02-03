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
  <body>
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy"><b>글 쓰 기</b></font>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="rb-list.do?method=list">목록</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='main.do'>메인</a>
	  <hr width="600" color="Maroon" size="2" noshade>
      <!-------------------- re 변화 1 ------------------------------->
	  <form name="input" action="rb-write-ok.do" method="post"
	                                     enctype="multipart/form-data">
	  <!-------------------------------------------------------------->
	    <!-- <input type="hidden"  name="method" value="writeOk"> -->
	    <table align="center" width="600" cellspacing="1" 
		                                  cellpadding="3" border="1">
		  <tr>
		    <td align="center" width="20%">제목</td>
			<td align="center" width="80%">
			  <input type="text" name="subject" size="60">
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

<!-- board폴더안의 board_write.html을 가공하여 
     ROOT안에 reboard란 폴더를 만들고 그 하위에 저장한다.-->