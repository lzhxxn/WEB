<%@page contentType="text/html;charset=utf-8" 
        import="java.util.ArrayList, mvc.domain.Member"%> 
        
<link href="../css/signup.css" rel="stylesheet" type="text/css" media="all" />    
   
<div class="container">  
  <form id="contact" action="../member/member.do?m=insert" method="post">
    <center><h3>쇼핑몰 회원등록</h3></center>
    <fieldset>
      <input name='name' placeholder="name" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name='email' placeholder="Email Address (ID)" type="email" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input name='phone' placeholder="Phone" type="text" tabindex="4" required>
    </fieldset>
    <fieldset>
      <textarea name='grade' placeholder="Grade here" tabindex="5" required></textarea>
    </fieldset>
    <fieldset>
      <textarea name='addr' placeholder="Address here" tabindex="5" required></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
    <center><a href="../context/context.jsp">CONTEXT</a></center>
  </form>
</div>