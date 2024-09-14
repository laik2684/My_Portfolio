package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tech.codehunt.pojo.ReadLoginPojo;

public class LoginDaoImp implements LoginDao {
    
	
	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private int row ;
	private ResultSet rs;
	
	@SuppressWarnings("finally")
	@Override
	public String checkCredentials(String username, String password) {
		// TODO Auto-generated method stub
		
		try {
			 con = ConnectionFactory.getcon();
			sql="select * from login where username= ? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			//username nad pwd agar match kiya
			
		    if(rs.next())
		    {
		    	result="exist";
		    }
		    else
		    {
		    	result="Not exist";
		    }
		
			
		}catch(Exception e) {
			
			result="Not exist";
			e.printStackTrace();
			
		}
		finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ReadLoginPojo readLogin() {
		
		ReadLoginPojo rlp = null;
		
		//multiple user ke case me arraylist needed
		//ArrayList<ReadLoginPojo> al=new ArrayList<>();
		try {
		  con = ConnectionFactory.getcon();
		  sql="select * from login where sn=1";
		  ps=con.prepareStatement(sql);
			
		  rs=ps.executeQuery();
		  rs.next();
		  rlp = new ReadLoginPojo(rs.getString("username"), rs.getString("password"));
		  
		
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			return rlp;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String updateLoginInfo(String username, String password) {
		try {
			  con = ConnectionFactory.getcon();
			  sql="update login set username=?, password=? where sn=1";
			  
			  ps=con.prepareStatement(sql);
			  ps.setString(1,username);
			  ps.setString(2,password);
			  row=ps.executeUpdate();
			  
			  	  
			if(row==1)
			{
				result="updated";
			}
				
			}catch(Exception e) {
				
				result="failed";
				e.printStackTrace();
				
			}
			finally {
				return result;
			}
	}
}
