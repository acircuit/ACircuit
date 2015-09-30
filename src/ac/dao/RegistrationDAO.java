package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ac.dto.PromotionsDTO;
import ac.jdbc.ConnectionFactory;

public class RegistrationDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(RegistrationDAO.class);
	
	
	// This method will put the user details retrieved from the form in the
	// userdetails table
	public Integer setUserDetails(String email, String hashPassword,
			String fullname,String absolutePath, String newsletter) {
		logger.info("Entered setUserDetails method of RegistrationDAO");
		int result = 0;
		int userId = 0;
		Boolean isNewsLetterSubscribed = false;
		if(newsletter != null && newsletter.equals("true")){
			isNewsLetterSubscribed = true;
		}else{
			isNewsLetterSubscribed = false;
		}
		Boolean isDetailsCommit = false;
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
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into userdetails"
					+ "(EMAIL,PASSWORD,FULL_NAME,IMAGE,DATE_OF_REGISTRATION,NEWSLETTER) values"
					+ "(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			pstmt.setString(2, hashPassword);
			pstmt.setString(3, fullname);
			pstmt.setString(4, absolutePath);
			Timestamp time = new java.sql.Timestamp(date.getTime());
			pstmt.setTimestamp(5, time);
			pstmt.setBoolean(6, isNewsLetterSubscribed);
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					userId = generatedKeys.getInt(1);
				}
			}
			logger.info("Exit setUserDetails method of RegistrationDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("setUserDetails method of RegistrationDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("setUserDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("setUserDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("setUserDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setUserDetails method of RegistrationDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return userId;
	}
	public Integer setAdvisorDetails(String email, String hashPassword,
			String fullname, String newsletter) {
		logger.info("Entered setAdvisorDetails method of RegistrationDAO");
		int result = 0;
		int advisorId = 0;
		Boolean isNewsLetterSubscribed = false;
		if(newsletter != null && newsletter.equals("true")){
			isNewsLetterSubscribed = true;
		}else{
			isNewsLetterSubscribed = false;
		}
		Boolean isDetailsCommit = false;
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
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into advisordetails"
					+ "(EMAIL,PASSWORD,NAME,DATE_OF_REGISTRATION,NEWSLETTER) values"
					+ "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			pstmt.setString(2, hashPassword);
			pstmt.setString(3, fullname);
			Timestamp time = new java.sql.Timestamp(date.getTime());
			pstmt.setTimestamp(4, time);
			pstmt.setBoolean(5, isNewsLetterSubscribed);
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					advisorId = generatedKeys.getInt(1);
				}
			}
			logger.info("Exit setAdvisorDetails method of RegistrationDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("setAdvisorDetails method of RegistrationDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("setAdvisorDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("setAdvisorDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("setAdvisorDetails method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setAdvisorDetails method of RegistrationDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return advisorId;
	}
	
	public Boolean InsertUserWallet(int userId,String amount) {
		logger.info("Entered InsertUserWallet method of RegistrationDAO");
		int result = 0;
		Boolean isCommit = false;

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into userwallet"
					+ "(USER_ID,AMOUNT) values"
					+ "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
		    pstmt.setDouble(2, Double.valueOf(amount));
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
				isCommit = true;
			}else{
				isCommit = false;

			}
			logger.info("Exit InsertUserWallet method of RegistrationDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("InsertUserWallet method of RegistrationDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("InsertUserWallet method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("InsertUserWallet method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("InsertUserWallet method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("InsertUserWallet method of RegistrationDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return isCommit;
	}
	
	public Boolean  UpdateUserProfile(String name,String gender,String occupation,String phone,int userId) { 
		logger.info("Entered UpdateUserProfile method of RegistrationDAO");
		Boolean isCommit = false ;
		String query;
        try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			if(phone != null){
				query ="UPDATE userdetails SET FULL_NAME=?,GENDER=?,OCCUPATION=?,PHONE_NUMBER=? WHERE USER_ID = ? ";
			}else{
				query ="UPDATE userdetails SET FULL_NAME=?,GENDER=?,OCCUPATION=? WHERE USER_ID = ? ";
            }
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3,occupation);
			if(phone != null){
				pstmt.setString(4, phone);
				pstmt.setInt(5, userId);
			}else{
				pstmt.setInt(4, userId);
			}
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
					logger.error("UpdateUserProfile method of RegistrationDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserProfile method of RegistrationDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserProfile method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserProfile method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserProfile method of RegistrationDAO");
		return isCommit;
	}
	
	public Boolean SetGeneralInfo(String name,String gender,String age,String city,String phone,String industry, String intro,String exp,String linkedin_Profile_Link,int advisorId){
	logger.info("Entered SetGeneralInfo method of RegistrationDAO");
	Boolean isGeneralInfoCommit = false;
	String query = "";
	PreparedStatement pstmt;
	try {
		conn =ConnectionFactory.getConnection();
		conn.setAutoCommit(false);
		query = "UPDATE advisordetails  SET NAME=?,GENDER = ?,AGE = ?,PHONE_NUMBER = ?,CITY = ?,INDUSTRY = ?,EXPERIENCE = ?,LINKEDIN_PROFILE_LINK = ?,INTRODUCTION = ?, WHERE ADVISOR_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,name );
		pstmt.setString(2, gender);
		pstmt.setString(3, age);
		pstmt.setString(4, phone);
		pstmt.setString(5, city);
		pstmt.setString(6, industry);
		pstmt.setString(7, exp);
		pstmt.setString(8, linkedin_Profile_Link);
		pstmt.setString(9, intro);
		pstmt.setInt(10, advisorId);
		int result = pstmt.executeUpdate(); 
		if(result >0) {
			conn.commit();
			isGeneralInfoCommit = true;
			}
	} catch (SQLException e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			logger.error("SetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
			e1.printStackTrace();
		}	
		logger.error("SetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	} catch (IOException e) {
		logger.error("SetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	} catch (PropertyVetoException e) {
		logger.error("SetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			logger.error("SetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
	}	
	logger.info("Entered SetGeneralInfo method of RegistrationDAO");
	return isGeneralInfoCommit;
	}
	
	public PromotionsDTO GetPromotionValidity(String promo){
		logger.info("Entered GetPromotionValidity method of RegistrationDAO");
		PromotionsDTO promotion = new PromotionsDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ISACTIVE,AMOUNT FROM promotions WHERE PROMOTION_NAME=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, promo);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				promotion.setIsActive(results.getBoolean("ISACTIVE"));
				promotion.setAmount(results.getString("AMOUNT"));
            }
		} catch (SQLException e) {
			logger.error("GetPromotionValidity method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPromotionValidity method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPromotionValidity method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPromotionValidity method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetPromotionValidity method of RegistrationDAO");
		return promotion;
	}
	
	public Boolean  UpdateWallet(String uid,String amount) { 
		logger.info("Entered UpdateWallet method of RegistrationDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userwallet SET AMOUNT= AMOUNT+?,IS_PROMO_APPLIED=? WHERE USER_ID = ? AND IS_PROMO_APPLIED=? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, Double.valueOf(amount));
			pstmt.setBoolean(2, true);
			pstmt.setString(3, uid);
			pstmt.setBoolean(4, false);
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
					logger.error("UpdateWallet method of RegistrationDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateWallet method of RegistrationDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateWallet method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateWallet method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateWallet method of RegistrationDAO");
		return isCommit;
	}
	
}
