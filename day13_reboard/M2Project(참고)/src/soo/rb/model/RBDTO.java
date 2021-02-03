package soo.rb.model;

import java.sql.*;

public class RBDTO {
   int idx;
   String writer;
   String email;
   String homepage;
   String pwd;
   String subject;
   String content;
   Date writedate;
   int readnum;
   String filename;
   int filesize;
   int refer;
   int lev;
   int sunbun;
   
   public RBDTO(){}
	/**
	 * @param idx
	 * @param writer
	 * @param email
	 * @param homepage
	 * @param pwd
	 * @param subject
	 * @param content
	 * @param writedate
	 * @param readnum
	 * @param filename
	 * @param filesize
	 * @param refer
	 * @param lev
	 * @param sunbun
	 */
	public RBDTO(int idx, String writer, String email, String homepage,
			String pwd, String subject, String content, Date writedate,
			int readnum, String filename, int filesize, int refer, int lev,
			int sunbun) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.email = email;
		this.homepage = homepage;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.readnum = readnum;
		this.filename = filename;
		this.filesize = filesize;
		this.refer = refer;
		this.lev = lev;
		this.sunbun = sunbun;
	}
	
	
/**
 * @return content�� �����մϴ�.
 */
public String getContent() {
	return content;
}
/**
 * @param content �����Ϸ��� content.
 */
public void setContent(String content) {
	this.content = content;
}
/**
 * @return email�� �����մϴ�.
 */
public String getEmail() {
	return email;
}
/**
 * @param email �����Ϸ��� email.
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return filename�� �����մϴ�.
 */
public String getFilename() {
	return filename;
}
/**
 * @param filename �����Ϸ��� filename.
 */
public void setFilename(String filename) {
	this.filename = filename;
}
/**
 * @return filesize�� �����մϴ�.
 */
public int getFilesize() {
	return filesize;
}
/**
 * @param filesize �����Ϸ��� filesize.
 */
public void setFilesize(int filesize) {
	this.filesize = filesize;
}
/**
 * @return homepage�� �����մϴ�.
 */
public String getHomepage() {
	return homepage;
}
/**
 * @param homepage �����Ϸ��� homepage.
 */
public void setHomepage(String homepage) {
	this.homepage = homepage;
}
/**
 * @return idx�� �����մϴ�.
 */
public int getIdx() {
	return idx;
}
/**
 * @param idx �����Ϸ��� idx.
 */
public void setIdx(int idx) {
	this.idx = idx;
}
/**
 * @return lev�� �����մϴ�.
 */
public int getLev() {
	return lev;
}
/**
 * @param lev �����Ϸ��� lev.
 */
public void setLev(int lev) {
	this.lev = lev;
}
/**
 * @return pwd�� �����մϴ�.
 */
public String getPwd() {
	return pwd;
}
/**
 * @param pwd �����Ϸ��� pwd.
 */
public void setPwd(String pwd) {
	this.pwd = pwd;
}
/**
 * @return readnum�� �����մϴ�.
 */
public int getReadnum() {
	return readnum;
}
/**
 * @param readnum �����Ϸ��� readnum.
 */
public void setReadnum(int readnum) {
	this.readnum = readnum;
}
/**
 * @return refer�� �����մϴ�.
 */
public int getRefer() {
	return refer;
}
/**
 * @param refer �����Ϸ��� refer.
 */
public void setRefer(int refer) {
	this.refer = refer;
}
/**
 * @return subject�� �����մϴ�.
 */
public String getSubject() {
	return subject;
}
/**
 * @param subject �����Ϸ��� subject.
 */
public void setSubject(String subject) {
	this.subject = subject;
}
/**
 * @return sunbun�� �����մϴ�.
 */
public int getSunbun() {
	return sunbun;
}
/**
 * @param sunbun �����Ϸ��� sunbun.
 */
public void setSunbun(int sunbun) {
	this.sunbun = sunbun;
}
/**
 * @return writedate�� �����մϴ�.
 */
public Date getWritedate() {
	return writedate;
}
/**
 * @param writedate �����Ϸ��� writedate.
 */
public void setWritedate(Date writedate) {
	this.writedate = writedate;
}
/**
 * @return writer�� �����մϴ�.
 */
public String getWriter() {
	return writer;
}
/**
 * @param writer �����Ϸ��� writer.
 */
public void setWriter(String writer) {
	this.writer = writer;
}
}
