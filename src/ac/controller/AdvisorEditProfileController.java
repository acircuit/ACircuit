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
import ac.dao.RegistrationDAO;
import ac.dto.AdvisorDTO;
import ac.dto.CategoryDTO;
import ac.dto.SkillsDTO;
import ac.dto.SubCategoryDTO;
import ac.util.GetRelativeImageURL;

/**
 * Servlet implementation class AdvisorEditProfileController
 */
@WebServlet("/AdvisorEditProfileController")
public class AdvisorEditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorEditProfileController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorEditProfileController");
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
			String action = request.getParameter("action");
		//Getting the general info of the Advisor
			AdvisorDTO profile = new AdvisorDTO();
			// Getting General Information of the advisor
			RegistrationDAO dao = new RegistrationDAO();
			profile = dao.GetGeneralInfo(advisorId);
			GetRelativeImageURL image = new GetRelativeImageURL();
			profile.setImage(image.getImageURL(profile.getImage())); 
			
			//Getting advisor languages
			RegistrationDAO lang = new RegistrationDAO();
			profile.setLanguage(lang.GetAdvisorLanguages(advisorId));
			
			
			//Getting advisor education
			// Getting Education Information of the advisor
			RegistrationDAO  educate = new RegistrationDAO();
			profile.setEducation(educate.GetEducationInfo(advisorId));
			
			RegistrationDAO dao3 = new RegistrationDAO();
			profile.setProfession(dao3.GetProfessionalBackground(advisorId));
			List<CategoryDTO> cat = new ArrayList<CategoryDTO>(); 
			RegistrationDAO category = new RegistrationDAO();
			cat = category.GetAdvisorCategory(advisorId);
			if(cat.size() > 0){
				List<SubCategoryDTO> subcat = new ArrayList<SubCategoryDTO>(); 
				RegistrationDAO sub = new RegistrationDAO();
				subcat  = sub.GetAdvisorSubCategory(advisorId);
				List<SkillsDTO> skill = new ArrayList<SkillsDTO>(); 
				RegistrationDAO skills = new RegistrationDAO();
				skill = skills.GetAdvisorSkills(subcat);
				for (CategoryDTO cate : cat) {
					for(SubCategoryDTO subs : subcat){
						if(cate.getCatId() == subs.getCategoryId()){
			                List<String> advSkills = new ArrayList<String>();

							for(SkillsDTO ski : skill){
								if(ski.getSubId() == subs.getId()){
									advSkills.add(ski.getSkill());
								}
								
							}
							subs.setSkills(advSkills);
							cate.setSub(subs);
						}
					}
				}
				profile.setInterests(cat);
			}
            
			
			//Getting the sub categories
			MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
			List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
			
			MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
			List<String> industrySubCategory = industry.getIndustrySubCategory();
			
			MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
			List<String> optionsSubCategory = option.getOpionsSubCategory();
			
			request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
			request.setAttribute("industrySubCategory", industrySubCategory);
			request.setAttribute("optionsSubCategory", optionsSubCategory);
			request.setAttribute("profile", profile);
			request.setAttribute("action", action);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
			rd.forward(request, response);
		
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		
		
		logger.info("Entered doGet method of AdvisorEditProfileController");
	}

}
