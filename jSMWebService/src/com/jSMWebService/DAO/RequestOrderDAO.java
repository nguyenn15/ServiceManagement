package com.jSMWebService.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import com.jSMWebService.RequestOrder;
import com.jSMWebService.RequestOrder.STATUS;
/**
 * This is the DAO class for accessing RequestOrder table in DB
 * @author segroup1
 *
 */
public class RequestOrderDAO extends BaseDAO {

	/**
	 * Get All requestorders from table RequestOrder
	 * @return
	 */
	 public List<RequestOrder> getAllRequestOrders(){ 
		  
		 String sql =
			        "SELECT * " +
			        "FROM RequestOrder";

			    try(Connection con = sql2o.open()) {
			        return con.createQuery(sql).executeAndFetch(RequestOrder.class);
			    }
		      
	   } 

	 /**
	  * Get Request Order by ID
	  * @param RequestOrderId
	  * @return
	  */
	   public RequestOrder selectRequestOrderByID(int RequestOrderId)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE idRequest = :RequestOrderId";
			    System.out.println(query.toString() +"---"+ RequestOrderId );
			    
			    return con.createQuery(query)
			        .addParameter("RequestOrderId", RequestOrderId)
			        .executeAndFetchFirst(RequestOrder.class);
			  }
	   }
	   
	   /**
	    * Get Request Order by customerID
	    * @param CustomerID
	    * @return
	    */
	   public List<RequestOrder> selectRequestOrderByCustomerID(int CustomerID)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE idCustomer = :CustomerID";

			    return con.createQuery(query)
			        .addParameter("CustomerID", CustomerID)
			        .executeAndFetch(RequestOrder.class);
			  }
	   }
	   
	   /**
	    * Get Request Order by Manager ID
	    * @param ManagerID
	    * @return
	    */
	   public List<RequestOrder> selectRequestOrderByManagerID(int ManagerID)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE idManager = :ManagerID";

			    return con.createQuery(query)
			        .addParameter("ManagerID", ManagerID)
			        .executeAndFetch(RequestOrder.class);
			  }
	   }
	   /**
	    * Get RequestOrder by AdminID 
	    * @param AdminID
	    * @return
	    */
	   public List<RequestOrder> selectRequestOrderByAdminID(int AdminID)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE idAdmin = :AdminID";

			    return con.createQuery(query)
			        .addParameter("AdminID", AdminID)
			        .executeAndFetch(RequestOrder.class);
			  }
	   }

	   /**
	    * Get Request by Status
	    * @param status
	    * @return
	    */
	   public List<RequestOrder> selectRequestOrderByStatus(STATUS status)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE Status = :status";

			    return con.createQuery(query)
			        .addParameter("status", status)
			        .executeAndFetch(RequestOrder.class);
			  }
	   }

	   /**
	    * Create an new Request Order
	    * @param requestorder
	    * @return
	    */
	   public RequestOrder Create(RequestOrder requestorder) {
		   
		   
		   String insertSql = 
					" INSERT INTO `requestorder` (`Date`, `Area`, `NoOfDoors`, `Entry_Exit_Doors`, `OpenWindows`, `OpenAreas`, `DoorBell`, `LocationOfService`, `Status`, `idCustomer`) "
					+" VALUES (  :Date, :Area, :NoOfDoors, :Entry_Exit_Doors, :OpenWindows, :OpenAreas, :DoorBell, :LocationOfService, :Status, :idCustomer )" ; 
		   		BigInteger insertedId;
				try (Connection con = sql2o.open()) {
					insertedId =  (BigInteger)con.createQuery(insertSql, true)
				    		//.addParameter("idRequest",requestorder.getIdRequest())
				    		.addParameter("Date",requestorder.getDate())
				    		.addParameter("Area",requestorder.getArea())				    		
				    		.addParameter("NoOfDoors",requestorder.getNoOfDoors())
				    		.addParameter("Entry_Exit_Doors",requestorder.getEntry_Exit_Doors())
				    		.addParameter("OpenWindows",requestorder.getOpenWindows())
				    		.addParameter("OpenAreas",requestorder.getOpenAreas())
				    		.addParameter("DoorBell",requestorder.getDoorBell())
				    		.addParameter("LocationOfService",requestorder.getLocationOfService())
				    		.addParameter("Status",requestorder.getStatus())
				    		.addParameter("idCustomer",requestorder.getIdCustomer())
					    .executeUpdate().getKey();
				}
				//get the newest row.
				System.out.println("Create request Order " +"---"+ insertedId );
				
				return selectRequestOrderByID(insertedId.intValue());
				
	   }
	   
	   /**
	    * Update the information of a request order
	    * @param requestorder
	 * @return 
	    */
	   public RequestOrder Update(RequestOrder requestorder) {
		   
		   String updateSql = "update requestorder"
		   		+ " set "
		   		+ " `Date`=:Date , `Area`=:Area , `NoOfDoors`=:NoOfDoors ,"
		   		+ " `Entry_Exit_Doors`=:Entry_Exit_Doors , `OpenWindows`=:OpenWindows , `OpenAreas`=:OpenAreas, `DoorBell`=:DoorBell , `LocationOfService`=:LocationOfService , `Status`=:Status ,"
		   		+ " `idCustomer` =:idCustomer, `idManager` =:idManager, `idAdmin` =:idAdmin`"  
		   		+ " where idRequest = :idRequest";

				try (Connection con = sql2o.open()) {
				    con.createQuery(updateSql)
				    		.addParameter("idRequest",requestorder.getIdRequest())
				    		.addParameter("Date",requestorder.getDate())
				    		.addParameter("Area",requestorder.getArea())
				    		
				    		.addParameter("NoOfDoors",requestorder.getNoOfDoors())
				    		.addParameter("Entry_Exit_Doors",requestorder.getEntry_Exit_Doors())
				    		.addParameter("OpenWindows",requestorder.getOpenWindows())
				    		.addParameter("OpenAreas",requestorder.getOpenAreas())
				    		.addParameter("DoorBell",requestorder.getDoorBell())
				    		.addParameter("LocationOfService",requestorder.getLocationOfService())
				    		.addParameter("Status",requestorder.getStatus())
				    		.addParameter("idCustomer",requestorder.getIdCustomer())
				    		.addParameter("idManager",requestorder.getIdManager())
				    		.addParameter("idAdmin",requestorder.getIdAdmin())
					    .executeUpdate();
				}
				//get the newest row.
				System.out.println("Update request Order " +"---"+ requestorder.getIdRequest() );
				
				return selectRequestOrderByID(requestorder.getIdRequest());
			
	   }
	   
}
