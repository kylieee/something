package com.sms.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.bean.StudentBean;
import com.sms.studentpojo.StudentPojo;

/**
 * Servlet implementation class RemoveStudServlet
 */
@WebServlet("/RemoveStudServlet")
public class RemoveStudServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
	    
        StudentPojo studentpj = new StudentPojo();
        int id = Integer.parseInt(request.getParameter("studentID"));
        String name = request.getParameter("name");
        
        studentpj.setId(id);
	    	        
	    if(StudentBean.deleteStudent(studentpj) == true)
	    {
	   		RequestDispatcher rd = request.getRequestDispatcher("RemoveStudResultServlet");
	   		request.setAttribute("studentID", id);
	   		rd.forward(request, response);
	   	}	  
	   	else{
          	//System.out.println("Failed to remove student.");
			RequestDispatcher rd2 = request.getRequestDispatcher("RemoveStudent.jsp");				
			rd2.forward(request, response);
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
