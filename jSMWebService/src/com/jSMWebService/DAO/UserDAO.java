package com.jSMWebService.DAO;


import java.util.List;

import org.sql2o.Connection;

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
   
   public User selectUserForLogin(String email, String password, USERTYPE userType)
   {
	 
	   try (Connection con = sql2o.open()) {
		    final String query =
		        "SELECT * " +
		        "FROM User WHERE email = :email and password = :password and idUserType = :userType";

		    return con.createQuery(query)
		        .addParameter("email", email)
		        .addParameter("password", password)
		        .addParameter("userType", userType)
		        .executeAndFetchFirst(User.class);
		  }
   }
   
   
}
