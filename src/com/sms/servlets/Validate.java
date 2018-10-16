package com.sms.servlets;


import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String user,String pw) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/mydb","root","training123");
         PreparedStatement ps =con.prepareStatement
                             ("select username,password from user where username=? and password=?");
         ps.setString(1, user);
         ps.setString(2, pw);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}
