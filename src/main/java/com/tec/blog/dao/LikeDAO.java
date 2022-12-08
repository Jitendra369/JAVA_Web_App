package com.tec.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// this class handle all the like and unlike on the particular post 
public class LikeDAO {
	
	Connection connection =null;
	
	public LikeDAO(Connection connection) {
		this.connection = connection;
	}
	
//	like id is auto increment 
	public void  insertLike(int userID, int postID) {
		String query = "insert into likes (user_id, post_id) values(?,?)";
		boolean isLikeAdded = false;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userID);
			statement.setInt(2, postID);
			int result = statement.executeUpdate();
			if (result> 0) {
				System.out.println("data from like has been added");
			}else {
				System.out.println("data from like is not added");
			}
//			isLikeAdded = true;
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	return isLikeAdded;

}
	
//	Number of likes on the post, count postID from the table
	public int getLikeOnPost(int postID) {
		int count =0;
		String query ="select count(*) from likes where post_id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, postID);
			ResultSet set  = statement.executeQuery();
			if(set.next()) {
				count = set.getInt("count(*)");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
//	check weather the post is liked by the user, if it isliked by the user then, he/she will not like 
//	twice, before liking the post, verify weather the post is like by the user or not
	public boolean isLikedByUser(int postID, int userID) {
		boolean isLiked = false;
		String query = "select *from likes where post_id = ? and user_id=?";
			try {
				PreparedStatement stm = connection.prepareStatement(query);
				stm.setInt(1, postID);
				stm.setInt(2, userID);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
//					it will return single row 
					isLiked = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return isLiked;
	}
	
	
//	dislike the user, deleted the like from the likes table of corr. userID and postID,  
	public boolean deleteLike(int postID, int userID) {
		boolean disliked = false;
		String query ="delete from likes where post_id = ? and user_id=?";
		try {
			PreparedStatement stm = connection.prepareStatement(query);
			stm.setInt(1, postID);
			stm.setInt(2, userID);
			stm.executeUpdate();
			disliked = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return disliked;
	}
}
