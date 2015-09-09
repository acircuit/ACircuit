package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;
import ac.jdbc.ConnectionFactory;

public class QuestionsDAO {
	private static final Logger logger = Logger.getLogger(QuestionsDAO.class);
	Connection conn = null;
	
	public List<QuestionsDTO> GetAllQuestions(){
		logger.info("Entered GetAllQuestions method of QuestionsDAO");
		List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT * FROM questions WHERE ISANSWERED=?";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			QuestionsDTO question = new QuestionsDTO();
			question.setQuestionId(results.getInt("Q_ID"));
			question.setQuestion(results.getString("QUESTION"));
			question.setCategory(results.getString("CATEGORY"));
			question.setSubcategory(results.getString("SUBCATEGORY"));
			list.add(question);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAllQuestions method of QuestionsDAO");
		return list;

	}
	
	public Boolean SubmitQuestion(String question,String category,String subcategory){
		logger.info("Entered SubmitQuestion method of QuestionsDAO");
		Boolean isCommit = false;
		Calendar mbCal = new GregorianCalendar(TimeZone.getTimeZone("IST"));  
        mbCal.setTimeInMillis(new Date().getTime());      
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));  
        cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));  
        cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));  
        cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));  
        cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));  
        cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));  
        cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
        Date date = cal.getTime();
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into questions "+"(QUESTION,CATEGORY,SUBCATEGORY,TIMESTAMP) values" + "(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question);
			pstmt.setString(2, category);
			pstmt.setString(3, subcategory);
			pstmt.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}else{
				isCommit = false;
				conn.rollback();
			}
		}catch (SQLException e) {
				logger.error("SubmitQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SubmitQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SubmitQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		logger.info("Exit SubmitQuestion method of QuestionsDAO");
		return isCommit;	
	}
	
	public List<AnswerDTO> GetAnswers(List<QuestionsDTO> questions) {
		logger.info("Entered GetAnswers method of QuestionsDAO");
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(questions.size());
			String query = "SELECT * FROM answers WHERE QID IN ( "
					+ q4in + " )";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			int i = 1;
			for (QuestionsDTO item : questions) {
				pstmt.setInt(i++, item.getQuestionId());
			}
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AnswerDTO que = new AnswerDTO();
				que.setAdvisor_id(results.getInt("AID"));
				que.setQuestionId(results.getInt("QID"));
				que.setAnswer(results.getString("ANSWER"));
				list.add(que);
			}
			logger.info("Exit GetAnswers method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAnswers method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetAnswers method of QuestionsDAO");
		return list;
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
