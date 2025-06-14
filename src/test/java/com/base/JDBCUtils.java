package com.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCUtils {
	private static JDBCUtils instance;
	private static Connection connection;
	
	private JDBCUtils() {
		try {
			Properties prop=new Properties();
			connection=DriverManager.getConnection(prop.getProperty("db.url"), 
					prop.getProperty("username"), prop.getProperty("password"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static JDBCUtils getInstance() {
		if(instance == null) {
			instance =new JDBCUtils();
		}
		return instance;
		
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			Statement stmt=connection.createStatement();
			return stmt.executeQuery(sql);
			
		}catch(SQLException e){
			throw new RuntimeException("DB Query Failed...", e);
		}
		
		
	}
	
	public void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
