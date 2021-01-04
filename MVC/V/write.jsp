<%@page contentType="text/html;charset=utf-8" %>

<html>
  <head>
    <meta charset="utf-8">
    <title> BOARD Write JSP in Model2</title>
    <style>
		table, th, td {
		   border: 1px solid black;
		   border-collapse: collapse;
		}
		th, td {
		   padding: 5px;
		}
		a { text-decoration:none }
	</style>
	<script language="javascript">
	   function check()
	   {
	       for(var i=0; i<document.input.elements.length; i++)
		   {
		      if(document.input.elements[i].value == "")
			  {
			     alert("모든 값을 입력 하셔야 합니다. ");
				 return false;
			  }
		   }
		   document.input.submit();
       }
	</script>
  </head>
  <body onload="input.writer.focus()">
	<font color="gray" size='4' face="휴먼편지체">
    <center>
	   <hr width="600" size='2' color="gray" noshade>
	      <h3>  BOARD Write JSP in Model2 </h3>
		  	<font color="gray" size="3" face="휴먼편지체">
			<a href='../'>글목록</a>
			</font>
	   <hr width="600" size="2" color="gray" noshade>
	</center>

	<form name="input" method="post" action="board.do?m=insert">
	   <table border="0" width="500" align="center"  cellpadding="3" cellspacing="1" bordercolor="gray">
	      <tr>
		     <td width="30%" align="center">WRITER</td>
			 <td><input type="text" name="writer" size="70"></td>
		  </tr>
		  <tr>
		     <td align="center">EMAIL</td>
			 <td><input type="text" name="email" size="70"></td>
		  </tr>
          <tr>
		     <td align="center">SUBJECT</td>
			 <td><input type="text" name="subject" size="70"></td>
		  </tr>
		  <tr>
		     <td align="center">CONTENT</td>
			 <td><textarea  name="content" rows="15" cols="60"></textarea></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="전송" onclick="check()">
				<input type="reset" value="다시입력" onclick="input.writer.focus()">
			 </td>
		  </tr>
	   </table>
	   <hr width="600" size="2" color="gray" noshade>
	</form>
	</font>
  </body>
</html>