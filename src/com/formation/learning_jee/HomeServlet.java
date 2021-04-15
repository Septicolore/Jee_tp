package com.formation.learning_jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		/* response.getWriter()
		.append("Mon contextPath est : ")
		.append(request.getContextPath())
		.append(" - username : ")
		.append(username)
		.append(" - age : ")
		.append(age); */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
