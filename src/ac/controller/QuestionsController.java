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
import ac.dao.AdminNotificationDAO;
import ac.dao.FeedDAO;
import ac.dao.QuestionsDAO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class QuestionsController
 */
@WebServlet("/QuestionsController")
public class QuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(QuestionsController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of QuestionsController");
		String category = request.getParameter("category");
		String subcategory = request.getParameter("subcategory");
		List<QuestionsDTO> list1 = new ArrayList<QuestionsDTO>();
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		if(category != null && subcategory != null){
			QuestionsDAO questions = new QuestionsDAO();
			list1 = questions.GetQuestionsAccordingToSubcategory(category,subcategory);
			//Getting the last updated answer for each of the questions
			QuestionsDAO answers = new QuestionsDAO();
			list = answers.GetAnswers(list1);
			
			
		}else{
			//Getting all the questions for the user
			QuestionsDAO que = new QuestionsDAO();
			list1 = que.GetAllQuestions();
			//Getting the Answers of the question
			QuestionsDAO question = new QuestionsDAO();
			list = question.GetAnswers(list1);
		}

		
		
		SimpleDateFormat format = new SimpleDateFormat("dd MMM");
		for(QuestionsDTO que1 : list1) {
		 int count=0;
		 for(AnswerDTO ans : list){
			 if(que1.getQuestionId() == ans.getQuestionId()){
				 count ++;
				 que1.setLastUpdated(format.format(ans.getTime()));
			 }
		 }
		 que1.setCount(count);
		}
		//Getting Most Viewed Questions
		List<QuestionsDTO> mostViewedQuestions = new ArrayList<QuestionsDTO>();
		QuestionsDAO views = new QuestionsDAO();
		mostViewedQuestions = views.GetMostViewedQuestion();
		
		//Getting Popular categories
		QuestionsDAO cats = new QuestionsDAO();
		List<String> popCats = cats.GetPopularCategories();
		
		//Getting the sub categories
		MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
		String[] higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
		
		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
		List<String> industrySubCategory = industry.getIndustrySubCategory();
		
		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
		List<String> optionsSubCategory = option.getOpionsSubCategory();
		request.setAttribute("questions", list1);
		request.setAttribute("answers", list);
		request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
		request.setAttribute("industrySubCategory", industrySubCategory);
		request.setAttribute("optionsSubCategory", optionsSubCategory);
		request.setAttribute("mostViewedQuestions", mostViewedQuestions);
		request.setAttribute("popCats", popCats);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Questions.jsp");
        rd.forward(request, response);
		
		logger.info("Exit doPost method of QuestionsController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of QuestionsController");
		int userId = 0;
		Boolean isError =false;
		Boolean isCommit =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
		String question = request.getParameter("question");
		String category = request.getParameter("category");
		String subcategory = request.getParameter("subcategory");
		QuestionsDAO ques = new QuestionsDAO();
		int id = ques.SubmitQuestion(userId,question,category,subcategory);
		if(id !=0){
			List<Integer> aids = new ArrayList<Integer>();
			QuestionsDAO ids = new QuestionsDAO();
			aids = ids.GetSimilarAdvisorIds(category,subcategory);
			if(aids.size() > 0){
				QuestionsDAO post =  new QuestionsDAO();
				isCommit = post.PostQuestionToAdvisors(aids,id);
			}
			if(isCommit){
				String comment = "New Question posted on the forum";
				String href = "adminquestions";
				AdminNotificationDAO notify = new AdminNotificationDAO();
				notify.InsertNotification(comment, href);
			    response.getWriter().write("Your Question has been submitted");
			
			}
			}
		
		}
		
		
		
		logger.info("Exit doPost method of QuestionsController");
	}
}
