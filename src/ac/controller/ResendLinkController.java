package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.util.SendMail;

/**
 * Servlet implementation class ResendLinkController
 */
@WebServlet("/ResendLinkController")
public class ResendLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ResendLinkController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of ResendLinkController");
		String resendLink = request.getParameter("resendLink");
		String id = request.getParameter("id");
        System.out.println(resendLink);
		Properties prop = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Mail.properties");
        try {
			prop.load(resourceAsStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String subject ="";
		String content ="";
		subject = "Thank you for registering on Advisor Circuit";
		content = "Hi, <br><br> Thank you for registering on Advisor Circuit. Please Click on the link below to activate your account:<br> <a href='"+prop.getProperty("USER_REGISTRATION_VERIFICATION_LINK")+id+"'>Click Here to Activate Your Account</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
		SendMail mail = new SendMail(subject, content, resendLink,prop.getProperty("MAIL_ADMIN"));
		mail.start();
		response.getWriter().write("true");
		
		
		
		
		logger.info("Exit doPost method of ResendLinkController");
	}

}
