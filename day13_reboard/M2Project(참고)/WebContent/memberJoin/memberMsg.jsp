<%@ page contentType="text/html;charset=euc-kr"
              info="memberMsg.jsp" import="soo.mb.controller.MbForm"
%>

<%
      Object kind_obj = request.getAttribute("kind");
      Object result_obj = request.getAttribute("result");
      if(kind_obj == null || result_obj == null)
         response.sendRedirect("/M2Project/mb-ssn.do");
         
      String kind = (String)kind_obj;
      Boolean result_ref = (Boolean)result_obj;
      
         
      boolean result = result_ref.booleanValue();
      
      if(kind.equals("mbCheck"))
      { 
          /*String name = (String)request.getAttribute("name");
          String ssn = (String)request.getAttribute("ssn"); */
          
          Object mf_obj = session.getAttribute("mf");
          if(mf_obj == null) response.sendRedirect("/M2Project/mb-ssn.do"); 
          
          MbForm mf = (MbForm)mf_obj;
          
	      String name = mf.getName();
	      String ssn1 = mf.getSsn1();
	      String ssn2 = mf.getSsn2();
          if(name == null || name.equals("") || ssn1 == null || ssn1.equals("")
               || ssn2 == null || ssn2.equals("") || kind == null || kind.equals(""))
                   response.sendRedirect("/M2Project/mb-ssn.do"); 
              
          if(result)
          {
%>
              <script language="javascript">
                   alert("�� ������ �ñ���..");
                   location.href="/M2Project/main.do";
              </script>
<%
          }
          else
          {
%>
              <script language="javascript">
                   alert("ȸ�� ���� �������� �̵��մϴ�.");
                   location.href="/M2Project/mb-input.do";   
              </script>
<%
          }
      }
      else // kind.equals("mbInsert")
      {
           if(result) 
           {
%>
              <script language="javascript">
                   alert("ȸ�� ���� ���� !!");
                   location.href= "/M2Project/main.do";   
              </script>
<%         
           }
           else
           {
%>
              <script language="javascript">
                   yesNo = confirm("ȸ�� ���� ����!! ȸ�� ������������ �����?");
                   if(yesNo)
                   {
                       location.href="/M2Project/mb-ssn.do"; 
                   }  
                   else
                   {
                       location.href= "/M2Project/main.do";   
                   }
              </script>
<%      
           }
      }    
%>
