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
import ac.util.PasswordHashing;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of LoginController");
		String username = request.getParameter("email");
		String password = request.getParameter("password");

			try{
				if(!username.isEmpty() && username != null  && !password.isEmpty() &&  password != null){
					
						PasswordHashing pass = new PasswordHashing();
						String securedPassword = pass.doHash(password);
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
						        if(!user.getIsActive()){
						        	
						        }else{
						        	request.getSession().setAttribute("isLogin", "user");
						        	response.sendRedirect("userdashboard");
									
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
								request.getSession().setAttribute("isLogin",
										"advisor");
					        	response.sendRedirect("advisordashboard");
							
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
