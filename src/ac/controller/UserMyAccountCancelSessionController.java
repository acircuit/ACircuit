package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.SessionDAO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;
import ac.util.SendMail;

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
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		String sid= request.getParameter("sId");
		if(userId != 0){
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
			String href1 = "adminsessionviewdetails?sid="+sid;
			AdminNotificationDAO admin = new AdminNotificationDAO();
			admin.InsertNotification(comment1, href1);
			SessionDAO user = new SessionDAO();
			int[] ids =   user.GetUserAdvisorIds(sid);
			SessionDAO advisorName = new SessionDAO();
			String advName = advisorName.GetAdvisorName(ids[0]);
			SessionDAO users = new SessionDAO();
			UserDetailsDTO userName  = users.GetUserName(ids[1]);
			SessionDAO sessions = new SessionDAO();
			SessionDTO sessionDetails = sessions.GetSessionDetails(sid);
			Properties prop = new Properties();
    		InputStream resourceAsStream = Thread.currentThread()
    				.getContextClassLoader()
    				.getResourceAsStream("ac/resources/Mail.properties");
    		prop.load(resourceAsStream);
			String subject = "User has rejected the session request- #"+sid;
			String content = "Hello, <br><br>"
					+ "The session had been rejected by the user.<br><br>"
					+ "1.Session ID : "+sid+"<br>"
					+ "2.Username: "+userName+"<br>"
					+ "3.Advisorname:"+advName+"<br>"
					+ "4.Mode: "+sessionDetails.getMode()+"<br>"
					+ "5.Date and Time:"+sessionDetails.getAcceptedDate() +"and"+ sessionDetails.getAcceptedTime()+""
					+ "6.Duration:"+sessionDetails.getDuration()+"<br>"
					+ "7.Cost of session"+sessionDetails.getSessionPrice()+"<br>"
					+ " <br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
			SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
			mail.start();
			
			response.sendRedirect("usercancelledsession?sId="+sid);
		}
		}
		if(isError){
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("usercancelledsession?sId="+sid);
	        rd.forward(request, response);
		}
		logger.info("Entered doGet method of UserMyAccountCancelSessionController");
	}

}
