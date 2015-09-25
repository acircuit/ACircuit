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
		}else{
			ForgotPasswordDAO forgot1 = new ForgotPasswordDAO();
            AdvisorDTO advisor = forgot1.GetAdvisorDetails(email);
            if(advisor.getId() != 0 && advisor.getEmail() != null){
            	advisorId = advisor.getId();
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
			
		}

		
		logger.info("Entered doPost method of ForgotPasswordController");
	}

}
