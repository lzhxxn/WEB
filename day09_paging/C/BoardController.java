package board.mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.mvc.model.BoardService;
import board.mvc.vo.ListResult;
import mvc.domain.Board;

@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m){
				case "list": list(request, response); break;
				case "write": write(request, response); break;
				case "insert": insert(request, response); break;
				case "content": getBoard(request, response); break;
				case "update": getBoard(request, response); break;
				case "updateOk": updateOk(request, response); break;
				case "del": del(request, response); break;
				default: list(request, response);
			}
		}else {
			list(request, response);
		}
	}
	/*private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{	
		BoardService service = BoardService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}*/
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{	
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		HttpSession session = request.getSession();
		
		//(1) cp 
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		BoardService service = BoardService.getInstance();
		ListResult listResult = service.getListResult(cp, ps);
		request.setAttribute("listResult", listResult);
		
		if(listResult.getList().size() == 0 && cp>1) {
			response.sendRedirect("board.do?m=list&cp="+(cp-1));
		}else {
			String view = "list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	private void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String view = "write.jsp";
		response.sendRedirect(view);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		Board board = new Board(-1, writer, email, subject, content, null);
		
		BoardService service = BoardService.getInstance();
		service.insertS(board);
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	private void getBoard(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardService service = BoardService.getInstance();
			Board board = service.getBoardS(seq);
			request.setAttribute("board", board);
			
			String view = "";
			if(m.equals("content")) {
				view = "content.jsp";
			}else { //m.equals("update")
				view = "update.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "board.do";
			response.sendRedirect(view);
		}
	}
	private void updateOk(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		long seq = getSeq(request);
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Board board = new Board(seq, writer, email, subject, content, null);
		BoardService service = BoardService.getInstance();
		service.updateS(board);
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardService service = BoardService.getInstance();
			service.delS(seq);
		}
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	
	private long getSeq(HttpServletRequest request) {
		String seqStr = request.getParameter("seq");
		long seq = 0L;
		if(seqStr == null) {
			return -1L;
		}else {
			seqStr = seqStr.trim();
			try {
				seq = Integer.parseInt(seqStr);
				
				return seq;
			}catch(NumberFormatException ne) {
				return -1L;
			}
		}
	}
}
