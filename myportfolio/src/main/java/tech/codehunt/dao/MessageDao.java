package tech.codehunt.dao;

import java.util.ArrayList;

import tech.codehunt.pojo.MessagePojo;

// this is a blue print of implement class
public interface MessageDao {
	
	/*
	 * public void read(String ephone); public String delete(int eid); public String
	 * update(int eid,int esal);
	 */
	
	public String insert(String name,String email,String message);
	
	public ArrayList<MessagePojo>read();
	
	public String delete(String sn);
}
