package member.mvc.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
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
import file.mvc.model.FileSet;
import mvc.domain.Member;

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
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("content")) {
				content(request, response);
			}else if(m.equals("update1")) {
				update1(request, response);
			}else if(m.equals("update2")) {
				update2(request, response);
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
    	String date = request.getParameter("joindate");
    	Date joindate = Date.valueOf(date);
    	
    	Member dto = new Member(-1, name, email, phone, addr, grade, joindate);
    	MemberService service = MemberService.getInstance();
    	service.insertS(dto);
    	System.out.println("회원가입 완료!");
    	
    	String view = "../member/member.do?m=list";
    	response.sendRedirect(view);
    }
    private void del(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String seqStr = request.getParameter("seq");
    	int seq = -1;
    	if(seqStr != null) {
    		seqStr = seqStr.trim();
    		try {
    			seq = Integer.parseInt(seqStr);
    			MemberService service = MemberService.getInstance();
    			boolean flag = service.delS(seq);
    			request.setAttribute("flag", flag);
    		}catch(NumberFormatException ne) {}
    	}
    	
    	String view = "../member/member.do?m=list";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void content(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	MemberService service = MemberService.getInstance();
    	int seq = -1;
    	String seqStr = request.getParameter("seq");
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
      				Member dto = service.contentS(seq);
    				request.setAttribute("dto", dto);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String view = "../member/content.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
 
    }
    private void update1(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	int seq = -1;
    	String seqStr = request.getParameter("seq");
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
    				MemberService service = MemberService.getInstance();
    				Member dto = service.update1S(seq);
    				request.setAttribute("dto", dto);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String view = "../member/update1.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void update2(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String seqStr = request.getParameter("seq");
    	
    	int seq = -1;
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
    				System.out.println(seq);
    				MemberService service = MemberService.getInstance();
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String phone = request.getParameter("phone");
    	String addr = request.getParameter("addr");
    	String grade = request.getParameter("grade");
    	System.out.println(name+email+phone);
		Member dto = new Member(seq, name, email, phone, addr, grade, null);
    	
    	MemberService service = MemberService.getInstance();
    	service.update2S(dto);
    	System.out.println("수정 완료!");
    	
    	String view = "../member/member.do?m=list";
    	response.sendRedirect(view);
    }
}