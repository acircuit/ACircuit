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

import ac.dao.QuestionsDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;
import ac.dto.SessionDTO;

/**
 * Servlet implementation class AdvisorMyAccountQuestionsController
 */
@WebServlet("/AdvisorMyAccountQuestionsController")
public class AdvisorMyAccountQuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountQuestionsController.class);



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountApproveSessionController");
        int advisorId = 0;
		Boolean isError = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
			List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();
			List<QuestionsDTO> newQuestions = new ArrayList<QuestionsDTO>();
			List<QuestionsDTO> answeredQuestions = new ArrayList<QuestionsDTO>();
			List<Integer> ids = new ArrayList<Integer>();
			QuestionsDAO answers = new QuestionsDAO();
			list = answers.GetQuestionIds(advisorId);

			QuestionsDAO ques = new QuestionsDAO();
			List<QuestionsDTO> questions = ques.GetQuestions(list);
			for(QuestionsDTO advQuestions : questions){
				if(advQuestions.getIsAnswered()){
					ids.add(advQuestions.getQuestionId());
					answeredQuestions.add(advQuestions);
				}else{
					newQuestions.add(advQuestions);
				}
			}
			QuestionsDAO ans = new QuestionsDAO();
			List<AnswerDTO> answer = ans.GetAnswersFromQuestionIds(ids);
			SimpleDateFormat format = new SimpleDateFormat("dd MMM");
			for(QuestionsDTO que1 : questions) {
			 for(AnswerDTO ans1 : answer){
				 if(que1.getQuestionId() == ans1.getQuestionId() && que1.getIsAnswered()){
					 que1.setLastUpdated(format.format(ans1.getTime()));
					 que1.setAnswer(ans1.getAnswer());
				 }
			 }
			}
			//Get Advisor Image
			SessionDAO adv = new SessionDAO();
			 AdvisorDTO advisorDetails =  adv.GetAdvisorDetails(advisorId);
			 
			 System.out.println("ans"+answeredQuestions.size());
			 System.out.println("new"+newQuestions.size());
			request.setAttribute("answeredQuestions", answeredQuestions);
			request.setAttribute("newQuestions", newQuestions);
			request.setAttribute("advisorDetails", advisorDetails);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorsessionquestions.jsp");
	        rd.forward(request, response);
			
			
		}
		if(isError){
			response.sendRedirect("error");
		}
		logger.info("Entered doGet method of AdvisorMyAccountApproveSessionController");
	}

}
