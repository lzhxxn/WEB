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
