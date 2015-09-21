package ac.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.dto.ContactUsDTO;
import ac.dto.UserDetailsDTO;
import ac.jdbc.ConnectionFactory;

public class AdminDAO {
	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger.getLogger(AdminDAO.class);
	
	public Boolean  CheckLoginDetails(String username , String securedPassword) { 
		
		
		logger.info("Entered CheckLoginDetails method of AdminDAO");
		ResultSet results = null;
		Boolean isAutheticated = false;
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT * FROM admin_table WHERE EMAIL = ? AND PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,username);
			pstmt.setString(2,securedPassword);
		    results = pstmt.executeQuery();
		    if(results.first()){
		    	isAutheticated = true;
		    }
			conn.commit();
			
		logger.info("Exit CheckLoginDetails method of AdminDAO");
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
					e2.printStackTrace();
				}
				logger.error("CheckLoginDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckLoginDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		return isAutheticated;
}
    public List<UserDetailsDTO> GetUserDetails(){
    	logger.info("Entered GetUserDetails method of AdminDAO");
   		List<UserDetailsDTO> list = new ArrayList<UserDetailsDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT USER_ID,EMAIL,PHONE_NUMBER,FULL_NAME,ISACTIVE,OCCUPATION FROM userdetails ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
				UserDetailsDTO user = new UserDetailsDTO();
				user.setUserId(results.getInt("USER_ID"));
				user.setEmail(results.getString("EMAIL"));
				user.setFullName(results.getString("FULL_NAME"));
				user.setPhone(results.getString("PHONE_NUMBER"));
				user.setOccupation(results.getString("OCCUPATION"));
				user.setIsActive(results.getBoolean("ISACTIVE"));
				list.add(user);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetUserDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetUserDetails method of AdminDAO");
		return list;
	}
    
	public Boolean  UpdateUserIsActive(Boolean value,String uid) { 
		logger.info("Entered UpdateUserIsActive method of AdminDAO");
		Boolean isCommit = false ;

		try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE userdetails SET ISACTIVE=? WHERE USER_ID = ? ";
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
					logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateUserIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateUserIsActive method of AdminDAO");
		return isCommit;
	}
	
	public UserDetailsDTO GetUserDetails(String email) {

		logger.info("Entered GetUserDetails method of AdminDAO");
		ResultSet results = null;
		UserDetailsDTO user = new UserDetailsDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM userdetails WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			results = pstmt.executeQuery();
			if (results.first()) {
				user.setUserId(results.getInt("USER_ID"));
				user.setEmail(results.getString("EMAIL"));
				user.setFullName(results.getString("FULL_NAME"));
				user.setPhone(results.getString("PHONE_NUMBER"));
				user.setImage(results.getString("IMAGE"));
				user.setDateOfRegistration(results.getTimestamp("DATE_OF_REGISTRATION"));
				user.setIsActive(results.getBoolean("ISACTIVE"));
			}
			logger.info("Exit GetUserDetails method of AdminDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetUserDetails method of AdminDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetUserDetails method of AdminDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetUserDetails method of AdminDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public List<AdvisorDTO> GetAdvisorDetails(){
   		logger.info("Entered GetAdvisorDetails method of AdminDAO");
   		List<AdvisorDTO> list = new ArrayList<AdvisorDTO>();
   		
   		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query="";
			query = "SELECT ADVISOR_ID,NAME,PHONE_NUMBER,EMAIL,ISACTIVE FROM advisordetails ";	
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet results = pstmt.executeQuery();
			while (results.next()) {
			AdvisorDTO adv = new AdvisorDTO();
			adv.setId(results.getInt("ADVISOR_ID"));
			adv.setName(results.getString("NAME"));
			adv.setEmail(results.getString("EMAIL"));
			adv.setPhoneNo(results.getString("PHONE_NUMBER"));
			adv.setIsActive(results.getBoolean("ISACTIVE"));
			list.add(adv);
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			} catch (SQLException e1) {
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorDetails method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit GetAdvisorDetails method of AdminDAO");
		return list;
	}
	
	public Boolean  UpdateAdvisorIsActive(Boolean value,String aid) { 
		logger.info("Entered UpdateAdvisorIsActive method of AdminDAO");
		Boolean isCommit = false ;
         try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE advisordetails SET ISACTIVE=? WHERE ADVISOR_ID = ? ";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, value);
			pstmt.setString(2, aid);
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
					logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAdvisorIsActive method of AdminDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAdvisorIsActive method of AdminDAO");
		return isCommit;
	}
	

	public List<ContactUsDTO> GetContactUsDetails() {
		logger.info("Entered GetUserDetails method of AdminUserDAO");
		ResultSet results = null;
		List<ContactUsDTO> contactList = new ArrayList<ContactUsDTO>();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT * FROM contactus";
			PreparedStatement pstmt = conn.prepareStatement(query);
			results = pstmt.executeQuery();
			while (results.next()) {
				ContactUsDTO contact = new ContactUsDTO();
				contact.setId(results.getInt("ID"));
				contact.setName(results.getString("NAME"));
				contact.setEmail(results.getString("EMAIL"));
				contact.setPhone(results.getString("PHONE_NUMBER"));
				contact.setMessage(results.getString("MESSAGE"));
				contactList.add(contact);
			}
			logger.info("Exit GetUserDetails method of AdminUserDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("GetUserDetails method of AdminUserDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("GetUserDetails method of AdminUserDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("GetUserDetails method of AdminUserDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetUserDetails method of AdminUserDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return contactList;
	}
}
