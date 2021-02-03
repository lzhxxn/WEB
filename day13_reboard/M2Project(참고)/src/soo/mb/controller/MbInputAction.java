package soo.mb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;
//import soo.util.hangul.Han;

public class MbInputAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		/*MbForm mf = (MbForm)form;
		String name = mf.getName();
		String ssn = mf.getSsn();
		
		System.out.println("MbInputAction¿« name : " + name  + ", ssn : " + ssn);
		request.setAttribute("name", name);
		request.setAttribute("ssn", ssn);*/
		 HttpSession session = request.getSession();
	     MbForm mf_session = (MbForm)session.getAttribute("mf");
	     /*String name = mf_session.getName();
	     String ssn1 = mf_session.getSsn1();
	     String ssn2 = mf_session.getSsn2();
	     System.out.println("MbInputAction¿« name : " + name  
	     		+ ", ssn1 : " + ssn1 + ", ssn2 : " + ssn2); */
		
		
	    return mapping.findForward("fw-mb-input");
	 }
}
