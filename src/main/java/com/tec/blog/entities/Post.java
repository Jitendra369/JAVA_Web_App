package com.tec.blog.entities;

import java.sql.Timestamp;

//post table in database
public class Post {
	private int postID;
	private String postTitle;
	private String postContent;
	private String postCode;
	private String postPicture;
	private Timestamp postDate;
	private int catID;
	private int userID;
	
	
	public Post() {
		super();
	}

//	constructor with ID
	public Post(int postID, String postTitle, String postContent, String postCode, String postPicture,
			Timestamp postDate, int catID, int userID) {
		super();
		this.postID = postID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postPicture = postPicture;
		this.postDate = postDate;
		this.catID = catID;
		this.userID = userID;
	}
	
//	constructor with no ID
	public Post(int catID,String postTitle, String postContent, String postCode, String postPicture, Timestamp postDate, int userID
			) {
		super();
		
		this.catID = catID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postPicture = postPicture;
		this.postDate = postDate;
		this.userID = userID;
	}
	
	public Post(int catID,String postTitle, String postContent, String postCode) {
		super();
		this.catID = catID;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		
	}


	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostPicture() {
		return postPicture;
	}

	public void setPostPicture(String postPicture) {
		this.postPicture = postPicture;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postCode="
				+ postCode + ", postPicture=" + postPicture + ", postDate=" + postDate + ", catID=" + catID
				+ ", userID=" + userID + "]";
	}
	
	
	
	
}
