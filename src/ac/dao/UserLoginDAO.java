package ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ac.dto.UserDetailsDTO;
import ac.jdbc.ConnectionFactory;

public class UserLoginDAO {
	
	
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(UserLoginDAO.class);
	
	
		public UserDetailsDTO  CheckLoginDetails(String username , String securedPassword) { 
			
			
			logger.info("Entered CheckLoginDetails method of UserLoginDAO");
			ResultSet results = null;
			UserDetailsDTO user = new ac.dto.UserDetailsDTO();
			try {

				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query ="SELECT USER_ID,FULL_NAME,ISACTIVE,EMAIL FROM userdetails WHERE EMAIL = ? AND PASSWORD = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,username);
				pstmt.setString(2,securedPassword);
			    results = pstmt.executeQuery();
			    if(results.first()){
			    	user.setUserId(results.getInt("USER_ID"));
			    	user.setFullName(results.getString("FULL_NAME"));
			    	user.setIsActive(results.getBoolean("ISACTIVE"));
			    	user.setEmail(results.getString("EMAIL"));
			    }
			logger.info("Exit CheckLoginDetails method of UserLoginDAO");
			}catch(Exception e){
				logger.error("CheckLoginDetails method of UserLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("CheckLoginDetails method of UserLoginDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			return user;
	}
	
}
