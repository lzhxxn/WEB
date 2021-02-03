package soo.rb.controller;

import org.apache.struts.action.ActionForm;

public class ReBoardEditForm extends ActionForm{
   private String subject;
   private String content;
   private String writer;
   private String email;
   private String homepage;
   private String pwd;
   
   public ReBoardEditForm(){}
   
   
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
