package com.sms.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentHibernateDAO;
import com.sms.studentpojo.Student;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/ListStudentServlet")
public class ListStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>All Students</title></head>");
	    out.println("<body>");
	    out.println("<left><h1>Student List</h1>");
	    	
	    out.print("<link rel ='stylesheet' type=text/css  href='tablestyle.css'>");
	    out.println("<table>");
        out.println("<tr>"
            		+ "<th> StudentID </th>"
            			+ "<th> Name </th>"
            				+ "<th> Contact </th>"
            					+ "<th> Gender </th>"
            						+ "</tr>");
        
	    List<Student> studentList = StudentHibernateDAO.ListStudent();
	        
        for (Student s : studentList){	            
	        out.println("<tr>"
	            		+ "<td>" +s.getId()+ "</td>"
	            				+ "<td>" +s.getName()+ "</td>"
	            						+ "<td>" +s.getContact()+ "</td>"
	            								+ "<td>" +s.getGender()+ "</td>"
	            										+ "</tr>");
	        }
	        
	        out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
