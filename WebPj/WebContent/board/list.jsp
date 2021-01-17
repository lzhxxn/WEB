<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board, board.mvc.vo.ListResult"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>
    
<section>
  <!--for demo wrap-->
  <h1>NOTICE</h1>
  <center>
  <a href="../context/context.jsp">INDEX</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href='board.do?m=write'>WRITE</a>
  </center>
  <div class="tbl-header">
 
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>글번호</th>
          <th>글제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>
        </thead>
       </table> 
  	</div>
  	<div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
<%
	ListResult listResult = (ListResult)request.getAttribute("listResult");  /* 원래형을 찾아주기위해  (ListResult) 쓴다 */
	// request에 넣어두었던, ListResult 객체를 뽑아내서 listResult라는 이름으로 대입.
	int cp = listResult.getCurrentPage();
	int ps = listResult.getPageSize();
	long tpc = listResult.getTotalPageCount();
	ArrayList<Board> list = listResult.getList(cp, ps);
	// listResult의 값들을 미리 빼놓고 사용할 준비를 한다.
	if(list != null && list.size() != 0){ //list안에 데이터가 존재하면,
		for(Board dto: list){ //list안에 있는 값들을 하나씩 꺼내서 dto에 넣는다.
%>
<TR>
<!-- // dto에 담긴 데이터들을 뿌려준다. -->
<TD align='center'><%=dto.getSeq()%></TD>
<TD align='center'><a href='board.do?m=content&seq=<%=dto.getSeq()%>'><%=dto.getSubject()%></a></TD>
<TD align='center'><%=dto.getWriter()%></TD>
<TD align='center'><%=dto.getRdate()%></TD>
<TD align='center'><%=dto.getCount()%></TD>
</TR>
<%    		
    	} //for문 닫기
    }else{ //list안에 데이터가 없다면 ?  ( == DB에 데이터가없음 )
%>
         <tr>
			<td align='center' colspan='5'>데이터가 하나도 없음</td>
		 </tr>
<%    	
    } //else문 닫기
%>
 </tbody>
     </table>
   </div>
 </section>

<font color='gray' size='4' face='휴먼편지체'>

<hr style="width:600px;">
<div style="text-align:center;">
	(총 페이지 수 : <%=tpc%>)
	&nbsp;&nbsp;&nbsp;
	<% 
		for(int i=1; i<=tpc; i++){ 
	%>
		<a href="board.do?m=list&cp=<%=i%>&ps=<%=ps%>">
	<%
		if(i==cp){ // 내가있는페이지라면,
	%>
		<strong><%=i%></strong></a>&nbsp; <!-- 굵게표기 -->
	<% 
		} else { // 내가있는 페이지가 아니라면
	%>
		<%=i%></a>&nbsp; <!-- 얇게표기 -->
	<%
			}
		}
	%>
	(TOTAL : <%=listResult.getTotalCount()%> )
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	Page Size :
	<select id="psId" name="ps" onchange="f(this)">  <!-- this -> select. -->
		<%
      if( listResult.getPageSize() == 3){
 %>
           <option value="3" selected>3</option>
           <option value="5">5</option>
		   <option value="10">10</option>
 <%   	  
      }else if(listResult.getPageSize() == 5){
%>
          <option value="3">3</option>
          <option value="5" selected>5</option>
          <option value="10">10</option>
<%   	  
      }else{
%>
          <option value="3">3</option>
          <option value="5">5</option>
          <option value="10" selected>10</option>
<%   	  
      }
 %>   		
<script type="text/javascript">
	
		function f(select){
			var ps = select.value;
			alert("ps : " + ps);
			console.log("ps :"+ps); <%-- 기능 : 웹페이지 콘솔창에 찍힘 (크롬 개발자 도구 : f12 )--%>
			location.href="board.do?ps="+ps;
		}
	</script>
</div>
<hr style="width:600px;">