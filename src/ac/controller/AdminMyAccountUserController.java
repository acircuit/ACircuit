package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminDAO;
import ac.dto.UserDetailsDTO;

public class AdminMyAccountUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountUserController.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountUserController");
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
		    List<UserDetailsDTO> list = new ArrayList<UserDetailsDTO>();
			//Getting all the user details
			AdminDAO user = new AdminDAO();
			list = user.GetUserDetails();
			System.out.println(list.size());
			request.setAttribute("userDetails",list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminusers.jsp");
	        rd.forward(request, response);
		}

		logger.info("Exit doGet method of AdminMyAccountUserController");

    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdminMyAccountUserController");
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
			String userId = request.getParameter("userId");
			String action = request.getParameter("action");
			Boolean isCommit = false;
			if(action.equals("deactivate")){
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateUserIsActive(false,userId);
			}else{
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateUserIsActive(true,userId);
			}
			
			
		}
		
		logger.info("Entered doPost method of AdminMyAccountUserController");
		
	}

}


