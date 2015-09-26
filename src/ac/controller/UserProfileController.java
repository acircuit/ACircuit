package ac.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.RegistrationDAO;
import ac.dao.SessionDAO;
import ac.dto.UserDetailsDTO;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet("/UserProfileController")
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserProfileController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserProfileController");
		int userId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
			 SessionDAO user = new SessionDAO();
			 UserDetailsDTO userDetails = user.GetUserDetails(userId);
			 request.setAttribute("userDetails", userDetails);
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/usereditprofile");
	         rd.forward(request, response);	
			
			
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doGet method of UserProfileController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserProfileController");
		int userId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0){
			String name = request.getParameter("name");
			String male = request.getParameter("radiomale");
			String female = request.getParameter("radiofemale");
			String occupation = request.getParameter("occupation");
	        String  phone = request.getParameter("phone");
	        String gender="";
	        if(male.equals("male")){
	        	gender = "male";
	        }else{
	        	gender = "female";
	        }
	        if(name != null && occupation != null){
	        	
	        	RegistrationDAO user = new RegistrationDAO();
	        	Boolean isUpdated = user.UpdateUserProfile(name,gender,occupation,phone,userId );
	        	if(isUpdated){
	        		 request.setAttribute("profileUpdate", "true");
	    			 doGet(request, response);
	        	}
	        	
	        }
		}
		if(isError){
			response.sendRedirect("error");
		}
		
		
		logger.info("Entered doPost method of UserProfileController");
	}

}
