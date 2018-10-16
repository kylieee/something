package com.sms.bean;

import com.sms.dao.StudentHibernateDAO;
import com.sms.studentpojo.StudentPojo;

public class StudentBean {

	public int addStudent(StudentPojo studentpj) {
		// TODO Auto-generated method stub
		int id = StudentHibernateDAO.insertStudent(studentpj);
		
		return id;
	}
	
	public static boolean updateStudent(StudentPojo studentpj) {
		// TODO Auto-generated method stub
		boolean execute = StudentHibernateDAO.updateStudent(studentpj);
		
		return execute;
	}
	
	public static boolean deleteStudent(StudentPojo studentpj) {
		// TODO Auto-generated method stub
		boolean execute = StudentHibernateDAO.removeStudent(studentpj);
		
		return execute;
	}
	
}
