package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.Option;
import com.cqut.dto.Questionnaire;
import com.cqut.util.DBUtil;

public class OptionDao {

	private static OptionDao optionDao;
	
	public static OptionDao getOptionDao(){
		if(optionDao == null){
			optionDao = new OptionDao();
		}
		return optionDao;
	}
	
	public ArrayList<Option> getOptionsByQuestionId(String quesId){
		String sql = "SELECT * FROM `option` WHERE question_id = '" + quesId + "' GROUP BY option_no;";
		ArrayList<Option> optionList = new ArrayList<Option>();
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String questionId = rs.getString(2);
				String optionName = rs.getString(3);
				Integer optionNo = rs.getInt(4);
				Date createTime = rs.getDate(5);
				String remark = rs.getString(6);
				Option option = new Option(id,questionId,optionName,optionNo,createTime,remark);
				optionList.add(option);
			}
			return optionList;
		} catch(Exception e) {
			e.printStackTrace();
			return optionList;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public Option getOptionById(String optionId) {
		String sql = "SELECT * FROM `option` WHERE id='" + optionId +"';";
		Connection connection = DBUtil.getConnection();
		ArrayList<Option> optionList = new ArrayList<Option>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String questionId = rs.getString(2);
				String optionName = rs.getString(3);
				Integer optionNo = rs.getInt(4);
				Date createTime = rs.getDate(5);
				String remark = rs.getString(6);
				Option option = new Option(id, questionId, optionName, optionNo, createTime, remark);
				optionList.add(option);
			}
			return optionList.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return optionList.get(0);
		} finally {
			DBUtil.close(connection);
		}
	}
}
