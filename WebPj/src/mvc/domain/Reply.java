package mvc.domain;

import java.sql.Date;

public class Reply {
	private String email;
	private String content;
	private int grub;
	private int lev;
	private Date rdate;

	public Reply() {}

	public Reply(String email, String content, int grub, int lev, Date rdate) {
		super();
		this.email = email;
		this.content = content;
		this.grub = grub;
		this.lev = lev;
		this.rdate = rdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGrub() {
		return grub;
	}

	public void setGrub(int grub) {
		this.grub = grub;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
	
}
