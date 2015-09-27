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
import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;

@WebServlet("/AdminMyAccountAdvisorController")

public class AdminMyAccountAdvisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountAdvisorController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountAdvisorController");
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
				List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
				//Getting all the Advisor details
				AdminDAO adv = new AdminDAO();
				list = adv.GetAdvisorDetails();
				request.setAttribute("advisorDetails",list);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminadvisors.jsp");
		        rd.forward(request, response);
		}
				
			logger.info("Exit doGet method of AdminMyAccountAdvisorController");

}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdminMyAccountAdvisorController");
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
			String advisorId = request.getParameter("advisorId");
			String action = request.getParameter("action");
			Boolean isCommit = false;
			if(action.equals("deactivate")){
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateAdvisorIsActive(false,advisorId);
			}else{
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateAdvisorIsActive(true,advisorId);
			}
		}
		logger.info("Entered doPost method of AdminMyAccountAdvisorController");
	}

		
}

