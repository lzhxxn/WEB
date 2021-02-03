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
	 * @return date_str�� �����մϴ�.
	 */
	public String getDate_str() {
		return date_str;
	}
	/**
	 * @param date_str �����Ϸ��� date_str.
	 */
	public void setDate_str(String date_str) {
		this.date_str = date_str;
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
	 * @return no�� �����մϴ�.
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no �����Ϸ��� no.
	 */
	public void setNo(int no) {
		this.no = no;
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
}
	
