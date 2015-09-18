package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import ac.dto.NotificationDTO;
import ac.jdbc.ConnectionFactory;

public class UserNotificationDAO {
	private static final Logger logger = Logger.getLogger(UserNotificationDAO.class);
	Connection conn = null;
	
	
	public Boolean InsertNotification(String comment, String href, String uId){
		logger.info("Entered InsertNotification method of UserNotificationDAO");
		Boolean isNotification = false;
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
						String query = "insert into user_notification"+"(COMMENT,HREF,USER_ID,DATE) values" + "(?,?,?,?)";
						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1,comment);
						pstmt.setString(2,href);
						pstmt.setString(3,uId);
						pstmt.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
						int result = pstmt.executeUpdate();
						if(result > 0) {
							conn.commit();
							isNotification = true;					
						}
					} catch (SQLException e) {
						try {
							conn.rollback();
						} catch (SQLException e1) {
							logger.error("InsertNotification method of UserNotificationDAO threw error:"+e.getMessage());
							e1.printStackTrace();
						}	
						logger.error("InsertNotification method of UserNotificationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (IOException e) {
						logger.error("InsertNotification method of UserNotificationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					} catch (PropertyVetoException e) {
						logger.error("InsertNotification method of UserNotificationDAO threw error:"+e.getMessage());
						e.printStackTrace();
					}finally{
						try {
							conn.close();
						} catch (SQLException e) {
							logger.error("InsertNotification method of UserNotificationDAO threw error:"+e.getMessage());
							e.printStackTrace();
						}
					}	
			logger.info("Entered InsertNotification method of UserNotificationDAO");
			return isNotification;

		}
	
	public List<NotificationDTO> GetNotifications(int uId){
		logger.info("Entered GetNotifications method of UserNotificationDAO");
		List<NotificationDTO> notify = new ArrayList<NotificationDTO>();
		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM user_notification WHERE USER_ID=? ORDER BY DATE DESC";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uId);
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				NotificationDTO note = new NotificationDTO();
				note.setnId(results.getInt("N_ID"));
				note.setComment(results.getString("COMMENT"));
				note.setHref(results.getString("HREF"));
				note.setIsPrevious(results.getBoolean("IS_PREVIOUS"));
				note.setDate(results.getTimestamp("DATE"));
				note.setIsViewed(results.getBoolean("IS_VIEWED"));
				notify.add(note);
			}

		} catch (SQLException e) {
			logger.error("GetNotifications method of UserNotificationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetNotifications method of UserNotificationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetNotifications method of UserNotificationDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetNotifications method of UserNotificationDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Entered GetNotifications method of UserNotificationDAO");
		return notify;
	}
}
