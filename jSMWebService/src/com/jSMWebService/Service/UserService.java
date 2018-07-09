package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jSMWebService.User;
import com.jSMWebService.UserType;
import com.jSMWebService.DAO.UserDAO;
import com.jSMWebService.UserType.USERTYPE;  
@Path("/UserService") 

public class UserService {  
	UserDAO userDao = new UserDAO();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<User> getUsers(){ 
      return userDao.getAllUsers(); 
   }  
   
   @GET 
   @Path("/login") 
   @Produces(MediaType.APPLICATION_JSON) 
   public User login(
		   @QueryParam("username") String username,
		   @QueryParam("password") String password,
		   @QueryParam("usertype") String usertype	// ADMIN, MANAGER, CUSTOMER, EMPLOYEE
		   )
   { 
	   
	  int utype = UserType.FromString(usertype);	   
	  
	  User user= userDao.selectUserForLogin(username, password, utype); 
	  
	  if(user ==null)
	  {
		  user = new User(0, "no user", "123465", "address", "MALE" , 0);
		  System.out.println("Can not find user:" + username + " with password: "+ password);
	  }
	  
      return user;
   }  
   
   
}
