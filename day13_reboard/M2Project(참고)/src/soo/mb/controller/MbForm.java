package soo.mb.controller;

import org.apache.struts.action.ActionForm;

public class MbForm extends ActionForm{
   private String name;
   private String ssn1;
   private String ssn2;
   private String ssn;  // �߰�1
   
   private String id; //�߰� 2
   private String pwd; //�߰� 2
   private String email; //�߰� 2
   private String phone; //�߰� 2
    
   
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
 * @return name�� �����մϴ�.
 */
public String getName() {
	return name;
}
/**
 * @param name �����Ϸ��� name.
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return phone�� �����մϴ�.
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone �����Ϸ��� phone.
 */
public void setPhone(String phone) {
	this.phone = phone;
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
 * @return ssn�� �����մϴ�.
 */
public String getSsn() {
	return ssn;
}
/**
 * @param ssn �����Ϸ��� ssn.
 */
public void setSsn(String ssn) {
	this.ssn = ssn;
}
/**
 * @return ssn1�� �����մϴ�.
 */
public String getSsn1() {
	return ssn1;
}
/**
 * @param ssn1 �����Ϸ��� ssn1.
 */
public void setSsn1(String ssn1) {
	this.ssn1 = ssn1;
}
/**
 * @return ssn2�� �����մϴ�.
 */
public String getSsn2() {
	return ssn2;
}
/**
 * @param ssn2 �����Ϸ��� ssn2.
 */
public void setSsn2(String ssn2) {
	this.ssn2 = ssn2;
}
}
