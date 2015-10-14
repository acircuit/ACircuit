package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.dto.ContactUsDTO;
import ac.dto.PromotionsDTO;
import ac.dto.QuestionsDTO;
import ac.dto.RefundDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;
import ac.jdbc.ConnectionFactory;

public class AdminDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(AdminDAO.class);
	
	public Boolean  CheckLoginDetails(String username , String securedPassword) { 
		
		
		logger.info("Entered CheckLoginDetails method of AdminDAO");
		ResultSet results = null;
		Boolean isAutheticated = false;
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM admin_table WHERE EMAIL = ? AND PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,username);
			pstmt.setString(2,securedPassword);
		    results = pstmt.executeQuery();
		    if(results.first()){
		    	isAutheticated = true;
		    }
			conn.commit();
			
		logger.info("Exit CheckLoginDetails method of AdminDAO");
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("CheckLoginDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		return isAutheticated;
}
    public List<UserDetailsDTO> GetUserDetails(){
    	logger.info("Entered GetUserDetails method of AdminDAO");
   		List<UserDetailsDTO> list = new ArrayList<UserDetailsDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT USER_ID,EMAIL,PHONE_NUMBER,FULL_NAME,ISACTIVE,OCCUPATION FROM userdetails ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				UserDetailsDTO user = new UserDetailsDTO();
				user.setUserId(results.getInt("USER_ID"));
				user.setEmail(results.getString("EMAIL"));
				user.setFullName(results.getString("FULL_NAME"));
				user.setPhone(results.getString("PHONE_NUMBER"));
				user.setOccupation(results.getString("OCCUPATION"));
				user.setIsActive(results.getBoolean("ISACTIVE"));
				list.add(user);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetUserDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetUserDetails method of AdminDAO");
		return list;
	}
    
	public Boolean  UpdateUserIsActive(Boolean value,String uid) { 
		logger.info("Entered UpdateUserIsActive method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userdetails SET ISACTIVE=? WHERE USER_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setString(2, uid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserIsActive method of AdminDAO");
		return isCommit;
	}
	
	public UserDetailsDTO GetUserDetails(String email) {

		logger.info("Entered GetUserDetails method of AdminDAO");
		ResultSet results = null;
		UserDetailsDTO user = new UserDetailsDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM userdetails WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			results = pstmt.executeQuery();
			if (results.first()) {
				user.setUserId(results.getInt("USER_ID"));
				user.setEmail(results.getString("EMAIL"));
				user.setFullName(results.getString("FULL_NAME"));
				user.setPhone(results.getString("PHONE_NUMBER"));
				user.setImage(results.getString("IMAGE"));
				user.setDateOfRegistration(results.getTimestamp("DATE_OF_REGISTRATION"));
				user.setIsActive(results.getBoolean("ISACTIVE"));
			}
			logger.info("Exit GetUserDetails method of AdminDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetUserDetails method of AdminDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetUserDetails method of AdminDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetUserDetails method of AdminDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public List<AdvisorDTO> GetAdvisorDetails(){
   		logger.info("Entered GetAdvisorDetails method of AdminDAO");
   		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT ADVISOR_ID,NAME,PHONE_NUMBER,EMAIL,ISACTIVE FROM advisordetails ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			AdvisorDTO adv = new AdvisorDTO();
			adv.setId(results.getInt("ADVISOR_ID"));
			adv.setName(results.getString("NAME"));
			adv.setEmail(results.getString("EMAIL"));
			adv.setPhoneNo(results.getString("PHONE_NUMBER"));
			adv.setIsActive(results.getBoolean("ISACTIVE"));
			list.add(adv);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorDetails method of AdminDAO");
		return list;
	}
	
	public Boolean  UpdateAdvisorIsActive(Boolean value,String aid) { 
		logger.info("Entered UpdateAdvisorIsActive method of AdminDAO");
		Boolean isCommit = false ;
         try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE advisordetails SET ISACTIVE=? WHERE ADVISOR_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setString(2, aid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAdvisorIsActive method of AdminDAO");
		return isCommit;
	}
	

	public List<ContactUsDTO> GetContactUsDetails() {
		logger.info("Entered GetUserDetails method of AdminUserDAO");
		ResultSet results = null;
		List<ContactUsDTO> contactList = new ArrayList<ContactUsDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM contactus";
			PreparedStatement pstmt = conn.prepareStatement(query);
			results = pstmt.executeQuery();
			while (results.next()) {
				ContactUsDTO contact = new ContactUsDTO();
				contact.setId(results.getInt("ID"));
				contact.setName(results.getString("NAME"));
				contact.setEmail(results.getString("EMAIL"));
				contact.setPhone(results.getString("PHONE_NUMBER"));
				contact.setMessage(results.getString("MESSAGE"));
				contactList.add(contact);
			}
			logger.info("Exit GetUserDetails method of AdminUserDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetUserDetails method of AdminUserDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetUserDetails method of AdminUserDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetUserDetails method of AdminUserDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminUserDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return contactList;
	}
	
	public List<QuestionsDTO> GetQuestions() {

		logger.info("Entered GetQuestions method of AdminDAO");
		ResultSet results = null;
		List<QuestionsDTO> questions = new ArrayList<QuestionsDTO>();
		 SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM questions";
			PreparedStatement pstmt = conn.prepareStatement(query);
			results = pstmt.executeQuery();
			while (results.next()) {
				QuestionsDTO question = new QuestionsDTO();
				question.setQuestionId(results.getInt("Q_ID"));
				question.setQuestion(results.getString("QUESTION"));
				question.setCategory(results.getString("CATEGORY"));
				question.setSubcategory(results.getString("SUBCATEGORY"));
				question.setPostedOnDate(sdf.format(results.getTimestamp("TIMESTAMP") ));
				question.setStatus(results.getString("STATUS"));
				questions.add(question);
			}
			logger.info("Exit GetQuestions method of AdminDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetQuestions method of AdminDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetQuestions method of AdminDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetQuestions method of AdminDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestions method of AdminDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return questions;
	}
	
	public Boolean  UpdateQuestionStatus(String qid,String status) { 
		logger.info("Entered UpdateQuestionStatus method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE questions SET STATUS=? WHERE Q_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setString(2, qid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateQuestionStatus method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateQuestionStatus method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateQuestionStatus method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateQuestionStatus method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateQuestionStatus method of AdminDAO");
		return isCommit;
	}
	
	public List<SessionDTO> GetSessionDetails(){
		logger.info("Entered GetSessionDetails method of AdminDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO dto = new SessionDTO();
				dto.setSessionid(results.getInt("SESSION_ID"));
				dto.setMode(results.getString("MODE"));
				dto.setDuration(results.getString("DURATION"));
				dto.setStatus(results.getString("STATUS"));
				sessions.add(dto);
			}
		} catch (SQLException e) {
			logger.error("GetSessionDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSessionDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSessionDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSessionDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetSessionDetails method of AdminDAO");
		return sessions;
	}
	public List<ReviewsDTO> GetReviews(){
		logger.info("Entered GetReviews method of AdminDAO");
		 SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
         List<ReviewsDTO> reviews=  new ArrayList<ReviewsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT RATING,REVIEW,POSTED_ON,STATUS,SESSION_ID FROM sessionreviews";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ReviewsDTO review = new ReviewsDTO();
				review.setRating(results.getString("RATING"));
				review.setReview(results.getString("REVIEW"));
				review.setDate(sdf.format(results.getDate("POSTED_ON")));
				review.setStatus(results.getString("STATUS"));
				review.setSessionId(results.getInt("SESSION_ID"));
				reviews.add(review);
            }
		
		} catch (SQLException e) {
			logger.error("GetReviews method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetReviews method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetReviews method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetReviews method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviews;
	}
	
    
	public Boolean  UpdateReviewsStatus(String sid,String status) { 
		logger.info("Entered UpdateReviewsStatus method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE sessionreviews SET STATUS=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setString(2, sid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateReviewsStatus method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateReviewsStatus method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateReviewsStatus method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateReviewsStatus method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateReviewsStatus method of AdminDAO");
		return isCommit;
	}
	
	public List<SessionDTO> GetPaymentHistory(){
		logger.info("Entered GetPaymentHistory method of AdminDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE STATUS=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "SESSION COMPLETE");
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO dto = new SessionDTO();
				dto.setSessionid(results.getInt("SESSION_ID"));
				dto.setMode(results.getString("MODE"));
				dto.setDuration(results.getString("DURATION"));
				dto.setStatus(results.getString("STATUS"));
				dto.setAcceptedDate(results.getDate("ACCEPTED_DATE"));
				dto.setSessionDuration(results.getString("SESSION_DURATION"));
				dto.setSessionPrice(results.getString("SESSION_PRICE"));
				sessions.add(dto);
			}
		} catch (SQLException e) {
			logger.error("GetPaymentHistory method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPaymentHistory method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPaymentHistory method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPaymentHistory method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
 	return sessions;
}
	
    public List<PromotionsDTO> GetPromotions(){
    	logger.info("Entered GetPromotions method of AdminDAO");
   		List<PromotionsDTO> list = new ArrayList<PromotionsDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT * FROM promotions ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				PromotionsDTO promo = new PromotionsDTO();
				promo.setId(results.getInt("ID"));
				promo.setPromoName(results.getString("PROMOTION_NAME"));
				promo.setIsActive(results.getBoolean("ISACTIVE"));
				promo.setAmount(results.getString("AMOUNT"));
				list.add(promo);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetPromotions method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetPromotions method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPromotions method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPromotions method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPromotions method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetPromotions method of AdminDAO");
		return list;
	}
    
	public Boolean  UpdatePromotionIsActive(Boolean value, String id) { 
		logger.info("Entered UpdatePromotionIsActive method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE promotions SET ISACTIVE=? WHERE ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setString(2, id);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdatePromotionIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdatePromotionIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdatePromotionIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdatePromotionIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdatePromotionIsActive method of AdminDAO");
		return isCommit;
	}
	
	public Boolean  UpdateAmount(String pid, String amount) { 
		logger.info("Entered UpdateAmount method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE promotions SET AMOUNT=? WHERE ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, amount);
			pstmt.setString(2, pid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateAmount method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAmount method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAmount method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAmount method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAmount method of AdminDAO");
		return isCommit;
	}
	
    public List<Integer> GetAdvisorIds(String qid){
    	logger.info("Entered GetAdvisorIds method of AdminDAO");
   		List<Integer> list = new ArrayList<Integer>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT A_ID FROM questiontoadvisor WHERE Q_ID=? ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,qid );
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				list.add(results.getInt("A_ID"));
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorIds method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorIds method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorIds method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorIds method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorIds method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorIds method of AdminDAO");
		return list;
	}
    
    public List<RefundDTO> GetUserRefunds(){
    	logger.info("Entered GetUserRefunds method of AdminDAO");
   		List<RefundDTO> list = new ArrayList<RefundDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT userrefund.ID,userrefund.RESPONSE,userrefund.TRACKING_ID,userrefund.AMOUNT,userrefund.STATUS,userrefund.ISAPPROVED,userdetails.USER_ID,userdetails.FULL_NAME FROM userrefund INNER JOIN userdetails ON userrefund.USER_ID = userdetails.USER_ID; ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				RefundDTO refund = new RefundDTO();
				refund.setId(results.getInt("ID"));
				refund.setAmount(Double.valueOf(results.getString("AMOUNT")));
				refund.setTrackingid(results.getString("TRACKING_ID"));
				refund.setUserId(results.getInt("USER_ID"));
				refund.setUsername(results.getString("FULL_NAME"));
				refund.setStatus(results.getInt("STATUS"));
				refund.setIsApproved(results.getBoolean("ISAPPROVED"));
				refund.setResponse(results.getString("RESPONSE"));
				list.add(refund);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetUserRefunds method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetUserRefunds method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserRefunds method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserRefunds method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserRefunds method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetUserRefunds method of AdminDAO");
		return list;
	}
    
	public Boolean  UpdateRefundDetails(String status, String response, String refundId) { 
		logger.info("Entered UpdateUserIsActive method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userrefund SET RESPONSE=?,STATUS=?,ISAPPROVED=? WHERE ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, response);
			pstmt.setString(2, status);
			pstmt.setBoolean(3, true);
			pstmt.setString(4, refundId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isCommit = true;
			}
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserIsActive method of AdminDAO");
		return isCommit;
	}
}
