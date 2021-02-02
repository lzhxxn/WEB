package addr.mvc.model;

import java.util.ArrayList;

import mvc.domain.Address;

public class AddrService { 
	private AddrDAO dao;
	
	//SingleTon Object Model - Start!
	private static final AddrService instance = new AddrService();
	private AddrService(){
		dao = new AddrDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	public static AddrService getInstance() {
		return instance;
	}
	//SingleTon Object Model - End!
	
	public ArrayList<Address> listS(){
		return dao.list();
	}
	public void insertS(Address dto){
		dao.insert(dto);
	}
	public boolean delS(int seq){
		return dao.del(seq);
	}
	public void delAllS(){
		dao.delAll();
	}
}
