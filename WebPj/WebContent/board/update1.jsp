<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />  
<script src='../js/list.js'></script>

<c:if test="${empty dto}">
</c:if>
   <div class="container">  
  <form id="contact" action="../board/board.do?m=insert" method="post" enctype="multipart/form-data">
    <center><h3>게시글 수정</h3></center>
  <center>
  <a href="../context/context.jsp">CONTEXT</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="../board/board.do?m=list">LIST</a>
  </center>
    <fieldset>
      <input name='writer' placeholder="글쓴이" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='email' placeholder="이메일" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='subject' placeholder="주제" type="text" tabindex="2" required>
    </fieldset>
    <fieldset>
      <textarea name='content' placeholder="내용" type="text" tabindex="7" required></textarea>
    </fieldset>
    <td colspan="2" align="center">
     파일: <input type="file" name="fname" value="">
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
	</div>
	</form>
	</body>
	</div>