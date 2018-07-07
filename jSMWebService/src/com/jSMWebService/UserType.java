package com.jSMWebService;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UserType implements Serializable {
	
	public static enum USERTYPE {ADMIN, MANAGER, CUSTOMER, EMPLOYEE};
	
	private USERTYPE idUserType;
	private String UserType;
	
	public UserType() {
	}

	public UserType(USERTYPE id, String type) {
		this.idUserType = id;
		this.UserType = type;
	}

	public USERTYPE getId() {
		return idUserType;
	}

	@XmlElement
	public void setId(USERTYPE id) {
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
