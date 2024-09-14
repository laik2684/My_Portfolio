package tech.codehunt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.LoginDaoImp;

public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		result=	new LoginDaoImp().updateLoginInfo(username,password);
		if(result.equals("updated"))
		{
			session.removeAttribute("login");
			session.setAttribute("msg", "credential updated successfully");
			response.sendRedirect("adminauth.jsp");
		}
		else
		{
			session.setAttribute("msg", "somthing went wrong");
			response.sendRedirect("admin.jsp");

		}
	}

}
