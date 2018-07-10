package com.jSMWebService;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UserType implements Serializable {
	//enum
	public class USERTYPE{
		public static final int ADMIN=1;
		public static final int MANAGER=2;
		public static  final int CUSTOMER=4;
		public static  final int EMPLOYEE=3;			
	}
	
	private  int idUserType; // have to geta value from class USERTYPE
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
	
	
	
	//------ static useful function for casting usertype and int
	public static int FromString(String usertype)
	{
		int rs = USERTYPE.CUSTOMER;
		
		switch(usertype.trim().toUpperCase())
		{
			case "ADMIN": rs = USERTYPE.ADMIN; break;
			case "MANAGER": rs = USERTYPE.MANAGER; break;
			case "CUSTOMER": rs = USERTYPE.CUSTOMER; break;
			case "EMPLOYEE": rs = USERTYPE.EMPLOYEE; break;
		}
		
		return rs;
	}
}
