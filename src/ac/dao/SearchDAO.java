package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SearchSuggestionsDTO;
import ac.dto.SubCategoryDTO;
import ac.jdbc.ConnectionFactory;


public class SearchDAO {
	private static final Logger logger = Logger.getLogger(SearchDAO.class);
	Connection conn = null;
	
	
	public List<Integer> CheckInKeyWords(List<String> words){
		logger.info("Entered CheckInKeyWords method of SearchDAO");
		List<Integer> list = new ArrayList<Integer>();

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			for (String word : words) {
				query = "SELECT DISTINCT ADVISOR_ID FROM advisordetails WHERE KEYWORDS LIKE ?";	
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, '%' + word + '%');
				ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			/*	AdvisorDTO dto = new AdvisorDTO();
				dto.setId(results.getInt("ADVISOR_ID"));
				dto.setName(results.getString("NAME"));
				dto.setIndustry(results.getString("INDUSTRY"));*/
				list.add(results.getInt("ADVISOR_ID"));
			}
		}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("CheckInKeyWords method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("CheckInKeyWords method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("CheckInKeyWords method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("CheckInKeyWords method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckInKeyWords method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit CheckInKeyWords method of SearchDAO");
		return list;

	}
	
	public Boolean PutSearchKeyWordInSuggestionTable(String keyWord){
		logger.info("Entered PutSearchKeyWordInSuggestionTable method of SearchDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into suggestions "+"(KEYWORD,HITS) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyWord);
			pstmt.setInt(2, 1);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}else{
				isCommit = false;
				conn.rollback();
			}
		}catch (SQLException e) {
				logger.error("PutSearchKeyWordInSuggestionTable method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("PutSearchKeyWordInSuggestionTable method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("PutSearchKeyWordInSuggestionTable method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		logger.info("Exit PutSearchKeyWordInSuggestionTable method of SearchDAO");
		return isCommit;	
	}
	
	public SearchSuggestionsDTO CheckInNotSuggested(String word){
		logger.info("Entered CheckInNotSuggested method of SearchDAO");
		SearchSuggestionsDTO dto = new SearchSuggestionsDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM notsuggested WHERE KEYWORDS =?";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,word);
			ResultSet results = pstmt.executeQuery();
			if (results.first()) {
				dto.setWord(results.getString("KEYWORDS"));
				dto.setId(results.getInt("ID"));
				dto.setHits(results.getInt("HITS"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("CheckInNotSuggested method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("CheckInNotSuggested method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("CheckInNotSuggested method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("CheckInNotSuggested method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckInNotSuggested method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit CheckInNotSuggested method of SearchDAO");
		return dto;
	}
	
	public Boolean IncrementKeyWordHit(String word){
		logger.info("Entered IncrementKeyWordHit method of SearchDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE notsuggested SET HITS=HITS+1 WHERE KEYWORDS = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, word);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}else{
				isCommit = false;
				conn.rollback();
			}
		}catch (SQLException e) {
				logger.error("IncrementKeyWordHit method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("IncrementKeyWordHit method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("IncrementKeyWordHit method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("IncrementKeyWordHit method of SearchDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
			logger.info("Exit IncrementKeyWordHit method of SearchDAO");
			return isCommit;
	}
	
	public Boolean InsertKeywordInNotSuggested(String keyWord){
		logger.info("Entered InsertKeywordInNotSuggested method of SearchDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into notsuggested "+"(KEYWORDS,HITS) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyWord);
			pstmt.setInt(2, 1);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}else{
				isCommit = false;
				conn.rollback();
			}
		}catch (SQLException e) {
				logger.error("InsertKeywordInNotSuggested method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertKeywordInNotSuggested method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertKeywordInNotSuggested method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		logger.info("Exit InsertKeywordInNotSuggested method of SearchDAO");
		return isCommit;	
	}
	
	public List<AdvisorDTO> GetAdvisorsProfiledetails(){
		logger.info("Entered GetAdvisorsProfiledetails method of SearchDAO");
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisordetails";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorDTO advisor = new AdvisorDTO();
				advisor.setId(results.getInt("ADVISOR_ID"));
				advisor.setName(results.getString("NAME"));
				advisor.setGender(results.getString("GENDER"));
				advisor.setAge(results.getInt("AGE"));
				advisor.setPhoneNo(results.getString("PHONE_NUMBER"));
				advisor.setEmail(results.getString("EMAIL"));
				advisor.setCity(results.getString("CITY"));
				advisor.setIndustry(results.getString("INDUSTRY"));
				advisor.setLanguagesKnown(results.getString("LANGUAGE_KNOWN"));
				advisor.setLinkedIn(results.getString("LINKEDIN_PROFILE_LINK"));
				advisor.setIntro(results.getString("INTRODUCTION"));
				advisor.setExperience(results.getString("EXPERIENCE"));
				advisor.setPhone(results.getBoolean("PHONE"));
				advisor.setVideo(results.getBoolean("VIDEO"));
				advisor.setImage(results.getString("IMAGE"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorsProfiledetails method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorsProfiledetails method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorsProfiledetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorsProfiledetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorsProfiledetails method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorsProfiledetails method of SearchDAO");
		return advisors;
	}
	
	public List<EducationDTO> GetAdvisorEducationDetails(){
		logger.info("Entered GetAdvisorEducationDetails method of SearchDAO");
		List<EducationDTO> advisors = new ArrayList<EducationDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisoreducation";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				EducationDTO advisor = new EducationDTO();
				advisor.setAdvisorId(results.getInt("ADVISOR_ID"));
				advisor.setCourse(results.getString("COURSE"));
				advisor.setDuration(results.getString("DURATION"));
				advisor.setInstitution(results.getString("INSTITUTION"));
				advisor.setType(results.getString("TYPE"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorEducationDetails method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorEducationDetails method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorEducationDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorEducationDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorEducationDetails method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorEducationDetails method of SearchDAO");
		return advisors;
	}
	
	public List<ProfessionalBackgroundDTO> GetAdvisorProfessionalDetails(){
		logger.info("Entered GetAdvisorProfessionalDetails method of SearchDAO");
		List<ProfessionalBackgroundDTO> advisors = new ArrayList<ProfessionalBackgroundDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisorprofessionalbackground";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				ProfessionalBackgroundDTO advisor = new ProfessionalBackgroundDTO();
				advisor.setAdvisorId(results.getInt("ADVISOR_ID"));
				advisor.setCompany(results.getString("COMPANY"));
				advisor.setDesignation(results.getString("DESIGNATION"));
				advisor.setDuration(results.getString("DURATION"));
				advisor.setIsCurrent(results.getBoolean("IS_CURRENT"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorProfessionalDetails method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorProfessionalDetails method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorProfessionalDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorProfessionalDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorProfessionalDetails method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorProfessionalDetails method of SearchDAO");
		return advisors;
	}
	
	public List<CategoryDTO> GetCategoryDetails(){
		logger.info("Entered GetCategoryDetails method of SearchDAO");
		List<CategoryDTO> advisors = new ArrayList<CategoryDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisor_category";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				CategoryDTO advisor = new CategoryDTO();
				advisor.setAdvisorId(results.getInt("ADVISOR_ID"));
				advisor.setCategory(results.getString("CATEGORY"));
				advisor.setCatId(results.getInt("CATEGORY_ID"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetCategoryDetails method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetCategoryDetails method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetCategoryDetails method of SearchDAO");
		return advisors;
	}
	
	public List<SubCategoryDTO> GetSubCategoryDetails(){
		logger.info("Entered GetSubCategoryDetails method of SearchDAO");
		List<SubCategoryDTO> advisors = new ArrayList<SubCategoryDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisor_subcategory";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				SubCategoryDTO advisor = new SubCategoryDTO();
				advisor.setAdvisorId(results.getInt("ADVISOR_ID"));
				advisor.setCategoryId(results.getInt("CATEGORY_ID"));
				advisor.setSubCategory(results.getString("SUBCATEGORY"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetSubCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetSubCategoryDetails method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSubCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSubCategoryDetails method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSubCategoryDetails method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetSubCategoryDetails method of SearchDAO");
		return advisors;
	}
	
	public String GetAdvisorsUsingCategory(String type){
		logger.info("Entered GetAdvisorsUsingCategory method of SearchDAO");
		String ids = "";
		String	query ="";
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt;
			if(type.equals("higherstudies")){
				query = "SELECT ADVISOR_ID FROM advisor_category WHERE CATEGORY = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "studies");
			}else if (type.equals("industry")) {
				query = "SELECT ADVISOR_ID FROM advisor_category WHERE CATEGORY = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "industry");
			}else if (type.equals("options")) {
				query = "SELECT ADVISOR_ID FROM advisor_category WHERE CATEGORY = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "options");
			}else{
				query = "SELECT ADVISOR_ID FROM advisordetails";
				pstmt = conn.prepareStatement(query);
			}
			
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				ids = ids+ results.getInt("ADVISOR_ID")+":";
			}
			if(!ids.equals("")){
			   int pos = ids.lastIndexOf(':');
			   ids = ids.substring(0, pos);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorsUsingCategory method of SearchDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorsUsingCategory method of SearchDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorsUsingCategory method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorsUsingCategory method of SearchDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorsUsingCategory method of SearchDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorsUsingCategory method of SearchDAO");
		return ids;

	}
	
}
