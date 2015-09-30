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

import ac.dao.RegistrationDAO;
import ac.dao.SessionDAO;
import ac.dao.UserLoginDAO;
import ac.dto.PromotionsDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;

/**
 * Servlet implementation class UserVerificationLinkController
 */
@WebServlet("/UserVerificationLinkController")
public class UserVerificationLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserVerificationLinkController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of RegistrationController");
		String uId = request.getParameter("verify");
		//Verify the user
		UserLoginDAO user = new UserLoginDAO();
		 Boolean isCommit = user.UpdateUserVerification(uId,true);
		 Properties prop2 = new Properties();
	        InputStream resourceAsStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Promotions.properties");
	        try {
				prop2.load(resourceAsStream2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 if(isCommit){
			 //Getting the user email
			 SessionDAO advisor = new SessionDAO();
				UserDetailsDTO adv = advisor.GetUserDetails(Integer.valueOf(uId));
				
				RegistrationDAO promotions = new RegistrationDAO();
				PromotionsDTO promo = promotions.GetPromotionValidity(prop2.getProperty("PROMOTION_1"));
				if(promo.getIsActive() != null && promo.getIsActive()){
					//Inserting the wallet for the user
					RegistrationDAO update = new RegistrationDAO();
					isCommit = update.UpdateWallet(uId, promo.getAmount());
				}
				request.getSession().setAttribute("userId",Integer.valueOf(uId));
				request.getSession().setAttribute("email", adv.getEmail());
				GetRelativeImageURL image = new GetRelativeImageURL();
				request.getSession().setAttribute("path", image.getImageURL(adv.getImage()));

			 request.getSession().setAttribute("isVerified",true);
			 response.sendRedirect("usereditprofile?userverification=true");
		 }
		logger.info("Entered doPost method of RegistrationController");
	}

}
