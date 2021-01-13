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

import mvc.domain.Member;
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
			throws ServletException, IOException{	
		MemberService service = MemberService.getInstance();
		ArrayList<Member> list = service.listS();
		request.setAttribute("list", list);
		System.out.println("수행완료 con");
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
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
    	
    	String view = "../member/member.do?m=list";
    	response.sendRedirect(view);
    }
}