package board.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.mvc.model.BoardService;
import mvc.domain.Board;


@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
			}else if(m.equals("write")) {
				write(request, response);
			}else if(m.equals("insert")) {
				insert(request, response);
			}else if(m.equals("content")) {
				content(request, response);
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("del_all")) {
				del_all(request, response);
			}else if(m.equals("update1")) {
				update1(request, response);
			}else if(m.equals("update2")) {
				update2(request, response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
    
	private void list(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	BoardService service = BoardService.getInstance();
    	ArrayList<Board> list = service.listS();
    	request.setAttribute("list", list);
    	
    	String view = "list.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void write(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String view = "write.jsp";
    	response.sendRedirect(view);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String writer = request.getParameter("writer");
    	String email = request.getParameter("email");
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    	
    	Board dto = new Board(-1, writer, email, subject, content, null);
    	BoardService service = BoardService.getInstance();
    	service.insertS(dto);
    	
    	String view = "board.do";
    	response.sendRedirect(view);
    }
    private void content(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	int seq = -1;
    	String seqStr = request.getParameter("seq");
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
    				BoardService service = BoardService.getInstance();
    				Board dto = service.contentS(seq);
    				request.setAttribute("dto", dto);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String view = "content.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void del(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String seqStr = request.getParameter("seq");
    	int seq = -1;
    	if(seqStr != null) {
    		seqStr = seqStr.trim();
    		try {
    			seq = Integer.parseInt(seqStr);
    			BoardService service = BoardService.getInstance();
    			boolean flag = service.delS(seq);
    			request.setAttribute("flag", flag);
    		}catch(NumberFormatException ne) {}
    	}
    	
    	String view = "del.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
    private void del_all(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	BoardService service = BoardService.getInstance();
    	service.delAllS();
    	
    	String view = "board.do";
    	response.sendRedirect(view);
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
    				BoardService service = BoardService.getInstance();
    				Board dto = service.update1S(seq);
    				request.setAttribute("dto", dto);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String view = "update1.jsp";
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
    				BoardService service = BoardService.getInstance();
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String writer = request.getParameter("writer");
    	String email = request.getParameter("email");
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    	Board dto = new Board(seq, writer, email, subject, content, null);
    	BoardService service = BoardService.getInstance();
    	service.update2S(dto);
    	
    	String view = "board.do";
    	response.sendRedirect(view);
    }
}
    
    
    
    
