package ORM;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestResponse {

	@SerializedName("cableBundle")
	@Expose
	private Integer cableBundle;
	@SerializedName("doorBell")
	@Expose
	private Integer doorBell;
	@SerializedName("idRequest")
	@Expose
	private Integer idRequest;
	@SerializedName("idResponse")
	@Expose
	private Integer idResponse;
	@SerializedName("motionDetector")
	@Expose
	private Integer motionDetector;
	@SerializedName("noOfAlarmPanel")
	@Expose
	private Integer noOfAlarmPanel;

	/*@SerializedName("status")
	@Expose
	private String status;*/

	@SerializedName("totalCost")
	@Expose
	private Double totalCost;

	public Integer getCableBundle() {
		return cableBundle;
	}

	public void setCableBundle(Integer cableBundle) {
		this.cableBundle = cableBundle;
	}

	public Integer getDoorBell() {
		return doorBell;
	}

	public void setDoorBell(Integer doorBell) {
		this.doorBell = doorBell;
	}

	public Integer getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public Integer getIdResponse() {
		return idResponse;
	}

	public void setIdResponse(Integer idResponse) {
		this.idResponse = idResponse;
	}

	public Integer getMotionDetector() {
		return motionDetector;
	}

	public void setMotionDetector(Integer motionDetector) {
		this.motionDetector = motionDetector;
	}

	public Integer getNoOfAlarmPanel() {
		return noOfAlarmPanel;
	}

	public void setNoOfAlarmPanel(Integer noOfAlarmPanel) {
		this.noOfAlarmPanel = noOfAlarmPanel;
	}
	/*
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    */
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}