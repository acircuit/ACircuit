package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.FeedDAO;
import ac.dao.QuestionsDAO;

/**
 * Servlet implementation class QuestionToAdvisorController
 */
@WebServlet("/QuestionToAdvisorController")
public class QuestionToAdvisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(QuestionToAdvisorController.class);
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of QuestionToAdvisorController");
		int userId = 0;
		Boolean isError =false;
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
		String aid = request.getParameter("aid");
		
		QuestionsDAO ques = new QuestionsDAO();
		int id = ques.SubmitQuestionToAdvisor(question,category,subcategory,userId);
		if(id !=0){
			//Inserting the advisor to which the question is posted
			QuestionsDAO adv = new QuestionsDAO();
			Boolean isInserted = adv.SetAdvisorIdForQuestion(id,aid);
			if(isInserted){
			    //Adding to the feeds table
				FeedDAO feed = new FeedDAO();
				int feedId = feed.InsertFeedType("question");
				if(feedId != 0){
					//Inserting feed content
				    FeedDAO questions = new FeedDAO();
				    Boolean isCommit = questions.InsertQuestionFeed(feedId,id,question,category,subcategory );
				    if(isCommit){
						response.getWriter().write("Your Question has been submitted");
				    }
				}
			}

		}
		
		}
		
		logger.info("Exit doPost method of QuestionToAdvisorController");	}

}
