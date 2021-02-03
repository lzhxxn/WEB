package soo.mb.model;

import java.util.ArrayList;


public class MbManager {
	private static MbManager instance = new MbManager();
    
    public MbManager(){}
    public static MbManager getInstance()
    {
    	return instance;
    }
    
    // memberJoin 관련 메소드 
    public boolean dbSelect(String ssn)
    {	
    	MbDAO dao = new MbDAO();
    	boolean result = dao.dbDAOSelect(ssn);
    	if(result)
    		return true;
    	else
    	    return false;
    }
    public boolean dbInsert(String name, String ssn, 
    		String id, String pwd, String email, String phone)
    {
    	MbDAO dao = new MbDAO();
    	boolean result = dao.dbDAOInsert(name, ssn, id, pwd, email, phone);
    	if(result) 
    		return true;
    	else 
    		return false;
    }
    
    // MemberFind 관련 메소드 
    public ArrayList dbSelect(String select, String searchString)
    {
    	MbDAO dao = new MbDAO();
    	ArrayList list = dao.dbDAOSelect(select, searchString);
    	
    	return list;
    }
}
