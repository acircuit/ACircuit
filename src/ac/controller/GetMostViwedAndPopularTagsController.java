package ac.controller;

import java.io.IOException;
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
import ac.dto.AdvisorDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class GetMostViwedAndPopularTagsController
 */
@WebServlet("/GetMostViwedAndPopularTagsController")
public class GetMostViwedAndPopularTagsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetMostViwedAndPopularTagsController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetMostViwedAndPopularTagsController");
		//Getting Most Viewed Questions
		List<QuestionsDTO> mostViewedQuestions = new ArrayList<QuestionsDTO>();
		QuestionsDAO views = new QuestionsDAO();
		mostViewedQuestions = views.GetMostViewedQuestion();
		
		//Getting Popular categories
		QuestionsDAO cats = new QuestionsDAO();
		List<String> popCats = cats.GetPopularCategories();
		
		
		JSONArray array = new JSONArray();
        for(QuestionsDTO question : mostViewedQuestions){
        	JSONObject jo = new JSONObject();
			jo.put("type", "question");
			jo.put("id", question.getQuestionId());
			jo.put("question",question.getQuestion());
			array.add(jo);

        }
        for(String cat : popCats){
        	JSONObject jo = new JSONObject();
			jo.put("type", "category");
			jo.put("category",cat);
			array.add(jo);

        }
		response.getWriter().write(array.toJSONString());
		logger.info("Entered doPost method of GetMostViwedAndPopularTagsController");
	}

}
