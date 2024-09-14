package tech.codehunt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.LoginDaoImp;

public class Login extends HttpServlet {
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String result = new LoginDaoImp().checkCredentials(username, password);
	    
		if(result.equals("exist"))
		{
			session.setAttribute("login", username);
			response.sendRedirect("admin.jsp");
		}
		else
		{
			session.setAttribute("msg", "INVALID USERNAME OR  PASSWORD");
			response.sendRedirect("adminauth.jsp");
		}
	
	}
	
	

}
