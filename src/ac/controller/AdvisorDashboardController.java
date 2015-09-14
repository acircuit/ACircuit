package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class AdvisorDashboardController
 */
@WebServlet("/AdvisorDashboardController")
public class AdvisorDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorDashboardController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorDashboardController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			response.sendRedirect("Error");
			isError = true;
		}
		if(advisorId != 0){
			//Getting all the information needed for the dashboard
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisordashboard.jsp");
	        rd.forward(request, response);
		}
		
		logger.info("Entered doPost method of AdvisorDashboardController");
	}

}
