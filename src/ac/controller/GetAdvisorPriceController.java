package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.SessionDAO;

/**
 * Servlet implementation class GetAdvisorPriceController
 */
@WebServlet("/GetAdvisorPriceController")
public class GetAdvisorPriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetAdvisorPriceController.class);
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of GetAdvisorPriceController");
		String advisorId = request.getParameter("advisorId");
		String duration = request.getParameter("duration");
		String isPhone = request.getParameter("isPhone");
		String isVideo = request.getParameter("isVideo");
		Double price =0.0;
		SessionDAO advPrice = new SessionDAO();
		Double[] prices = advPrice.GetAdvisorPrices(advisorId);
		if(isPhone != null && isPhone.equals("phone")){
			price = prices[0] * Double.valueOf(duration);
		}else if (isVideo != null && isVideo.equals("video")) {
			price = prices[1] * Double.valueOf(duration);
		}
		response.getWriter().write(String.valueOf(price));
		logger.info("Entered doGet method of GetAdvisorPriceController");
	}

}
