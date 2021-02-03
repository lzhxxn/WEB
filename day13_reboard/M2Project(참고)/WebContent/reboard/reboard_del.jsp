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
			  alert("삭제할 글의 비밀번호를 입력해주세요.");
			  return false;
		  }
		  document.input.submit();
	  }
	</script>
  </head>
  <body onload="input.pwd.focus()">
    <center>
	  <hr width="500" color="Maroon" size="2">
	    <font face="돋움" color="navy" size="5">
		  <b>글 삭제</b>
		</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="rb-list.do?method=list">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='main.do'>메인</a>
	  <hr width="500" color="Maroon" size="2">

      <!----------------------- re 변화 2 ---------------------------->
	  <form name="input" action="rb-del-ok.do">
	     <input type="hidden" name="method" value="delOk">
	     <!---------------------------------------------------------->
	    <table>
		  <tr>
		    <td width="20%" align="center">비밀번호</td>
			<td><input type="password" name="pwd" size="50"></td>
		  </tr>
		  <tr>
		    <td colspan="2" align="right">
			  <input type="button" value="삭제하기" onClick="checkValue()">
			</td>
		  </tr>
		</table>
	  </form>
	</center>
  </body>
</html>