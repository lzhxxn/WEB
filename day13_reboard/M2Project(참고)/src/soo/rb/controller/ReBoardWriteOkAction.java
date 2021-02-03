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
          /*주의1- ReBoardForm (ActionForm)은 만들필요 없음!! 
               제작한다고 하더라도 fileUpload관련 데이터 셋팅이 안되므로 
	 	   */
		
		  /*주의2- request의 기능 상실됨 
		  예 : String writer = request.getParameter("writer");
		  System.out.println("ReBoardAction의 writeOk()의 writer : " + writer); */
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
		  
		  
		  session.setAttribute("cp", "1"); // 글을 쓴 직후에는 첫번째 페이지로 이동 
		  return mapping.findForward("fw-write-ok");
	 }
}
