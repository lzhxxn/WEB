<%@ page language="java" contentType="text/html;charset=euc-kr"
              import="java.util.*, soo.rb.model.RBDTO"
%>


<%
      ArrayList list = (ArrayList)request.getAttribute("rb_list");
      Integer tgc_obj = (Integer)request.getAttribute("tgc");
      Integer cp_obj = (Integer)request.getAttribute("cp");
      Integer ps_obj = (Integer)request.getAttribute("ps");
      /*out.println("list 객체 : " + list + "<br>");
      out.println("tgc_obj 객체 : "+ tgc_obj + "<br>");
      out.println("cp_obj 객체 : " + cp_obj + "<br>");
      out.println("ps_obj 객체 : " + ps_obj + "<br>"); */
      int tgc = tgc_obj.intValue();
      int cp = cp_obj.intValue();
      int ps = ps_obj.intValue();
           
      // 전체페이지갯수를 구한다. 
      int totalPageCount = tgc/ps;
	  if(tgc%ps != 0) totalPageCount += 1;
	  if(cp > totalPageCount)
	  {
         cp = totalPageCount;
         response.sendRedirect("rb-list.do?method=list&cp="+cp); //중요!!
	  }
%>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">

<html>
  <head> 
    <title>reboard_list_partSel.jsp</title>
  </head>
  <body>
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy">
		  <b>SOO board</b>
		</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="rb-write.do?method=write">글쓰기</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='main.do'>메인</a>
		
		<form name="f">
		  <input type="hidden"  name="method" value="list">
		  <select name="ps" onChange="submit()">
<%
          if(ps == 3)
		  {
%>
              <option value="3" selected>페이지 SIZE 선택</option>
<%
		  }
		  else 
		  {
%>
              <option value="3">페이지 SIZE 선택</option>
<%
		  }
          for(int i=5; i<=20; i+=5)
		  {
	              if(ps == i)
				  {
					  out.println(
	"<option value="+i+" selected>페이지 SIZE "+i+"</option>");
					  continue;
				  }
				  out.println(
	"<option value="+i+">페이지 SIZE "+i+"</option>");
		  }
%>
		  </select>
		</form>
		
	  <hr width="600" color="Maroon" size="2" noshade>

	  <table align="center" cellspacing="1" cellpadding="3" 
	                                   width="600" border="1">
		<tr align="center">
		  <td width="10%">
		    <b>순번</b>
		  </td>
		  <td width="40%"><b>제목</b></td>
		  <td width="15%"><b>글쓴이</b></td>
		  <td width="15%"><b>날짜</b></td>
		  <td width="20%"><b>조회수</b></td>
		</tr>
<%
         if(tgc == 0)
         {
%>
                <tr align="center">
				  <td colspan="5">
					 게시 정보 없음
				  </td>        
				<tr>
<%
	            return;
	     }
	     else if(tgc == -1)
	     {
%>
               <tr align="center">
				  <td colspan="5">
					 서버측 예외 
				  </td>        
			   <tr>
<%
	           return;
	     }
%>
<%
        int size = list.size();
        String subject = "";
        String writer = "";
        
        for(int i=0; i<size; i++)
        {
             RBDTO dto = (RBDTO)list.get(i);
%>
                <tr align="center">
				  <td width="10%"><%=dto.getIdx()%></td>
				  <td width="40%" align="left">
				    <% 
				         subject = dto.getSubject();
				         int subject_len = subject.length();
				         
				         if(subject_len > 18)
	                     {
	                        subject = subject.substring(0, 18);
	                        subject = subject + "...";
	                     }
	                     
				         int lev = dto.getLev();
		                 for(int j=1; j<lev; j++)
		                 {
		                     %>&nbsp;&nbsp;&nbsp;<%
		                 }
		                 if(lev>0) 
		                 {
		             %>
                             <img src="/M2Project/reboard/images/icon_bbs_answer.gif">
                     <%
		                 }
		             %>
		            <a href="rb-content.do?method=content&idx=<%=dto.getIdx()%>&cp=<%=cp%>">
                      <%=subject%>
                    <a>
				  </td>
				  <td width="15%">
				    
				    <% 
				         writer = dto.getWriter();
				         int writer_len = writer.length();
				         
				         if(writer_len > 5)
	                     {
	                        writer = writer.substring(0, 5);
	                        writer = writer + "..";
	                     }
	                 %>
                      <%=writer%>
					
				  </td>
				  <td width="15%"><%=dto.getWritedate()%></td>
				  <td width="20%"><%=dto.getReadnum()%></td>
				</tr>
<%
        }
%>
		  <td colspan="5">
		    <hr width="600" color="Maroon" size="2" noshade>
		  </td>
		</tr>
		<tr>
		  <td colspan="3" align="center">
<%
         if(cp > 1)
         {
%>
             <a href="rb-list.do?method=list&cp=<%=cp-1%>&ps=<%=ps%>">
                ◀이전
			 </a>
<%
         }
%>
           |
<%
         int i = 0;
         for(i=1; i<=totalPageCount; i++)
         {
%>
             <a href="rb-list.do?method=list&cp=<%=i%>&ps=<%=ps%>">
<%
                 if(i == cp)
                 {
                     out.println("<b>"+i+"</b>");
                 }
                 else
                 {
                     out.println(i);
                 }
%>
             </a> 
<%
         }
%>
		   |
<%
         if(cp < totalPageCount)
         {
%>
             <a href="rb-list.do?method=list&cp=<%=cp+1%>&ps=<%=ps%>">
			    이후▶
			  </a>
<%
         }
%>
			 &nbsp;&nbsp;&nbsp; 
			<%=cp%>page/<%=totalPageCount%>pages
		  </td>
		  <td colspan="2" align="center">
		    총 게시물 수 : <%=tgc%>
		  </td>
		</tr>
	  </table>
	  <hr width="600" color="Maroon" size="2" noshade>
	</center>
  </body>
</html>

