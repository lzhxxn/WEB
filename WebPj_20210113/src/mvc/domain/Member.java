package mvc.domain;

import java.sql.*;

public class Member {
	private int seq;
	private String name;
	private String email;
	private String phone;
	private String addr;
	private String grade;
	private Date joindate;

	public Member() {}// MVC에서 쓸거기때문에 public

	public Member(int seq, String name, String email, String phone, String addr, String grade, Date joindate) {
		super();
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.grade = grade;
		this.joindate = joindate;
	}

	public int getSeq() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	
}