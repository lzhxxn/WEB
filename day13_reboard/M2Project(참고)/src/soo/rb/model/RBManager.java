package soo.rb.model;

import java.util.ArrayList;

import soo.rb.controller.ReBoardEditForm;
import com.oreilly.servlet.MultipartRequest;

public class RBManager {
	private static RBManager instance = new RBManager();
    
    public RBManager(){}
    public static RBManager getInstance()
    {
    	return instance;
    }
    // 1. list���� �޼ҵ� 
    public ArrayList dbList(int tn, int cp, int ps)
    {
    	RBDAO dao = new RBDAO();	
    	ArrayList list = dao.dbDAOList(tn, cp, ps);
    	
    	return list;
    }
    public int dbTotalGulCount(int tn)
    {
    	RBDAO dao = new RBDAO();
    	int tgc = dao.dbDAOTotalGulCount(tn);
    	
    	return tgc;
    }
    
    
    // 2. writeOk����(ReBoardWriteOkAction����) �޼ҵ� 
    public boolean dbWriteOk(MultipartRequest mr, int tn)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOWriteOk(mr, tn);
    	
    	return result;
    }
    
    
    // 3. content���� �޼ҵ� 
    public RBDTO dbContent(int tn, int idx)
    {
    	RBDAO dao = new RBDAO();
    	RBDTO dto = dao.dbDAOContent(tn, idx);
    	
    	boolean result = dao.dbDAOReadnum(tn, idx);//�߰� - ��ȸ�� ���� 
		if(result)
			System.out.println("��ȸ�� ���� ����");
		else
			System.out.println("��ȸ�� ���� ����");
    	
    	return dto;
    }
    
    // 3_1. content�� reply SAVE���� �޼ҵ� 
    public boolean dbReplySave(int tn, int idx, 
    		String content_reply, String pwd_reply, String writer, String id)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOReplySave(
    			tn, idx, content_reply, pwd_reply, writer, id);
    	
        return result;
    }
    
    // 3_2. content�� reply LIST���� �޼ҵ� 
    public ArrayList dbReplyList(int tn, int idx)
    {
    	RBDAO dao = new RBDAO();
    	ArrayList list = dao.dbDAOReplyList(tn, idx);
    	
    	return list;
    }
    
    // 3_3_1. content�� reply Del ���� �޼ҵ�1 
    public boolean dbReplyDelToLoginid(int tn, int idx_reply, String id)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOReplyDelToLoginid(tn, idx_reply, id);
    	
    	return result;
    }
    //3_3_2. content�� reply Del ���� �޼ҵ�2
    public boolean dbReplyDelToPwd(int tn, int idx_reply, String pwd_reply)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOReplyDelToPwd(tn, idx_reply, pwd_reply);
    	
        return result;
    }
    
    // 4. edit���� �޼ҵ� 
    public RBDTO dbEdit(int tn, int idx)
    {
    	RBDAO dao = new RBDAO();
    	RBDTO dto = dao.dbDAOEdit(tn, idx);
    	
    	return dto;
    }
    public boolean dbEditOk(int tn, int idx, ReBoardEditForm rbEditForm)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOEditOk(tn, idx, rbEditForm);
    	
    	return result;
    }
    
    // 5. delOk ���� �޼ҵ� 
    public boolean dbDelOk(int tn, int idx, String pwd)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAODelOk(tn, idx, pwd);
    	
    	return result;
    }
    
    // 6. rewrite ���� �޼ҵ� 
    public boolean dbReWriteOk(MultipartRequest mr, int tn, int idx)
    {
    	RBDAO dao = new RBDAO();
    	boolean result = dao.dbDAOReWriteOk(mr, tn, idx);
    	
        return result;
    }
}
