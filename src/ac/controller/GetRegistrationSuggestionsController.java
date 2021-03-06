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

import ac.dao.SuggestionDAO;

/**
 * Servlet implementation class GetRegistrationSuggestionsController
 */
@WebServlet("/GetRegistrationSuggestionsController")
public class GetRegistrationSuggestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(GetRegistrationSuggestionsController.class);   


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetRegistrationSuggestionsController");
		String industry = request.getParameter("industry");
		if(industry != null && !industry.equals("")){
			List<String> list = new ArrayList<String>();
			SuggestionDAO indsugg = new SuggestionDAO();
			list = indsugg.GetIndustrySuggestions(industry);
		    JSONArray array = new JSONArray();
			for (String word : list) {
				System.out.println(word);
				JSONObject jo = new JSONObject();
				jo.put("word", word);
				array.add(jo);
				//data = data+"<p>"+word+"</p><br><p>Hits:"+map.get(word)+"</p>";
			}
			if(array.isEmpty()){
			  response.getWriter().write("nosuggestion");
			}else{
				  response.getWriter().write(array.toJSONString());
			}
		}
		
		
		
		
		logger.info("Entered doPost method of GetRegistrationSuggestionsController");
	}

}
