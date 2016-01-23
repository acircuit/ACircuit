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
import ac.dto.AdvisorDTO;
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
		QuestionsDAO adv = new QuestionsDAO();
		List<AdvisorDTO> advisors = adv.GetAdvisorName(list);
		 int totalAnswers = 0;
		for(QuestionsDTO que1 : ques) {
			JSONObject jo = new JSONObject();
			jo.put("id", que1.getQuestionId());
			if(que1.getCategory().equals("studies")){
				jo.put("category", "Higher Studies");
			}else if (que1.getCategory().equals("industry")) {
				jo.put("category", "Career & Jobs");

			}else if (que1.getCategory().equals("options")) {
				jo.put("category", "Course");
			}
			jo.put("subcategory",que1.getSubcategory());
			jo.put("question",que1.getQuestion());
			
		 int count=0;
		 for(AnswerDTO ans : list){
			if(que1.getQuestionId() == ans.getQuestionId()){
				 count ++;
				 totalAnswers++;
				 jo.put("lastupdated", format.format(ans.getTime()));

				 for(AdvisorDTO advisor : advisors){

				 if(ans.getAdvisor_id() ==advisor.getId() ){
					 JSONObject ao = new JSONObject();
					 ao.put("answer", ans.getAnswer());

					 ao.put("name", advisor.getName());
					 array.add(ao);
				 }
				 }
			 }
		 }
		 jo.put("count", count);
		 array.add(jo);
		}
		JSONObject jo = new JSONObject();
		jo.put("totalanswers", totalAnswers);
		array.add(jo);
		System.out.println(array.size());

		response.getWriter().write(array.toJSONString());
		
		
		logger.info("Entered doPost method of GetSubcategoryQuestionsController");
	}

}
