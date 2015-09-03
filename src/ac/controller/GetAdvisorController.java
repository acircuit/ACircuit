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

import ac.cache.MyCacheBuilder;
import ac.dao.SearchDAO;

/**
 * Servlet implementation class GetAdvisorController
 */
@WebServlet("/GetAdvisorController")
public class GetAdvisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetAdvisorController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This controller will get the list of advisors depending upon the Get Parameter
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetAdvisorController");
		String category = request.getParameter("category");
		List<Integer> list = new ArrayList<Integer>();
		if(category != null && !category.isEmpty() && category.equals("higherstudies")){
			//Fetching all the advisor Id's from category table with category as Higher Studies
			SearchDAO advisors = new SearchDAO();
			list = 	advisors.GetAdvisorsUsingCategory("higherstudies");
		}else if (category != null && !category.isEmpty() && category.equals("industry")) {
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			list = 	advisors.GetAdvisorsUsingCategory("industry");
		}else if (category != null && !category.isEmpty() && category.equals("options")) {
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			list = 	advisors.GetAdvisorsUsingCategory("options");
		}else{
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			list = 	advisors.GetAdvisorsUsingCategory("all");
		}
		MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
		List<String> industries = cache.getIndustryFilterValues();
		MyCacheBuilder cache1 = MyCacheBuilder.getCacheBuilder();
		List<String> institutions = cache1.getInstitutionsFilterValues();
		request.setAttribute("ids", list);
		request.setAttribute("industries", industries);
		request.setAttribute("institutions", institutions);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Experts.jsp");
        rd.forward(request, response);
		logger.info("Exit doPost method of GetAdvisorController");
	}
}
