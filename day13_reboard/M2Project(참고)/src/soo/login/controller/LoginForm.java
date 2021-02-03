package soo.login.controller;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
   private String id;
   private String pwd;
   
   
	/**
	 * @return id을 리턴합니다.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id 설정하려는 id.
	 */
	public void setId(String id) {
		this.id = id;
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
}

