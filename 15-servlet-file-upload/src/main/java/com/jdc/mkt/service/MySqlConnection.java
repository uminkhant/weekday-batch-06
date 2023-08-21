package com.jdc.mkt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static final String  URL = "jdbc:mysql://localhost:3306/testDb";
	private static final String  USER = "root";
	private static final String  PASSWORD = "admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	
}
