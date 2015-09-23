package ac.controller;

import java.io.IOException;

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
 * Servlet implementation class UserMyAccountPastSessionController
 */
@WebServlet("/UserMyAccountPastSessionController")
public class UserMyAccountPastSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountPastSessionController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountPastSessionController");
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
			  SessionDAO reviews = new SessionDAO();
			  ReviewsDTO review = reviews.GetReviews(sid);
			
			  request.setAttribute("sessionDetails", sessionDetails);
			   request.setAttribute("advisorDetails", advisorDetails);
			   request.setAttribute("review", review);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/userpastsession.jsp");
	          rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("error");
		}
		
		
		logger.info("Entered doGet method of UserMyAccountPastSessionController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
