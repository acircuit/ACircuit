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

import sun.security.util.PendingException;
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
				}
			}
			QuestionsDAO ans = new QuestionsDAO();
			List<AnswerDTO> answer = ans.GetAnswersFromQuestionIds(ids);
			SimpleDateFormat format = new SimpleDateFormat("dd MMM");
			for(QuestionsDTO que1 : questions) 
			{
				Boolean isQuestionPending=true;
			 for(AnswerDTO ans1 : answer)
			 {
				 if(que1.getQuestionId() == ans1.getQuestionId())
				 {
			
					 que1.setLastUpdated(format.format(ans1.getTime()));
					 que1.setAnswer(ans1.getAnswer());
					 que1.setAdvisor_id(ans1.getAdvisor_id());
			
					 if(ans1.getAdvisor_id() == advisorId)
						 {
							 isQuestionPending = false;
						 }
				}	
			 }
			 
			 if(!isQuestionPending)
			 {
				 answeredQuestions.add(que1);
			 }
			 else
			 {
				 newQuestions.add(que1);
			 }
			}
			//Get Advisor Image
			SessionDAO adv = new SessionDAO();
			List<AdvisorDTO> advisorDetails =  adv.GetAdvisorDetailsUsingQuestions(answeredQuestions);
			
			SessionDAO details = new SessionDAO();
			AdvisorDTO advDetails = details.GetAdvisorDetails(advisorId);
			 
			System.out.println("Answered"+answeredQuestions.size() + "Pending" +newQuestions.size());
			request.setAttribute("answeredQuestions", answeredQuestions);
			request.setAttribute("newQuestions", newQuestions);
			request.setAttribute("advisorDetails", advisorDetails);
			request.setAttribute("advisorId", advisorId);
			request.setAttribute("advDetails", advDetails);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/advisorsessionquestions.jsp");
	        rd.forward(request, response);
			
			
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		logger.info("Entered doGet method of AdvisorMyAccountApproveSessionController");
	}

}
