package ac.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.SessionDTO;
import ac.dto.TimeDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetTimeLeftForSession;

/**
 * Servlet implementation class UserMyAccountCurrentSessionsController
 */
@WebServlet("/UserMyAccountCurrentSessionsController")
public class UserMyAccountCurrentSessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountCurrentSessionsController.class);
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountCurrentSessionsController");
		int userId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0){
			  String sid = request.getParameter("sId");
			  UserDetailsDTO userDetails = new UserDetailsDTO();
			  //Getting the session details for the page
			  SessionDAO session = new SessionDAO();
			  SessionDTO sessionDetails= session.GetSessionDetails(sid);
			  if(sessionDetails.getAcceptedDate() != null){
				  String accDate = sdf.format(sessionDetails.getAcceptedDate());
				  String time = sessionDetails.getAcceptedTime();
				  String timestamp = accDate+" "+ time+":00";
				  Timestamp ts = Timestamp.valueOf(timestamp);
				  GetTimeLeftForSession  time1 = new GetTimeLeftForSession();
			      TimeDTO left = time1.getTimeLeftForSession(ts);
			      sessionDetails.setHours(String.format("%02d", left.getHours()));
			      sessionDetails.setDays(String.format("%02d", left.getDay()));
			      sessionDetails.setMinutes(String.format("%02d", left.getMinutes()));
			  }
			
			  //Getting user details 
			  SessionDAO advisor = new SessionDAO();
			  AdvisorDTO advisorDetails= advisor.GetAdvisorDetails(sessionDetails.getAdvisorid());
			  if(sessionDetails.getMode().equals("phone")){
				  advisorPhone = advisorDetails.getPhoneNo();
                  //Retrieving the user phone number
				  SessionDAO phone = new SessionDAO();
				  userDetails = phone.GetUserDetails(userId);
			  }
			  //Getting wallet details
			  SessionDAO user = new SessionDAO();
			  double amount = user.GetWalletDetails(userId);
			  request.setAttribute("sessionDetails", sessionDetails);
			  request.setAttribute("advisorDetails", advisorDetails);
			  request.setAttribute("userDetails", userDetails);
			  request.setAttribute("advisorPhone", advisorPhone);
			  request.setAttribute("wallet", amount);
			  request.setAttribute("userId", userId);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/usercurrentsession.jsp");
	          rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Exit doGet method of UserMyAccountCurrentSessionsController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserMyAccountCurrentSessionsController");
			  String sid = request.getParameter("sId");
			  String cost = request.getParameter("cost");
			  String duration = request.getParameter("duration");
			  String uId = request.getParameter("uId");
			  String admin = request.getParameter("admin");
			  Boolean isSessionDetailsUdated = false;
			  //Updating the user wallet
			  SessionDAO wallet = new SessionDAO();
			  Boolean isUpdated = wallet.UpdateWallet(uId,cost);
			  if(isUpdated){
				//Updating the session details
				  SessionDAO session = new SessionDAO();
				  isSessionDetailsUdated = session.UpdateSessionDetails(cost,duration,sid);
			  }
			  if(isSessionDetailsUdated){
				  if(admin != null && admin.equals("true")){
					  response.sendRedirect("adminsessions");
					  
				  }else{
					  response.sendRedirect("useraftersession?sId="+sid);
					  
				  }
			  }
		logger.info("Entered doPost method of UserMyAccountCurrentSessionsController");
	}

}
