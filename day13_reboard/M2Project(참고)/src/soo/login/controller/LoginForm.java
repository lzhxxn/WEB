package soo.login.controller;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{
   private String id;
   private String pwd;
   
   
	/**
	 * @return id�� �����մϴ�.
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id �����Ϸ��� id.
	 */
	public void setId(String id) {
		this.id = id;
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
}

