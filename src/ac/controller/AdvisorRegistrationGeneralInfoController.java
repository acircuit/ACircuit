package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.RegistrationDAO;
import ac.util.SetFormImage;

/**
 * Servlet implementation class AdvisorRegistrationGeneralInfoController
 */
@WebServlet("/AdvisorRegistrationGeneralInfoController")
@MultipartConfig
public class AdvisorRegistrationGeneralInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdvisorRegistrationGeneralInfoController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorRegistrationGeneralInfoController");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String industry = request.getParameter("industry");
		String[] language_Known = request.getParameterValues("language[]");
		String exp = request.getParameter("experience");
		String linkedin_Profile_Link = request.getParameter("linkedin");
		String intro = request.getParameter("intro");
		String edit = request.getParameter("edit");
		String email = "";
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
			 email = (String) request.getSession().getAttribute("email");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
			try {
				if (name != null && gender != null && age != null && city != null
						&& phone != null && industry != null 
						&& language_Known != null && exp != null 
						 && intro != null && !name.isEmpty() 
						&& !gender.isEmpty() && !age.isEmpty() && !city.isEmpty()
						&& !phone.isEmpty() &&  !industry.isEmpty()
						
						&& !intro.isEmpty() && !exp.isEmpty()) {
					String url = "";
					    //Checking if there is an image to upload 
						//Calling util method which will put the image in the required folder.
					    if(request.getPart("file") != null){
					    	SetFormImage image = new SetFormImage();
							url = image.putImage(request, response, email,"ADVISOR");
					     }
					
						
						
						Boolean isGeneralInfoCommit = false;
						// Calling DAO to put the values into table
						RegistrationDAO dao = new RegistrationDAO();
						isGeneralInfoCommit = dao.SetGeneralInfo(name, gender, age, city, phone, industry, intro, exp, linkedin_Profile_Link, advisorId, url, edit);
						if (isGeneralInfoCommit) {
							Boolean isLanguageCommit = false;
							//Deleting previous languages and inserting new
							RegistrationDAO lang = new RegistrationDAO();
							Boolean isDeleted = lang.RemoveLanguages(advisorId);
							if(isDeleted){
								if(language_Known.length > 0){
									//Enter Advisor languages
									RegistrationDAO insert = new RegistrationDAO();
									isLanguageCommit = insert.InsertAdvisorLanguages(advisorId,language_Known);
									
								}
								if(edit== null){
									String status = "EducationInfo";
									//Change the Registration Status in advisorregistrationprofiledetails table
									RegistrationDAO dao1 = new RegistrationDAO();	
									Boolean isRegistrationStatusCommit = dao1.setRegistrationStatus(advisorId, status);
									if(isRegistrationStatusCommit){
										response.sendRedirect("profile?action=create");
									}
								}else{
									response.sendRedirect("profile");
								}

							}
							
						}
				}
				logger.info("Exit doPost method of AdvisorRegistrationGeneralInfoControler");
			} catch (Exception e) {
				logger.error("doPost method of AdvisorRegistrationGeneralInfoControler threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
			
		}
		if(isError){
			response.sendRedirect("profile");
		}
		
		
		logger.info("Entered doPost method of AdvisorRegistrationGeneralInfoController");
	}

}
