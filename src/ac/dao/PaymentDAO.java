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

import ac.dto.AdvisorDTO;
import ac.jdbc.ConnectionFactory;

public class PaymentDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(PaymentDAO.class);
	
	
	public Boolean SetTransactionDetails(String sid ,String order_status,String amount,String trackingId, String paymentMode,String uid){
		logger.info("Entered SetTransactionDetails method of PaymentDAO");
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
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into sessionrecharge"+"(RECHARGE_ID,STATUS,AMOUNT,TRACKING_ID,PAYMENT_MODE,TIMESTAMP,USER_ID) values" + "(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setString(2, order_status);
			pstmt.setString(3, amount);
			pstmt.setString(4, trackingId);
			pstmt.setString(5, paymentMode);
			pstmt.setTimestamp(6, new java.sql.Timestamp(date.getTime()));
			pstmt.setInt(7, Integer.valueOf(uid));
            int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				isCommit = true;
			}
		}catch (SQLException e) {
			    try {
					conn.rollback();
				} catch (SQLException e1) {
					logger.error("SetTransactionDetails method of PaymentDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("SetTransactionDetails method of PaymentDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				logger.error("SetTransactionDetails method of PaymentDAO threw error:"+e.getMessage());
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				logger.error("SetTransactionDetails method of PaymentDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("SetTransactionDetails method of PaymentDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			logger.info("Entered SetTransactionDetails method of PaymentDAO");
			return isCommit;

		}
	public Boolean  UpdateWallet(String uid,String amount) { 
		logger.info("Entered UpdateWallet method of PaymentDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userwallet SET AMOUNT= AMOUNT+? WHERE USER_ID = ? ";
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
					logger.error("UpdateWallet method of PaymentDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateWallet method of PaymentDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateWallet method of PaymentDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateWallet method of PaymentDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateWallet method of PaymentDAO");
		return isCommit;
	}
	
/*	public List<AdvisorDTO> GetDetailsForReviews(List<Integer> ids){
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
	}*/
	
}
