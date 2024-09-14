
<%

   String data = (String)session.getAttribute("login");
   if(data==null)
   {
	   response.sendRedirect("adminauth.jsp");
	   return;
   }


%>




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

<br>

    
    <a href ="read-message.jsp"> READ ALL MESSAGE.. </a><br><br>
   <a href ="uploadproject.jsp"> Upload Project </a><br><br>
   
   <a href ="deleteproject.jsp"> DELETE Project </a><br><br>
    <a href ="uploadedu.jsp"> Upload Education </a><br><br>
   
    <a href ="change.jsp"> CHANGE ID OR PASSWORD </a><br><br>
    <form action="Logout" method="post">
    
    <button>logout</button>
    
    
    
    
    </form>

</body>
</html>