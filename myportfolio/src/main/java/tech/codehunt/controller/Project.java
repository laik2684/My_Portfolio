package tech.codehunt.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tech.codehunt.dao.ProjectDaoImp;
@MultipartConfig
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		
		String check = request.getParameter("check");
		if(check==null)
		{	
		
		Part part = request.getPart("myfile");
		String filename = part.getSubmittedFileName();
      // System.out.println(filename );
		// make file unique
		String uniqueFileName = fomat(filename);
		//System.out.println(unique);
		
		
		
		
	result	=new ProjectDaoImp().uploadProject(uniqueFileName,request);
	//System.out.println(result);
	if(result.equals("uploaded"))
	 {
		session.setAttribute("msg", "project uploaded successfully");
		response.sendRedirect("uploadproject.jsp");
		
	 }
	 else
	 {
		 session.setAttribute("msg", "somthing went wrong");
			response.sendRedirect("uploadproject.jsp");
			
	 }
	   }
		else if(check.equals("deleteproject"))
		{
			//delete project logic
			String sn = request.getParameter("sn");
			String filename = request.getParameter("filename");
			
			result =new ProjectDaoImp().deleteProject(filename, sn, request);
		
			if(result.equals("deleted"))
			 {
				session.setAttribute("msg", "project deleted successfully");
				response.sendRedirect("deleteproject.jsp");
				
			 }
			 else
			 {
				 session.setAttribute("msg", "somthing went wrong");
				 response.sendRedirect("deleteproject.jsp");
					
			 }
		
		}
		
}
	
	private String fomat(String filename) {
		String format = LocalDateTime.now().toString();
		String[] split = format.split(":");
		// removing colon coz windows not supporting
		String unique=split[0]+split[1]+split[2]+filename;
		return unique;
	}

}
