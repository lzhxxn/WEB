package mvc.domain;

import java.sql.Date;

public class Board { //DTO
	private int seq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private String fname;
	private String ofname;
	private long fsize;
	private Date rdate;
	private int count;
	
	public Board() {}

	public Board(int seq, String writer, String email, String subject, String content, String fname, String ofname,
			long fsize, Date rdate, int count) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.fname = fname;
		this.ofname = ofname;
		this.fsize = fsize;
		this.rdate = rdate;
		this.count = count;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
	