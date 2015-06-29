package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteMysql {
	public static void connection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection connectionToMysql(){
		String host = "jdbc:mysql://localhost:3306/db_fb";
		String username = "root";
		String password = "";
		try {
			Connection connect = DriverManager.getConnection(host, username, password);
			System.out.println("Connected!");
			return connect; 	 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void theQuery(String query){

		Connection conn = null;
		Statement stat = null;
		
		conn = connectionToMysql();
		try {
			stat = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stat.executeUpdate(query);
			System.out.println("Query sucess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		theQuery("insert into db_fb.User values (2, 'jorge','jorgesff','male')");
		
	}*/
	 
}
