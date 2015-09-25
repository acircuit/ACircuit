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
				String query ="SELECT USER_ID,FULL_NAME,ISACTIVE,EMAIL FROM userdetails WHERE EMAIL = ? AND PASSWORD = ? AND ISACTIVE=?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,username);
				pstmt.setString(2,securedPassword);
				pstmt.setBoolean(3, true);
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
	
		public Boolean  UpdateUserVerification(String uid,Boolean value) { 
			logger.info("Entered UpdateUserVerification method of UserLoginDAO");
			Boolean isCommit = false ;
           try {
				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query ="UPDATE userdetails SET ISVERIFIED=? WHERE USER_ID = ? ";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setBoolean(1, value);
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
						logger.error("UpdateUserVerification method of UserLoginDAO threw error:"+e2.getMessage());
						e2.printStackTrace();
					}
					logger.error("UpdateUserVerification method of UserLoginDAO threw error:"+e1.getMessage());
					e1.printStackTrace();
				}
				logger.error("UpdateUserVerification method of UserLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("UpdateUserVerification method of UserLoginDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}
			logger.info("Exit UpdateUserVerification method of UserLoginDAO");
			return isCommit;
		}
		
		public String  GetUserEmail(String uid) { 
			logger.info("Entered GetUserEmail method of UserLoginDAO");
			ResultSet results = null;
			String email="";
			try {

				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query ="SELECT EMAIL FROM userdetails WHERE USER_ID=?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,uid);
 		        results = pstmt.executeQuery();
			    if(results.first()){
			    	email = results.getString("EMAIL");
			    }
			logger.info("Exit GetUserEmail method of UserLoginDAO");
			}catch(Exception e){
				logger.error("GetUserEmail method of UserLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("GetUserEmail method of UserLoginDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			return email;
	}
		
		public int  CheckEmailExistsUser(String email) { 
			logger.info("Entered CheckEmailExistsUser method of UserLoginDAO");
			ResultSet results = null;
			int id =0;
			try {

				conn =ConnectionFactory.getConnection();
				conn.setAutoCommit(false);
				String query ="SELECT USER_ID FROM userdetails WHERE EMAIL = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1,email);
			    results = pstmt.executeQuery();
			    if(results.first()){
			    	id = results.getInt("USER_ID");
			    }
			logger.info("Exit CheckEmailExistsUser method of UserLoginDAO");
			}catch(Exception e){
				logger.error("CheckEmailExistsUser method of UserLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("CheckEmailExistsUser method of UserLoginDAO threw error:"+e.getMessage());
					e.printStackTrace();
				}
			}	
			return id;
	}
		
	
}
