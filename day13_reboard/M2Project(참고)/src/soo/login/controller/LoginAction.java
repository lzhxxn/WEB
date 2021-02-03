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
		// 1. Ŭ���̾�Ʈ �����͸� form���κ��� �����´�.
		LoginForm lf = (LoginForm)form;
		String id = lf.getId();
		String pwd = lf.getPwd();
		System.out.println("LoginAction�� id : " + id + ", pwd : " + pwd);
		
		/* 2. DB table�� id/pwd�� ��ġ ���� �˻� 
		 *   - id�� pwd�� ��ġ�ϴ� ���  (case_count == 1)
		 *   - id�� �������� �ʴ� ��� (case_count == 2)
		 *   - id����������, pwd�� ��ġ���� �ʴ� ��� (case_count == 3) 
		 *   - web server�� db server�� ���۽��� ����(count_count == 4)
		 * */
		LoginManager manager = LoginManager.getInstance();
		Object objs[] = manager.memberCheck(id, pwd);
		Integer cc_ref = (Integer)objs[0]; // ����� ���� ���� 
		MbDTO dto = (MbDTO)objs[1]; //������ ȸ���� ���� 
		System.out.println("LoginAction�� cc_ref : " + cc_ref);
		System.out.println("LoginAction�� dto : " + dto);
		
		request.setAttribute("cc_ref", cc_ref);
		int cc = cc_ref.intValue(); 
		if(cc== 1) 
		{
			HttpSession session = request.getSession();
		    session.setAttribute("loginOkUser", dto);
		}
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
			
		// 3. forward ������ ���� 
	    return mapping.findForward("fw-login-ok");
	 }
}
