<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Goods"%>

<link href="../css/list.css" rel="stylesheet" type="text/css" media="all" />
<script src='../js/list.js'></script>

<section>
   <g font-family="카페24 아네모네">
  <h1>상품 목록</h1>
   <center>
  <a href="../context/context.jsp">INDEX</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="../goods/form.jsp">상품등록</a></center>
  </center>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>상품코드번호</th>
          <th>상품이름</th>
          <th>상품사진</th>
          <th>상품설명</th>
		  <th>상품등록날짜</th>
		  <th>삭제</th>
		  <th>이미지</th>
        </tr>
        </thead>
       </table> 
  	</div>
  	 <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
      </g>
<%
	ArrayList<Goods> list = (ArrayList<Goods>)request.getAttribute("list");
    if(list.size() != 0){
    	for(Goods goods: list){
%>
        <tr>
          <td><%=goods.getSeq()%></td>
          <td><%=goods.getName()%></a></td>
          <td><img src="../goods/photo/<%=goods.getFname()%>" width=70 height=70 align="center"/></td>
          <td><%=goods.getEtc()%></td>
          <td><%=goods.getRdate()%></td>
          <td><a href="../goods/goods.do?m=del&seq=<%=goods.getSeq()%>">삭제</a></td>
          <td><a href="../goods/goods.do?m=download&fname=<%=goods.getFname()%>">다운로드</a></td>
        
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
          <center><TD colspan="5">데이터가 없음</TD></center>
       </TR>
<%    	
    }
%> 

