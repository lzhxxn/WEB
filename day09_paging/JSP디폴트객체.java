< JSP 디폴트 객체(9개) > 

(1) 설명 : 객체를 따로 생성하지 않고 스크립트렛 즉, 
	   <%%> 사이에서 사용 가능한 객체를 의미 
	  
(2) 종류 
   <1> out 객체 ( type : JspWriter )
	  -> 클라이언트 브라우져와 연결된 출력 객체 
	  
   <2> request 객체 ( type : HttpServletRequest )
	  -> 클라이언트 요청정보를 가진 객체/공간[객체]
	  ex) scope/requestTest.jsp

   <3> response 객체 ( type : HttpServletResponse )
	  -> 서버의 답변정보를 가진 객체  

   <4> session 객체 ( type : HttpSession )
	  -> 클라이언트측 브라우져에 할당된 서버측 객체/공간[객체]
	   ( JSessionId라는 label 표식 소유 )
	  ex) scope/sessionTest.jsp

	  cf1) 세션 변수 ( 속성 == Attribute) 
		 -> session 객체안에 들어가는 객체(속성값 Object)
			 의 주소를 참조하는 변수 (type : String) 

	  cf2) 세션 변수값 (속성값 ==  Attribute Value)
		 -> session 객체안에 들어가는 객체(type : Object)

	  ex1) <jsp:useBean id="login" class="soo.loginBean" 
				  scope="session"/> 
	  ex2) session.setAttribute("id", "tiger");

		# 세션변수는 "login" 과 "id" 를 의미 
		# 세션변수값 new soo.loginBean() 과 "tiger"를 의미 
		# 세션객체가 없어지면, 그 안의 세션변수와 세션변수값
		  도 함께 사라진다.

   <5> application 객체 ( type : ServletContext ) 
	  -> WebApplication 전체에 공유되는 객체/공간[객체]
	   ex) scope/applicationTest.jsp

	   cf) application 변수(속성)/application 변수값(속성값)

   <6> page 객체 ( type : Object )
	  -> JSP 페이지 자신을 의미하는 객체 
	   ex) scope/pageTest.jsp

   <7> pageContext 객체 ( type : PageContext )  //JAVA
	  -> 다른 디폴트객체들을 접근(가져)할 수 있는 method
	  -> 모든 scope에 들어있는 속성(변수)들을 접근할 수 
		 있는 method가 존재 
		 - setAttribute(String name, Object value, int scope)
		 - getAttribute(String name, int scope) 
		 - findAttribute(String name)
	  -> page scope 영역도 핸들링이 가능함
		 ex) scope/pageTest.js

   <8> config 객체 ( type : ServletConfig )
	  -> DD(web.xml)에서 서블릿의 구성정보를 접근할 수 있는 객체
		 ex) servletConfigContext/
		  ConfigTest.java,ConfigTest.jsp(참조 불가),
		  ContextTest.java, contextTest.jsp

		 cf1) web.xml의 수정 (한글이 깨지지 않음)
		  <?xml version="1.0" encoding="euc-kr"?>
		 cf2) jsp페이지에서는 DD(web.xml)설정된 
				 init-param를 참조할 수 없음
		 cf3) DD(Deployment Descriptor)

   <9> exception 객체 ( type : Throwable )
	  -> 예외 처리 관련 객체 
