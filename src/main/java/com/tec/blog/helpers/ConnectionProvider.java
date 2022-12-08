package com.tec.blog.helpers;

import java.sql.*;

public class ConnectionProvider {

	private static Connection con;
	public static Connection getConnection() {

		if (con==null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","root");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return con;
	}
}
