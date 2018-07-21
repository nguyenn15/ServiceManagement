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
   
   /**
    * Get User by ID
    * @param idUser
    * @return
    */
   @GET 
   @Path("/byId") 
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
   

   /**
    * 
    * @param idUser
    * @param Password
    * @param Email
    * @param idUserType
    * @param Gender
    * @param Address
    * @param Fone
    * @param Name
    * @return
    */
   @GET 
   @Path("/update") 
   @Produces(MediaType.APPLICATION_JSON) 
   public User update( 
		   @QueryParam("idUser") int idUser,
		   @QueryParam("Password") String Password,
		   @QueryParam("Email") String Email,
		   @QueryParam("idUserType") int idUserType,
		   @QueryParam("Gender") String Gender,
		   @QueryParam("Address") String Address,	   
		   @QueryParam("Fone") String Fone,
		   @QueryParam("Name") String Name   
		   )
   { 
	   User user = new User();
	   user.setId(idUser);
	   user.setPassword(Password);
	   user.setEmail(Email);
	   user.setGender(Gender);
	   user.setAddress(Address);
	   user.setFone(Fone);
	   user.setName(Name);
		  
		  
	   
      return userDao.Update(user); 
   }  
   
   /** Create user
   * @param idUserType
   * @param UserType
   * @return
   */
   
  @GET 
  @Path("/create") 
  @Produces(MediaType.APPLICATION_JSON) 
  public User create( 
		   @QueryParam("idUser") int idUser,
		   @QueryParam("Password") String Password,
		   @QueryParam("Email") String Email,
		   @QueryParam("idUserType") int idUserType,
		   @QueryParam("Gender") String Gender,
		   @QueryParam("Address") String Address,	   
		   @QueryParam("Fone") String Fone,
		   @QueryParam("Name") String Name   
		   )
  { 
	   User user = new User();
	   user.setId(idUser);
	   user.setPassword(Password);
	   user.setEmail(Email);
	   user.setGender(Gender);
	   user.setAddress(Address);
	   user.setFone(Fone);
	   user.setName(Name);
		  
		  
	   
     return userDao.Create(user); 
  }  
  
}
