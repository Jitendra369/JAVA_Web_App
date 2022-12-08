package com.tec.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tec.blog.entities.Users;

/**
 * Servlet implementation class CheckUserAuthe
 */
@WebServlet("/CheckUserAuthe")
public class CheckUserAuthe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckUserAuthe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<p>chcekUserauthe</p>");
		
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("current_user");
		if (user == null) {
			response.sendRedirect("Index.jsp");
		}else {
			response.sendRedirect("Profile.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
