< EL (Expression Language) >  //
 
 <1> ��� : ${}

 <2> ��� 
   1> ��ü�� �Ӽ����� ���´�.
   2> �迭�� ���� ���´�. 
   3> List ���� ���´�. 
   4> Map ���� ���´�.

 <3> EL�� ���� ��ü(11��)
   1> param 
	  paramValues
	  
   2> header
	  headerValues 

   3> pageContext - "EL���� JSP����Ʈ��ü ���ٽ� ���"  //EL

   4> requestScope 
	  pageScope 
	  sessionScope 
	  applicationScope 

   5> cookie 

   6> initParam - "ServletContext�� ���� initParam" 

 <4> EL �Լ� 

 <5> EL ������ 
   1> useELOperation 

   2> EL �������� ���� 
	  [1] ��� ������ 
		 ex) +, -, * , / �� div, %�� mod 
	     cf1)/�� div���� 0���� ���� �� �ִ�(infinity)
	     cf2)%�� mod���� 0���� ���� �� ����.(����)

	  [2] �� ������ 
		 ex) &&�� and, ||�� or, !�� not

	  [3] ���� ������ 
		 ex) ==�� eq, !=�� ne, <�� lt, >�� gt, 
			<=�� le, >=�� ge                          //���ڻ�밡��.

	  [4] empty 
		 -> ����ְų� null �� ��� true ���� 

	 cf1) jsp�� ����(���/����)�� EL���� �ν����� ���� //��Ʋ���⶧���� JAVA�ν� X
	 cf2) ���ǵ��� ���� ����/��(null)�� ��� ǥ��ó��  
	   case1) ���� ó�� (ex: ${str} )
	   case2) 0 ���� ó�� (ex: ${str + 10})
	   case3) false �� ó�� (ex: ${true and str})