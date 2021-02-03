package soo.login.model;

import soo.mb.model.MbDTO;

public class LoginManager {
	private static LoginManager instance = new LoginManager();
    
    public LoginManager(){}
    public static LoginManager getInstance()
    {
    	return instance;
    }
    
    public Object[] memberCheck(String id, String pwd)
    {
    	Object objs[] = new Object[2];
        LoginDAO dao = new LoginDAO();
        int n = dao.memberDAOCheck(id, pwd);
        Integer n_ref = new Integer(n);
        MbDTO dto = dao.getMbDTO();
        objs[0] = n_ref;
        objs[1] = dto;
        
        return objs;
    }
}
