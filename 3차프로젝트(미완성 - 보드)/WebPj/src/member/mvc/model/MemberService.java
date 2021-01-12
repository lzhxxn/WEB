package member.mvc.model;

import java.util.*;


import mvc.domain.Member;

public class MemberService {
	private MemberDAO dao;
	
	//SingleTon Object Model - Start!
	private static final MemberService instance = new MemberService();
	private MemberService() {
		dao = new MemberDAO();
	} // 메모리하나(static)올려놓고, instance객체에 담아주고 instance를 반환해준다.
	public static MemberService getInstance() {
		return instance;
	}
	public ArrayList<Member> listS(){
		return dao.list();
	}
	public void insertS(Member dto) {
		dao.insert(dto);
	}

}

