package file.mvc.control;

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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import file.mvc.model.FileSet;


@WebServlet("/file/file.do")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String m="";
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "form": form(request, response); break; 
				case "upload": upload(request, response); break; 
				case "list": list(request, response); break;
				case "del": del(request, response); break;
				case "download": download(request, response); break;
				default: list(request, response); break;
			}
		}else {
			list(request, response);
		}
		
	}
	
	public void form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "form.jsp";
		response.sendRedirect(view);
	}
	public void upload(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		File fSaveDir = new File(FileSet.FILE_DIR);
		if(!fSaveDir.exists()) fSaveDir.mkdirs();
		
		MultipartRequest mr = new MultipartRequest(request,
                FileSet.FILE_DIR,
                1*1024*1024,
                "utf-8",
                new DefaultFileRenamePolicy());
		
		String writer = mr.getParameter("writer");
		String fname = mr.getFilesystemName("fname");
		String ofname =mr.getOriginalFileName("fname");
		System.out.println(
			"# writer: "+ writer + ", fname: "+fname+", ofname: " + ofname);
		
		String view = "file.do";
		response.sendRedirect(view);
	}
	public void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		File f = new File(FileSet.FILE_DIR);
		File kids[] = f.listFiles();
	    ArrayList<File> fList = new ArrayList<File>();
	    for(File kid: kids) fList.add(kid);
		request.setAttribute("fList", fList);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	public void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname =request.getParameter("fname");
		if(fname != null) fname = fname.trim();
		File f = new File(FileSet.FILE_DIR, fname);
		if(f.exists()) f.delete();
		
		String view = "file.do";
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
}




