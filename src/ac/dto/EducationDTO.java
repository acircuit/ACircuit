package ac.dto;

public class EducationDTO {
     
	private int advisorId;
	private String  course;
	private String  institution;
	private String  duration;
	private String  type;
	
	public int getAdvisorId() {
		return advisorId;
	}
	public void setAdvisorId(int advisorId) {
		this.advisorId = advisorId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}
