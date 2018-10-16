package com.sms.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sms.aspect.LoggingAspect;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(LoggingAspect.class.getName());
		
		HttpSession session = request.getSession(true);
		
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("username");
		String pw = request.getParameter("password");
		
		if(Validate.checkUser(user, pw)){
			log.debug(user + " has logged in.");
			RequestDispatcher rd = request.getRequestDispatcher("About.jsp");
			session.setAttribute("name", user);
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd2 = request.getRequestDispatcher("LoginResult.jsp");
			rd2.forward(request, response);
		}
	}
	
}
