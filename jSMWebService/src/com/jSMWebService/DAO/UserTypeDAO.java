package com.jSMWebService.DAO;


import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Query;

import com.jSMWebService.*;


/**
 * This is the DAO class for access table UserType in Db
 * @author segroup1
 *
 */
public class UserTypeDAO extends BaseDAO {
	
	/**
	 * Get all users from table user
	 * @return
	 */
   public List<UserType> getAll(){ 
  
	   String sql =
		        "SELECT * " +
		        "FROM UserType";
	   
		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql).executeAndFetch(UserType.class);
		    }
	      
     
   } 
   
   /**
    * Select UserType by ID
    * Use UsetType.USERTYPEID enum to get correct value if need
    * @param userId
    * @return
    */
   public UserType getById(int usertypeId)
   {
	 
	   try (Connection con = sql2o.open()) {
		    final String query =
		        "SELECT * " +
		        "FROM UserType WHERE idUserType = :userTypeId";

		    return con.createQuery(query)
		        .addParameter("userTypeId", usertypeId)
		        .executeAndFetchFirst(UserType.class);
		  }
   }
     
}