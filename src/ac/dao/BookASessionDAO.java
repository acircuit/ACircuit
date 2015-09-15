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
import java.util.Date;

import org.apache.log4j.Logger;

import ac.jdbc.ConnectionFactory;

public class BookASessionDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(BookASessionDAO.class);
	
	public int SetSessionDetails(String mode, String duration, String query,String slot1Date, String slot2Date, String slot3Date, String slot1Time,String slot2Time, String slot3Time, String approxprice,String aid, int uid,String resume){
		logger.info("Entered SetSessionDetails method of BookASessionDAO");
		Date date1=null;
		Date date2=null;
		Date date3=null;
		int sessionId = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		try {
			date1 =  (Date) formatter.parse(slot1Date);
			date2 =  (Date) formatter.parse(slot2Date);
			date3 =  (Date) formatter.parse(slot3Date);

		} catch (ParseException e) {
			logger.error("setBookASessionDetails method of BookASessionDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}
			try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query1 = "insert into sessiondetails"+"(ADVISOR_ID,USER_ID,CV,MODE,DURATION,DATE1,TIME1,DATE2,TIME2,DATE3,TIME3,PRICE,STATUS) values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, Integer.valueOf(aid));
				pstmt.setInt(2, uid);
				pstmt.setString(3, resume);
				pstmt.setString(4, mode);
				pstmt.setString(5, duration);
				pstmt.setDate(6,new java.sql.Date(date1.getTime()));
				pstmt.setString(7, slot1Time);
				pstmt.setDate(8,new java.sql.Date(date2.getTime()));
				pstmt.setString(9, slot2Time);
				pstmt.setDate(10,new java.sql.Date(date3.getTime()));
				pstmt.setString(11, slot3Time);
				pstmt.setString(12, approxprice);
				pstmt.setString(13, "PENDING APPROVAL");
				int result = pstmt.executeUpdate(); 
				if(result >0) {
					ResultSet generatedKeys = pstmt.getGeneratedKeys();
					if (null != generatedKeys && generatedKeys.next()) {
						sessionId = generatedKeys.getInt(1);
					}
					conn.commit();
				}
				logger.info("Exit SetSessionDetails method of BookASessionDAO");
			} catch (SQLException e) {
				logger.error("SetSessionDetails method of BookASessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SetSessionDetails method of BookASessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SetSessionDetails method of BookASessionDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("setCV method of BookASessionDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
		return sessionId;		
	}
}
