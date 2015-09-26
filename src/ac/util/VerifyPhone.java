package ac.util;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.resource.list.MessageList;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * Servlet implementation class VerifyPhone
 */
@WebServlet("/VerifyPhone")
public class VerifyPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
	public static final String AUTH_TOKEN = "906d5c7d2f78582c8958eb8f13e66d89";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String uid = request.getParameter("uid");
		System.out.println(phone);
		RechargeIdGenerator gen = new RechargeIdGenerator();
		long code = gen.vergen();
        String verificationCode = String.valueOf(code);
        verificationCode = verificationCode + uid;
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		 
	    // Build a filter for the MessageList
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("Body", "Your verification code is"+verificationCode));
	    params.add(new BasicNameValuePair("To", "+91" +phone));
	    params.add(new BasicNameValuePair("From", "+13368037448"));
	     
	     
	    MessageFactory messageFactory = client.getAccount().getMessageFactory();
	    Message message;
		try {
			message = messageFactory.create(params);
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(verificationCode);
	}

}
