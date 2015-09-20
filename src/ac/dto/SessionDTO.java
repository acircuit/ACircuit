package ac.dto;

import java.util.Date;

public class SessionDTO {
     
	private int sessionid;
	private int advisorid;
	private int userid;
	private String mode;
	private String duration;
	private String query;
    public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	private Date date1;
	private Date date2;
	private Date date3;
	private String time1;
	private String time2;
	private String time3;
	private Double price;
	private String resume;
	private String status;
	private Date acceptedDate;
	private String acceptedTime;
	private String sessionPlan;
	private String sessionDuration;
	private String sessionPrice;
	private String accepDate;
	
	public String getSessionDuration() {
		return sessionDuration;
	}
	public void setSessionDuration(String sessionDuration) {
		this.sessionDuration = sessionDuration;
	}
	public String getSessionPrice() {
		return sessionPrice;
	}
	public void setSessionPrice(String sessionPrice) {
		this.sessionPrice = sessionPrice;
	}
	public String getAccepDate() {
		return accepDate;
	}
	public void setAccepDate(String accepDate) {
		this.accepDate = accepDate;
	}
	public String getSessionPlan() {
		return sessionPlan;
	}
	public void setSessionPlan(String sessionPlan) {
		this.sessionPlan = sessionPlan;
	}
	public Date getAcceptedDate() {
		return acceptedDate;
	}
	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}
	public String getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(String acceptedTime) {
		this.acceptedTime = acceptedTime;
	}
	public int getSessionid() {
		return sessionid;
	}
	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
	}
	public int getAdvisorid() {
		return advisorid;
	}
	public void setAdvisorid(int advisorid) {
		this.advisorid = advisorid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getDate3() {
		return date3;
	}
	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTime3() {
		return time3;
	}
	public void setTime3(String time3) {
		this.time3 = time3;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
