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
 * @return content을 리턴합니다.
 */
public String getContent() {
	return content;
}
/**
 * @param content 설정하려는 content.
 */
public void setContent(String content) {
	this.content = content;
}
/**
 * @return email을 리턴합니다.
 */
public String getEmail() {
	return email;
}
/**
 * @param email 설정하려는 email.
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return filename을 리턴합니다.
 */
public String getFilename() {
	return filename;
}
/**
 * @param filename 설정하려는 filename.
 */
public void setFilename(String filename) {
	this.filename = filename;
}
/**
 * @return filesize을 리턴합니다.
 */
public int getFilesize() {
	return filesize;
}
/**
 * @param filesize 설정하려는 filesize.
 */
public void setFilesize(int filesize) {
	this.filesize = filesize;
}
/**
 * @return homepage을 리턴합니다.
 */
public String getHomepage() {
	return homepage;
}
/**
 * @param homepage 설정하려는 homepage.
 */
public void setHomepage(String homepage) {
	this.homepage = homepage;
}
/**
 * @return idx을 리턴합니다.
 */
public int getIdx() {
	return idx;
}
/**
 * @param idx 설정하려는 idx.
 */
public void setIdx(int idx) {
	this.idx = idx;
}
/**
 * @return lev을 리턴합니다.
 */
public int getLev() {
	return lev;
}
/**
 * @param lev 설정하려는 lev.
 */
public void setLev(int lev) {
	this.lev = lev;
}
/**
 * @return pwd을 리턴합니다.
 */
public String getPwd() {
	return pwd;
}
/**
 * @param pwd 설정하려는 pwd.
 */
public void setPwd(String pwd) {
	this.pwd = pwd;
}
/**
 * @return readnum을 리턴합니다.
 */
public int getReadnum() {
	return readnum;
}
/**
 * @param readnum 설정하려는 readnum.
 */
public void setReadnum(int readnum) {
	this.readnum = readnum;
}
/**
 * @return refer을 리턴합니다.
 */
public int getRefer() {
	return refer;
}
/**
 * @param refer 설정하려는 refer.
 */
public void setRefer(int refer) {
	this.refer = refer;
}
/**
 * @return subject을 리턴합니다.
 */
public String getSubject() {
	return subject;
}
/**
 * @param subject 설정하려는 subject.
 */
public void setSubject(String subject) {
	this.subject = subject;
}
/**
 * @return sunbun을 리턴합니다.
 */
public int getSunbun() {
	return sunbun;
}
/**
 * @param sunbun 설정하려는 sunbun.
 */
public void setSunbun(int sunbun) {
	this.sunbun = sunbun;
}
/**
 * @return writedate을 리턴합니다.
 */
public Date getWritedate() {
	return writedate;
}
/**
 * @param writedate 설정하려는 writedate.
 */
public void setWritedate(Date writedate) {
	this.writedate = writedate;
}
/**
 * @return writer을 리턴합니다.
 */
public String getWriter() {
	return writer;
}
/**
 * @param writer 설정하려는 writer.
 */
public void setWriter(String writer) {
	this.writer = writer;
}
}
