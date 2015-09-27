package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ac.dto.ActivityDTO;
import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.QuestionsDTO;
import ac.dto.SessionDTO;
import ac.jdbc.ConnectionFactory;

public class FeedDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(FeedDAO.class);
	
	public int InsertFeedType(String type){
		logger.info("Entered InsertFeedType method of FeedDAO");
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
		int feedId = 0;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into feeds"+"(FEED_TYPE,FEED_TIME) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, type);
			pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			int result = pstmt.executeUpdate();
			if(result > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					feedId = generatedKeys.getInt(1);
				}
				conn.commit();
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertFeedType method of FeedDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertFeedType method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertFeedType method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertFeedType method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertFeedType method of FeedDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertFeedType method of FeedDAO");
			return feedId;

		}
	
	public Boolean InsertQuestionFeed(int feedId,int id,String question,String category,String subcategory){
		logger.info("Entered InsertQuestionFeed method of FeedDAO");
		Boolean isCommit = false;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into questionsfeed"+"(FEED_ID,QUESTION_ID,QUESTION,CATEGORY,SUBCATEGORY,POSTED_ON) values" + "(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, feedId);
			pstmt.setInt(2, id);
            pstmt.setString(3, question); 
            pstmt.setString(4, category); 
            pstmt.setString(5, subcategory); 
            pstmt.setDate(6, new java.sql.Date(new Date().getTime()));

			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertQuestionFeed method of FeedDAO");
			return isCommit;

		}
	
	public Boolean InsertReviewFeed(int feedId,int id,String advName,String userName,String image,String review,String rating){
		logger.info("Entered InsertQuestionFeed method of FeedDAO");
		Boolean isCommit = false;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into reviewfeed"+"(FEED_ID,REVIEW_ID,USERNAME,USER_IMAGE,ADVISORNAME,REVIEW,RATING,POSTED_ON) values" + "(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, feedId);
			pstmt.setInt(2, id);
            pstmt.setString(3, userName); 
            pstmt.setString(4, image); 
            pstmt.setString(5, advName);
            pstmt.setString(6, review); 
            pstmt.setString(7, rating); 
            pstmt.setDate(8, new java.sql.Date(new Date().getTime()));

			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertQuestionFeed method of FeedDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertQuestionFeed method of FeedDAO");
			return isCommit;

		}
	
	public List<ActivityDTO> Getfeeds(){
		logger.info("Entered Getfeeds method of FeedDAO");
		List<ActivityDTO> activities = new ArrayList<ActivityDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM feeds";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ActivityDTO activity = new ActivityDTO();
				activity.setFeedId(results.getInt("FEED_ID"));
				activity.setFeedType(results.getString("FEED_TYPE"));
				activity.setFeedtime(results.getTimestamp("FEED_TIME"));
				activities.add(activity);
			}
		} catch (SQLException e) {
			logger.error("Getfeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Getfeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("Getfeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("Getfeeds method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered Getfeeds method of FeedDAO");
		return activities;
	}
	
	public List<ActivityDTO> GetQuestionsFeeds(){
		logger.info("Entered GetQuestionsFeeds method of FeedDAO");
		List<ActivityDTO> questionActivities = new ArrayList<ActivityDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			String query = "SELECT * FROM questionsfeed";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ActivityDTO questionActivity = new ActivityDTO();
				questionActivity.setFeedId(results.getInt("FEED_ID"));
				questionActivity.setQuestionId(results.getInt("QUESTION_ID"));
				questionActivity.setQuestion(results.getString("QUESTION"));
				questionActivity.setSubcategory(results.getString("SUBCATEGORY"));
				questionActivity.setCategory(results.getString("CATEGORY"));
				questionActivity.setQuestionPostedOn(results.getDate("POSTED_ON"));
				questionActivities.add(questionActivity);
			}
		
		} catch (SQLException e) {
			logger.error("GetQuestionsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetQuestionsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetQuestionsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestionsFeeds method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return questionActivities;
	}
	
	
	public List<ActivityDTO> GetReviewsFeeds(){
		logger.info("Entered GetReviewsFeeds method of FeedDAO");
		List<ActivityDTO> reviewActivities = new ArrayList<ActivityDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			String query = "SELECT * FROM reviewfeed";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ActivityDTO reviewActivity = new ActivityDTO();
				reviewActivity.setFeedId(results.getInt("FEED_ID"));
				reviewActivity.setReviewId(results.getInt("REVIEW_ID"));
				reviewActivity.setUserName(results.getString("USERNAME"));
				reviewActivity.setImage(results.getString("USER_IMAGE"));
				reviewActivity.setAdvisorName(results.getString("ADVISORNAME"));
				reviewActivity.setRating(results.getString("RATING"));
				reviewActivity.setReview(results.getString("REVIEW"));
				reviewActivity.setReviewPostedOn(results.getDate("POSTED_ON"));
				reviewActivities.add(reviewActivity);
			}
		
		} catch (SQLException e) {
			logger.error("GetReviewsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetReviewsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetReviewsFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetReviewsFeeds method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviewActivities;
	}
	
	
	public QuestionsDTO GetQuestionDetails(String qid){
		logger.info("Entered GetQuestionDetails method of FeedDAO");
		QuestionsDTO question = new QuestionsDTO();
		 SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM questions WHERE  Q_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				question.setQuestionId(results.getInt("Q_ID"));
				question.setQuestion(results.getString("QUESTION"));
				question.setPostedOnDate(sdf.format(results.getTimestamp("TIMESTAMP")));
				question.setCategory(results.getString("CATEGORY"));
				question.setSubcategory(results.getString("SUBCATEGORY"));
				
			}
		} catch (SQLException e) {
			logger.error("GetQuestionDetails method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetQuestionDetails method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetQuestionDetails method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestionDetails method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetQuestionDetails method of FeedDAO");
		return question;
	}
	
	public Boolean InsertAnswerFeed(int feedId,QuestionsDTO question , AdvisorDTO advisor, String answer){
		logger.info("Entered InsertAnswerFeed method of FeedDAO");
		Boolean isCommit = false;
		SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into answerfeed"+"(FEED_ID,Q_ID,QUESTION,CATEGORY,SUBCATEGORY,POSTED_ON,ADVISOR_NAME,ADVISOR_IMAGE,ANSWER,ANSWER_POSTED_ON) values" + "(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, feedId);
			pstmt.setInt(2, question.getQuestionId());
            pstmt.setString(3, question.getQuestion()); 
            pstmt.setString(4, question.getCategory()); 
            pstmt.setString(5, question.getSubcategory());
            pstmt.setString(6, question.getPostedOnDate()); 
            pstmt.setString(7, advisor.getName()); 
            pstmt.setString(8, advisor.getImage());
            pstmt.setString(9, answer);
            pstmt.setString(10, sdf.format(new Date()));

			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertAnswerFeed method of FeedDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertAnswerFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertAnswerFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertAnswerFeed method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertAnswerFeed method of FeedDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertAnswerFeed method of FeedDAO");
			return isCommit;

		}
	
	public List<ActivityDTO> GetAnswerFeeds(){
		logger.info("Entered GetAnswerFeeds method of FeedDAO");
		List<ActivityDTO> answerActivities = new ArrayList<ActivityDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			String query = "SELECT * FROM answerfeed";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ActivityDTO answerActivity = new ActivityDTO();
				answerActivity.setFeedId(results.getInt("FEED_ID"));
				answerActivity.setQuestionId(results.getInt("Q_ID"));
				answerActivity.setQuestion(results.getString("QUESTION"));
				answerActivity.setSubcategory(results.getString("SUBCATEGORY"));
				answerActivity.setCategory(results.getString("CATEGORY"));
				answerActivity.setPostedon(results.getString("POSTED_ON"));
				answerActivity.setAdvisorName(results.getString("ADVISOR_NAME"));
				answerActivity.setImage(results.getString("ADVISOR_IMAGE"));
				answerActivity.setAnswer(results.getString("ANSWER"));
				answerActivity.setAnswerpostedon(results.getString("ANSWER_POSTED_ON"));
				answerActivities.add(answerActivity);
			}
		
		} catch (SQLException e) {
			logger.error("GetAnswerFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAnswerFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAnswerFeeds method of FeedDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAnswerFeeds method of FeedDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return answerActivities;
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
