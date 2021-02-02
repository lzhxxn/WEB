<%@page contentType="text/html;charset=utf-8" 
        import="soo.mv.model.AddrDTO"%>
<jsp:useBean id="addrDao" class="soo.mv.model.AddrDAO" scope="application"/>
<jsp:useBean id="dto" class="soo.mv.model.AddrDTO"/>
<jsp:setProperty name="dto" property="*"/>


<%
	//String name = request.getParameter("name");
	//String addr = request.getParameter("addr");
	//AddrDTO dto = new AddrDTO(-1, name, addr, null);
	addrDao.insert(dto);
	
	response.sendRedirect("list.jsp");
%>