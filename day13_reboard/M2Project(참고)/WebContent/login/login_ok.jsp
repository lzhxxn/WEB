<%@ page language="java" contentType="text/html;charset=euc-kr"%>


<%
     boolean rpJsp = false; //�߰� 
     String returnPage = (String)session.getAttribute("returnPage"); //�߰� 
     out.println("##returnPage 1: " + returnPage); //Ȯ��!! 
     if(returnPage != null) rpJsp = true; //�߰�
        
     String id = (String)request.getAttribute("id");
     String pwd = (String)request.getAttribute("pwd");
     
     Integer cc_ref = (Integer)request.getAttribute("cc_ref");
     if(cc_ref == null)
       response.sendRedirect("/M2Project/login.do"); 
     else
     {
        int cc = cc_ref.intValue();
        if(cc == 1)  // id�� pwd�� ��ġ�ϴ� ��� 
        {
%>
            <script language="javascript">
                alert("�α��� ����");
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
        else if(cc == 2) // id�� �������� �ʴ� ��� 
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
		 
		          <b>�α��� ����</b><br><br>
				  <b><%=id%>
				  ��� ���̵� ���� ȸ���� �����ϴ�.</b><br><br>
				  <a href="javascript:location.href='/M2Project/login.do'">
				     �ٽ� �α���
				  <a> &nbsp;&nbsp;&nbsp;
				  <a href="javascript:alert('������ ������')">ȸ������</a> <!-- javascript:memberJoin() -->
				  <br>
				  <a href="javascript:alert('������ ������')">ID�� �����̳���?</a>
				  <!--  ������ �� ������.. -->
		
		  </body>
		</html>
<%          
        }
        else if(cc == 3) // id�� ���� , pwd�� ��ġ���� �ʴ� ��� 
        {
 %>
         <html>
		  <head>
		    <title>login_ok_noId.jsp</title>
		  </head>
		  <body>
		 
		          <b>�α��� ����</b><br><br>
				  <b><%=pwd%>��� ��й�ȣ�� Ʋ���ϴ�.</b>
				  �ٽ� �õ����ּ���.<br><br>
				  <a href="/M2Project/login.do">�ٽ� �α���</a>
				  <a href="javascript:alert('������ ������')">
				      ��й�ȣ�� �����̳���? <!-- ������ �� ������..-->
				  </a>
		
		  </body>
		</html>
<%
        }
        else // cc == 4
        {
%>
            <script language="javascript">
                alert("���۽��� ������ ����");
                location.href="/M2Project/main.do";
                opener.location.reload(true);
                self.close();
            </script> 
<%
        }
     }
%>
