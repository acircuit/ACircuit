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
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class UserDashboardController
 */
@WebServlet("/UserDashboardController")
public class UserDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserDashboardController.class);
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserLoginController");
		int userId = 0;
		Boolean isError = false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		if(userId != 0){
			//Getting user information 
			SessionDAO user = new SessionDAO();
			UserDetailsDTO userDetails =  user.GetUserDetails(userId);
			request.setAttribute("userDetails", userDetails);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashboard.jsp");
	        rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("Error");
		}
			
		logger.info("Entered doPost method of UserLoginController");
	}
}
