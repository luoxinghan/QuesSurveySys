package com.cqut.dto;

import java.util.Date;

public class UserSurvey {

	private String id;
	
	private String qsnId;
	
	private String userId;
	
	private Date createTime;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQsnId() {
		return qsnId;
	}

	public void setQsnId(String qsnId) {
		this.qsnId = qsnId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	
	public UserSurvey() {
		super();
	}

	public UserSurvey(String id, String qsnId, String userId, Date createTime, String remark) {
		super();
		this.id = id;
		this.qsnId = qsnId;
		this.userId = userId;
		this.createTime = createTime;
		this.remark = remark;
	}
}
