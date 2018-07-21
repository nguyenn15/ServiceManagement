package com.jSMWebService.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import com.jSMWebService.Assignment;
import com.jSMWebService.Assignment.STATUS;
/**
 * This is the DAO class for accessing Assignment table in DB
 * @author segroup1
 *
 */
public class AssigmentDAO extends BaseDAO {

	/**
	 * Get All assignments from table Assignment
	 * @return
	 */
	 public List<Assignment> getAll(){ 
		  
		 String sql =
			        "SELECT * " +
			        "FROM Assignment";

			    try(Connection con = sql2o.open()) {
			        return con.createQuery(sql).executeAndFetch(Assignment.class);
			    }
		      
	   } 

	 /**
	  * Get assignment by ID
	  * @param AssignmentId
	  * @return
	  */
	   public Assignment selectById(int AssignmentId)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM Assignment WHERE idAssignment = :AssignmentId";
			    System.out.println(query.toString() +"---"+ AssignmentId );
			    
			    return con.createQuery(query)
			        .addParameter("AssignmentId", AssignmentId)
			        .executeAndFetchFirst(Assignment.class);
			  }
	   }
	   
	   
	   
	   
		
	   /**
	    * Get Request by id response
	    * @param status
	    * @return
	    */
	   public List<Assignment> selectByIdResponse(int idResponse)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM Assignment WHERE idResponse = :idResponse";

			    return con.createQuery(query)
			        .addParameter("idResponse", idResponse)
			        .executeAndFetch(Assignment.class);
			  }
	   }

	  
	   
	 
	
	   /**
	    * Get Request by Status
	    * @param status
	    * @return
	    */
	   public List<Assignment> selectByStatus(Assignment.STATUS status)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM Assignment WHERE Status = :status";

			    return con.createQuery(query)
			        .addParameter("status", status.getValue())
			        .executeAndFetch(Assignment.class);
			  }
	   }

	   /**
	    * Create an new assignment
	    * @param assignment
	    * @return
	    
	   public Assignment Create(Assignment assignment) {
		   
		   
		   String insertSql = 
					" INSERT INTO `assignment` (`Date`, `Area`, `NoOfDoors`, `Entry_Exit_Doors`, `OpenWindows`, `OpenAreas`, `DoorBell`, `LocationOfService`, `Status`, `idCustomer`) "
					+" VALUES (  :Date, :Area, :NoOfDoors, :Entry_Exit_Doors, :OpenWindows, :OpenAreas, :DoorBell, :LocationOfService, :Status, :idCustomer )" ; 
		   		BigInteger insertedId;
				try (Connection con = sql2o.open()) {
					insertedId =  (BigInteger)con.createQuery(insertSql, true)
				    		//.addParameter("idAssignment",assignment.getIdRequest())
				    		.addParameter("Date",assignment.getDa())
				    		.addParameter("Status",assignment.getStatus())
				    		.addParameter("Status",assignment.getidEmployee())
				    		.addParameter("Status",assignment.getidResponse())
				    		
					    .executeUpdate().getKey();
				}
				//get the newest row.
				System.out.println("Create request Order " +"---"+ insertedId );
				
				return selectAssignmentByID(insertedId.intValue());
				
	   }
	   */
	 
}
