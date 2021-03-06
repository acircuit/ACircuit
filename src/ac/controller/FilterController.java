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
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AdvisorLanguageDTO;
import ac.dto.AnswerDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SubCategoryDTO;
import ac.util.GetRelativeImageURL;

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
		System.out.println(filterString);
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
		System.out.println(ids);
		
		
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
			indus = indus.replaceAll("&amp;", "&");
			List<AdvisorLanguageDTO> language1 = advisor.getLanguage();
			for(int i=0;i<myarray.length;i++){
				if(myarray[i].equals("college")){
					for(EducationDTO edu : education){
						if(edu.getInstitution().equals(myarray[i+1])){
							advCollege++;
						}
					}
				}else if (myarray[i].equals("industry") && indus.equals(myarray[i+1].replaceAll("&amp;", "&"))) {
					advIndus++;
					System.out.println("Industry"+ myarray[i+1]);
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
/*				List<CategoryDTO> list = advisor.getCategories();
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
						if(cat.getCategory().equals("options")){
							catId = cat.getCatId();
						}
					}
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId){
							jo.put("subcategory", sub.getSubCategory());
						}
					}
				}else{
					for(CategoryDTO cat : list){
							catId = cat.getCatId();
					}
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId){
							jo.put("subcategory", sub.getSubCategory());
						}
					}
				}*/
				int i=1;
				List<SubCategoryDTO> subcats = advisor.getSubCategories();
				for(SubCategoryDTO sub :subcats){
						jo.put("subcategory"+i, sub.getSubCategory());
						i++;
				}
				List<EducationDTO> education1 = advisor.getEducation();
				int ed=0;
				for(EducationDTO educ : education1){
					if(educ.getType().equals("PG") && educ.getInstitution() != null){
						jo.put("institution", educ.getInstitution());
						ed++;
					}
				}
				if(ed == 0){
					for(EducationDTO educ : education1){
						if(educ.getType().equals("UG") && educ.getInstitution() != null){
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
				SessionDAO ans = new SessionDAO();
				List<AnswerDTO> answers = ans.GetAdvisorAnswers(String.valueOf(advisor.getId()));
				jo.put("answers", answers.size());
				
				List<ReviewsDTO> advisorReviews = new ArrayList<ReviewsDTO>();
				SessionDAO reviews = new SessionDAO();
				advisorReviews = reviews.GetAdvisorReviews(String.valueOf(advisor.getId()));
				Double ratingCount =0.0;
				for(ReviewsDTO review : advisorReviews){
					ratingCount = ratingCount + Double.valueOf(review.getRating());
				}
				Double rateCount =0.0;
				rateCount = ratingCount / advisorReviews.size();
				jo.put("reviews", advisorReviews.size());
				jo.put("ratecount", Math.round(rateCount));
				
				int consultations = 0;
				//Getting the number of consultations
				SessionDAO sessions= new SessionDAO();
				consultations =  sessions.GetConsultations(advisor.getId());
				jo.put("sessions", consultations);
				jo.put("image", advisor.getImage());
				array.add(jo);
				System.out.println("added");
				isLeft = false;
				SessionDAO advPrice = new SessionDAO();
				Double[] prices = advPrice.GetAdvisorPrices(String.valueOf(advisor.getId()));
/*				Double price = advisor.getPhonePrice();
*/				Double commisionedPrice  = prices[0] +( prices[0]  * 20 /100);
				Double finalPrice = commisionedPrice / 60;
				jo.put("price", Math.round(finalPrice));
				//q= q+advisor.getId();
				}else{
					isLeft = true;
				}
				count++;
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
