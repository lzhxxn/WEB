package addr.mvc.model;

class AddrSQL {
	static final String LIST = "select * from ADDRESS order by SEQ desc";
	static final String INSERT 
	   = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	static final String DEL="delete from ADDRESS where SEQ=?";
	static final String DEL_ALL="delete from ADDRESS";
}
