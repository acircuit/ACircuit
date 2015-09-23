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
import ac.dao.PaymentDAO;
import ac.dto.SessionDTO;

/**
 * Servlet implementation class AdminMyAccountPaymentHistoryController
 */
@WebServlet("/AdminMyAccountPaymentHistoryController")
public class AdminMyAccountPaymentHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountAdvisorController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountSessionViewDetailsController");
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
				List<SessionDTO> sessions= new ArrayList<SessionDTO>();
				AdminDAO payment = new AdminDAO();
				sessions = payment.GetPaymentHistory();
				request.setAttribute("sessions", sessions);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminpaymenthistory.jsp");
		        rd.forward(request, response);
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
