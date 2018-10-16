package com.sms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
		try{
	        
	        //loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");

	        //creating connection with the database 
	        Connection  con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydb","root","training123");

	        String queryCheck = "SELECT count(*) from user WHERE username=?";
	        
	        PreparedStatement ps = con.prepareStatement(queryCheck);
	        ps.setString(1, username);
	        ResultSet resultSet = ps.executeQuery();
	        
	        if(resultSet.next()) {
	            int count = resultSet.getInt(1);
	            
	    	    PreparedStatement ps2 = con.prepareStatement
	    	        		("insert into user (username,password) values(?,?)");
	    	         
	    	         ps2.setString(1, username);
	    	         ps2.setString(2, password);
	    	         
	    	         int i=ps2.executeUpdate();
	    	        
	    	         if(i>0)
	    	         {
	    	 			out.println("Registration success.");
	    				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	    				rd.include(request, response);
	    	         }
	            }
            else{
	            	out.println("Registration failed.");
    				RequestDispatcher rd = request.getRequestDispatcher("Register.html");
    				rd.include(request, response);
	            }
		}
	    catch(Exception se)
	    {
	    	se.printStackTrace();
	    }	        
	}
}
