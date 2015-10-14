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
import ac.dto.RefundDTO;
import ac.dto.SessionDTO;

/**
 * Servlet implementation class AdminRefundController
 */
@WebServlet("/AdminRefundController")
public class AdminRefundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminRefundController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminRefundController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				
				isError = true;
				StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
				String url1 = url.toString();
				request.setAttribute("url1", url1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
		        rd.forward(request, response);
			}
		if(isError!= null &&  !isError){
	   		List<RefundDTO> list = new ArrayList<RefundDTO>();
			AdminDAO refund = new AdminDAO();
			list = refund.GetUserRefunds();
			request.setAttribute("list", list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminrefunds.jsp");
	        rd.forward(request, response);
			
		}
		logger.info("Entered doGet method of AdminRefundController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
