<%@ page language="java" contentType="text/html;charset=euc-kr"%>


<%
     boolean rpJsp = false; //추가 
     String returnPage = (String)session.getAttribute("returnPage"); //추가 
     out.println("##returnPage 1: " + returnPage); //확인!! 
     if(returnPage != null) rpJsp = true; //추가
        
     String id = (String)request.getAttribute("id");
     String pwd = (String)request.getAttribute("pwd");
     
     Integer cc_ref = (Integer)request.getAttribute("cc_ref");
     if(cc_ref == null)
       response.sendRedirect("/M2Project/login.do"); 
     else
     {
        int cc = cc_ref.intValue();
        if(cc == 1)  // id와 pwd가 일치하는 경우 
        {
%>
            <script language="javascript">
                alert("로그인 성공");
                rpJs = <%=rpJsp%>;
                if(!rpJs)
                   location.href="/M2Project/main.do";
                else 
                   location.href="/M2Project/<%=returnPage%>";
                   
                opener.location.reload(true);
                self.close();
            </script> 
<%
        }
        else if(cc == 2) // id가 존재하지 않는 경우 
        {
%>
        <html>
		  <head>
		    <title>login_ok_noId.jsp</title>
			<script language="javascript">
			    function memberJoin()
				{
					 opener.location.href="/M2Project/mb-ssn.do";
					 self.close();
				}
			</script>
		  </head>
		  <body>
		 
		          <b>로그인 실패</b><br><br>
				  <b><%=id%>
				  라는 아이디를 가진 회원은 없습니다.</b><br><br>
				  <a href="javascript:location.href='/M2Project/login.do'">
				     다시 로그인
				  <a> &nbsp;&nbsp;&nbsp;
				  <a href="javascript:alert('구현해 보세요')">회원가입</a> <!-- javascript:memberJoin() -->
				  <br>
				  <a href="javascript:alert('구현해 보세요')">ID를 잊으셨나요?</a>
				  <!--  숙제로 해 오세요.. -->
		
		  </body>
		</html>
<%          
        }
        else if(cc == 3) // id는 존재 , pwd가 일치하지 않는 경우 
        {
 %>
         <html>
		  <head>
		    <title>login_ok_noId.jsp</title>
		  </head>
		  <body>
		 
		          <b>로그인 실패</b><br><br>
				  <b><%=pwd%>라는 비밀번호는 틀립니다.</b>
				  다시 시도해주세요.<br><br>
				  <a href="/M2Project/login.do">다시 로그인</a>
				  <a href="javascript:alert('구현해 보세요')">
				      비밀번호를 잊으셨나요? <!-- 숙제로 해 오세요..-->
				  </a>
		
		  </body>
		</html>
<%
        }
        else // cc == 4
        {
%>
            <script language="javascript">
                alert("갑작스런 서버측 오류");
                location.href="/M2Project/main.do";
                opener.location.reload(true);
                self.close();
            </script> 
<%
        }
     }
%>
