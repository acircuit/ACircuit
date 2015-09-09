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
		//Get Advisor name , image and industry
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
		QuestionsDAO adv = new QuestionsDAO();
		advisors = adv.GetAdvisorDetails(aId);
		request.setAttribute("question", que);
		request.setAttribute("answers", list);
		request.setAttribute("last_Updated", last_Updated);
		request.setAttribute("advisors", advisors);
		request.setAttribute("count", count);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Answers.jsp");
        rd.forward(request, response);
		
		
		logger.info("Exit doPost method of AnswersController");
	}
}
