package soo.mb.controller;

import org.apache.struts.action.ActionForm;

public class MbForm extends ActionForm{
   private String name;
   private String ssn1;
   private String ssn2;
   private String ssn;  // 추가1
   
   private String id; //추가 2
   private String pwd; //추가 2
   private String email; //추가 2
   private String phone; //추가 2
    
   
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
 * @return name을 리턴합니다.
 */
public String getName() {
	return name;
}
/**
 * @param name 설정하려는 name.
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return phone을 리턴합니다.
 */
public String getPhone() {
	return phone;
}
/**
 * @param phone 설정하려는 phone.
 */
public void setPhone(String phone) {
	this.phone = phone;
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
 * @return ssn을 리턴합니다.
 */
public String getSsn() {
	return ssn;
}
/**
 * @param ssn 설정하려는 ssn.
 */
public void setSsn(String ssn) {
	this.ssn = ssn;
}
/**
 * @return ssn1을 리턴합니다.
 */
public String getSsn1() {
	return ssn1;
}
/**
 * @param ssn1 설정하려는 ssn1.
 */
public void setSsn1(String ssn1) {
	this.ssn1 = ssn1;
}
/**
 * @return ssn2을 리턴합니다.
 */
public String getSsn2() {
	return ssn2;
}
/**
 * @param ssn2 설정하려는 ssn2.
 */
public void setSsn2(String ssn2) {
	this.ssn2 = ssn2;
}
}
