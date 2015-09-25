package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.FeedDAO;
import ac.dao.SessionDAO;
import ac.dto.ActivityDTO;
import ac.dto.AdvisorDTO;

/**
 * Servlet implementation class AdvisorDashboardController
 */
@WebServlet("/AdvisorDashboardController")
public class AdvisorDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorDashboardController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorDashboardController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			response.sendRedirect("Error");
			isError = true;
		}
		if(advisorId != 0){
			//Getting advisor information 
			SessionDAO advisor = new SessionDAO();
			AdvisorDTO advisorDetails =  advisor.GetAdvisorDetails(advisorId);
			List<ActivityDTO> activities = new ArrayList<ActivityDTO>();
			//Getting feeds for the dashboard
			//Geeting the info from the feeds table
			FeedDAO feeds = new FeedDAO();
			activities = feeds.Getfeeds();
			List<Integer> questionsFeedIds = new ArrayList<Integer>();
			List<Integer> reviewsFeedIds = new ArrayList<Integer>();

			List<ActivityDTO> questionActivities = new ArrayList<ActivityDTO>();
			FeedDAO questionFeeds = new FeedDAO();
			questionActivities = questionFeeds.GetQuestionsFeeds();
			
			List<ActivityDTO> reviewActivities = new ArrayList<ActivityDTO>();
			FeedDAO reviewFeeds = new FeedDAO();
			reviewActivities = reviewFeeds.GetReviewsFeeds();
			
			List<ActivityDTO> answerActivities = new ArrayList<ActivityDTO>();
			FeedDAO answerFeeds = new FeedDAO();
			answerActivities = answerFeeds.GetAnswerFeeds();
			
			for(ActivityDTO activity : activities){
			  for(ActivityDTO question : questionActivities){
				  if(question.getFeedId() == activity.getFeedId()){
					  activity.setQuestionId(question.getQuestionId());
					  activity.setQuestion(question.getQuestion());
					  activity.setCategory(question.getSubcategory());
					  activity.setSubcategory(question.getSubcategory());
					  activity.setQuestionPostedOn(question.getQuestionPostedOn());
				  }
			  }
			  for(ActivityDTO review : reviewActivities){
				  if(review.getFeedId() == activity.getFeedId()){
					  activity.setReviewId(review.getReviewId());
					  activity.setAdvisorName(review.getAdvisorName());
					  activity.setUserName(review.getUserName());
					  activity.setRating(review.getRating());
					  activity.setImage(review.getImage());
					  activity.setReview(review.getReview());
					  activity.setReviewPostedOn(review.getReviewPostedOn()); 
				  }
			  }
			  
			  for(ActivityDTO answer : answerActivities){
				  if(answer.getFeedId() == activity.getFeedId()){
					  activity.setQuestionId(answer.getQuestionId());
					  activity.setQuestion(answer.getQuestion());
					  activity.setCategory(answer.getCategory());
					  activity.setSubcategory(answer.getSubcategory());
					  activity.setPostedon(answer.getPostedon());
					  activity.setAdvisorName(answer.getAdvisorName());
					  activity.setImage(answer.getImage());
					  activity.setAnswer(answer.getAnswer());
					  activity.setAnswerpostedon(answer.getAnswerpostedon());
				  }
			  }
				
				
			}
			
			request.setAttribute("advisorDetails", advisorDetails);
			request.setAttribute("activities", activities);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisordashboard.jsp");
	        rd.forward(request, response);
		}
		
		logger.info("Entered doPost method of AdvisorDashboardController");
	}

}
