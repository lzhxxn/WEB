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
	                <b> DB �������� �����͸� ���� �� �� ���� </b>
	            </center>
	                                  
<%
               return; // �׽�Ʈ �� ������..
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
        
	    <font size="4" color="green"><b>�˻� ���</b></font><br><br>
	    <table border="1" width="500" bordercolor="green">
		   
<%
          if(size == 0) // �˻��� DTO�� ���� 
          {
%>
	            <tr align="center">
	              <td><b> �׷� ȸ���� �������� ����... </b></td>
	            </tr>
<%              
          }
          else 
          {
%>
	            <tr align="center">
			      <td width="30">��ȣ</td>
				  <td width="70">�̸�</td>
				  <td width="100">�̸���</td>
				  <td width="200">����ó</td>
				  <td width="100">������</td>
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
