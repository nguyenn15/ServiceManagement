package com.jSMWebService;

import java.io.Serializable;

import com.jSMWebService.RequestOrder.STATUS;

public class RequestResponse implements Serializable {

	public static enum STATUS {
		
		PENDING(0) , ACCEPTED(1), REJECTED(2);
		
		 private final int status;
		 STATUS(int status) { this.status = status; }
		 public int getValue() { return status; }
		 public static STATUS FromInt(int value)
		 {
			 switch(value)
			 {
				 case 0: return STATUS.PENDING;
				 case 1: return STATUS.ACCEPTED;
				 case 2: return STATUS.REJECTED;
			 }
			 return STATUS.PENDING;
		 }
	
	}
	;
	
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

	public RequestResponse(int idResponse, int noOfAlarm, int motionDetector, int cableBundle, int doorBell, double totalCost, STATUS status, int idrequest) {
		this.idResponse = idResponse;
		this.NoOfAlarmPanel = noOfAlarm;
		this.MotionDetector = motionDetector;
		this.CableBundle = cableBundle;
		this.DoorBell = doorBell;
		this.TotalCost = totalCost;
		this.Status = status;
		this.idRequest = idrequest;
	}

	
	public int getIdResponse() { return this.idResponse; }
	public int getIdRequest() { return this.idRequest; }
	public int getNoOfAlarmPanel() { return this.NoOfAlarmPanel; }
	public int getMotionDetector() { return this.MotionDetector; }
	public int getCableBundle() { return this.CableBundle; }
	public int getDoorBell() { return this.DoorBell; }
	public double getTotalCost() { return this.TotalCost; }
	public STATUS getStatus() { return this.Status; }
	
	
	
	public void setIdResponse(int idresponse) {  this.idResponse = idresponse; }
	public void setIdRequest(int idrequest) {  this.idRequest = idrequest; }
	public void setNoOfAlarmPanel(int noofalarm) {  this.NoOfAlarmPanel = noofalarm; }
	public void setMotionDetector(int motiondetector) {  this.MotionDetector=motiondetector; }
	public void setCableBundle(int cablebundle) {  this.CableBundle= cablebundle; }
	public void setDoorBell(int doorbell) {  this.DoorBell = doorbell; }
	public void setTotalCost(double totalcost) {  this.TotalCost = totalcost; }
	public void setStatus(STATUS status) {  this.Status = status; }
	
	
}
