package tech.codehunt.dao;

import java.sql.Connection;

public class CreateTable {
	
	
	private String sql;
	private Connection con;
	
	
	public void createProjectTable() {
		
		try {
		
			con=ConnectionFactory.getcon();
			sql="create table project(sn int primary key auto_increment,"
			+ "filename varchar(100))";
			con.createStatement().execute(sql);
			System.out.println("project table created");
			
		   }
		   catch(Exception e) 
		{
			e.printStackTrace();
			
		}
		
	}
    public void createEducationTable() {
		
		try {
			
			con=ConnectionFactory.getcon();
			sql="create table education (sn int primary key auto_increment,"
			+"year int,"
			+"title varchar(100),"
			+"subtitle varchar(150),"
			+"description varchar(1000))";
			con.createStatement().execute(sql);
			System.out.println("educaton table created");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
    public void createMessageTable() {
		
		try {
			
			con=ConnectionFactory.getcon();
			sql="create table message (sn int primary key auto_increment,"
			+"name varchar(40),"
			+"email varchar(100),"
			
			+"message varchar(1000))";
			con.createStatement().execute(sql);
			System.out.println("message table created");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
    public void createLoginTable() {
		
		try {
			
			con=ConnectionFactory.getcon();
			sql="create table login (sn int primary key auto_increment,"
			
			+"username varchar(45),"
			
			+"password varchar(45))";
			con.createStatement().execute(sql);
			System.out.println("login table created");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			defaultCredentials();
			System.out.println("logn data nserted..");
		}
		
  }
   private void defaultCredentials() {
	 try 
	 {
		 
		 con=ConnectionFactory.getcon();
	    sql="insert into login(sn,username, password) values(1,'admin', 'admin')";
	    con.prepareStatement(sql).executeUpdate();
	    //System.out.println("login table data inserted ");
	 }
	 catch(Exception e) 
	 {
			e.printStackTrace();

	 }
 }

}
