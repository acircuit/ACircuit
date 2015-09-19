package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.PaymentDAO;

/**
 * Servlet implementation class UserMyAccountPaymentHistroryController
 */
@WebServlet("/UserMyAccountPaymentHistroryController")
public class UserMyAccountPaymentHistroryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountPaymentHistroryController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountPaymentHistroryController");
		int userId = 0;
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		if(userId != 0){
			//Getting the user Payment history
			PaymentDAO payment = new PaymentDAO();
			payment.GetPaymentHistory(userId);
			request.setAttribute("userId", userId);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/userwallet.jsp");
	        rd.forward(request, response);
		}
		
		logger.info("Entered doGet method of UserMyAccountPaymentHistroryController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserMyAccountPaymentHistroryController");
		

		
		logger.info("Entered doPost method of UserMyAccountPaymentHistroryController");
	}

}
