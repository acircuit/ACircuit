package ac.controller;

import java.io.IOException;

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
         if(action != null && action.equals("approve")){
        	 SessionDAO session = new SessionDAO();
        	 session.UpdateStatus("PENDING APPROVAL", sId);
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
