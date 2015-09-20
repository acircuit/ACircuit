package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class AdvisorMyAccountSessionsController
 */
@WebServlet("/AdvisorMyAccountSessionsController")
public class AdvisorMyAccountSessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountSessionsController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountSessionsController");
		int advisorId = 0;
		Boolean isError =false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(advisorId != 0){
			  List<SessionDTO> currentSessions = new ArrayList<SessionDTO>();
			  //Getting all sessions for the user 
			  SessionDAO session = new SessionDAO();
			  currentSessions = session.GetCurrentSessionDetailsUsingAdvisorId(advisorId);
			  //Getting user Details
			  SessionDAO user = new SessionDAO();
			  List<UserDetailsDTO> userDetails= user.GetUserDetails(currentSessions);
			 
			  List<SessionDTO> pastSessions = new ArrayList<SessionDTO>();
              SessionDAO session1 = new SessionDAO();
              pastSessions = session1.GetPastSessionsUsingAdvisorId(advisorId);
              List<UserDetailsDTO> userDetails1 = new ArrayList<UserDetailsDTO>();
              if(pastSessions.size() > 0){
                  //Getting user Details
    			  SessionDAO user1 = new SessionDAO();
    			  userDetails1= user1.GetUserDetails(pastSessions);
              }
              
              //Getting advisor reviews
              //Getting Reviews given by the user
				List<ReviewsDTO> advisorReviews = new ArrayList<ReviewsDTO>();
			  SessionDAO reviews = new SessionDAO();
			  advisorReviews = reviews.GetAdvisorReviews(advisorId);
			  List<Date> list = new ArrayList<Date>();
			  List<Integer> sIds = new ArrayList<Integer>();
			  List<Integer> uIds = new ArrayList<Integer>();

			  for(ReviewsDTO rev :advisorReviews){
				  sIds.add(rev.getSessionId());
				  uIds.add(rev.getUserId());
			  }
			  List<SessionDTO> dates = new ArrayList<SessionDTO>();
			  SessionDAO time = new SessionDAO();
			  dates = time.GetSessionDate(sIds);
			  
				List<UserDetailsDTO> usersForReviews = new ArrayList<UserDetailsDTO>();

			  //Getting advisor details
			  SessionDAO userDetailsForReviews = new SessionDAO();
			  usersForReviews = userDetailsForReviews.GetDetailsForReviewsUsingUserIds(uIds);

  
              System.out.println("user" + usersForReviews.size());

			  request.setAttribute("sessions", currentSessions);
			  request.setAttribute("userDetails", userDetails);
			  request.setAttribute("pastSessions", pastSessions);
			  request.setAttribute("userDetails1", userDetails1);
			   request.setAttribute("advisorReviews", advisorReviews);
			   request.setAttribute("sessionDates", dates);
			   request.setAttribute("usersForReviews", usersForReviews);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorsessions.jsp");
	          rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doGet method of UserMyAccountSessionsController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
