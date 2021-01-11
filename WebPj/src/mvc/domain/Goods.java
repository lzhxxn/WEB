package mvc.domain;

import java.sql.*;

public class Goods {
	private int seq;
	private String name;
	private String etc;
	private String fname;
	private String ofname;
	private long fsize;
	private Date rdate; 

	public Goods() {}// MVC에서 쓸거기때문에 public

	public Goods(int seq, String name, String etc, String fname, String ofname, long fsize, Date rdate) {
		super();
		this.seq = seq;
		this.name = name;
		this.etc = etc;
		this.fname = fname;
		this.ofname = ofname;
		this.fsize = fsize;
		this.rdate = rdate;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getOfname() {
		return ofname;
	}

	public void setOfname(String ofname) {
		this.ofname = ofname;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	
	}