package com.begin;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tech.codehunt.dao.CreateTable;
import tech.codehunt.dao.Destroy;


public class Start implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
         // drop database logic
    	
    	Destroy d = new Destroy();
    	d.dropEducatonTable();
    	d.dropLoginTable();
    	d.dropMessageTable();
    	d.dropProjectTable();
    }

	
    
    
    public void contextInitialized(ServletContextEvent sce)  { 
         // table creation logic
    	
     CreateTable c = new CreateTable();
    c.createProjectTable();
    	c.createEducationTable();
    	c.createMessageTable();
    	c.createLoginTable();
    }
	
}
