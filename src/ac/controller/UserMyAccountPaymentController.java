package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.PaymentDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.SessionDTO;
import ac.dto.UserDetailsDTO;
import ac.util.CreateTwiml;
import ac.util.SendMail;

import com.ccavenue.security.AesCryptUtil;

/**
 * Servlet implementation class UserMyAccountPaymentController
 */
@WebServlet("/UserMyAccountPaymentController")
public class UserMyAccountPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserMyAccountPaymentController.class);   
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserMyAccountPaymentController");
		String encResp= request.getParameter("encResp");
		String sessionPrice= request.getParameter("amount");
		String sid= request.getParameter("sid");

		Properties prop = new Properties();
	    InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
	    prop.load(resourceAsStream1);
		if (encResp != null) {
			String workingKey = prop.getProperty("WORKING_KEY");		//32 Bit Alphanumeric Working Key should be entered here so that data can be decrypted.
			AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
			String decResp = aesUtil.decrypt(encResp);
			StringTokenizer tokenizer = new StringTokenizer(decResp, "&");
			String order_status = "";
			String oId ="";String sId = "";
			String uid="";
			String type = "";
			String date = "";
			String pair=null, pname=null, pvalue=null;
			String amount = "",trackingId="",paymentMode="",accDate="";
			while (tokenizer.hasMoreTokens()) {
				pair = (String)tokenizer.nextToken();
				if(pair!=null) {
					StringTokenizer strTok=new StringTokenizer(pair, "=");
					pname=""; pvalue="";
					if(strTok.hasMoreTokens()) {
						pname=(String)strTok.nextToken();
						if(strTok.hasMoreTokens())
							pvalue=(String)strTok.nextToken();
							if(pname.equals("order_id")){
								oId = pvalue;
							}
							if(pname.equals("order_status")){
								order_status = pvalue;
							}
							if(pname.equals("amount")){
								amount = pvalue;
							}
							if(pname.equals("tracking_id")){
								trackingId = pvalue;
							}
							if(pname.equals("payment_mode")){
								paymentMode = pvalue;
							}
							if(pname.equals("merchant_param1")){
								uid = pvalue;
							}
							if(pname.equals("merchant_param2")){
								type = pvalue;
							}
							if(pname.equals("merchant_param3")){
								sId = pvalue;
							}
							if(pname.equals("merchant_param4")){
								date = pvalue;
							}
							
					}
				}
			}
			if(oId != null && !oId.equals("") && order_status.equals("Success")){
				Boolean isWalletUpdated = false;
				Boolean isStatusCommit = false;
				//Entering the details of the transaction
				PaymentDAO transactionDetails = new PaymentDAO();
				Boolean isCommit =  transactionDetails.SetTransactionDetails(oId,order_status,amount,trackingId,paymentMode,uid);
				if(isCommit){
					PaymentDAO wallet = new PaymentDAO();
					isWalletUpdated = wallet.UpdateWallet(uid,amount);
				}
				
				
					if(type.equals("recharge")){
						  response.sendRedirect("userpaymenthistory?recharge="+order_status);
					}else{
						if(isWalletUpdated){
							if(date != null ){
								String[] acceptedDate = date.split(",");
								//Update Date and status
								SessionDAO update = new SessionDAO();
								isStatusCommit =  update.UpdateSessionDetails("SESSION ON SCHEDULE", sId,acceptedDate);
								
							}else{
								//Update session status
								SessionDAO status = new SessionDAO();
								isStatusCommit =  status.UpdateStatus("SESSION ON SCHEDULE", sId);
							}
							
						}
						if(isStatusCommit){
							  CreateTwiml twiml = new CreateTwiml();
							  Boolean isCreated =  twiml.CreateTwimlXML(sId);
							  if(isCreated){
						          response.sendRedirect("usercurrentsession?sId="+sId+"&session="+order_status);
							  }
						}
					}
				
			}else{
				//Transaction was not successfull
				response.sendRedirect("useracceptsession?sId="+sId);
			}
		
		}else{
			int userId = 0;
			Boolean isError =false;
			try{
				userId = (int) request.getSession().getAttribute("userId");
			}catch(Exception e){
				isError = true;
			}
			//Getting the sessiondetails for the user
			if(userId != 0){

				String date = request.getParameter("merchant_param4");
				Boolean isWalletUpdated =false;
				Boolean isStatusCommit =false;

				String amount = request.getParameter("amount");
				String sId = request.getParameter("sid");
				SessionDAO advisor = new SessionDAO();
				int aid = advisor.GetAdvisorId(sId);
				SessionDAO advisorName = new SessionDAO();
				AdvisorDTO advDetails = advisorName.GetAdvisorDetails(Integer.valueOf(aid));
				SessionDAO user = new SessionDAO();
				UserDetailsDTO userName  = user.GetUserName(userId);
				SessionDAO sessions = new SessionDAO();
				SessionDTO sessionDetails = sessions.GetSessionDetails(sId);
					if(date != null && !date.equals("") ){
						String[] acceptedDate = date.split(",");
						//Update Date and status
						SessionDAO update = new SessionDAO();
						isStatusCommit =  update.UpdateSessionDetails("SESSION ON SCHEDULE", sId,acceptedDate);
				   		 String comment = "Your session is on schedule ";
			   				String href = "advisorcurrentsession?sId="+sId;
			   				//Notification for Admin
			   				AdvisorNotificationDAO notify = new AdvisorNotificationDAO();
			   				notify.InsertNotification(comment,String.valueOf(aid),href); 
			        		String comment1 = "User confirmed the session";
							String href1 = "adminsessionviewdetails?sid="+sId;
							AdminNotificationDAO admin = new AdminNotificationDAO();
							admin.InsertNotification(comment1, href1);
							if(isStatusCommit){
								String subject = "Session had been confirmed- #"+sId+"!";
								String content = "Hello, <br><br>A session had been confirmed by the user<br><br>"
										+ "1.Session ID : "+sId+"<br>"
										+ "2.Username: "+userName.getFullName()+"<br>"
										+ "3.Advisorname:"+advDetails.getName()+"<br>"
										+ "4.Mode: "+sessionDetails.getMode()+"<br>"
										+ "5.Date and Time:"+acceptedDate[0] +"and"+ acceptedDate[1]+""
										+ "6.Duration:"+sessionDetails.getDuration()+"<br>"
										+ "7.Cost of session"+sessionDetails.getSessionPrice()+"<br>"
										+ " <br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
								SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
								mail.start();
								
								String subject4 = "You have a session coming up!";
								String content4 = "Hello, <br><br>"
										+ "We see you have a session coming up:"
										+ "<br><br>"
										+ "<p style ='font-weight:bold'>Session with "+advDetails.getName()+"</p>"
										+ "<br>"
										+ "Date: "+acceptedDate[0]+""
										+ "<br>"
										+ "Time: "+acceptedDate[1]+"<br>"
										+ "Mode of Communication: "+sessionDetails.getMode()+""
										+ "<br>"
										+ "Duration:"+sessionDetails.getDuration()+"<br>"
										+ "<span>Simply go to your session page and press the 'Join Call' button at the time of your session and you will receive a call on your registered number with us. Make sure your wallet is recharged enough before the session for you to solve all your doubts. You can always refund any balance left later. </span><br><br>"
										+ "<span>You can <a href="+prop.getProperty("HOME_PATH_SECURED")+"/usercurrentsession?sid="+sId+">View more details</a> by logging in to your account. Have a great session!</span><br><br>"
										+ "Feel free to reach us if you have any questions!<br><br>"
										+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
												+ "<br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
									SendMail mail1 = new SendMail(subject4, content4, userName.getEmail(),prop.getProperty("MAIL_ADMIN"));
									mail1.start();
									
									String subject5 = "You have a session coming up!";
									String content5 = "Hello, <br><br>"
											+ "We see you have a session coming up:"
											+ "<br><br>"
											+ "<p style ='font-weight:bold'>Session with "+userName.getFullName()+"</p>"
											+ "<br>"
											+ "Date: "+acceptedDate[0]+""
											+ "<br>"
											+ "Time: "+acceptedDate[1]+"<br>"
											+ "Mode of Communication: "+sessionDetails.getMode()+""
											+ "<br>"
											+ "Duration:"+sessionDetails.getDuration()+"<br>"
											+ "<a href="+prop.getProperty("HOME_PATH_SECURED")+"/advisorcurrentsession?sid="+sId+">Click Here to View Session Details</a><br><br>"
											+ "Feel free to reach us if you have any questions!<br><br>"
											+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
													+ "<br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
										SendMail mail2 = new SendMail(subject5, content5, advDetails.getEmail(),prop.getProperty("MAIL_ADMIN"));
										mail2.start();
								
								
						          response.sendRedirect("usercurrentsession?sId="+sId+"&session=Success");
							}
					}else{
						//Update session status
						SessionDAO status = new SessionDAO();
						isStatusCommit =  status.UpdateStatus("SESSION ON SCHEDULE", sId);
				   		 String comment = "Your session is on schedule ";
			   				String href = "advisorcurrentsession?sId="+sId;
			   				//Notification for Admin
			   				AdvisorNotificationDAO notify = new AdvisorNotificationDAO();
			   				notify.InsertNotification(comment,String.valueOf(aid),href); 
			   				String comment1 = "User confirmed the session";
							String href1 = "adminsessionviewdetails?sid="+sId;
							AdminNotificationDAO admin = new AdminNotificationDAO();
							admin.InsertNotification(comment1, href1);
							if(isStatusCommit){
								 CreateTwiml twiml = new CreateTwiml();
								  Boolean isCreated =  twiml.CreateTwimlXML(sId);
								  if(isCreated){
										String subject = "Session had been confirmed- #"+sId+"!";
										String content = "Hello, <br><br>A session had been confirmed by the user<br><br>"
												+ "1.Session ID : "+sId+"<br>"
												+ "2.Username: "+userName.getFullName()+"<br>"
												+ "3.Advisorname:"+advDetails.getName()+"<br>"
												+ "4.Mode: "+sessionDetails.getMode()+"<br>"
												+ "5.Date and Time:"+sessionDetails.getAcceptedDate() +"and"+ sessionDetails.getAcceptedTime()+""
												+ "6.Duration:"+sessionDetails.getDuration()+"<br>"
												+ "7.Cost of session"+sessionDetails.getSessionPrice()+"<br>"
												+ " <br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
										SendMail mail = new SendMail(subject, content, prop.getProperty("MAIL_ADMIN"),prop.getProperty("MAIL_ADMIN"));
										mail.start();
										
										String subject4 = "You have a session coming up!";
										String content4 = "Hello, <br><br>"
												+ "We see you have a session coming up:"
												+ "<br><br>"
												+ "<p style ='font-weight:bold'>Session with "+advDetails.getName()+"</p>"
												+ "<br>"
												+ "Date: "+sessionDetails.getAcceptedDate()+""
												+ "<br>"
												+ "Time: "+sessionDetails.getAcceptedTime()+"<br>"
												+ "Mode of Communication: "+sessionDetails.getMode()+""
												+ "<br>"
												+ "Duration:"+sessionDetails.getDuration()+"<br>"
												+ "<span>Simply go to your session page and press the 'Join Call' button at the time of your session and you will receive a call on your registered number with us. Make sure your wallet is recharged enough before the session for you to solve all your doubts. You can always refund any balance left later. </span><br><br>"
												+ "<span>You can <a href="+prop.getProperty("HOME_PATH_SECURED")+"/usercurrentsession?sid="+sId+">View more details</a> by logging in to your account. Have a great session!</span><br><br>"
												+ "Feel free to reach us if you have any questions!<br><br>"
												+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
														+ "<br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
											SendMail mail1 = new SendMail(subject4, content4, userName.getEmail(),prop.getProperty("MAIL_ADMIN"));
											mail1.start();
										
											String subject5 = "You have a session coming up!";
											String content5 = "Hello, <br><br>"
													+ "We see you have a session coming up:"
													+ "<br><br>"
													+ "<p style ='font-weight:bold'>Session with "+userName.getFullName()+"</p>"
													+ "<br>"
													+ "Date: "+sessionDetails.getAcceptedDate()+""
													+ "<br>"
													+ "Time: "+sessionDetails.getAcceptedTime()+"<br>"
													+ "Mode of Communication: "+sessionDetails.getMode()+""
													+ "<br>"
													+ "Duration:"+sessionDetails.getDuration()+"<br>"
													+ "<a href="+prop.getProperty("HOME_PATH_SECURED")+"/advisorcurrentsession?sid="+sId+">Click Here to View Session Details</a><br><br>"
													+ "Feel free to reach us if you have any questions!<br><br>"
													+ "<span style='text-decoration:underline; font-weight:bold'>Team Advisor Circuit</span>"
															+ "<br><img src=\"https://www.advisorcircuit.com/ACircuit/assets/img/logo_black.png\" style='float:right' width='15%'>";
												SendMail mail2 = new SendMail(subject5, content5, advDetails.getEmail(),prop.getProperty("MAIL_ADMIN"));
												mail2.start();
								          response.sendRedirect("usercurrentsession?sId="+sId+"&session=Success");
								  }

							}
					}
					

			}
			if(isError){
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/userdashboard.jsp");
		        rd.forward(request, response);
			}
			
			
		}
		  logger.info("Entered doPost method of UserMyAccountPaymentController");
	}
}
