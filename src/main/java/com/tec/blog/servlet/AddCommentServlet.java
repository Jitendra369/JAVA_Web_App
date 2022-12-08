package com.tec.blog.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.mysql.cj.xdevapi.JsonValue;
import com.tec.blog.dao.CommentDAO;
import com.tec.blog.helpers.ConnectionProvider;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
       
    public AddCommentServlet() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("comment data");
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		int postID = Integer.parseInt(request.getParameter("post_id"));
		String comment = request.getParameter("comment");
		
		System.out.println(userID+" "+ postID + " "+ comment);
		
		 CommentDAO commentDAO = new CommentDAO(ConnectionProvider.getConnection());
		 HashMap<String, String> map = commentDAO.insertComment(postID, userID, comment);
		 String jsonText = JSONValue.toJSONString(map);
		 response.getWriter().print(jsonText);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
