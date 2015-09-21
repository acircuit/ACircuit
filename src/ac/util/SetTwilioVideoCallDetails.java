package ac.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.controller.UserMyAccountAfterSessionController;
import ac.dao.SessionDAO;

/**
 * Servlet implementation class SetTwilioVideoCallDetails
 */
@WebServlet("/SetTwilioVideoCallDetails")
public class SetTwilioVideoCallDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SetTwilioVideoCallDetails.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of SetTwilioVideoCallDetails");
		Boolean isCommit = false;
		String sId = request.getParameter("sId");
		String type = request.getParameter("type");
		if(type != null && type.equals("start")){
			SessionDAO video = new SessionDAO();
			isCommit = video.SetTwilioConversationDetails(sId);
		}else{
			SessionDAO video = new SessionDAO();
			isCommit = video.SetTwilioConversationEnd(sId);
		}
		if(isCommit){
			response.getWriter().write("true");
		}
		logger.info("Exit doGet method of SetTwilioVideoCallDetails");
	}

}
