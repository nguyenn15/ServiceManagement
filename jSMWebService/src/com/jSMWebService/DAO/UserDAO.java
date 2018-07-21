package com.jSMWebService.DAO;


import java.math.BigInteger;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Query;

import com.jSMWebService.*;

/**
 * This is the DAO class for access table User in Db
 * @author segroup1
 *
 */
public class UserDAO extends BaseDAO { 
	/**
	 * Get all users from table user
	 * @return
	 */
   public List<User> getAllUsers(){ 
  
	   String sql =
		        "SELECT * " +
		        "FROM User";
	   
		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql).executeAndFetch(User.class);
		    }
	      
     
   } 
   
   /**
    * Get user by type of user: ADMIN, MAnager, employee, customer
    * @param userType
    * @return
    */
   public List<User> selectUsersByType(UserType.USERTYPEID userType){
	   String sql =
		        "SELECT * " +
		        "FROM User " + 
		        "Where idUserType = :userType";

		    try(Connection con = sql2o.open()) {
		        return con.createQuery(sql)
		        		.addParameter("userType", userType.getValue())
		        		.executeAndFetch(User.class);
		    }
	      
   } 
   
   /**
    * Selec User by ID
    * @param userId
    * @return
    */
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
   
   
   /**
    * Get User For login info
    * @param email
    * @param password
    * @param userType
    * @return
    */
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
   
   
   /**
    * Update the information of a user
    * @param user
 * @return 
    */
   public User Update(User user) {
	   
	   String updateSql = "update user"
	   		+ " set "
			+ " `Name` = :Name, "
			+ "`Fone` = :Fone, "
			+ "`Address` = :Address, "
			+ "`Gender` = :Gender, "
			+ "`idUserType` = :idUserType, "
			+ "`Email` = :Email, "
			+ "`Password` = :Password "
			+ "WHERE (`idUser` = :idUser);" ;
		
			try (Connection con = sql2o.open()) {
			    con.createQuery(updateSql)
			    		.addParameter("idUser",user.getId())
			    		.addParameter("Password",user.getPassword())
			    		.addParameter("Email",user.getEmail())		    		
			    		.addParameter("idUserType",user.getIdType())
			    		.addParameter("Gender",user.getGender())
			    		.addParameter("Address",user.getAddress())
			    		.addParameter("Fone",user.getFone())
			    		.addParameter("Name",user.getName())
				    .executeUpdate();
			}
			//get the newest row.
			System.out.println("Update User " +"---"+ user.getId() );
			
			return selectUserByID(user.getId());
		
   }
   
   
   /**
    * create the information of a user
    * @param user
 * @return 
    */
   public User Create(User user) {
	   
	   String insertSql = "INSERT INTO `user` (`Name`, `Fone`, `Address`, `Gender`, `idUserType`, `Email`, `Password`) "
	   		+ "VALUES (:Name, :Fone, :Address, :Gender, :idUserType, :Email,:Password);" ;
	   
	   		BigInteger insertedId;
			try (Connection con = sql2o.open()) {
				insertedId= (BigInteger)con.createQuery(insertSql)
			    
			    		.addParameter("Password",user.getPassword())
			    		.addParameter("Email",user.getEmail())		    		
			    		.addParameter("idUserType",user.getIdType())
			    		.addParameter("Gender",user.getGender())
			    		.addParameter("Address",user.getAddress())
			    		.addParameter("Fone",user.getFone())
			    		.addParameter("Name",user.getName())
				    .executeUpdate().getKey();
			}
			//get the newest row.
			System.out.println("insert User " +"---"+ insertedId.intValue() );
			
			return selectUserByID(insertedId.intValue());
		
   }
   
   
}
