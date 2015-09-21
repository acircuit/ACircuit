package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.SessionDAO;
import ac.dao.UserNotificationDAO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;

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
		
		  request.setAttribute("sessionDetails", sessionDetails);
		   request.setAttribute("userDetails", userDetails);
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorrequestviewdetails.jsp");
          rd.forward(request, response);
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
  				String comment = "Your request has been accepted by the Advisor with revised dates! Choose 1 date and Pay to confirm the session";
  				String href = "useracceptsession?sId="+sessionId;
  				UserNotificationDAO userNotification = new UserNotificationDAO();
  				userNotification.InsertNotification(comment, href, userId);
          	    response.sendRedirect("advisorcurrentsession?sId="+sessionId+"&action=newdates");
        	  }else{
        		//Notify the user 
  				String comment = "Your request has been accepted by the Advisor! Pay to confirm the session";
  				String href = "useracceptsession?sId="+sessionId;
  				UserNotificationDAO userNotification = new UserNotificationDAO();
  				userNotification.InsertNotification(comment, href, userId);
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
		logger.info("Entered doPost method of AdvisorMyAccountApproveSessionController");
	}

}
