package mvc.domain;

import java.sql.*;

public class Member {
	private long seq;
	private String name;
	private String email;
	private String pwd;
	private String phone;
	private Date rdate;
	private Date update;
	
	public Member() {}

	public Member(long seq, String name, String email, String pwd, String phone, Date rdate, Date update) {
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phone = phone;
		this.rdate = rdate;
		this.update = update;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
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

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}
}
