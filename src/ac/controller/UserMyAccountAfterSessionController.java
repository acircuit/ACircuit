package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdvisorNotificationDAO;
import ac.dao.FeedDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class UserMyAccountAfterSessionController
 */
@WebServlet("/UserMyAccountAfterSessionController")
public class UserMyAccountAfterSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountAfterSessionController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountAfterSessionController");
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
			  String sid = request.getParameter("sId");
			  //Getting the session details for the page
			  SessionDAO session = new SessionDAO();
			  SessionDTO sessionDetails= session.GetSessionDetails(sid);
			
			  //Getting user details 
			  SessionDAO advisor = new SessionDAO();
			  AdvisorDTO advisorDetails= advisor.GetAdvisorDetails(sessionDetails.getAdvisorid());
			
			  request.setAttribute("sessionDetails", sessionDetails);
			   request.setAttribute("advisorDetails", advisorDetails);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/aftersession.jsp");
	          rd.forward(request, response);
		}
	
		logger.info("Entered doGet method of UserMyAccountAfterSessionController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserMyAccountAfterSessionController");
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
		  String review = request.getParameter("review");
		  String rating = request.getParameter("rating");
		  String sid = request.getParameter("id");
		  int[] ids;
		  //Inserting the reviews given b the user
		  SessionDAO  review1= new SessionDAO();
		  int reviewId = review1.SetSesionReviews(sid,rating,review);
		  if(reviewId != 0){
			//Update session status
				SessionDAO status = new SessionDAO();
				Boolean isStatusCommit =  status.UpdateStatus("SESSION COMPLETE", sid);
				if(isStatusCommit){
			           //Getting userid and advisorid from sessionid
			            SessionDAO session = new SessionDAO();
			            ids = session.GetUserAdvisorIds(sid);
			  
			           //Getting the username and the advisor name
			           SessionDAO name = new SessionDAO();
			           String advName = name.GetAdvisorName(ids[0]);
			  
			            SessionDAO uname = new SessionDAO();
			            UserDetailsDTO user = uname.GetUserName(ids[1]); 
			  
			           //Adding to the feeds table
				       FeedDAO feed = new FeedDAO();
				       int feedId = feed.InsertFeedType("review");
				       if(feedId != 0){
					      //Inserting feed content
				          FeedDAO reviews = new FeedDAO();
				          Boolean isCommit = reviews.InsertReviewFeed(feedId,reviewId,advName,user.getFullName(),user.getImage(),review,rating );
				          if(isCommit){
				        	//Notify advisor
				  			String advisorComment = "User just gave feedback for the session with session id :"+sid;
				  			String advisorHref = "advisorprofile?a="+ids[0];
				  			AdvisorNotificationDAO advisor = new AdvisorNotificationDAO();
				  			advisor.InsertNotification(advisorComment, String.valueOf(ids[0]), advisorHref);
				        	 response.sendRedirect("userpastsession?sId="+sid); 
				          }

				        }
				}
		  }
		}
		
		logger.info("Entered doPost method of UserMyAccountAfterSessionController");
	}

}
