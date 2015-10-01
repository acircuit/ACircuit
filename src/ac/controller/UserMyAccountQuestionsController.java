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
import ac.dao.QuestionsDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class UserMyAccountQuestionsController
 */
@WebServlet("/UserMyAccountQuestionsController")
public class UserMyAccountQuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountQuestionsController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserMyAccountQuestionsController");
		int userId = 0;
		Boolean isError = false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		if(userId != 0){
			List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();
			List<QuestionsDTO> pendingQuestions = new ArrayList<QuestionsDTO>();
			List<QuestionsDTO> answeredQuestions = new ArrayList<QuestionsDTO>();
			//Getting all the questions asked by the user
			QuestionsDAO questions = new QuestionsDAO();
			list = questions.GetUserQuestions(userId);
			
			//Getting all the answers for the questions which are answered.
			//Getting the question ids which have been answered
			List<Integer> qids = new ArrayList<Integer>();
			List<Integer> qid = new ArrayList<Integer>();
			for(QuestionsDTO question : list){
				if(question.getIsAnswered()){
					qids.add(question.getQuestionId());
					answeredQuestions.add(question);
				}else{
					pendingQuestions.add(question);
				}
			
			}
			//Getting all the answers
			SimpleDateFormat format = new SimpleDateFormat("dd MMM");
			List<AnswerDTO> advisorAnswers = new ArrayList<AnswerDTO>();
			QuestionsDAO answers = new QuestionsDAO();
			advisorAnswers = answers.GetAnswersFromQuestionIds(qids);
			for(QuestionsDTO question : list){
				for(AnswerDTO answer : advisorAnswers){
					if(answer.getQuestionId() == question.getQuestionId()){
						question.setAnswer(answer.getAnswer());
						question.setLastUpdated(format.format(answer.getTime()));
						question.setAdvisor_id(answer.getAdvisor_id());
					}
				}
			
			}
			//Getting the advisorname from the advisor ids
			QuestionsDAO ids = new QuestionsDAO();
			List<AdvisorDTO> advisorDetails  = ids.GetAdvisorName(advisorAnswers);
			
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

			request.setAttribute("answeredQuestions", answeredQuestions);
			request.setAttribute("pendingQuestions", pendingQuestions);
			request.setAttribute("advisorDetails", advisorDetails);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/usersessionquestions.jsp");
	        rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
