package ac.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.twilio.sdk.resource.instance.Call;

/**
 * Servlet implementation class RecordingController
 */
@WebServlet("/RecordingController")
public class RecordingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(RecordingController.class);

	public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
	public static final String AUTH_TOKEN = "906d5c7d2f78582c8958eb8f13e66d89"; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of RecordingController");

		String RecordingUrl = request.getParameter("RecordingUrl");
		//Send Mail to Admin
		String content = "Hello, <br><br>"
                       + "Recording Link:"+RecordingUrl+""
						+ "<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
		SendMail mail = new SendMail("Recording URL", content, "udaykhatry@advisorcircuit.com","udaykhatry@advisorcircuit.com");
		mail.start();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of RecordingController");

		String RecordingUrl = request.getParameter("RecordingUrl");
		String id = request.getParameter("id");
		if(id != null){
			TwilioRestClient client1 = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			 
		    // Get an object from its sid. If you do not have a sid,
		    // check out the list resource examples on this page
		    Call call1 = client1.getAccount().getCall(id);
		 // Build a filter for the CallList
		    List<NameValuePair> params = new ArrayList<NameValuePair>();
		    params.add(new BasicNameValuePair("Status", "completed"));
		    try {
		    	call1.update(params);
		    	System.out.println("updated");
			} catch (TwilioRestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else{
		//Send Mail to Admin
		String content = "Hello, <br><br>"
                       + "Recording Link:"+RecordingUrl+""
						+ "<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
		SendMail mail = new SendMail("Recording URL", content, "udaykhatry@advisorcircuit.com","udaykhatry@advisorcircuit.com");
		mail.start();
//		}
	}
	}
}


