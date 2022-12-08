package com.tec.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tec.blog.dao.UserDAO;
import com.tec.blog.entities.Users;
import com.tec.blog.helpers.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
//		// TODO Auto-generated method stub
//		doGet(request, response);
		
//		fetch all the data from signUp Page
		fetchAlltheData(request, response);
	}	

	private void fetchAlltheData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String checkbox = request.getParameter("user_checkbox");
		if(checkbox==null) {
				out.print("Please Check the CheckBox, Agree to Terms & Conditions");
		}else {
			String userName = request.getParameter("user_name");
			String emailAdd = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String gender = request.getParameter("user_gender");
			String about = request.getParameter("user_details");
//			create user object to insert into dao object, which save the user details, with the help of 
//			user object
			Users user = new Users();
			user.setName(userName);
			user.setEmail(emailAdd);
			user.setPassword(password);
			user.setAbout(about);
			user.setGender(gender);
			
			
//			insert the data using USER DAO class, which handle all the BD operation 
			UserDAO userDAO = new UserDAO(ConnectionProvider.getConnection());
			if (userDAO.saveUser(user)) {
				out.print("data have been saved into DB");
			} else {
				out.print("data have not been saved");
			}
		}
		
		
//		
//		out.print(userName+" "+emailAdd+" "+password +" "+gender+" "+about +" "+checkbox);
		
	}
}

