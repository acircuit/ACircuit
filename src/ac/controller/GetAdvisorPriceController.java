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
		Double finalPrice= 0.0;
		SessionDAO advPrice = new SessionDAO();
		Double[] prices = advPrice.GetAdvisorPrices(advisorId);
		if(isPhone != null && isPhone.equals("phone")){
			Double commisionedPrice  = prices[0]  +( prices[0]  * 20 /100);
			finalPrice = commisionedPrice / 60;
            finalPrice = finalPrice * Double.valueOf(duration);		
		}else if (isVideo != null && isVideo.equals("video")) {
			Double commisionedPrice  = prices[1]  +( prices[1]  * 20 /100);
			finalPrice = commisionedPrice / 60;
            finalPrice = finalPrice * Double.valueOf(duration);	
		}
		response.getWriter().write(String.valueOf(finalPrice));
		logger.info("Entered doGet method of GetAdvisorPriceController");
	}

}
