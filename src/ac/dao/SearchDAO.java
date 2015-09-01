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
import ac.dto.SearchSuggestionsDTO;
import ac.jdbc.ConnectionFactory;


public class SearchDAO {
	private static final Logger logger = Logger.getLogger(SearchDAO.class);
	Connection conn = null;
	
	
	public List<AdvisorDTO> CheckInKeyWords(List<String> words){
		logger.info("Entered CheckInKeyWords method of SearchDAO");
		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			for (String word : words) {
				query = "SELECT count(*) DISTINCT ADVISOR_ID,NAME,INDUSTRY FROM advisordetails WHERE KEYWORDS LIKE ?";	
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, '%' + word + '%');
				ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorDTO dto = new AdvisorDTO();
				dto.setId(results.getInt("ADVISOR_ID"));
				dto.setName(results.getString("NAME"));
				dto.setIndustry(results.getString("INDUSTRY"));
				list.add(dto);
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
}
