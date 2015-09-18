package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;





import ac.dto.AdvisorDTO;
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
	
	public int SubmitQuestion(int userId,String question,String category,String subcategory){
		logger.info("Entered SubmitQuestion method of QuestionsDAO");
		int id = 0;
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
			String query = "insert into questions "+"(QUESTION,CATEGORY,SUBCATEGORY,TIMESTAMP,U_ID) values" + "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, question);
			pstmt.setString(2, category);
			pstmt.setString(3, subcategory);
			pstmt.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			pstmt.setInt(5, userId);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				}
				conn.commit();
			}else{
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
		return id;	
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
				que.setTime(results.getTimestamp("TIMESTAMP"));
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
	
	
	public QuestionsDTO GetQuestion( String qid){
		logger.info("Entered GetQuestion method of QuestionsDAO");
		QuestionsDTO question = new QuestionsDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT * FROM questions WHERE Q_ID=?";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,Integer.valueOf(qid) );
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			question.setQuestionId(results.getInt("Q_ID"));
			question.setQuestion(results.getString("QUESTION"));
			question.setCategory(results.getString("CATEGORY"));
			question.setSubcategory(results.getString("SUBCATEGORY"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetQuestion method of QuestionsDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAllQuestions method of QuestionsDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetQuestion method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetQuestion method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetQuestion method of QuestionsDAO");
		return question;

	}
	
	
	public List<AnswerDTO> GetAllAnswers(String q_id) {
		logger.info("Entered GetAllAnswers method of QuestionsDAO");
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM answers WHERE QID =?";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(q_id));
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AnswerDTO que = new AnswerDTO();
				que.setAdvisor_id(results.getInt("AID"));
				que.setQuestionId(results.getInt("QID"));
				que.setAnswer(results.getString("ANSWER"));
				que.setTime(results.getTimestamp("TIMESTAMP"));
				list.add(que);
			}
			logger.info("Exit GetAllAnswers method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetAllAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAllAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAllAnswers method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAllAnswers method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetAllAnswers method of QuestionsDAO");
		return list;
	}
	
	public List<AdvisorDTO> GetAdvisorDetails(List<Integer> aId) {
		logger.info("Entered GetAdvisorDetails method of QuestionsDAO");
		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(aId.size());
			String query = "SELECT ADVISOR_ID,NAME,IMAGE,INDUSTRY FROM advisordetails WHERE ADVISOR_ID IN ( "+ q4in + " )";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			int i = 1;
			for (Integer item : aId) {
				pstmt.setInt(i++, item);
			}
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorDTO adv = new AdvisorDTO();
				adv.setId(results.getInt("ADVISOR_ID"));
				adv.setName(results.getString("NAME"));
				adv.setImage(results.getString("IMAGE"));
				adv.setIndustry(results.getString("INDUSTRY"));
				list.add(adv);
			}
			logger.info("Exit GetAdvisorDetails method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetAdvisorDetails method of QuestionsDAO");
		return list;
	}
	
	public Boolean IncrementQuestionHit(String qid){
		logger.info("Entered IncrementQuestionHit method of QuestionsDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE questions SET HITS=HITS+1 WHERE Q_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(qid));
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("IncrementQuestionHit method of QuestionsDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}	
			logger.error("IncrementQuestionHit method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IncrementQuestionHit method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("IncrementQuestionHit method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("IncrementQuestionHit method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}		
		logger.info("Entered IncrementQuestionHit method of QuestionsDAO");
		return isCommit;
	}
	
	public List<QuestionsDTO> GetMostViewedQuestion() {
		logger.info("Entered GetMostViewedQuestion method of QuestionsDAO");
		List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT QUESTION,Q_ID FROM questions WHERE ISANSWERED=? ORDER BY HITS DESC LIMIT 5";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				QuestionsDTO question = new QuestionsDTO();
				question.setQuestion(results.getString("QUESTION"));
				question.setQuestionId(results.getInt("Q_ID"));
				list.add(question);
			}
			logger.info("Exit GetMostViewedQuestion method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetMostViewedQuestion method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetMostViewedQuestion method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetMostViewedQuestion method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetMostViewedQuestion method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetMostViewedQuestion method of QuestionsDAO");
		return list;
	}
	
	
	public List<String> GetPopularCategories() {
		logger.info("Entered GetPopularCategories method of QuestionsDAO");
		List<String> list = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT DISTINCT CATEGORY FROM questions WHERE ISANSWERED=?  ORDER BY HITS DESC LIMIT 4";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getString("CATEGORY"));
			}
			logger.info("Exit GetPopularCategories method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetPopularCategories method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPopularCategories method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPopularCategories method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPopularCategories method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetPopularCategories method of QuestionsDAO");
		return list;
	}
	
	public List<QuestionsDTO> GetQuestionsAccordingToSubcategory(String category, String subcategory) {
		logger.info("Entered GetQuestionsAccordingToSubcategory method of QuestionsDAO");
		List<QuestionsDTO> questions = new ArrayList<QuestionsDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM questions WHERE ISANSWERED=?  AND CATEGORY=? AND SUBCATEGORY=?";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, true);
			if(category.equals("higherstudies")){
				pstmt.setString(2,"studies");
			}else if (category.equals("industry")) {
				pstmt.setString(2,"industry");
			}else{
				pstmt.setString(2,"options");
			}
			pstmt.setString(3, subcategory.toLowerCase());
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				QuestionsDTO question = new QuestionsDTO();
				question.setQuestionId(results.getInt("Q_ID"));
				question.setQuestion(results.getString("QUESTION"));
				question.setCategory(results.getString("CATEGORY"));
				question.setSubcategory(results.getString("SUBCATEGORY"));
				questions.add(question);
			}
			logger.info("Exit GetQuestionsAccordingToSubcategory method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetQuestionsAccordingToSubcategory method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetQuestionsAccordingToSubcategory method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetQuestionsAccordingToSubcategory method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestionsAccordingToSubcategory method of QuestionsDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Exit GetQuestionsAccordingToSubcategory method of QuestionsDAO");
		return questions;
	}
	
	public int SubmitQuestionToAdvisor(String question,String category,String subcategory,int userId){
		logger.info("Entered SubmitQuestion method of QuestionsDAO");
		int id = 0;
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
			String query = "insert into questions "+"(QUESTION,CATEGORY,SUBCATEGORY,TIMESTAMP,U_ID,TOFORUM) values" + "(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, question);
			pstmt.setString(2, category);
			pstmt.setString(3, subcategory);
			pstmt.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			pstmt.setInt(5, userId);
			pstmt.setBoolean(6, false);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					id = generatedKeys.getInt(1);
				}
				conn.commit();
			}else{
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
		return id;	
	}
	
	public Boolean SetAdvisorIdForQuestion(int qid,String aid){
		logger.info("Entered SetAdvisorIdForQuestion method of QuestionsDAO");
        Boolean isInserted = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into questiontoadvisor "+"(Q_ID,A_ID) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qid);
			pstmt.setString(2, aid);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isInserted = true;
			}else{
				conn.rollback();
			}
		}catch (SQLException e) {
				logger.error("SetAdvisorIdForQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SetAdvisorIdForQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SetAdvisorIdForQuestion method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		logger.info("Exit SetAdvisorIdForQuestion method of QuestionsDAO");
		return isInserted;	
	}
	
	public List<QuestionsDTO> GetUserQuestions(int uid){
		logger.info("Entered GetUserQuestions method of QuestionsDAO");
		List<QuestionsDTO> list = new ArrayList<QuestionsDTO>();

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			//String q4in = generateQsForIn(words.size());
			query = "SELECT Q_ID,QUESTION,TIMESTAMP,TOFORUM,ISANSWERED  FROM questions WHERE U_ID=?";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			QuestionsDTO question = new QuestionsDTO();
			question.setQuestionId(results.getInt("Q_ID"));
			question.setQuestion(results.getString("QUESTION"));
			question.setPostedOn(results.getTimestamp("TIMESTAMP"));
			question.setToForum(results.getBoolean("TOFORUM"));
			question.setIsAnswered(results.getBoolean("ISANSWERED"));
			list.add(question);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetUserQuestions method of QuestionsDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetUserQuestions method of QuestionsDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserQuestions method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserQuestions method of QuestionsDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserQuestions method of QuestionsDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetUserQuestions method of QuestionsDAO");
		return list;

	}
	
	public List<AnswerDTO> GetAnswersFromQuestionIds(List<Integer> ids) {
		logger.info("Entered GetAnswers method of QuestionsDAO");
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(ids.size());
			String query = "SELECT * FROM answers WHERE QID IN ( "
					+ q4in + " ) ";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			int i = 1;
			for (int item : ids) {
				pstmt.setInt(i++, item);
			}
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AnswerDTO que = new AnswerDTO();
				que.setAdvisor_id(results.getInt("ADVISOR_ID"));
				que.setQuestionId(results.getInt("QID"));
				que.setAnswer(results.getString("ANSWER"));
				que.setTime(results.getTimestamp("TIMESTAMP"));
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
	
	public List<AdvisorDTO> GetAdvisorName(List<AnswerDTO> advisorAnswers) {
		logger.info("Entered GetAdvisorDetails method of QuestionsDAO");
		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(advisorAnswers.size());
			String query = "SELECT NAME,IMAGE,ADVISOR_ID FROM advisordetails WHERE ADVISOR_ID IN ( "+ q4in + " )";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(query);
			int i = 1;
			for (AnswerDTO item : advisorAnswers) {
				pstmt.setInt(i++, item.getAdvisor_id());
			}
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				AdvisorDTO advisor = new AdvisorDTO();
				advisor.setId(results.getInt("ADVISOR_ID"));
				advisor.setName(results.getString("NAME"));
				advisor.setImage(results.getString("IMAGE"));
				list.add(advisor);
			}
			logger.info("Exit GetAdvisorDetails method of QuestionsDAO");
		} catch (SQLException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of QuestionsDAO threw error:"
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
