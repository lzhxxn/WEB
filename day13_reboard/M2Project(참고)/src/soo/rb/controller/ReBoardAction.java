package soo.rb.controller;

import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;
import java.util.*;

import soo.rb.model.*;
import soo.mb.model.MbDTO;

public class ReBoardAction extends DispatchAction{
	
	// 1. listing ���� Action 
	public ActionForward list(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		 // (1) client�κ��� �Ѿ�� �����͸� �޴´�. 
		 String method = request.getParameter("method");
		 //System.out.println("���� ^^");
		 
		   //(1_1) tn�� session�� �ִ´�. 
		 HttpSession session = request.getSession();
		 
		 String tn_str = request.getParameter("tn");
		 if(tn_str == null) 
		 { 
		 	tn_str = (String)session.getAttribute("tn");
		 	if(tn_str == null) 
		 	{
		 		return new ActionForward("/main.do", true);
		 	}
		 }
		 else 
		 {
		 	tn_str = tn_str.trim();
		 	session.setAttribute("tn", tn_str);
		 }
		 
		 // cp�� session�� list�� ���� �ʴ´�. 
		 String cp_str = request.getParameter("cp");
		 if(cp_str == null)
		 {
		 	 cp_str = (String)session.getAttribute("cp");
		 	 if(cp_str == null) 
		 	 {
		 	    cp_str = "1";
		 	 }
		 }
		 else
		 {
		 	 cp_str = cp_str.trim();
		 }
		 
         //(1_2) ps�� session�� �ִ´�. 
		 String ps_str = request.getParameter("ps");
		 if(ps_str == null)
		 {
		 	ps_str = (String)session.getAttribute("ps");
		 	if(ps_str == null) 
		 	{
		 		ps_str ="3";
		 		session.setAttribute("ps", ps_str);
		 	}
		 } 
		 else
		 {
		 	ps_str = ps_str.trim();
		 	session.setAttribute("ps", ps_str);
		 }
		 /*System.out.println(
		 		"#1. ReBoardAction�� method : " + method + ", tn_str : " + tn_str
				   + ", cp_str : " + cp_str + ", ps_str : " + ps_str); */
		 
		 // (2) DB���� �ش� view�������� �ٹ� dto�� �����´�.
		 int tn = Integer.parseInt(tn_str.trim());
		 int cp = Integer.parseInt(cp_str.trim());
		 int ps = Integer.parseInt(ps_str.trim());
		 
		 
		 RBManager manager = RBManager.getInstance();
		 ArrayList rb_list = manager.dbList(tn, cp, ps);
		 int tgc = manager.dbTotalGulCount(tn);
		 request.setAttribute("rb_list", rb_list);
		 request.setAttribute("tgc", new Integer(tgc));
		 request.setAttribute("cp", new Integer(cp));
		 request.setAttribute("ps", new Integer(ps));
		 /*System.out.println(
		 		"#2. ReBoardAction�� rb_list : " + rb_list
				   + ", tgc : " + tgc + ", cp : " + cp + ", ps : " + ps); */
		 
		 // (3) view�������� �����Ѵ�. 
	     return mapping.findForward("fw-rb-list");
	 }
	
	 public ActionForward write(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		  String method = request.getParameter("method");
		  /*System.out.println(
		 		"ReBoardForm�� write()�� method : " + method); */
		  
		  HttpSession session = request.getSession();
		  String tn_str = (String)session.getAttribute("tn");
		  int tn = 0;
		  if(tn_str == null || tn_str.equals(""))
		  {
		  	  return new ActionForward("/main.do", true);
		  }
		  else 
		  {
	          return mapping.findForward("fw-rb-write");
		  }
	 }
	 
	 // �Ʒ��� writeOk()�� ���� ������ �Ѵ�.
	 public ActionForward writeOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
          
	 	  //System.out.println("ReBoardAction�� writeOk() ȣ��");
	 	  
		  /*DispatchAction - get��� 
		     MultipartRequest - post��� 
		     ==> �浹�� ���Ƿ� �Ǵٸ� 
		          Action����(ReBoardWriteOkAction.java)�� �����ؾ� �Ѵ�.  
		  */
			
