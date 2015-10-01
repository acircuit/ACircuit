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
import ac.util.GetRelativeImageURL;
import ac.util.GetTimeLeftForSession;

/**
 * Servlet implementation class AdvisorMyAccountCurrentSessionController
 */
@WebServlet("/AdvisorMyAccountCurrentSessionController")
public class AdvisorMyAccountCurrentSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountCurrentSessionController.class);
  


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountCurrentSessionController");
		int advisorId = 0;
		Boolean isError =false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(advisorId != 0){
			  String sid = request.getParameter("sId");
			  String action = request.getParameter("action");
			  //Getting the session details for the page
			  SessionDAO session = new SessionDAO();
			  SessionDTO sessionDetails= session.GetSessionDetails(sid);
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
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
			  SessionDAO user = new SessionDAO();
			  UserDetailsDTO userDetails= user.GetUserDetails(sessionDetails.getUserid());
			  GetRelativeImageURL image = new GetRelativeImageURL();
			  userDetails.setImage(image.getImageURL(userDetails.getImage()));
			  SessionDTO dates= null;
			  if(sessionDetails.getStatus().equals("ACCEPTED WITH NEW DATES")){
				  SessionDAO newDates = new SessionDAO();
				  dates = newDates.GetAdvisorNewDates(sid); 
			  }
			  SessionDAO advisor = new SessionDAO();
			  String advName  = advisor.GetAdvisorName(advisorId);
			
			  request.setAttribute("sessionDetails", sessionDetails);
			   request.setAttribute("userDetails", userDetails);
			   request.setAttribute("newdates", dates);
			   request.setAttribute("advName", advName);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorcurrentsession.jsp");
	          rd.forward(request, response);
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doGet method of AdvisorMyAccountCurrentSessionController");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
