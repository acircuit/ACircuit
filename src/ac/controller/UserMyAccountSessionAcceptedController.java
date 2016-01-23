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
import ac.dto.AdvisorDTO;
import ac.dto.SessionDTO;

/**
 * Servlet implementation class UserMyAccountSessionAcceptedController
 */
@WebServlet("/UserMyAccountSessionAcceptedController")
public class UserMyAccountSessionAcceptedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountSessionAcceptedController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountSessionAcceptedController");
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
			System.out.println(userId);
			  String sid = request.getParameter("sId");
			  //Getting the session details for the page
			  SessionDAO session = new SessionDAO();
			  SessionDTO sessionDetails= session.GetSessionDetails(sid);
			
			  //Getting user details 
			  SessionDAO advisor = new SessionDAO();
			  AdvisorDTO advisorDetails= advisor.GetAdvisorDetails(sessionDetails.getAdvisorid());
			  SessionDTO dates = new SessionDTO();
			  if(sessionDetails.getStatus().equals("ACCEPTED WITH NEW DATES")){
				 SessionDAO newDates = new SessionDAO();
				 dates = newDates.GetAdvisorNewDates(sid);
			  }
			  //Getting wallet details
			  SessionDAO user = new SessionDAO();
			  double amount = user.GetWalletDetails(userId);
			  
			  request.setAttribute("sessionDetails", sessionDetails);
			  request.setAttribute("advisorDetails", advisorDetails);
			  request.setAttribute("newDates", dates);
			  request.setAttribute("wallet", amount);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/approve.jsp");
	          rd.forward(request, response);
		}
		
		if(isError){
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/approve.jsp");
	        rd.forward(request, response);
		}
		
		logger.info("Entered doGet method of UserMyAccountSessionAcceptedController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason =  request.getParameter("reason");
		String sId =  request.getParameter("sid");
		Boolean isStatusCommit = false;
        //Inserting the reason of cancelling the session
		SessionDAO reject = new SessionDAO();
		Boolean isCommit = reject.InsertRejectionReason(sId,reason);
		//Updating the status of the session 
		if(isCommit){
			SessionDAO status = new SessionDAO();
			isStatusCommit = status.UpdateStatus("SESSION CANCELLED BY USER",sId);
		}
		SessionDAO id = new SessionDAO();
		int advId = id.GetAdvisorId(sId);
		if(isStatusCommit){
			//Notify advisor
			String advisorComment = "We're sorry but the User has declined the session. You will get a mail regarding this soon.";
			String advisorHref = "advisorcancelledsession?sId="+sId;
			AdvisorNotificationDAO advisor = new AdvisorNotificationDAO();
			advisor.InsertNotification(advisorComment, String.valueOf(advId), advisorHref);
			response.sendRedirect("usercancelledsession?sId="+sId);
		}
	}

}
