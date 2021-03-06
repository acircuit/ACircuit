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
import ac.dto.AdvisorLanguageDTO;
import ac.dto.AdvisorSkillsDTO;
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.SubCategoryDTO;
import ac.jdbc.ConnectionFactory;

public class CacheDAO {
	private static final Logger logger = Logger.getLogger(CacheDAO.class);
	Connection conn = null;
	
	public List<AdvisorDTO> GetAdvisorsProfiledetails(){
		logger.info("Entered GetAdvisorsProfiledetails method of CacheDAO");
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisordetails WHERE ISACTIVE=?";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
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
				advisor.setLinkedIn(results.getString("LINKEDIN_PROFILE_LINK"));
				advisor.setIntro(results.getString("INTRODUCTION"));
				advisor.setExperience(results.getString("EXPERIENCE"));
				advisor.setPhone(results.getBoolean("PHONE"));
				advisor.setVideo(results.getBoolean("VIDEO"));
				advisor.setImage(results.getString("IMAGE"));
				advisor.setPhonePrice(results.getDouble("PHONE_PRICE"));
				advisor.setVideoPrice(results.getDouble("VIDEO_PRICE"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorsProfiledetails method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorsProfiledetails method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorsProfiledetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorsProfiledetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorsProfiledetails method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorsProfiledetails method of CacheDAO");
		return advisors;
	}
	
	public List<EducationDTO> GetAdvisorEducationDetails(){
		logger.info("Entered GetAdvisorEducationDetails method of CacheDAO");
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
				logger.error("GetAdvisorEducationDetails method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorEducationDetails method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorEducationDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorEducationDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorEducationDetails method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorEducationDetails method of CacheDAO");
		return advisors;
	}
	
	public List<ProfessionalBackgroundDTO> GetAdvisorProfessionalDetails(){
		logger.info("Entered GetAdvisorProfessionalDetails method of CacheDAO");
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
				logger.error("GetAdvisorProfessionalDetails method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorProfessionalDetails method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorProfessionalDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorProfessionalDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorProfessionalDetails method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorProfessionalDetails method of CacheDAO");
		return advisors;
	}
	
	public List<CategoryDTO> GetCategoryDetails(){
		logger.info("Entered GetCategoryDetails method of CacheDAO");
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
				logger.error("GetCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetCategoryDetails method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetCategoryDetails method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetCategoryDetails method of CacheDAO");
		return advisors;
	}
	
	public List<SubCategoryDTO> GetSubCategoryDetails(){
		logger.info("Entered GetSubCategoryDetails method of CacheDAO");
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
				advisor.setId(results.getInt("SUB_CATEGORY_ID"));
				advisors.add(advisor);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetSubCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetSubCategoryDetails method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSubCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSubCategoryDetails method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSubCategoryDetails method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetSubCategoryDetails method of CacheDAO");
		return advisors;
	}
	
	
	public List<String> GetAdvisorInstitutions(){
		logger.info("Entered GetAdvisorInstitutions method of CacheDAO");
		List<String> institutions = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  DISTINCT INSTITUTION FROM advisoreducation ORDER BY INSTITUTION";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
					institutions.add(results.getString("INSTITUTION"));
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorInstitutions method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorInstitutions method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorInstitutions method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorInstitutions method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorInstitutions method of CacheDAO");
		return institutions;
	}
	
	public List<String> GetLanguages(){
		logger.info("Entered GetLanguages method of CacheDAO");
		List<String> languages = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  DISTINCT LANGUAGE_KNOWN FROM advisorlanguage ORDER BY LANGUAGE_KNOWN";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				languages.add(results.getString("LANGUAGE_KNOWN"));
			}
		} catch (SQLException e) {
			logger.error("GetLanguages method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetLanguages method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetLanguages method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetLanguages method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetLanguages method of CacheDAO");
		return languages;
	}
	
	public List<String> GetIndustries(){
		logger.info("Entered GetIndustries method of CacheDAO");
		List<String> industries = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  DISTINCT INDUSTRY FROM advisordetails WHERE ISVERIFIED=? AND ISACTIVE=? ORDER BY INDUSTRY";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, true);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				industries.add(results.getString("INDUSTRY"));
			}
		} catch (SQLException e) {
			logger.error("GetIndustries method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetIndustries method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetIndustries method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetIndustries method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetIndustries method of CacheDAO");
		return industries;
	}
	
