package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.dto.UserDetailsDTO;
import ac.jdbc.ConnectionFactory;

public class ForgotPasswordDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(ForgotPasswordDAO.class);
	
	
	public UserDetailsDTO GetUserDetails(String email) {
        logger.info("Entered GetUserDetails method of ForgotPasswordDAO");
		String query = "SELECT USER_ID,EMAIL FROM userdetails WHERE EMAIL = ?";
		PreparedStatement pstmt;
		ResultSet results = null;
		UserDetailsDTO user = new UserDetailsDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			results = pstmt.executeQuery();
			if (results.first()) {
				user.setUserId(results.getInt("USER_ID"));
				user.setEmail(results.getString("EMAIL"));
				conn.commit();
			}
			logger.info("Entered GetUserDetails method of ForgotPasswordDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("GetUserDetails method of ForgotPasswordDAO threw error:"
						+ e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetUserDetails method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetails method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetails method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

		return user;

	}
	
	public Boolean setForgotPasswordDetails(int userId, String email) {

		logger.info("Entered setForgotPasswordDetails method of ForgotPasswordDAO");
		Boolean isInsertComplete = false;
		try {
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
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "INSERT INTO forgotpassword_user(USER_ID,TIME,EMAIL)"
					+ "VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(3, email);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				conn.commit();
				isInsertComplete = true;
			}
			logger.info("Exit setForgotPasswordDetails method of ForgotPasswordDAO");
		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				logger.error("setForgotPasswordDetails method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("setForgotPasswordDetails method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setForgotPasswordDetails method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return isInsertComplete;
	}
	
	public AdvisorDTO GetAdvisorDetails(String userName){
		
		logger.info("Entered GetAdvisorDetails method of ForgotPasswordDAO");
		
		PreparedStatement pstmt;
		ResultSet results = null;
		String query="";
		AdvisorDTO profile = new AdvisorDTO();
		Boolean flag = true;
			try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
                query ="SELECT ADVISOR_ID,EMAIL FROM advisordetails WHERE EMAIL = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,userName);
			    results = pstmt.executeQuery();
			    if(results.first()){
			    	profile.setId(results.getInt("ADVISOR_ID"));
			    	profile.setEmail(results.getString("EMAIL"));
			    }
			    logger.info("Entered GetAdvisorDetails method of ForgotPasswordDAO");
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("GetAdvisorDetails method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("GetAdvisorDetails method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("GetAdvisorDetails method of ForgotPasswordDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
			
		return profile;
		
	}
	
	public Boolean  setForgotPasswordDetailsAdvisor(int  advisorId,String email) { 
		
		
		logger.info("Entered setForgotPasswordDetailsAdvisor method of ForgotPasswordDAO");
		Boolean isInsertComplete = false;
		try {
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
	         conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "INSERT INTO forgotpassword_advisor(ADVISOR_ID,TIME,EMAIL)" + "VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,advisorId );
			pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(3, email);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
				isInsertComplete = true;
			}
		logger.info("Exit setForgotPasswordDetailsAdvisor method of ForgotPasswordDAO");
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("setForgotPasswordDetailsAdvisor method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("setForgotPasswordDetailsAdvisor method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("setForgotPasswordDetailsAdvisor method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		return isInsertComplete;
}
}
