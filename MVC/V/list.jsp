<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board"%>

<meta charset='utf-8'>
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
</head>
<body>
<center>
<font color='gray' size='4' face='휴먼편지체'>
<hr width='600' size='2' color='gray' noshade>
<h3> BOARD List JSP in Model2  </h3>
<font color='gray' size='4' face='휴먼편지체'>
<a href='../'>인덱스</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='board.do?m=write'>글쓰기</a><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='board.do?m=del_all'>dellAll</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</font>
<hr width='600' size='2' color='gray' noshade>
<TABLE border='2' width='600' align='center' noshade>
<TR size='2' align='center' noshade bgcolor='AliceBlue'>
<th bgcolor='AliceBlue'>번호</th>
<th align='center' width='10%'>작성자</th>
<th align='center' width='30%'>이메일</th>
<th align='center' width='30%'>글제목</th>
<th align='center' width='15%'>작성일</th>
</TR>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	if(list.size() != 0){
		for(Board dto : list){
%>
<TR>
<TD align='center'><%=dto.getSeq()%></TD>
<TD align='center'><%=dto.getWriter()%></TD>
<TD align='center'><%=dto.getEmail()%></TD>
<TD align='center'><a href='board.do?m=content&seq=<%=dto.getSeq()%>'><%=dto.getSubject()%></a></TD>
<TD align='center'><%=dto.getRdate()%></TD>
</TR>
<%    		
    	}
    }else{
%>
         <tr>
			<td align='center' colspan='5'>데이터가 하나도 없음</td>
		 </tr>
<%    	
    }
%>
</table>
</div>