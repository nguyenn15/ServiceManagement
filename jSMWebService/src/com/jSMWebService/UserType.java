package com.jSMWebService;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import com.jSMWebService.RequestOrder.STATUS;

public class UserType implements Serializable {
	
	
	public static enum USERTYPEID {ADMIN(1), MANAGER(2), CUSTOMER(4), EMPLOYEE(3);
		
		 private final int status;
		 USERTYPEID(int status) { this.status = status; }
		 public int getValue() { return status; }
		 public static USERTYPEID FromInt(int value)
		 {
			 switch(value)
			 {
				 case 1: return USERTYPEID.ADMIN;
				 case 2: return USERTYPEID.MANAGER;
				 case 3: return USERTYPEID.CUSTOMER;
				 case 4: return USERTYPEID.EMPLOYEE;
			 }
			 return USERTYPEID.CUSTOMER;
		 }
		 public static USERTYPEID FromString(String usertype)
		 {
			 USERTYPEID rs = USERTYPEID.CUSTOMER;
				
			switch(usertype.trim().toUpperCase())
			{
				case "ADMIN": rs = USERTYPEID.ADMIN; break;
				case "MANAGER": rs = USERTYPEID.MANAGER; break;
				case "CUSTOMER": rs = USERTYPEID.CUSTOMER; break;
				case "EMPLOYEE": rs = USERTYPEID.EMPLOYEE; break;
			}
				
			return rs;
		 }
	}
	
	
	
	private  int idUserType; // have to get a value from class USERTYPE
	private String UserType;
	
	public UserType() {
	}

	public UserType(int id, String type) {
		this.idUserType = id;
		this.UserType = type;
	}

	public int getId() {
		return idUserType;
	}

	@XmlElement
	public void setId(int id) {
		this.idUserType = id;
	}
	
	public String getType() {
		return UserType;
	}

	@XmlElement
	public void setType(String type) {
		this.UserType = type;
	}
	
	
	
	
}
