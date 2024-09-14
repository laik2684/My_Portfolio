
<%@page import="tech.codehunt.pojo.ReadLoginPojo" %>
<%@page import="tech.codehunt.dao.LoginDaoImp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <% 
    
 ReadLoginPojo rlp   =  new LoginDaoImp().readLogin();
 
 %> 

  <form action="Change" method="post" >
    <input type ="text" name ="username" value="<%=rlp.getUsername() %>"><br>
     <input type ="text" name ="password" value="<%=rlp.getPassword() %>"><br>
     <button>update</button>
  
  
  </form>

</body>
</html>