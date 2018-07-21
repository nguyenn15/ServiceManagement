package com.jSMWebService.Service;

import java.util.List;


import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jSMWebService.RequestResponse;
import com.jSMWebService.RequestResponse.STATUS;
import com.jSMWebService.DAO.RequestResponseDAO;  
@Path("/RequestResponseService") 

public class RequestResponseService {  
	RequestResponseDAO RequestResponseDao = new RequestResponseDAO();  
	/**
	 * API: get all request order
	 * @return
	 */
   @GET 
   @Path("/all") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestResponse> getRequestResponses(){ 
      return RequestResponseDao.getAll(); 
   }  
   
   /**
    * API: get a request order by ID
    * @param idRequest
    * @return
    */
   @GET 
   @Path("/byId") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestResponse getRequestResponseByID(
		   @QueryParam("idResponse") int idResponse
		   )
   { 
	   RequestResponse  obj= RequestResponseDao.selectById(idResponse); 
	   return obj;
   }  
   
   /**
    * get ReqResp by request id
    * @param idRequest
    * @return
    */
   @GET 
   @Path("/byRequestId") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<RequestResponse> getByRequestId(
		   @QueryParam("idRequest") int idRequest
		   )
   { 
	  return RequestResponseDao.selectByRequestId(idRequest) ;
	   
   }  
   
   
   
   /**
    * Get ReqResp by status
    * @param Status
    * @return
   */
  @GET 
  @Path("/byStatus") 
  @Produces(MediaType.APPLICATION_JSON) 
  public List<RequestResponse> getByStatus(
		   @QueryParam("Status") int Status
		   )
  { 
	 RequestResponse.STATUS rStatus = STATUS.FromInt(Status);
	 
     return RequestResponseDao.selectByStatus(rStatus);
  }    
   
   /**
    * Create ne request reponse from an requestorder id
    * @param idRequest
    * @param NoOfAlarm
    * @param MotionDetector
    * @param CableBundle
    * @param DoorBell
    * @param TotalCost
    * @param Status
    * @return
    */
   @GET 
   @Path("/create") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestResponse  create(

		   @QueryParam("idRequest") int idRequest,
		   @QueryParam("NoOfAlarm") int NoOfAlarm,
		   @QueryParam("MotionDetector") int MotionDetector,
		   @QueryParam("CableBundle") int CableBundle,		   
		   @QueryParam("DoorBell") int DoorBell,
		   @QueryParam("TotalCost") double TotalCost,
		   @QueryParam("Status") int Status

		   )

	
   { 
	   RequestResponse objRequestResponse=null;
	   String message="";
	   int idManager =0;
	   int idAdmin =0;
	   RequestResponse.STATUS rStatus = RequestResponse.STATUS.PENDING;
	   	   	   
	 try {
		   RequestResponse  obj= new RequestResponse();
		   obj.setIdRequest(idRequest);
		   obj.setNoOfAlarmPanel(NoOfAlarm);
		   obj.setMotionDetector(MotionDetector);
		   obj.setCableBundle(CableBundle);
		   obj.setDoorBell(DoorBell);
		   obj.setTotalCost(TotalCost);
		   obj.setStatus(rStatus);
		   objRequestResponse=RequestResponseDao.create(obj);
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());

	}
	 return objRequestResponse;
   }  
 
   /**
    *API: Update a RequestResponse:
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
   @Path("/update") 
   @Produces(MediaType.APPLICATION_JSON) 
   public RequestResponse  Update(
		   @QueryParam("idResponse") int idResponse,
		   @QueryParam("idRequest") int idRequest,
		   @QueryParam("NoOfAlarm") int NoOfAlarm,
		   @QueryParam("MotionDetector") int MotionDetector,
		   @QueryParam("CableBundle") int CableBundle,		   
		   @QueryParam("DoorBell") int DoorBell,
		   @QueryParam("TotalCost") double TotalCost,
		   @QueryParam("Status") int Status

		   )
   { 
	   RequestResponse objRequestResponse=null;

	   RequestResponse.STATUS rStatus = STATUS.FromInt(Status);
	   	   	   
	 try {
		   
		   RequestResponse  obj= new RequestResponse();
		   obj.setIdResponse(idResponse);
		   obj.setIdRequest(idRequest);
		   obj.setNoOfAlarmPanel(NoOfAlarm);
		   obj.setMotionDetector(MotionDetector);
		   obj.setCableBundle(CableBundle);
		   obj.setDoorBell(DoorBell);
		   obj.setTotalCost(TotalCost);
		   obj.setStatus(rStatus);		   
		   		   
		   objRequestResponse=RequestResponseDao.Update(obj);
		  
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} 
	 return objRequestResponse;
   }  
   
}
