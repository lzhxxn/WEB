package addr.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import addr.mvc.model.AddrService;
import mvc.domain.Address;


@WebServlet("/addr/addr.do")
public class AddrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
			}else if(m.equals("input")) {
				input(request, response);
			}else if(m.equals("insert")) {
				insert(request, response);
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("del_all")) {
				del_all(request, response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
    
    private void list(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	AddrService service = AddrService.getInstance();
    	ArrayList<Address> list = service.listS();
    	request.setAttribute("list", list);
    	
    	String view = "list.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void input(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String view = "input.jsp";
    	response.sendRedirect(view);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String name = request.getParameter("name");
    	String addr = request.getParameter("addr");
    	Address dto = new Address(-1, name, addr, null);
    	AddrService service = AddrService.getInstance();
    	service.insertS(dto);
    	
    	String view = "addr.do";
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
    			AddrService service = AddrService.getInstance();
    			boolean flag = service.delS(seq);
    			request.setAttribute("flag", flag);
    		}catch(NumberFormatException ne) {}
    	}
    	
    	String view = "msg.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void del_all(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	AddrService service = AddrService.getInstance();
    	service.delAllS();
    	
    	String view = "addr.do";
    	response.sendRedirect(view);
    }
}
