package com.jSMWebService.DAO;


import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Query;

import com.jSMWebService.*;
import com.jSMWebService.UserType.USERTYPE;


public class UserDAO extends BaseDAO { 
	
   public List<User> getAllUsers(){ 
  
	   String sql =
		        "SELECT * " +
		        "FROM User";

		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql).executeAndFetch(User.class);
		    }
	      
     
   } 
   
   
   public List<User> selectUsersByType(USERTYPE userType){
	   String sql =
		        "SELECT * " +
		        "FROM User " + 
		        "Where idUserType = :userType";

		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql)
		        		.addParameter("userType", userType)
		        		.executeAndFetch(User.class);
		    }
	      
   } 
   
   public User selectUserByID(int userId)
   {
	 
	   try (Connection con = sql2o.open()) {
		    final String query =
		        "SELECT * " +
		        "FROM User WHERE idUser = :userId";

		    return con.createQuery(query)
		        .addParameter("userId", userId)
		        .executeAndFetchFirst(User.class);
		  }
   }
   
   public User selectUserForLogin(String email, String password, int userType)
   {
	 
	   try (Connection con = sql2o.open()) {
		    final String querystr =
		        "SELECT * " +
		        "FROM User WHERE email = :email and password = :password and idUserType =:userType";
		    Query query =con.createQuery(querystr)
			        .addParameter("email", email)
			        .addParameter("password", password)
			        .addParameter("userType", userType);
		    
		    // debug print query string.
		    System.out.println(query.toString() +"---"+ email +"---"+  password +"---"+ userType);
		    
		    return 	query.executeAndFetchFirst(User.class);
		  }
   }
   
   
}
