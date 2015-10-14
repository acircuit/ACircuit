package ac.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import ac.dao.AdminDAO;
import ac.dao.AdminNotificationDAO;
import ac.dao.SessionDAO;

import com.ccavenue.security.AesCryptUtil;

/**
 * Servlet implementation class GetEncRequestForRefund
 */
@WebServlet("/GetEncRequestForRefund")
public class GetEncRequestForRefund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties prop = new Properties();
	    InputStream resourceAsStream1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("ac/resources/Path.properties");
	    prop.load(resourceAsStream1);
	     String tranId = request.getParameter("tranId");
	     String amount = request.getParameter("amount");
	     String uid = request.getParameter("uid");
	     String action = request.getParameter("action");
	     if(action.equals("user")){
	    	  SessionDAO refund = new SessionDAO();
              Boolean isCommit = refund.InsertRefundDetails(uid,amount,tranId);
              if(isCommit){
            		String comment = "A user has asked for refund";
    				String href = "adminrefund";
    				AdminNotificationDAO admin = new AdminNotificationDAO();
    				admin.InsertNotification(comment, href);
    				response.getWriter().write("true");
              }else{
            	  response.getWriter().write("false");
              }
	     }else if (action.equals("admin")) {
	    	 String refundId = request.getParameter("refundId");
	    	 String workingKey = prop.getProperty("WORKING_KEY");	
			 String accessCode = prop.getProperty("ACCESS_CODE");
			 Enumeration enumeration=request.getParameterNames();
			 String ccaRequest=tranId+"|"+amount+"|REF"+tranId+"|";
			 AesCryptUtil aesUtil=new AesCryptUtil(workingKey);
			 String encRequest = aesUtil.encrypt(ccaRequest);
			 HttpClient httpClient = new DefaultHttpClient();
		        HttpPost httpPost = new HttpPost("https://login.ccavenue.com/apis/servlet/DoWebTrans");
		        // Request parameters and other properties.
		        List<NameValuePair> params = new ArrayList<NameValuePair>();
		        params.add(new BasicNameValuePair("enc_request", encRequest));
		        params.add(new BasicNameValuePair("access_code", accessCode));
		        params.add(new BasicNameValuePair("command", "refundOrder"));
		        params.add(new BasicNameValuePair("request_type", "STRING"));
		        params.add(new BasicNameValuePair("version", "1.1"));
		        try {
		            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		        } catch (UnsupportedEncodingException e) {
		            // writing error to Log
		            e.printStackTrace();
		        }
		        /*
		         * Execute the HTTP Request
		         */
		        try {
		            HttpResponse response1 = httpClient.execute(httpPost);
		            HttpEntity respEntity = response1.getEntity();

		            if (respEntity != null) {
		                // EntityUtils to get the response content
		                String content =  EntityUtils.toString(respEntity);
		                String[] refundResponse = content.split("&");
		                String[] status= refundResponse[0].split("=");
		                String[] encResponse= refundResponse[1].split("=");
		                AdminDAO refund = new AdminDAO();
		                Boolean isCommit = refund.UpdateRefundDetails(status[1],encResponse[1],refundId);
		                if(status[1].equals("0") && isCommit){
		                	//The refund process is successfull
		                	//Update refund table
		                	 SessionDAO updateWallet = new SessionDAO();
				   	    	 Boolean isUpdated =  updateWallet.UpdateWallet(uid, amount);
				   	    	 if(isUpdated){
				   	    		 response.getWriter().write("true");
				   	    	 }
		                }else{
		                	if(isCommit){
		                		response.getWriter().write("false");
		                	}
		                	
		                }
		               
		            }
		        } catch (ClientProtocolException e) {
		            // writing exception to log
		            e.printStackTrace();
		        } catch (IOException e) {
		            // writing exception to log
		            e.printStackTrace();
		        }
		}

	    	
		}

}
