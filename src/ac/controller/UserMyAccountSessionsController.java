package ac.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import ac.cache.MyCacheBuilder;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SessionDTO;
import ac.dto.TimeDTO;
import ac.util.GetTimeLeftForSession;

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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0){
			  List<SessionDTO> sessions = new ArrayList<SessionDTO>();
			  //Getting all sessions for the user 
			  SessionDAO session = new SessionDAO();
			  sessions = session.GetCurrentSessionDetails(userId);
			  System.out.println("sess"+sessions.size());
			  for(SessionDTO ses : sessions){
				  if(ses.getAcceptedDate() != null){
					  String accDate = sdf.format(ses.getAcceptedDate());
					  String time = ses.getAcceptedTime();
					  String timestamp = accDate+" "+ time+":00";
					  Timestamp ts = Timestamp.valueOf(timestamp);
					  GetTimeLeftForSession  time1 = new GetTimeLeftForSession();
				      TimeDTO left = time1.getTimeLeftForSession(ts);
					  ses.setHours(String.format("%02d", left.getHours()));
					  ses.setDays(String.format("%02d", left.getDay()));
					  ses.setMinutes(String.format("%02d", left.getMinutes()));
				  }
				
			  }
			  
			  
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
			//Getting the sub categories
				MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
				List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
				
				MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
				List<String> industrySubCategory = industry.getIndustrySubCategory();
				
				MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
				List<String> optionsSubCategory = option.getOpionsSubCategory();
				
				
				request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
				request.setAttribute("industrySubCategory", industrySubCategory);
				request.setAttribute("optionsSubCategory", optionsSubCategory);


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
