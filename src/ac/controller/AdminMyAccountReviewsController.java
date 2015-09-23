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
import ac.dao.FeedDAO;
import ac.dto.ReviewsDTO;

/**
 * Servlet implementation class AdminMyAccountReviewsController
 */
@WebServlet("/AdminMyAccountReviewsController")
public class AdminMyAccountReviewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountReviewsController.class);
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
		Boolean isError = false;
		Boolean isAdmin = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				response.sendRedirect("Error");
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			response.sendRedirect("Error");
		}
		if(isError!= null &&  !isError){
	         List<ReviewsDTO> reviews=  new ArrayList<ReviewsDTO>();
			AdminDAO review = new AdminDAO();
			reviews = review.GetReviews();
			request.setAttribute("reviews", reviews);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminreviews.jsp");
	        rd.forward(request, response);
			
		}
		
		logger.info("Exit doGet method of AdminMyAccountReviewsController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				response.sendRedirect("Error");
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			response.sendRedirect("Error");
		}
		if(isError!= null &&  !isError){
			String sessionId = request.getParameter("sessionId");
			String action = request.getParameter("action");
			if(action.equals("approve")){
				
				AdminDAO update = new AdminDAO();
				update.UpdateReviewsStatus(sessionId,"APPROVED");
			}else{
				AdminDAO update = new AdminDAO();
				update.UpdateReviewsStatus(sessionId,"REJECTED");
			}
	    }
		logger.info("Entered doGet method of AdminMyAccountReviewsController");
	}
}
