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
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class UserDashboardController
 */
@WebServlet("/UserDashboardController")
public class UserDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserDashboardController.class);
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserDashboardController");
		int userId = 0;
		Boolean isError = false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		if(userId != 0){
			//Getting user information 
			SessionDAO user = new SessionDAO();
			UserDetailsDTO userDetails =  user.GetUserDetails(userId);
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
				
				
			}
			
			request.setAttribute("userDetails", userDetails);
			request.setAttribute("activities", activities);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashboard.jsp");
	        rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("Error");
		}
			
		logger.info("Entered doPost method of UserDashboardController");
	}
}
