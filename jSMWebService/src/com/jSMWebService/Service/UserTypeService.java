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
	UserTypeDAO userTypeDao = new UserTypeDAO();
	/**
	 * Get all User Type
	 * @return
	 */
   @GET 
   @Path("/all") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<UserType> getAll(){ 
      return userTypeDao.getAll(); 
   }  
   
   /**
    * get user type by id
    * @param idUserType
    * @return
    */
   @GET 
   @Path("/byId") 
   @Produces(MediaType.APPLICATION_JSON) 
   public UserType getByID( 
		   @QueryParam("idUserType") int idUserType
		   ){ 
      return userTypeDao.getById(idUserType); 
   }  
  
   /**
    * Update Service
    * @param idUserType
    * @param UserType
    * @return
    */
   @GET 
   @Path("/update") 
   @Produces(MediaType.APPLICATION_JSON) 
   public UserType update( 
		   @QueryParam("idUserType") int idUserType,
		   @QueryParam("UserType") String UserType
		   ){ 
	   
	   UserType utype = new UserType();
	   utype.setType(UserType);
	   
      return userTypeDao.Update(utype); 
   }  
   
}
