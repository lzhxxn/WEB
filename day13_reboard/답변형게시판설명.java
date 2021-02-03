< 답변형 게시판 DB table > 

(1) DB테이블간의 relationship 
	 # JSP_BOARD(일)         #JSP_MEMBER(일)
                
				   #REPLY(다)

(2) 특이한 JSP_BOARD 필드 
	 1> REFER : 같은 글집단을 표시하는 변수(글 '족번호')
	 2> LEV : 같은 글집단(패밀리)에서의 '등급' 변수 
	 3> SUNBUN : 같은 글집단(refer)에서의 글listing '순서'변수

	 ex1) 필드 설명의 예 

	 3. 세번째 족(refer=2, lev=0, sunbun=0) 

	 2. 두번째 족(refer=1, lev=0, sunbun=0) 
		-> 두족의 답2(refer=1, lev=1, sunbun=1) 
		   -> 두족의 답2의 답1(refer=1, lev=2, sunbun=2) 
		-> 두족의 답1(refer=1, lev=1, sunbun=3) 
		   -> 두족의 답1의 답2(refer=1, lev=2, sunbun=4) 
		   -> 두족의 답1의 답1(refer=1, lev=2, sunbun=5)
		-> 두족의 답0(refer=1, lev=1, sunbun=6)

	 1. 첫번째 족(refer=0, lev=0, sunbun=0)
		-> 첫족의 답1(refer=0, lev=1, sunbun=1)
	  
	SQL> listing SQL문 
 "SELECT * FROM jsp_board ORDER BY refer DESC, sunbun ASC"

(3) 페이징 기능 (SQL의 SELECT문이 다름)
	 1> JSP_BOARD의 모든 글을 가져와서 rs의 커서를 
		해당 페이지의 시작점으로 이동시켜서 page를 
		listing 하는 방법 

	 2> JSP_BOARD의 글을 가져올 때, 미리 해당 페이지에
		포함되는 글들만을 SELECT하는 방법 
		ex) reboard/RBSQL.java의 RB_SELECT_TN_0
	"select * from (select rownum rnum , aa.* from " +
	"(select * from jsp_board order by refer desc, sunbun asc ) aa ) " +
		"where rnum > ? and rnum <= ?"


	cf)참고 - 방명록 
	 select bb.rnum, bb.subject from 
	  (select rownum rnum, aa.subject from 
		(select * from guestbook order by idx desc) aa) bb
		   where rnum>1 and rnum<=3;
