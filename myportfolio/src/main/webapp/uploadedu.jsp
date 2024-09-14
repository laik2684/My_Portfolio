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
    <form action="Education" method="post">
       <input type="text" name="title" placeholder="title" ><br>
       <input type="text" name="subtitle" placeholder="subtitle" ><br>
       <input type="text" name="desc" placeholder="desc" ><br>
       <input type="text" name="year" placeholder="year" ><br>
       <button>upload</button>
    
    
    
    </form>

</body>
</html>