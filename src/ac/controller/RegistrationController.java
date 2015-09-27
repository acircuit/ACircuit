package ac.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.RegistrationDAO;
import ac.dao.UserNotificationDAO;
import ac.util.PasswordHashing;
import ac.util.SendMail;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegistrationController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of RegistrationController");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("name");
		String type = request.getParameter("type");
		String updates = request.getParameter("updates");
		Properties prop = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Mail.properties");
        Properties prop1 = new Properties();
        InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
        try {
			prop.load(resourceAsStream);
			prop1.load(resourceAsStream1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if(email != null && password != null && fullname != null && type!= null){
			
        	if(type.equals("user")){
    			try {
    				String absolutePath="";
    				//Setting the image retrieved from the user to the required file location
    			    File source = new File(prop1.getProperty("DUMMY_USER_IMAGE_SOURCE_PATH"));
    			    absolutePath = MessageFormat.format(prop1.getProperty("DUMMY_USER_IMAGE_DESTINATION_PATH"), email);
    				File dest = new File(absolutePath);
    			    FileUtils.copyFile(source, dest);
    			    
    			  //Hashing the retrieved password from the user.
    				PasswordHashing securedPass = new PasswordHashing();
    				String hashPassword = securedPass.doHash(password);
    				
    				
    				//Setting the user details in the userdetails table
    				RegistrationDAO dao = new RegistrationDAO();
    				int userId = dao.setUserDetails(email,hashPassword,fullname,absolutePath,updates);
    				if(userId != 0){
    					//Inserting the wallet for the user
    					RegistrationDAO wallet = new RegistrationDAO();
    					Boolean isCommit = wallet.InsertUserWallet(userId);
    					if(isCommit){
        					
        					String comment = fullname+" signed up as a user";
        					String href = "adminuser?email="+email;
        					AdminNotificationDAO notify = new AdminNotificationDAO();
        					notify.InsertNotification(comment, href);
        					
        					
        					String userComment = "Welcome to Advisor Circuit. Find your Advisor now ! If you need any help, call us on +91 9999372087";
        					String userHref = "advisors?category=all";
        					UserNotificationDAO user = new UserNotificationDAO();
        					user.InsertNotification(userComment, userHref, String.valueOf(userId));
        					
        					
        				 	String subject ="";
        					String content ="";
        					subject = "Thank you for registering on Advisor Circuit";
        					content = "Hi, <br><br> Thank you for registering on Advisor Circuit. Please Click on the below link to activate your account:<br> <a href='"+MessageFormat.format(prop.getProperty("USER_REGISTRATION_VERIFICATION_LINK"), userId)+"'>Click Here to Activate Your Account</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        					SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
        					mail.start();
        					String subject1= "A New User Sign Up!";
        					String content1 = "Hi, <br><br> A new user has signed up with us. Following are the details: <br>Full Name : "+fullname+"<br>Email Id : " +email+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        					SendMail mail1 = new SendMail(subject1, content1, prop.getProperty("MAIL_ADMIN"),prop1.getProperty("MAIL_ADMIN"));
        					mail1.start();
        					request.getSession().setAttribute("userId",userId);
        					request.getSession().setAttribute("email", email);
        					response.sendRedirect("userdashboard?type=signup");
    					}

    				}
    				
    				
    			} catch (IOException | NoSuchAlgorithmException | NoSuchProviderException e) {
    				logger.error("doPost method of RegistrationController threw error:"+e.getMessage());
    			    e.printStackTrace();
    			}
        	}else if (type.equals("advisor")) {
        		
				try {
					  //Hashing the retrieved password from the user.
					PasswordHashing securedPass = new PasswordHashing();
					String hashPassword = securedPass.doHash(password);
					//Setting the user details in the userdetails table
    				RegistrationDAO dao = new RegistrationDAO();
    				int advisorId = dao.setAdvisorDetails(email,hashPassword,fullname,updates);
    				if(advisorId != 0){
    					String comment = fullname+" signed up as a advisor";
    					String href = "AdminViewUserProfile?email="+email;
    					AdminNotificationDAO notify = new AdminNotificationDAO();
    					notify.InsertNotification(comment, href);
    					
    				/*	String advisorComment = "Welcome to Advisor Circuit.If you need any help, call us on +91 9999372087";
    					String advisorHref = "";
    					AdvisorNotificationDAO advisor = new AdvisorNotificationDAO();
    					advisor.InsertNotification(advisorComment,String.valueOf(advisorId), advisorHref );*/
    					
    				/*	String subject ="";
    					String content ="";
    					subject = "Thank you for registering on Advisor Circuit";
    					content = "Hi, <br><br> Thank you for registering on Advisor Circuit. Please Click on the below link to activate your account:<br> <a href='"+MessageFormat.format(prop.getProperty("ADVISOR_REGISTRATION_VERIFICATION_LINK"), advisorId)+"'>Click Here to Activate Your Account</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
    					SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
    					mail.start();*/
    					String subject1= "A New Advisor Sign Up!";
    					String content1 = "Hi, <br><br> A new advisor has signed up with us. Following are the details: <br>Full Name : "+fullname+"<br>Email Id : " +email+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
    					SendMail mail1 = new SendMail(subject1, content1, prop.getProperty("MAIL_ADMIN"),prop1.getProperty("MAIL_ADMIN"));
    					mail1.start();

    					response.sendRedirect("thankyou");
    				}
				} catch (NoSuchAlgorithmException e) {
    				logger.error("doPost method of RegistrationController threw error:"+e.getMessage());
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
    				logger.error("doPost method of RegistrationController threw error:"+e.getMessage());
					e.printStackTrace();
				}
        		
			}
        }
         logger.info("Exit doPost method of RegistrationController");
	}

}
