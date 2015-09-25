package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdvisorLoginDAO;
import ac.dao.UserLoginDAO;

/**
 * Servlet implementation class AdvisorVerificationLinkController
 */
@WebServlet("/AdvisorVerificationLinkController")
public class AdvisorVerificationLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorVerificationLinkController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorVerificationLinkController");
		String aId = request.getParameter("verify");
		//Verify the user
		AdvisorLoginDAO advisor = new AdvisorLoginDAO();
		 Boolean isCommit = advisor.UpdateAdvisorVerification(aId,true);
		 if(isCommit){
			 //Getting the user email
			 AdvisorLoginDAO adv = new AdvisorLoginDAO();
			 String email = adv.GetAdvisorEmail(aId);
			 request.getSession().setAttribute("advisorId",Integer.valueOf(aId));
			 request.getSession().setAttribute("email", email);
			 response.sendRedirect("profile?advisorverification=true");
		 }
		
		
		logger.info("Entered doPost method of AdvisorVerificationLinkController");
	}
}
