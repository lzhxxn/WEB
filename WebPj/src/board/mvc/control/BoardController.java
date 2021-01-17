package board.mvc.control;

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

import board.mvc.model.BoardService;
import mvc.domain.Board;
import board.mvc.vo.ListResult;
import file.mvc.model.FileSet;


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
			}else if(m.equals("update1")) {
				update1(request, response);
			}else if(m.equals("update2")) {
				update2(request, response);
			}else if(m.equals("delF")) {
				delF(request, response);
			}else if(m.equals("download")) {
				download(request, response);
		/*	}else if(m.equals("readcount")) {
				readcount(request, response);*/
			}else {
				list(request, response);
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
		//board.do??m=list&cp=?&ps=? 형태로 넘어온다.
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
				int ps = 10;  // 기본값
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
				
				BoardService service = BoardService.getInstance(); //서비스객체호출
				ListResult listResult = service.getListResult(cp, ps);		
				//cp와 ps로 새로운 리스트리절트 객체를 생성해준다.
				request.setAttribute("listResult", listResult);	 
				//생성된 객체를 request에 기록해준다.
				
				if(listResult.getList(cp, ps).size() == 0 && cp>1) { 
					//해당 페이지리스트가 비었고, 페이지가 1페이지 이상인 경우
					response.sendRedirect("../board.do?m=list&cp="+(cp-1));
					//앞전페이지로 돌아가라.
				}else {
					String view = "../board/list.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
		    }
    private void write(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String view = "../board/write.jsp";
    	response.sendRedirect(view);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	File fSaveDir = new File(FileSet.FILE_DIR);
		if(!fSaveDir.exists()) fSaveDir.mkdirs();
    	MultipartRequest mr = new MultipartRequest(request,
                FileSet.FILE_DIR,
                1*1024*1024,
                "utf-8",
                new DefaultFileRenamePolicy());
    	String writer = mr.getParameter("writer");
    	String email = mr.getParameter("email");
    	String subject = mr.getParameter("subject");
    	String content = mr.getParameter("content");
    	String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
	    File f = new File(FileSet.FILE_DIR, fname);
	       long fSize = (long) f.length();
    	Board dto = new Board(-1, writer, email, subject, content, fname, ofname, fSize, null, -1);
    	BoardService service = BoardService.getInstance();
    	service.insertS(dto);
    	System.out.println("CON");
    	String view = "../board/board.do?m=list";
    	response.sendRedirect(view);
    }
    private void content(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	BoardService service = BoardService.getInstance();
    	int seq = -1;
    	String seqStr = request.getParameter("seq");
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
      				Board dto = service.contentS(seq);
    				request.setAttribute("dto", dto);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String view = "content.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    	
    	service.upcountS(seq);
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
    	
    	String view = "../board/del.jsp";
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
    	MultipartRequest mr = new MultipartRequest(request,
                FileSet.FILE_DIR,
                1*1024*1024,
                "utf-8",
                new DefaultFileRenamePolicy());
    	File fSaveDir = new File(FileSet.FILE_DIR);
    	int fSize = (int) fSaveDir.length();
		if(!fSaveDir.exists()) fSaveDir.mkdirs();
    	String seqStr = mr.getParameter("seq");
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

    	String writer = mr.getParameter("writer");
    	String email = mr.getParameter("email");
    	String subject = mr.getParameter("subject");
    	String content = mr.getParameter("content");
    	String fname = mr.getFilesystemName("fname");
		String ofname = mr.getOriginalFileName("fname");
		Board dto = new Board(seq, writer, email, subject, content, fname, ofname, fSize, null, -1);
    	
    	BoardService service = BoardService.getInstance();
    	service.update2S(dto);
    	
    	String view = "board.do";
    	response.sendRedirect(view);
    }
	public void delF(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname =request.getParameter("fname");
		if(fname != null) fname = fname.trim();
		File f = new File(FileSet.FILE_DIR, fname);
		if(f.exists()) f.delete();
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	public void download(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname = new String(request.getParameter("fname"));
		File file = new File(FileSet.FILE_DIR +"/"+fname);

		response.setContentType("application/octet-stream"); 

		String Agent=request.getHeader("USER-AGENT");
		if( Agent.indexOf("MSIE") >= 0 ){
			int i = Agent.indexOf( 'M', 2 );

			String IEV = Agent.substring( i + 5, i + 8 );

			if( IEV.equalsIgnoreCase("5.5") ){
				response.setHeader("Content-Disposition", "filename=" + new String(fname.getBytes("utf-8"), "8859_1") );
			}else{
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes("utf-8"),"8859_1"));
			}
		}else{
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fname.getBytes("utf-8"), "8859_1") );
		}

		byte b[] = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		
		if( file.isFile()){ 
			try{ 
				fis = new FileInputStream(file);//Node 
				bis = new BufferedInputStream(fis); //Filter 
				
				os = response.getOutputStream(); //Node
				bos = new BufferedOutputStream(os); //Filter   

				int read = 0;

				while( ( read = bis.read( b ) ) != -1 ){  
					bos.write(b,0,read);
				}

				bos.flush();
				
			}catch( Exception e ){
				
			}finally {
				try {
					if(bis != null) bis.close();
					if(bos != null) bos.close();
					if(fis != null) fis.close();
					if(os != null) os.close();
				}catch(IOException ie) {}
			}
		}
	}
	/*private void readcount(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int seq = -1;
		String seqStr = request.getParameter("seq");
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					seq = Integer.parseInt(seqStr);
					BoardService service = BoardService.getInstance();
					System.out.println("확인");
					service.upcountS(seq);
				}catch(NumberFormatException ne){
    			}
    		}
    	}
				String view = "../board/board.do?m=list";
				response.sendRedirect(view);
	}*/
}
    
    
    
