<%@ page language="java" contentType="text/html;charset=euc-kr"%>

<%
       String msg = (String)request.getAttribute("msg");
       Boolean result_obj = (Boolean)request.getAttribute("result");
       boolean result = result_obj.booleanValue();
       
       /*out.println("msg : " + msg + "<br>");
       out.println("result_obj : " + result_obj); */
       
       
       // �ڹ� ��ũ��Ʈ ó��
       if(msg.equals("writeok"))
       {
%>
        <script language="javascript">
             if(<%=result%>)
             {
                  alert("�� �Է� ����");   
             }
             else 
             {
                  alert("�� �Է� ����");
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
                  alert("���� ���� ����");
             }
             else 
             {
                  alert("���� ���� ����!! ���� �ۼ����� �α��� ID�� �ƴϰų�, �Էµ� ���ú���� Ʋ���ϴ�.");
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
                  alert("���� ����!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("���� ����!! ��й�ȣ�� Ʋ���ϴ�.");
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
                  alert("���� ����!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("���� ����!! ��й�ȣ�� Ʋ���ϴ�.");
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
                  alert("��� �Է� ����!!");
                  location.href="rb-list.do?method=list"; 
             }
             else 
             {
                  alert("��� �Է� ����!!");
                  history.go(-1);
             }
          </script>
<%
       }
%>