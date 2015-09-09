package ac.dto;

import java.sql.Timestamp;

public class AnswerDTO {
	
	private int questionId;
	private int advisor_id;
	private String answer;
	private Timestamp time;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getAdvisor_id() {
		return advisor_id;
	}
	public void setAdvisor_id(int advisor_id) {
		this.advisor_id = advisor_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
