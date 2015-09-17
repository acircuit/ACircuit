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

import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
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
			  sessions = session.GetSessionDetails(userId);
			  System.out.println(userId);
			  System.out.println(sessions.size());
			  
			  //Getting Advisor Details
			  SessionDAO advisor = new SessionDAO();
			  List<AdvisorDTO> advisorDetails= advisor.GetAdvisorDetails(sessions);
			  System.out.println(advisorDetails.size());
			  
			
			  request.setAttribute("sessions", sessions);
			   request.setAttribute("advisorDetails", advisorDetails);
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
