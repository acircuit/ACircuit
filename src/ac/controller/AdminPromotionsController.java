package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminDAO;
import ac.dto.PromotionsDTO;

/**
 * Servlet implementation class AdminPromotionsController
 */
@WebServlet("/AdminPromotionsController")
public class AdminPromotionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminPromotionsController.class);
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminPromotionsController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				response.sendRedirect("error");
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			response.sendRedirect("error");
		}
		if(isError!= null &&  !isError){
	   		List<PromotionsDTO> list = new ArrayList<PromotionsDTO>();
			AdminDAO promo = new AdminDAO();
			list = promo.GetPromotions();
			
			request.setAttribute("promotions", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminpromotions.jsp");
	        rd.forward(request, response);
			
		}
		logger.info("Entered doGet method of AdminPromotionsController");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdminPromotionsController");
		String promoId = request.getParameter("promoId");
		String action = request.getParameter("action");
		String amount = request.getParameter("amount");
		Boolean isCommit = false;
		if(amount != null){
			AdminDAO update = new AdminDAO();
			isCommit = update.UpdateAmount(promoId,amount);
		}else{
			if(action.equals("deactivate")){
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdatePromotionIsActive(false,promoId);
			}else{
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdatePromotionIsActive(true,promoId);
			}
		}
		logger.info("Entered doPost method of AdminPromotionsController");
	}

}
