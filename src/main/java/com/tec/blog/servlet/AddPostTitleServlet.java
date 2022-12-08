package com.tec.blog.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.JspPage;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.cj.Session;
import com.tec.blog.dao.PostDAO;
import com.tec.blog.entities.Post;
import com.tec.blog.entities.Users;
import com.tec.blog.helpers.ConnectionProvider;
import com.tec.blog.helpers.Helper;

/**
 * handle all the post content data, once the user add the new post 
 */
@WebServlet("/AddPostTitleServlet")
@MultipartConfig
public class AddPostTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddPostTitleServlet() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
////		for multiple file upload 
//		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
//		try {
//			List<FileItem> items = upload.parseRequest(request);
//			System.out.println(items.size());
//			for(FileItem item : items) {
//				String name = item.getName();
//				System.out.println("---------name-----------");
//				System.out.println(name);
//				if(name=="") {
//					
//					System.out.println("Empty file refrence ");
//				}
//				name = name.substring(name.lastIndexOf("\\")+1);
//				System.out.println(name);
//			}
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		}
//		
		
		
		
		
		int postCat = Integer.parseInt(request.getParameter("post_cat")); 
		String postTitle = request.getParameter("post_title");
		String postCntent = request.getParameter("post_content");
		String postCode = request.getParameter("post_code");
		Part partFile = request.getPart("file");
		System.out.println("Cat title of the form ");
		System.out.println(postCat);
		
		System.out.println(partFile.getName());
		
		
		
//		getting user-id from session to store in the database 
		Users user= (Users) request.getSession().getAttribute("current_user");
		int userID = user.getId();
		
		PrintWriter writer = response.getWriter();
//		writer.print("you have enter "+ partFile.getSubmittedFileName());
//		writer.print("you have enter "+ postTitle);
	
		Post userPost = new Post(postCat, postTitle, postCntent,postCode, partFile.getSubmittedFileName(),null,userID);
		System.out.println("------User Object Data");
		System.out.println(userPost);
		
		PostDAO dao = new PostDAO(ConnectionProvider.getConnection());
		System.out.println("----------Dao Class");
		if (dao.addNewPost(userPost)) {
//			writer.print("-----value has been inserted");
//			System.out.println("data hasbeen inserted ");
			String path = request.getRealPath("/")+"post_pic"+File.separator+partFile.getSubmittedFileName();
			System.out.println("file save in "+ path);
			Helper.saveFile(partFile.getInputStream(), path);
			writer.print("done");
//			response.sendRedirect("Profile.jsp")
;		}else {
			writer.print("failed");
			System.out.println("value have not been inserted");
		}
		
	
		
		
		
		
	}

}
