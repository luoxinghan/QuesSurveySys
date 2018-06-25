package com.cqut.dto;

import java.util.Date;

public class Option {
	
	private String id;
	
	private String questionId;
	
	private String optionName;
	
	private Integer optionNo;
	
	private Date createTime;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(Integer optionNo) {
		this.optionNo = optionNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Option() {
		super();
	}

	public Option(String id, String questionId, String optionName, Integer optionNo, Date createTime, String remark) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.optionName = optionName;
		this.optionNo = optionNo;
		this.createTime = createTime;
		this.remark = remark;
	}
}
