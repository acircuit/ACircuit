package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.cache.MyCacheBuilder;
import ac.dao.FeedDAO;
import ac.dao.SessionDAO;
import ac.dto.ActivityDTO;
import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;

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
			GetRelativeImageURL image = new GetRelativeImageURL();
			userDetails.setImage(image.getImageURL(userDetails.getImage()));
			List<ActivityDTO> activities = new ArrayList<ActivityDTO>();
			//Getting feeds for the dashboard
			//Geeting the info from the feeds table
			FeedDAO feeds = new FeedDAO();
			activities = feeds.Getfeeds();
			List<Integer> questionsFeedIds = new ArrayList<Integer>();
			List<Integer> reviewsFeedIds = new ArrayList<Integer>();
			List<Integer> answerFeedIds = new ArrayList<Integer>();

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
					  activity.setCategory(question.getCategory());
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
					  GetRelativeImageURL images = new GetRelativeImageURL();
					  activity.setImage(images.getImageURL(review.getImage()));
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
					  GetRelativeImageURL images = new GetRelativeImageURL();
					  activity.setImage(images.getImageURL(answer.getImage()));
					  activity.setAnswer(answer.getAnswer());
					  activity.setAnswerpostedon(answer.getAnswerpostedon());
				  }
			  }
				
			}
			//Getting wallet amount
			SessionDAO wallet = new SessionDAO();
			Double amount = wallet.GetWalletDetails(userId);
			//Getting the sub categories
			MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
			List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
			
			MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
			List<String> industrySubCategory = industry.getIndustrySubCategory();
			
			MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
			List<String> optionsSubCategory = option.getOpionsSubCategory();
			
			Collections.sort(activities);

			request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
			request.setAttribute("industrySubCategory", industrySubCategory);
			request.setAttribute("optionsSubCategory", optionsSubCategory);
            request.setAttribute("userDetails", userDetails);
			request.setAttribute("activities", activities);
			request.setAttribute("amount", amount);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashboard.jsp");
	        rd.forward(request, response);
		}
		if(isError){
			
			/*StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);*/
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashboard.jsp");
	        rd.forward(request, response);
		}
			
		logger.info("Entered doPost method of UserDashboardController");
	}
}
