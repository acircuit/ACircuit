package ac.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.cache.MyCacheBuilder;
import ac.dto.AdvisorDTO;
import ac.dto.ProfessionalBackgroundDTO;

/**
 * Servlet implementation class AdvisorProfileController
 */
@WebServlet("/AdvisorProfileController")
public class AdvisorProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorProfileController.class);
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorProfileController");
		String aId = request.getParameter("a");
		if(aId != null){
			MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
             AdvisorDTO advisor = cache.getAdvisor(Integer.valueOf(aId));
             String currentDesignation = "";
             String currentCompany = "";
             List<ProfessionalBackgroundDTO> prof = advisor.getProfession();
             for(ProfessionalBackgroundDTO pro : prof){
            	 if(pro.getIsCurrent()){
            		 currentDesignation = pro.getDesignation();
            		 currentCompany = pro.getCompany();
            	 }
             }
             
             
     		 request.setAttribute("advisor", advisor);
     		 request.setAttribute("currentDesignation", currentDesignation);
     		 request.setAttribute("currentCompany", currentCompany);

             RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisor.jsp");
             rd.forward(request, response);
		}	
		logger.info("Entered doPost method of AdvisorProfileController");
	}
}
