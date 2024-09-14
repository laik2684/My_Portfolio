 <% 
         
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
        %>