package board.mvc.model;

import java.util.ArrayList;
import java.util.List;

import board.mvc.vo.ListResult;
import mvc.domain.Board;

public class BoardService {
	private BoardDAO dao;
	
	private static final BoardService instance = new BoardService();
	private BoardService(){
		dao = new BoardDAO();
	} 
	public static BoardService getInstance() {
		return instance;
	}
	
	public ListResult getListResult(int cp, int ps) {
		List<Board> list = dao.list(cp, ps); //use1
		long totalCount = dao.getTotalCount(); //use2
		ListResult r = new ListResult(cp, totalCount, ps, list);
		
		return r;
	}
	
	public ArrayList<Board> listS(){
		return dao.list();
	}
	public void insertS(Board board) {
		dao.insert(board);
	}
	public Board getBoardS(long seq) {
		return dao.getBoard(seq);
	}
	public void updateS(Board board) {
		dao.update(board);
	}
	public void delS(long seq) {
		dao.del(seq);
	}
}
