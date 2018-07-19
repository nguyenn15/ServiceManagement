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
  
@Path("/UserService") 

public class UserService {  
	UserDAO userDao = new UserDAO();  
   @GET 
   @Path("/all") 
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
	   
	  int utypeid = UserType.USERTYPEID.FromString(usertype).getValue();	   
	  
	  User user= userDao.selectUserForLogin(username, password, utypeid); 
	  
	  if(user ==null)
	  {
		  user = new User(0, "no user", "123465", "address", "MALE" , 0);
		  System.out.println("Can not find user:" + username + " with password: "+ password);
	  }
	  
      return user;
   }  
   
   
   @GET 
   @Path("/byID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public User getById(
		   @QueryParam("idUser") int idUser
		   )
   {  
	  User user= userDao.selectUserByID(idUser); 	 
      return user;
   }  
   /**
    * Get User by user type id
    * use enum in UserTYpe class for convert value to int
    * @param idUserType     
    * @return
    */
   @GET 
   @Path("/byUserType") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<User> getByUserType(
		   @QueryParam("idUserType") int idUserType
		   )
   {  
	   UserType.USERTYPEID typeid = UserType.USERTYPEID.FromInt(idUserType);
	  return userDao.selectUsersByType(typeid); 	       
   }  
   
}
