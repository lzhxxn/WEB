package soo.rb.controller;

import javax.servlet.http.*;

import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;
import java.util.*;

import soo.rb.model.*;
import soo.mb.model.MbDTO;

public class ReBoardAction extends DispatchAction{
	
	// 1. listing 관련 Action 
	public ActionForward list(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		 // (1) client로부터 넘어온 데이터를 받는다. 
		 String method = request.getParameter("method");
		 //System.out.println("헤헤 ^^");
		 
		   //(1_1) tn을 session에 넣는다. 
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
		 
		 // cp는 session에 list시 넣지 않는다. 
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
		 
         //(1_2) ps을 session에 넣는다. 
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
		 		"#1. ReBoardAction의 method : " + method + ", tn_str : " + tn_str
				   + ", cp_str : " + cp_str + ", ps_str : " + ps_str); */
		 
		 // (2) DB에서 해당 view페이지를 꾸밀 dto를 가져온다.
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
		 		"#2. ReBoardAction의 rb_list : " + rb_list
				   + ", tgc : " + tgc + ", cp : " + cp + ", ps : " + ps); */
		 
		 // (3) view페이지를 지정한다. 
	     return mapping.findForward("fw-rb-list");
	 }
	
	 public ActionForward write(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		  String method = request.getParameter("method");
		  /*System.out.println(
		 		"ReBoardForm의 write()의 method : " + method); */
		  
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
	 
	 // 아래의 writeOk()는 없는 것으로 한다.
	 public ActionForward writeOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
          
	 	  //System.out.println("ReBoardAction의 writeOk() 호출");
	 	  
		  /*DispatchAction - get방식 
		     MultipartRequest - post방식 
		     ==> 충돌이 나므로 또다른 
		          Action파일(ReBoardWriteOkAction.java)을 생성해야 한다.  
		  */
			
	 	  return null;
	 }
	 
	 
	 //3. content 관련 Action
	 public ActionForward content(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  // (1) client데이터를 받는다. 
	 	  String method = request.getParameter("method");
	 	  String idx_str = request.getParameter("idx");
	 	  String cp_str = request.getParameter("cp");
	 	  
	 	  /*System.out.println(
	 	  		"content()의 method : " + method + ", idx_str : " + idx_str 
				       + ", cp_str : " + cp_str); */
	 	 
	 	  // (1_1) cp를 session에 넣는다.
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
          // (1_2) idx를 session에 넣는다.
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
	 	  // (1_3) tn을 session에서 가져온다.
	 	  String tn_str = (String)session.getAttribute("tn"); 
	 	  if(tn_str == null)
	 	  {
	 	  	 return new ActionForward("/main.do", true);
	 	  }
	 	  
	 	  
	 	  //(2) tn과 idx를 구해서, 비지니스로직을 처리한다.
 	  	  tn_str = tn_str.trim();
 	  	  idx_str = idx_str.trim();
 	  	  int tn = Integer.parseInt(tn_str);
 	  	  int idx = Integer.parseInt(idx_str);
	 	  
	 	  
	 	  RBManager manager = RBManager.getInstance();
		  RBDTO dto_content = manager.dbContent(tn, idx);
		  ArrayList dtos_reply = manager.dbReplyList(tn, idx); // ReplyDTO의 list가 담긴 ArrayList
		  
		  System.out.println("## 1. dto_content : " + dto_content);
		  System.out.println("## 2. dtos_reply : " + dtos_reply);
		  
		  
		  if((dto_content != null) && (dtos_reply != null))
		  {
		      request.setAttribute("dto_content", dto_content);
		      request.setAttribute("dtos_reply", dtos_reply);
		  }
		  else
		  {
		  	  System.out.println("dto_content 또는  dtos_reply가 null이군!!");
		  }
		  	 	  
          // (3) forward page를 셋팅 
	      return mapping.findForward("fw-rb-content");
	 }
	 
	 // 3_1. content page에서 reply저장 Action
	 public ActionForward replySave(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  String content_reply = request.getParameter("content_reply");
	 	  String pwd_reply = request.getParameter("pwd_reply");
	 	  /*System.out.println("replySave()의 method : " + method + 
	 	 		", content_reply : " + content_reply + ", pwd_reply : " + pwd_reply); */
	 	  if(content_reply != null)  content_reply = content_reply.trim();
	 	  if(pwd_reply != null)  pwd_reply = pwd_reply.trim();
	 	 
	 	  // (1) session에서 tn과 idx  가져오기 
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
	 	  
	 	
	 	 // (2) session에서 writer가져오기  
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
	 	 	System.out.println("리플 저장 성공");
	 	 else
	 	 	System.out.println("리플 저장 실패"); 
	 	 
	 	 return new ActionForward("/rb-content.do?method=content", true); //반드시 true로 해야 한다.
	 	 // 아니면 JSP페이지를 하나 더 만들어서 거기서 이동 
	 }
	 
     //	3_2. content page에서 reply 삭제 Action 
	 public ActionForward replyDel(ActionMapping mapping, 
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  String idx_reply_str = request.getParameter("idx_reply");
	 	  String pwd_reply_str = request.getParameter("pwd_reply");
	 	  
	 	  /*System.out.println("replyDel의 넘어온 값 method : " + method 
	 	  		+ ", idx_reply_str : "+ idx_reply_str 
				+ ", pwd_reply_str : " + pwd_reply_str);*/
	 	  
          //(1) idx_reply 습득 
	 	  if(idx_reply_str != null) idx_reply_str = idx_reply_str.trim();
	 	  int idx_reply = Integer.parseInt(idx_reply_str);
	 	  
	 	  //(2) pwd_reply 습득 
	 	  String pwd_reply = null;
	 	  if(pwd_reply_str != null) pwd_reply = pwd_reply_str.trim();
	 	  
          //(3) session에서 tn 가져오기 
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
	 	  if(pwd_reply_str == null) // 리플 글쓴이의 로그인 id로 리플삭제하는 경우 
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
	 	  else // 리플 비번으로 리플삭제하는 경우
	 	  {	  
	 	  	  result = manager.dbReplyDelToPwd(tn, idx_reply, pwd_reply); 
	 	  }
	 	  
	 	  
	 	 
	     
	 	  if(result)
	 	  {
	 	  	 System.out.println("reply 삭제 성공");
	 	  	
	 	  	 return new ActionForward("/rb-content.do?method=content", true); // 반드시 true
		 	 //return mapping.findForward("fw-rb-reply-del-msg"); 자바스크립트 메세지 처리하려면..
	 	  }
	 	  else
	 	  {
	 	  	 System.out.println("reply 삭제 실패");
	 	  	 
	 	     String msg = "replyDel";
		 	 Boolean result_ref = new Boolean(result);
		 	 request.setAttribute("msg", msg);
		 	 request.setAttribute("result", result_ref);  // 자바스크립트의 메세지를 위해..
		 	 
	 	     return mapping.findForward("fw-rb-reply-del-msg");
	 	  }
	 }
	 
     //	4. edit 관련 Action 
	 public ActionForward edit(ActionMapping mapping, 
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
	 	  String method = request.getParameter("method");
	 	  //System.out.println("edit의 method : " + method); 
	 	     
          //(1) session에서 tn/idx 가져오기 
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
	 	  //System.out.println("edit의 dto : " + dto);
	 	  request.setAttribute("dto", dto);
	 	  
	      return mapping.findForward("fw-rb-edit");
	 }
	 
     // 4_1. editOk 관련 Action
	 public ActionForward editOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  System.out.println("editOk의 method : " + method); 
	 	  
	 	  ReBoardEditForm rbEditForm = (ReBoardEditForm)form;
	 	  /*String content = rbEditForm.getContent();
	 	  String subject = rbEditForm.getSubject();
	 	  String writer = rbEditForm.getWriter();
	 	  String email = rbEditForm.getEmail();
	 	  String homepage = rbEditForm.getHomepage();
	 	  String pwd = rbEditForm.getPwd();
	 	  System.out.println("editOk()의 content : " + content  
	 	  		+ ", subject : " + subject + ", writer : " + writer + ", email : "+ email
				+ ", homepage : " + homepage + ", pwd : " + pwd);*/
	 	  
	 	  
          // (1) session에서 tn/idx 가져오기 
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
	 
	 
     //5. del 관련 Action
	 public ActionForward del(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  System.out.println("del의 method : " + method); 
	 	  
	 	  
	 	  return mapping.findForward("fw-rb-del");
	 }
	 
     //	5_1. delOk 관련 Action 
	 public ActionForward delOk(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 {
	 	  String method = request.getParameter("method");
	 	  String pwd = request.getParameter("pwd");
	 	  System.out.println("delOk의 method : " + method + ", pwd : " + pwd); 
	 	  
	 	  // (1) pwd 습득 
	 	  if(pwd != null) pwd = pwd.trim();
	 	  
          // (2) session에서 tn/idx 가져오기 
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
	 
	 // 6. rewrite (답변) 관련 메소드 
	 public ActionForward rewrite(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		  String method = request.getParameter("method");
		  String subject = request.getParameter("subject");
		  //System.out.println("rewrite()의 method : "+method+", subject : " + subject);
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
     < 참고 > 
  (1) list(ps도 체크) / write / writeOk  
      --> tn  ( Action에서 세션 체크 )

  (2) content에서 
      --> cp, idx, tn  (Action에서 세션 체크)
      
  (3) 글 수정에서 fileupload기능은 제외 했음 
  
  (4) 글 삭제시 관련 file 삭제기능은 제외 했음(자원의 보존성 차원)  
  
  (5) content에서 CurrentGul을 session에 담아두면 수정/삭제/답글 을 구현하는데 
      select SQL문을 줄일 수 있다. (but, 여기서는 그 방법을 쓰지 않았다.)   
 */
