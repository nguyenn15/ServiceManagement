package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jSMWebService.User;
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
		   @QueryParam("password") String password
		   ){ 
	   User user= userDao.selectUserForLogin(username, password, USERTYPE.EMPLOYEE); 
	  
      return userDao.getAllUsers().get(0); 
   }  
   
   
}
