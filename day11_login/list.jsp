<%@ page contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board, board.mvc.vo.ListResult"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../login/login_check_modul.jsp"/>
    
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
</head>
<body>
<center>
<font color='gray' size='4' face='휴먼편지체'>
<hr width='600' size='2' color='gray' noshade>
<h3> MVC Board with JSTL+EL</h3>
<font color='gray' size='4' face='휴먼편지체'>
<a href='../'>인덱스</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='board.do?m=write'>글쓰기</a><br/>
</font>
<hr width='600' size='2' color='gray' noshade>

<TABLE border='2' width='600' align='center' noshade>
<TR size='2' align='center' noshade bgcolor='AliceBlue'>
	<th bgcolor='AliceBlue'>no</th>
	<th color='gray'>writer</th>
	<th color='gray'>e-mail</th>
	<th color='gray'>subject</th>
	<th color='gray'>date</th>
</TR>

   <c:if test="${empty listResult.list}">
       <TR align='center' noshade>
          <TD colspan="5">데이터가 없음</TD>
       </TR>
   </c:if> 
   <c:forEach items="${listResult.list}" var="board">
       <TR align='center' noshade>
		<TD>${board.seq}</TD>
		<TD>${board.writer}</TD>
		<TD>${board.email}</TD>
	    <TD>
	      <a href="board.do?m=content&seq=${board.seq}">
		    ${board.subject}
		  </a>
		</TD>
		<TD>${board.rdate}</TD>
	  </TR> 
   </c:forEach>
   
</TABLE>

<hr width='600' size='2' color='gray' noshade>
<font color='gray' size='3' face='휴먼편지체'>
    (총페이지수 : ${listResult.totalPageCount} )
    &nbsp;&nbsp;&nbsp;
    <c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
        <a href="board.do?cp=${i}">
           <c:choose>
               <c:when test="${i==listResult.currentPage}">
                  <strong>${i}</strong>
               </c:when>
	           <c:otherwise>
	              ${i}
	           </c:otherwise>
           </c:choose>
        </a>&nbsp;
    </c:forEach>
    
    
    ( TOTAL : ${listResult.totalCount} )
    
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       페이지 싸이즈 : 
    <select id="psId" name="ps" onchange="f(this)">
       <c:choose>
          <c:when test="${listResult.pageSize == 3}">
              <option value="3" selected>3</option>
              <option value="5">5</option>
		      <option value="10">10</option>
          </c:when>
          <c:when test="${listResult.pageSize == 5}">
              <option value="3">3</option>
              <option value="5" selected>5</option>
		      <option value="10">10</option>
          </c:when>
	      <c:otherwise>
	          <option value="3">3</option>
	          <option value="5">5</option>
	          <option value="10" selected>10</option>
	      </c:otherwise>	
       </c:choose>	
    </select>
    
    <script language="javascript">
       function f(select){
           //var el = document.getElementById("psId");
           var ps = select.value;
           //alert("ps : " + ps);
           location.href="board.do?ps="+ps;
       }
    </script>
    
</font>
<hr width='600' size='2' color='gray' noshade>
    
</center>
</body>
</html>
    
