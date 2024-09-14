package tech.codehunt.dao;

import java.sql.Connection;

public class Destroy {
	
	private String sql;
	private Connection con;
	
	
public void dropProjectTable() {
		
		try {
		
			con=ConnectionFactory.getcon();
			sql="drop table project";
			con.createStatement().execute(sql);
			System.out.println("project table deleted");
			
		   }
		   catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("s w w");
			
		}
		
	}
public void dropMessageTable() {
	
	try {
	
		con=ConnectionFactory.getcon();
		sql="drop table message";
		con.createStatement().execute(sql);
		System.out.println("message table deleted");
		
	   }
	   catch(Exception e) 
	{
		e.printStackTrace();
		System.out.println("s w w");
		
	}
	
}
public void dropEducatonTable() {
	
	try {
	
		con=ConnectionFactory.getcon();
		sql="drop table education";
		con.createStatement().execute(sql);
		System.out.println("educaton table deleted");
		
	   }
	   catch(Exception e) 
	{
		e.printStackTrace();
		System.out.println("s w w");
		
	}
	
}
public void dropLoginTable() {
	
	try {
	
		con=ConnectionFactory.getcon();
		sql="drop table login";
		con.createStatement().execute(sql);
		System.out.println("login table deleted");
		
	   }
	   catch(Exception e) 
	{
		e.printStackTrace();
		System.out.println("s w w");
		
	}
	
}



}
