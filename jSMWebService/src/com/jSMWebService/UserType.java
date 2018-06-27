package com.jSMWebService;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UserType implements Serializable {
	private int idUserType;
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
