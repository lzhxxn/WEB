package soo.mb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import soo.mb.model.MbManager;

public class MbInsertAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		 
		  // 1. client�� ���� ���� �޴´�. 
	      MbForm mf = (MbForm)form;
	      System.out.println("MbInsertAction�� MbForm : " + mf);
	      //String name = mf.getName();
	      //String ssn = mf.getSsn();
	      String id = mf.getId();
	      String pwd = mf.getPwd();
	      String email = mf.getEmail();
	      String phone = mf.getPhone();
	      
	     
	      // 2. session���� ���� name, ssn1, ssn2�� �޾Ƽ� mf�� �����Ѵ�.
	      HttpSession session = request.getSession();
	      MbForm mf_session = (MbForm)session.getAttribute("mf");
	      String name = "";
	      String ssn = "";
	      
	      if(mf_session != null)
	      {
		      name = mf_session.getName();
		      String ssn1 = mf_session.getSsn1();
		      String ssn2 = mf_session.getSsn2();
		      ssn = (ssn1 + ssn2);
	      }
	      else
	      {
	      	 return mapping.findForward("fw-mb-ssn");
	      }
	   
	      
	      System.out.println("MbInsertAction�� name : " + name + ", ssn : " + ssn 
	  	      + ", id : " + id + ", pwd : " + pwd + ", email : " + email + ", phone : " + phone);
	     
	      // 2. db table�� insert�Ѵ�. 
	      MbManager manager = MbManager.getInstance();
	      boolean result = manager.dbInsert(name, ssn, id, pwd, email, phone);
	      //System.out.println("MbInsertAction�� result : " + result);
	      Boolean result_ref = Boolean.valueOf(result);
	      request.setAttribute("result" , result_ref);
	      request.setAttribute("kind", "mbInsert");
	      //request.setAttribute("name", name);
	      //request.setAttribute("ssn", ssn);
	      session.removeAttribute("mf");
	      
	      // 3. forward page�� ���ν�Ų��.
	      return mapping.findForward("fw-mb-join-msg");
	 }
}
