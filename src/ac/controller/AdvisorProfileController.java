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
     		String[] higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
     		
     		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
     		List<String> industrySubCategory = industry.getIndustrySubCategory();
     		
     		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
     		List<String> optionsSubCategory = option.getOpionsSubCategory();
             
			List<ReviewsDTO> advisorReviews = new ArrayList<ReviewsDTO>();
			SessionDAO reviews = new SessionDAO();
			advisorReviews = reviews.GetAdvisorReviews(aId);
			int reviewCount = 0;
			List<Integer> uIds = new ArrayList<Integer>();
			for(ReviewsDTO review: advisorReviews){
				    reviewCount++;
					uIds.add(review.getUserId());
			}
			
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
			
			List<UserDetailsDTO> userDetails = new ArrayList<UserDetailsDTO>();
			  //Getting user details
			  SessionDAO usrDetails = new SessionDAO();
			  userDetails = usrDetails.GetUserDetailsForReviews(uIds);
     		 request.setAttribute("advisor", advisor);
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
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/Advisor.jsp");
             rd.forward(request, response);
		}	
		logger.info("Entered doPost method of AdvisorProfileController");
	}
}
