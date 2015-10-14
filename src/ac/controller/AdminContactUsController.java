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
import ac.dao.AdminNotificationDAO;
import ac.dto.ContactUsDTO;

/**
 * Servlet implementation class AdminContactUsController
 */
@WebServlet("/AdminContactUsController")
public class AdminContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminContactUsController.class); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminContactUsController");
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
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		if(isError!= null &&  !isError){
			//Getting the Contact us details
			List<ContactUsDTO> contactList = new ArrayList<ContactUsDTO>();
			AdminDAO contact = new AdminDAO();
			contactList = contact.GetContactUsDetails();
			
			//Update Admin's Notification
    		String url =  request.getRequestURI();
			url = url.substring(url.lastIndexOf('/')+1);
		/*	AdminNotificationDAO admin = new AdminNotificationDAO();
			admin.SetNotificationRead(url);*/
			
			request.setAttribute("contactList",contactList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admincontactus.jsp");
	        rd.forward(request, response);
		}
		
		logger.info("Exit doGet method of AdminContactUsController");
	}
}
