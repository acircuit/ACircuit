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
	
	public Boolean InsertUserWallet(int userId) {
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
		    pstmt.setDouble(2, 0);
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
	
}
