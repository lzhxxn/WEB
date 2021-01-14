<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />  
<script src='../js/list.js'></script>

<c:if test="${empty dto}">
</c:if>
    
<div class="container">  
  <form id="contact" action="../member/member.do?m=insert" method="post" enctype="multipart/form-data">
    <center><h3>회원 정보조회</h3></center>
    <div style="text-align:center;">
    <a href='../member/member.do?m=update1&seq=${dto.seq}'>UPDATE</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
	<a href='../member/member.do?m=del&seq=${dto.seq}'>DELETE</a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="../member/member.do?m=list">LIST</a>
	</div>
	<strong>
    <fieldset>
      <input name='name' placeholder="회원이름 :  ${dto.name}" type="text" tabindex="1" required readonly>
    </fieldset>
    <fieldset>
      <input name='email' placeholder="이메일 :  ${dto.email}" type="text" tabindex="2" required readonly>
    </fieldset>
    <fieldset>
      <input name='phone' placeholder="휴대폰번호 :  ${dto.phone}" type="tel" tabindex="4" required readonly>
    </fieldset>
    <fieldset>
      <textarea name='addr' placeholder="주소 :  ${dto.addr}" type="text" tabindex="5" required readonly></textarea>
    </fieldset>
    <fieldset>
      <input name='grade' placeholder="회원등급 :  ${dto.grade}" type="text" tabindex="5" required readonly>
    </fieldset>
   
	</strong>
	</form>
	</body>
	</div>
    