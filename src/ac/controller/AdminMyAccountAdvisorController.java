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
import ac.dao.AdminDAO;
import ac.dao.CacheDAO;
import ac.dao.RegistrationDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AdvisorSkillsDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SkillsDTO;
import ac.dto.SubCategoryDTO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;

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
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
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
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if(isError!= null &&  !isError){
			String advisorId = request.getParameter("advisorId");
			String action = request.getParameter("action");
			Boolean isCommit = false;
			if(action.equals("deactivate")){
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateAdvisorIsActive(false,advisorId);
			}else if (action.equals("activate")) {
				AdminDAO update = new AdminDAO();
				isCommit = update.UpdateAdvisorIsActive(true,advisorId);
			}else if (action.equals("show")) {
				
				AdvisorDTO profile = new AdvisorDTO();
				// Getting General Information of the advisor
				RegistrationDAO dao = new RegistrationDAO();
				profile = dao.GetGeneralInfo(Integer.valueOf(advisorId));
				GetRelativeImageURL image = new GetRelativeImageURL();
				profile.setImage(image.getImageURL(profile.getImage())); 
				
				//Getting advisor languages
				RegistrationDAO lang = new RegistrationDAO();
				profile.setLanguages(lang.GetAdvisorLanguages(Integer.valueOf(advisorId)));
				
				
				//Getting advisor education
				// Getting Education Information of the advisor
				RegistrationDAO  educate = new RegistrationDAO();
				profile.setEducation(educate.GetEducationInfo(Integer.valueOf(advisorId)));
				
				RegistrationDAO dao3 = new RegistrationDAO();
				profile.setProfession(dao3.GetProfessionalBackground(Integer.valueOf(advisorId)));
				List<CategoryDTO> cat = new ArrayList<CategoryDTO>(); 
				RegistrationDAO category = new RegistrationDAO();
				cat = category.GetAdvisorCategory(Integer.valueOf(advisorId));
				List<SubCategoryDTO> subcat = new ArrayList<SubCategoryDTO>(); 
				RegistrationDAO sub = new RegistrationDAO();
				subcat  = sub.GetAdvisorSubCategory(Integer.valueOf(advisorId));
				List<AdvisorSkillsDTO> skill = new ArrayList<AdvisorSkillsDTO>(); 
				AdminDAO skills = new AdminDAO();
				skill = skills.GetAdvisorSkills(subcat);
				profile.setCategories(cat);
				profile.setSubCategories(subcat);
				profile.setSkills(skill);
				MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
				cache.addAdvisor(profile);
				//Checking if the subcategory alread exists

				
				
				//Now update keyword column
				String keyword="";
				keyword = keyword + profile.getName().toLowerCase()+",";
				keyword = keyword + profile.getIndustry().toLowerCase()+",";
				for(EducationDTO edu : profile.getEducation()){
					keyword = keyword + edu.getCourse().toLowerCase()+",";
					keyword = keyword + edu.getInstitution().toLowerCase()+",";
				}
				for(ProfessionalBackgroundDTO  prof : profile.getProfession()){
					keyword = keyword + prof.getCompany().toLowerCase()+",";
					keyword = keyword + prof.getDesignation().toLowerCase()+",";
				}
				List<String> higher = null;
				List<String> industry = null;
				List<String> options = null;
				MyCacheBuilder cache1 = MyCacheBuilder.getCacheBuilder();
                higher =  cache1.getHigherStudiesSubCategory();
                MyCacheBuilder cache2 = MyCacheBuilder.getCacheBuilder();
                industry =  cache2.getIndustrySubCategory();
                MyCacheBuilder cache3 = MyCacheBuilder.getCacheBuilder();
                options =  cache3.getOpionsSubCategory();
				for(CategoryDTO cate : profile.getCategories()){
					keyword = keyword + cate.getCategory().toLowerCase()+",";
					for(SubCategoryDTO subc : profile.getSubCategories()){
						keyword = keyword + subc.getSubCategory().toLowerCase()+",";
						if(subc.getCategoryId() == cate.getCatId()){
							AdminDAO check = new AdminDAO();
							String subcats = check.CheckSubCategory(cate.getCategory(),subc.getSubCategory());
							if(subcats == ""){
								AdminDAO insert = new AdminDAO();
								insert.InsertSubCategory(cate.getCategory(),subc.getSubCategory());
								if(cat.equals("studies")){
                    				higher.add(subc.getSubCategory());
                    			}else if (cat.equals("options")) {
                    				options.add(subc.getSubCategory());
                    			}else{
                    				industry.add(subc.getSubCategory());
                    			}
							}
						}
						
						
					}
				}
				if(higher != null && industry != null && options != null){
					MyCacheBuilder cache4= MyCacheBuilder.getCacheBuilder();
					cache4.addSubCategories(higher, industry, options);
				}
				List<String> institutions = new ArrayList<String>();
				CacheDAO institute = new CacheDAO();
				institutions = institute.GetAdvisorInstitutions();
				
				//Getting all industries from the advisordetails table
				List<String> industries = new ArrayList<String>();
				CacheDAO industry1 = new CacheDAO();
				industries = industry1.GetIndustries();
				
				//Getting all languages from the advisorlanguage table
				List<String> languages = new ArrayList<String>();
				CacheDAO languag = new CacheDAO();
				languages = languag.GetLanguages();
				MyCacheBuilder cache5= MyCacheBuilder.getCacheBuilder();

				cache5.addFilters(institutions, industries,languages); 
				
				
				AdminDAO words = new AdminDAO();
				Boolean isCommit1 =  words.SetAdvisorKeywords(keyword,advisorId);
				if(isCommit1){
					AdminDAO visible = new AdminDAO();
					visible.UpdateAdvisorVisibility(true,advisorId);
				}
				
			
			}else if (action.equals("hide")) {
				AdminDAO visible = new AdminDAO();
				visible.UpdateAdvisorVisibility(false,advisorId);
			}else if (action.equals("setprice")) {
				String price = request.getParameter("price");
				AdminDAO prices = new AdminDAO();
				prices.UpdatePrice(price,advisorId);
			}
			
		}
		logger.info("Entered doPost method of AdminMyAccountAdvisorController");
	}

		
}

