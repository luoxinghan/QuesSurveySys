package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.Questionnaire;
import com.cqut.util.DBUtil;

public class QuestionnaireDao {

	private static QuestionnaireDao questionnaireDao;

	public static QuestionnaireDao getQuestionnaireDao() {
		if (questionnaireDao == null) {
			questionnaireDao = new QuestionnaireDao();
		}
		return questionnaireDao;
	}

	public ArrayList<Questionnaire> getQuestionnaire() {
		String sql = "SELECT q.id, q.qsn_name, q.qsn_describe, u.user_name, "
				+ "q.end_time,q.create_time,q.is_delete,q.remark FROM (questionnaire q, `user` u) "
				+ "WHERE q.author = u.id q.is_delete = 0;";
		ArrayList<Questionnaire> qsnList = new ArrayList<Questionnaire>();
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String qsnName = rs.getString(2);
				String qsnDescribe = rs.getString(3);
				String author = rs.getString(4);
				Date endTime = rs.getDate(5);
				Date createTime = rs.getDate(6);
				Byte isDelete = rs.getByte(7);
				String remark = rs.getString(8);
				Questionnaire user = new Questionnaire(id, qsnName, qsnDescribe, author, endTime, createTime, isDelete,
						remark);
				qsnList.add(user);
			}
			return qsnList;
		} catch (Exception e) {
			e.printStackTrace();
			return qsnList;
		} finally {
			DBUtil.close(connection);
		}
	}
}
