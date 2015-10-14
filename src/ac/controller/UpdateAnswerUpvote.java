package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.QuestionsDAO;

/**
 * Servlet implementation class UpdateAnswerUpvote
 */
@WebServlet("/UpdateAnswerUpvote")
public class UpdateAnswerUpvote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UpdateAnswerUpvote.class);
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UpdateAnswerUpvote");
		String answerId = request.getParameter("answerId");
		String aId = request.getParameter("aid");
		int userId =0;
		int advisorId= 0;
		Boolean isError = false;
		try{ 
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		//Check if the advisor who answered the question is not upvoting the answer
		if(Integer.valueOf(aId) == advisorId){
			response.getWriter().write("false");
		}else{
			int upid = 0;
			//Check if the user or advisor has already upvoted the answer
			QuestionsDAO check = new QuestionsDAO();
			if(userId != 0){
				upid = check.CheckUpvoteDetails(answerId,"USER",userId);
			}else if (advisorId !=0) {
				upid = check.CheckUpvoteDetails(answerId,"ADVISOR",advisorId);
			}
			if(upid != 0){
				response.getWriter().write("false");
			}else{
				Boolean isCommit = false;
				QuestionsDAO upvote = new QuestionsDAO();
				if(userId != 0){
					isCommit = upvote.InsertUpvoteDetails(answerId,"USER",userId);
				}else if (advisorId !=0) {
					isCommit = upvote.InsertUpvoteDetails(answerId,"ADVISOR",advisorId);
				}
				if(isCommit){
					//Updating the upvote count in the answers table
					QuestionsDAO answer = new QuestionsDAO();
					Boolean isUpdateCommit =  answer.UpdateUpvote(answerId);
					if(isUpdateCommit){
						//Getting the upvote count
						QuestionsDAO count = new QuestionsDAO();
						int upCount =  count.GetUpvoteCount(answerId);
						response.getWriter().write(String.valueOf(upCount));
					}
				}
			}
			
	
		}

		
		
		
		
		
		logger.info("Entered doPost method of UpdateAnswerUpvote");
	}

}
