package tech.codehunt.dao;


import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	
	@SuppressWarnings("finally")
	public static Connection getcon()
	{
		Connection con = null;
		try {
			
		    // Class.forName("com.mysql.cj.jdbc.Driver");
		     
		     String url="jdbc:mysql://localhost:3306/myportfolio";
		     String username="root";
		     String password="Laik123@";
		     
		     MysqlDataSource ds= new MysqlDataSource();
		     ds.setUrl(url);
		     ds.setUser(username);
		     ds.setPassword(password);
		     
		     
		     con = ds.getConnection();
		     
		 }
		   catch(Exception e)
		   {
			   
			e.printStackTrace();
		   
		   }
		finally
		{
			return con;    
		}		
	}

}
