package com.jSMWebService.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.sql2o.Connection;

import com.jSMWebService.RequestResponse;
import com.jSMWebService.RequestResponse.STATUS;
/**
 * This is the DAO class for accessing RequestResponse table in DB
 * @author segroup1
 *
 */
public class RequestResponseDAO extends BaseDAO {

	/**
	 * Get All requestresponses from table RequestResponse
	 * @return
	 */
	 public List<RequestResponse> getAll(){ 
		  
		 String sql =
			        "SELECT * " +
			        "FROM resquestresponse";
		 System.out.println(sql);
			    try(Connection con = sql2o.open()) {
			        return con.createQuery(sql).executeAndFetch(RequestResponse.class);
			    }
		      
	   } 

	 /**
	  * Get Request Response by ID
	  * @param RequestResponseId
	  * @return
	  */
	   public RequestResponse selectById(int responseId)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM resquestresponse WHERE idResponse = :idResponse";
			    System.out.println(query.toString() +"---"+ responseId );
			    
			    
			    return con.createQuery(query)
			        .addParameter("idResponse", responseId)
			        .executeAndFetchFirst(RequestResponse.class);
			  }
	   }
	   
	   /**
	    * Get Request Response by requestId
	    * @param CustomerID
	    * @return
	    */
	   public List<RequestResponse> selectByRequestId(int requestId)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM resquestresponse WHERE idRequest = :idRequest";

			    System.out.println(query + "--" +requestId );
			    
			    
			    return con.createQuery(query)
			        .addParameter("idRequest", requestId)
			        .executeAndFetch(RequestResponse.class);
			  }
	   }

	   /**
	    * Get Request by Customer ID 
	    * @param status
	    * @return
	    */
	   public List<RequestResponse> selectByCustomerId(int customerid)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        " SELECT B.* " + 
			        " FROM RequestOrder  A inner join ResquestResponse  B on A.idRequest = B.idRequest " + 
			        " where A.idCustomer = :idCustomer ";
			       
			    System.out.println(query + " with id Customer: "+customerid);
			    
			    return con.createQuery(query)
			       .addParameter("idCustomer", customerid)
			        
			        .executeAndFetch(RequestResponse.class);
			  }
	   }

	   /**
	    * Get Request by Status
	    * @param status
	    * @return
	    */
	   public List<RequestResponse> selectByStatus(RequestResponse.STATUS status)
	   {
		 
		   try (Connection con = sql2o.open()) {
			    final String query =
			        "SELECT * " +
			        "FROM resquestresponse WHERE Status = :status";
			    System.out.println(query);
			    return con.createQuery(query)
			        .addParameter("status", status.getValue())
			        .executeAndFetch(RequestResponse.class);
			  }
	   }

	   
	   
	   /**
	    * Create an new Request Response
	    * @param requestresponse
	    * @return
	    */
	   public RequestResponse create(RequestResponse requestresponse) {
		   
		   
		   String insertSql ="INSERT INTO `resquestresponse` "
		   		+ "(`NoOfAlarmPanel`, `MotionDetector`, `CableBundle`, `DoorBell`, `TotalCost`, `Status`, `idRequest`) "
		   		+ "VALUES (:NoOfAlarmPanel, :MotionDetector, :CableBundle, :DoorBell, :TotalCost, :Status, :idRequest);\r\n"; 
		   	 
		   System.out.println(insertSql);
		   
		   		BigInteger insertedId;
				try (Connection con = sql2o.open()) {
					insertedId =  (BigInteger)con.createQuery(insertSql, true)
							.addParameter("idRequest",requestresponse.getIdRequest())
				    		.addParameter("NoOfAlarmPanel",requestresponse.getNoOfAlarmPanel())
				    		.addParameter("MotionDetector",requestresponse.getMotionDetector())				    		
				    		.addParameter("CableBundle",requestresponse.getCableBundle())
				    		.addParameter("DoorBell",requestresponse.getDoorBell())
				    		.addParameter("TotalCost",requestresponse.getTotalCost())
				    		.addParameter("Status",requestresponse.getStatus().getValue())
				    	
					    .executeUpdate().getKey();
				}
				//get the newest row.
				System.out.println("Create request Response " +"---"+ insertedId );
				
				return selectById(insertedId.intValue());
				
	   }
	   
	   /**
	    * Update the information of a request order
	    * @param requestresponse
	 * @return 
	    */
	   public RequestResponse Update(RequestResponse requestresponse) {
		   
		
		   
		   String updateSql = "UPDATE `resquestresponse` SET "
		   		+ "`NoOfAlarmPanel` = :NoOfAlarmPanel , "
		   		+ "`MotionDetector` = :MotionDetector, "
		   		+ "`CableBundle` = :CableBundle , "
		   		+ "`DoorBell` = :DoorBell, "
		   		+ "`TotalCost` = :TotalCost , "
		   		+ "`Status` = :Status , "
		   		+ "`idRequest` = :idRequest "
		   		+ "WHERE (`idResponse` = :idResponse);\r\n"  
		   		;
		   System.out.println(updateSql);

				try (Connection con = sql2o.open()) {
				    con.createQuery(updateSql)
				    		.addParameter("idResponse",requestresponse.getIdResponse())
						    .addParameter("idRequest",requestresponse.getIdRequest())
				    		.addParameter("NoOfAlarmPanel",requestresponse.getNoOfAlarmPanel())
				    		.addParameter("MotionDetector",requestresponse.getMotionDetector())				    		
				    		.addParameter("CableBundle",requestresponse.getCableBundle())
				    		.addParameter("DoorBell",requestresponse.getDoorBell())
				    		.addParameter("TotalCost",requestresponse.getTotalCost())
				    		.addParameter("Status",requestresponse.getStatus().getValue())
					    .executeUpdate();
				}
				//get the newest row.
				System.out.println("Update request Response " +"---"+ requestresponse.getIdRequest() );
				
				return selectById(requestresponse.getIdResponse());
			
	   }
	   
}
