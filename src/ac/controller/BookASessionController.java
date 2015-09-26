package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.BookASessionDAO;
import ac.dao.SessionDAO;
import ac.util.SendMail;
import ac.util.SetCV;

/**
 * Servlet implementation class BookASessionController
 */
@WebServlet("/BookASessionController")
@MultipartConfig
public class BookASessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BookASessionController.class);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of BookASessionController");
		String mode = request.getParameter("mode");
		String duration = request.getParameter("duration");
		String query = request.getParameter("query");
		String slot1Date = request.getParameter("slot1date");
		String slot2Date = request.getParameter("slot2date");
		String slot3Date = request.getParameter("slot3date");
		String slot1Time = request.getParameter("slot1time");
		String slot2Time = request.getParameter("slot2time");
		String slot3Time = request.getParameter("slot3time");
        String approxprice = request.getParameter("approxprice");
        String aId = request.getParameter("aId");
        String uid = request.getParameter("uid");
        String phone = request.getParameter("phone");
		int userId = 0;
		int sessionId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
        if(mode != null && duration != null && slot1Date != null && slot2Date != null
        		&& slot3Date != null && slot1Time != null && slot2Time != null && slot3Time != null && approxprice != null && query!= null
        		&& aId != null && !aId.isEmpty() && !mode.isEmpty() && !duration.isEmpty() && !query.isEmpty() && !slot1Date.isEmpty() && !slot2Date.isEmpty()
        		&& !slot3Date.isEmpty() && !slot1Time.isEmpty() && !slot2Time.isEmpty() && !slot3Time.isEmpty() && !approxprice.isEmpty()
        		){
        	if(uid != null && phone != null){
        	     //Entering the userphone number
        	     SessionDAO user = new SessionDAO();
        	     user.InsertUserPhone(phone,uid);
        	}
        	
        	// set the CV in the required folder and retrieving the absolute
			// URL
			SetCV cv = new SetCV();
			String absoluteURL = cv.putCV(request, response, userId);
        	if(absoluteURL != null && !absoluteURL.equals("")){
	        	//Inserting the session details 
	        	BookASessionDAO session = new BookASessionDAO();
	        	sessionId = session.SetSessionDetails(mode, duration,query,slot1Date,slot2Date,slot3Date,slot1Time,slot2Time,slot3Time,approxprice,aId,userId,absoluteURL);
        	}
        	if(sessionId != 0){
        	
        		
        		Properties prop = new Properties();
        		InputStream resourceAsStream = Thread.currentThread()
        				.getContextClassLoader()
        				.getResourceAsStream("ac/resources/Mail.properties");
        		prop.load(resourceAsStream);
        		String comment = "You've got a new Session request";
				String href = "adminsessionviewdetails?sId="+sessionId;
				AdminNotificationDAO admin = new AdminNotificationDAO();
				admin.InsertNotification(comment, href);
				//Send Mail to Admin
				String subject = "A new session request!";
				String content = "Hi, <br><br>A new SESSION REQUEST by the user ! Following are the details <br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
				SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
				mail.start();
        		response.sendRedirect("usersessions?session=booked");
        	}


        	
        }
        if(isError){
        	response.sendRedirect("error");
        }
		
		
		logger.info("Entered doPost method of BookASessionController");
	}

}
