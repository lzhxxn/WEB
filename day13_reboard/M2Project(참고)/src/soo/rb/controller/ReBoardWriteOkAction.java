package soo.rb.controller;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import soo.path.M2ProjectPath;
import soo.rb.model.RBManager;

import com.oreilly.servlet.MultipartRequest;

public class ReBoardWriteOkAction extends Action{
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
		  System.out.println("ReBoardAction�� writeOk()�� writer : " + writer); */
		  String storePath = request.getRealPath("reboard/store");
		  M2ProjectPath.RB_UPLOAD_DIR = storePath;
		  
		  MultipartRequest mr = new MultipartRequest(
				request, storePath, 
				5*1024*1024, "euc-kr");
		  
		  HttpSession session = request.getSession();
		  String tn_str = (String)session.getAttribute("tn");
		  int tn = 0;
		  if(tn_str == null || tn_str.equals(""))
		  {
		  	  return new ActionForward("/main.do", true);
		  }
		  else
		  {
		  	  tn = Integer.parseInt(tn_str);
		  }
		  RBManager manager = RBManager.getInstance();
		  boolean result = manager.dbWriteOk(mr, tn);
		  System.out.println("result : " + result);
		  
		  Boolean result_obj = new Boolean(result);
		  request.setAttribute("msg", "writeok");
		  request.setAttribute("result", result_obj);
		  
		  
		  session.setAttribute("cp", "1"); // ���� �� ���Ŀ��� ù��° �������� �̵� 
		  return mapping.findForward("fw-write-ok");
	 }
}
