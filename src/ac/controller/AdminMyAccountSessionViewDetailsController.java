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

import ac.dao.AdvisorNotificationDAO;
import ac.dao.SessionDAO;
import ac.dao.UserNotificationDAO;
import ac.dto.AdvisorDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;
import ac.util.SendMail;

/**
 * Servlet implementation class AdminMyAccountSessionViewDetailsController
 */
@WebServlet("/AdminMyAccountSessionViewDetailsController")
public class AdminMyAccountSessionViewDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountAdvisorController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountSessionViewDetailsController");
		  String sid = request.getParameter("sid");
			Boolean isAdmin = false;
			Boolean isError = false;
			try{
				isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
				}catch(Exception e){
					response.sendRedirect("Error");
					isError = true;
				}
			if(isAdmin == null){
				isError = true;
				response.sendRedirect("Error");
			}
			if(isError!= null &&  !isError){
		  //Getting the session details for the page
		  SessionDAO session = new SessionDAO();
		  SessionDTO sessionDetails= session.GetSessionDetails(sid);
		  
		  SessionDTO dates = new SessionDTO();
		  if(sessionDetails.getStatus().equals("ACCEPTED WITH NEW DATES")){
			 SessionDAO newDates = new SessionDAO();
			 dates = newDates.GetAdvisorNewDates(sid);
		  }
		  
		  
		  //Getting user details 
		  SessionDAO advisor = new SessionDAO();
		  AdvisorDTO advisorDetails= advisor.GetAdvisorDetails(sessionDetails.getAdvisorid());
		  SessionDAO user = new SessionDAO();
		  UserDetailsDTO userDetails  =user.GetUserDetails(sessionDetails.getUserid());
		  
		  
		  SessionDAO reviews = new SessionDAO();
		  ReviewsDTO review = reviews.GetReviews(sid);
		
		  request.setAttribute("sessionDetails", sessionDetails);
		   request.setAttribute("advisorDetails", advisorDetails);
		   request.setAttribute("review", review);
			  request.setAttribute("newDates", dates);
			  request.setAttribute("userDetails", userDetails);

		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminsessionviewdetails.jsp");
          rd.forward(request, response);
			}
		
		
		
		
		logger.info("Entered doGet method of AdminMyAccountSessionViewDetailsController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdminMyAccountSessionViewDetailsController");
         String sId = request.getParameter("sId");   
         String action = request.getParameter("action");
         String uid = request.getParameter("uid");
         String aid = request.getParameter("aid");
         if(action != null && action.equals("approve")){
        	 SessionDAO session = new SessionDAO();
        	 Boolean isCommit =session.UpdateStatus("PENDING APPROVAL", sId);
        	 if(isCommit){
        		 String comment = "You have got a session request";
   				String href = "approvesession?sId="+sId;
   				//Notification for Advisor
   				AdvisorNotificationDAO notify = new AdvisorNotificationDAO();
   				notify.InsertNotification(comment,aid,href); 
   				SessionDAO user = new SessionDAO();
        		UserDetailsDTO userDetails = user.GetUserName(Integer.valueOf(uid));
        		SessionDAO query = new SessionDAO();
        		SessionDAO adv = new SessionDAO();
        		AdvisorDTO advisorEmail = adv.GetAdvisorDetails(Integer.valueOf(aid));
        		SessionDTO sessionDetails =  query.GetSessionDetails(sId);
        		Properties prop = new Properties();
        		InputStream resourceAsStream = Thread.currentThread()
        				.getContextClassLoader()
        				.getResourceAsStream("ac/resources/Mail.properties");
        		prop.load(resourceAsStream);
   				String subject = "You have a new  session request.";
				String content = "Hello, <br><br>"
						+ "Someone is looking for your Advice. Following are the details:"
						+ "<br><br>"
						+ "Session Id:"+sId+""
						+ "<br>"
						+ "User Name:"+userDetails.getFullName()+""
								+ "<br>"
						+ "Query:"+sessionDetails.getQuery()+" "
								+ "<a style='text-decoration:underline; font-weight:bold' href='"+prop.getProperty("PROJECT")+"'>Click here to view the request</a><br>"
								+ "<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
				SendMail mail = new SendMail(subject, content, advisorEmail.getEmail(),prop.getProperty("MAIL_ADMIN"));
				mail.start();
        	 }
         }else if (action != null && action.equals("reject")) {
        	 SessionDAO session = new SessionDAO();
        	 Boolean isCommit = session.UpdateStatus("SESSION CANCELLED BY ADMIN", sId);
        	 if(isCommit){
        		String comment = "Your session request has been rejected by the admin";
  				String href = "usercancelledsession?sId="+sId;
  				//Notification for Admin
  				UserNotificationDAO notify = new UserNotificationDAO();
  				notify.InsertNotification(comment,href,uid); 
        	 }
        		
		}
		
		
		logger.info("Exit doPost method of AdminMyAccountSessionViewDetailsController");
	}

}
