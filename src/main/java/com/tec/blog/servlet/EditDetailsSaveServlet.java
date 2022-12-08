package com.tec.blog.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import com.mysql.cj.Session;
import com.tec.blog.dao.UserDAO;
import com.tec.blog.entities.Message;
import com.tec.blog.entities.Users;
import com.tec.blog.helpers.ConnectionProvider;
import com.tec.blog.helpers.Helper;

/**
 * Handle the Edit-User-Details JSP Page
 */
@WebServlet("/EditDetailsSaveServlet")
@MultipartConfig
public class EditDetailsSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDetailsSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name_edit = request.getParameter("name");
//		String email_edit = request.getParameter("email");
//		response.getWriter().print(name_edit);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		
//		get all the value form the editDetail page, update the database
		
		Users currentUser = (Users) request.getSession().getAttribute("current_user");
		
		String name_edit = request.getParameter("name");
		String email_edit = request.getParameter("email");
		String about = request.getParameter("about");
		Part partPhoto = request.getPart("profile");
		String photoName = partPhoto.getSubmittedFileName();
		
		System.out.println("new Image Path "+ photoName);
		
		String password = request.getParameter("password");
		String email_adress = currentUser.getEmail();
		
//		all the user-information to the user-object
		Users updateUser = new Users();
		updateUser.setName(name_edit);
		updateUser.setEmail(email_adress);
		updateUser.setAbout(about);
		updateUser.setPassword(password);
		//save the image path to database
		updateUser.setProfile(photoName); 
		
		
//		get the old image path
		String oldImagePath  = currentUser.getProfile();
		System.out.println("old file Name :"+ oldImagePath);

		 
		
		System.out.println("update user inf: "+updateUser.toString());
		
//		send the alter-user-details the database
		Connection conn = ConnectionProvider.getConnection();
		
		if (conn!=null) {
			UserDAO dao = new UserDAO(conn);
			boolean status  = dao.UpdateUserDetails(currentUser, updateUser);
			System.out.println("update the profile pic"+ status);
			
//			save the new Image 
			if(status) {
				String path = request.getRealPath("/")+"images"+File.separator+updateUser.getProfile();
				String oldFilePath = request.getRealPath("/")+"images"+File.separator+oldImagePath;
				System.out.println(path);
				System.out.println(oldFilePath);
				
//				notes: values set in the profile is come from session, while 
//				edit servlet data is updated in the database, it is not reflected inthe
//				data base while showing the content on the page
				
//				delete the old file 
				Helper.deleteFile(oldFilePath);
					if(Helper.saveFile(partPhoto.getInputStream(), path)) {
						System.out.println("profile Update");
						Message message = new Message("profile upload success","success" ,"alert-success");
						HttpSession session  = request.getSession();
						System.out.println("##=====-------------session object info :");
						
						
						Users sessionUser = (Users) session.getAttribute("current_user");
//						System.out.println(user.getName());
//						System.out.println(user.getAbout());
//						System.out.println(user.getEmail());
//						System.out.println(user.getGender());
//						System.out.println(user.getId());
//						System.out.println(user.getPassword());
//						System.out.println(user.getProfile());
						
						//save the image path to database
						updateUser.setProfile(photoName);
						String var = sessionUser.getProfile();
						System.out.println("id 119 : "+ var);
						if(sessionUser.getProfile()=="") {
							System.out.println("id : 120 : profile phot is null, setting default value ");
							sessionUser.setProfile("default.png");
						}else {
							sessionUser.setProfile(photoName);
							System.out.println(photoName);
						}
						sessionUser.setName(name_edit);
						sessionUser.setEmail(email_adress);
						sessionUser.setAbout(about);
						sessionUser.setPassword(password);
						
						System.out.println("**** session + "+ sessionUser.getProfile());
						
						session.setAttribute("msg", message);
//						
					}else {
						System.out.println("File not saved");
					}
					
			}else {
				
			}
		}
		response.sendRedirect("Profile.jsp");
	}

}
