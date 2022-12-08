package com.tec.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tec.blog.dao.LikeDAO;
import com.tec.blog.helpers.ConnectionProvider;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  userID = Integer.parseInt(request.getParameter("userID"));
		int postID = Integer.parseInt(request.getParameter("postID"));
		String operation  = request.getParameter("operation");
		
		if (operation.equals("like")) {
			LikeDAO dao = new LikeDAO(ConnectionProvider.getConnection());
			dao.insertLike(userID, postID);
			System.out.println("data inserted to like table");
			response.getWriter().println("true");
		}else {
			response.getWriter().println("false");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
