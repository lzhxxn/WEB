package member.mvc.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.mvc.model.MemberService;
import board.mvc.vo.ListResult;
import mvc.domain.Member;
import file.mvc.model.FileSet;
import member.mvc.model.MemberService;


@WebServlet("/member/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
			}else if(m.equals("insert")) {
				insert(request, response);
			}else {
				list(request, response);
				System.out.println("se");
			}
		}else {
			list(request, response);
		}
    }

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//<페이징에서는 session에 set / get 방식으로 값을 설정한다.>//
		String cpStr = request.getParameter("cp"); //클라이언트로부터 받아야한다. index (cp)(ps)
		String psStr = request.getParameter("ps"); //클라이언트로부터 받아야한다. index (cp)(ps)
		//Member.do??m=list&cp=?&ps=? 형태로 넘어온다.
		HttpSession session = request.getSession();
		//(1) cp 
				int cp = 1; // 일단 cp를 1이라고 설정한다. 
				if(cpStr == null) { // 따로 파라미터로 입력 들어온 값이 없다면,
					Object cpObj = session.getAttribute("cp"); 
					// 원래 세션에 입력되었던 cp값을 가져와서 오브젝트형태로 만든다.
					if(cpObj != null) {
						cp = (Integer)cpObj; // 기본형으로 바꿔준다.
					}
				}else {  //if(cpStr != null)
					cpStr = cpStr.trim();
					cp = Integer.parseInt(cpStr);
				}
				session.setAttribute("cp", cp);
				
				/// (2) Page Size : ps 
				int ps = 3;  // 기본값
				if(psStr == null) { // 파라미터로 들어온 값이 없으면,
					Object psObj = session.getAttribute("ps");
					// 세션에 있는 ps값을 가져와서 psObj로 값을 넣어준다.
					if(psObj != null) { // 이 값이 널이 아니면, 
						ps = (Integer)psObj; // 기본형으로 바꿔준다.
					}		
				}else { // null이 아니면 parameter 값이 넘어온 것. if(psStr != null)
					psStr = psStr.trim();// 공백을 제거해서 대입
					int psParam = Integer.parseInt(psStr);// 형변환해서 psParam으로 저장
					Object psObj = session.getAttribute("ps");
					if(psObj != null) { //세션에 기록된 값이 있다면,
						int psSession = (Integer)psObj;// 그값을가져와서, int로 형변환 후 psSession에 대입
						if(psSession != psParam) {// 세션에있던값이, 파라미터로 넘어온 값과 다르다면
							cp = 1; //페이지 사이즈에의해서 cp가바뀐다. 맨앞페이지로 cp 바꿔라!
							session.setAttribute("cp", cp);
						}
					}else {
						if(ps != psParam) { //얘도역시
							cp = 1;
							session.setAttribute("cp", cp);
						}
					}
					
					ps = psParam; //파라미터에서 넘어온 값으로 ps를 지정해준다.
				}
				session.setAttribute("ps", ps); //지정된 ps값을 세션에 기록한다.
				
				MemberService service = MemberService.getInstance(); //서비스객체호출
				ListResult listResult = service.getListResult(cp, ps);		
				//cp와 ps로 새로운 리스트리절트 객체를 생성해준다.
				request.setAttribute("listResult", listResult);	 
				//생성된 객체를 request에 기록해준다.
				
				if(listResult.getList(cp, ps).size() == 0 && cp>1) { 
					//해당 페이지리스트가 비었고, 페이지가 1페이지 이상인 경우
					response.sendRedirect("Member.do?m=list&cp="+(cp-1));
					//앞전페이지로 돌아가라.
				}else {
					String view = "list.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
		    }
    

    private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String addr = request.getParameter("addr");
    	String grade = request.getParameter("grade");

    	Member dto = new Member(-1, name, email, phone, addr, grade, null);
    	MemberService service = MemberService.getInstance();
    	service.insertS(dto);
    	System.out.println("회원가입 완료!");
    	
    	String view = "../context/context.jsp";
    	response.sendRedirect(view);
    }
}