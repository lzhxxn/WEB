<%@ page language="java" contentType="text/html;charset=euc-kr"%>

<%
       String msg = (String)request.getAttribute("msg");
       Boolean result_obj = (Boolean)request.getAttribute("result");
       boolean result = result_obj.booleanValue();
       
       /*out.println("msg : " + msg + "<br>");
       out.println("result_obj : " + result_obj); */
       
       
       // 자바 스크립트 처리
       if(msg.equals("writeok"))
       {
%>
        <script language="javascript">
             if(<%=result%>)
             {
                  alert("글 입력 성공");   
             }
             else 
             {
                  alert("글 입력 실패");
             }
             location.href="rb-list.do?method=list";
        </script>
<% 
       }
       else if(msg.equals("replyDel"))
       {
%>
          <script language="javascript">
             if(<%=result%>)
             {
                  alert("리플 삭제 성공");
             }
             else 
             {
                  alert("리플 삭제 실패!! 리플 작성자의 로그인 ID가 아니거나, 입력된 리플비번이 틀립니다.");
             }
             location.href="rb-content.do?method=content"; 
          </script>
<%
       }
       else if(msg.equals("editok"))
       {
%>
          <script language="javascript">
             if(<%=result%>)
             {
                  alert("수정 성공!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("수정 실패!! 비밀번호가 틀립니다.");
                  history.go(-1);
             }
          </script>
<%
       }
       else if(msg.equals("delok"))
       {
%>
          <script language="javascript">
             if(<%=result%>)
             {
                  alert("삭제 성공!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("삭제 실패!! 비밀번호가 틀립니다.");
                  history.go(-1);
             }
          </script>
<%
       }
       else if(msg.equals("rewriteok"))
       {
%>
          <script language="javascript">
             if(<%=result%>)
             {
                  alert("답글 입력 성공!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("답글 입력 실패!!");
                  history.go(-1);
             }
          </script>
<%
       }
%>