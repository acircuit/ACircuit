package ac.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import com.twilio.sdk.client.TwilioCapability;
 
public class TwilioServlet extends HttpServlet {
 
    public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
    public static final String AUTH_TOKEN = "906d5c7d2f78582c8958eb8f13e66d89";
 
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        // This is a special Quickstart application sid - or configure your own
        // at twilio.com/user/account/apps
        String applicationSid = "AP80e23f22595a2a57d550da9e4967a5a8";
 
        TwilioCapability capability = new TwilioCapability(ACCOUNT_SID, AUTH_TOKEN);
        capability.allowClientOutgoing(applicationSid);
 
        String token = null;
        try {
            token = capability.generateToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Forward the token information to a JSP view
        response.setContentType("text/html");
        request.setAttribute("token", token);
        RequestDispatcher view = request.getRequestDispatcher("client.jsp");
        view.forward(request, response);
    }
}
