package ac.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ac.dao.QuestionsDAO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class GetSubcategoryQuestionsController
 */
@WebServlet("/GetSubcategoryQuestionsController")
public class GetSubcategoryQuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetSubcategoryQuestionsController.class);
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetSubcategoryQuestionsController");
		String category = request.getParameter("category");	
		String subcategory = request.getParameter("subcategory");
		//Getting all the questions
		List<QuestionsDTO> ques = new ArrayList<QuestionsDTO>();
		QuestionsDAO questions = new QuestionsDAO();
		ques = questions.GetQuestionsAccordingToSubcategory(category,subcategory);
		//Getting the last updated answer for each of the questions
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		QuestionsDAO answers = new QuestionsDAO();
		list = answers.GetAnswers(ques);
		JSONArray array = new JSONArray();
		SimpleDateFormat format = new SimpleDateFormat("dd MMM");
		for(QuestionsDTO que1 : ques) {
			JSONObject jo = new JSONObject();
			jo.put("id", que1.getQuestionId());
			jo.put("category", que1.getCategory());
			jo.put("subcategory",que1.getSubcategory());
			jo.put("question",que1.getQuestion());
		 int count=0;
		 for(AnswerDTO ans : list){
			 if(que1.getQuestionId() == ans.getQuestionId()){
				 count ++;
				 jo.put("lastupdated", format.format(ans.getTime()));
				 jo.put("answer", ans.getAnswer());
			 }
		 }
		 jo.put("count", count);
		 array.add(jo);
		}
		System.out.println(array.size());

		response.getWriter().write(array.toJSONString());
		
		
		logger.info("Entered doPost method of GetSubcategoryQuestionsController");
	}

}
