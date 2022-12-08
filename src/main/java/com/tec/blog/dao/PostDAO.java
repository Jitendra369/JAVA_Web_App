package com.tec.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.tec.blog.entities.Categories;
import com.tec.blog.entities.Post;


public class PostDAO {

	Connection mConnection;

	public PostDAO(Connection mConnection) {
		super();
		this.mConnection = mConnection;
	}
	
	public ArrayList<Categories> getAllCategories() {
		
		ArrayList<Categories> catList = new ArrayList<>();
		String queryGetCate = "SELECT *FROM categories";
		try {
			Statement ptm = mConnection.createStatement();
			ResultSet rs = ptm.executeQuery(queryGetCate);
			while (rs.next()) {
				int catId = rs.getInt("cat_id");
				String catName = rs.getString("cat_name");
				String catDesc = rs.getString("cat_desc");
				Categories categories = new Categories(catId, catName, catDesc);
				catList.add(categories);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catList;
	}
	
	public boolean addNewPost(Post newPost) {
		boolean valueUpdate = false;
		String queryAddPost ="INSERT INTO post_table(post_title, post_content,post_code, post_pic,cat_id, user_id) VALUE(?,?,?,?,?,?);";
		try {
			PreparedStatement prm = mConnection.prepareStatement(queryAddPost);
			prm.setString(1, newPost.getPostTitle());
			prm.setString(2, newPost.getPostContent());
			prm.setString(3, newPost.getPostCode());
			prm.setString(4, newPost.getPostPicture());
			prm.setInt(5, newPost.getCatID());
			prm.setInt(6, newPost.getUserID());
			
			prm.executeUpdate();
			valueUpdate = true;
			
			
		} catch (SQLException e) {
			
			valueUpdate = false;
			e.printStackTrace();
		}
		
		System.out.println("data status :" + valueUpdate);
		return valueUpdate;
	}
	
//	get All the post
	public List<Post> getAllPost(){
		List<Post> listPost = new ArrayList<>();
		String query = "select *from post_table order by post_id desc";
		try {
			PreparedStatement stm = mConnection.prepareStatement(query);
			ResultSet resultSet =  stm.executeQuery();
			
			while(resultSet.next()) {
				int postId = resultSet.getInt("post_id");
				String postTitle = resultSet.getString("post_title");
				String postContent = resultSet.getString("post_content");
				String postCode = resultSet.getString("post_code");
				String postImage = resultSet.getString("post_pic");
				Timestamp postDate = resultSet.getTimestamp("post_date");
				int postCatId = resultSet.getInt("cat_id");
				int postUserID = resultSet.getInt("user_id");
////				
				Post post = new Post(postId, postTitle, postContent, postCode, postImage, postDate,postCatId, postUserID);
				listPost.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return listPost;
	}
	
//	get All the post by Categ.
	public List<Post> getAllPostByCateg(int catId){
		List<Post> listPost = new ArrayList<>();
		String query = "select *from post_table where cat_id =?";
		try {
			PreparedStatement stm = mConnection.prepareStatement(query);
			stm.setInt(1, catId);
			ResultSet resultSet =  stm.executeQuery();
			
			while(resultSet.next()) {
				int postId = resultSet.getInt("post_id");
				String postTitle = resultSet.getString("post_title");
				String postContent = resultSet.getString("post_content");
				String postCode = resultSet.getString("post_code");
				String postImage = resultSet.getString("post_pic");
				Timestamp postDate = resultSet.getTimestamp("post_date");
				
				int postUserID = resultSet.getInt("user_id");
////				
				Post post = new Post(postId, postTitle, postContent, postCode, postImage, postDate,catId, postUserID);
				listPost.add(post);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPost;
	}
	
	public Post getPostById(int postID) {
		
		String query  = "select *from post_table where post_id=?";
		Post post = null;
		try {
			PreparedStatement statement = mConnection.prepareStatement(query);
			statement.setInt(1, postID);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int postId = resultSet.getInt("post_id");
				String postTitle = resultSet.getString("post_title");
				String postContent = resultSet.getString("post_content");
				String postCode = resultSet.getString("post_code");
				String postImage = resultSet.getString("post_pic");
				Timestamp postDate = resultSet.getTimestamp("post_date");
				int catId = resultSet.getInt("cat_id");
				
				int postUserID = resultSet.getInt("user_id");
////				
				post = new Post(postId, postTitle, postContent, postCode, postImage, postDate,catId, postUserID);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}
}
