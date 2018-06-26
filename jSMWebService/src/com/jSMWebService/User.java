package com.jSMWebService;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author segroup1
 *
 */

@XmlRootElement(name = "user")

public class User implements Serializable {

	private int idUser;
	private String Name;
	private String Fone;
	private String Address;
	private String Gender;
	private int UserType_idUser;

	public User() {
	}

	public User(int id, String name, String fone, String address, String gender, int usertype) {
		this.idUser = id;
		this.Name = name;
		this.Fone = fone;
		this.Address = address;
		this.Gender = gender;
		this.UserType_idUser = usertype;

	}

	public int getId() {
		return idUser;
	}

	@XmlElement
	public void setId(int id) {
		this.idUser = id;
	}
	
	public int getIdType() {
		return UserType_idUser;
	}

	@XmlElement
	public void setIdType(int id) {
		this.UserType_idUser = id;
	}
	public String getName() {
		return Name;
	}

	@XmlElement
	public void setName(String name) {
		this.Name = name;
	}

	public String getFone() {
		return Fone;
	}

	@XmlElement
	public void setFone(String fone) {
		this.Fone = fone;
	}

	public String getAddress() {
		return Address;
	}

	@XmlElement
	public void setAddress(String address) {
		this.Address = address;
	}

	public String getGender() {
		return Gender;
	}

	@XmlElement
	public void setGender(String gender) {
		this.Gender = gender;
	}
}