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
 * Servlet implementation class AdvisorRegistrationEducationInfoController
 */
@WebServlet("/AdvisorRegistrationEducationInfoController")
public class AdvisorRegistrationEducationInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdvisorRegistrationEducationInfoController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorRegistrationEducationInfoController");
		int advisorId = 0;
		Boolean isError = false;
		String email = "";
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
			 email = (String) request.getSession().getAttribute("email");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
			//We are first retreiving the values from the form
			String[] course = request.getParameterValues("course[]");
			String[] institution = request.getParameterValues("institution[]");
			String[] duration = request.getParameterValues("duration[]");
			/*String[] type = request.getParameterValues("type[]");*/
			 int length = course.length;
			 String[] type = new String[length];
			 for (int i = 0; i < course.length; i++) {
				 type[i] = request.getParameter("type"+i);
			}

			String edit = request.getParameter("edit");
			List<EducationDTO> education = new ArrayList<EducationDTO>();
			// Deleting the Education Details
			RegistrationDAO deledu = new RegistrationDAO();
			Boolean isDeleted = deledu.DeleteEducation(advisorId);
			if(isDeleted){
				EducationInfoObject educate = new EducationInfoObject();
				education = educate.getEducationInfoObject(course, institution, duration,type);
			}
			// Calling DAO to put the values into table
			RegistrationDAO dao = new RegistrationDAO();
			Boolean isEducationInfoCommit = dao.setEducationInfo(education,advisorId);
			if (isEducationInfoCommit && edit== null ) {
				// Changing the status of the Advisor To
				// ProfessionalBackground.jsp
				RegistrationDAO status = new RegistrationDAO();
				Boolean isStatusCommit = status.setRegistrationStatus(advisorId,"ProfessionalBackground");
				if (isStatusCommit) {
					response.sendRedirect("profile?action=create");
				}
			} else {
				response.sendRedirect("profile");
			}
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		
		
		logger.info("Entered doPost method of AdvisorRegistrationEducationInfoController");
	}

}
