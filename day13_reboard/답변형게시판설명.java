< �亯�� �Խ��� DB table > 

(1) DB���̺��� relationship 
	 # JSP_BOARD(��)         #JSP_MEMBER(��)
                
				   #REPLY(��)

(2) Ư���� JSP_BOARD �ʵ� 
	 1> REFER : ���� �������� ǥ���ϴ� ����(�� '����ȣ')
	 2> LEV : ���� ������(�йи�)������ '���' ���� 
	 3> SUNBUN : ���� ������(refer)������ ��listing '����'����

	 ex1) �ʵ� ������ �� 

	 3. ����° ��(refer=2, lev=0, sunbun=0) 

	 2. �ι�° ��(refer=1, lev=0, sunbun=0) 
		-> ������ ��2(refer=1, lev=1, sunbun=1) 
		   -> ������ ��2�� ��1(refer=1, lev=2, sunbun=2) 
		-> ������ ��1(refer=1, lev=1, sunbun=3) 
		   -> ������ ��1�� ��2(refer=1, lev=2, sunbun=4) 
		   -> ������ ��1�� ��1(refer=1, lev=2, sunbun=5)
		-> ������ ��0(refer=1, lev=1, sunbun=6)

	 1. ù��° ��(refer=0, lev=0, sunbun=0)
		-> ù���� ��1(refer=0, lev=1, sunbun=1)
	  
	SQL> listing SQL�� 
 "SELECT * FROM jsp_board ORDER BY refer DESC, sunbun ASC"

(3) ����¡ ��� (SQL�� SELECT���� �ٸ�)
	 1> JSP_BOARD�� ��� ���� �����ͼ� rs�� Ŀ���� 
		�ش� �������� ���������� �̵����Ѽ� page�� 
		listing �ϴ� ��� 

	 2> JSP_BOARD�� ���� ������ ��, �̸� �ش� ��������
		���ԵǴ� �۵鸸�� SELECT�ϴ� ��� 
		ex) reboard/RBSQL.java�� RB_SELECT_TN_0
	"select * from (select rownum rnum , aa.* from " +
	"(select * from jsp_board order by refer desc, sunbun asc ) aa ) " +
		"where rnum > ? and rnum <= ?"


	cf)���� - ���� 
	 select bb.rnum, bb.subject from 
	  (select rownum rnum, aa.subject from 
		(select * from guestbook order by idx desc) aa) bb
		   where rnum>1 and rnum<=3;
