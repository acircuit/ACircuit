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

import ac.dto.SearchSuggestionsDTO;
import ac.jdbc.ConnectionFactory;

public class SuggestionDAO {
	private static final Logger logger = Logger.getLogger(SuggestionDAO.class);
	Connection conn = null;
	
	
	
	//This method will get all the search keywords for the suggestions from the suggestions table.
	public List<SearchSuggestionsDTO> GetSearchSuggestionsForCache(){
		logger.info("Entered GetSearchSuggestions method of SuggestionDAO");
		List<SearchSuggestionsDTO> list = new ArrayList<SearchSuggestionsDTO>();
		String query = "SELECT * FROM suggestions";
		try {
			PreparedStatement pstmt;
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				SearchSuggestionsDTO dto = new SearchSuggestionsDTO();
				dto.setId(results.getInt("ID"));
				dto.setWord(results.getString("KEYWORD"));
				dto.setHits(results.getInt("HITS"));
				list.add(dto);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetSearchSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetSearchSuggestions method of SuggestionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSearchSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSearchSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("Exit GetSearchSuggestions method of SuggestionDAO");
			} catch (SQLException e) {
				logger.error("GetSearchSuggestions method of SuggestionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	    return list;	
	}
	
	public List<String> GetIndustrySuggestions(String industry){
		logger.info("Entered GetIndustrySuggestions method of SuggestionDAO");
		List<String> list = new ArrayList<String>();
		String query = "SELECT DISTINCT INDUSTRY FROM advisordetails WHERE ISACTIVE=? AND ISVISIBLE=? AND INDUSTRY LIKE ?";
		try {
			PreparedStatement pstmt;
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, true);
			pstmt.setString(3,industry+'%');
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getString("INDUSTRY"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetIndustrySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetIndustrySuggestions method of SuggestionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetIndustrySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetIndustrySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("Exit GetIndustrySuggestions method of SuggestionDAO");
			} catch (SQLException e) {
				logger.error("GetIndustrySuggestions method of SuggestionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	    return list;	
	}
	
	public List<String> GetCourseSuggestions(String course){
		logger.info("Entered GetCourseSuggestions method of SuggestionDAO");
		List<String> list = new ArrayList<String>();
		String query = "SELECT DISTINCT advisoreducation.COURSE FROM advisoreducation INNER JOIN advisordetails ON advisoreducation.ADVISOR_ID=advisordetails.ADVISOR_ID WHERE advisordetails.ISACTIVE=? AND advisordetails.ISVISIBLE=? AND advisoreducation.COURSE LIKE ?";
		try {
			PreparedStatement pstmt;
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, true);
			pstmt.setString(3,course+'%');
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getString("COURSE"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetCourseSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetCourseSuggestions method of SuggestionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCourseSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCourseSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("Exit GetCourseSuggestions method of SuggestionDAO");
			} catch (SQLException e) {
				logger.error("GetCourseSuggestions method of SuggestionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	    return list;	
	}
	
	public List<String> GetInstitutionSuggestions(String course){
		logger.info("Entered GetInstitutionSuggestions method of SuggestionDAO");
		List<String> list = new ArrayList<String>();
		String query = "SELECT DISTINCT advisoreducation.INSTITUTION FROM advisoreducation INNER JOIN advisordetails ON advisoreducation.ADVISOR_ID=advisordetails.ADVISOR_ID WHERE advisordetails.ISACTIVE=? AND advisordetails.ISVISIBLE=? AND advisoreducation.INSTITUTION LIKE ?";
		try {
			PreparedStatement pstmt;
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, true);
			pstmt.setString(3,course+'%');
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getString("INSTITUTION"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetInstitutionSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetInstitutionSuggestions method of SuggestionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetInstitutionSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetInstitutionSuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("Exit GetInstitutionSuggestions method of SuggestionDAO");
			} catch (SQLException e) {
				logger.error("GetInstitutionSuggestions method of SuggestionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	    return list;	
	}
	
	public List<String> GetCompanySuggestions(String course){
		logger.info("Entered GetCompanySuggestions method of SuggestionDAO");
		List<String> list = new ArrayList<String>();
		String query = "SELECT DISTINCT advisorprofessionalbackground.COMPANY FROM advisorprofessionalbackground INNER JOIN advisordetails ON advisorprofessionalbackground.ADVISOR_ID=advisordetails.ADVISOR_ID WHERE advisordetails.ISACTIVE=? AND advisordetails.ISVISIBLE=? AND advisorprofessionalbackground.COMPANY LIKE ?";
		try {
			PreparedStatement pstmt;
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, true);
			pstmt.setString(3,course+'%');
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getString("COMPANY"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetCompanySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetCompanySuggestions method of SuggestionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCompanySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCompanySuggestions method of SuggestionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("Exit GetCompanySuggestions method of SuggestionDAO");
			} catch (SQLException e) {
				logger.error("GetCompanySuggestions method of SuggestionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	    return list;	
	}
	
}
