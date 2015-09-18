package ac.dto;

import java.sql.Timestamp;

public class QuestionsDTO {
	
	private int questionId;
	private int advisor_id;
	private int user_id;
	public int getAdvisor_id() {
		return advisor_id;
	}
	public void setAdvisor_id(int advisor_id) {
		this.advisor_id = advisor_id;
	}
	private String question;
	private String answer;
	private String category;
	private String subcategory;
	private String lastUpdated; 
	private int count;
	private Boolean isAnswered;
	private Boolean isAnonymous;
	private Timestamp postedOn;
	private int hits;
	private Boolean toForum;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Boolean getIsAnswered() {
		return isAnswered;
	}
	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}
	public Boolean getIsAnonymous() {
		return isAnonymous;
	}
	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	public Timestamp getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Timestamp postedOn) {
		this.postedOn = postedOn;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Boolean getToForum() {
		return toForum;
	}
	public void setToForum(Boolean toForum) {
		this.toForum = toForum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
}
