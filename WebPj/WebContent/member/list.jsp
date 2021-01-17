<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Member"%>

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>

<section>
  <!--for demo wrap-->
  <h1>회원 리스트</h1>
  <center><a href="../context/context.jsp">INDEX</a></center>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>NO</th>
          <th>NAME</th>
          <th>EMAIL</th>
          <th>PHONE</th>
          <th>ADDR</th>
		  <th>GRADE</th>
		  <th>JOINDATE</th>
        </tr>
        </thead>
       </table> 
  	</div>
  	 <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    if(list.size() != 0){
    	for(Member member: list){
%>
 
        <tr>
          <td><%=member.getSeq()%></td>
          <td><%=member.getName()%></td>
          <td><a href='../member/member.do?m=content&seq=<%=member.getSeq()%>'><%=member.getEmail()%></a></td>
          <td><%=member.getPhone()%></td>
          <td><%=member.getAddr()%></td>
          <td><%=member.getGrade()%></td>
          <td><%=member.getJoindate()%></td>
        
<%    		
    	}
%>
	</tr>   
      </tbody>
     </table>
   </div>
 </section>
<%
    }else{
%>
       <TR align='center' noshade>
          <TD colspan="6">데이터가 없음</TD>
       </TR>
<%    	
    }
%> 
 <div style="text-align:center;">
<form action=/member/member.do?m=select>
	<select name="ch1">
		<option value="name">이름</option>
		<option value="addr">주소</option>
	</select>
	<input type="text" name="ch2">
	<input type="submit" value="검색하기">
</form>
</div>
<font color='gray' size='4' face='휴먼편지체'>


