
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
     <form action ="Project" method="post" enctype="multipart/form-data">
     
          <input type="file" name="myfile"><br>
          <button> upload</button>
     
     
     
     
     
     
     </form>

</body>
</html>