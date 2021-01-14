<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*, mvc.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />  
<script src='../js/list.js'></script>

<c:if test="${empty dto}">
</c:if>
   <div class="container">  
  <form id="contact" action="../member/member.do?m=update2&seq=${dto.seq}" method="post">
    <center><h3>회원정보 수정</h3></center>
  <center>
  <a href="../context/context.jsp">CONTEXT</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="../member/member.do?m=list">LIST</a>
  </center>
    <fieldset>
      <input name='name' placeholder="회원이름 :  ${dto.name}" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='email' placeholder="이메일 :  ${dto.email}" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='phone' placeholder="휴대폰번호 :  ${dto.phone}" type="tel" tabindex="4" required>
    </fieldset>
    <fieldset>
      <textarea name='addr' placeholder="주소 :  ${dto.addr}" type="text" tabindex="7" required></textarea>
    </fieldset>
    <fieldset>
      <input name='grade' placeholder="회원등급 :  ${dto.grade}" type="text" tabindex="5" required>
    </fieldset>

    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
	</div>
	</form>
	</body>
	</div>