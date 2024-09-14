package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.Statement;

public class Create {
	
	
	//Connection con;
	private String result;
	
	
	@SuppressWarnings("finally")
	public String databaseCreation()
	{
		
		try {
			Connection con = ConnectionFactory.getcon();
		    String sql ="Create database industrial";
		    
		    Statement st = con.createStatement();
			
			st.execute(sql);
			result="created";
		
		
		 }catch(Exception e) {
			 result="failed";
			 e.printStackTrace();
			 
		 }
		finally {
			return result;
		}
	}
	@SuppressWarnings("finally")
	public String tableCreation()
	{
		try {
			Connection con = ConnectionFactory.getcon();
		    String sql ="Create table industrial.employee(eid int primary key auto_increment,"
		    		+ "ename varchar(40),"
		    		+ "ephone varchar(13),"
		    		+ "esal int)";
		    
		    Statement st = con.createStatement();
			
			st.execute(sql);
			result="created";
		
		
		 }catch(Exception e) {
			 result="failed";
			 e.printStackTrace();
			 
		 }
		finally {
			return result;
		}	
		
		
		
	}

}
