package goods.mvc.model;

import java.util.*;

import mvc.domain.Goods;


public class GoodsService {
	private GoodsDAO dao;
	
	//SingleTon Object Model - Start!
	private static final GoodsService instance = new GoodsService();
	private GoodsService() {
		dao = new GoodsDAO();
	} // �޸��ϳ�(static)�÷�����, instance��ü�� ����ְ� instance�� ��ȯ���ش�.
	public static GoodsService getInstance() {
		return instance;
	}
	public ArrayList<Goods> listS(){
		System.out.println("�������");
		return dao.list();
		
	}
	public void insertS(Goods dto) {
		dao.insert(dto);
	}
	public boolean delS(int seq) {
		return dao.del(seq);
	}
}