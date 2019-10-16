package com.mohit.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestdbServlet
 */
@WebServlet("/TestdbServlet")
public class TestdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//connection variable 
		String user="springstudent";
		String password="springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out=response.getWriter();
			out.println("connectiong to DB");
			Class.forName(driver);
			Connection conn= DriverManager.getConnection(jdbcUrl,user,password);
			out.println("connectionn successful");
			
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
