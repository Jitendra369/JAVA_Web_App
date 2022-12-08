package com.tec.blog.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tec.blog.dao.UserDAO;
import com.tec.blog.entities.Message;
import com.tec.blog.entities.Users;
import com.tec.blog.helpers.ConnectionProvider;

/**
 * User-login Page, handle all the user-login-page, add the user object/name to the session object 
 * so-that it can be help in near feature.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		fetch username and password form login Page
		
		String userEmail = request.getParameter("user_email");
		String password = request.getParameter("password");
		
		Connection conn = ConnectionProvider.getConnection();
		UserDAO userDao = new UserDAO(conn);
		try {
			Users user =  userDao.getUserByEmailAndPass(userEmail, password);
			
			if (user==null) {
//				System.out.println("invalid user-name and password");
//				response.getWriter().print("Invalid Details, check user-name and password");
				Message message = new Message("Invalid Login","error","alert-danger");
				HttpSession session= request.getSession();
//				adding error message in the message object, to inform something went wrong.
				session.setAttribute("message", message);

//				redirect to login Page
				response.sendRedirect("SOMA_Servlet");
				
				
				
			}else {
				int userID = user.getId();
				System.out.println("printing userid : "+userID);
				System.out.println(user.getName()+" Welcome to TechBlog");
				
				HttpSession session = request.getSession();
				
				/*
				 * if user is valid, then add the user-information in the user-object, which add
				 * the into session to be used later in pages
				 */
				
				session.setAttribute("current_user", user);
				response.sendRedirect("Profile.jsp");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}

}
