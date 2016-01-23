package ac.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.PaymentDAO;
import ac.dao.SessionDAO;
import ac.dto.SessionDTO;

/**
 * Servlet implementation class AdvisorMyAccountPaymentHistroryController
 */
@WebServlet("/AdvisorMyAccountPaymentHistroryController")
public class AdvisorMyAccountPaymentHistroryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountPaymentHistroryController.class);

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountPaymentHistroryController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
			List<SessionDTO> payments = new ArrayList<SessionDTO>();
			PaymentDAO payment = new PaymentDAO();
			payments = payment.GetAdvisorPaymentHistory(advisorId);
			for(SessionDTO pay : payments){
				  String price =  pay.getSessionPrice();
				  DecimalFormat decim = new DecimalFormat("#.##");
				  Double price1 = Double.valueOf(price) * 5 /6;
				  pay.setSessionPrice(decim.format(price1));
			}
			request.setAttribute("payments", payments);
			System.out.println(payments.size());
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorpaymenthistory.jsp");
	        rd.forward(request, response);
		}
		if(isError){
		
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorpaymenthistory.jsp");
	        rd.forward(request, response);
		}
		logger.info("Exit doGet method of AdvisorMyAccountPaymentHistroryController");
	}

}
