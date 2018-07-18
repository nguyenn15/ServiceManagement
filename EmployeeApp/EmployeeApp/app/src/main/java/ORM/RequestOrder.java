package ORM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Class Pojo of RequestOrder, will be used for store object from json of webservice
 */
public class RequestOrder implements Serializable {
	
	public static enum STATUS {PENDING(0), ACCEPTED(1), REJECTED(2);
	
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

	@SerializedName("area")
	@Expose
	private Double area;
	@SerializedName("date")
	@Expose
	private String date;
	@SerializedName("doorBell")
	@Expose
	private Integer doorBell;
	@SerializedName("entry_Exit_Doors")
	@Expose
	private Integer entryExitDoors;
	@SerializedName("idAdmin")
	@Expose
	private Integer idAdmin;
	@SerializedName("idCustomer")
	@Expose
	private Integer idCustomer;
	@SerializedName("idManager")
	@Expose
	private Integer idManager;
	@SerializedName("idRequest")
	@Expose
	private Integer idRequest;
	@SerializedName("locationOfService")
	@Expose
	private String locationOfService;
	@SerializedName("noOfDoors")
	@Expose
	private Integer noOfDoors;
	@SerializedName("openAreas")
	@Expose
	private Double openAreas;
	@SerializedName("openWindows")
	@Expose
	private Integer openWindows;
	@SerializedName("status")
	@Expose
	private Integer status;

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDoorBell() {
		return doorBell;
	}

	public void setDoorBell(Integer doorBell) {
		this.doorBell = doorBell;
	}

	public Integer getEntryExitDoors() {
		return entryExitDoors;
	}

	public void setEntryExitDoors(Integer entryExitDoors) {
		this.entryExitDoors = entryExitDoors;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getIdManager() {
		return idManager;
	}

	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}

	public Integer getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public String getLocationOfService() {
		return locationOfService;
	}

	public void setLocationOfService(String locationOfService) {
		this.locationOfService = locationOfService;
	}
	public Integer getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(Integer noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public Double getOpenAreas() {
		return openAreas;
	}

	public void setOpenAreas(Double openAreas) {
		this.openAreas = openAreas;
	}

	public Integer getOpenWindows() {
		return openWindows;
	}

	public void setOpenWindows(Integer openWindows) {
		this.openWindows = openWindows;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
