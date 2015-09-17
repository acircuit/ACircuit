package ac.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.list.CallList;



import ac.controller.UserMyAccountCurrentSessionsController;
import ac.dao.SessionDAO;
import ac.dto.CostDTO;

/**
 * Servlet implementation class ClickToCall
 */
@WebServlet("/ClickToCall")
public class ClickToCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ClickToCall.class);
	public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
	public static final String AUTH_TOKEN = "906d5c7d2f78582c8958eb8f13e66d89"; 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of ClickToCall");
		String sId = request.getParameter("sId");
		String mode = request.getParameter("mode");
		String userPhone = request.getParameter("user");
		String advisorPhone = request.getParameter("advisor");
		Properties prop = new Properties();
	    InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
	    prop.load(resourceAsStream1);
	    if(mode != null){
	    	int totalDuration =0;
			SessionDAO dao = new SessionDAO();
			List<CostDTO> costs = dao.GetDuration(sId);
			for(CostDTO cost :costs){
				if(cost.getAdvisorTime() >= cost.getUserTime() ){
					totalDuration = totalDuration + cost.getUserTime(); 
				}else if (cost.getAdvisorTime() < cost.getUserTime()) {
					totalDuration = totalDuration + cost.getAdvisorTime(); 
				}
			}
			//Getting the advisor id
			SessionDAO advisor = new SessionDAO();
			int advId = advisor.GetAdvisorId(sId);
			SessionDAO price = new SessionDAO();
			Double advPrice = price.GetAdvisorPrice(advId, mode);
			int durationInMinutes = totalDuration / 60;
			int remainder = totalDuration % 60;
			if(remainder != 0){
				durationInMinutes = durationInMinutes +1;
			}
			Double totalCost = advPrice * durationInMinutes;
			response.getWriter().write(String.valueOf(durationInMinutes)+":" +String.valueOf(advPrice)+":"+String.valueOf(totalCost));
	    }else{

	    	 TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	 	    TwilioRestClient client1 = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	 		Call call = null;
	 	    Call call1 = null;
	 		    // Build a filter for the CallList
	 		    List<NameValuePair> params = new ArrayList<NameValuePair>();
	 		    params.add(new BasicNameValuePair("Url", prop.getProperty("CONFERENCE_XML_URL")));
	 		    params.add(new BasicNameValuePair("To","+91" +userPhone));
	 		    params.add(new BasicNameValuePair("From","+13368037448"));
	 		    params.add(new BasicNameValuePair("StatusCallback",prop.getProperty("STATUSCALLBACK_URL_USER")));
	 		    params.add(new BasicNameValuePair("StatusCallbackEvent", "ringing"));
	 		    params.add(new BasicNameValuePair("StatusCallbackEvent", "answered"));
	             params.add(new BasicNameValuePair("StatusCallbackEvent", "completed"));
	 		    
	 		    
	 		    // Build a filter for the CallList
	 		    List<NameValuePair> params1 = new ArrayList<NameValuePair>();
	 		    params1.add(new BasicNameValuePair("Url", prop.getProperty("CONFERENCE_XML_URL")));
	 		    params1.add(new BasicNameValuePair("To","+91"+ advisorPhone));
	 		    params1.add(new BasicNameValuePair("From","+13368037448"));
	 		    params1.add(new BasicNameValuePair("StatusCallback",prop.getProperty("STATUSCALLBACK_URL_ADVISOR")));	
	 		    params.add(new BasicNameValuePair("StatusCallbackEvent", "ringing"));
	 		    params.add(new BasicNameValuePair("StatusCallbackEvent", "answered"));
	 		    params.add(new BasicNameValuePair("StatusCallbackEvent", "completed"));

	 		    CallFactory callFactory = client.getAccount().getCallFactory();
	 			try {
	 				call = callFactory.create(params);
	 			} catch (TwilioRestException e) {
	 				logger.error("doPost method of ClickToCall threw error:"+e.getMessage());
	 				e.printStackTrace();
	 			}
	 			CallFactory callFactory1 = client1.getAccount().getCallFactory();
	 			try {
	 				call1 = callFactory1.create(params1);
	 			} catch (TwilioRestException e) {
	 				logger.error("doPost method of ClickToCall threw error:"+e.getMessage());
	 				e.printStackTrace();
	 			}
	 			
	 			SessionDAO  dao = new SessionDAO();
	 			dao.UpdateCallSid(call.getSid(),call1.getSid(),sId);
	    }
	   
		
		logger.info("Entered doPost method of ClickToCall");
	}

}
