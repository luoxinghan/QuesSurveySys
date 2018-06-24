package com.cqut.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lxh
 * @date 2018.6.24
 *
 */
public class DBUtil {
	
	public static Connection getConnection() {
		
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ques_survey";
		
		String userName = "root";
		String userPassword = "741067";
		
		Connection connection = null;
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, userPassword);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static boolean execute(String sql) {
		Connection connection = getConnection();
		
		Statement statement;
		try {
			statement = connection.createStatement();
			return statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void close(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
