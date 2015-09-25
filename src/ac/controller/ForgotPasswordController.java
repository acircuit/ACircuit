package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.ForgotPasswordDAO;
import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;
import ac.util.SendMail;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);
 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of ForgotPasswordController");
		String email = request.getParameter("email");
		ForgotPasswordDAO forgot = new ForgotPasswordDAO();
		UserDetailsDTO user = forgot.GetUserDetails(email);
		int userId = 0;
		int advisorId =0;
		Properties prop = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Mail.properties");
        try {
			prop.load(resourceAsStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user.getUserId() != 0 && user.getEmail() != null){
			userId = user.getUserId();
			ForgotPasswordDAO dao = new ForgotPasswordDAO();
			Timestamp time = dao.getUserTimestamp(String.valueOf(user.getUserId()));
			Date date1=null;
			if(time != null){
				Calendar c = Calendar.getInstance();
				c.setTime(new Date(time.getTime()));
				c.add(Calendar.DATE, 1);
				Date date = c.getTime();
				Calendar mbCal = new GregorianCalendar(
						TimeZone.getTimeZone("IST"));
				mbCal.setTimeInMillis(new Date().getTime());
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));
				cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));
				cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));
				cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));
				cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
				date1 = cal.getTime();
				int comparision = date1.compareTo(date);
				if (comparision > 0) {
					//Deactivate the row
					ForgotPasswordDAO deactivate = new ForgotPasswordDAO();
					Boolean isCommit =deactivate.UpdateUserForgotPassword(user.getUserId(),false);
					if(isCommit){
						ForgotPasswordDAO dao1 = new ForgotPasswordDAO();
						Boolean isInsertComplete = dao1.setForgotPasswordDetails(userId, email);
						if(isInsertComplete){
						    String url = prop.getProperty("USER_FORGOT_PASSWORD_MAIL_URL")+userId;
							String subject ="Forgot Password";
							String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href='"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
							SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
							mail.start();	
							response.getWriter().write("true");
						}
					}
				}else{
					//update the timestamp
					ForgotPasswordDAO update = new ForgotPasswordDAO();
					Boolean isCommit =update.UpdateUserForgotPasswordTimestamp(user.getUserId());
					if(isCommit){
					    String url = prop.getProperty("USER_FORGOT_PASSWORD_MAIL_URL")+userId;
						String subject ="Forgot Password";
						String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href='"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
						SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
						mail.start();	
						response.getWriter().write("true");
					}
				}
			}else{
				ForgotPasswordDAO dao1 = new ForgotPasswordDAO();
				Boolean isInsertComplete = dao1.setForgotPasswordDetails(userId, email);
				if(isInsertComplete){
				    String url = prop.getProperty("USER_FORGOT_PASSWORD_MAIL_URL")+userId;
					String subject ="Forgot Password";
					String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href='"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
					SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
					mail.start();	
					response.getWriter().write("true");
				}
			}


			

		}else{
			ForgotPasswordDAO forgot1 = new ForgotPasswordDAO();
            AdvisorDTO advisor = forgot1.GetAdvisorDetails(email);
            if(advisor.getId() != 0 && advisor.getEmail() != null){
            	advisorId = advisor.getId();
            	ForgotPasswordDAO dao = new ForgotPasswordDAO();
    			Timestamp time = dao.getAdvisorTimestamp(String.valueOf(advisor.getId()));
    			if(time != null){
        			Calendar c = Calendar.getInstance();
        			c.setTime(new Date(time.getTime()));
        			c.add(Calendar.DATE, 1);
        			Date date = c.getTime();
        			Calendar mbCal = new GregorianCalendar(
        					TimeZone.getTimeZone("IST"));
        			mbCal.setTimeInMillis(new Date().getTime());
        			Calendar cal = Calendar.getInstance();
        			cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));
        			cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));
        			cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));
        			cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));
        			cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));
        			cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));
        			cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
        			Date date1 = cal.getTime();
        			int comparision = date1.compareTo(date);
        			if (comparision > 0) {
        				//Deactivate the row
        				ForgotPasswordDAO deactivate = new ForgotPasswordDAO();
        				Boolean isCommit =deactivate.UpdateAdvisorForgotPassword(advisor.getId(),false);
        				if(isCommit){
        	            	ForgotPasswordDAO insert = new ForgotPasswordDAO();
        	            	Boolean isInsertComplete = insert.setForgotPasswordDetailsAdvisor(advisorId, email);
        	    			if(isInsertComplete){
        	    				String url = prop.getProperty("ADVISOR_FORGOT_PASSWORD_MAIL_URL")+advisorId;
        						String subject ="Forgot Password";
        						String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href= '"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        						SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
        						mail.start();		
        	    				response.getWriter().write("true");
        	    			}
        				}
        			}else{
        				//update the timestamp
        				ForgotPasswordDAO update = new ForgotPasswordDAO();
        				Boolean isCommit =update.UpdateAdvisorForgotPasswordTimestamp(advisorId);
        				if(isCommit){
        				    String url = prop.getProperty("ADVISOR_FORGOT_PASSWORD_MAIL_URL")+advisorId;
        					String subject ="Forgot Password";
        					String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href='"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
        					SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
        					mail.start();	
        					response.getWriter().write("true");
        				}
        			}
    			}else{
    				//update the timestamp
    				ForgotPasswordDAO insert = new ForgotPasswordDAO();
	            	Boolean isInsertComplete = insert.setForgotPasswordDetailsAdvisor(advisorId, email);
    				if(isInsertComplete){
    				    String url = prop.getProperty("ADVISOR_FORGOT_PASSWORD_MAIL_URL")+userId;
    					String subject ="Forgot Password";
    					String content ="Hi, <br><br>Please Click on the below link to set your New Password: <br><a href='"+url+"'>Click Here To Set New Password</a>"+"<br><img src=\"https://www.advisorcircuit.com/Test/assets/img/logo_black.png\" style='float:right' width='15%'>";
    					SendMail mail = new SendMail(subject, content, email,prop.getProperty("MAIL_ADMIN"));
    					mail.start();	
    					response.getWriter().write("true");
    				}
    			}

            	
            	
            	

            }else{
            	response.getWriter().write("invalid");
            }
			
		}

		
		logger.info("Entered doPost method of ForgotPasswordController");
	}

}
