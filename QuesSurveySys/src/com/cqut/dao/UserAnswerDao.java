package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import com.cqut.dto.UserAnswer;
import com.cqut.util.DBUtil;
import com.cqut.util.StringUtil;

public class UserAnswerDao {

	private static UserAnswerDao userAnswerDao;
	
	public static UserAnswerDao getUserAnswerDao(){
		if(userAnswerDao == null){
			userAnswerDao = new UserAnswerDao();
		}
		return userAnswerDao;
	}
	
	public boolean addAUserAnswer(UserAnswer userAnswer){
		String sql = "INSERT into user_answer(id , us_id, question_id, option_id, option_info, create_time, remark) VALUES(?,?,?,?,?,?,?)";
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, userAnswer.getId());
			pstm.setString(2, userAnswer.getUserSurveyId());
			pstm.setString(3, userAnswer.getQuestionId());
			pstm.setString(4, userAnswer.getOptionId());
			pstm.setString(5, userAnswer.getOptionInfo());
			pstm.setDate(6, StringUtil.changeToSqlDate(new Date()));
			pstm.setString(7, userAnswer.getRemark());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
}
