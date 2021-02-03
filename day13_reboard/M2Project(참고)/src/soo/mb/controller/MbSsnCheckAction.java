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
		 // 1. Ŭ���̾�Ʈ���� �����͸� �޴´�. 
		 MbForm mf = (MbForm)form;
		 String name = mf.getName();
		 String ssn1 = mf.getSsn1();
		 String ssn2 = mf.getSsn2();
		 if(name != null) name = name.trim();
		 if(ssn1 != null) ssn1 = ssn1.trim();
		 if(ssn2 != null) ssn2 = ssn2.trim();
		 String ssn = (ssn1 + ssn2);
		 
		 System.out.println("MbSsnCheckAction�� name : " + name 
		 		+ ", ssn1 : " + ssn1 + ", ssn2 : " + ssn2);
		 
		 // 2. DB table�� ssn1 + ssn2 �� ȸ���� �ִ� �� �˻� 
		 MbManager manager = MbManager.getInstance();
		 boolean result = manager.dbSelect(ssn);
		 Boolean result_ref = Boolean.valueOf(result); 
		 //System.out.println("MbSsnCheckAction��  result : " + result);
		 request.setAttribute("result", result_ref);
		 request.setAttribute("kind", "mbCheck");
		 
		 /*request.setAttribute("name", name);
		 request.setAttribute("ssn", ssn);*/
		 
		 HttpSession session = request.getSession();
	     session.setAttribute("mf", mf);
	        
		 // 3. forward �������� ���� 
	     return mapping.findForward("fw-mb-ssnCheck-msg");
	 }
}
