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
			  List<SessionDTO> sessions = new ArrayList<SessionDTO>();
			  //Getting all sessions for the user 
			  SessionDAO session = new SessionDAO();
			  sessions = session.GetSessionDetailsUsingAdvisorId(advisorId);
			  //Getting user Details
			  SessionDAO user = new SessionDAO();
			  List<UserDetailsDTO> userDetails= user.GetUserDetails(sessions);
			  System.out.println(sessions.size());
			  System.out.println(userDetails.size());

			  request.setAttribute("sessions", sessions);
			   request.setAttribute("userDetails", userDetails);
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
