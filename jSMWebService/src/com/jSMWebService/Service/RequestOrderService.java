package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jSMWebService.RequestOrder;
import com.jSMWebService.RequestOrder.STATUS;
import com.jSMWebService.DAO.RequestOrderDAO;  
@Path("/RequestOrderService") 

public class RequestOrderService {  
	RequestOrderDAO RequestOrderDao = new RequestOrderDAO();  
	/**
	 * API: get all request order
	 * @return
	 */
   @GET 
   @Path("/RequestOrders") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestOrder> getRequestOrders(){ 
      return RequestOrderDao.getAllRequestOrders(); 
   }  
   
   /**
    * API: get a request order by ID
    * @param idRequest
    * @return
    */
   @GET 
   @Path("/ByID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestOrder getRequestOrderByID(
		   @QueryParam("idRequest") int idRequest
		   )
   { 
	   RequestOrder  obj= RequestOrderDao.selectRequestOrderByID(idRequest); 
	   return obj;
   }  
   
   /**
    * API: gaet RO by customer ID 
    * @param idCustomer
    * @return
    */
   @GET 
   @Path("/ByCustomerID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestOrder> getRequestOrdersByCustomer(
		   @QueryParam("idCustomer") int idCustomer
		   )
   { 
      return RequestOrderDao.selectRequestOrderByCustomerID(idCustomer);
   }  
   
   
   /**
    * Create a request 
    * @param idRequest
    * @return
    */
   @GET 
   @Path("/Create") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestOrder  Create(

		   @QueryParam("Area") double Area,

		   @QueryParam("NoOfDoors") int NoOfDoors,
		   @QueryParam("EntryDoors") int Entry_Exit_Doors,
		   @QueryParam("OpenWindows") int OpenWindows,
		   @QueryParam("OpenAreas") double OpenAreas,
		   @QueryParam("DoorBell") int DoorBell,
		   @QueryParam("LocationOfService") String LocationOfService,

		   @QueryParam("idCustomer") int idCustomer

		   )
   { 
	   RequestOrder objRequestOrder=null;
	   String message="";
	   int idManager =0;
	   int idAdmin =0;
	   RequestOrder.STATUS Status = STATUS.PENDING;
	   
	   System.out.println("Create request from user "+idCustomer);
	   
	 try {
		   RequestOrder  obj= new RequestOrder(0 ,  Area,NoOfDoors,Entry_Exit_Doors,OpenWindows,OpenAreas,DoorBell,LocationOfService,Status,idCustomer,idManager,idAdmin);
		   
		   objRequestOrder=RequestOrderDao.Create(obj);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());

		
	}
	// return Response			   .status(200)			   .entity(message).build();
	 return objRequestOrder;
   }  
 
   /**
    * Update a RequestOrder:
    * 
    * @param idRequest : key do not change 
    * @param Area
    * @param NoOfDoors
    * @param Entry_Exit_Doors
    * @param OpenWindows
    * @param OpenAreas
    * @param DoorBell
    * @param LocationOfService
    * @param Status
    * @param idCustomer
    * @param idManager
    * @param idAdmin
    * @return
    */
   @GET 
   @Path("/Update") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestOrder  Update(
		   @QueryParam("idRequest")int idRequest,
		  // @QueryParam("Date") java.util.Date Date , // the create date time can not be changed
		   @QueryParam("Area") double Area,
		   //@QueryParam("Medium") int Medium,
		   @QueryParam("NoOfDoors") int NoOfDoors,
		   @QueryParam("EntryDoors") int Entry_Exit_Doors,
		   @QueryParam("OpenWindows") int OpenWindows,
		   @QueryParam("OpenAreas") double OpenAreas,
		   @QueryParam("DoorBell") int DoorBell,
		   @QueryParam("LocationOfService") String LocationOfService,
		   @QueryParam("Status") int Status,
		   @QueryParam("idCustomer") int idCustomer,
		   @QueryParam("idManager") int idManager,
		   @QueryParam("idAdmin") int idAdmin
		   )
   { 
	   RequestOrder objRequestOrder=null;
	   String message="";
	
	   RequestOrder.STATUS rStatus = STATUS.FromInt(Status);
	   
	   System.out.println("Create request from user "+idCustomer);
	   
	 try {
		   RequestOrder  obj= new RequestOrder(0 ,  Area,NoOfDoors,Entry_Exit_Doors,OpenWindows,OpenAreas,DoorBell,LocationOfService,rStatus,idCustomer,idManager,idAdmin);
		   
		   objRequestOrder=RequestOrderDao.Update(obj);
		  
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	} 
	 return objRequestOrder;
   }  
   
}
