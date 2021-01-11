package member.mvc.model;

import java.util.*;

import board.mvc.vo.ListResult;
import mvc.domain.Board;
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
	public ListResult getListResult(int currentPage, int pageSize) { //ListResult�� �����ϰԲ� �������ؼ� ListResultŸ��!
		System.out.println("");
		
		ArrayList<Member> list = dao.list(currentPage, pageSize); //use1
		
		long totalCount = dao.getTotalCount(); //use2
		
		return new ListResult(currentPage, totalCount, pageSize, list);
	}
	public void insertS(Member dto) {
		dao.insert(dto);
	}

}

