package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tech.codehunt.pojo.MessagePojo;

public class MessageDaoImp implements MessageDao{
   
	private String result;
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private int row;
	private ResultSet rs;
	@SuppressWarnings("finally")
	@Override
	public String insert(String name, String email, String message) {
		// TODO Auto-generated method stub
		try {
			
			Connection con = ConnectionFactory.getcon();
			sql="insert into message(name , email , message) values (?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);
			
			row=ps.executeUpdate();
			
			if(row==1)
			{
				result="saved";
			}
		
			
			
		}catch(Exception e)
		{
			
		e.printStackTrace();
		result="failed";
		}
		finally {
			
		return result;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public ArrayList<MessagePojo> read() {
		// TODO Auto-generated method stub
		
		// jo data mp me aye ga oh delete na ho isliye hum arraylist me add kr denge
		
		ArrayList<MessagePojo> arrayList = new ArrayList();
try {
			Connection con = ConnectionFactory.getcon();
			sql="select * from message";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();	
			while(rs.next())
			{
				int getsn = rs.getInt("sn");
				String getname = rs.getString("name");
				String getemail = rs.getString("email");
				String getmessage = rs.getString("message");
				// message pojo me bind kre ge
				
				MessagePojo mp = new MessagePojo(getsn,getname,getemail,getmessage);
				arrayList.add(mp);
			}
			
		}catch(Exception e)
		{
			
		e.printStackTrace();
		
		}
		finally {
			
		return arrayList;
		}
	}
	@SuppressWarnings("finally")
	@Override
	public String delete(String sn) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionFactory.getcon();
			sql="delete from message where sn=?";
			 ps = con.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(sn));
			 row=ps.executeUpdate();
			 if(row==1)
			 {
				 result="deleted";
			 }
			
			
		}catch(Exception e)
		{
			result="failed";
		  e.printStackTrace();
		
		}
		finally {
			
		    return result;
		}
		
	}
	
	
}
