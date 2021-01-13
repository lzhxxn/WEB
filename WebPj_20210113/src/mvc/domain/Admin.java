package mvc.domain;

import java.sql.*;

public class Admin {
	private int seq;
	private String name;
	private String email;
	private String pwd;
	private String phone;
	private Date rdate; //최초날짜
	private Date udate; //갱신날짜

	public Admin() {}// MVC에서 쓸거기때문에 public

	public Admin(int seq, String name, String email, String pwd, String phone, Date rdate, Date udate) {
		super();
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phone = phone;
		this.rdate = rdate;
		this.udate = udate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	
}