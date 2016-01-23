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

import ac.cache.MyCacheBuilder;
import ac.dao.SearchDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SubCategoryDTO;
import ac.util.GetRelativeImageURL;

/**
 * Servlet implementation class GetSubcategoryAdvisorsController
 */
@WebServlet("/GetSubcategoryAdvisorsController")
public class GetSubcategoryAdvisorsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetSubcategoryAdvisorsController.class);
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetSubcategoryAdvisorsController");

		String ids = "";
		String adId ="";
		String category = request.getParameter("category");	
		String subcategory = request.getParameter("subcategory");	
		String paging = request.getParameter("paging");
		int startIndex = 1;
		int endIndex = 10;
		System.out.println(category);
		System.out.println(subcategory);
		String[] initialAdvisors = null;
		if(paging != null){
			int page = Integer.valueOf(paging);

			startIndex = 11+ (page-1)*6;
            endIndex = startIndex +5;
		}
		//Getting advisorId's
		int count=1;
		int catId =0;
		Boolean isLeft = false;
		SearchDAO advisors = new SearchDAO();
		ids = 	advisors.GetAdvisorsUsingCategory(category);
		System.out.println("es"+ids);
		String[] advisorIds = ids.split(":");
		
		//Getting the advisors object from Cache
		  JSONArray array = new JSONArray();
			for(String aid : advisorIds){
				int threshold = 0;
				MyCacheBuilder cache = MyCacheBuilder.getCacheBuilder();
				AdvisorDTO advisor = cache.getAdvisor(Integer.valueOf(aid));
				List<CategoryDTO> list = advisor.getCategories();
				List<SubCategoryDTO> subcats2 = advisor.getSubCategories();

				if(category.equals("higherstudies")){
					for(CategoryDTO cat : list){
						if(cat.getCategory().equals("studies")){
							catId = cat.getCatId();
							threshold++;
						}
						for(SubCategoryDTO sub :subcats2){
							if(sub.getCategoryId() == catId && sub.getSubCategory().equals(subcategory)){
								threshold++;	
								}
						}
						if(threshold % 2 == 1){
							threshold = threshold -1;
						}
					}
					
			  }else if (category.equals("industry")) {
				  for(CategoryDTO cat : list){
						if(cat.getCategory().equals("industry")){
							catId = cat.getCatId();
							threshold++;
						}
						for(SubCategoryDTO sub :subcats2){
							if(sub.getCategoryId() == catId && sub.getSubCategory().equals(subcategory)){
								threshold++;	
								}
						}
						if(threshold % 2 == 1){
							threshold = threshold -1;
						}
					}
			   }else if (category.equals("options")) {
				   for(CategoryDTO cat : list){
						if(cat.getCategory().equals("options")){
							catId = cat.getCatId();
							threshold++;
						}
						for(SubCategoryDTO sub :subcats2){
							if(sub.getCategoryId() == catId && sub.getSubCategory().equals(subcategory)){
								threshold++;	
								}
						}
						if(threshold % 2 == 1){
							threshold = threshold -1;
						}
					}
			    }
/*				if(category.equals("options")){
					threshold++;	

				}else{
					List<SubCategoryDTO> subcats = advisor.getSubCategories();
					for(SubCategoryDTO sub :subcats){
						if(sub.getCategoryId() == catId && sub.getSubCategory().equals(subcategory)){
							threshold++;	
							}
					}
				}*/
			
				if(threshold ==2){
					adId = adId+advisor.getId()+":";
					if(count >= startIndex && count <=endIndex) {
						JSONObject jo = new JSONObject();
						jo.put("name", advisor.getName());
						jo.put("id", advisor.getId());
						List<SubCategoryDTO> subcats1 = advisor.getSubCategories();
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
						System.out.println(jo.get("name"));
						SessionDAO advPrice = new SessionDAO();
						Double[] prices = advPrice.GetAdvisorPrices(String.valueOf(advisor.getId()));
/*						Double price = advisor.getPhonePrice();
*/						Double commisionedPrice  = prices[0] +( prices[0]  * 20 /100);
						Double finalPrice = commisionedPrice / 60;
						jo.put("price", Math.round(finalPrice));
						jo.put("image", advisor.getImage());
						array.add(jo);
						isLeft = false;
						System.out.println(isLeft);

					}else{
						isLeft = true;
						System.out.println(isLeft);
					}
					count++;
				}
			
			}
			if(isLeft){
				JSONObject jo = new JSONObject();
				jo.put("name", "noadv");
				array.add(jo);
			}
			if(!adId.equals("")){
				 int pos = adId.lastIndexOf(':');
				 adId = adId.substring(0, pos);
			}
			
			 JSONObject jo = new JSONObject();
				jo.put("name", "id");
				jo.put("ids", adId);
				array.add(jo);
				System.out.println(array.size());
			response.getWriter().write(array.toJSONString());

	    logger.info("Exit doPost method of GetSubcategoryAdvisorsController");
	}	    
}
