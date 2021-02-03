package soo.rb.model;

import java.sql.Date;

public class ReplyDTO {
	int idx_reply;
	String writer;
	String pwd;
	String content;
	Date writedate;
	String id;
	int idx;
	
	public ReplyDTO()
	{
		System.out.println("ReplyDTO() 호출");
	}
	
	public ReplyDTO(int idx_reply, String writer, String pwd, String content,
			Date writedate, String id, int idx) {
		super();
		this.idx_reply = idx_reply;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.writedate = writedate;
		this.id = id;
		this.idx = idx;
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
	 * @return idx_reply을 리턴합니다.
	 */
	public int getIdx_reply() {
		return idx_reply;
	}
	/**
	 * @param idx_reply 설정하려는 idx_reply.
	 */
	public void setIdx_reply(int idx_reply) {
		this.idx_reply = idx_reply;
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
