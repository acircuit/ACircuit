package ac.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
		logger.info("Entered doPost method of AdvisorProfileController");
		int userId = 0;
		int advisorId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0 || advisorId != 0){
		String category = request.getParameter("category");
		List<Integer> list = new ArrayList<Integer>();
		String ids = "";
		if(category != null && !category.isEmpty() && category.equals("higherstudies")){
			//Fetching all the advisor Id's from category table with category as Higher Studies
			SearchDAO advisors = new SearchDAO();
			ids = 	advisors.GetAdvisorsUsingCategory("higherstudies");
		}else if (category != null && !category.isEmpty() && category.equals("industry")) {
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			ids = 	advisors.GetAdvisorsUsingCategory("industry");
		}else if (category != null && !category.isEmpty() && category.equals("options")) {
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			ids = 	advisors.GetAdvisorsUsingCategory("options");
		}else{
			//Fetching all the advisor Id's from category table with category as industry
			SearchDAO advisors = new SearchDAO();
			ids = 	advisors.GetAdvisorsUsingCategory("all");
		}
		MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
		List<String> industries = cache.getIndustryFilterValues();
		MyCacheBuilder cache1 = MyCacheBuilder.getCacheBuilder();
		List<String> institutions = cache1.getInstitutionsFilterValues();
		MyCacheBuilder lang = MyCacheBuilder.getCacheBuilder();
		List<String> languages = cache1.getLanguagesFilterValues();
        
		
		//Getting the sub categories
		MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
		List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
		
		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
		List<String> industrySubCategory = industry.getIndustrySubCategory();
		
		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
		List<String> optionsSubCategory = option.getOpionsSubCategory();
		
		System.out.println("higher" + higherStudiesSubCategory.size());
		System.out.println("industry" + industrySubCategory.size());
		System.out.println("options" + optionsSubCategory.size());

		request.setAttribute("ids", ids);
		request.setAttribute("industries", industries);
		request.setAttribute("institutions", institutions);
		request.setAttribute("languages", languages);
		request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
		request.setAttribute("industrySubCategory", industrySubCategory);
		request.setAttribute("optionsSubCategory", optionsSubCategory);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Experts.jsp");
        rd.forward(request, response);
		}else{
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			/*url = url.substring(url.lastIndexOf('/')+1);*/
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		logger.info("Exit doPost method of GetAdvisorController");
	}
}
