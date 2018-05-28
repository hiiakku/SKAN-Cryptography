package com.sandeep.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider 
{
	
	
	public static Connection cn;
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql:" +
					"//localhost:3306/crypt","root","akki");		
		}
		catch(
Exception e) 
		{
			e.printStackTrace();
		}
		return cn;
		
		
	}

}
