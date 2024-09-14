package tech.codehunt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.MessageDaoImp;
import tech.codehunt.validation.Validation;


public class Message extends HttpServlet {
	
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String check = request.getParameter("check");
		if(check==null)
		{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		result=	new Validation().validateMessage(name, email, message);
		
		if(result.equals("valid"))
		{
			//DAO
			result= new MessageDaoImp().insert(name,email,message);
			if(result.equals("saved"))
			{
				System.out.println("message sent  successfully");
				session.setAttribute("msg", "message sent  successfully");
				response.sendRedirect("index.jsp");
			}
			else
			{
				System.out.println("somthing went wrong..");
				session.setAttribute("msg", "somthing went wrong..");
				response.sendRedirect("index.jsp");
			}
			
		}
		else
		{
			System.out.println(result);
			session.setAttribute("msg",result );
			response.sendRedirect("index.jsp");
		}
		}
		else if(check.equals("deletemessage"))
		{
			// delete msg logic
			String sn = request.getParameter("sn");
			result = new MessageDaoImp().delete(sn);
			if(result.equals("deleted"))
			{
				session.setAttribute("msg", "message deleted successfully");
				response.sendRedirect("read-message.jsp");
			}
			else
			{
				session.setAttribute("msg", "somthing went wrong..");
				response.sendRedirect("read-message.jsp");
			}
		}
	}

}
