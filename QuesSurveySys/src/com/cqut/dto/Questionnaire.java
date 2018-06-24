package com.cqut.dto;

import java.util.Date;

public class Questionnaire {

	private String id;
	
	private String qsnName;
	
	private String qsnDescribe;
	
	private String author;
	
	private Date endTime;
	
	private Date createTime;
	
	private Byte isDelete;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQsnName() {
		return qsnName;
	}

	public void setQsnName(String qsnName) {
		this.qsnName = qsnName;
	}
	
	public String getQsnDescribe() {
		return qsnDescribe;
	}

	public void setQsnDescribe(String qsnDescribe) {
		this.qsnDescribe = qsnDescribe;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Questionnaire() {
		super();
	}

	public Questionnaire(String id, String qsnName, String qsnDescribe, String author, Date endTime, Date createTime, Byte isDelete,
			String remark) {
		super();
		this.id = id;
		this.qsnName = qsnName;
		this.qsnDescribe = qsnDescribe;
		this.author = author;
		this.endTime = endTime;
		this.createTime = createTime;
		this.isDelete = isDelete;
		this.remark = remark;
	}
}
