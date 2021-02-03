<%@ page language="java" contentType="text/html;charset=euc-kr"
              import="soo.rb.model.RBDTO"
              import="soo.mb.model.MbDTO"
              import="java.util.ArrayList"
              import="soo.rb.model.ReplyDTO"
%>



<%
     RBDTO dto = (RBDTO)request.getAttribute("dto_content");
     //out.println("dto : " + dto + "<br>");
     ArrayList dtos_reply = (ArrayList)request.getAttribute("dtos_reply");
     //out.println("dtos_reply : " + dtos_reply + "<br>");
%>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
    <title>reboard_content.jsp</title>
  </head>
  <body>
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy">
		  <b>SOO board</b>
		</font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="rb-list.do?method=list">���</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='main.do'>����</a>
		  
	  <hr width="600" color="Maroon" size="2" noshade>


	  <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1" id="table">
		<tr>
		  <td align="center" width="15%"><b>����</b></td>
		  <td align="center" width="35%">&nbsp;<%=dto.getIdx()%></td>
		  <td align="center" width="15%"><b>��¥</b></td>
		  <td align="center" width="35%">
			&nbsp;<%=dto.getWritedate()%>
		  </td>
		</tr>
		<tr>
		  <td align="center" width="15%"><b>�۾���</b></td>
		  <td align="center" width="35%">
			&nbsp; <%=dto.getWriter()%>
	      </td>
		  <td align="center" width="15%"><b>HomePage</b></td>
		  <td align="center" width="35%">
		    &nbsp;<%=dto.getHomepage()%>
		  </td>
		</tr>
		<tr>
		  <td colspan="3">&nbsp;</td>
		  <td><b>��ȸ��</b> : <%=dto.getReadnum()%></td>
		</tr>
		<tr>
		  <td colspan="2"><b>����</b> : <%=dto.getSubject()%></td>
		  <td colspan="2"><b>÷������</b>:
<%  
      int index = -1;
      String filename_simple = "";
      String filename = dto.getFilename();
      if(filename == null) 
      {
           filename = "";
      }
      else
      {
         index = filename.indexOf("_"); 
         if(index != -1) filename_simple = filename.substring(index+1); 
         
%>
               <a href="reboard/rb_filedown_util.jsp?filename=<%=dto.getFilename()%>">
		         <%=filename_simple%>(<%=dto.getFilesize()%> bytes)
			   </a>
<%
      }
%>
		  </td>
		</tr>
		<tr>
<%
      String content = dto.getContent();
      if(content == null) content = "";
%>
		  <td colspan="4"><%=content%></td>
		</tr>
		<tr>
		  <td colspan="4" align="center">
		    <hr width="550" color="Maroon" size="2" noshade>
			<!----------------- re ��ȭ 2 ---------------->
			<a href="rb-list.do?method=list">���</a> | 
			<a href="rb-edit.do?method=edit">����</a> | 
			<a href="rb-del.do?method=del">����</a> | 
			<a href="rb-rewrite.do?method=rewrite&subject=<%=dto.getSubject()%>">�亯</a>
		    <!-- <a href=
	"reboard_rewrite.jsp?idx=13&ref=9&lev=0&sunbun=0&cp=1">
			  �亯
		    </a> -->
			
			<!-------------------------------------------->
		  </td>
		</tr>
		<tr align="center" id="ta">
		  <td>
		     ���ôޱ� 
		  </td>
<%
          boolean loginJsp = false;
          MbDTO mbDto =  (MbDTO)session.getAttribute("loginOkUser");
          if(mbDto != null) loginJsp = true;
%>
          <script language="javascript">
              loginJs = <%=loginJsp%>;
              function check()
              {
                  if(!loginJs)
                  {
                      yesNo = confirm(
                         "���� �α����� �ϼž� �մϴ�. �α��� �������� �̵��ұ��?");
                      if(yesNo)
                      {
                         location.href="/M2Project/login.do";
 <%
                         session.setAttribute("returnPage", "rb-content.do?method=content"); // ���� ������ ���� 
 %> 
                      }
                      
                      return;
                  }
                  else
                  {
                      if(f1.content_reply.value == "" || f1.pwd_reply.value == "")
	                  {
	                      alert("���� ����� ��й�ȣ�� ��� �Է��ϼž� �մϴ�.");
	                      return;
	                  }
                  	  f1.submit();
                  }
              }
          </script>
		  <form name="f1" action="rb-reply-save.do">
			  <td colspan="3">
			     <input type="hidden" name="method" value="replySave">
				 <input type="text" name="content_reply" size="50">
				 &nbsp;&nbsp;��й�ȣ
				 <input type="text" name="pwd_reply" size="10">
				 <input type="button" value="���" onclick="check()">
			  </td>
		  </form>
		</tr>
	  </table>
	  
	  <br><hr width="600" color="Maroon" size="2" noshade><br>
	  
	  
<script language="javascript">     
      function replyDelCheck(idx_reply)
      {
          //alert("loginJs : " + loginJs);
          //alert("idx_reply : " + idx_reply);
          if(!loginJs) //�α��� ���� 
          {
             
             alert("�α��� or ������ ��й�ȣ�� �Է��ϼž� �մϴ�.");
             yesNo = confirm("�α����� �Ͻðڽ��ϱ�?");
             if(yesNo)
             {
                  location.href="/M2Project/login.do";   
<%
                  session.setAttribute("returnPage", "rb-content.do?method=content"); // ���� ������ ���� 
%>      
             }
             else
             {
                   pwd_reply = prompt("���� ��й�ȣ�� �Է����ּ���..");
                   location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply+"&pwd_reply="+pwd_reply;
             }
          }
          else  // �α��� �� 
          {
               location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply;
          }
      }
</script>
      <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1"> 
		 <tr align="center">
		     <td colspan="2">
			    <font color="red"><b>R E P L Y</b></font>
			 </td>
		 </tr>

<%
           int size = dtos_reply.size();
           for(int i=0; i<size; i++)
           {
               ReplyDTO replyDto = (ReplyDTO)dtos_reply.get(i);
%>
                     <tr align="center">
                       <td width="90%">
<%=replyDto.getContent()%><br>
(writer:<%=replyDto.getWriter()%>, writedate:<%=replyDto.getWritedate()%>)

					   </td>
					   <td width="10%"> 
					     <a href="javascript:replyDelCheck(<%=replyDto.getIdx_reply()%>)">
	                     ����</a>
					   </td>
				     <tr>        
<%
           }
%>
	  </table>
	</center>
  </body>
</html>