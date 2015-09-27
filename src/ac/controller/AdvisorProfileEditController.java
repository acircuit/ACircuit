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

import ac.dao.RegistrationDAO;
import ac.dto.EducationDTO;
import ac.util.EducationInfoObject;

/**
 * Servlet implementation class AdvisorProfileEditController
 */
@WebServlet("/AdvisorProfileEditController")
public class AdvisorProfileEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorProfileEditController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorProfileEditController");
		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
         rd.forward(request, response);	
		
		
		logger.info("Entered doGet method of AdvisorProfileEditController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorProfileEditController");
		int advisorId = 0;
		Boolean isError =false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(advisorId != 0){
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String city = request.getParameter("city");
			String phone = request.getParameter("phone");
			String industry = request.getParameter("industry");
			String intro = request.getParameter("intro");
			String[] language = request.getParameterValues("language[]");
			String experience = request.getParameter("experience");
			String linkedIn = request.getParameter("linkedin");
			
			//Retrieving education info
			String[] course = request.getParameterValues("course[]");
			String[] institution = request.getParameterValues("institution[]");
			String[] duration = request.getParameterValues("duration[]");
			String[] type =request.getParameterValues("type[]"); 
			
			String[] organisation = request.getParameterValues("organisation[]");
			String[] designation = request.getParameterValues("designation[]");
			String[] profduration = request.getParameterValues("profduration[]");
			
			RegistrationDAO adv = new RegistrationDAO();
			Boolean isCommit =  adv.SetGeneralInfo(name,gender,age,city,phone,industry,intro,experience,linkedIn,advisorId);
			if(isCommit){
				//Creating an object for education
				//Creating Education Object to put values
	/*			List<EducationDTO> list = new ArrayList<E>();
				EducationInfoObject education = new EducationInfoObject();
				list = education.getEducationInfoObject(course, institution, duration);*/
				List<EducationDTO> list = new ArrayList<EducationDTO>();
				EducationInfoObject education = new EducationInfoObject();
				education.getEducationInfoObject(course, institution, duration,type);
				//check if 
				
				//Deleting previous education info
				
			}
		}
		if(isError){
			response.sendRedirect("error");
		}
		
		
		logger.info("Entered doGet method of AdvisorProfileEditController");
	}

}
