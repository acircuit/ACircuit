package ac.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ac.dao.AdminDAO;
import ac.util.PasswordHashing;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminLoginController.class);



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if(!username.isEmpty() && username != null  && !password.isEmpty() &&  password != null){
			PasswordHashing pass = new PasswordHashing();
			String securedPassword;
			try {
				securedPassword = pass.doHash(password);
				if(!securedPassword.isEmpty() && securedPassword != null){
					AdminDAO dao = new AdminDAO();
					Boolean isAuthenticated = dao.CheckLoginDetails(username, securedPassword);
					if(isAuthenticated){
						HttpSession session=request.getSession(); 
						session.setAttribute("admin", true);
						response.sendRedirect("adminquestions");
					}else{
						request.setAttribute("loginverificationfailed","true");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminLogin.jsp");
				        rd.forward(request, response);
					}			
				}
			} catch (NoSuchAlgorithmException e) {
	   			logger.error("doPost method of AdminLoginController threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
	   			logger.error("doPost method of AdminLoginController threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}		}

}
