package com.jSMWebService.DAO;

import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import com.jSMWebService.RequestOrder;
import com.jSMWebService.RequestOrder.STATUS;

public class RequestOrderDAO extends BaseDAO {

	 public List<RequestOrder> getAllRequestOrders(){ 
		  
		 String sql =
			        "SELECT * " +
			        "FROM RequestOrder";

			    try(Connection con = sql2o.open()) {
			        return con.createQuery(sql).executeAndFetch(RequestOrder.class);
			    }
		      
	   } 
	   
	   public RequestOrder selectRequestOrderByID(int RequestOrderId)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM RequestOrder WHERE idRequest = :RequestOrderId";

			    return con.createQuery(query)
			        .addParameter("RequestOrderId", RequestOrderId)
			        .executeAndFetchFirst(RequestOrder.class);
			  }
	   }
	   
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

	   
	   public void Create(RequestOrder requestorder) {
		   
		   
		   String insertSql = 
					" INSERT INTO `requestorder` (`Date`, `Area`, `Medium`, `NoOfDoors`, `Entry_Exit_Doors`, `OpenWindows`, `OpenAreas`, `DoorBell`, `LocationOfService`, `Status`, `idCustomer`) "
					+" VALUES (  :Date, :Area, :Medium, :NoOfDoors, :Entry_Exit_Doors, :OpenWindows, :OpenAreas, :DoorBell, :LocationOfService, :Status, :idCustomer )" ; 
					
				try (Connection con = sql2o.open()) {
				    con.createQuery(insertSql)
				    		//.addParameter("idRequest",requestorder.getIdRequest())
				    		.addParameter("Date",requestorder.getDate())
				    		.addParameter("Area",requestorder.getArea())
				    		.addParameter("Medium",requestorder.getMedium())
				    		.addParameter("NoOfDoors",requestorder.getNoOfDoors())
				    		.addParameter("Entry_Exit_Doors",requestorder.getEntry_Exit_Doors())
				    		.addParameter("OpenWindows",requestorder.getOpenWindows())
				    		.addParameter("OpenAreas",requestorder.getOpenAreas())
				    		.addParameter("DoorBell",requestorder.getDoorBell())
				    		.addParameter("LocationOfService",requestorder.getLocationOfService())
				    		.addParameter("Status",requestorder.getStatus())
				    		.addParameter("idCustomer",requestorder.getIdCustomer())
					    .executeUpdate();
				}
			
	   }
	   
	   public void Update(RequestOrder requestorder) {
		   
		   String updateSql = "update requestorder"
		   		+ " set "
		   		+ " `Date`=:Date , `Area`=:Area , `Medium`=:Medium , `NoOfDoors`=:NoOfDoors ,"
		   		+ " `Entry_Exit_Doors`=:Entry_Exit_Doors , `OpenWindows`=:OpenWindows , `OpenAreas`=:OpenAreas, `DoorBell`=:DoorBell , `LocationOfService`=:LocationOfService , `Status`=:Status ,"
		   		+ " `idCustomer` =:idCustomer, `idManager` =:idManager, `idAdmin` =:idAdmin`"  
		   		+ " where idRequest = :idRequest";

				try (Connection con = sql2o.open()) {
				    con.createQuery(updateSql)
				    		.addParameter("idRequest",requestorder.getIdRequest())
				    		.addParameter("Date",requestorder.getDate())
				    		.addParameter("Area",requestorder.getArea())
				    		.addParameter("Medium",requestorder.getMedium())
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
			
	   }
	   
}