	 	  return null;
	 }
	 
	 
	 //3. content ���� Action
	 public ActionForward content(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  // (1) client�����͸� �޴´�. 
	 	  String method = request.getParameter("method");
	 	  String idx_str = request.getParameter("idx");
	 	  String cp_str = request.getParameter("cp");
	 	  
	 	  /*System.out.println(
	 	  		"content()�� method : " + method + ", idx_str : " + idx_str 
				       + ", cp_str : " + cp_str); */
	 	 
	 	  // (1_1) cp�� session�� �ִ´�.
	 	  HttpSession session = request.getSession();
	 	  if(cp_str == null)
		  {
		 	 cp_str = (String)session.getAttribute("cp");
		 	 if(cp_str == null)
		 	 {
		 	 	return new ActionForward("/rb-list.do?method=list", true);
		 	 }
		  }
		  else
		  {
		 	 cp_str = cp_str.trim();
		 	 session.setAttribute("cp", cp_str);
		  }
          // (1_2) idx�� session�� �ִ´�.
	 	  if(idx_str == null)
		  {
	 	  	 idx_str = (String)session.getAttribute("idx");
		 	 if(idx_str == null)
		 	 {
		 	 	return new ActionForward("/rb-list.do?method=list", true);  
		 	 }
		  }
		  else
		  {
		 	 idx_str = idx_str.trim();
		 	 session.setAttribute("idx", idx_str);
		  }
	 	  // (1_3) tn�� session���� �����´�.
	 	  String tn_str = (String)session.getAttribute("tn"); 
	 	  if(tn_str == null)
	 	  {
	 	  	 return new ActionForward("/main.do", true);
	 	  }
	 	  
	 	  
	 	  //(2) tn�� idx�� ���ؼ�, �����Ͻ������� ó���Ѵ�.
 	  	  tn_str = tn_str.trim();
 	  	  idx_str = idx_str.trim();
 	  	  int tn = Integer.parseInt(tn_str);
 	  	  int idx = Integer.parseInt(idx_str);
	 	  
	 	  
	 	  RBManager manager = RBManager.getInstance();
		  RBDTO dto_content = manager.dbContent(tn, idx);
		  ArrayList dtos_reply = manager.dbReplyList(tn, idx); // ReplyDTO�� list�� ��� ArrayList
		  
		  System.out.println("## 1. dto_content : " + dto_content);
		  System.out.println("## 2. dtos_reply : " + dtos_reply);
		  
		  
		  if((dto_content != null) && (dtos_reply != null))
		  {
		      request.setAttribute("dto_content", dto_content);
		      request.setAttribute("dtos_reply", dtos_reply);
		  }
		  else
		  {
		  	  System.out.println("dto_content �Ǵ�  dtos_reply�� null�̱�!!");
		  }
		  	 	  
          // (3) forward page�� ���� 
	      return mapping.findForward("fw-rb-content");
	 }
	 
	 // 3_1. content page���� reply���� Action
	 public ActionForward replySave(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  String content_reply = request.getParameter("content_reply");
	 	  String pwd_reply = request.getParameter("pwd_reply");
	 	  /*System.out.println("replySave()�� method : " + method + 
	 	 		", content_reply : " + content_reply + ", pwd_reply : " + pwd_reply); */
	 	  if(content_reply != null)  content_reply = content_reply.trim();
	 	  if(pwd_reply != null)  pwd_reply = pwd_reply.trim();
	 	 
	 	  // (1) session���� tn�� idx  �������� 
	 	  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn"); 
	 	  if(tn_str == null)
	 	  {
	 	  	 return new ActionForward("/main.do", true);
	 	  }
	 	  String idx_str = (String)session.getAttribute("idx");
	 	  if(idx_str == null)
	 	  {
	 	  	 return new ActionForward("/rb-list.do?method=list", true);
	 	  }
	 	  
 	  	  tn_str = tn_str.trim();
 	  	  idx_str = idx_str.trim();
 	  	  int tn = Integer.parseInt(tn_str);
 	  	  int idx = Integer.parseInt(idx_str);
	 	  
	 	
	 	 // (2) session���� writer��������  
	 	 MbDTO dto =  (MbDTO)session.getAttribute("loginOkUser");
	 	 if(dto == null) 
	 	 {
	 	 	session.setAttribute("returnPage", "rb-content.do?method=content");
	 	 	return new ActionForward("/login.do", true); 
	 	 }
	 	 
	 	 String writer = dto.getName();
	 	 String id = dto.getId();
	 	 if(writer != null) writer = writer.trim();
	 	 if(id != null) id = id.trim();
	 	 
	 	 RBManager manager = RBManager.getInstance();
	 	 boolean result = manager.dbReplySave(
	 	 		tn, idx, content_reply, pwd_reply, writer, id);
	 	 
	 	 if(result)
	 	 	System.out.println("���� ���� ����");
	 	 else
	 	 	System.out.println("���� ���� ����"); 
	 	 
	 	 return new ActionForward("/rb-content.do?method=content", true); //�ݵ�� true�� �ؾ� �Ѵ�.
	 	 // �ƴϸ� JSP�������� �ϳ� �� ���� �ű⼭ �̵� 
	 }
	 
     //	3_2. content page���� reply ���� Action 
	 public ActionForward replyDel(ActionMapping mapping, 
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  String idx_reply_str = request.getParameter("idx_reply");
	 	  String pwd_reply_str = request.getParameter("pwd_reply");
	 	  
	 	  /*System.out.println("replyDel�� �Ѿ�� �� method : " + method 
	 	  		+ ", idx_reply_str : "+ idx_reply_str 
				+ ", pwd_reply_str : " + pwd_reply_str);*/
	 	  
          //(1) idx_reply ���� 
	 	  if(idx_reply_str != null) idx_reply_str = idx_reply_str.trim();
	 	  int idx_reply = Integer.parseInt(idx_reply_str);
	 	  
	 	  //(2) pwd_reply ���� 
	 	  String pwd_reply = null;
	 	  if(pwd_reply_str != null) pwd_reply = pwd_reply_str.trim();
	 	  
          //(3) session���� tn �������� 
	 	  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  
 	  	  if(tn_str == null)
 	  	  {
 	  	     return new ActionForward("/main.do", true);
 	  	  }
	 	  else
	 	  {
	 	  	 tn_str = tn_str.trim();
	 	  }
	 	  int tn = Integer.parseInt(tn_str);
	 	  
	 	  
	 	  boolean result = false;
          RBManager manager = RBManager.getInstance();
	 	  if(pwd_reply_str == null) // ���� �۾����� �α��� id�� ���û����ϴ� ��� 
	 	  {
	 	  	  String id = null;
	 	  	  MbDTO mbDto = (MbDTO)session.getAttribute("loginOkUser");
	 	  	  if(mbDto == null)
	 	  	  {
	 	  	    session.setAttribute("returnPage", "rb-content.do?method=content");
		 	 	return new ActionForward("/login.do", true);
	 	  	  }
	 	  	  else
	 	  	  {
	 	  	  	 id = mbDto.getId();	
	 	  	  }
	 	  	  if(id != null) id = id.trim();
	 	  	  result = manager.dbReplyDelToLoginid(tn, idx_reply, id); 
	 	  }
	 	  else // ���� ������� ���û����ϴ� ���
	 	  {	  
	 	  	  result = manager.dbReplyDelToPwd(tn, idx_reply, pwd_reply); 
	 	  }
	 	  
	 	  
	 	 
	     
	 	  if(result)
	 	  {
	 	  	 System.out.println("reply ���� ����");
	 	  	
	 	  	 return new ActionForward("/rb-content.do?method=content", true); // �ݵ�� true
		 	 //return mapping.findForward("fw-rb-reply-del-msg"); �ڹٽ�ũ��Ʈ �޼��� ó���Ϸ���..
	 	  }
	 	  else
	 	  {
	 	  	 System.out.println("reply ���� ����");
	 	  	 
	 	     String msg = "replyDel";
		 	 Boolean result_ref = new Boolean(result);
		 	 request.setAttribute("msg", msg);
		 	 request.setAttribute("result", result_ref);  // �ڹٽ�ũ��Ʈ�� �޼����� ����..
		 	 
	 	     return mapping.findForward("fw-rb-reply-del-msg");
	 	  }
	 }
	 
     //	4. edit ���� Action 
	 public ActionForward edit(ActionMapping mapping, 
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  //System.out.println("edit�� method : " + method); 
	 	     
          //(1) session���� tn/idx �������� 
	 	  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  String idx_str = (String)session.getAttribute("idx");
	 	   
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
	 	  	 tn_str = tn_str.trim();
	 	  	 idx_str = idx_str.trim();
	 	  }
	 	  int tn = Integer.parseInt(tn_str);
	 	  int idx = Integer.parseInt(idx_str);
	 	  
	 	  RBManager manager = RBManager.getInstance();
	 	  RBDTO dto = manager.dbEdit(tn, idx);
	 	  //System.out.println("edit�� dto : " + dto);
	 	  request.setAttribute("dto", dto);
	 	  
	      return mapping.findForward("fw-rb-edit");
	 }
	 
     // 4_1. editOk ���� Action
	 public ActionForward editOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  System.out.println("editOk�� method : " + method); 
	 	  
	 	  ReBoardEditForm rbEditForm = (ReBoardEditForm)form;
	 	  /*String content = rbEditForm.getContent();
	 	  String subject = rbEditForm.getSubject();
	 	  String writer = rbEditForm.getWriter();
	 	  String email = rbEditForm.getEmail();
	 	  String homepage = rbEditForm.getHomepage();
	 	  String pwd = rbEditForm.getPwd();
	 	  System.out.println("editOk()�� content : " + content  
	 	  		+ ", subject : " + subject + ", writer : " + writer + ", email : "+ email
				+ ", homepage : " + homepage + ", pwd : " + pwd);*/
	 	  
	 	  
          // (1) session���� tn/idx �������� 
	 	  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  String idx_str = (String)session.getAttribute("idx");
	 	   
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
	 	  	 tn_str = tn_str.trim();
	 	  	 idx_str = idx_str.trim();
	 	  }
	 	  int tn = Integer.parseInt(tn_str);
	 	  int idx = Integer.parseInt(idx_str);
	 	  
	 	  RBManager manager = RBManager.getInstance();
	 	  boolean result = manager.dbEditOk(tn, idx, rbEditForm);
	 	  Boolean result_obj = new Boolean(result);
	 	  
	 	  request.setAttribute("msg", "editok");
	      request.setAttribute("result", result_obj);
	      
	      return mapping.findForward("fw-edit-ok");
	 }
	 
	 
     //5. del ���� Action
	 public ActionForward del(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  System.out.println("del�� method : " + method); 
	 	  
	 	  
	 	  return mapping.findForward("fw-rb-del");
	 }
	 
     //	5_1. delOk ���� Action 
	 public ActionForward delOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  String pwd = request.getParameter("pwd");
	 	  System.out.println("delOk�� method : " + method + ", pwd : " + pwd); 
	 	  
	 	  // (1) pwd ���� 
	 	  if(pwd != null) pwd = pwd.trim();
	 	  
          // (2) session���� tn/idx �������� 
	 	  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  String idx_str = (String)session.getAttribute("idx");
	 	   
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
	 	  	 tn_str = tn_str.trim();
	 	  	 idx_str = idx_str.trim();
	 	  }
	 	  int tn = Integer.parseInt(tn_str);
	 	  int idx = Integer.parseInt(idx_str);
	 	  
	 	  RBManager manager = RBManager.getInstance();
	 	  boolean result = manager.dbDelOk(tn, idx, pwd);
	 	  Boolean result_obj = new Boolean(result);
	 	  
	 	  request.setAttribute("msg", "delok");
	      request.setAttribute("result", result_obj);
	      
	      return mapping.findForward("fw-del-ok");
	 }
	 
	 // 6. rewrite (�亯) ���� �޼ҵ� 
	 public ActionForward rewrite(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		  String method = request.getParameter("method");
		  String subject = request.getParameter("subject");
		  //System.out.println("rewrite()�� method : "+method+", subject : " + subject);
		  if(subject == null) subject = "";
		  
		  HttpSession session = request.getSession();
	 	  String tn_str = (String)session.getAttribute("tn");
	 	  String idx_str = (String)session.getAttribute("idx");
	 	   
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
	 	  	 request.setAttribute("subject", subject);
	 	  	 return mapping.findForward("fw-rb-rewrite");
	 	  }
	 }
}



/*
     < ���� > 
  (1) list(ps�� üũ) / write / writeOk  
      --> tn  ( Action���� ���� üũ )

  (2) content���� 
      --> cp, idx, tn  (Action���� ���� üũ)
      
  (3) �� �������� fileupload����� ���� ���� 
  
  (4) �� ������ ���� file ��������� ���� ����(�ڿ��� ������ ����)  
  
  (5) content���� CurrentGul�� session�� ��Ƶθ� ����/����/��� �� �����ϴµ� 
      select SQL���� ���� �� �ִ�. (but, ���⼭�� �� ����� ���� �ʾҴ�.)   
 */
