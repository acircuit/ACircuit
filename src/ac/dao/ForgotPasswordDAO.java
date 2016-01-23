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
                query ="SELECT ADVISOR_ID,EMAIL FROM advisordetails WHERE EMAIL = ? AND ISACTIVE=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,userName);
				pstmt.setBoolean(2, true);
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
	public Timestamp getUserTimestamp(String userId) {
        logger.info("Entered getUserTimestamp method of ForgotPasswordDAO");
		String query = "SELECT * FROM forgotpassword_user WHERE USER_ID = ? AND ISACTIVE=?";
		PreparedStatement pstmt;
		ResultSet results = null;
		Timestamp time = null;
		Boolean exist = false;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setBoolean(2, true);
			results = pstmt.executeQuery();
			exist = results.next();
			if (exist) {
				conn.commit();
				time = results.getTimestamp("TIME");
			}
			logger.info("Entered getUserTimestamp method of ForgotPasswordDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("getUserTimestamp method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("getUserTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("getUserTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("getUserTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("getUserTimestamp method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit getUserTimestamp method of ForgotPasswordDAO");
		return time;

	}
	
	public Boolean  UpdateUserForgotPassword(int id,Boolean value) { 
		logger.info("Entered UpdateUserForgotPassword method of ForgotPasswordDAO");
		Boolean isCommit = false ;
        
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE forgotpassword_user SET ISACTIVE=? WHERE USER_ID=? AND ISACTIVE=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setInt(2, id);
			pstmt.setBoolean(3,true );
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
					logger.error("UpdateUserForgotPassword method of ForgotPasswordDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserForgotPassword method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserForgotPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserForgotPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserForgotPassword method of ForgotPasswordDAO");
		return isCommit;
	}
	
	public Boolean  UpdateUserForgotPasswordTimestamp(int id) { 
		logger.info("Entered UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO");
		Boolean isCommit = false ;
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
			String query ="UPDATE forgotpassword_user SET TIME=? WHERE USER_ID=? AND ISACTIVE=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
			pstmt.setInt(2, id);
			pstmt.setBoolean(3,true );
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
					logger.error("UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserForgotPasswordTimestamp method of ForgotPasswordDAO");
		return isCommit;
	}
	
	
	public Timestamp getAdvisorTimestamp(String advisorId) {
        logger.info("Entered getAdvisorTimestamp method of ForgotPasswordDAO");
		String query = "SELECT * FROM forgotpassword_advisor WHERE ADVISOR_ID = ? AND ISACTIVE=?";
		PreparedStatement pstmt;
		ResultSet results = null;
		Timestamp time = null;
		Boolean exist = false;
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, advisorId);
			pstmt.setBoolean(2, true);
			results = pstmt.executeQuery();
			exist = results.next();
			if (exist) {
				conn.commit();
				time = results.getTimestamp("TIME");
			}
			logger.info("Entered getAdvisorTimestamp method of ForgotPasswordDAO");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("getAdvisorTimestamp method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("getAdvisorTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("getAdvisorTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("getAdvisorTimestamp method of ForgotPasswordDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("getAdvisorTimestamp method of ForgotPasswordDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit getAdvisorTimestamp method of ForgotPasswordDAO");
		return time;

	}
	
	
	public Boolean  UpdateAdvisorForgotPassword(int id,Boolean value) { 
		logger.info("Entered UpdateAdvisorForgotPassword method of ForgotPasswordDAO");
		Boolean isCommit = false ;
        
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE forgotpassword_advisor SET ISACTIVE=? WHERE ADVISOR_ID=? AND ISACTIVE=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setInt(2, id);
			pstmt.setBoolean(3,true );
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
					logger.error("UpdateAdvisorForgotPassword method of ForgotPasswordDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAdvisorForgotPassword method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAdvisorForgotPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAdvisorForgotPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAdvisorForgotPassword method of ForgotPasswordDAO");
		return isCommit;
	}
	
	
	public Boolean  UpdateAdvisorForgotPasswordTimestamp(int id) { 
		logger.info("Entered UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO");
		Boolean isCommit = false ;
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
			String query ="UPDATE forgotpassword_advisor SET TIME=? WHERE ADVISOR_ID=? AND ISACTIVE=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
			pstmt.setInt(2, id);
			pstmt.setBoolean(3,true );
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
					logger.error("UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAdvisorForgotPasswordTimestamp method of ForgotPasswordDAO");
		return isCommit;
	}
	
	public Boolean updateAdvisorPassword(String newPassword, String advisorId){
		logger.info("Entered updateAdvisorPassword method of ForgotPasswordDAO");
		Boolean isInsertComplete = false;
		try{
			if(!newPassword.isEmpty() && !("").equals(newPassword)){
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query = "UPDATE advisordetails SET PASSWORD = ? WHERE ADVISOR_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
			    pstmt.setString(1, newPassword);
			    pstmt.setString(2, advisorId);
			    int result = pstmt.executeUpdate(); 
				if(result >0) {
					conn.commit();
					isInsertComplete = true;
				}
			}
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("updateAdvisorPassword method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("updateAdvisorPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
				logger.error("updateAdvisorPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("updateAdvisorPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		logger.info("Exit updateAdvisorPassword method of ForgotPasswordDAO");
		return isInsertComplete;	
	}
	
	public Boolean updateUserPassword(String newPassword, String advisorId){
		logger.info("Entered updateUserPassword method of ForgotPasswordDAO");
		Boolean isInsertComplete = false;
		try{
			if(!newPassword.isEmpty() && !("").equals(newPassword)){
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query = "UPDATE userdetails SET PASSWORD = ? WHERE USER_ID = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
			    pstmt.setString(1, newPassword);
			    pstmt.setString(2, advisorId);
			    int result = pstmt.executeUpdate(); 
				if(result >0) {
					conn.commit();
					isInsertComplete = true;
				}
			}
		}catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("updateUserPassword method of ForgotPasswordDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("updateUserPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
				logger.error("updateUserPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("updateUserPassword method of ForgotPasswordDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		logger.info("Exit updateUserPassword method of ForgotPasswordDAO");
		return isInsertComplete;	
	}
}
