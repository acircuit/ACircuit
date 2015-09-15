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
		  
		  //Inserting the reviews given b the user
		  SessionDAO  review1= new SessionDAO();
		  Boolean isCommit = review1.SetSesionReviews(sid,rating,review);
		}
		
		logger.info("Entered doPost method of UserMyAccountAfterSessionController");
	}

}
