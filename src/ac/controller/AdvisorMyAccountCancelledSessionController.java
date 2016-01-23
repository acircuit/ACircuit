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
import ac.util.GetRelativeImageURL;

/**
 * Servlet implementation class AdvisorMyAccountCancelledSessionController
 */
@WebServlet("/AdvisorMyAccountCancelledSessionController")
public class AdvisorMyAccountCancelledSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountCancelledSessionController.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountSessionAcceptedController");
		int advisorId = 0;
		Boolean isError =false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(advisorId != 0){
			  String sid = request.getParameter("sId");
			  //Getting the session details for the page
			  SessionDAO session = new SessionDAO();
			  SessionDTO sessionDetails= session.GetSessionDetails(sid);
			
			  //Getting user details 
			  SessionDAO user = new SessionDAO();
			  UserDetailsDTO userDetails= user.GetUserDetails(sessionDetails.getUserid());
			  GetRelativeImageURL image = new GetRelativeImageURL();
			  userDetails.setImage(image.getImageURL(userDetails.getImage()));

			  request.setAttribute("sessionDetails", sessionDetails);
			  request.setAttribute("userDetails", userDetails);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorcancelledsession.jsp");
	          rd.forward(request, response);
		}
	    if(isError){
	    	
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorcancelledsession.jsp");
	        rd.forward(request, response);
	    }
		logger.info("Entered doGet method of UserMyAccountSessionAcceptedController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
