package login.mvc.model;

import java.util.*;

import mvc.domain.*;
import login.mvc.model.*;
import static login.mvc.model.LoginCase.*;

public class LoginService { // 다른 패키지에서 쓰려면 public 으로써야한다. Controller에서
	private LoginDAO dao;
	
	private static final LoginService instance = new LoginService();
	//객체를 한개를 만들어서, 메모리에서 한개만 쓰겠다.
	private LoginService() { //생성자는 자기자신에서 호출하니까 private.
		dao = new LoginDAO();
	} // 메모리하나(static)올려놓고, instance객체에 담아주고 instance를 반환해준다.
	//외부에서 사용하게끔 getInstance()를 써준다.
	public static LoginService getInstance() {
		return instance;
	}
    // id/pwd만 놓고보면 boolean형은 합당하지않다. 맞는지 틀린지 두가지검사만된다.
	//int로하면 여러가지 수를 리턴핧수있기때문에 경우의수가많아져서 좋다
	public int checkAdmin(String email, String pwd) {
		Admin m = dao.getAdmin(email);
		if(m == null) {
			return NO_ID;
		}else {
			String pwdDb = m.getPwd();
			if(pwdDb != null) pwdDb = pwdDb.trim(); 
			
			if(!pwd.equals(pwdDb)) {
				return NO_PWD;
			}else {
				return PASS;
			} // session에 무엇을 저장하면 좋을까  ?
		}
	}
	public Admin getAdminS(String email) { //실제 멤버를 가져온다.
		Admin m = dao.getAdmin(email);
		m.setPwd(""); //pwd가 MVC로 이동하는건 좋은게아니다. 뷰나 컨트롤러로가는 pwd가 공백으로처리된다.
		//위에서 이미 검증을 거치기때문에 공백을넣어도된다. 해킹가능성도있다. for 보안성 ! !
		
		return m;
	}

}