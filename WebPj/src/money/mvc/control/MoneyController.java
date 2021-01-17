package money.mvc.control;

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
import mvc.domain.Member;
import mvc.domain.Money;
import money.mvc.model.MoneyService;


@WebServlet("/money/money.do")
public class MoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
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
		MoneyService service = MoneyService.getInstance();
		ArrayList<Money> list = service.listS();
		request.setAttribute("list", list);
		System.out.println("수행완료 control");
		String view = "../member/money.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

}