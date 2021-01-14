<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />  
<script src='../js/list.js'></script>

<c:if test="${empty dto}">
</c:if>
    
<div class="container">  
  <form id="contact" action="../goods/goods.do?m=insert" method="post" enctype="multipart/form-data">
    <center><h3>상세 내용</h3></center>
    <div style="text-align:center;">
    <a href='../board/board.do?m=update1&seq=${dto.seq}'>UPDATE</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
	<a href='../board/board.do?m=del&seq=${dto.seq}'>DELETE</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../board/board.do?m=list">LIST</a>
	</div>
    <fieldset>
      <input name='writer' placeholder="글쓴이 :  ${dto.writer}" type="text" tabindex="1" required readonly>
    </fieldset>
    <fieldset>
      <input name='subject' placeholder="글제목 :  ${dto.subject}" type="text" tabindex="2" required readonly>
    </fieldset>
    <fieldset>
      <input name='content' placeholder="글내용 :  ${dto.content}" type="text" tabindex="4" required readonly></textarea>
    </fieldset>
    <fieldset>
      <input name='fname' placeholder="첨부파일 :  ${dto.fname}" tabindex="5" required readonly> <td><a href="../goods/goods.do?m=download&fname=${dto.fname}">다운로드</a></td>
    </fieldset>
    <fieldset>
      <input name='fsize' placeholder="파일크기 :  ${dto.fsize}" tabindex="5" required readonly>
    </fieldset>

	</form>
	</body>
	</div>
    