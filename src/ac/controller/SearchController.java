package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import ac.cache.MyCacheBuilder;
import ac.dao.SearchDAO;
import ac.dto.AdvisorDTO;
import ac.dto.SearchSuggestionsDTO;
import ac.dto.Trie;
import ac.util.LuceneAnalyzer;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SearchController.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This servlet retrieves the keyword and checks if there is a result
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of SearchController");
		String keyWord = request.getParameter("word");
		String word = keyWord.toLowerCase();
		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
		Analyzer analyzer = new StandardAnalyzer();
		LuceneAnalyzer token = new LuceneAnalyzer();
		List<String> tokens= token.tokenizeString(analyzer, word);
		//Search the keyword in Keywords column
		ac.dao.SearchDAO dao = new ac.dao.SearchDAO();
		list = dao.CheckInKeyWords(tokens);
		if(list.size() > 0){
			//Check if the keywords is in the Trie
			Trie trie = MyCacheBuilder.trie;
			List<String> words = trie.findCompletions(word);
			if(words.size() > 0){
				// Increase the Hit of the word.
				Map<String, Integer> map = MyCacheBuilder.map;
				int hit = map.get(word);
				map.remove(word);
				map.put(word, hit+1);
				response.sendRedirect("Sample.jsp");
			}else{
				// If the keywors is not in the Trie, Then update trie, map and suf=ggestions table
				//Updating table
				//Put the search keyword in the table
				ac.dao.SearchDAO key = new ac.dao.SearchDAO();
				Boolean isCommit = key.PutSearchKeyWordInSuggestionTable(word);
				MyCacheBuilder cacheBuilder1 = MyCacheBuilder .getCacheBuilder();
				Map<String, Integer> map = MyCacheBuilder.map;
				Trie trie1 = MyCacheBuilder.trie;
				trie1.load(keyWord);
				map.put(keyWord, 1);
				response.sendRedirect("Sample.jsp");

			}

		}else{
			//check if the keywords exists in the notsuggested table
			SearchSuggestionsDTO dto = new SearchSuggestionsDTO();
			SearchDAO notSuggested = new SearchDAO();
			dto = notSuggested.CheckInNotSuggested(word);
			if(dto.getId() != 0){
				//Increment hits
				SearchDAO inc = new SearchDAO();
				Boolean isIncrementCommit = inc.IncrementKeyWordHit(word);
				response.sendRedirect("Sample.jsp");
			}else{
				//insert the keyword in notsuggested table
				SearchDAO insert = new SearchDAO();
				Boolean isInserted = insert.InsertKeywordInNotSuggested(word);
				response.sendRedirect("Sample.jsp");
			}
		}
		
		logger.info("Exit doGet method of SearchController");
	}

}
