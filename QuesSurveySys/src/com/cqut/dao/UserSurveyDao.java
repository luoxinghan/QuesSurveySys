package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.UserSurvey;
import com.cqut.util.DBUtil;
import com.cqut.util.StringUtil;

public class UserSurveyDao {

	private static UserSurveyDao userSurveyDao;
	
	public static UserSurveyDao getUserSurveyDao(){
		if(userSurveyDao == null){
			userSurveyDao = new UserSurveyDao();
		}
		return userSurveyDao;
	}
	
	public boolean addAUserSurvey(UserSurvey userSurvey){
		String sql = "INSERT into user_survey(id , qsn_id, user_id, create_time, remark) VALUES(?,?,?,?,?)";
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userSurvey.getId());
			pstm.setString(2, userSurvey.getQsnId());
			pstm.setString(3, userSurvey.getUserId());
			pstm.setDate(4, StringUtil.changeToSqlDate(new Date()));
			pstm.setString(5, userSurvey.getRemark());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public ArrayList<UserSurvey> getUserSurveyList() {
		String sql = "SELECT us.id, qsn.qsn_name, u.user_name, us.create_time, us.remark FROM user_survey us, `user` u, questionnaire qsn WHERE u.id = us.user_id AND qsn.id = us.qsn_id;";
		ArrayList<UserSurvey> usList = new ArrayList<UserSurvey>();
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String qsnName = rs.getString(2);
				String userName = rs.getString(3);
				Date createTime = rs.getDate(4);
				String remark = rs.getString(5);
				UserSurvey userSurvey = new UserSurvey(id, qsnName, userName, createTime, remark);
				usList.add(userSurvey);
			}
			return usList;
		} catch (Exception e) {
			e.printStackTrace();
			return usList;
		} finally {
			DBUtil.close(connection);
		}
	}
}
