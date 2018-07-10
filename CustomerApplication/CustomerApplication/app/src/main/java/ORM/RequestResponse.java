package ORM;

import java.io.Serializable;

//import com.jSMWebService.RequestOrder.STATUS;

public class RequestResponse implements Serializable {

	public static enum STATUS {PENDING , ACCEPTED, REJECTED};
	
	private int idResponse;
	private int idRequest;
	private int NoOfAlarm;
	private int MotionDetector;
	private int CableBundle;
	private int DoorBell;
	private double TotalCost;
	private STATUS Status = STATUS.PENDING;

	
	public RequestResponse() {
		// TODO Auto-generated constructor stub
	}

	public RequestResponse(int idResponse, int noOfAlarm, int motionDetector, int cableBundle, int doorBell, double totalCost, STATUS status, int idrequest) {
		this.idResponse = idResponse;
		this.NoOfAlarm = noOfAlarm;
		this.MotionDetector = motionDetector;
		this.CableBundle = cableBundle;
		this.DoorBell = doorBell;
		this.TotalCost = totalCost;
		this.Status = status;
		this.idRequest = idrequest;
	}

	
	public int getIdResponse() { return this.idResponse; }
	public int getNoOfAlarm() { return this.NoOfAlarm; }
	public int getMotionDetector() { return this.MotionDetector; }
	public int getCableBundle() { return this.CableBundle; }
	public int getDoorBell() { return this.DoorBell; }
	public double getTotalCost() { return this.TotalCost; }
	public STATUS getStatus() { return this.Status; }
	
	
	
	public void setIdResponse(int idresponse) {  this.idResponse = idresponse; }
	public void setNoOfAlarm(int noofalarm) {  this.NoOfAlarm = noofalarm; }
	public void setMotionDetector(int motiondetector) {  this.MotionDetector=motiondetector; }
	public void setCableBundle(int cablebundle) {  this.CableBundle= cablebundle; }
	public void setDoorBell(int doorbell) {  this.DoorBell = doorbell; }
	public void setTotalCost(double totalcost) {  this.TotalCost = totalcost; }
	public void setStatus(STATUS status) {  this.Status = status; }
	
	
}
