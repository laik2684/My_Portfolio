<%@page import="tech.codehunt.dao.ProjectDaoImp"%>
<%@page import="tech.codehunt.pojo.ProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file ="messageprint.jsp" %>


                       <%
                         ArrayList<ProjectPojo> alpp= new ProjectDaoImp().readProject();
                        for(ProjectPojo p:alpp)
                        {
                        		
                        %>
            
                            <img style="width:200px;"  src="images/fileuploaded/<%=p.getFilename()%>" class="img-fluid" alt="project image">
                            <form action="Project" method="post">
                               <input type="hidden" name="check" value="deleteproject">
                               <input type="hidden" name="sn" value="<%=p.getSn() %>">
                               <input type="hidden" name="filename" value="<%=p.getFilename() %>"> 
                               <button> delete</button>
                            
                            </form>
                          <% 
                           }
                          
                          %>
                         

</body>
</html>