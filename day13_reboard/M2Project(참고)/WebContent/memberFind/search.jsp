<%@ page language="java" contentType="text/html;charset=euc-kr"%>


<html>
  <head>
    <title>search.jsp</title>
  </head>
  <body>
    <center>

	   <hr width="500" size="2" noshade color="Maroon">
	       <font size="5" color="Navy"><b>SOO's 회원 검색</b></font>
		   &nbsp;&nbsp;&nbsp;&nbsp;
		   <a href="/M2Project/main.do" target="_top">메인</a>
       <hr width="500" size="2" noshade color="Maroon">

	   <form action="/M2Project/mb-search.do" method="post" name="f" target="r">
	      <table align="center" width="500" cellspacing="1" cellpadding="3" border="1">
		    <tr>
			  <td>
			     <select size="1" name="select">
                    <option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="ssn">주민번호</option>
				 </select>
			  </td>
			  <td>
			     <input type="text" size="35" name="searchString">
			  </td>
			  <td>
			     <input type="submit" value="검색">
			  </td>
			</tr>
		  </table>
	   </form>
	</center>
  </body>
</html>