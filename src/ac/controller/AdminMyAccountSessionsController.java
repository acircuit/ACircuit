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
import ac.dto.SessionDTO;

/**
 * Servlet implementation class AdminMyAccountSessionsController
 */
@WebServlet("/AdminMyAccountSessionsController")
public class AdminMyAccountSessionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountSessionsController.class); 
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountSessionsController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
				String url1 = url.toString();
				request.setAttribute("url1", url1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
		        rd.forward(request, response);
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if(isError!= null &&  !isError){
			List<SessionDTO> sessions = new ArrayList<SessionDTO>();
			AdminDAO sess = new AdminDAO();
			sessions = sess.GetSessionDetails();
			request.setAttribute("sessions",sessions);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminsessions.jsp");
	        rd.forward(request, response);
			
			
		}
		logger.info("Entered doGet method of AdminMyAccountSessionsController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
