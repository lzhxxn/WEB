< 쿠키와 세션 >

(1) 쿠키
   1) 설    명 : 클라이언트측에 저장되는 서버측 정보(부스러기)
   2) 제한 크기 : 4KB 이하 제한/개(사이트)
   3) 제한 갯수 : 300 개
   4) 최대로 저장 가능한 쿠키의 용량 : 1.2 MB
   5) 종    류 
	   <1> 클라이언트의 하드 디스크에 저장되는 쿠키(파일)
	   <2> 클라이언트의 메모리에 존재하는 쿠키 
		  ( 브라우져가 열려져 있을 때까지만 존재 )
		  1> JSessionID
		  2> setMaxAge(0 || 음수) -> (MaxAge 기본값 -1)

   6) 주   의 
	   <1> 한글이 지원 안된다.
	   <2> MaxAge 가 지났을 때, 하드의 파일에는 지워지지 않지만
		  CookieGet.jsp를 실행하게 되면 MaxAge가 지난 Cookie는 
		  검출되지 않는다.

(2) 세션 
    1) 설    명 : HTTP 프로토콜은 무상태(stateless)프로토콜
	            이기때문에 상태를 유지할 수 없다.
	            세션이라는 기술은 그 상태 정보를 유지할 수 있도록 
	            만들어진 "기술"이다.
	            ex) 쇼핑몰의 장바구니, 로그인, ...

   2) 원    리 : 클라이언트의 첫번째 요청에 의해서 서버측 
	           메모리에는 JSessionId라는 ID로 해당 클라이언트를 
	           위한 방(공간)이 만들어지고, 첫번째 답변으로 그 
	           JSessionId를 쿠키 형태로 클라이언트에게 전달한다.

	           다음 요청부터는 클라이언트가 JSessionId을 가지고 
	           서버에게 요청함으로써 서버는 그 클라이언트를 식별 
	           할 수 있고, 그 클라이언트의 방을 공유할 수 있게 한다.
	           따라서, 그 방에 있는 객체(세션변수값==세션속성값)들로
	           상태정보를 유지 할 수 있는 것이다.

    3) 주   의
	         같은 서버에서는 하나의 클라이언트의 브라우져에 대해서
	         WebApplication(Context)마다 JSessionId가 따로 생성된다.
	         ex) Tomcat 서버 

	       cf1) 위의 사항은 서버마다 차이가 있을 수 있다. 
	       cf2) 증명( 같은 브라우져에서 ) 
		    [1] NewContext WebApp 호출 
			http://~/nc/JSP/mutiAppSession/multiApp.jsp
			 -> jsId : 6B7800F047F22D76CC261C87575EFC06

		    [2] Root WebApp 호출
			http://~/JSP/mutiAppSession/multiApp.jsp
			 -> jsId : B7E6A183517F3B54B89967F316C2CA83 