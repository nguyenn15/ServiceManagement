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
   @GET 
   @Path("/RequestOrders") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestOrder> getRequestOrders(){ 
      return RequestOrderDao.getAllRequestOrders(); 
   }  
   
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
   
   @GET 
   @Path("/ByCustomerID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestOrder> getRequestOrdersByCustomer(
		   @QueryParam("idCustomer") int idCustomer
		   )
   { 
      return RequestOrderDao.selectRequestOrderByCustomerID(idCustomer);
   }  
   
   
/* Create request order
    * @param idRequest
    * @return
    */
   @GET 
   @Path("/Create") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestOrder  Create(
	//	   @QueryParam("idRequest")int idRequest,
	//	   @QueryParam("Date") java.util.Date Date ,
		   @QueryParam("Area") double Area,
		//   @QueryParam("Medium") int Medium,
		   @QueryParam("NoOfDoors") int NoOfDoors,
		   @QueryParam("EntryDoors") int Entry_Exit_Doors,
		   @QueryParam("OpenWindows") int OpenWindows,
		   @QueryParam("OpenAreas") double OpenAreas,
		   @QueryParam("DoorBell") int DoorBell,
		   @QueryParam("LocationOfService") String LocationOfService,
	//	   @QueryParam("Status") RequestOrder.STATUS Status,
		   @QueryParam("idCustomer") int idCustomer
	//	   @QueryParam("idManager") int idManager,
	//	   @QueryParam("idAdmin") int idAdmin
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
		  //message = "Created Request Order";
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		
		// message = e.getMessage();
		
	}
	// return Response			   .status(200)			   .entity(message).build();
	 return objRequestOrder;
   }  
   
}
