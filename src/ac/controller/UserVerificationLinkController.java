package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.UserLoginDAO;

/**
 * Servlet implementation class UserVerificationLinkController
 */
@WebServlet("/UserVerificationLinkController")
public class UserVerificationLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserVerificationLinkController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of RegistrationController");
		String uId = request.getParameter("verify");
		//Verify the user
		UserLoginDAO user = new UserLoginDAO();
		 Boolean isCommit = user.UpdateUserVerification(uId,true);
		 if(isCommit){
			 //Getting the user email
			 UserLoginDAO usr = new UserLoginDAO();
			 String email = usr.GetUserEmail(uId);
			 request.getSession().setAttribute("userId",Integer.valueOf(uId));
			 request.getSession().setAttribute("email", email);
			 response.sendRedirect("userprofile?userverification=true");
		 }
		logger.info("Entered doPost method of RegistrationController");
	}

}
