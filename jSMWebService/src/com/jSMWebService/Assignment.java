package com.jSMWebService;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jSMWebService.RequestOrder.STATUS;

public class Assignment implements Serializable {

	public static enum STATUS {
		WORKING(0), FINISH(1), ACCEPTED(2), REJECTED(3);

		 private final int status;
		 STATUS(int status) { this.status = status; }
		 public int getValue() { return status; }
		 public static STATUS FromInt(int value)
		 {
			 switch(value)
			 {
				 case 0: return STATUS.WORKING;
				 case 1: return STATUS.FINISH;
				 case 2: return STATUS.ACCEPTED;
				 case 3: return STATUS.REJECTED;
			 }
			 return STATUS.WORKING;
		 }
	};
	
	private int idAssignment;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date Date;
	private STATUS Status = STATUS.WORKING;
	private int idResponse;
	private int idEmployee;
	private int idAdmin;
	
	public Assignment() {
		// TODO Auto-generated constructor stub
	}

	public Assignment(int id, STATUS status, int idResponse, int idEmployee)
	{
		this.idAssignment= id;
		
		this.Status = status;
		this.idResponse = idResponse;
		this.idEmployee = idEmployee;
		
	}	
	public int getIdAssignment() { return this.idAssignment; }	
	public STATUS getStatus() { return this.Status; }
	public int getidResponse() { return this.idResponse; }
	public int getidEmployee() { return this.idEmployee; }	
	public void setIdAssignment(int idAssignment) {  this.idAssignment = idAssignment; }	
	public void setidResponse(int idResponse) {  this.idResponse = idResponse; }
	public void setidEmployee(int idEmployee) {  this.idEmployee= idEmployee; }
}
