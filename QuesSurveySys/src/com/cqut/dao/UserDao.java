package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.User;
import com.cqut.util.DBUtil;
import com.cqut.util.StringUtil;

public class UserDao {
	
	private static UserDao userDao;
	
	public static UserDao getUserDao(){
		if(userDao == null){
			userDao = new UserDao();
		}
		return userDao;
	}
	
	public ArrayList<User> getAdmin(){
		String sql = "SELECT * from user WHERE user.is_delete = 0 AND user.user_type = 1 AND user.is_delete = 0;";
		ArrayList<User> adminList = new ArrayList<User>();
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				Byte userType = rs.getByte(4);
				Date createTime = rs.getDate(5);
				Byte isDelete = rs.getByte(6);
				String remark = rs.getString(7);
				User user = new User(id,userName,password,userType,createTime,isDelete,remark);
				adminList.add(user);
			}
			return adminList;
		} catch(Exception e) {
			e.printStackTrace();
			return adminList;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public boolean addAUser(User user){
		String sql = "INSERT into user(id , user_name, password, user_type, create_time, is_delete, remark) VALUES(?,?,?,?,?,?,?)";
		if(this.isUserExist(user.getId()) == true){
			return false;
		}
		Connection connection = DBUtil.getConnection();
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getUserName());
			pstm.setString(3, user.getPassword());
			pstm.setByte(4, user.getUserType());
			pstm.setDate(5, StringUtil.changeToSqlDate(new Date()));
			pstm.setByte(6, user.getIsDelete());
			pstm.setString(7, user.getRemark());
			pstm.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public boolean isUserExist(String id) {
		String sql = "SELECT * FROM user WHERE id = '" + id +"';";
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count++;
			}
			if(count != 0){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
	
	public boolean isUserExistUserName(String userName, String qsnId) {
		String sql = "SELECT * FROM user_survey WHERE user_id = (SELECT `user`.id FROM user WHERE user_name = '" + userName + "') AND qsn_id = '" + qsnId + "';";
		Connection connection = DBUtil.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count++;
			}
			if(count != 0){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(connection);
		}
	}
}
