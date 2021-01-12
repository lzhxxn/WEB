package money.mvc.model;

import java.util.*;

import mvc.domain.Money;

public class MoneyService {
	private MemberDAO dao;
	
	//SingleTon Object Model - Start!
	private static final MoneyService instance = new MoneyService();
	private MoneyService() {
		dao = new MemberDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	public static MoneyService getInstance() {
		return instance;
	}
	public ArrayList<Money> listS(){
		return dao.list();
	}
}