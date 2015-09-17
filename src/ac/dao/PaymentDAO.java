package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import ac.jdbc.ConnectionFactory;

public class PaymentDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(PaymentDAO.class);
	
	
	public Boolean SetTransactionDetails(String sid ,String order_status,String amount,String trackingId, String paymentMode){
		logger.info("Entered SetTransactionDetails method of PaymentDAO");
		Boolean isCommit = false;
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "insert into sessionrecharge"+"(SESSION_ID,STATUS,AMOUNT,TRACKING_ID,PAYMENT_MODE) values" + "(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sid);
			pstmt.setString(2, order_status);
			pstmt.setString(3, amount);
			pstmt.setString(4, trackingId);
			pstmt.setString(5, paymentMode);
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
	
}
