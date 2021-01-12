package login.mvc.model;

import java.util.*;

import mvc.domain.*;
import login.mvc.model.*;
import static login.mvc.model.LoginCase.*;

public class LoginService { // �ٸ� ��Ű������ ������ public ���ν���Ѵ�. Controller����
	private LoginDAO dao;
	
	private static final LoginService instance = new LoginService();
	//��ü�� �Ѱ��� ����, �޸𸮿��� �Ѱ��� ���ڴ�.
	private LoginService() { //�����ڴ� �ڱ��ڽſ��� ȣ���ϴϱ� private.
		dao = new LoginDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	//�ܺο��� ����ϰԲ� getInstance()�� ���ش�.
	public static LoginService getInstance() {
		return instance;
	}
    // id/pwd�� ������ boolean���� �մ������ʴ�. �´��� Ʋ���� �ΰ����˻縸�ȴ�.
	//int���ϸ� �������� ���� �����C���ֱ⶧���� ����Ǽ����������� ����
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
			} // session�� ������ �����ϸ� ������  ?
		}
	}
	public Admin getAdminS(String email) { //���� ����� �����´�.
		Admin m = dao.getAdmin(email);
		m.setPwd(""); //pwd�� MVC�� �̵��ϴ°� �����Ծƴϴ�. �䳪 ��Ʈ�ѷ��ΰ��� pwd�� ��������ó���ȴ�.
		//������ �̹� ������ ��ġ�⶧���� �������־�ȴ�. ��ŷ���ɼ����ִ�. for ���ȼ� ! !
		
		return m;
	}

}