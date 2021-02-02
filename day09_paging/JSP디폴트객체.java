< JSP ����Ʈ ��ü(9��) > 

(1) ���� : ��ü�� ���� �������� �ʰ� ��ũ��Ʈ�� ��, 
	   <%%> ���̿��� ��� ������ ��ü�� �ǹ� 
	  
(2) ���� 
   <1> out ��ü ( type : JspWriter )
	  -> Ŭ���̾�Ʈ �������� ����� ��� ��ü 
	  
   <2> request ��ü ( type : HttpServletRequest )
	  -> Ŭ���̾�Ʈ ��û������ ���� ��ü/����[��ü]
	  ex) scope/requestTest.jsp

   <3> response ��ü ( type : HttpServletResponse )
	  -> ������ �亯������ ���� ��ü  

   <4> session ��ü ( type : HttpSession )
	  -> Ŭ���̾�Ʈ�� �������� �Ҵ�� ������ ��ü/����[��ü]
	   ( JSessionId��� label ǥ�� ���� )
	  ex) scope/sessionTest.jsp

	  cf1) ���� ���� ( �Ӽ� == Attribute) 
		 -> session ��ü�ȿ� ���� ��ü(�Ӽ��� Object)
			 �� �ּҸ� �����ϴ� ���� (type : String) 

	  cf2) ���� ������ (�Ӽ��� ==  Attribute Value)
		 -> session ��ü�ȿ� ���� ��ü(type : Object)

	  ex1) <jsp:useBean id="login" class="soo.loginBean" 
				  scope="session"/> 
	  ex2) session.setAttribute("id", "tiger");

		# ���Ǻ����� "login" �� "id" �� �ǹ� 
		# ���Ǻ����� new soo.loginBean() �� "tiger"�� �ǹ� 
		# ���ǰ�ü�� ��������, �� ���� ���Ǻ����� ���Ǻ�����
		  �� �Բ� �������.

   <5> application ��ü ( type : ServletContext ) 
	  -> WebApplication ��ü�� �����Ǵ� ��ü/����[��ü]
	   ex) scope/applicationTest.jsp

	   cf) application ����(�Ӽ�)/application ������(�Ӽ���)

   <6> page ��ü ( type : Object )
	  -> JSP ������ �ڽ��� �ǹ��ϴ� ��ü 
	   ex) scope/pageTest.jsp

   <7> pageContext ��ü ( type : PageContext )  //JAVA
	  -> �ٸ� ����Ʈ��ü���� ����(����)�� �� �ִ� method
	  -> ��� scope�� ����ִ� �Ӽ�(����)���� ������ �� 
		 �ִ� method�� ���� 
		 - setAttribute(String name, Object value, int scope)
		 - getAttribute(String name, int scope) 
		 - findAttribute(String name)
	  -> page scope ������ �ڵ鸵�� ������
		 ex) scope/pageTest.js

   <8> config ��ü ( type : ServletConfig )
	  -> DD(web.xml)���� ������ ���������� ������ �� �ִ� ��ü
		 ex) servletConfigContext/
		  ConfigTest.java,ConfigTest.jsp(���� �Ұ�),
		  ContextTest.java, contextTest.jsp

		 cf1) web.xml�� ���� (�ѱ��� ������ ����)
		  <?xml version="1.0" encoding="euc-kr"?>
		 cf2) jsp������������ DD(web.xml)������ 
				 init-param�� ������ �� ����
		 cf3) DD(Deployment Descriptor)

   <9> exception ��ü ( type : Throwable )
	  -> ���� ó�� ���� ��ü 
