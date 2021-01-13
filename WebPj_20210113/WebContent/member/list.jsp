<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Member, member.mvc.vo.ListResult"%>

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>

<section>
  <!--for demo wrap-->
  <h1>회원 목록</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
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
          <td><%=member.getName()%></td>
          <td><%=member.getEmail()%></td>
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
<font color='gray' size='4' face='휴먼편지체'>
<center>
<a href="../context/context.jsp">CONTEXT</a></center>
