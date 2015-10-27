package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
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
import ac.dto.CategoryDTO;
import ac.dto.EducationDTO;
import ac.dto.ProfessionalBackgroundDTO;
import ac.dto.PromotionsDTO;
import ac.dto.SessionDTO;
import ac.dto.SkillsDTO;
import ac.dto.SubCategoryDTO;
import ac.dto.UserDetailsDTO;
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
			String fullname, String newsletter,String image) {
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
					+ "(EMAIL,PASSWORD,NAME,DATE_OF_REGISTRATION,NEWSLETTER,IMAGE,REGISTRATION_STATUS) values"
					+ "(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			pstmt.setString(2, hashPassword);
			pstmt.setString(3, fullname);
			Timestamp time = new java.sql.Timestamp(date.getTime());
			pstmt.setTimestamp(4, time);
			pstmt.setBoolean(5, isNewsLetterSubscribed);
			pstmt.setString(6, image);
			pstmt.setString(7, "GeneralInfo");
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
	
	public Boolean SetGeneralInfo(String name,String gender,String age,String city,String phone,String industry, String intro,String exp,String linkedin_Profile_Link,int advisorId,String url,String edit){
	logger.info("Entered SetGeneralInfo method of RegistrationDAO");
	Boolean isGeneralInfoCommit = false;
	String query = "";
	PreparedStatement pstmt;
	try {
		conn =ConnectionFactory.getConnection();
		conn.setAutoCommit(false);
		if(edit != null && !edit.equals("")){
			if(!url.equals("")){
				query = "UPDATE advisordetails  SET NAME=?,GENDER = ?,AGE = ?,PHONE_NUMBER = ?,CITY = ?,INDUSTRY = ?,EXPERIENCE = ?,LINKEDIN_PROFILE_LINK = ?,INTRODUCTION = ?,IMAGE=? WHERE ADVISOR_ID = ?";

			}else{
				query = "UPDATE advisordetails  SET NAME=?,GENDER = ?,AGE = ?,PHONE_NUMBER = ?,CITY = ?,INDUSTRY = ?,EXPERIENCE = ?,LINKEDIN_PROFILE_LINK = ?,INTRODUCTION = ? WHERE ADVISOR_ID = ?";

			}

		}else{
			if(!url.equals("")){
				query = "UPDATE advisordetails  SET NAME=?,GENDER = ?,AGE = ?,PHONE_NUMBER = ?,CITY = ?,INDUSTRY = ?,EXPERIENCE = ?,LINKEDIN_PROFILE_LINK = ?,INTRODUCTION = ?,REGISTRATION_STATUS=?,IMAGE=? WHERE ADVISOR_ID = ?";

			}else{
				query = "UPDATE advisordetails  SET NAME=?,GENDER = ?,AGE = ?,PHONE_NUMBER = ?,CITY = ?,INDUSTRY = ?,EXPERIENCE = ?,LINKEDIN_PROFILE_LINK = ?,INTRODUCTION = ?,REGISTRATION_STATUS=? WHERE ADVISOR_ID = ?";

			}

		}
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
		if(edit != null && !edit.equals("")){
			if(!url.equals("")){
				pstmt.setString(10, url);
				pstmt.setInt(11, advisorId);

			}else{
				pstmt.setInt(10, advisorId);
			}
		}else{
			pstmt.setString(10, "EducationInfo");
			if(!url.equals("")){
				pstmt.setString(11, url);
				pstmt.setInt(12, advisorId);

			}else{
				pstmt.setInt(11, advisorId);

			}
		}
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
	
	public Boolean  UpdateUserImage(int userId,String path) { 
		logger.info("Entered UpdateUserImage method of RegistrationDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userdetails SET IMAGE= ? WHERE USER_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, path);
			pstmt.setInt(2, userId);
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
					logger.error("UpdateUserImage method of RegistrationDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserImage method of RegistrationDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserImage method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserImage method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserImage method of RegistrationDAO");
		return isCommit;
	}
	
	public UserDetailsDTO  CheckEmailExistsUser(String email) { 
		logger.info("Entered CheckEmailExistsUser method of UserLoginDAO");
		ResultSet results = null;
		UserDetailsDTO user = new UserDetailsDTO();
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT USER_ID,IMAGE,ISVERIFIED FROM userdetails WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
		    results = pstmt.executeQuery();
		    if(results.first()){
		    	user.setUserId(results.getInt("USER_ID"));
		    	user.setImage(results.getString("IMAGE"));
		    	user.setIsVerified(results.getBoolean("ISVERIFIED"));
		    }
		logger.info("Exit CheckEmailExistsUser method of UserLoginDAO");
		}catch(Exception e){
			logger.error("CheckEmailExistsUser method of UserLoginDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckEmailExistsUser method of UserLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		return user;
       }
	
	public AdvisorDTO  CheckEmailExistsAdvisor(String email) { 
		logger.info("Entered CheckEmailExistsAdvisor method of AdvisorLoginDAO");
		ResultSet results = null;
		AdvisorDTO adv = new AdvisorDTO();
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID,IMAGE,ISVERIFIED,ISACTIVE FROM advisordetails WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
		    results = pstmt.executeQuery();
		    if(results.first()){
		    	adv.setId(results.getInt("ADVISOR_ID"));
		    	adv.setImage(results.getString("IMAGE"));
		    	adv.setIsVerified(results.getBoolean("ISVERIFIED"));
		    	adv.setIsActive(results.getBoolean("ISACTIVE"));
		    }
		logger.info("Exit CheckEmailExistsAdvisor method of AdvisorLoginDAO");
		}catch(Exception e){
			logger.error("CheckEmailExistsAdvisor method of AdvisorLoginDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckEmailExistsAdvisor method of AdvisorLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		return adv;
        }
	
	public Integer setUserDetailsViaOthers(String email, 
			String fullname,String absolutePath) {
		logger.info("Entered setUserDetails method of RegistrationDAO");
		int result = 0;
		int userId = 0;
		Boolean isNewsLetterSubscribed = false;
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
					+ "(EMAIL,FULL_NAME,IMAGE,DATE_OF_REGISTRATION,ISVERIFIED) values"
					+ "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			pstmt.setString(2, fullname);
			pstmt.setString(3, absolutePath);
			Timestamp time = new java.sql.Timestamp(date.getTime());
			pstmt.setTimestamp(4, time);
			pstmt.setBoolean(5, true);
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
	
	
	public Integer setAdvisorDetailsViaOthers(String email,String name) {
		logger.info("Entered setAdvisorDetailsViaOthers method of RegistrationDAO");
		int result = 0;
		int advisorId = 0;
		Boolean isNewsLetterSubscribed = false;
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
					+ "(EMAIL,NAME,DATE_OF_REGISTRATION) values"
					+ "(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			Timestamp time = new java.sql.Timestamp(date.getTime());
			pstmt.setTimestamp(3, time);
			result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					advisorId = generatedKeys.getInt(1);
				}
			}
			logger.info("Exit setAdvisorDetailsViaOthers method of RegistrationDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("setAdvisorDetailsViaOthers method of RegistrationDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("setAdvisorDetailsViaOthers method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("setAdvisorDetailsViaOthers method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("setAdvisorDetailsViaOthers method of RegistrationDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setAdvisorDetailsViaOthers method of RegistrationDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return advisorId;
	}
	

	
	public Boolean RemoveLanguages(int aId){
		
		logger.info("Entered RemoveLanguages method of RegistrationDAO");
		Boolean isDeleted =false;
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="DELETE FROM advisorlanguage WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}else{
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("RemoveLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("RemoveLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("RemoveLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("RemoveLanguages method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetProfessionalBackground method of RegistrationDAO");
		return isDeleted;
	}

	public Boolean InsertAdvisorLanguages(int aId, String[] language){
		logger.info("Entered InsertAdvisorLanguages method of RegistrationDAO");
		Boolean isAchievementCommit = false;
		try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				for (String lang : language) {
					
						if(!lang.equals("")){

							String query = "insert into advisorlanguage"+"(ADVISOR_ID,LANGUAGE_KNOWN) values" + "(?, ?)";
							PreparedStatement pstmt = conn.prepareStatement(query);
							pstmt.setInt(1,aId);
							pstmt.setString(2,lang);
							int result = pstmt.executeUpdate();
							if(result > 0) {
								conn.commit();
								isAchievementCommit = true;
							}else{
								isAchievementCommit = false;
								conn.rollback();
								break;
							}
						}
					} 
		}catch (SQLException e) {
						logger.error("InsertAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("InsertAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("InsertAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("InsertAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
			logger.info("Entered InsertAdvisorLanguages method of RegistrationDAO");
			return isAchievementCommit;

		}	
	
	public AdvisorDTO GetGeneralInfo(int aId){
		
		logger.info("Entered GetGeneralInfo method of RegistrationDAO");
		AdvisorDTO profile = new AdvisorDTO();
		if( aId != 0){
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID,NAME,GENDER,AGE,PHONE_NUMBER,CITY,INDUSTRY,INTRODUCTION,IMAGE,EMAIL,LINKEDIN_PROFILE_LINK,EXPERIENCE,IMAGE,REGISTRATION_STATUS,VIDEO,PHONE FROM advisordetails WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
			profile.setName(results.getString("NAME"));
			profile.setGender(results.getString("GENDER"));
			profile.setAge(results.getInt("AGE"));
			profile.setPhoneNo(results.getString("PHONE_NUMBER"));
			profile.setCity(results.getString("CITY"));
			profile.setIndustry(results.getString("INDUSTRY"));
			profile.setIntro(results.getString("INTRODUCTION"));
			profile.setLinkedIn(results.getString("LINKEDIN_PROFILE_LINK"));
			profile.setEmail(results.getString("EMAIL"));
			profile.setExperience(results.getString("EXPERIENCE"));	
			profile.setId(results.getInt("ADVISOR_ID"));
			profile.setImage(results.getString("IMAGE"));
			profile.setStatus(results.getString("REGISTRATION_STATUS"));
			profile.setVideo(results.getBoolean("VIDEO"));
			profile.setPhone(results.getBoolean("PHONE"));
			}
		} catch (SQLException e) {
			logger.error("GetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetGeneralInfo method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetGeneralInfo method of RegistrationDAO");
		return profile;
	}
	
	public List<String> GetAdvisorLanguages(int aId){
		
		logger.info("Entered GetAdvisorLanguages method of RegistrationDAO");
		List<String> lang = new ArrayList<String>(); 
		if( aId != 0){
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT LANGUAGE_KNOWN FROM advisorlanguage WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				lang.add(results.getString("LANGUAGE_KNOWN"));
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorLanguages method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetAdvisorLanguages method of RegistrationDAO");
		return lang;
	}
	
	public Boolean DeleteEducation(int aId){
		
		logger.info("Entered DeleteEducation method of RegistrationDAO");
		Boolean isDeleted =false;
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="DELETE FROM advisoreducation WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}else{
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("DeleteEducation method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("DeleteEducation method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("DeleteEducation method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("DeleteEducation method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered DeleteEducation method of RegistrationDAO");
		return isDeleted;
	}
	
	public Boolean setEducationInfo(List<EducationDTO> education , int advisorId){
		logger.info("Entered setEducationInfo method of RegistrationDAO");
		Boolean isEducationCommit = false;
			if(!education.isEmpty() && (advisorId != 0)) {
				for (EducationDTO edu : education) {
					try {
						conn =ConnectionFactory.getConnection();
						conn.setAutoCommit(false);
						String query = "insert into advisoreducation"+"(ADVISOR_ID,COURSE,INSTITUTION,DURATION,TYPE) values" + "(?, ?,?,?, ?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setInt(1,advisorId);
						pstmt.setString(2,edu.getCourse());
						pstmt.setString(3,edu.getInstitution());
						pstmt.setString(4,edu.getDuration());
						pstmt.setString(5, edu.getType());
						int result = pstmt.executeUpdate();
						if(result > 0) {
							conn.commit();
							isEducationCommit = true;
							continue;
						}else{
							isEducationCommit = false;
							conn.rollback();
							break;
						}
					} catch (SQLException e) {
						logger.error("setEducationInfo method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("setEducationInfo method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("setEducationInfo method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("setEducationInfo method of RegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
				}

			}
			logger.info("Entered addProfessionalBackground method of RegistrationDAO");
			return isEducationCommit;

		}
	
	public Boolean setRegistrationStatus(int advisorId,String  status){
		logger.info("Entered setRegistrationStatus method of RegistrationDAO");
		Boolean isRegistrationStatusCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "UPDATE advisordetails SET REGISTRATION_STATUS = ? WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,status );
			pstmt.setInt(2, advisorId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isRegistrationStatusCommit = true;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("setRegistrationStatus method of RegistrationDAO threw error:"+e.getMessage());
				e1.printStackTrace();
			}	
			logger.error("setRegistrationStatus method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("setRegistrationStatus method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("setRegistrationStatus method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setRegistrationStatus method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}		
		logger.info("Exit setRegistrationStatus method of RegistrationDAO");
		return isRegistrationStatusCommit;
	}
	
	public List<EducationDTO> GetEducationInfo(int aId){
		
		logger.info("Entered GetEducationInfo method of AdvisorRegistrationDAO");
		List<EducationDTO> educations = new ArrayList<EducationDTO>();
		if( aId != 0){
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID,COURSE,INSTITUTION,DURATION,TYPE FROM advisoreducation WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				EducationDTO education = new EducationDTO();
				education.setAdvisorId(results.getInt("ADVISOR_ID"));
				education.setCourse(results.getString("COURSE"));
				education.setInstitution(results.getString("INSTITUTION"));
				education.setDuration(results.getString("DURATION"));
				education.setType(results.getString("TYPE"));
				educations.add(education);
			}
		} catch (SQLException e) {
			logger.error("GetEducationInfo method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetEducationInfo method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetEducationInfo method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetEducationInfo method of AdvisorRegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetEducationInfo method of AdvisorRegistrationDAO");
		return educations;
	}
	
	public Boolean DeleteProfCompany(int aId){
		
		logger.info("Entered DeleteProfCompany method of AdvisorRegistrationDAO");
		Boolean isDeleted =false;
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="DELETE FROM advisorprofessionalbackground WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("DeleteProfCompany method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("DeleteProfCompany method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("DeleteProfCompany method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("DeleteProfCompany method of AdvisorRegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered DeleteProfCompany method of AdvisorRegistrationDAO");
		return isDeleted;
	}
	
	public Boolean addProfessionalBackground(List<ProfessionalBackgroundDTO> professionalBackgrounds, int advisorId){
		
		
		logger.info("Entered addProfessionalBackground method of AdvisorRegistrationDAO");
		Boolean isProfessionalBackgorundCommit = false;
		List<Integer> profId =new ArrayList<Integer>();
			if(!professionalBackgrounds.isEmpty() && (advisorId != 0)) {
				for (ProfessionalBackgroundDTO profession : professionalBackgrounds) {
					try {
						conn =ConnectionFactory.getConnection();
						conn.setAutoCommit(false);
						String query = "insert into advisorprofessionalbackground"+"(ADVISOR_ID,COMPANY,DESIGNATION,DURATION,IS_CURRENT) values" + "(?, ?,?,?, ?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setInt(1,advisorId);
						pstmt.setString(2,profession.getCompany());
						pstmt.setString(3,profession.getDesignation());
						pstmt.setString(4,profession.getDuration());
						pstmt.setBoolean(5, profession.getIsCurrent());
						int result = pstmt.executeUpdate();
						if(result > 0) {
							conn.commit();

							isProfessionalBackgorundCommit = true;
							continue;
						}else{
							isProfessionalBackgorundCommit = false;
							conn.rollback();
							break;
						}
					} catch (SQLException e) {
						logger.error("addProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("addProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("addProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("addProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
				}

			}
			logger.info("Entered addProfessionalBackground method of AdvisorRegistrationDAO");
			return isProfessionalBackgorundCommit;

		}
	
	public List<ProfessionalBackgroundDTO> GetProfessionalBackground(int aId){
		
		logger.info("Entered GetProfessionalBackground method of AdvisorRegistrationDAO");
		List<ProfessionalBackgroundDTO> list = new ArrayList<ProfessionalBackgroundDTO>();
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT PROF_ID,COMPANY,DESIGNATION,DURATION,IS_CURRENT FROM advisorprofessionalbackground WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ProfessionalBackgroundDTO prof = new ProfessionalBackgroundDTO();
				prof.setCompany(results.getString("COMPANY"));
				prof.setDesignation(results.getString("DESIGNATION"));
				prof.setDuration(results.getString("DURATION"));
				prof.setIsCurrent(results.getBoolean("IS_CURRENT"));
				list.add(prof);
			}
		} catch (SQLException e) {
			logger.error("GetProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetProfessionalBackground method of AdvisorRegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetProfessionalBackground method of AdvisorRegistrationDAO");
		return list;
	}
	
	public Boolean  UpdateModes(int advisorId, String phone,String video) { 
		logger.info("Entered UpdateModes method of RegistrationDAO");
		Boolean isCommit = false ;
		String query;
        try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			query ="UPDATE advisordetails SET PHONE=?,VIDEO=? WHERE ADVISOR_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			if(phone != null && phone.equals("phone")){
				pstmt.setBoolean(1, true);
			}else{
				pstmt.setBoolean(1, false);
			}
			if(video != null && video.equals("video")){
				pstmt.setBoolean(2, true);
			}else{
				pstmt.setBoolean(2, false);
			}
			pstmt.setInt(3, advisorId);
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
					logger.error("UpdateModes method of RegistrationDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateModes method of RegistrationDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateModes method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateModes method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateModes method of RegistrationDAO");
		return isCommit;
	}
	
	public Boolean DeleteCategory(int aId){
		
		logger.info("Entered DeleteCategory method of RegistrationDAO");
		Boolean isDeleted =false;
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="DELETE FROM advisor_category WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}else{
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("DeleteCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("DeleteCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("DeleteCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("DeleteCategory method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered DeleteCategory method of RegistrationDAO");
		return isDeleted;
	}
	
	public List<Integer> GetSubCategoryId(int aId){
		
		logger.info("Entered GetSubCategoryId method of RegistrationDAO");
		List<Integer> list = new ArrayList<Integer>();
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT SUB_CATEGORY_ID FROM advisor_subcategory WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				
				list.add(results.getInt("SUB_CATEGORY_ID"));
			}
		} catch (SQLException e) {
			logger.error("GetSubCategoryId method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSubCategoryId method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSubCategoryId method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSubCategoryId method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetSubCategoryId method of RegistrationDAO");
		return list;
	}
	
	
	public Boolean DeleteSubCategory(int aId){
		
		logger.info("Entered DeleteSubCategory method of RegistrationDAO");
		Boolean isDeleted =false;
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="DELETE FROM advisor_subcategory WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}else{
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("DeleteSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("DeleteSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("DeleteSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("DeleteSubCategory method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered DeleteSubCategory method of RegistrationDAO");
		return isDeleted;
	}
	
	public Boolean DeleteSkills(List<Integer> list){
		
		logger.info("Entered DeleteSkills method of RegistrationDAO");
		Boolean isDeleted =false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(list.size());
			String query ="DELETE FROM advisorskills WHERE ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (Integer i1 : list) {
				pstmt.setInt(i++, i1);
			}
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isDeleted = true;
			}else{
				isDeleted = true;
			}

		} catch (SQLException e) {
			logger.error("DeleteSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("DeleteSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("DeleteSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("DeleteSkills method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		logger.info("Entered DeleteSkills method of RegistrationDAO");
		return isDeleted;
	}
	
	
	public List<CategoryDTO> InsertAdvisorCategory( String[] cat,int aId){
		logger.info("Entered InsertAdvisorCategory method of RegistrationDAO");
		List<CategoryDTO> list =new ArrayList<CategoryDTO>();
		try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				for (String category : cat) {
					
						if(!category.equals("")){

							String query = "insert into advisor_category"+"(ADVISOR_ID,CATEGORY) values" + "(?, ?)";
							PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
							pstmt.setInt(1,aId);
							if(category.equals("higherstudies")){
								pstmt.setString(2,"studies");
							}else{
								pstmt.setString(2,category);
							}
							
							int result = pstmt.executeUpdate();
							if(result > 0) {
								conn.commit();
								CategoryDTO cats= new CategoryDTO();
								cats.setAdvisorId(aId);
								ResultSet generatedKeys = pstmt.getGeneratedKeys();
								if (null != generatedKeys && generatedKeys.next()) {
									cats.setCatId(generatedKeys.getInt(1));
								}
								cats.setCategory(category);
								list.add(cats);
								
							}else{
								conn.rollback();
								break;
							}
						}
					} 
		}catch (SQLException e) {
						logger.error("InsertAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("InsertAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("InsertAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("InsertAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
			logger.info("Entered InsertAdvisorCategory method of RegistrationDAO");
			return list;

		}	
	
	
	public List<CategoryDTO> InsertAdvisorSubCategory( List<CategoryDTO> cat,int aId){
		logger.info("Entered InsertAdvisorSubCategory method of RegistrationDAO");
		Boolean isAchievementCommit = false;
		try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				for (CategoryDTO category : cat) {
					
						if(!category.getSubcategory().equals("")){

							String query = "insert into advisor_subcategory"+"(ADVISOR_ID,SUBCATEGORY,CATEGORY_ID) values" + "(?, ?,?)";
							PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
							pstmt.setInt(1,aId);
							pstmt.setString(2,category.getSubcategory());
							pstmt.setInt(3, category.getCatId());
							int result = pstmt.executeUpdate();
							if(result > 0) {
								conn.commit();
								ResultSet generatedKeys = pstmt.getGeneratedKeys();
								if (null != generatedKeys && generatedKeys.next()) {
									category.setSubcatId(generatedKeys.getInt(1));
								}
							}else{
								conn.rollback();
								break;
							}
						}
					} 
		}catch (SQLException e) {
						logger.error("InsertAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("InsertAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("InsertAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("InsertAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
			logger.info("Entered InsertAdvisorSubCategory method of RegistrationDAO");
			return cat;

		}	
	
	public Boolean SetAdvisorSkills( List<CategoryDTO> cat){
		logger.info("Entered SetAdvisorSkills method of RegistrationDAO");
		Boolean isCommit = false;
		try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				for (CategoryDTO category : cat) {
					for(String skill : category.getSkills()){
						if(!skill.equals("")){
						String query = "insert into advisorskills"+"(SUBCATEGORY_ID,SKILL) values" + "(?, ?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, category.getSubcatId());
						pstmt.setString(2,skill);
						int result = pstmt.executeUpdate();
						if(result > 0) {
							conn.commit();
							isCommit = true;
						}else{
							conn.rollback();
							isCommit = false;
							break;
						}
						}
					}
					} 
		}catch (SQLException e) {
						logger.error("SetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("SetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("SetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("SetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
			logger.info("Entered SetAdvisorSkills method of RegistrationDAO");
			return isCommit;

		}
	
	public String GetAdvisorIndustry(int aId){
		
		logger.info("Entered GetAdvisorIndustry method of RegistrationDAO");
		String industry = "";
		if( aId != 0){
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT INDUSTRY FROM advisordetails WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				industry = results.getString("INDUSTRY");
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorIndustry method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorIndustry method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorIndustry method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorIndustry method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetAdvisorIndustry method of RegistrationDAO");
		return industry;
	}
	
	public List<CategoryDTO> GetAdvisorCategory(int aId){
		
		logger.info("Entered GetAdvisorCategory method of RegistrationDAO");
		List<CategoryDTO> cat = new ArrayList<CategoryDTO>(); 
		if( aId != 0){
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM advisor_category WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				CategoryDTO category =  new CategoryDTO();
				category.setAdvisorId(results.getInt("ADVISOR_ID"));
				category.setCatId(results.getInt("CATEGORY_ID"));
				category.setCategory(results.getString("CATEGORY"));
				cat.add(category);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorCategory method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetAdvisorCategory method of RegistrationDAO");
		return cat;
	}
	
	public List<SubCategoryDTO> GetAdvisorSubCategory(int aId){
		
		logger.info("Entered GetAdvisorSubCategory method of RegistrationDAO");
		List<SubCategoryDTO> subcat = new ArrayList<SubCategoryDTO>(); 
		if( aId != 0){
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM advisor_subcategory WHERE ADVISOR_ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,aId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SubCategoryDTO subcategory =  new SubCategoryDTO();
				subcategory.setAdvisorId(results.getInt("ADVISOR_ID"));
				subcategory.setCategoryId(results.getInt("CATEGORY_ID"));
				subcategory.setId(results.getInt("SUB_CATEGORY_ID"));
				subcategory.setSubCategory(results.getString("SUBCATEGORY"));
				subcat.add(subcategory);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorSubCategory method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		}
		
		logger.info("Entered GetAdvisorSubCategory method of RegistrationDAO");
		return subcat;
	}
	
	public List<SkillsDTO> GetAdvisorSkills(List<SubCategoryDTO> sub){
		
		logger.info("Entered GetAdvisorSkills method of RegistrationDAO");
		List<SkillsDTO> subcat = new ArrayList<SkillsDTO>(); 
		
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(sub.size());
			String query ="SELECT * FROM advisorskills WHERE SUBCATEGORY_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (SubCategoryDTO subs : sub) {
				pstmt.setInt(i++, subs.getId());
			}
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SkillsDTO skill =  new SkillsDTO();
				skill.setSkill(results.getString("SKILL"));
				skill.setSubId(results.getInt("SUBCATEGORY_ID"));
				subcat.add(skill);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorSkills method of RegistrationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		
		logger.info("Entered GetAdvisorSubCategory method of RegistrationDAO");
		return subcat;
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
