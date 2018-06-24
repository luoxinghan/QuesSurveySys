package com.cqut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.cqut.dto.User;
import com.cqut.util.DBUtil;

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
}
