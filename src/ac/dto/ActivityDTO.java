package ac.dto;

import java.util.Date;

public class ActivityDTO {

	private int feedId;
	private String feedType;
	
	//Questions feed 
	private int questionId;
	private String category;
	private String question;
	private String subcategory;
	private Date questionPostedOn;
	
	//Reviews feed
	private int reviewId;
	private String userName;
	private String advisorName;
	private String image;

	private String rating;
	private String review;
	private Date reviewPostedOn;
	
	
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAdvisorName() {
		return advisorName;
	}
	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getReviewPostedOn() {
		return reviewPostedOn;
	}
	public void setReviewPostedOn(Date reviewPostedOn) {
		this.reviewPostedOn = reviewPostedOn;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	public Date getQuestionPostedOn() {
		return questionPostedOn;
	}
	public void setQuestionPostedOn(Date questionPostedOn) {
		this.questionPostedOn = questionPostedOn;
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public String getFeedType() {
		return feedType;
	}
	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}
}
