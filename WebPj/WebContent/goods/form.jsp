<%@page contentType="text/html;charset=utf-8" 
        import="java.util.ArrayList, mvc.domain.Goods"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />    
   
<div class="container">  
  <form id="contact" action="../goods/goods.do?m=insert" method="post" enctype="multipart/form-data">
    <center><h3>새 상품 등록</h3></center>
    <fieldset>
      <input name='seq' placeholder="상품코드" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='name' placeholder="아이스크림명" type="text" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input name='fname' placeholder="상품사진" type="file" tabindex="4" required>
    </fieldset>
    <fieldset>
      <textarea name='etc' placeholder="상품상세설명" tabindex="5" required></textarea>
    </fieldset>
    <fieldset>
      <input name='rdate' placeholder="상품등록날짜" type="date" tabindex="5" required>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
    <center><a href="../context/context.jsp">INDEX</a></center>
  </form>
</div>