package ac.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.log4j.Logger;
import ac.dao.SuggestionDAO;
import ac.dto.SearchSuggestionsDTO;
import ac.dto.Trie;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;


public class MyCacheBuilder
{

	/**
	 * All the get method will be called from ur service layer, for most of the get cache wud be last point, no DB
	 * once you add/edit/delete the db entry alsp update the cache
	 */


	private static final CacheManager cacheManager = new CacheManager();

	//cache for advisor
	private Ehcache searchCache;
	private static final Logger logger = Logger.getLogger(MyCacheBuilder.class);
	public  static final Trie trie = new Trie();
	public  static final 		Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	// cache for filters
	//private Ehcache filterCache;

	//other filters

	private MyCacheBuilder()
	{
		//create all cache here, you can configure each cache, in ehcache.xml (must be in classpth)
		cacheManager.addCache("SearchCache");
		searchCache = cacheManager.getEhcache( "SearchCache" );
		System.out.println("search cache="+searchCache );
		System.out.println("Search manager="+cacheManager);
		//filterCache = cacheManager.getEhcache( "FilterCache" );
	}

/*	public void addSearchWord(String word, SearchDTO searchWord){
		Element element = searchCache.get( word );
		if( element != null ){
			List<SearchDTO> strList=(List<SearchDTO>)element.getValue();
			strList.add(searchWord);
		}else{
			element = new Element( searchWord.getWord(), searchWord );
			searchCache.put(element);
		}
	}*/
	/*public void addTrie(Trie trie,HashMap<String, Integer> map){
		Element element = new Element( 1, trie );
		searchCache.put(element);
		Element element1 = new Element( 2, map );
		searchCache.put(element1);
	}*/


/*	@SuppressWarnings("deprecation")
	public List<SearchDTO> getSearchWord(String word){
		Element element = searchCache.get( word );
		if( element != null )
		{
			return null;
		}else{
			return null;
		}

		// We don't have the object in the cache so return null, or fetch it from DB
		// or logic to fetch latest result from DB. : But you dont need it.

	}*/
	
	/*public Trie getTrie(){
		return trie;

	}
	
	public HashMap<String, Integer> getMap(){
		Element element = searchCache.get(2);
		if( element != null )
		{
			return (HashMap<String, Integer>) element.getValue();
		}else{
			return null;
		}

	}*/



	/**
	 * Building cache for : 
	 * 1) Search Suggestions keywords
	 */
	public void build(){
		logger.info("Building Cache");
		//System.out.println("Building Cache");
		// Building Trie and Map for the search suggestions.
		List<SearchSuggestionsDTO> suggest = new ArrayList<SearchSuggestionsDTO>();
		SuggestionDAO dao = new SuggestionDAO();
		suggest = dao.GetSearchSuggestionsForCache();
		for (SearchSuggestionsDTO suggestion : suggest) {
			trie.load(suggestion.getWord());
			map.put(suggestion.getWord(), suggestion.getHits());
		}
		logger.info("Cache Built");
		//System.out.println("Cache Built");
	}

	public void getMainPageAdvisorList(){

		// get the all advisor list from here for display at any page.. etc 
	}

	/**
	 * Remove all the cache here, setting all to null ...or evict all
	 */
	public void destroy() {
		cacheManager.clearAll();
	}


	/**
	 * Implementing singleton design pattern
	 * @author pranav
	 *
	 */
	static class SingletonHolder{
		private static final MyCacheBuilder INSTANCE = new MyCacheBuilder();
	}

	public static MyCacheBuilder getCacheBuilder() {
		return SingletonHolder.INSTANCE;
	}

}
