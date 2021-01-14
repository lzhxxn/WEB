package goods.mvc.model;

import java.util.*;

import mvc.domain.Goods;


public class GoodsService {
	private GoodsDAO dao;
	
	//SingleTon Object Model - Start!
	private static final GoodsService instance = new GoodsService();
	private GoodsService() {
		dao = new GoodsDAO();
	} // 메모리하나(static)올려놓고, instance객체에 담아주고 instance를 반환해준다.
	public static GoodsService getInstance() {
		return instance;
	}
	public ArrayList<Goods> listS(){
		System.out.println("여기까지");
		return dao.list();
		
	}
	public void insertS(Goods dto) {
		dao.insert(dto);
	}
	public boolean delS(int seq) {
		return dao.del(seq);
	}
}