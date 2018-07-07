package com.jSMWebService;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RequestOrder implements Serializable {
	
	public static enum STATUS {PENDING, ACCEPTED, REJECTED}
	
	private int idRequest;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date Date;
	private double Area;
	private int Medium;
	private int NoOfDoors;
	private int Entry_Exit_Doors;
	private int OpenWindows;
	private double OpenAreas;
	private int DoorBell;
	private String LocationOfService;
	private STATUS Status = STATUS.PENDING;
	private int idCustomer;
	private int idManager;
	private int idAdmin;
	
	public RequestOrder() {
		// TODO Auto-generated constructor stub
	}

	public RequestOrder(int id, double area, int medium, int noofdoors, int entryexitdoors, int openwindows, double openareas, int doorbell, String locationservice, STATUS status, int idcustomer, int idmanager, int idadmin)
	{
		this.idRequest= id;
		this.Area = area;
		this.Medium= medium;
		this.NoOfDoors = noofdoors;
		this.Entry_Exit_Doors= entryexitdoors;
		this.OpenWindows = openwindows;
		this.OpenAreas = openareas;
		this.DoorBell= doorbell;
		this.LocationOfService = locationservice;
		this.Status = status;
		this.idCustomer = idcustomer;
		this.idManager = idmanager;
		this.idAdmin = idadmin;
	}
	
	public int getIdRequest() { return this.idRequest; }
	
	public double getArea() { return this.Area; }
	
	public int getMedium() { return this.Medium; }
	
	public int getNoOfDoors() {return this.NoOfDoors;}
	public int getEntry_Exit_Doors() {return this.Entry_Exit_Doors;}	
	public int getOpenWindows() {return this.OpenWindows;}
	public double  getOpenAreas() {return this.OpenAreas;}
	
	public int getDoorBell() { return this.DoorBell; }
	public String getLocationOfService() { return this.LocationOfService; }
	public STATUS getStatus() { return this.Status; }
	public int getIdCustomer() { return this.Medium; }
	public int getIdManager() { return this.Medium; }
	public int getIdAdmin() { return this.Medium; }
	
	public void setIdRequest(int idrequest) {  this.idRequest = idrequest; }
	
	public void setArea(double area) {  this.Area = area; }
	
	public void setMedium(int medium) {  this.Medium = medium; }
	
	public void setNoOfDoors(int doors) { this.NoOfDoors= doors;}
	public void setEntry_Exit_Doors(int entries) { this.Entry_Exit_Doors = entries;}	
	public void setOpenWindows(int openwindows) { this.OpenWindows = openwindows;}
	public void  setOpenAreas(double area) { this.OpenAreas = area;}
	
	public void setDoorBell(int doorbell) {  this.DoorBell= doorbell; }
	public void setLocationOfService(String locationservice) {  this.LocationOfService = locationservice; }
	public void setIdCustomer(int idcustomer) {  this.idCustomer = idcustomer; }
	public void setIdManager(int idmanager) {  this.idManager= idmanager; }
	public void setIdAdmin(int idAdmin) {this.idAdmin = idAdmin; }

}
