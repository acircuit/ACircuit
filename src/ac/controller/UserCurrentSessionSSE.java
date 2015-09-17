package ac.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class UserCurrentSessionSSE
 */
@WebServlet("/UserCurrentSessionSSE")
public class UserCurrentSessionSSE extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(UserCurrentSessionSSE.class);         

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserCurrentSessionSSE");
		int userId = 0;
		String userPhone="";
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
	        response.setContentType("text/event-stream");
	        response.setCharacterEncoding("UTF-8");
	        response.setHeader("Connection", "keep-alive");
	        response.setHeader("cache-control", "no-cache"); 
	        PrintWriter writer = response.getWriter();
            
	        
	        writer.write("event:notify\n");
	       // writer.write("data: " + data + "\n\n");
	        try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}

		
		
		logger.info("Entered doGet method of UserCurrentSessionSSE");
	}

}
