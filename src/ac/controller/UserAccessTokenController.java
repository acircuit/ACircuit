package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.auth.AccessToken;
import com.twilio.sdk.auth.EndpointGrant;

/**
 * Servlet implementation class UserAccessTokenController
 */
@WebServlet("/UserAccessTokenController")
public class UserAccessTokenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ACCOUNT_SID = "ACb7a902d49f24767663631f500d00d212";
	public static final String SIGNINGKEY_SID = "SKaf3102a94616bc71f34d442a4470a9ee";
	public static final String SIGNINGKEY_SECRET = "ytaSHKTqVfkw3uwAuzR9ekqFzaXH37f1";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sId = request.getParameter("sid");
		name= name.replaceAll(" ", "");
		name = name.toLowerCase();
		System.out.println(name);
		AccessToken token = new AccessToken(SIGNINGKEY_SID, ACCOUNT_SID, SIGNINGKEY_SECRET);
		token.addGrant(new EndpointGrant(name));
		token.enableNTS();
		request.setAttribute("token", token.toJWT());
		request.setAttribute("sId",sId);
		RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/VideoCallUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
