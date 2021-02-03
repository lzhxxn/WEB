<%@ page language="java" contentType="text/html;charset=euc-kr"
               import="java.util.*, soo.mb.model.MbDTO"
%>


<%
      int size = 0;
      ArrayList list = (ArrayList)request.getAttribute("list");
      Boolean result_ref = (Boolean)request.getAttribute("result_ref");
      if(list == null || result_ref == null)
      {
           response.sendRedirect("/M2Project/memberFind/result.html");
      }
      else
      {    
	      boolean result = result_ref.booleanValue();
	      if(!result)
	      {
	          
%>    
	            <center>
	                <b> DB 서버에서 데이터를 가져 올 수 없음 </b>
	            </center>
	                                  
<%
               return; // 테스트 해 보세요..
	      }
	      else
	      {
	          size = list.size();
	      }  
      }
%>
<html>
  <head>
    <title>result.jsp</title>
  </head>
  <body>
     <center>
        
	    <font size="4" color="green"><b>검색 결과</b></font><br><br>
	    <table border="1" width="500" bordercolor="green">
		   
<%
          if(size == 0) // 검색된 DTO가 없음 
          {
%>
	            <tr align="center">
	              <td><b> 그런 회원은 존재하지 않음... </b></td>
	            </tr>
<%              
          }
          else 
          {
%>
	            <tr align="center">
			      <td width="30">번호</td>
				  <td width="70">이름</td>
				  <td width="100">이메일</td>
				  <td width="200">연락처</td>
				  <td width="100">가입일</td>
			    </tr>
<%            
             for(int i=0; i<size; i++)
             {
                 MbDTO dto = (MbDTO)list.get(i);
%>
	            <tr align="center">
			      <td width="30"><%=dto.getNo()%></td>
				  <td width="70"><%=dto.getName()%></td>
				  <td width="100"><%=dto.getEmail()%></td>
				  <td width="200"><%=dto.getPhone()%></td>
				  <td width="100"><%=dto.getDate_str()%></td>
			    </tr>
<%                
             } 
          }
%>
		</table> 
	 </center>
  </body>
</html>
