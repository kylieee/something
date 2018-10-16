package com.sms.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.bean.StudentBean;
import com.sms.dao.StudentHibernateDAO;
import com.sms.studentpojo.StudentPojo;

/**
 * Servlet implementation class AddStudServlet
 */
@WebServlet("/AddStudServlet")
public class AddStudServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	    
        StudentPojo studentpj = new StudentPojo();
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
	    
        studentpj.setName(name);
        studentpj.setContact(contact);
        studentpj.setGender(gender);
         
		String[] beansXMLFiles = new String[]{
				"file:C:/Users/725580/workspace/Copy of StudentMgmtSys/src/beans.xml",
	            "file:C:/Users/725580/workspace/Copy of StudentMgmtSys/src/beans-aspect.xml"};
		ApplicationContext context = new FileSystemXmlApplicationContext(beansXMLFiles); 
		StudentBean bean = (StudentBean) context.getBean("addStudent");

	    if(bean.addStudent(studentpj) != 0)
	    {
	    	request.setAttribute("name", name);
	    	RequestDispatcher rd = request.getRequestDispatcher("AddStudentResult.jsp");
	    	rd.forward(request, response);
	    }	  
	    else{
	    	out.print("Failed to add student.");
			RequestDispatcher rd2 = request.getRequestDispatcher("AddStudent.jsp");
			rd2.include(request, response);
	    }
	}

}
