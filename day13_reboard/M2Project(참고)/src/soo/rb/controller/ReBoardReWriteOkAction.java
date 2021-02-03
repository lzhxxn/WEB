package soo.rb.controller;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import soo.path.M2ProjectPath;
import soo.rb.model.RBManager;
import com.oreilly.servlet.MultipartRequest;

public class ReBoardReWriteOkAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
          /*����1- ReBoardForm (ActionForm)�� �����ʿ� ����!! 
               �����Ѵٰ� �ϴ��� fileUpload���� ������ ������ �ȵǹǷ� 
	 	   */
		
		  /*����2- request�� ��� ��ǵ� 
		  �� : String writer = request.getParameter("writer");
		  System.out.println("ReBoardReWriteOkAction�� writer : " + writer); */
		  String storePath = request.getRealPath("reboard/store");
		  M2ProjectPath.RB_UPLOAD_DIR = storePath;
		  
		  MultipartRequest mr = new MultipartRequest(
				request, storePath, 
				5*1024*1024, "euc-kr");
		  
		  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  String idx_str = (String)session.getAttribute("idx");
	 	  int tn = 0;
	 	  int idx = 0;
	 	   
	  	  if(tn_str == null)
	  	  {
	  	     return new ActionForward("/main.do", true);
	  	  }
	  	  else if(idx_str == null)
	  	  {
	  	     return new ActionForward("/rb-list.do?method=list", true);
	  	  }
		  else
		  {
		  	  tn = Integer.parseInt(tn_str.trim());
		  	  idx = Integer.parseInt(idx_str.trim());
		  }
		  RBManager manager = RBManager.getInstance();
		  boolean result = manager.dbReWriteOk(mr, tn, idx);
		  System.out.println("result : " + result);
		  
		  Boolean result_obj = new Boolean(result);
		  request.setAttribute("msg", "rewriteok");
		  request.setAttribute("result", result_obj);
		  
		  
		  return mapping.findForward("fw-rewrite-ok");
	 }
}
