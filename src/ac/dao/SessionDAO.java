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
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.dto.SessionDTO;
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
			String query ="SELECT FULL_NAME,IMAGE FROM userdetails WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			if(results.first()){
				dto.setFullName(results.getString("FULL_NAME"));
				dto.setImage(results.getString("IMAGE"));

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
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	    try {
			date1 = sdf.parse(date);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	    
	    System.out.println(new java.sql.Date(date1.getTime()));
	    
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE sessiondetails SET SESSIONPLAN = ?,STATUS=?,ACCEPTED_DATE=?,ACCEPTED_TIME=? WHERE SESSION_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sessionPlan);
			if(isNewDates){
				pstmt.setString(2, "ACCEPTED WITH NEW DATES");
			}else{
				pstmt.setString(2, "ACCEPTED");
			}
			pstmt.setDate(3, new java.sql.Date(date1.getTime()));
			pstmt.setString(4, time);
			pstmt.setString(5, sId);
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
	
	
	public UserDetailsDTO GetSessionDetails(int uid){
		logger.info("Entered GetSessionDetails method of SessionDAO");
		List<SessionDTO> list = new ArrayList<SessionDTO>();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT FULL_NAME,IMAGE FROM userdetails WHERE USER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				SessionDTO dto = new SessionDTO();
				dto.set
				dto.setImage(results.getString("IMAGE"));

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
	
	public AdvisorDTO GetAdvisorDetails(int sid){
		logger.info("Entered GetAdvisorDetails method of SessionDAO");
		AdvisorDTO advisor = new AdvisorDTO();
 	try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT NAME,IMAGE FROM advisordetails WHERE SESSION_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sid);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				advisor.setName(results.getString("NAME"));
				advisor.setImage(results.getString("IMAGE"));

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
	
	
}
