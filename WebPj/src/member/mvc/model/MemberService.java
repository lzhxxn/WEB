package member.mvc.model;

import java.util.*;

import mvc.domain.Member;
import mvc.domain.Member;

public class MemberService {
	private MemberDAO dao;
	
	//SingleTon Object Model - Start!
	private static final MemberService instance = new MemberService();
	private MemberService() {
		dao = new MemberDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	public static MemberService getInstance() {
		return instance;
	}
	public ArrayList<Member> listS(){
		return dao.list();
	}
	public void insertS(Member dto) {
		dao.insert(dto);
	}
	public boolean delS(int seq) {
		return dao.del(seq);
	}
	public Member contentS(int seq) {
		return dao.content(seq);
	}
	public Member update1S(int seq) {
		return dao.update1(seq);
	}
	public void update2S(Member dto) {
		dao.update2(dto);
	}
}

