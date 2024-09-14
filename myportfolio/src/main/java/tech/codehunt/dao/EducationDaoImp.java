package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EducationDaoImp implements EducationDao{

	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private int row ;
	private ResultSet rs;
	
	
	
	@SuppressWarnings("finally")
	@Override
	public String insert(String title, String subtitle, String desc, String year) {

		try
		{
			con = ConnectionFactory.getcon();
			sql="insert into education(title,subtitle,description,year) values(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, subtitle);
			ps.setString(3, desc);
			ps.setInt(4, 	Integer.parseInt(year));
			
			row = ps.executeUpdate() ;
			if(row==1)
			{
				result="saved";
			}
			
		}
		catch(Exception e)
		{
			result="failed";
			e.printStackTrace();
		}
		finally
		{
			return result;
			
		}
		
		
		
		
		
	}

}
