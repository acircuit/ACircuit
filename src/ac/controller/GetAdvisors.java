package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SubCategoryDTO;

/**
 * Servlet implementation class GetInitialAdvisors
 */
@WebServlet("/GetAdvisors")
public class GetAdvisors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetAdvisors.class);
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetAdvisors");
		String category = request.getParameter("category");
		String ids = request.getParameter("ids");
		String paging = request.getParameter("paging");
		String[] advisorIds = ids.split(":");
		String[] initialAdvisors = null;
		if(paging.equals("0")){
			if(advisorIds.length > 10){
				initialAdvisors = Arrays.copyOfRange(advisorIds, 0, 10);
			}else{
				initialAdvisors = advisorIds;
			}
		}else{
			int page = Integer.valueOf(paging);
			int startIndex = 0;
			int endIndex = 0;
			startIndex = 11+ (page-1)*6;
            endIndex = startIndex +5;
			initialAdvisors = Arrays.copyOfRange(advisorIds, startIndex, endIndex);
		}
		
		  JSONArray array = new JSONArray();
			for(String aid : initialAdvisors){
				if(aid != null){
						MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
						AdvisorDTO advisor = cache.getAdvisor(Integer.valueOf(aid));
						List<EducationDTO> education = new ArrayList<EducationDTO>();
						education = advisor.getEducation();
						String indus = advisor.getIndustry();
		
							JSONObject jo = new JSONObject();
							jo.put("name", advisor.getName());
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
					//q= q+advisor.getId();
				   }else{
						JSONObject jo = new JSONObject();
						jo.put("name","noadv");
						array.add(jo);
				   }
				}

			response.getWriter().write(array.toJSONString());
		
		logger.info("Exit doPost method of GetAdvisors");
	}

}