package com.jSMWebService;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Assigment implements Serializable {

	public static enum STATUS {WORKING, FINISH, ACCEPTED, REJECTED}
	
	private int idAssignment;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date Date;
	private STATUS Status = STATUS.WORKING;
	private int idResponse;
	private int idEmployee;
	private int idAdmin;
	
	public Assigment() {
		// TODO Auto-generated constructor stub
	}

	public Assigment(int id, STATUS status, int idResponse, int idEmployee)
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
