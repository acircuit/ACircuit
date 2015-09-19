package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.util.RechargeIdGenerator;

/**
 * Servlet implementation class UserRechargeController
 */
@WebServlet("/UserRechargeController")
public class UserRechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserRechargeController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountPaymentHistroryController");
		String amount = request.getParameter("amount");
		String merchant_param1 = request.getParameter("merchant_param1");
		String merchant_param2 = request.getParameter("merchant_param2");

		RechargeIdGenerator generate = new RechargeIdGenerator();
		int id =generate.gen();
		if(merchant_param2 != null){
		     response.sendRedirect("payment?order_id="+id+"&amount="+amount+"&merchant_param1="+merchant_param1+"&merchant_param2=recharge");
		}else{
			 response.sendRedirect("payment?order_id="+id+"&amount="+amount+"&merchant_param1="+merchant_param1);
		}
		logger.info("Exit doGet method of UserMyAccountPaymentHistroryController");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserMyAccountPaymentHistroryController");
		String amount = request.getParameter("amount");
		String merchant_param1 = request.getParameter("merchant_param1");
		String merchant_param2 = request.getParameter("merchant_param2");
		RechargeIdGenerator generate = new RechargeIdGenerator();
		int id =generate.gen();
		if(merchant_param2 != null){
		     response.sendRedirect("payment?order_id="+id+"&amount="+amount+"&merchant_param1="+merchant_param1+"&merchant_param2=recharge");
		}else{
			 response.sendRedirect("payment?order_id="+id+"&amount="+amount+"&merchant_param1="+merchant_param1);
		}
		logger.info("Exit doPost method of UserMyAccountPaymentHistroryController");
	}

}
