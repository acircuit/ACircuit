package ac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.PaymentDAO;
import ac.dao.SessionDAO;

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
					          response.sendRedirect("usercurrentsession?sId="+sId+"&session="+order_status);
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
				System.out.println(date);
				Boolean isWalletUpdated =false;
				Boolean isStatusCommit =false;

				String amount = request.getParameter("amount");
				String sId = request.getParameter("sid");
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
					
				if(isStatusCommit){
			          response.sendRedirect("usercurrentsession?sId="+sId+"&session=Success");
				}
			}
			if(isError){
				response.sendRedirect("error");
			}
			
			
		}
		  logger.info("Entered doPost method of UserMyAccountPaymentController");
	}
}
