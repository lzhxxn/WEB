package goods.mvc.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import goods.mvc.model.GoodsService;
import file.mvc.model.FileSet;
import mvc.domain.Goods;


@WebServlet("/goods/goods.do")
public class GoodsController extends HttpServlet {
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
			}else if(m.equals("download")) {
				download(request, response);
			}else if(m.equals("del")) {
				del(request, response);
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
		GoodsService service = GoodsService.getInstance();
		ArrayList<Goods> list = service.listS();
		request.setAttribute("list", list);
		
		System.out.println("수행완료 control");
		String view = "../goods/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
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
    	int seq = -1;
    	String seqStr = mr.getParameter("seq");
    	if(seqStr != null){
    		seqStr = seqStr.trim();
    		if(seqStr.length() != 0){
    			try{
    				seq = Integer.parseInt(seqStr);
    			}catch(NumberFormatException ne){
    			}
    		}
    	}
    	String name = mr.getParameter("name");
    	String fname = mr.getFilesystemName("fname");
    	String type = mr.getContentType("fname");
		String ofname = mr.getOriginalFileName("fname");
	    File f = new File(FileSet.FILE_DIR, fname);
	       long fSize = (long) f.length();
	    String etc = mr.getParameter("etc");
	    String rdate = mr.getParameter("rdate");
    	Goods dto = new Goods(seq, name, etc, fname, ofname, fSize, rdate);
    	GoodsService service = GoodsService.getInstance();
    	service.insertS(dto);
    	
    	String view = "../goods/goods.do?m=list";
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
    private void del(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String seqStr = request.getParameter("seq");
    	int seq = -1;
    	if(seqStr != null) {
    		seqStr = seqStr.trim();
    		try {
    			seq = Integer.parseInt(seqStr);
    			GoodsService service = GoodsService.getInstance();
    			boolean flag = service.delS(seq);
    			request.setAttribute("flag", flag);
    		}catch(NumberFormatException ne) {}
    	}
    	
    	String view = "../goods/del.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }
}
   