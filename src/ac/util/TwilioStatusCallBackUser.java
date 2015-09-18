package ac.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.controller.GetAdvisorController;
import ac.dao.SessionDAO;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Call;







import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
/**
 * Servlet implementation class TwilioStatusCallBackUser
 */
@WebServlet("/TwilioStatusCallBackUser")
public class TwilioStatusCallBackUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TwilioStatusCallBackUser.class);
	// Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
	  public static final String AUTH_TOKEN = "906d5c7d2f78582c8958eb8f13e66d89"; 
      

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetAdvisorController");
		String callDuration = request.getParameter("CallDuration");
		String callStatus = request.getParameter("CallStatus");
		String callSid = request.getParameter("CallSid");
		//String recording = request.getParameter("RecordingUrl");
		//Get the call sid of the advisor call and terminate that call
		SessionDAO dao = new SessionDAO();
		String advisorCallSid = dao.GetAdvisorCallSid(callSid);
		if(callStatus.equals("in-progress")){
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			 
		    // Get an object from its sid. If you do not have a sid,
		    // check out the list resource examples on this page
		    Call call = client.getAccount().getCall(advisorCallSid);
		    if(call.getStatus().equals("busy") || call.getStatus().equals("failed") || call.getStatus().equals("no-answer")){
		    	TwilioRestClient client1 = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
				 
			    // Get an object from its sid. If you do not have a sid,
			    // check out the list resource examples on this page
			    Call call1 = client1.getAccount().getCall(callSid);
			 // Build a filter for the CallList
			    List<NameValuePair> params = new ArrayList<NameValuePair>();
			    params.add(new BasicNameValuePair("Status", "completed"));
			    try {
					call.update(params);
				} catch (TwilioRestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    SessionDAO dao1 = new SessionDAO();
			    dao1.UpdateCallStatus(callDuration,callStatus,call.getStatus(),call.getDuration(),callSid);
		    }else{
		    	SessionDAO dao1 = new SessionDAO();
				dao1.UpdateDuration(callDuration,"user",callSid,callStatus);
		    }
		}else if (callStatus.equals("busy") || callStatus.equals("failed") || callStatus.equals("no-answer")) {
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		    // Get an object from its sid. If you do not have a sid,
		    // check out the list resource examples on this page
		    Call call = client.getAccount().getCall(advisorCallSid);
		    // Build a filter for the CallList
		    List<NameValuePair> params = new ArrayList<NameValuePair>();
		    params.add(new BasicNameValuePair("Status", "completed"));
		    try {
				call.update(params);
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    SessionDAO dao1 = new SessionDAO();
		    dao1.UpdateCallStatus(callDuration,callStatus,call.getStatus(),call.getDuration(),callSid);
			}else if (callStatus.equals("completed")){
			SessionDAO dao1 = new SessionDAO();
			dao1.UpdateDuration(callDuration,"user",callSid,callStatus);
		}
		logger.info("Entered doPost method of GetAdvisorController");
	}

}