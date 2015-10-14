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
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.QuestionsDTO;
import ac.dto.ReviewsDTO;
import ac.dto.UserDetailsDTO;

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
		int userId = 0;
		int advisorId = 0;
		Boolean admin = false;
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
		try{
			admin = (Boolean) request.getSession().getAttribute("admin");
		}catch (Exception e){
			isError = true;
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0 || advisorId != 0 || (admin != null && admin)){
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
             //Getting the sub categories
     		MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
     		List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
     		
     		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
     		List<String> industrySubCategory = industry.getIndustrySubCategory();
     		
     		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
     		List<String> optionsSubCategory = option.getOpionsSubCategory();
             
			List<ReviewsDTO> advisorReviews = new ArrayList<ReviewsDTO>();
			SessionDAO reviews = new SessionDAO();
			advisorReviews = reviews.GetAdvisorReviews(aId);
			int reviewCount = 0;
			Double rateCount =0.0;
			Double ratingCount =0.0;
			List<Integer> uIds = new ArrayList<Integer>();
			for(ReviewsDTO review: advisorReviews){
				    reviewCount++;
					uIds.add(review.getUserId());
					ratingCount = ratingCount + Double.valueOf(review.getRating());
			}
			rateCount = ratingCount / advisorReviews.size();
			rateCount = (double) Math.round(rateCount);
			//Geting advisor answers
			int answerCount =0;
			 List<AnswerDTO> answers = new ArrayList<AnswerDTO>();
			 List<Integer> qids = new ArrayList<Integer>();
			SessionDAO ans = new SessionDAO();
			answers = ans.GetAdvisorAnswers(aId);
			for (AnswerDTO answer : answers) {
				answerCount++;
				qids.add(answer.getQuestionId());
			}
			
			//Get Question Details
			List<QuestionsDTO> questions = new ArrayList<QuestionsDTO>();
            SessionDAO question = new SessionDAO();
            questions = question.GetQuestions(qids);
			Boolean isPhone =false;
			if(userId != 0){
				SessionDAO user = new SessionDAO();
				UserDetailsDTO userDetails = user.GetUserDetails(userId);
				if(userDetails.getPhone() != null && !userDetails.getPhone().equals("")){
					isPhone = true;
				}
			}
			int consultations = 0;
			//Getting the number of consultations
			SessionDAO sessions= new SessionDAO();
			consultations =  sessions.GetConsultations(advisor.getId());
			
			//Calculating price
			SessionDAO advPrice = new SessionDAO();
			Double[] prices = advPrice.GetAdvisorPrices(String.valueOf(advisor.getId()));
/*			Double price = advisor.getPhonePrice();
*/			Double commisionedPrice  = prices[0] +( prices[0]  * 20 /100);
			Double finalPrice = commisionedPrice / 60;
			advisor.setPhonePrice(Math.round(finalPrice));
            
			List<UserDetailsDTO> userDetails = new ArrayList<UserDetailsDTO>();
			  //Getting user details
			  SessionDAO usrDetails = new SessionDAO();
			  userDetails = usrDetails.GetUserDetailsForReviews(uIds);
     		 request.setAttribute("advisor", advisor);
     		request.setAttribute("consultations", consultations);
     		request.setAttribute("isPhone", isPhone);
     		request.setAttribute("reviewCount", reviewCount);
     		request.setAttribute("advisorReviews", advisorReviews);
     		request.setAttribute("userDetails", userDetails);
     		 request.setAttribute("currentDesignation", currentDesignation);
     		 request.setAttribute("currentCompany", currentCompany);
     		 request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
    		 request.setAttribute("industrySubCategory", industrySubCategory);
    		 request.setAttribute("optionsSubCategory", optionsSubCategory);
    		 request.setAttribute("answers", answers);
    		 request.setAttribute("questions", questions);
    		 request.setAttribute("answerCount", answerCount);
    		 request.setAttribute("rateCount", rateCount);
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/Advisor.jsp");
             rd.forward(request, response);
		}	
		}else{
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		logger.info("Entered doPost method of AdvisorProfileController");
	}
}
