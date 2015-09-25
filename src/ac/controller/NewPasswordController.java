package ac.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;









import org.apache.log4j.Logger;

import ac.dao.ForgotPasswordDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;
import ac.util.PasswordHashing;

/**
 * Servlet implementation class NewPasswordController
 */
@WebServlet("/NewPasswordController")
public class NewPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(NewPasswordController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of NewPasswordController");
		String newPassword = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String id = (String) request.getParameter("id");
		String type = (String) request.getParameter("type");
		String securedPassword = "";
		Boolean isInsertComplete = false;
		if(type != null && type.equals("advisor")){
			PasswordHashing hash = new PasswordHashing();
			try {
				securedPassword = hash.doHash(newPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ForgotPasswordDAO dao = new ForgotPasswordDAO();
			isInsertComplete = dao.updateAdvisorPassword(securedPassword, id);
			if(isInsertComplete){
				SessionDAO advisor = new SessionDAO();
				AdvisorDTO adv = advisor.GetAdvisorDetails(Integer.valueOf(id));
				request.getSession().setAttribute("advisorId",Integer.valueOf(id));
				request.getSession().setAttribute("email", adv.getEmail());
				response.sendRedirect("advisordashboard");
			}

		}else if (type != null && type.equals("user")) {
			PasswordHashing hash = new PasswordHashing();
			try {
				securedPassword = hash.doHash(newPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ForgotPasswordDAO dao = new ForgotPasswordDAO();
			isInsertComplete = dao.updateUserPassword(securedPassword, id);
			if(isInsertComplete){
				SessionDAO advisor = new SessionDAO();
				UserDetailsDTO adv = advisor.GetUserDetails(Integer.valueOf(id));
				request.getSession().setAttribute("userId",Integer.valueOf(id));
				request.getSession().setAttribute("email", adv.getEmail());
				response.sendRedirect("userdashboard");
			}
		}
		
		
		
		
		logger.info("Entered doPost method of NewPasswordController");
	}

}
