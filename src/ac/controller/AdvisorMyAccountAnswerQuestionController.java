package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.QuestionsDAO;

/**
 * Servlet implementation class AdvisorMyAccountAnswerQuestionController
 */
@WebServlet("/AdvisorMyAccountAnswerQuestionController")
public class AdvisorMyAccountAnswerQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountAnswerQuestionController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountAnswerQuestionController");
		int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
		     String answer = request.getParameter("answer");
		     String qid = request.getParameter("qid");
		     String aid = request.getParameter("aid");
		     QuestionsDAO answers = new QuestionsDAO();
		     int aId = answers.SubmitAnswer(qid,aid,answer);
		     //Marking the question as answered and incrementing the count
		     QuestionsDAO question = new QuestionsDAO();
		     Boolean isCommit = question.UpdateDetails(qid);
		     if(isCommit){
			     response.sendRedirect("answers?q="+qid);
		     }
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doGet method of AdvisorMyAccountAnswerQuestionController");
	}

}
