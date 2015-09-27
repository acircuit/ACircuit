package ac.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import ac.dao.CacheDAO;
import ac.dao.SuggestionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.AdvisorLanguageDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SearchSuggestionsDTO;
import ac.dto.SubCategoryDTO;
import ac.dto.Trie;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;


public class MyCacheBuilder
{

	/**
	 * All the get method will be called from ur service layer, for most of the get cache wud be last point, no DB
	 * once you add/edit/delete the db entry alsp update the cache
	 */


	private static final CacheManager cacheManager = new CacheManager();

	//cache for advisor
	private Ehcache searchCache;
	private Ehcache advisorProfileCache;
	private Ehcache filterCache;
	private Ehcache subCategoryCache;
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
		cacheManager.addCache("AdvisorProfileCache");
		cacheManager.addCache("FilterCache");
		cacheManager.addCache("SubCategoryCache");
		
		searchCache = cacheManager.getEhcache( "SearchCache" );
		CacheConfiguration config = searchCache.getCacheConfiguration(); 
		config.setEternal(true);
		advisorProfileCache = cacheManager.getEhcache( "AdvisorProfileCache" );
		CacheConfiguration config1 = advisorProfileCache.getCacheConfiguration(); 
		config1.setEternal(true);
		filterCache = cacheManager.getEhcache( "FilterCache" );
		CacheConfiguration config2 = filterCache.getCacheConfiguration(); 
		config2.setEternal(true);
		subCategoryCache= cacheManager.getEhcache( "SubCategoryCache" );
		CacheConfiguration config3 = subCategoryCache.getCacheConfiguration(); 
		config3.setEternal(true);
	}
	public void addAdvisor(AdvisorDTO advisor){
		Element element = new Element( advisor.getId(), advisor );
		advisorProfileCache.put(element);
	}
	
	public AdvisorDTO getAdvisor(int id){
		Element element = advisorProfileCache.get(id);
		if( element != null )
		{
			return (AdvisorDTO)element.getValue();
		}else{
			return null;
		}
	}
	
	public void addFilters(List<String> institutions, List<String> industries, List<String> languages ){
		Element element = new Element( 1, institutions );
		filterCache.put(element);
		Element element1 = new Element( 2, industries );
		filterCache.put(element1);
		
		Element lang = new Element( 3, languages );
		filterCache.put(lang);
	}
	public List<String> getIndustryFilterValues(){
		Element element = filterCache.get(2);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
	}
	
	public List<String> getInstitutionsFilterValues(){
		Element element = filterCache.get(1);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
	}
	
	public void addSubCategories(List<String> higherStudiesSubCaegory,List<String> industrySub,List<String> optionSub){
		Element element = new Element( 1, higherStudiesSubCaegory );
		subCategoryCache.put(element);
		Element element1 = new Element( 2, industrySub );
		subCategoryCache.put(element1);
		
		Element element2 = new Element( 3, optionSub );
		subCategoryCache.put(element2);
	}
	
	public List<String> getHigherStudiesSubCategory(){
		Element element = subCategoryCache.get(1);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
	}
	public List<String> getIndustrySubCategory(){
		Element element = subCategoryCache.get(2);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
	}
	public List<String> getOpionsSubCategory(){
		Element element = subCategoryCache.get(3);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
	}
	
	
	
	public List<String> getLanguagesFilterValues(){
		Element element = filterCache.get(3);
		if( element != null )
		{
			return (List<String>)element.getValue();
		}else{
			return null;
		}
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
		// Building Trie and Map for the search suggestions.
		List<SearchSuggestionsDTO> suggest = new ArrayList<SearchSuggestionsDTO>();
		SuggestionDAO dao = new SuggestionDAO();
		suggest = dao.GetSearchSuggestionsForCache();
		for (SearchSuggestionsDTO suggestion : suggest) {
			trie.load(suggestion.getWord());
			map.put(suggestion.getWord(), suggestion.getHits());
		}
		
		logger.info("Building AdvisorProfileCache");

		//Building Advisors cache
		List<AdvisorDTO> advisorProfile = new ArrayList<AdvisorDTO>();
		CacheDAO advisor = new CacheDAO();
		advisorProfile = advisor.GetAdvisorsProfiledetails();
		
		//Getting the education info
		List<EducationDTO> education = new ArrayList<EducationDTO>();
		CacheDAO advisorEducation = new CacheDAO();
		education = advisorEducation.GetAdvisorEducationDetails();
		
		//Getting professional background
		List<ProfessionalBackgroundDTO> profession = new ArrayList<ProfessionalBackgroundDTO>();
		CacheDAO advisorProfession = new CacheDAO();
		profession = advisorProfession.GetAdvisorProfessionalDetails();
		
		//Fetching advisor categories
		List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		CacheDAO category = new CacheDAO();
		categories = category.GetCategoryDetails();
		
		//Fetching advisor sub categories
		List<SubCategoryDTO> subCategories = new ArrayList<SubCategoryDTO>();
		CacheDAO subCategory = new CacheDAO();
		subCategories = subCategory.GetSubCategoryDetails();
		
		//Fetching languages for an advisor
		List<AdvisorLanguageDTO> language = new ArrayList<AdvisorLanguageDTO>();
		CacheDAO lang = new CacheDAO();
		language = lang.GetAdvisorLanguage();
		
		for(AdvisorDTO adv : advisorProfile){
			List<EducationDTO> educ = new ArrayList<EducationDTO>();
			List<ProfessionalBackgroundDTO> prof = new ArrayList<ProfessionalBackgroundDTO>();
			List<CategoryDTO> categ= new ArrayList<CategoryDTO>();
			List<SubCategoryDTO> sub = new ArrayList<SubCategoryDTO>();
			List<AdvisorLanguageDTO> advLanguage = new ArrayList<AdvisorLanguageDTO>();

			for(EducationDTO edu : education){
				if(edu.getAdvisorId() == adv.getId()){
					educ.add(edu);
				}
			}
			adv.setEducation(educ);
			for(ProfessionalBackgroundDTO pro : profession){
				if(pro.getAdvisorId() == adv.getId()){
					prof.add(pro);
				}
			}
			adv.setProfession(prof);
			for(CategoryDTO cat : categories){
				if(cat.getAdvisorId() == adv.getId()){
					categ.add(cat);
				}
			}
			adv.setCategories(categ);
			for(SubCategoryDTO subCat : subCategories){
				if(subCat.getAdvisorId() == adv.getId()){
					sub.add(subCat);
				}
			}
			adv.setSubCategories(sub);
			for(AdvisorLanguageDTO lan : language){
				if(lan.getAdvisor_id() == adv.getId()){
					advLanguage.add(lan);
				}
			}
			adv.setLanguage(advLanguage);
			addAdvisor(adv);
		}
		
		
		logger.info("Building FilterCache");
		
		//Getting all the filter values
		//Getting all institutions from advisor education table
		List<String> institutions = new ArrayList<String>();
		CacheDAO institute = new CacheDAO();
		institutions = institute.GetAdvisorInstitutions();
		
		//Getting all industries from the advisordetails table
		List<String> industries = new ArrayList<String>();
		CacheDAO industry = new CacheDAO();
		industries = industry.GetIndustries();
		
		//Getting all languages from the advisorlanguage table
		List<String> languages = new ArrayList<String>();
		CacheDAO languag = new CacheDAO();
		languages = languag.GetLanguages();
		
		addFilters(institutions, industries,languages); 
		
		logger.info("Building SubCategory Cache");
		//Building Higher studies sub category

		
		//Building higher studies sub category
		List<String> higherStudiesSubCaegory = new ArrayList<String>();
		CacheDAO higher = new CacheDAO();
		higherStudiesSubCaegory = higher.GetHigherStudiesSubCategory();
		
		//Building Industry SubCategory
		List<Integer> industryCategoryId = new ArrayList<Integer>();
        //Getting the advisorids with category as industry

		List<String> subs = new ArrayList<String>();
		//Getting all the sub category
		CacheDAO subCat = new CacheDAO();
		subs = subCat.GetIndustrySubCategories();

		
		
		//Building Options sub category
		List<String> subs1 = new ArrayList<String>();
		CacheDAO subCat1 = new CacheDAO();
		subs1 = subCat1.GetOptionsSubCategories();
		addSubCategories(higherStudiesSubCaegory, subs,subs1); 
		
		
		logger.info("Cache Built");
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
	 *
	 */
	static class SingletonHolder{
		private static final MyCacheBuilder INSTANCE = new MyCacheBuilder();
	}

	public static MyCacheBuilder getCacheBuilder() {
		return SingletonHolder.INSTANCE;
	}

}
