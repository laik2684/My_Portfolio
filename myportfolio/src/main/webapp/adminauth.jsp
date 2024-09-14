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

      <%--  <% 
         
         String message= (String)session.getAttribute("msg");
         
         //out.print(message); you can use but there is an alternative
         if(message !=null)
         {
         
         %>
        
        <h2 style="text-align: center;"><%= message %></h2>
       
        <%
         }
         // when referesh screen msg dsable
         session.removeAttribute("msg");
        %> --%>




     <form action ="Login" method="post">
          <input type="text" name="username" placeholder="Enter Username">
          <input type="text" name="password" placeholder="Enter password">
     
           <button>login</button>
     
     
     </form>

</body>
</html>