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
import ac.dto.ProfessionalBackgroundDTO;
import ac.util.ProfessionalBackgroundObject;

/**
 * Servlet implementation class AdvisorRegistrationProfessionalBackgroundConroller
 */
@WebServlet("/AdvisorRegistrationProfessionalBackgroundConroller")
public class AdvisorRegistrationProfessionalBackgroundConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdvisorRegistrationProfessionalBackgroundConroller.class);  


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorRegistrationProfessionalBackgroundConroller");
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
			String[] company = request.getParameterValues("company[]");
			String[] designation = request.getParameterValues("designation[]");
			String[] duration = request.getParameterValues("duration[]");
			 int length = company.length;
			 String[] isCurrent = new String[length];
			 for (int i = 0; i < company.length; i++) {
				 isCurrent[i] = request.getParameter("level"+i);
			}

			String edit = request.getParameter("edit");
			//Deleting the details from advisorprofessionalbackground table
			List<ProfessionalBackgroundDTO> list = new ArrayList<ProfessionalBackgroundDTO>();
			RegistrationDAO profs = new RegistrationDAO();
			profs.DeleteProfCompany(advisorId);
			ProfessionalBackgroundObject obj = new ProfessionalBackgroundObject();
			list = obj.getProfessionalBackgroundObject(company, designation, duration,isCurrent);
			//Setting the company, designation and duration
			RegistrationDAO prof = new RegistrationDAO();
			Boolean isCommit = prof.addProfessionalBackground(list,advisorId);
			if(isCommit){
				if(edit== null){
					String status = "Skills";
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
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		
		logger.info("Entered doPost method of AdvisorRegistrationProfessionalBackgroundConroller");
	}

}
