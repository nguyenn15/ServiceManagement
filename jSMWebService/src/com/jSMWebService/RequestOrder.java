package com.jSMWebService;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class RequestOrder implements Serializable {
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
	private int Status;
	private int idCustomer;
	private int idManager;
	private int idAdmin;
	
	public RequestOrder() {
		// TODO Auto-generated constructor stub
	}

	public RequestOrder(int id, double area, int medium, int noofdoors, int entryexitdoors, int openwindows, double openareas, int doorbell, String locationservice, int status, int idcustomer, int idmanager, int idadmin)
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
	
	public int getId() { return this.idRequest; }
	
	public double getArea() { return this.Area; }
	
	public int getMedium() { return this.Medium; }
	
	public int getNoOfDoors() {return this.NoOfDoors;}
	public int getEntry_Exit_Doors() {return this.Entry_Exit_Doors;}	
	public int getOpenWindows() {return this.OpenWindows;}
	public double  getOpenAreas() {return this.OpenAreas;}
	
	
}
