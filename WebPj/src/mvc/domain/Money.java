package mvc.domain;

import java.sql.*;

public class Money {
	private int seq;
	private String name;
	private String grade;
	private String pricesum;
	
	public Money() {}

	public Money(int seq, String name, String grade, String pricesum) {
		super();
		this.seq = seq;
		this.name = name;
		this.grade = grade;
		this.pricesum = pricesum;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPricesum() {
		return pricesum;
	}

	public void setPricesum(String pricesum) {
		this.pricesum = pricesum;
	}
	
}