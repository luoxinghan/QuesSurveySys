package com.cqut.dto;

import java.util.Date;

public class UserAnswer {
	
	private String id;
	
	private String userSurveyId;
	
	private String questionId;
	
	private String optionId;
	
	private String optionInfo;
	
	private Date createTime;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserSurveyId() {
		return userSurveyId;
	}

	public void setUserSurveyId(String userSurveyId) {
		this.userSurveyId = userSurveyId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionInfo() {
		return optionInfo;
	}

	public void setOptionInfo(String optionInfo) {
		this.optionInfo = optionInfo;
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

	public UserAnswer() {
		super();
	}

	public UserAnswer(String id, String userSurveyId, String questionId, String optionId, String optionInfo,
			Date createTime, String remark) {
		super();
		this.id = id;
		this.userSurveyId = userSurveyId;
		this.questionId = questionId;
		this.optionId = optionId;
		this.optionInfo = optionInfo;
		this.createTime = createTime;
		this.remark = remark;
	}
}
