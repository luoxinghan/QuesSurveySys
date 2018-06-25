package com.cqut.dto;

import java.util.ArrayList;
import java.util.Date;

public class Question {
	
	private String id;
	
	private String questionName;
	
	private Byte questionType;
	
	private Integer questionNo;
	
	private Byte isRequired;
	
	private Date createTime;
	
	private String remark;
	
	private ArrayList<Option> options;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Byte getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Byte questionType) {
		this.questionType = questionType;
	}

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public Byte getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Byte isRequired) {
		this.isRequired = isRequired;
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

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

	public Question() {
		super();
	}

	public Question(String id, String questionName, Byte questionType, Integer questionNo, Byte isRequired,
			Date createTime, String remark) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.questionType = questionType;
		this.questionNo = questionNo;
		this.isRequired = isRequired;
		this.createTime = createTime;
		this.remark = remark;
	}
}
