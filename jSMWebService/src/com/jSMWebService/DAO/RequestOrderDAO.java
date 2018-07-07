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

}
