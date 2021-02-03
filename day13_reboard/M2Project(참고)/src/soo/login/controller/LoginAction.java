package soo.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import soo.login.model.LoginManager;
import soo.mb.model.MbDTO;


public class LoginAction extends Action{
	public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws java.lang.Exception
	 { 
		// 1. 클라이언트 데이터를 form으로부터 가져온다.
		LoginForm lf = (LoginForm)form;
		String id = lf.getId();
		String pwd = lf.getPwd();
		System.out.println("LoginAction의 id : " + id + ", pwd : " + pwd);
		
		/* 2. DB table에 id/pwd와 일치 여부 검사 
		 *   - id와 pwd가 일치하는 경우  (case_count == 1)
		 *   - id가 존재하지 않는 경우 (case_count == 2)
		 *   - id존재하지만, pwd가 일치하지 않는 경우 (case_count == 3) 
		 *   - web server나 db server의 갑작스런 오류(count_count == 4)
		 * */
		LoginManager manager = LoginManager.getInstance();
		Object objs[] = manager.memberCheck(id, pwd);
		Integer cc_ref = (Integer)objs[0]; // 경우의 수를 리턴 
		MbDTO dto = (MbDTO)objs[1]; //로인한 회원의 정보 
		System.out.println("LoginAction의 cc_ref : " + cc_ref);
		System.out.println("LoginAction의 dto : " + dto);
		
		request.setAttribute("cc_ref", cc_ref);
		int cc = cc_ref.intValue(); 
		if(cc== 1) 
		{
			HttpSession session = request.getSession();
		    session.setAttribute("loginOkUser", dto);
		}
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
			
		// 3. forward 페이지 매핑 
	    return mapping.findForward("fw-login-ok");
	 }
}
