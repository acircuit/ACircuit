package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.SessionDAO;
import ac.dao.UserNotificationDAO;

/**
 * Servlet implementation class AdvisorMyAccountCancelSession
 */
@WebServlet("/AdvisorMyAccountCancelSession")
public class AdvisorMyAccountCancelSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountCancelSession.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountCancelSession");
		String sid= request.getParameter("sId");
		SessionDAO update = new SessionDAO();
		Boolean isCommit = update.UpdateStatus("SESSION CANCELLED BY ADVISOR", sid);
		if(isCommit){
			SessionDAO user = new SessionDAO();
			int[] ids =   user.GetUserAdvisorIds(sid);
			String comment = "Your session request has been rejected by the advisor";
				String href = "usercancelledsession?sId="+sid;
				//Notification for user
				UserNotificationDAO notify = new UserNotificationDAO();
				notify.InsertNotification(comment,href,String.valueOf(ids[1])); 
			response.sendRedirect("advisorcancelledsession?sId="+sid);
			
			//notify admin
			String comment1 = "The session request has been rejected by the advisor";
			String href1 = "adminsessionviewdetails?sId="+sid;
			AdminNotificationDAO admin = new AdminNotificationDAO();
			admin.InsertNotification(comment1, href1);
		}
		logger.info("Entered doGet method of AdvisorMyAccountCancelSession");
	}

}
