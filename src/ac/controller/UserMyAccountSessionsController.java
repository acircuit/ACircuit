package ac.controller;

import java.io.IOException;
import java.sql.Timestamp;
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

/**
 * Servlet implementation class UserMyAccountSessionsController
 */
@WebServlet("/UserMyAccountSessionsController")
public class UserMyAccountSessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountSessionsController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountSessionsController");
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
			  List<SessionDTO> sessions = new ArrayList<SessionDTO>();
			  //Getting all sessions for the user 
			  SessionDAO session = new SessionDAO();
			  sessions = session.GetCurrentSessionDetails(userId);
			  System.out.println(userId);
			  System.out.println(sessions.size());
			  List<SessionDTO> pastSessions = new ArrayList<SessionDTO>();

			  SessionDAO past = new SessionDAO();
			  pastSessions = past.GetPastSessionDetails(userId);
			  
			  //Getting Advisor Details
			  List<AdvisorDTO> advisorDetails1 = new ArrayList<AdvisorDTO>();
			  SessionDAO advisor = new SessionDAO();
			  List<AdvisorDTO> advisorDetails= advisor.GetAdvisorDetails(sessions);
			  if(pastSessions.size() > 0){
			    SessionDAO advisors = new SessionDAO();
			    advisorDetails1= advisors.GetAdvisorDetails(pastSessions);
			  }
			  
			  //Getting Reviews given by the user
				List<ReviewsDTO> userReviews = new ArrayList<ReviewsDTO>();
			  SessionDAO reviews = new SessionDAO();
			  userReviews = reviews.GetUserReviews(userId);
			  List<Date> list = new ArrayList<Date>();
			  List<Integer> sIds = new ArrayList<Integer>();
			  List<Integer> aIds = new ArrayList<Integer>();

			  for(ReviewsDTO rev :userReviews){
				  System.out.println(rev.getSessionId() + ":" + rev.getAdvisorId());
				  sIds.add(rev.getSessionId());
				  aIds.add(rev.getAdvisorId());
			  }
			  List<SessionDTO> dates = new ArrayList<SessionDTO>();
			  SessionDAO time = new SessionDAO();
			  dates = time.GetSessionDate(sIds);
			  
				List<AdvisorDTO> advisorsForReviews = new ArrayList<AdvisorDTO>();

			  //Getting advisor details
			  SessionDAO advDetails = new SessionDAO();
			  advisorsForReviews = advDetails.GetDetailsForReviews(aIds);
			  


			  request.setAttribute("sessions", sessions);
			   request.setAttribute("advisorDetails", advisorDetails);
			   request.setAttribute("pastSessions", pastSessions);
			   request.setAttribute("advisorDetails1", advisorDetails1);
			   request.setAttribute("userReviews", userReviews);
			   request.setAttribute("sessionDates", dates);
			   request.setAttribute("advisorsForReviews", advisorsForReviews);

			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/usersessions.jsp");
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
