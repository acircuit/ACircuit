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
import ac.dto.AdvisorDTO;
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
	
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0 || advisorId != 0 || (admin != null && admin)){
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

		
		List<Integer> advId = new ArrayList<Integer>();
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		for(QuestionsDTO que1 : list1) {
		 int count=0;
		 for(AnswerDTO ans : list){
			 if(que1.getQuestionId() == ans.getQuestionId()){
				 count ++;
				 que1.setLastUpdated(format.format(ans.getTime()));
				 advId.add(ans.getAdvisor_id());
				 que1.setAdvisor_id(ans.getAdvisor_id());
			 }
		 }
		 que1.setCount(count);
		}
		
		QuestionsDAO adv = new QuestionsDAO();
		List<AdvisorDTO> advisors = adv.GetAdvisorName(list);
		
		
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
		request.setAttribute("questions", list1);
		request.setAttribute("answers", list);
		request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
		request.setAttribute("industrySubCategory", industrySubCategory);
		request.setAttribute("optionsSubCategory", optionsSubCategory);
		request.setAttribute("mostViewedQuestions", mostViewedQuestions);
		request.setAttribute("popCats", popCats);
		request.setAttribute("advisors", advisors);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Questions.jsp");
        rd.forward(request, response);
		}else{
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
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
		question = question.replaceAll("\r\n", "");
		question = question.replaceAll("\r", "");
		question = question.replaceAll("\n", "");
		QuestionsDAO ques = new QuestionsDAO();
		int id = ques.SubmitQuestion(userId,question,category,subcategory);
		if(id !=0){
			if(category.equals("higherstudies")){
				category = "studies";
			}else if (category.equals("industry")) {
				category = "industry";
			}else if (category.equals("options")) {
				category = "options";
			}
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
				    response.getWriter().write("Your question has been submitted for just a few checks. We'll get back to you with a go ahead within two hours, thank you!");
				}
			}
		
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		
		logger.info("Exit doPost method of QuestionsController");
	}
}
