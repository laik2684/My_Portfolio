
<%@page import="java.util.ArrayList" %>
<%@page import= "tech.codehunt.dao.MessageDaoImp" %>
<%@page import="tech.codehunt.pojo.MessagePojo" %>

<%

   String data = (String)session.getAttribute("login");
   if(data==null)
   {
	   response.sendRedirect("adminauth.jsp");
	   return;
   }


%>





<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href ="admin.jsp">HOME</a>

<!-- include jsp directive page -->

<%@include file ="messageprint.jsp" %>

<%

   MessageDaoImp md = new MessageDaoImp();
  ArrayList<MessagePojo>al = md.read();
  int i=1;
  for(MessagePojo mp :al)
  {
 %>	  
 
      <h1> SN:<%= i %></h1><br>
       NAME: <%=mp.getName() %><br>
       EMAIL: <%=mp.getEmail() %><br>
       MESSAGE: <%=mp.getMessage() %>
     
       
       <form action="Message" method ="post">
            <input type ="hidden" value ="deletemessage" name ="check">
            <input type ="hidden" value ="<%=mp.getSn() %>" name ="sn">
       
          <button>delete</button>
       
       </form><br>
	  
	 
  <% 
     i++;
     }
  %>


  




</body>
</html>