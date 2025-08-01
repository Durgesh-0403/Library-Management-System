package com.jts.lms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
	public static Connection conn;

	private static Connection createConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "enter_your_name_here", "enter_your_password_here");

		System.out.println("Database connection created successfully.");

		return conn;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			return createConn();
		}

		return conn;
	}
	public static void main(String[] args) {
		 try {
		        getConnection();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
}