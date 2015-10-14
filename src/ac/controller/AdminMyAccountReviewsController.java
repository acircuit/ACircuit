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

import ac.dao.AdminDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.FeedDAO;
import ac.dao.SessionDAO;
import ac.dto.ReviewsDTO;
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class AdminMyAccountReviewsController
 */
@WebServlet("/AdminMyAccountReviewsController")
public class AdminMyAccountReviewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountReviewsController.class);
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
		Boolean isError = false;
		Boolean isAdmin = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
				String url1 = url.toString();
				request.setAttribute("url1", url1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
		        rd.forward(request, response);
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if(isError!= null &&  !isError){
	         List<ReviewsDTO> reviews=  new ArrayList<ReviewsDTO>();
			AdminDAO review = new AdminDAO();
			reviews = review.GetReviews();
			request.setAttribute("reviews", reviews);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminreviews.jsp");
	        rd.forward(request, response);
			
		}
		
		logger.info("Exit doGet method of AdminMyAccountReviewsController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
				String url1 = url.toString();
				request.setAttribute("url1", url1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
		        rd.forward(request, response);
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if(isError!= null &&  !isError){
			String sessionId = request.getParameter("sessionId");
			String action = request.getParameter("action");
			if(action.equals("approve")){
				
				AdminDAO update = new AdminDAO();
				update.UpdateReviewsStatus(sessionId,"APPROVED");
		           //Getting the username and the advisor name
		           SessionDAO ids = new SessionDAO();
		           int[] id = ids.GetUserAdvisorIds(sessionId);
		  
		            SessionDAO uname = new SessionDAO();
		            UserDetailsDTO user = uname.GetUserName(id[1]); 
		            SessionDAO aname = new SessionDAO();
		            String advName = aname.GetAdvisorName(id[0]);
		            
		            SessionDAO reviews = new SessionDAO();
		            ReviewsDTO reviewDetails = reviews.GetReviews(sessionId);
		  
		           //Adding to the feeds table
			       FeedDAO feed = new FeedDAO();
			       int feedId = feed.InsertFeedType("review");
			       if(feedId != 0){
				      //Inserting feed content
			          FeedDAO rev = new FeedDAO();
			          Boolean isCommit = rev.InsertReviewFeed(feedId,reviewDetails.getId(),advName,user.getFullName(),user.getImage(),reviewDetails.getReview(),reviewDetails.getRating() );
			          if(isCommit){


						     //Notify advisor
					  			String advisorComment = "User just gave feedback for the session with session id :"+sessionId;
					  			String advisorHref = "advisorprofile?a="+id[0];
					  			AdvisorNotificationDAO advisor = new AdvisorNotificationDAO();
					  			advisor.InsertNotification(advisorComment,String.valueOf(id[0]), advisorHref);
			          }

			        }
			}else{
				AdminDAO update = new AdminDAO();
				update.UpdateReviewsStatus(sessionId,"REJECTED");
			}
	    }
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
	}
}
