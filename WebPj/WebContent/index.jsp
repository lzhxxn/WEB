<%@page contentType="text/html;charset=utf-8" 
        import="java.util.ArrayList, mvc.domain.Admin"%> 
        
<link href="./css/login.css" rel="stylesheet" type="text/css" media="all" />

<meta charset="utf-8">
<script src="./js/trim.js"></script>
<script language="javascript"> 
    function check(){
		var emailval = f.email.value;
		emailval = trim(emailval);
		if(emailval.length == 0){
			alert("이메일을 넣어주세요");
			f.email.value = "";
			f.email.focus();
			return false;
		}else{
			pass = checkByteLen(emailval, 50);
			if(!pass){
				alert("이메일이 너무 길어요");
				f.email.focus();
				return false;
			}
		}
		
		var pwdval = f.pwd.value;
		pwdval = trim(pwdval);
		if(pwdval.length == 0){
			alert("비번을 넣어주세요");
			f.pwd.value = "";
			f.pwd.focus();
			return false;
		}else{
			pass = checkByteLen(pwdval, 30);
			if(!pass){
				alert("비번이 너무 길어요");
				f.pwd.focus();
				return false;
			}
		}

		f.submit();
	}

    function checkByteLen(str, size){
        var byteLen = getByteLen(str);
		if(byteLen <= size){
			return true;
		}else{
			return false;
		}
	}
	function getByteLen(str){
	   return str.replace(/[\0-\x7f]|([0-\u07ff]|(.))/g,"$&$1$2").length;
    }
	
	function enterCheck(elm){
		if(event.keyCode == 13){
			if(elm == f.email){
				f.pwd.focus();
			}else{
				check();
			}
		}
	}
</script>
<g font-family="카페24 아네모네">
<div class="login-box">
  <h2>관리자 로그인</h2>

   <form name="f" action="login/login.do?m=check" method="post">
    <div class="user-box">
      <input type="text" name="email" required="">
      <label>Email</label>
    </div>
    <div class="user-box">
      <input type="password" name="pwd" required="">
      <label>Password</label>
    </div>
    <button type="submit">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Submit
    </button>
  </form>
  </g>
</div>