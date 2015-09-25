package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
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

import ac.dto.AdvisorDTO;
import ac.dto.AnswerDTO;
import ac.dto.CostDTO;
import ac.dto.QuestionsDTO;
import ac.dto.ReviewsDTO;
import ac.dto.SessionDTO;
import ac.dto.TwilioVideoDTO;
import ac.dto.UserDetailsDTO;
import ac.jdbc.ConnectionFactory;

public class SessionDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(SessionDAO.class);
	
	
	
	public SessionDTO GetSessionDetails(String sid){
		
		logger.info("Entered GetSessionDetails method of SessionDAO");
		SessionDTO dto = new SessionDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.valueOf(sid));
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				dto.setSessionid(results.getInt("SESSION_ID"));
				dto.setAdvisorid(results.getInt("ADVISOR_ID"));
				dto.setUserid(results.getInt("USER_ID"));
				dto.setMode(results.getString("MODE"));
				dto.setDuration(results.getString("DURATION"));
				dto.setQuery(results.getString("QUERY"));
				dto.setDate1(results.getDate("DATE1"));
				dto.setDate2(results.getDate("DATE2"));
				dto.setDate3(results.getDate("DATE3"));
				dto.setTime1(results.getString("TIME1"));
				dto.setTime2(results.getString("TIME2"));
				dto.setTime3(results.getString("TIME3"));
				dto.setPrice(results.getDouble("PRICE"));
				dto.setStatus(results.getString("STATUS"));
				dto.setAcceptedDate(results.getDate("ACCEPTED_DATE"));
				dto.setAcceptedTime(results.getString("ACCEPTED_TIME"));
				dto.setSessionPlan(results.getString("SESSIONPLAN"));
				dto.setSessionDuration(results.getString("SESSION_DURATION"));
				dto.setSessionPrice(results.getString("SESSION_PRICE"));

			}
		} catch (SQLException e) {
			logger.error("GetSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSessionDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetSessionDetails method of SessionDAO");
		return dto;
	}
	
	public UserDetailsDTO GetUserDetails(int uid){
		
		logger.info("Entered GetUserDetails method of SessionDAO");
		UserDetailsDTO dto = new UserDetailsDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT FULL_NAME,IMAGE,EMAIL,USER_ID,PHONE_NUMBER FROM userdetails WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				dto.setFullName(results.getString("FULL_NAME"));
				dto.setImage(results.getString("IMAGE"));
                dto.setEmail(results.getString("EMAIL"));
                dto.setUserId(results.getInt("USER_ID"));
                dto.setPhone(results.getString("PHONE_NUMBER"));
			}
		} catch (SQLException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetUserDetails method of SessionDAO");
		return dto;
	}
	
	public Boolean  UpdateSessionPlan(String sId, String sessionPlan, Boolean isNewDates,String date, String time ) { 
		logger.info("Entered UpdateSessionPlan method of SessionDAO");
		Boolean isCommit = false ;
		Date date1=null;
		if(!isNewDates){
	       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	       try {
		    	date1 = sdf.parse(date);
		   } catch (ParseException e3) {
			    // TODO Auto-generated catch block
			    e3.printStackTrace();
		  }
		}

	    
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="";
			if(isNewDates){
			    query ="UPDATE sessiondetails SET SESSIONPLAN = ?,STATUS=? WHERE SESSION_ID = ? ";
			}else{
			    query ="UPDATE sessiondetails SET SESSIONPLAN = ?,STATUS=?,ACCEPTED_DATE=?,ACCEPTED_TIME=? WHERE SESSION_ID = ? ";
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sessionPlan);
			if(!isNewDates){
				pstmt.setString(2, "ACCEPTED");
				pstmt.setDate(3, new java.sql.Date(date1.getTime()));
				pstmt.setString(4, time);
				pstmt.setString(5, sId);
			}else{
				pstmt.setString(2, "ACCEPTED WITH NEW DATES");
				pstmt.setString(3, sId);
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
					logger.error("UpdateSessionPlan method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateSessionPlan method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateSessionPlan method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateSessionPlan method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateSessionPlan method of SessionDAO");
		return isCommit;
	}
	
	public Boolean InsertNewDates(String sid ,String slot1Date, String slot2Date, String time1, String time2){
		logger.info("Entered InsertNewDates method of SessionDAO");
		Boolean isCommit = false;
		Date date1=null;
		Date date2=null;
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		try {
			date1 =  (Date) formatter.parse(slot1Date);
			date2 =  (Date) formatter.parse(slot2Date);

		} catch (ParseException e) {
			logger.error("setBookASessionDetails method of BookASessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into advisornewdates"+"(SESSION_ID,DATE1,DATE2,TIME1,TIME2) values" + "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setDate(2,new java.sql.Date(date1.getTime()));
			pstmt.setDate(3,new java.sql.Date(date2.getTime()));
			pstmt.setString(4, time1);
			pstmt.setString(5, time2);

			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertNewDates method of SessionDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertNewDates method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertNewDates method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertNewDates method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertNewDates method of SessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertNewDates method of SessionDAO");
			return isCommit;

		}
	
	

	public String getCvPath(String sid){
		logger.info("Entered getCvPath method of SessionDAO");
		String resume = "";
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT CV FROM sessiondetails WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				resume = results.getString("CV");

			}
		} catch (SQLException e) {
			logger.error("getCvPath method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("getCvPath method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("getCvPath method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("getCvPath method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetSessionDetails method of SessionDAO");
		return resume;
	}
	
	public AdvisorDTO GetAdvisorDetails(int aid){
		logger.info("Entered GetAdvisorDetails method of SessionDAO");
		AdvisorDTO advisor = new AdvisorDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT NAME,IMAGE,ADVISOR_ID,EMAIL,PHONE_NUMBER FROM advisordetails WHERE ADVISOR_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, aid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				advisor.setName(results.getString("NAME"));
				advisor.setImage(results.getString("IMAGE"));
                advisor.setId(results.getInt("ADVISOR_ID"));
                advisor.setEmail(results.getString("EMAIL"));
                advisor.setPhoneNo(results.getString("PHONE_NUMBER"));
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorDetails method of SessionDAO");
		return advisor;
	}
	
	public int SetSesionReviews(String sid ,String rating, String review,int userId,String aId){
		logger.info("Entered SetSesionReviews method of SessionDAO");
		int reviewId = 0;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into sessionreviews"+"(SESSION_ID,REVIEW,RATING,USER_ID,ADVISOR_ID,POSTED_ON,STATUS) values" + "(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, sid);
			pstmt.setString(2, review);
			pstmt.setString(3, rating);
            pstmt.setInt(4, userId);
            pstmt.setString(5, aId);
            pstmt.setDate(6, new java.sql.Date(new Date().getTime()));
            pstmt.setString(7, "WAITING FOR APPROVAL");
			int result = pstmt.executeUpdate();
			if(result > 0) {
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (null != generatedKeys && generatedKeys.next()) {
					reviewId = generatedKeys.getInt(1);
				}
				conn.commit();
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("SetSesionReviews method of SessionDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("SetSesionReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SetSesionReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SetSesionReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("SetSesionReviews method of SessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered SetSesionReviews method of SessionDAO");
			return reviewId;

		}
	public List<SessionDTO> GetCurrentSessionDetails(int userId){
		logger.info("Entered GetCurrentSessionDetails method of SessionDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE USER_ID=? AND STATUS IN (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setString(2,"PENDING APPROVAL");
			pstmt.setString(3,"ACCEPTED");
			pstmt.setString(4,"ACCEPTED WITH NEW DATES");
			pstmt.setString(5,"SESSION ON SCHEDULE");
			pstmt.setString(6,"PENDING APPROVAL BY ADMIN");
            ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO session = new SessionDTO();
				session.setSessionid(results.getInt("SESSION_ID"));
				session.setAdvisorid(results.getInt("ADVISOR_ID"));
				session.setMode(results.getString("MODE"));
				session.setQuery(results.getString("QUERY"));
				session.setStatus(results.getString("STATUS"));
				sessions.add(session);

			}
		} catch (SQLException e) {
			logger.error("GetCurrentSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCurrentSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCurrentSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetCurrentSessionDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return sessions;
	}
	
	public List<SessionDTO> GetPastSessionDetails(int userId){
		logger.info("Entered GetPastSessionDetails method of SessionDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE USER_ID=? AND STATUS IN (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setString(2,"SESSION CANCELLED BY USER");
			pstmt.setString(3,"SESSION CANCELLED BY ADVISOR");
			pstmt.setString(4,"SESSION COMPLETE");
			pstmt.setString(5,"SESSION CANCELLED BY ADMIN");
            ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO session = new SessionDTO();
				session.setSessionid(results.getInt("SESSION_ID"));
				session.setAdvisorid(results.getInt("ADVISOR_ID"));
				session.setMode(results.getString("MODE"));
				session.setQuery(results.getString("QUERY"));
				session.setStatus(results.getString("STATUS"));
				sessions.add(session);

			}
		} catch (SQLException e) {
			logger.error("GetPastSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPastSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPastSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPastSessionDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return sessions;
	}
	
	
	
	
	
	
	public List<AdvisorDTO> GetAdvisorDetails(List<SessionDTO> sessions){
		logger.info("Entered GetAdvisorDetails method of SessionDAO");
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(sessions.size());
			System.out.println(q4in);
			String query = "SELECT NAME,IMAGE,ADVISOR_ID FROM advisordetails WHERE ADVISOR_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (SessionDTO session : sessions) {
				pstmt.setInt(i++, session.getAdvisorid());
			}
			System.out.println(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				AdvisorDTO advisor = new AdvisorDTO();
				advisor.setName(results.getString("NAME"));
				advisor.setImage(results.getString("IMAGE"));
				advisor.setId(results.getInt("ADVISOR_ID"));
				advisors.add(advisor);
			}
		
		} catch (SQLException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return advisors;
	}
	
	
	public SessionDTO GetAdvisorNewDates(String sid){
		logger.info("Entered GetAdvisorNewDates method of SessionDAO");
		SessionDTO dates = new SessionDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM advisornewdates WHERE SESSION_ID= ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				dates.setSessionid(results.getInt("SESSION_ID"));
				dates.setDate1(results.getDate("DATE1"));
				dates.setDate2(results.getDate("DATE2"));
                dates.setTime1(results.getString("TIME1"));
                dates.setTime2(results.getString("TIME2"));

			}
		
		} catch (SQLException e) {
			logger.error("GetAdvisorNewDates method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorNewDates method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorNewDates method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorNewDates method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return dates;
	}
	
	public Boolean InsertRejectionReason(String sid ,String reason){
		logger.info("Entered InsertRejectionReason method of SessionDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into sessionrejection"+"(SESSION_ID,REASON) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setString(2, reason);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("InsertRejectionReason method of SessionDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("InsertRejectionReason method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("InsertRejectionReason method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("InsertRejectionReason method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("InsertRejectionReason method of SessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered InsertRejectionReason method of SessionDAO");
			return isCommit;

		}
	
	
	
	public Boolean  UpdateStatus(String status,String sId) { 
		logger.info("Entered UpdateStatus method of SessionDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE sessiondetails SET STATUS=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setString(2, sId);
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
					logger.error("UpdateStatus method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateStatus method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateStatus method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateStatus method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateStatus method of SessionDAO");
		return isCommit;
	}
	
	public List<SessionDTO> GetCurrentSessionDetailsUsingAdvisorId(int advisorId){
		logger.info("Entered GetCurrentSessionDetailsUsingAdvisorId method of SessionDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE ADVISOR_ID=? AND STATUS IN (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, advisorId);
			pstmt.setString(2,"PENDING APPROVAL");
			pstmt.setString(3,"ACCEPTED");
			pstmt.setString(4,"ACCEPTED WITH NEW DATES");
			pstmt.setString(5,"SESSION ON SCHEDULE");
            ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO session = new SessionDTO();
				session.setSessionid(results.getInt("SESSION_ID"));
				session.setAdvisorid(results.getInt("ADVISOR_ID"));
				session.setUserid(results.getInt("USER_ID"));
				session.setMode(results.getString("MODE"));
				session.setQuery(results.getString("QUERY"));
				session.setStatus(results.getString("STATUS"));
				sessions.add(session);

			}
		} catch (SQLException e) {
			logger.error("GetCurrentSessionDetailsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetCurrentSessionDetailsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetCurrentSessionDetailsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetCurrentSessionDetailsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return sessions;
	}
	
	public List<UserDetailsDTO> GetUserDetails(List<SessionDTO> sessions){
		logger.info("Entered GetUserDetails method of SessionDAO");
		List<UserDetailsDTO> users = new ArrayList<UserDetailsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(sessions.size());
			System.out.println(q4in);
			String query = "SELECT FULL_NAME,IMAGE,USER_ID FROM userdetails WHERE USER_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (SessionDTO session : sessions) {
				pstmt.setInt(i++, session.getUserid());
			}
			System.out.println(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				UserDetailsDTO user = new UserDetailsDTO();
				user.setFullName(results.getString("FULL_NAME"));
				user.setImage(results.getString("IMAGE"));
				user.setUserId(results.getInt("USER_ID"));
				users.add(user);
			}
		
		} catch (SQLException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return users;
	}
	
	public double GetWalletDetails(int uid){
		logger.info("Entered GetWalletDetails method of SessionDAO");
		double amount=0;
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT AMOUNT FROM userwallet WHERE USER_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				amount = results.getDouble("AMOUNT");
			}
		
		} catch (SQLException e) {
			logger.error("GetWalletDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetWalletDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetWalletDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetWalletDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return amount;
	}
	
	public String GetUserPhoneNumber(int uid){
		logger.info("Entered GetUserPhoneNumber method of SessionDAO");
		String phone = "";
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT PHONE_NUMBER FROM userdetails WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				phone = results.getString("PHONE_NUMBER");
			}
		} catch (SQLException e) {
			logger.error("GetUserPhoneNumber method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserPhoneNumber method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserPhoneNumber method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserPhoneNumber method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetUserPhoneNumber method of SessionDAO");
		return phone;
	}
	
	public void UpdateCallSid(String userSid, String advisorSid,String sId){
		logger.info("Entered UpdateCallSid method of SessionDAO");
		Boolean isEducationCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into twilliocalls"+"(USER_CALL_SID,ADVISOR_CALL_SID,SESSION_ID) values" + "(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userSid);
			pstmt.setString(2,advisorSid);
			pstmt.setString(3, sId);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
		}catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		logger.info("Entered UpdateCallSid method of SessionDAO");
	}
    
	
	public String GetAdvisorCallSid(String sId){
		logger.info("Entered GetAdvisorCallSid method of SessionDAO");
		String advisorSid = "";
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_CALL_SID FROM twilliocalls WHERE USER_CALL_SID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				advisorSid = results.getString("ADVISOR_CALL_SID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.info("Entered GetAdvisorCallSid method of SessionDAO");
		return advisorSid;
	}
	
	public String GetUserCallSid(String sId){
		logger.info("Entered GetAdvisorCallSid method of SessionDAO");
		String userSid = "";
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT USER_CALL_SID FROM twilliocalls WHERE ADVISOR_CALL_SID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				userSid = results.getString("USER_CALL_SID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.info("Entered GetAdvisorCallSid method of SessionDAO");
		return userSid;
	}
	
	public void UpdateDuration(String duration, String type,String Sid,String Status){
		logger.info("Entered UpdateDuration method of SessionDAO");
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
			String query="";
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			if(type.equals("user")){
			query = "UPDATE twilliocalls SET USER_DURATION = ?,USER_CALL_STATUS=?,USER_STATUS_UPDATE_TIME WHERE USER_CALL_SID = ?";
			}else{
				query = "UPDATE twilliocalls SET ADVISOR_DURATION = ?,ADVISOR_CALL_STATUS=?,ADVISOR_STATUS_UPDATE_TIME WHERE ADVISOR_CALL_SID = ?";	
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, duration);
			pstmt.setString(2, Status);
			pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(4, Sid);
			int result = pstmt.executeUpdate(); 
			if(result >0) {
				conn.commit();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		logger.info("Exit UpdateDuration method of SessionDAO");
	}
	
	public List<CostDTO> GetDuration(String sId){
		logger.info("Exit UpdateDuration method of SessionDAO");
		List<CostDTO> list = new ArrayList<CostDTO>();
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_DURATION,USER_DURATION FROM twilliocalls WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				CostDTO cost = new CostDTO();
				cost.setAdvisorTime(results.getInt("ADVISOR_DURATION"));
				cost.setUserTime(results.getInt("USER_DURATION"));
				list.add(cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateDuration method of SessionDAO");
		return list;
	}
	
	public int GetAdvisorId(String sId){
		logger.info("Entered GetAdvisorId method of SessionDAO");
		int id=0;
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID FROM sessiondetails WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				id = results.getInt("ADVISOR_ID");
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorId method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorId method of SessionDAO");
		return id;
	}
	public Double GetAdvisorPrice(int advId, String mode){
		logger.info("Entered GetAdvisorPrice method of SessionDAO");
		String query = "";
		Double price = 0.0;
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			if(mode.equals("phone")){
				query ="SELECT PHONE_PRICE FROM advisordetails WHERE ADVISOR_ID=?";
			}else{
				query ="SELECT VIDEO_PRICE FROM advisordetails WHERE ADVISOR_ID=?";
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, advId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				if(mode.equals("phone")){
					price = results.getDouble("PHONE_PRICE");
				}else{
					price = results.getDouble("VIDEO_PRICE");
				}
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorPrice method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorPrice method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorPrice method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorPrice method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorPrice method of SessionDAO");
		return price;
	}
	
	public Boolean  UpdateWallet(String uid,String amount) { 
		logger.info("Entered UpdateWallet method of SessionDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userwallet SET AMOUNT= AMOUNT-? WHERE USER_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, amount);
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
					logger.error("UpdateWallet method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateWallet method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateWallet method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateWallet method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateWallet method of SessionDAO");
		return isCommit;
	}
	
	public Boolean  UpdateSessionDetails(String cost,String duration,String sid) { 
		logger.info("Entered UpdateSessionDetails method of SessionDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE sessiondetails SET SESSION_DURATION= ?,SESSION_PRICE=?,STATUS=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, duration);
			pstmt.setString(2, cost);
			pstmt.setString(3, "SESSION SUCCESSFULLY COMPLETED");
			pstmt.setString(4, sid);
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
					logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateSessionDetails method of SessionDAO");
		return isCommit;
	}
	
	public Boolean  UpdateCallStatus(String callDuration,String  callStatus,String status,String duration,String callSid) { 
		logger.info("Entered UpdateCallStatus method of SessionDAO");
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
			String query ="UPDATE twilliocalls SET USER_DURATION= ?,USER_CALL_STATUS=?,USER_STATUS_UPDATE_TIME=?,ADVISOR_DURATION= ?,ADVISOR_CALL_STATUS=?,ADVISOR_STATUS_UPDATE_TIME=? WHERE USER_CALL_SID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, callDuration);
			pstmt.setString(2, callStatus);
			pstmt.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(4, duration);
			pstmt.setString(5, status);
			pstmt.setTimestamp(6, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(7, callSid);
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
					logger.error("UpdateCallStatus method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateCallStatus method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateCallStatus method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateCallStatus method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateCallStatus method of SessionDAO");
		return isCommit;
	}
	
	public int[] GetUserAdvisorIds(String sId){
		logger.info("Entered GetUserAdvisorIds method of SessionDAO");
		int[] ids = null;
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID,USER_ID FROM sessiondetails WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sId);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				ids[0]= results.getInt("ADVISOR_ID");
				ids[1]= results.getInt("USER_ID");
			}
		} catch (SQLException e) {
			logger.error("GetUserAdvisorIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserAdvisorIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserAdvisorIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserAdvisorIds method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetUserAdvisorIds method of SessionDAO");
		return ids;
	}
	public String GetAdvisorName(int id){
		logger.info("Entered GetAdvisorName method of SessionDAO");
		String name = "";
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT NAME FROM advisordetails WHERE ADVISOR_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,id);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				name = results.getString("NAME");
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorName method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorName method of SessionDAO");
		return name;
	}
	
	public UserDetailsDTO GetUserName(int id){
		logger.info("Entered GetUserName method of SessionDAO");
		UserDetailsDTO user = new UserDetailsDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT FULL_NAME,IMAGE FROM userdetails WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,id);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				user.setFullName(results.getString("NAME"));
				user.setImage(results.getString("IMAGE"));
			}
		} catch (SQLException e) {
			logger.error("GetUserName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserName method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserName method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetUserName method of SessionDAO");
		return user;
	}
	
	public List<ReviewsDTO> GetUserReviews(int userId){
		logger.info("Entered GetUserReviews method of SessionDAO");
		List<ReviewsDTO> reviews = new ArrayList<ReviewsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM sessionreviews WHERE USER_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ReviewsDTO review = new ReviewsDTO();
				review.setSessionId(results.getInt("SESSION_ID"));
				review.setUserId(results.getInt("USER_ID"));
				review.setAdvisorId(results.getInt("ADVISOR_ID"));
				review.setReview(results.getString("REVIEW"));
				review.setRating(results.getString("RATING"));
				review.setPostedOn(results.getDate("POSTED_ON"));
				reviews.add(review);
			}
		
		} catch (SQLException e) {
			logger.error("GetUserReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviews;
	}
	
	public List<SessionDTO> GetSessionDate(List<Integer> ids){
		logger.info("Entered GetSessionDate method of SessionDAO");
		List<SessionDTO> dates = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(ids.size());
			System.out.println(q4in);
			String query = "SELECT SESSION_ID,ACCEPTED_DATE FROM sessiondetails WHERE SESSION_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (int id : ids) {
				pstmt.setInt(i++, id);
			}
			System.out.println(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				System.out.println("date" + results.getInt("SESSION_ID"));
				SessionDTO session = new SessionDTO();
				session.setAcceptedDate(results.getDate("ACCEPTED_DATE"));
				session.setSessionid(results.getInt("SESSION_ID"));
				dates.add(session);
			}
		
		} catch (SQLException e) {
			logger.error("GetSessionDate method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetSessionDate method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetSessionDate method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetSessionDate method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return dates;
	}
	
	public List<AdvisorDTO> GetDetailsForReviews(List<Integer> ids){
		logger.info("Entered GetDetailsForReviews method of SessionDAO");
		List<AdvisorDTO> advisors = new ArrayList<AdvisorDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(ids.size());
			System.out.println(q4in);
			String query = "SELECT ADVISOR_ID,NAME,IMAGE FROM advisordetails WHERE ADVISOR_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (int id : ids) {
				pstmt.setInt(i++, id);
			}
			System.out.println(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				AdvisorDTO advisor = new AdvisorDTO();
				advisor.setId(results.getInt("ADVISOR_ID"));
				advisor.setName(results.getString("NAME"));
				advisor.setImage(results.getString("IMAGE"));
				advisors.add(advisor);
			}
		
		} catch (SQLException e) {
			logger.error("GetDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return advisors;
	}
	
	public List<SessionDTO> GetPastSessionsUsingAdvisorId(int advisorId){
		logger.info("Entered GetPastSessionsUsingAdvisorId method of SessionDAO");
		List<SessionDTO> sessions = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM sessiondetails WHERE ADVISOR_ID=? AND STATUS IN (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, advisorId);
			pstmt.setString(2,"SESSION CANCELLED BY USER");
			pstmt.setString(3,"SESSION CANCELLED BY ADVISOR");
			pstmt.setString(4,"SESSION COMPLETE");
            ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO session = new SessionDTO();
				session.setSessionid(results.getInt("SESSION_ID"));
				session.setUserid(results.getInt("USER_ID"));
				session.setMode(results.getString("MODE"));
				session.setQuery(results.getString("QUERY"));
				session.setStatus(results.getString("STATUS"));
				sessions.add(session);

			}
		} catch (SQLException e) {
			logger.error("GetPastSessionsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetPastSessionsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetPastSessionsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetPastSessionsUsingAdvisorId method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return sessions;
	}
	
	public List<ReviewsDTO> GetAdvisorReviews(int advisorId){
		logger.info("Entered GetAdvisorReviews method of SessionDAO");
		List<ReviewsDTO> reviews = new ArrayList<ReviewsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM sessionreviews WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, advisorId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ReviewsDTO review = new ReviewsDTO();
				review.setSessionId(results.getInt("SESSION_ID"));
				review.setUserId(results.getInt("USER_ID"));
				review.setAdvisorId(results.getInt("ADVISOR_ID"));
				review.setReview(results.getString("REVIEW"));
				review.setRating(results.getString("RATING"));
				review.setPostedOn(results.getDate("POSTED_ON"));
				reviews.add(review);
			}
		
		} catch (SQLException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviews;
	}
	
	public List<UserDetailsDTO> GetDetailsForReviewsUsingUserIds(List<Integer> ids){
		logger.info("Entered GetDetailsForReviewsUsingUserIds method of SessionDAO");
		List<UserDetailsDTO> users = new ArrayList<UserDetailsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(ids.size());
			String query = "SELECT USER_ID,FULL_NAME,IMAGE FROM userdetails WHERE USER_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (int id : ids) {
				pstmt.setInt(i++, id);
			}
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				UserDetailsDTO user = new UserDetailsDTO();
				user.setUserId(results.getInt("USER_ID"));
				user.setFullName(results.getString("FULL_NAME"));
				user.setImage(results.getString("IMAGE"));
				users.add(user);
			}
		
		} catch (SQLException e) {
			logger.error("GetDetailsForReviewsUsingUserIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetDetailsForReviewsUsingUserIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetDetailsForReviewsUsingUserIds method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetDetailsForReviewsUsingUserIds method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return users;
	}
	
	public Double[] GetAdvisorPrices(String aid){
		logger.info("Entered GetAdvisorPrices method of SessionDAO");
		Double[] prices = new Double[2];
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT PHONE_PRICE,VIDEO_PRICE FROM advisordetails WHERE ADVISOR_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, aid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				prices[0] = results.getDouble("PHONE_PRICE");
				prices[1] = results.getDouble("VIDEO_PRICE");
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorPrices method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorPrices method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorPrices method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorPrices method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorPrices method of SessionDAO");
		return prices;
	}
	
	public Boolean  UpdateSessionDetails(String status,String sId,String[] date) { 
		logger.info("Entered UpdateStatus method of SessionDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE sessiondetails SET STATUS=?,ACCEPTED_DATE=?,ACCEPTED_TIME=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setString(2,date[0]); 
			pstmt.setString(3,date[1]); 
			pstmt.setString(4, sId);
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
					logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateSessionDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateSessionDetails method of SessionDAO");
		return isCommit;
	}
	
	
	public Boolean SetTwilioConversationDetails(String sid){
		logger.info("Entered SetTwilioConversationDetails method of SessionDAO");
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
			String query = "insert into twiliovideo"+"(SESSION_ID,CONVERSATION_START) values" + "(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("SetTwilioConversationDetails method of SessionDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("SetTwilioConversationDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SetTwilioConversationDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SetTwilioConversationDetails method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("SetTwilioConversationDetails method of SessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered SetTwilioConversationDetails method of SessionDAO");
			return isCommit;

		}
	
	public Boolean  SetTwilioConversationEnd(String sId) { 
		logger.info("Entered SetTwilioConversationEnd method of SessionDAO");
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
			String query ="UPDATE twiliovideo SET CONVERSATION_END=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
			pstmt.setString(2, sId);
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
					logger.error("SetTwilioConversationEnd method of SessionDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("SetTwilioConversationEnd method of SessionDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("SetTwilioConversationEnd method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("SetTwilioConversationEnd method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit SetTwilioConversationEnd method of SessionDAO");
		return isCommit;
	}
	
	public List<TwilioVideoDTO> GetTwilioVideoConversationTimings(String sid){
		logger.info("Entered GetTwilioVideoConversationTimings method of SessionDAO");
		List<TwilioVideoDTO> video =  new ArrayList<TwilioVideoDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT CONVERSATION_START,CONVERSATION_END FROM twiliovideo WHERE SESSION_ID= ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				TwilioVideoDTO twil = new TwilioVideoDTO();
				twil.setStart(results.getTimestamp("CONVERSATION_START"));
				twil.setEnd(results.getTimestamp("CONVERSATION_END"));
				video.add(twil);
			}
		
		} catch (SQLException e) {
			logger.error("GetTwilioVideoConversationTimings method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetTwilioVideoConversationTimings method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetTwilioVideoConversationTimings method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetTwilioVideoConversationTimings method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return video;
	}
	
	
	public ReviewsDTO GetReviews(String sid){
		logger.info("Entered GetReviews method of SessionDAO");
		ReviewsDTO reviews = new ReviewsDTO();
		 SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");

 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT RATING,REVIEW,POSTED_ON,STATUS FROM sessionreviews WHERE SESSION_ID= ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				reviews.setRating(results.getString("RATING"));
				reviews.setReview(results.getString("REVIEW"));
				reviews.setDate(sdf.format(results.getDate("POSTED_ON")));
				reviews.setStatus(results.getString("STATUS"));
            }
		
		} catch (SQLException e) {
			logger.error("GetReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviews;
	}
	public List<ReviewsDTO> GetAdvisorReviews(String aid){
		logger.info("Entered GetAdvisorReviews method of SessionDAO");
		List<ReviewsDTO> reviews = new ArrayList<ReviewsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM sessionreviews WHERE ADVISOR_ID =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, aid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				ReviewsDTO review = new ReviewsDTO();
				review.setSessionId(results.getInt("SESSION_ID"));
				review.setUserId(results.getInt("USER_ID"));
				review.setAdvisorId(results.getInt("ADVISOR_ID"));
				review.setReview(results.getString("REVIEW"));
				review.setRating(results.getString("RATING"));
				review.setPostedOn(results.getDate("POSTED_ON"));
				review.setStatus(results.getString("STATUS"));
				reviews.add(review);
			}
		
		} catch (SQLException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return reviews;
	}
	
	public List<UserDetailsDTO> GetUserDetailsForReviews(List<Integer> ids){
		logger.info("Entered GetUserDetailsForReviews method of SessionDAO");
		List<UserDetailsDTO> users = new ArrayList<UserDetailsDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(ids.size());
			System.out.println(q4in);
			String query = "SELECT USER_ID,FULL_NAME FROM userdetails WHERE USER_ID IN ( "+ q4in + ")";
			PreparedStatement pstmt = conn.prepareStatement(query);
			int i = 1;
			for (int id : ids) {
				pstmt.setInt(i++, id);
			}
			System.out.println(query);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				UserDetailsDTO user = new UserDetailsDTO();
				user.setUserId(results.getInt("USER_ID"));
				user.setFullName(results.getString("FULL_NAME"));
				users.add(user);
			}
		
		} catch (SQLException e) {
			logger.error("GetUserDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetailsForReviews method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return users;
	}
	
	public List<AnswerDTO> GetAdvisorAnswers(String aid){
		logger.info("Entered GetAdvisorAnswers method of SessionDAO");
		 List<AnswerDTO> answers = new ArrayList<AnswerDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT QID,ANSWER FROM answers WHERE ADVISOR_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, aid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				AnswerDTO answer = new AnswerDTO();
				answer.setQuestionId(results.getInt("QID"));
				answer.setAnswer(results.getString("ANSWER"));
				answers.add(answer);
			}
		} catch (SQLException e) {
			logger.error("GetAdvisorAnswers method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorAnswers method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorAnswers method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorAnswers method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
				
		logger.info("Entered GetAdvisorAnswers method of SessionDAO");
		return answers;
	}
	
	public List<QuestionsDTO> GetQuestions(List<Integer> qids){
		logger.info("Entered GetQuestions method of SessionDAO");
		List<QuestionsDTO> questions = new ArrayList<QuestionsDTO>();
		 SimpleDateFormat sdf=new SimpleDateFormat("dd MMM yyyy");
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String q4in = generateQsForIn(qids.size());
			String query = "SELECT QUESTION,TIMESTAMP,Q_ID FROM questions WHERE STATUS = ? AND Q_ID IN ( "+ q4in + ") ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "APPROVED");
			int i = 2;
			for (int id : qids) {
				pstmt.setInt(i++, id);
			}
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				QuestionsDTO question = new QuestionsDTO();
				question.setQuestionId(results.getInt("Q_ID"));
				question.setQuestion(results.getString("QUESTION"));
				question.setPostedOnDate(sdf.format(results.getTimestamp("TIMESTAMP")));
				questions.add(question);
			}
		
		} catch (SQLException e) {
			logger.error("GetQuestions method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetQuestions method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetQuestions method of SessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetQuestions method of SessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
	return questions;
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
