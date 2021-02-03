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
                   alert("기 가입자 시군요..");
                   location.href="/M2Project/main.do";
              </script>
<%
          }
          else
          {
%>
              <script language="javascript">
                   alert("회원 가입 페이지로 이동합니다.");
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
                   alert("회원 가입 성공 !!");
                   location.href= "/M2Project/main.do";   
              </script>
<%         
           }
           else
           {
%>
              <script language="javascript">
                   yesNo = confirm("회원 가입 실패!! 회원 가입페이지로 갈까요?");
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
