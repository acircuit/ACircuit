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
import ac.dao.SessionDAO;
import ac.dao.UserNotificationDAO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;
import ac.util.SendMail;

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
		int advisorId = 0;
		Boolean isError =false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(advisorId != 0){
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
			String href1 = "adminsessionviewdetails?sid="+sid;
			AdminNotificationDAO admin = new AdminNotificationDAO();
			admin.InsertNotification(comment1, href1);
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
			String subject = "Advisor has replied to session request- #"+sid;
			String content = "Hello, <br><br>"
					+ "The session had been rejected by the advisor.<br><br>"
					+ "1.Session ID : "+sid+"<br>"
					+ "2.Username: "+userName.getFullName()+"<br>"
					+ "3.Advisorname:"+advName+"<br>"
					+ "4.Mode: "+sessionDetails.getMode()+"<br>"
					+ "5.Date and Time:"+sessionDetails.getAcceptedDate() +"and"+ sessionDetails.getAcceptedTime()+""
					+ "6.Duration:"+sessionDetails.getDuration()+"<br>"
					+ "7.Cost of session"+sessionDetails.getSessionPrice()+"<br>"
					+ " <br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
			SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
			mail.start();
		}
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		logger.info("Entered doGet method of AdvisorMyAccountCancelSession");
	}

}
