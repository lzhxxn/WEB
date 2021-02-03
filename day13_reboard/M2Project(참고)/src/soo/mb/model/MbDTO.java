package soo.mb.model;

public class MbDTO {
	private int no;
	private String name, ssn,  id, pwd, email, phone, date_str;
	
    public MbDTO(){}
    public MbDTO(int no, String name, String ssn, String id, 
    		String pwd, String email, String phone, String date_str)
    {
       this.no = no;
       this.name = name;
       this.ssn = ssn;
       this.id = id;
       this.pwd = pwd;
       this.email = email;
       this.phone = phone;
       this.date_str = date_str;
    }
    
    /**
	 * @return date_str을 리턴합니다.
	 */
	public String getDate_str() {
		return date_str;
	}
	/**
	 * @param date_str 설정하려는 date_str.
	 */
	public void setDate_str(String date_str) {
		this.date_str = date_str;
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
	 * @return no을 리턴합니다.
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no 설정하려는 no.
	 */
	public void setNo(int no) {
		this.no = no;
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
}
	
