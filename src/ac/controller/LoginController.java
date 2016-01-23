package ac.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ac.dao.AdvisorLoginDAO;
import ac.dao.UserLoginDAO;
import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;
import ac.util.PasswordHashing;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of LoginController");
        String email = request.getParameter("email");
        //Check if the email id exists
        UserLoginDAO user = new UserLoginDAO();
        int userid =  user.CheckEmailExistsUser(email);
        if(userid !=0){
        	response.getWriter().write("true");
        }else{
        	
        	AdvisorLoginDAO advisor = new AdvisorLoginDAO();
        	int advisorid = advisor.CheckEmailExistsAdvisor(email);
        	if(advisorid != 0){
        		response.getWriter().write("true");
        	}else{
        		response.getWriter().write("false");
        	}
        }
		
		
		logger.info("Entered doGet method of LoginController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of LoginController");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		System.out.println(url);
		logger.info(username + password);
			try{
				if(!username.isEmpty() && username != null  && !password.isEmpty() &&  password != null){
					
						PasswordHashing pass = new PasswordHashing();
						String securedPassword = pass.doHash(password);
						System.out.println(securedPassword);
						if(!securedPassword.isEmpty() && securedPassword != null){
							UserLoginDAO dao = new UserLoginDAO();
							UserDetailsDTO user= dao.CheckLoginDetails(username, securedPassword);
							if(user.getUserId() != 0 && user.getFullName() != null){
								int uId = user.getUserId();
								String userName = user.getFullName();
								HttpSession session=request.getSession();  
						        session.setAttribute("username",userName); 
						        session.setAttribute("userId",uId);
						        session.setAttribute("email", username);
						        GetRelativeImageURL image = new GetRelativeImageURL();
						        session.setAttribute("path", image.getImageURL(user.getImage()));
						        if(user.getIsVerified()){
							        session.setAttribute("isVerified", true);
						        }else{
							        session.setAttribute("isVerified", false);
						        }
						        if(url != null && !url.equals("")){
						        	if(url.indexOf("null") != -1){
						        		url=url.substring(0, url.indexOf("null") - 1);
						        	}
						        	response.getWriter().write(url); 
						        }else{
						        	response.getWriter().write("advisors?category=all");

						        }
						        
							}else{
							AdvisorDTO advisor = new AdvisorDTO();
							AdvisorLoginDAO dao1 = new AdvisorLoginDAO();
							advisor = dao1.CheckLoginDetails(username, securedPassword);
							if (advisor.getId() != 0 && advisor.getName() != null && advisor.getIsActive() != null
									&& advisor.getIsVerified() != null && advisor.getIsActive() && advisor.getIsVerified()) {
								int aId = advisor.getId();
								String userName = advisor.getName();
								HttpSession session = request.getSession();
								session.setAttribute("username", userName);
								session.setAttribute("advisorId", aId);
								session.setAttribute("email", username);
								GetRelativeImageURL image = new GetRelativeImageURL();
							    session.setAttribute("path", image.getImageURL(advisor.getImage()));
								request.getSession().setAttribute("isLogin",
										"advisor");
								 if(url != null && !url.equals("")){
							        	response.getWriter().write(url); 
							        }else{
										response.getWriter().write("advisors?category=all");

							        }
							
							}else{
								response.getWriter().write("invalid");
							}
						}
					}
				}
				logger.info("Exit doPost method of LoginController");	
		   		}catch(NoSuchAlgorithmException | NoSuchProviderException e){
		   			logger.error("doPost method of LoginController threw error:"+e.getMessage());
					e.printStackTrace();
				}catch(Exception e){
				   	  logger.error("doPost method of LoginController threw error:"+e.getMessage());
				      e.printStackTrace();
			   }
	}
}
