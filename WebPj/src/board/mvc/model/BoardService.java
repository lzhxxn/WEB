package board.mvc.model;

import java.util.*;

import mvc.domain.Board;
import board.mvc.vo.ListResult;

public class BoardService {
	private BoardDAO dao;
	
	//SingleTon Object Model - Start!
	private static final BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	public static BoardService getInstance() {
		return instance;
	}
	public ListResult getListResult(int currentPage, int pageSize) { //ListResult�� �����ϰԲ� �������ؼ� ListResultŸ��!
		System.out.println("");
		
		ArrayList<Board> list = dao.list(currentPage, pageSize); //use1
		
		long totalCount = dao.getTotalCount(); //use2
		
		return new ListResult(currentPage, totalCount, pageSize, list);
	}
	//SingleTon Object Model - End!
	/*public ArrayList<Board> listS(){
		return dao.list();
	}
	*/
	public void insertS(Board dto) {
		dao.insert(dto);
	}
	public Board contentS(int seq) {
		return dao.content(seq);
	}
	public boolean delS(int seq) {
		return dao.del(seq);
	}
	public void delAllS() {
		dao.delAll();
	}
	public Board update1S(int seq) {
		return dao.update1(seq);
	}
	public void update2S(Board dto) {
		dao.update2(dto);
	}
	public void upcountS(int seq) {
		dao.upcount(seq);
	}
	
}

