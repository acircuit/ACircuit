package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ac.cache.MyCacheBuilder;
import ac.dto.AdvisorDTO;
import ac.dto.AdvisorLanguageDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SubCategoryDTO;

/**
 * Servlet implementation class FilterController
 */
@WebServlet("/FilterController")
public class FilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FilterController.class);
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of FilterController");
		String filterString = request.getParameter("filterString");
		String ids = request.getParameter("ids");
		String category = request.getParameter("category");
		String paging = request.getParameter("paging");
		int startIndex = 1;
		int endIndex = 10;
		String[] initialAdvisors = null;
		if(paging != null){
			int page = Integer.valueOf(paging);

			startIndex = 11+ (page-1)*6;
            endIndex = startIndex +5;
		}
		
		
		
		//Getting a list of advisor id
		String[] advisorIds = ids.split(":");
		String q="";
		int threshold=0;
		Boolean institution = false;
		Boolean industry = false;
		Boolean language = false;
		//Setting the threshold of advisors
		String[] filters = filterString.split("::");
		String[] filterType = null;
		String[] myarray = new String[filters.length * 2];
		int k=0;
		for(String fil : filters){
			filterType = fil.split(":");
			myarray[k] = filterType[0];
			k++;
			myarray[k] = filterType[1];
			k++;
			if(filterType[0].indexOf("college") != -1){
				institution = true;
			}else if (filterType[0].indexOf("industry") != -1) {
				industry = true;
			}else if (filterType[0].indexOf("language") != -1) {
				language = true;
			}
		}
		if(institution){
			threshold++;
		}
		if(industry){
			threshold++;
		}
		if(language){
			threshold++;
		}
		int count=1;
		Boolean isLeft = false;
		//Getting the advisors object from Cache
		  JSONArray array = new JSONArray();
		for(String aid : advisorIds){
			MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
			AdvisorDTO advisor = cache.getAdvisor(Integer.valueOf(aid));
			int advThreshold = 0;
			int advCollege = 0;
			int advIndus = 0;
			int advLang = 0;
			List<EducationDTO> education = new ArrayList<EducationDTO>();
			education = advisor.getEducation();
			String indus = advisor.getIndustry();
			List<AdvisorLanguageDTO> language1 = advisor.getLanguage();
			for(int i=0;i<myarray.length;i++){
				if(myarray[i].equals("college")){
					for(EducationDTO edu : education){
						if(edu.getInstitution().equals(myarray[i+1])){
							advCollege++;
						}
					}
				}else if (myarray[i].equals("industry") && indus.equals(myarray[i+1])) {
					advIndus++;
				}else if (myarray[i].equals("language")) {
					for(AdvisorLanguageDTO lan : language1){
						if(lan.getLanguage().equals(myarray[i+1])){
							advLang++;
						}
					}
				}
			}
			if(advIndus > 0){
				advThreshold++;
			}
			if(advCollege > 0){
				advThreshold++;
			}
			if(advLang > 0){
				advThreshold++;
			}
			if( advThreshold != 0 && advThreshold >= threshold){
				if(count >= startIndex && count <=endIndex) {
				JSONObject jo = new JSONObject();
				jo.put("name", advisor.getName());
				jo.put("id",advisor.getId());
				List<CategoryDTO> list = advisor.getCategories();
				int catId =0;
				if(category.equals("higherstudies")){
					for(CategoryDTO cat : list){
						if(cat.getCategory().equals("studies")){
							catId = cat.getCatId();
						}
					}
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId){
							jo.put("subcategory", sub.getSubCategory());
						}
					}
      			}else if (category.equals("industry")) {
      				for(CategoryDTO cat : list){
						if(cat.getCategory().equals("industry")){
							catId = cat.getCatId();
						}
					}
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId){
							jo.put("subcategory", sub.getSubCategory());
						}
					}
				}else if (category.equals("options")) {
					for(CategoryDTO cat : list){
							catId = cat.getCatId();
					}
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId){
							jo.put("subcategory", sub.getSubCategory());
						}
					}
				}
				List<EducationDTO> education1 = advisor.getEducation();
				int ed=0;
				for(EducationDTO educ : education1){
					if(educ.getType().equals("pg") && educ.getInstitution() != null){
						jo.put("institution", educ.getInstitution());
						ed++;
					}
				}
				if(ed == 0){
					for(EducationDTO educ : education1){
						if(educ.getType().equals("ug") && educ.getInstitution() != null){
							jo.put("institution", educ.getInstitution());
							ed++;
						}
					}
				}
				List<ProfessionalBackgroundDTO> profession= advisor.getProfession();
				for(ProfessionalBackgroundDTO prof : profession){
					if(prof.getIsCurrent() && prof.getDesignation() != null && prof.getCompany() != null){
						jo.put("company", prof.getCompany());
						jo.put("designation", prof.getDesignation());
					}
				}
				array.add(jo);
				count++;
				isLeft = false;
				
				//q= q+advisor.getId();
				}else{
					isLeft = true;
					count++;
				}
			}
		}
		if(isLeft){
			JSONObject jo = new JSONObject();
			jo.put("name", "noadv");
			array.add(jo);

		}
		System.out.println(array.size());
		response.getWriter().write(array.toJSONString());
		
		logger.info("Entered doPost method of FilterController");
	}

}
