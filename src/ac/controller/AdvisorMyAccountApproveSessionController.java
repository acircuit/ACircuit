package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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
import ac.util.GetRelativeImageURL;
import ac.util.SendMail;

/**
 * Servlet implementation class AdvisorMyAccountApproveSessionController
 */
@WebServlet("/AdvisorMyAccountApproveSessionController")
public class AdvisorMyAccountApproveSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountApproveSessionController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountApproveSessionController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
		  String sid = request.getParameter("sId");
		  //Getting the session details for the page
		  SessionDAO session = new SessionDAO();
		  SessionDTO sessionDetails= session.GetSessionDetails(sid);
		  //Getting user details 
		  SessionDAO user = new SessionDAO();
		  UserDetailsDTO userDetails= user.GetUserDetails(sessionDetails.getUserid());
		  GetRelativeImageURL image = new GetRelativeImageURL();
		  userDetails.setImage(image.getImageURL(userDetails.getImage()));
		  request.setAttribute("sessionDetails", sessionDetails);
		   request.setAttribute("userDetails", userDetails);
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorrequestviewdetails.jsp");
          rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("error");
		}
		
		logger.info("Entered doGet method of AdvisorMyAccountApproveSessionController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorMyAccountApproveSessionController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
          String sessionId = request.getParameter("sId");
          String userId = request.getParameter("uid");
          String reason= request.getParameter("reason");
          String sessionPlan = request.getParameter("sessionplan");
          String date1 = request.getParameter("newdate1");
          String date2 = request.getParameter("newdate2");
          String time1 = request.getParameter("newtime1");
          String time2 = request.getParameter("newtime2");
          String acceptedDateTime = request.getParameter("date1");
          String[] dateTime = null ;
          String acceptedDate="";
          String acceptedTime=""; 
          sessionPlan = sessionPlan.replaceAll("\r\n", "");
          sessionPlan = sessionPlan.replaceAll("\r", "");
          sessionPlan = sessionPlan.replaceAll("\n", "");
          if(acceptedDateTime != null){
           dateTime = acceptedDateTime.split("::");
           acceptedDate = dateTime[0];
           acceptedTime = dateTime[1];
          }

          Boolean isNewDatesCommit = false;
          if(sessionPlan != null && sessionId != null){
        	 if(date1 != null && date2 != null  && time1 != null && time2 != null
        			 && !date1.equals("") && !date2.equals("") && !time1.equals("") && !time2.equals("")){
        		 //insert the new dates proposed by the advisor
        		 SessionDAO newDates  = new SessionDAO();
        		 isNewDatesCommit = newDates.InsertNewDates(sessionId,date1,date2,time1,time2);
        	 }
          //Update the sessionplan
             SessionDAO session = new SessionDAO();
             Boolean isCommit = session.UpdateSessionPlan(sessionId,sessionPlan,isNewDatesCommit,acceptedDate,acceptedTime);
          if(isCommit){
        	  if(isNewDatesCommit){
          		//Notify the user 
  				String comment = "Your request has been accepted by the Advisor with revised dates! Choose 1 date and Recharge your wallet.";
  				String href = "useracceptsession?sId="+sessionId;
  				UserNotificationDAO userNotification = new UserNotificationDAO();
  				userNotification.InsertNotification(comment, href, userId);
  		   	    String comment1 = "Advisor accepted the session with revised dates";
				String ahref = "adminsessions?sid="+sessionId;
				//Notify Admin
				AdminNotificationDAO notify = new AdminNotificationDAO();
				notify.InsertNotification(comment1, ahref);
				Properties prop = new Properties();
        		InputStream resourceAsStream = Thread.currentThread()
        				.getContextClassLoader()
        				.getResourceAsStream("ac/resources/Mail.properties");
        		prop.load(resourceAsStream);
				//Send Mail to Admin
				String subject = "Advisor accepted the session with revised dates!";
				String content = "Hi, <br><br>Advisor accepted the session with revised dates <br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
				SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
				mail.start();
				SessionDAO adv = new SessionDAO();
				String name = adv.GetAdvisorName(advisorId);
				SessionDAO user = new SessionDAO();
				UserDetailsDTO userDetails = user.GetUserDetails(Integer.valueOf(userId));
			
				String subject4 = "Your session request has been accepted by the advisor.";
				String content4 = "Hello, <br><br>"
						+ "Your session has been accepted!  However, the advisor was not comfortable with your dates so he’s sent you three of his own choice. He’s also sent across a session plan to help you understand how the session will be conducted."
						+ "<br><br>"
						+ "You can now accept the session with one of the advisor’s dates or cancel the session."
						+ "<br><br>"
						+ "Advisor Name:"+name+""
								+ "<br>"
						+ "Reply:"+sessionPlan+""
						+ "Session Plan : "+sessionPlan+""
						+ "<br><br>"
						+ "<a style='text-decoration:underline; font-weight:bold' href='"+prop.getProperty("PROJECT")+"/useracceptsession?sId="+sessionId+"'>Click here to view details and confirm session</a><br><br>"
						+ "<span style='text-decoration:underline; font-weight:bold'>Remember this session will lapse if you fail to pay within 48 Hours.</span><br><br>"
						+ "Please reach out to us for any doubts or clarifications!<br><br>"
						+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
								+ "<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
					SendMail mail1 = new SendMail(subject4, content4, userDetails.getEmail(),prop.getProperty("MAIL_ADMIN"));
					mail1.start();
          	    response.sendRedirect("advisorcurrentsession?sId="+sessionId+"&action=newdates");
          	    
       
        	  }else{
        		//Notify the user 
  				String comment = "Your request has been accepted by the Advisor! Recharge your wallet.";
  				String href = "useracceptsession?sId="+sessionId;
  				UserNotificationDAO userNotification = new UserNotificationDAO();
  				userNotification.InsertNotification(comment, href, userId);
  				
  			    String comment1 = "Advisor accepted the session";
				String ahref = "adminsessions?sid="+sessionId;
				//Notify Admin
				AdminNotificationDAO notify = new AdminNotificationDAO();
				notify.InsertNotification(comment1, ahref);
				
				Properties prop = new Properties();
        		InputStream resourceAsStream = Thread.currentThread()
        				.getContextClassLoader()
        				.getResourceAsStream("ac/resources/Mail.properties");
        		prop.load(resourceAsStream);
				//Send Mail to Admin
				String subject = "Advisor accepted the session!";
				String content = "Hi, <br><br>Advisor accepted the session.<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
				SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
				mail.start();
				
				SessionDAO user = new SessionDAO();
				UserDetailsDTO userDetails = user.GetUserDetails(Integer.valueOf(userId));
				
				SessionDAO adv = new SessionDAO();
				String name = adv.GetAdvisorName(advisorId);
				String subject4 = "Your session request has been accepted by the advisor.";
				String content4 = "Hello, <br><br>"
						+ "Your session request to "+name+" has been accepted!"
						+ "<br><br>"
						+ "To understand how the session will be conducted, the advisor has sent you a session plan. Please recharge your wallet with the minimum amount in order to confirm the session. "
						+ "<br><br>"
						+ "Advisor Name:"+name+""
								+ "<br>"
						+ "Accepted Date and Time:"+acceptedDate+","+acceptedTime+"<br>"
						+ "Session Plan : "+sessionPlan+""
						+ "<br><br>"
						+ "<span style='text-decoration:underline; font-weight:bold'>Remember this session will lapse if you fail to pay within 48 Hours.</span><br><br>"
						+ "<a style='text-decoration:underline; font-weight:bold' href='"+prop.getProperty("PROJECT")+"/useracceptsession?sId="+sessionId+"'>Click here to confirm the Session</a><br><br>"
						+ "Feel free to reach us if you have any questions!<br><br>"
						+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
								+ "<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
					SendMail mail1 = new SendMail(subject4, content4, userDetails.getEmail(),prop.getProperty("MAIL_ADMIN"));
					mail1.start();
  				
          	    response.sendRedirect("advisorcurrentsession?sId="+sessionId);
        	  }
        		
          }
         }else{
        	 //Session is rejected
        	 //Updating the session status
        	 SessionDAO update = new SessionDAO();
        	 Boolean isCommit = update.UpdateStatus("SESSION CANCELLED BY ADVISOR", sessionId);
        	 Boolean isReasonCommit = false;
             if(isCommit){
            	 //Inserting the rejection reason
            	 SessionDAO reject = new SessionDAO();
            	 isReasonCommit = reject.InsertRejectionReason(sessionId, reason);
             }
             if(isReasonCommit){
 				//Notify the user 
 				String comment = "We're sorry but the Advisor has declined the session. You will get a mail regarding this soon.";
 				String href = "usercancelledsession?sId="+sessionId;
 				UserNotificationDAO userNotification = new UserNotificationDAO();
 				userNotification.InsertNotification(comment, href, userId);
            	 response.sendRedirect("advisorcancelledsession?sId="+sessionId);
             }
        	 
         }
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doPost method of AdvisorMyAccountApproveSessionController");
	}

}
