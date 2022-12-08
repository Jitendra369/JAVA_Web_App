package com.tec.blog.entities;

import java.sql.Timestamp;

public class Comments {
	private Timestamp time;
	private String content;
	private int userID;
	
	
	
	public Comments() {
		super();
	}



	public Comments(Timestamp time, String content, int userID) {
		super();
		this.time = time;
		this.content = content;
		this.userID = userID;
	}



	public Timestamp getTime() {
		return time;
	}



	public void setTime(Timestamp time) {
		this.time = time;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}

	


	
	
	
	

}
