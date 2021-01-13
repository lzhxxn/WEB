package money.mvc.model;

import java.util.*;

import mvc.domain.Money;

public class MoneyService {
	private MemberDAO dao;
	
	//SingleTon Object Model - Start!
	private static final MoneyService instance = new MoneyService();
	private MoneyService() {
		dao = new MemberDAO();
	} // 메모리하나(static)올려놓고, instance객체에 담아주고 instance를 반환해준다.
	public static MoneyService getInstance() {
		return instance;
	}
	public ArrayList<Money> listS(){
		return dao.list();
	}
}