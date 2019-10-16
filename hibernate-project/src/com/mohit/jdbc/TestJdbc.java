package com.mohit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String [] args)
	{
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="root";
		String password="root";
		try
		{
		Connection myCon= DriverManager.getConnection(jdbcUrl,user,password);
		System.out.print("Connection Successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