	public List<Integer> GetCategoryId(String type){
		logger.info("Entered GetCategoryId method of CacheDAO");
		List<Integer> catId = new ArrayList<Integer>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = null;
			String query="";
			query = "SELECT  CATEGORY_ID FROM advisor_category WHERE CATEGORY=?";	
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, type);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				catId.add(results.getInt("CATEGORY_ID"));
			}
		} catch (SQLException e) {
			logger.error("GetCategoryId method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCategoryId method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCategoryId method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetCategoryId method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetCategoryId method of CacheDAO");
		return catId;
	}
	public List<String> GetIndustrySubCategories(){
		logger.info("Entered GetIndustrySubCategories method of CacheDAO");
		List<String> subs = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM industry";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				subs.add(results.getString("SUBCATEGORY"));
			}
		} catch (SQLException e) {
			logger.error("GetIndustrySubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetIndustrySubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetIndustrySubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetIndustrySubCategories method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetIndustrySubCategories method of CacheDAO");
		return subs;
	}
	
	public List<AdvisorLanguageDTO> GetAdvisorLanguage(){
		logger.info("Entered GetAdvisorLanguage method of CacheDAO");
		List<AdvisorLanguageDTO> language = new ArrayList<AdvisorLanguageDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT  * FROM advisorlanguage";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorLanguageDTO lang = new AdvisorLanguageDTO();
				lang.setAdvisor_id(results.getInt("ADVISOR_ID"));
				lang.setLanguage(results.getString("LANGUAGE_KNOWN"));
				language.add(lang);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorLanguage method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorLanguage method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorLanguage method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorLanguage method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorLanguage method of CacheDAO");
		return language;
	}
	
	public List<String> GetHigherStudiesSubCategory(){
		logger.info("Entered GetHigherStudiesSubCategory method of CacheDAO");
		List<String> higher = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT  * FROM higherstudies";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				higher.add(results.getString("SUBCATEGORY"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetHigherStudiesSubCategory method of CacheDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetHigherStudiesSubCategory method of CacheDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetHigherStudiesSubCategory method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetHigherStudiesSubCategory method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetHigherStudiesSubCategory method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetHigherStudiesSubCategory method of CacheDAO");
		return higher;
	}
	
	public List<String> GetOptionsSubCategories(){
		logger.info("Entered GetOptionsSubCategories method of CacheDAO");
		List<String> subs = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM options";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				subs.add(results.getString("SUBCATEGORY"));
			}
		} catch (SQLException e) {
			logger.error("GetOptionsSubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetOptionsSubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetOptionsSubCategories method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetOptionsSubCategories method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetOptionsSubCategories method of CacheDAO");
		return subs;
	}
	
	
	public List<AdvisorSkillsDTO> GetAdvisorSkills(){
		logger.info("Entered GetAdvisorSkills method of CacheDAO");
		List<AdvisorSkillsDTO> skills = new ArrayList<AdvisorSkillsDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM advisorskills";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorSkillsDTO skill = new AdvisorSkillsDTO();
				skill.setId(results.getInt("ID"));
				skill.setSubId(results.getInt("SUBCATEGORY_ID"));
				skill.setSkill(results.getString("SKILL"));
				skills.add(skill);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorSkills method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorSkills method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorSkills method of CacheDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorSkills method of CacheDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorSkills method of CacheDAO");
		return skills;
	}
	
	private String generateQsForIn(int numQs) {
		String items = "";
		for (int i = 0; i < numQs; i++) {
			if (i != 0)
				items += ", ";
			items += "?";
		}
		return items;
	}
	
}
