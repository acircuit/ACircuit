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
		//Getting all the questions for the user
		List<QuestionsDTO> list1 = new ArrayList<QuestionsDTO>();
		QuestionsDAO que = new QuestionsDAO();
		list1 = que.GetAllQuestions();
		//Getting the Answers of the question
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		QuestionsDAO question = new QuestionsDAO();
		list = question.GetAnswers(list1);
		//Getting the sub categories
		MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
		String[] higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
		
		MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
		List<String> industrySubCategory = industry.getIndustrySubCategory();
		
		MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
		List<String> optionsSubCategory = option.getOpionsSubCategory();
		System.out.println(higherStudiesSubCategory.length);
		request.setAttribute("questions", list1);
		request.setAttribute("answers", list);
		request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
		request.setAttribute("industrySubCategory", industrySubCategory);
		request.setAttribute("optionsSubCategory", optionsSubCategory);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Questions.jsp");
        rd.forward(request, response);
		
		logger.info("Exit doPost method of QuestionsController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of QuestionsController");
		String question = request.getParameter("question");
		String category = request.getParameter("category");
		String subcategory = request.getParameter("subcategory");
		QuestionsDAO ques = new QuestionsDAO();
		Boolean isCommit = ques.SubmitQuestion(question,category,subcategory);
		response.getWriter().write("Your Question has been submitted");
		
		logger.info("Exit doPost method of QuestionsController");
	}
}
