package com.tec.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tec.blog.entities.Users;

public class UserDAO {
	private Connection mConnection;

	public UserDAO(Connection mConnection) {
//		super();
		this.mConnection = mConnection;
	}
	
	boolean dataInserted = false;
	
//	add all the details of user, sign-up page
	public boolean saveUser(Users user) {
		try {
//			we will not add id--> which is auto increment / timestamp --> which get the current time span form the system 
			String query = "insert into users(name,email,password,gender,about) values(?,?,?,?,?)";
			PreparedStatement preStm = this.mConnection.prepareStatement(query);
			preStm.setString(1,user.getName());
			preStm.setString(2, user.getEmail());
			preStm.setString(3, user.getPassword());
			preStm.setString(4, user.getGender());
			preStm.setString(5, user.getAbout());
			
			preStm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		dataInserted = true;
		
		return dataInserted;
	}
	
//	check the user Email and password, for login to web-site 
	public Users getUserByEmailAndPass(String email_add, String password) throws SQLException {
		Users user = null;
		String query_search ="SELECT * FROM users WHERE email = ? AND PASSWORD = ?";
		PreparedStatement prm = mConnection.prepareStatement(query_search);
		prm.setString(1, email_add);
		prm.setString(2, password);
		ResultSet rs =  prm.executeQuery();
		if (rs.next()) {
			user = new Users();
//			String name = rs.getString("name");
//			user.setName(name);
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getString("gender"));
			user.setAbout(rs.getString("about"));
			user.setProfile(rs.getString("profile"));
			user.setDateTime(rs.getTimestamp("r_date"));
			
		}else {
			
		}
		
		System.out.println("data is chekker");
		
		return user;
	}
	
//	update user details, if user change its details 
	public boolean UpdateUserDetails(Users currentUser, Users updateUser) {
		boolean isUserDetailsUpdate = false;
		System.out.println("##  update user Name : "+updateUser.getName());
		System.out.println("##  update user about : "+updateUser.getAbout());
		System.out.println("##  update user password : "+updateUser.getPassword());
		System.out.println("##  update user profile  : "+updateUser.getProfile());
		System.out.println("##  update user Emial : "+updateUser.getEmail());
		
		
		
		String query = "UPDATE users SET name =?, about=?, password=?, profile=? WHERE email=? ";
		try {
			PreparedStatement ptm = mConnection.prepareStatement(query);
			ptm.setString(1, updateUser.getName());
			ptm.setString(2, updateUser.getAbout());
			ptm.setString(3, updateUser.getPassword());
			if(updateUser.getProfile()=="") {
				updateUser.setProfile("default.png");
			}
			ptm.setString(4, updateUser.getProfile()); 
			ptm.setString(5, currentUser.getEmail());
			ptm.executeUpdate();
			
			System.out.println("data has been updated");
			isUserDetailsUpdate = true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUserDetailsUpdate;
		
	}
	
	
	public String getUserNameById(int userID) {
		String query = "select name from users where id = ?";
		String userName ="";
		try {
			PreparedStatement stm = mConnection.prepareStatement(query);
			stm.setInt(1, userID);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				userName = rs.getString("name");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return userName;

	}
}
