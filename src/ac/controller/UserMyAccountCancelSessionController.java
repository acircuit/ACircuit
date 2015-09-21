package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.SessionDAO;

/**
 * Servlet implementation class UserMyAccountCancelSessionController
 */
@WebServlet("/UserMyAccountCancelSessionController")
public class UserMyAccountCancelSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountCancelSessionController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountCancelSessionController");
		String sid= request.getParameter("sId");
		SessionDAO update = new SessionDAO();
		Boolean isCommit = update.UpdateStatus("SESSION CANCELLED BY USER", sid);
		if(isCommit){
			response.sendRedirect("usercancelledsession?sId="+sid);
		}
		logger.info("Entered doGet method of UserMyAccountCancelSessionController");
	}

}
