package goods.mvc.model;

class GoodsSQL {
	static final String LIST= "select * from GOODS order by SEQ desc";
	static final String INSERT = "insert into GOODS values(?, ?, ?, ?, ?, ?, ?)";
	static final String DEL = "delete from GOODS where SEQ=?";
	//�����Ȼ���� ���ǿ� �ֱ����� ���� *�� �Ѵ�. pwd���ƴ϶�.
}

