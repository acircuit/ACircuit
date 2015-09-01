package ac.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ac.cache.MyCacheBuilder;
import ac.dto.SearchSuggestionsDTO;
import ac.dto.Trie;


/**
 * Servlet implementation class GetSuggestionsController
 */
@WebServlet("/GetSuggestionsController")
public class GetSuggestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(GetSuggestionsController.class);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * This method will retrieve the suggestions using the keyword and then retuen a json object
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of GetSuggestionsController");
		String kword = request.getParameter("word");
		Trie trie = MyCacheBuilder.trie;
		if(trie != null){
			List<String> words = trie.findCompletions(kword);
			Map<String, Integer> map = MyCacheBuilder.map;
			String data="";
		    JSONArray array = new JSONArray();
			for (String word : words) {
				JSONObject jo = new JSONObject();
				jo.put("word", word);
				jo.put("hits", map.get(word));
				array.add(jo);
				//data = data+"<p>"+word+"</p><br><p>Hits:"+map.get(word)+"</p>";
			}
			response.setContentType("application/json");
			if(array.isEmpty()){
			  response.getWriter().write("no suggestion");
			}else{
				  response.getWriter().write(array.toJSONString());
			}
			logger.info("Exit doPost method of GetSuggestionsController");
		}

	}

}
