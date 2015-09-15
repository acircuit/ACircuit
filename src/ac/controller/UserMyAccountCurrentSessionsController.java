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

/**
 * Servlet implementation class UserMyAccountCurrentSessionsController
 */
@WebServlet("/UserMyAccountCurrentSessionsController")
public class UserMyAccountCurrentSessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountCurrentSessionsController.class);
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/currentsession.jsp");
	          rd.forward(request, response);
			
			
			
		}
	}
}
