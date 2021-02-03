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
		System.out.println("ReplyDTO() ȣ��");
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
	 * @return idx�� �����մϴ�.
	 */
	public int getIdx() {
		return idx;
	}
	/**
	 * @param idx �����Ϸ��� idx.
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	/**
	 * @return idx_reply�� �����մϴ�.
	 */
	public int getIdx_reply() {
		return idx_reply;
	}
	/**
	 * @param idx_reply �����Ϸ��� idx_reply.
	 */
	public void setIdx_reply(int idx_reply) {
		this.idx_reply = idx_reply;
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
	 * @return writedate�� �����մϴ�.
	 */
	public Date getWritedate() {
		return writedate;
	}
	/**
	 * @param writedate �����Ϸ��� writedate.
	 */
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
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
