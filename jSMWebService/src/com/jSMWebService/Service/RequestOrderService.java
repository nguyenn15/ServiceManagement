package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
   @Path("/RequestOrder") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestOrder getRequestOrderByID(
		   @QueryParam("idRequest") int idRequest
		   )
   { 
	   RequestOrder  obj= RequestOrderDao.selectRequestOrderByID(idRequest); 
	   return obj;
   }  
   
   @GET 
   @Path("/RequestOrderByCustomerID") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestOrder> getRequestOrdersByCustomer(
		   @QueryParam("idCustomer") int idCustomer
		   )
   { 
      return RequestOrderDao.selectRequestOrderByCustomerID(idCustomer);
   }  
}
