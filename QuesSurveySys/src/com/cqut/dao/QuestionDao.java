package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.Question;
import com.cqut.util.DBUtil;

public class QuestionDao {

	private static QuestionDao questionDao;
	
	public static QuestionDao getQuestionDao(){
		if(questionDao == null){
			questionDao = new QuestionDao();
		}
		return questionDao;
	}
	
	public ArrayList<Question> getQuestionsByQsnId(String QsnId){
		String sql = "SELECT q.id, q.question_name, q.question_type, q.question_no, q.is_required, q.create_time, q.remark "
				+ "FROM question q, qsn_question qq where q.id = qq.question_id AND qq.qsn_id = '" + QsnId + "' GROUP BY q.question_no;";
		ArrayList<Question> questionList = new ArrayList<Question>();
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String questionName = rs.getString(2);
				Byte questionType = rs.getByte(3);
				Integer questionNo = rs.getInt(4);
				Byte isRequired = rs.getByte(5);
				Date createTime = rs.getDate(6);
				String remark = rs.getString(7);
				Question question = new Question(id,questionName,questionType,questionNo,isRequired,createTime,remark);
				question.setOptions(OptionDao.getOptionDao().getOptionsByQuestionId(id));
				questionList.add(question);
			}
			return questionList;
		} catch(Exception e) {
			e.printStackTrace();
			return questionList;
		} finally {
			DBUtil.close(connection);
		}
	}
}
