package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorNotificationDAO;
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
			SessionDAO advisor = new SessionDAO();
			int aid = advisor.GetAdvisorId(sid);
			 String comment = "The session has been rejected by the user";
				String href = "approvesession?sId="+sid;
				//Notification for Advisor
				AdvisorNotificationDAO notify = new AdvisorNotificationDAO();
				notify.InsertNotification(comment,String.valueOf(aid),href); 
			//notify admin
			String comment1 = "The session request has been rejected by the user";
			String href1 = "adminsessionviewdetails?sId="+sid;
			AdminNotificationDAO admin = new AdminNotificationDAO();
			admin.InsertNotification(comment1, href1);
			response.sendRedirect("usercancelledsession?sId="+sid);
		}
		logger.info("Entered doGet method of UserMyAccountCancelSessionController");
	}

}
