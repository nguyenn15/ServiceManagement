package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.jSMWebService.UserType;
import com.jSMWebService.DAO.UserTypeDAO;
  
@Path("/UserTypeService") 

public class UserTypeService {  
	UserTypeDAO userDao = new UserTypeDAO();
	/**
	 * Get all User Type
	 * @return
	 */
   @GET 
   @Path("/all") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<UserType> getAll(){ 
      return userDao.getAll(); 
   }  
   
   @GET 
   @Path("/byID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public UserType getByID( 
		   @QueryParam("idUserType") int idUserType
		   ){ 
      return userDao.getById(idUserType); 
   }  
  
   
}
