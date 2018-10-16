package com.sms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sms.studentpojo.Student;
import com.sms.studentpojo.StudentPojo;

public class StudentHibernateDAO {
	
	public static int insertStudent(StudentPojo studentpj){
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		
		Student student = new Student();
		int userId = 0;
		
		try{
			sf = util.HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr = session.beginTransaction();
			
			student.setName(studentpj.getName());
			student.setContact(studentpj.getContact());
			student.setGender(studentpj.getGender());
			session.save(student);
			tr.commit();
			userId = student.getId();
		}
		catch(Exception e) {
			  System.out.println("Error with insert block");
			  tr.rollback();
		} finally {
			  session.close();			  
		}
		return userId;
	}
	
	//update
	//hql
	public static boolean updateStudent(StudentPojo studentpj){
		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;
		
		boolean execute = false;
		
		try{
			sf = util.HibernateUtil.getSessionFactory();
			session=sf.openSession();
			tr = session.beginTransaction();
			
			Query query = session.createQuery("update Student student "
					+ "set student.name = :name, student.contact = :contact, "
					+ "student.gender = :gender "
					+ "where student.id = :id");
	        query.setParameter("name", studentpj.getName());
	        query.setParameter("contact", studentpj.getContact());
	        query.setParameter("gender", studentpj.getGender());
	        query.setParameter("id", studentpj.getId());
			
	        int i = query.executeUpdate();
	        session.getTransaction().commit();
	        
			if(i>0){
				execute = true;
			}
		}
		catch(Exception e) {
			  System.out.println("Error with update block");
			  tr.rollback();
		} finally {
			  session.close();			  
		}
		return execute;
	}
	
	//delete
	//hql
	public static boolean removeStudent(StudentPojo studentpj) {
		boolean remove = true;

		SessionFactory sf = null;
		Session session = null;
		Transaction tr = null;

		try {
			sf = util.HibernateUtil.getSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();
			Student s = session.get(Student.class, new Integer (studentpj.getId()));
			session.delete(s);
			tr.commit();
			remove = true;
		} catch (Exception e) {
			remove = false;
			tr.rollback();
			session.close();
		}
		return remove;
	}
	
	public static List<Student> ListStudent() {
		
		SessionFactory sf = null;
		Session session = null;
		sf = util.HibernateUtil.getSessionFactory();
		session = sf.openSession();
		Query query = session.createQuery("from Student");
	    List<Student> s = query.list();
	    return s;
	}
}
