package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.BookASessionDAO;
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
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
        if(mode != null && duration != null && slot1Date != null && slot2Date != null
        		&& slot3Date != null && slot1Time != null && slot2Time != null && slot3Time != null && approxprice != null 
        		&& aId != null && !aId.isEmpty() && !mode.isEmpty() && !duration.isEmpty() && !query.isEmpty() && !slot1Date.isEmpty() && !slot2Date.isEmpty()
        		&& !slot3Date.isEmpty() && !slot1Time.isEmpty() && !slot2Time.isEmpty() && !slot3Time.isEmpty() && !approxprice.isEmpty()
        		){
        	
        	// set the CV in the required folder and retrieving the absolute
			// URL
			SetCV cv = new SetCV();
			String absoluteURL = cv.putCV(request, response, userId);
        	if(absoluteURL != null && !absoluteURL.equals("")){
	        	//Inserting the session details 
	        	BookASessionDAO session = new BookASessionDAO();
	        	int sessionId = session.SetSessionDetails(mode, duration,query,slot1Date,slot2Date,slot3Date,slot1Time,slot2Time,slot3Time,approxprice,aId,userId,absoluteURL);
        	}
        	


        	
        }
        if(isError){
        	response.sendRedirect("error");
        }
		
		
		logger.info("Entered doPost method of BookASessionController");
	}

}
