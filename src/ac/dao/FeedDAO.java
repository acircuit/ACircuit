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
import ac.dto.SessionDTO;
import ac.jdbc.ConnectionFactory;

public class FeedDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(FeedDAO.class);
	
	public int InsertFeedType(String type){
		logger.info("Entered InsertFeedType method of FeedDAO");
		int feedId = 0;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into feeds"+"(FEED_TYPE) values" + "(?)";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, type);
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
