<%@ page contentType="text/html; charset=utf-8" import="mvc.domain.Board"%>

<% 
   Board board = (Board)request.getAttribute("board");
   if(board != null){
%>
     <!DOCTYPE html>
	<html>
	<head>
		<title> MVC Board </title>
		<meta charset="utf-8">
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
		    function f(){
		    	input.email.value = "";
		    	input.subject.value = "";
		    	//input.content.innerText = "";
		    	$("#ta").text("");
		    	
		    	input.email.focus();
		    }
		</script>
	</head>
	<body>
	<center>
	<font color='gray' size='4' face='휴먼편지체'>
	<hr width='600' size='2' color='gray' noshade>
	<h3> MVC Board </h3>
	</font>
	<font color='gray' size='4' face='휴먼편지체'>
	<a href='board.do?m=list'>목록</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='board.do?m=write'>글쓰기</a><br/>
	</font>
	<hr width='600' size='2' color='gray' noshade>
	</center>
	
	<form name='input' method='post' action='board.do?m=updateOk'>
	<input type="hidden" name="seq" value="<%=board.getSeq()%>">
	<table border='0' width='600' align='center' cellpadding='3' cellspacing='1' bordercolor='gray'>	
	<tr>
	   <td width='20%' align='center' >WRITER</td>
	   <td>
	      <input name='writer' readonly value='<%=board.getWriter()%>' size="65"/>
	   </td>
	</tr>
	
	<tr>
		<td align='center'>EMAIL</td>
		<td><input name='email' value="<%=board.getEmail()%>" size="65"/></td>
	</tr>
	
	<tr>
		<td align='center'>SUBJECT</td>
		<td><input name='subject' value="<%=board.getSubject()%>" size="65"/></td>
	</tr>
				
	<tr>
		<td align='center'>CONTENT</td>
		<td><textarea id='ta' name='content' rows='15' cols='67'><%=board.getContent()%></textarea></td>
	</tr>
	<tr>
		 <td colspan='2' align='center'>
			<input type='submit' value='수정'>
			<input type="button" value="다시입력" onclick="f()">
		 </td>
	</tr>
	
	</table>
	<hr width="600" size="2" color="gray" noshade>
	</form>
	</body>
	</html>
<%	   
   }else{
	   response.sendRedirect("board.do");
   }
%>




