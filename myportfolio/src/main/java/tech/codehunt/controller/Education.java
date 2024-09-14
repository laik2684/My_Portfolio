package tech.codehunt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.EducationDaoImp;

public class Education extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String desc = request.getParameter("desc");
		String year = request.getParameter("year");
		
		result = new EducationDaoImp().insert(title, subtitle, desc, year);
		if(result.equals("saved"))
		{
			session.setAttribute("msg", "uploaded successfully");
			response.sendRedirect("uploadedu.jsp");
		}
		else
		{
			session.setAttribute("msg", "somthing went wrong");
			response.sendRedirect("uploadedu.jsp");
		
		}
		
		
	}

}
