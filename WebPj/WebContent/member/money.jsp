<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Money"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>

<section>
  <!--for demo wrap-->
  <h1>회원 매출 조회</h1>
  <center><a href="../context/context.jsp">INDEX</a></center>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>번호</th>
          <th>이름</th>
          <th>고객등급</th>
          <th>매출</th>
        </tr>
        </thead>
       </table> 
  	</div>
  	 <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      <c:forEach var='m' items="${list}">
        <tr>
          <td>${m.seq}</td>
          <td>${m.name}</td>
          <td>${m.grade}</td>
          <td>${m.pricesum}</td>
		</tr>   
	</c:forEach>
      </tbody>
     </table>
   </div>
 </section>

 
<font color='gray' size='4' face='휴먼편지체'>

