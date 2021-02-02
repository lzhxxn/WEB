<%@page contentType="text/html;charset=utf-8"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>

<%
    int seq = -1;
	String seqStr = request.getParameter("seq");
	if(seqStr != null){
		seqStr = seqStr.trim();
		if(seqStr.length() != 0){
			try{
				seq = Integer.parseInt(seqStr);
			}catch(NumberFormatException ne){
			}
		}
	}
	
	addrDao.delete(seq);
	response.sendRedirect("list.jsp");
%>