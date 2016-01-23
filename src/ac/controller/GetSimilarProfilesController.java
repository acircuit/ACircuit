package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ac.dao.QuestionsDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.SubCategoryDTO;

/**
 * Servlet implementation class GetSimilarProfilesController
 */
@WebServlet("/GetSimilarProfilesController")
public class GetSimilarProfilesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetSimilarProfilesController.class);



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetSimilarProfilesController");
		String category = request.getParameter("category");
		String subcategory = request.getParameter("subcategory");
		String advisorId = request.getParameter("advisorId");
		String type = request.getParameter("type");
		if(type != null && type.equals("popular")){
			List<Integer> aids = new ArrayList<Integer>();
			QuestionsDAO pop = new QuestionsDAO();
			aids = pop.GetPopularAdvisors();
			List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
			JSONArray array = new JSONArray();
	        if(aids.size() > 0){
	    		QuestionsDAO advDetails = new QuestionsDAO();
	    		list = advDetails.GetAdvisorDetails(aids);
	    		List<SubCategoryDTO> sub = new ArrayList<SubCategoryDTO>();
	    		QuestionsDAO subs = new QuestionsDAO();
	    		sub = subs.GetAdvisorSubcategories(aids);
	            for(AdvisorDTO advisor : list){
	        		String subcategories = "";
	            	for(SubCategoryDTO subcat : sub){
	            		System.out.println(subcat.getAdvisorId());
	            		System.out.println(advisor.getId());
	            		if(subcat.getAdvisorId() == advisor.getId()){
	            			subcategories = subcategories +subcat.getSubCategory()+"|";
	            		}
	            	}
	            	if(!subcategories.equals("") ){
	            	int index = subcategories.lastIndexOf("|");
	            	subcategories =subcategories.substring(0, index);
	            	}
	            	System.out.println(subcategories);
	            	JSONObject jo = new JSONObject();
	    			jo.put("id", advisor.getId());
	    			jo.put("image", advisor.getImage());
	    			jo.put("name",advisor.getName());
	    			jo.put("industry",subcategories);
	    			array.add(jo);

	            }
	            
	        }
			response.getWriter().write(array.toJSONString());
		}else{
			List<Integer> aids = new ArrayList<Integer>();
			QuestionsDAO profiles = new QuestionsDAO();
			aids = profiles.GetSimilarProfiles(advisorId,category,subcategory);
			List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
			JSONArray array = new JSONArray();
	        if(aids.size() > 0){
	    		QuestionsDAO advDetails = new QuestionsDAO();
	    		list = advDetails.GetAdvisorDetails(aids);
	    		List<SubCategoryDTO> sub = new ArrayList<SubCategoryDTO>();
	    		QuestionsDAO subs = new QuestionsDAO();
	    		sub = subs.GetAdvisorSubcategories(aids);
	            for(AdvisorDTO advisor : list){
	        		String subcategories = "";
	            	for(SubCategoryDTO subcat : sub){
	            		System.out.println(subcat.getAdvisorId());
	            		System.out.println(advisor.getId());
	            		if(subcat.getAdvisorId() == advisor.getId()){
	            			subcategories = subcategories +subcat.getSubCategory()+"|";
	            		}
	            	}
	            	if(!subcategories.equals("") ){
	            	int index = subcategories.lastIndexOf("|");
	            	subcategories =subcategories.substring(0, index);
	            	}
	            	System.out.println(subcategories);
	            	JSONObject jo = new JSONObject();
	    			jo.put("id", advisor.getId());
	    			jo.put("image", advisor.getImage());
	    			jo.put("name",advisor.getName());
	    			jo.put("industry",subcategories);
	    			array.add(jo);

	            }
	            
	        }
			response.getWriter().write(array.toJSONString());

		}


        logger.info("Entered doPost method of GetSimilarProfilesController");
	}

}
