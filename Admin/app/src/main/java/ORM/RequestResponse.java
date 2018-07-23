package ORM;

import java.io.Serializable;

//import com.jSMWebService.RequestOrder.STATUS;

public class RequestResponse implements Serializable {
	public static enum STATUS {
		PENDING(0),REVIEWED(1), ACCEPTED(2), REJECTED(3), INPROGRESS(4);

		private final int status;
		STATUS(int status) { this.status = status; }
		public int getValue() { return status; }
		public static STATUS FromInt(int value)
		{
			switch(value)
			{
				case 0: return STATUS.PENDING;
				case 1: return STATUS.REVIEWED;
				case 2: return STATUS.ACCEPTED;
				case 3: return STATUS.REJECTED;
				case 4: return STATUS.INPROGRESS;
			}
			return STATUS.PENDING;
		}
	}

	private int idResponse;
	private int idRequest;
	private int NoOfAlarmPanel;
	private int MotionDetector;
	private int CableBundle;
	private int DoorBell;
	private double TotalCost;
	private STATUS Status = STATUS.PENDING;

	
	public RequestResponse() {
		// TODO Auto-generated constructor stub
	}

	public RequestResponse(int idResponse, int idRequest, int noOfAlarm, int motionDetector, int cableBundle, int doorBell, double totalCost, STATUS status, int idrequest) {
		this.idResponse = idResponse;
		this.idRequest=idRequest;
		this.NoOfAlarmPanel = noOfAlarm;
		this.MotionDetector = motionDetector;
		this.CableBundle = cableBundle;
		this.DoorBell = doorBell;
		this.TotalCost = totalCost;
		this.Status = status;
		this.idRequest = idrequest;
	}

	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public int getIdResponse() { return this.idResponse; }
	public int getNoOfAlarm() { return this.NoOfAlarmPanel; }
	public int getMotionDetector() { return this.MotionDetector; }
	public int getCableBundle() { return this.CableBundle; }
	public int getDoorBell() { return this.DoorBell; }
	public double getTotalCost() { return this.TotalCost; }
	public STATUS getStatus() { return this.Status; }
	
	
	
	public void setIdResponse(int idresponse) {  this.idResponse = idresponse; }
	public void setNoOfAlarm(int noofalarm) {  this.NoOfAlarmPanel = noofalarm; }
	public void setMotionDetector(int motiondetector) {  this.MotionDetector=motiondetector; }
	public void setCableBundle(int cablebundle) {  this.CableBundle= cablebundle; }
	public void setDoorBell(int doorbell) {  this.DoorBell = doorbell; }
	public void setTotalCost(double totalcost) {  this.TotalCost = totalcost; }
	public void setStatus(STATUS status) {  this.Status = status; }
	
	
}
