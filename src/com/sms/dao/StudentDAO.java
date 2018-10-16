package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.sms.studentpojo.StudentPojo;

public class StudentDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int addStudent(StudentPojo student){
		
		int id = 0;
		String query = "insert into student (name,contact,gender) values(?,?,?)";
		
		try{
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
   	        ps.setString(1, student.getName());
   	        ps.setString(2, student.getContact());
	    	ps.setString(3, student.getGender());

	    	ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			while (rs.next()) {
				id = rs.getInt(1);
			}
		}
	    catch(Exception se)
	    {
	    	se.printStackTrace();
	    }		
		student.setId((id));	
		return id;
	}
	
	public static int removeStudent(StudentPojo student) {
		Connection con = DBUtil.getConnection();
		int count = 0;

		try {
			Statement st = con.createStatement();
			String query = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, student.getId());
			count = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static int updateStudent(StudentPojo student) {
		Connection con = DBUtil.getConnection();
		int count = 0;

		try {
			Statement st = con.createStatement();
			String query = "update student set name=?, contact=?, gender=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
	    	ps.setString(2, student.getContact());
   	        ps.setString(3, student.getGender());
   	        ps.setInt(4, student.getId());
			count = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	} 
	
}
