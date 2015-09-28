package ac.dto;

public class RefundDTO {

	private int id;
	private String trackingid;
	private Double amount;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrackingid() {
		return trackingid;
	}
	public void setTrackingid(String trackingid) {
		this.trackingid = trackingid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
