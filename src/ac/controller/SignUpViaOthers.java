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
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorLoginDAO;
import ac.dao.RegistrationDAO;
import ac.dao.UserLoginDAO;
import ac.dao.UserNotificationDAO;
import ac.dto.AdvisorDTO;
import ac.dto.PromotionsDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;
import ac.util.PasswordHashing;
import ac.util.SendMail;

/**
 * Servlet implementation class SignUpViaOthers
 */
@WebServlet("/SignUpViaOthers")
public class SignUpViaOthers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginController.class);




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of SignUpViaOthers");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String isLogin = request.getParameter("isLogin");
		Properties prop = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Mail.properties");
        Properties prop1 = new Properties();
        InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
        Properties prop2 = new Properties();
        InputStream resourceAsStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Promotions.properties");
        try {
			prop.load(resourceAsStream);
			prop1.load(resourceAsStream1);
			prop2.load(resourceAsStream2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //Check if the email id exists
        RegistrationDAO user = new RegistrationDAO();
        UserDetailsDTO userDetails =  user.CheckEmailExistsUser(email);
        if(userDetails.getUserId() !=0){
        	HttpSession session=request.getSession();  
	        session.setAttribute("username",name); 
	        session.setAttribute("userId",userDetails.getUserId());
	        session.setAttribute("email", email);
	        GetRelativeImageURL image = new GetRelativeImageURL();
	        session.setAttribute("path", image.getImageURL(userDetails.getImage()));
	        if(userDetails.getIsVerified()){
		        session.setAttribute("isVerified", true);
	        }else{
		        session.setAttribute("isVerified", false);
	        }
	        response.getWriter().write("userlogin");
        }else{
        	
        	RegistrationDAO advisor = new RegistrationDAO();
        	AdvisorDTO adv = advisor.CheckEmailExistsAdvisor(email);
        	if(adv.getId() != 0){
        		
				if(adv.getIsActive() && adv.getIsVerified()){
					HttpSession session = request.getSession();
					session.setAttribute("username", name);
					session.setAttribute("advisorId", adv.getId());
					session.setAttribute("email", email);
					GetRelativeImageURL image = new GetRelativeImageURL();
				    session.setAttribute("path", image.getImageURL(adv.getImage()));
					request.getSession().setAttribute("isLogin",
							"advisor");
					response.getWriter().write("advisorlogin");
				}else{
					response.getWriter().write("advisorsignup");
				}
		        
        	}
        	else if (type.equals("user") && isLogin.equals("false")) {
    			try {
    				String absolutePath="";
    				//Setting the image retrieved from the user to the required file location
    			    File source = new File(prop1.getProperty("DUMMY_USER_IMAGE_SOURCE_PATH"));
    			    absolutePath = MessageFormat.format(prop1.getProperty("DUMMY_USER_IMAGE_DESTINATION_PATH"), email);
    				File dest = new File(absolutePath);
    			    FileUtils.copyFile(source, dest);
    				
    				//Setting the user details in the userdetails table
    				RegistrationDAO dao = new RegistrationDAO();
    				int userId = dao.setUserDetailsViaOthers(email,name,absolutePath);
    				if(userId != 0){
    					Boolean isCommit = false;
    					RegistrationDAO promotions = new RegistrationDAO();
    					PromotionsDTO promo = promotions.GetPromotionValidity(prop2.getProperty("PROMOTION_1"));
    					if(promo.getIsActive() != null && promo.getIsActive()){
    						//Inserting the wallet for the user
        					RegistrationDAO wallet = new RegistrationDAO();
        					isCommit = wallet.InsertUserWallet(userId,"0"); 
    						//Updating the wallet for the user
    						RegistrationDAO update = new RegistrationDAO();
    						isCommit = update.UpdateWallet(String.valueOf(userId), promo.getAmount());
    					}else{
    						//Inserting the wallet for the user
        					RegistrationDAO wallet = new RegistrationDAO();
        					isCommit = wallet.InsertUserWallet(userId,"0"); 
    					}
    					 
    				
    					
    					if(isCommit){
        					
        					String comment = name+" signed up as a user";
        					String href = "adminuser?email="+email;
        					AdminNotificationDAO notify = new AdminNotificationDAO();
        					notify.InsertNotification(comment, href);
        					
        					
        					String userComment = "Welcome to Advisor Circuit. Find your Advisor now ! If you need any help, call us on +91 9971232582";
        					String userHref = "advisors?category=all";
        					UserNotificationDAO user1 = new UserNotificationDAO();
        					user1.InsertNotification(userComment, userHref, String.valueOf(userId));
        					

        					
        					String subject2 ="";
        					String content2 ="";
        					subject2 = "Welcome to Advisor Circuit";
        					content2 = "Hi, <br><br>"
        							+ "Thank you for creating an account with us. We are thrilled to have you on board. You can now solve away all your career troubles by connecting to the right expert in the field of your choice"
        							+ "<br><br>"
        							+ "Here's a quick guide to help you get started:"
        							+ "<br><br>"
        							+ "<span style='text-decoration:underline; font-weight:bold'>1. Search our Advisors</span><br>"
        							+ "Pick your advisor depending on the category of advice – Higher Studies, different Careers and Jobs or General Questions."
        							+ "<br><br>"
        							+ "<span style='text-decoration:underline; font-weight:bold'>2. Ask Questions</span><br>"
        							+ "Post a question to any one or ALL advisors for FREE and get expert answers to your career queries"
        							+ "<br><br>"
        							+ "<span style='text-decoration:underline; font-weight:bold'>3. Take sessions</span><br>"
        							+ "Book a one on one session within seconds and get great career advice from people who have first-hand experience with the doubts that you face"
        							+ "<br><br>"
        							+ "Start exploring Advisor Circuit now! Call +91 9971232582 for any queries"
        							+ "<br><br>"
        							+ "Cheers,<br>"
        							+ "Team Advisor Circuit<br><br>"
        							+ "<img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        					SendMail mail2 = new SendMail(subject2, content2, email,prop.getProperty("MAIL_ADMIN"));
        					mail2.start();
        					
        					String subject1= "A New User Sign Up!";
        					String content1 = "Hi, <br><br> A new user has signed up with us. Following are the details: <br>Full Name : "+name+"<br>Email Id : " +email+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        					SendMail mail1 = new SendMail(subject1, content1, prop.getProperty("MAIL_ADMIN"),prop1.getProperty("MAIL_ADMIN"));
        					mail1.start();
        					request.getSession().setAttribute("userId",userId);
        					request.getSession().setAttribute("email", email);
        					  GetRelativeImageURL image = new GetRelativeImageURL();
        					 request.getSession().setAttribute("path", image.getImageURL(absolutePath));
        					 request.getSession().setAttribute("isVerified", true);
        					response.getWriter().write("usersignup");
    					}

    				}
    				
    				
    			} catch (IOException e) {
    				logger.error("doPost method of RegistrationController threw error:"+e.getMessage());
    			    e.printStackTrace();
    			}
			}else if (type.equals("advisor") && isLogin.equals("false")) {
				//Setting the user details in the userdetails table
  				RegistrationDAO dao = new RegistrationDAO();
  				int advisorId = dao.setAdvisorDetailsViaOthers(email,name);
  				if(advisorId != 0){
  					String comment = name+" signed up as a advisor";
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
  					String content1 = "Hi, <br><br> A new advisor has signed up with us. Following are the details: <br>Full Name : "+name+"<br>Email Id : " +email+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
  					SendMail mail1 = new SendMail(subject1, content1, prop.getProperty("MAIL_ADMIN"),prop1.getProperty("MAIL_ADMIN"));
  					mail1.start();

  					response.getWriter().write("advisorsignup");
  				}
			}else{
				response.getWriter().write("false");
			}
        }
		
		
		logger.info("Entered doPost method of SignUpViaOthers");
	}

}
