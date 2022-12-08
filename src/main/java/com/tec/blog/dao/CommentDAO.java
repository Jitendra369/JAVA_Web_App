package com.tec.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.mysql.cj.xdevapi.JsonString;
import com.tec.blog.entities.Comments;
import com.tec.blog.helpers.ConnectionProvider;

public class CommentDAO {
	Connection connection= null;
	
	public CommentDAO(Connection connection) {
		this.connection = connection;
	}
	
//	insert the comment in DB 
	public HashMap<String, String> insertComment(int postID, int userID,String comment) {
		boolean isCommented = false;
		HashMap<String, String> map = null;
//		JSONObject json = new JSONObject();
		
		
		String query ="insert into usercomments ( postID, userID, comments) value(?,?,?)";
		System.out.println("inside the comment DAO Class");
		try {
			PreparedStatement stm = connection.prepareStatement(query);
			stm.setInt(1, postID);
			stm.setInt(2, userID);
			stm.setString(3, comment);
			
			int status = stm.executeUpdate();
			stm.close();
			
			if (status == 1) {
//				listLastComment = new ArrayList<>();
//				Comments comments = new 
				
				String query_lastUpdate ="select *from usercomments ORDER BY commID DESC LIMIT 1";
				
				PreparedStatement stm_2 = connection.prepareStatement(query_lastUpdate);
				ResultSet rs =  stm_2.executeQuery();
				while(rs.next()) {
//					int commID = rs.getInt("commID");
//					int post_ID = rs.getInt("postID");
//					int user_ID = rs.getInt("userID");
					String comment_ = rs.getString("comments");
					String date = rs.getTimestamp("date").toString();
					map = new HashMap<>();
					map.put("comment", comment_); 
					map.put("date", date);
					map.put("status", "success");
					
//					json.put("user_date", date);
//					json.put("user_comment", comment_);
//					json.put("comment_status", "success");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public ArrayList<Comments> getAllComment(int postID){
		String query ="select *from usercomments where postID  = ?";
		ArrayList<Comments> list = new ArrayList<>();
		
		
		PreparedStatement stm;
		try {
			stm = connection.prepareStatement(query);
			stm.setInt(1, postID);
			ResultSet rs =  stm.executeQuery();
			while(rs.next()) {
				
				int user_id = rs.getInt("userID");
				String comment  = rs.getString("comments");
				Timestamp  time = rs.getTimestamp("date");
				Comments comments = new  Comments(time, comment, user_id);
				list.add(comments);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
