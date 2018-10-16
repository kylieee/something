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
 * Servlet implementation class UpdateStudServlet
 */
@WebServlet("/UpdateStudServlet")
public class UpdateStudServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        StudentPojo studentpj = new StudentPojo();
        int id = Integer.parseInt(request.getParameter("studentID"));
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
         
        studentpj.setName(name);
        studentpj.setContact(contact);
        studentpj.setGender(gender);
        studentpj.setId(id);
        
		if(StudentBean.updateStudent(studentpj) == true)
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("UpdateStudResultServlet");
	   		request.setAttribute("studentID", id);
	   		request.setAttribute("name", name);
	   		request.setAttribute("contact", contact);
	   		request.setAttribute("gender", gender);
    		rd.forward(request, response);	    	
    	}	  
	    else{
            out.println("Failed to update student details.");
			RequestDispatcher rd2 = request.getRequestDispatcher("UpdateStudent.jsp");
			rd2.include(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
