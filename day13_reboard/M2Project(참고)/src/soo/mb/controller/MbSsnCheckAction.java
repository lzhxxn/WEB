package soo.mb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import soo.mb.model.MbManager;

public class MbSsnCheckAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		 // 1. 클라이언트에게 데이터를 받는다. 
		 MbForm mf = (MbForm)form;
		 String name = mf.getName();
		 String ssn1 = mf.getSsn1();
		 String ssn2 = mf.getSsn2();
		 if(name != null) name = name.trim();
		 if(ssn1 != null) ssn1 = ssn1.trim();
		 if(ssn2 != null) ssn2 = ssn2.trim();
		 String ssn = (ssn1 + ssn2);
		 
		 System.out.println("MbSsnCheckAction의 name : " + name 
		 		+ ", ssn1 : " + ssn1 + ", ssn2 : " + ssn2);
		 
		 // 2. DB table에 ssn1 + ssn2 의 회원이 있는 지 검사 
		 MbManager manager = MbManager.getInstance();
		 boolean result = manager.dbSelect(ssn);
		 Boolean result_ref = Boolean.valueOf(result); 
		 //System.out.println("MbSsnCheckAction의  result : " + result);
		 request.setAttribute("result", result_ref);
		 request.setAttribute("kind", "mbCheck");
		 
		 /*request.setAttribute("name", name);
		 request.setAttribute("ssn", ssn);*/
		 
		 HttpSession session = request.getSession();
	     session.setAttribute("mf", mf);
	        
		 // 3. forward 페이지를 매핑 
	     return mapping.findForward("fw-mb-ssnCheck-msg");
	 }
}
