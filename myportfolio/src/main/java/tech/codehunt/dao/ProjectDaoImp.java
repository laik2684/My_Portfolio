package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import tech.codehunt.fileio.ProjectIO;
import tech.codehunt.pojo.ProjectPojo;

public class ProjectDaoImp implements ProjectDao{

	
	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;
	@Override
	public String uploadProject(String uniqueFileName, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			
			
			con =ConnectionFactory.getcon();
			con.setAutoCommit(false);
			sql="insert into project(filename) Values(?)" ;
			ps=con.prepareStatement(sql);
			ps.setString(1, uniqueFileName);
			row=ps.executeUpdate();
			if(row== 1)
			{
				//FILE IO CODE
				result=new ProjectIO().projectWrite(request,uniqueFileName);
				//System.out.println(result ); 
			    if(result.equals("success"))
			    {
			    	con.commit();
			    	result="uploaded";
			    }
			    else
			    {
			    	con.rollback();
			    	result="failed";
			    }
			
			
			}
			
			
		}
		catch(Exception e){
			result="failed";
			e.printStackTrace();
			
		}
		finally {
				
		}
		
		return result;
		
	}
	@SuppressWarnings("finally")
	@Override
	public ArrayList<ProjectPojo> readProject() {
		ArrayList<ProjectPojo> al = new ArrayList();
      try {
			
			
			con =ConnectionFactory.getcon();
			sql= "select * from project";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				ProjectPojo p = new ProjectPojo(rs.getInt("sn"), rs.getString("filename"));
				al.add(p);
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		 finally {
		
		return al;
	}// is daoimpl ko index.jsp se call kre ge

}
	@SuppressWarnings("finally")
	@Override
	public String deleteProject(String filename, String sn, HttpServletRequest request) {
		 try {
				
				
				con =ConnectionFactory.getcon();
				con.setAutoCommit(false);
				sql= "delete from project where sn=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(sn));
				row=ps.executeUpdate();
				
				if(row==1)
				{
					// FILE IO SE DELETE KRE GE
					 result = new ProjectIO().projectDelete(request, filename);
				     if(result.equals("success"))
				     {
				    	 con.commit();
				    	 result="deleted";
				     }
				     else
				     {
				    	 con.rollback();
				    	 result="notdeleted";
				     }
				
				}
				
				
			}
			catch(Exception e){
				
				result="failed";
				e.printStackTrace();
				
			}
			 finally {
			
			return result;
		}
	}
}

