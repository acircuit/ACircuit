/*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 29/11/2014
 * ************************************************************************************************/
package ac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ac.dto.AdvisorDTO;
import ac.jdbc.ConnectionFactory;

/* *******************************CLASS SUMMARY****************************************************
 * 
 * This DAO class will make all the DB calls after the advisor Login
 * 
 * 
 *
 ***************************************************************************************************/

public class AdvisorLoginDAO {

	Connection conn = null;
	Statement stmt = null;
	private static final Logger logger = Logger
			.getLogger(AdvisorLoginDAO.class);

	/**************************************
	 * COMMENTS*************************************************** This function
	 * will retrieve the login credentials and check for valid credentials.Upon
	 * successfull validations sets the cookie and session and then redirects it
	 * to the MyAccount Page
	 * 
	 * @return : AdvisorProfileDTO advisor
	 * @param : String username String securedPassword
	 * 
	 *
	 ***************************************************************************************************/
	public AdvisorDTO CheckLoginDetails(String email,
			String securedPassword) {
		logger.info("Entered CheckLoginDetails method of AdvisorLoginDAO");
		ResultSet results = null;
		AdvisorDTO advisor = new AdvisorDTO();
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query = "SELECT ADVISOR_ID,NAME,EMAIL,ISACTIVE,ISVERIFIED,IMAGE FROM advisordetails WHERE EMAIL = ? AND PASSWORD = ? AND ISACTIVE=? AND ISVERIFIED=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, securedPassword);
			pstmt.setBoolean(3, true);
			pstmt.setBoolean(4, true);
			results = pstmt.executeQuery();
			if (results.first()) {
				advisor.setId(results.getInt("ADVISOR_ID"));
				advisor.setName(results.getString("NAME"));
				advisor.setEmail(results.getString("EMAIL"));
				advisor.setImage(results.getString("IMAGE"));
				advisor.setIsActive(results.getBoolean("ISACTIVE"));
				advisor.setIsVerified(results.getBoolean("ISVERIFIED"));
			}
			logger.info("Exit CheckLoginDetails method of AdvisorLoginDAO");
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					logger.error("CheckLoginDetails method of AdvisorLoginDAO threw error:"
							+ e.getMessage());
					e2.printStackTrace();
				}
				logger.error("CheckLoginDetails method of AdvisorLoginDAO threw error:"
						+ e.getMessage());
				e1.printStackTrace();
			}
			logger.error("CheckLoginDetails method of AdvisorLoginDAO threw error:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckLoginDetails method of AdvisorLoginDAO threw error:"
						+ e.getMessage());
				e.printStackTrace();
			}
		}
		return advisor;
	}
	

	public Boolean  UpdateAdvisorVerification(String uid,Boolean value) { 
		logger.info("Entered UpdateAdvisorVerification method of AdvisorLoginDAO");
		Boolean isCommit = false ;
       try {
			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="UPDATE advisordetails SET ISVERIFIED=? WHERE ADVISOR_ID = ? ";
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
					logger.error("UpdateAdvisorVerification method of AdvisorLoginDAO threw error:"+e2.getMessage());
					e2.printStackTrace();
				}
				logger.error("UpdateAdvisorVerification method of AdvisorLoginDAO threw error:"+e1.getMessage());
				e1.printStackTrace();
			}
			logger.error("UpdateAdvisorVerification method of AdvisorLoginDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("UpdateAdvisorVerification method of AdvisorLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}
		logger.info("Exit UpdateAdvisorVerification method of AdvisorLoginDAO");
		return isCommit;
	}
	
	
	public String  GetAdvisorEmail(String aid) { 
		logger.info("Entered GetAdvisorEmail method of AdvisorLoginDAO");
		ResultSet results = null;
		String email="";
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT EMAIL FROM advisordetails WHERE ADVISOR_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,aid);
		        results = pstmt.executeQuery();
		    if(results.first()){
		    	email = results.getString("EMAIL");
		    }
		logger.info("Exit GetAdvisorEmail method of AdvisorLoginDAO");
		}catch(Exception e){
			logger.error("GetAdvisorEmail method of AdvisorLoginDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("GetAdvisorEmail method of AdvisorLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		return email;
}
	
	public int  CheckEmailExistsAdvisor(String email) { 
		logger.info("Entered CheckEmailExistsAdvisor method of AdvisorLoginDAO");
		ResultSet results = null;
		int id =0;
		try {

			conn =ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			String query ="SELECT ADVISOR_ID FROM advisordetails WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email);
		    results = pstmt.executeQuery();
		    if(results.first()){
		    	id = results.getInt("ADVISOR_ID");
		    }
		logger.info("Exit CheckEmailExistsAdvisor method of AdvisorLoginDAO");
		}catch(Exception e){
			logger.error("CheckEmailExistsAdvisor method of AdvisorLoginDAO threw error:"+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error("CheckEmailExistsAdvisor method of AdvisorLoginDAO threw error:"+e.getMessage());
				e.printStackTrace();
			}
		}	
		return id;
        }

}
