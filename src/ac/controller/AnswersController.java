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

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.Object;

import ac.cache.MyCacheBuilder;
import ac.dao.QuestionsDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class AnswersController
 */
@WebServlet("/AnswersController")
public class AnswersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AnswersController.class);
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AnswersController");
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
		}catch(Exception e){
			isError = true;
		}
		String q_id = request.getParameter("q");
		String last_Updated = "";
		QuestionsDTO que = new QuestionsDTO();
		//Getting the question
		QuestionsDAO question = new QuestionsDAO();
		que = question.GetQuestion(q_id);
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		QuestionsDAO answer = new QuestionsDAO();
		list = answer.GetAllAnswers(q_id);
		SimpleDateFormat format = new SimpleDateFormat("dd MMM");
		List<Integer> aId = new ArrayList<Integer>();
		int count=0;
		for(AnswerDTO ans : list){
			ans.setDate(format.format(ans.getTime()));
			last_Updated = format.format(ans.getTime());
			aId.add(ans.getAdvisor_id());
			count++;
		}
		//Incrementing Questions hit
		QuestionsDAO inc = new QuestionsDAO();
		inc.IncrementQuestionHit(q_id);
		//Get Advisor name , image and industry
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
		QuestionsDAO adv = new QuestionsDAO();
		advisors = adv.GetAdvisorDetails(aId);
		
		//Getting Most Viewed Questions
		List<QuestionsDTO> mostViewedQuestions = new ArrayList<QuestionsDTO>();
		QuestionsDAO views = new QuestionsDAO();
		mostViewedQuestions = views.GetMostViewedQuestion();
					
		//Getting Popular categories
		QuestionsDAO cats = new QuestionsDAO();
		List<String> popCats = cats.GetPopularCategories();
		
		//Getting the sub categories
		MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
		List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
		
		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
		List<String> industrySubCategory = industry.getIndustrySubCategory();
		
		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
		List<String> optionsSubCategory = option.getOpionsSubCategory();
		request.setAttribute("mostViewedQuestions", mostViewedQuestions);
		request.setAttribute("popCats", popCats);
		request.setAttribute("question", que);
		request.setAttribute("answers", list);
		request.setAttribute("last_Updated", last_Updated);
		request.setAttribute("advisors", advisors);
		request.setAttribute("count", count);
		request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
		request.setAttribute("industrySubCategory", industrySubCategory);
		request.setAttribute("optionsSubCategory", optionsSubCategory);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Answers.jsp");
        rd.forward(request, response);

		
		logger.info("Exit doPost method of AnswersController");
	}
}
