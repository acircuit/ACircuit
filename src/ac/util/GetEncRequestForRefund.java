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
	     String tranId = request.getParameter("id");
	     String amount = request.getParameter("amount");
	     String update = request.getParameter("action");
	     String uid = request.getParameter("uid");
	     if(update != null && uid != null){
	    	 
	    	 SessionDAO updateWallet = new SessionDAO();
	    	 updateWallet.UpdateWallet(uid, amount);
	     }else{
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
		                System.out.println(content);
		            }
		        } catch (ClientProtocolException e) {
		            // writing exception to log
		            e.printStackTrace();
		        } catch (IOException e) {
		            // writing exception to log
		            e.printStackTrace();
		        }
			 
			 
			 
			 
			 response.getWriter().write(encRequest+":"+accessCode);
	     }
	    
		
	}

}
