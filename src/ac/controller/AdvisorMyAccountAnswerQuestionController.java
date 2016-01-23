package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminNotificationDAO;
import ac.dao.FeedDAO;
import ac.dao.QuestionsDAO;
import ac.dao.SessionDAO;
import ac.dao.UserNotificationDAO;
import ac.dto.AdvisorDTO;
import ac.dto.QuestionsDTO;

/**
 * Servlet implementation class AdvisorMyAccountAnswerQuestionController
 */
@WebServlet("/AdvisorMyAccountAnswerQuestionController")
public class AdvisorMyAccountAnswerQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdvisorMyAccountAnswerQuestionController.class);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdvisorMyAccountAnswerQuestionController");
		int advisorId = 0;
		Boolean isError = false;
	     String qid = request.getParameter("qid");
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
		     String answer = request.getParameter("answer");
		     String aid = request.getParameter("aid");
		     QuestionsDAO answers = new QuestionsDAO();
		     answer = answer.replaceAll("\r\n", "");
		     answer = answer.replaceAll("\r", "");
		     answer = answer.replaceAll("\n", "");
		     int aId = answers.SubmitAnswer(qid,aid,answer);
		     //Marking the question as answered and incrementing the count
		     QuestionsDAO question = new QuestionsDAO();
		     Boolean isCommit = question.UpdateDetails(qid);
		     if(isCommit){
		    	 QuestionsDAO user = new QuestionsDAO();
		    	 int uid = user.GetUserId(qid);
		    	 String comment = "Your question has been answered";
					String href = "answers?q="+qid;
					//Notification for user
					UserNotificationDAO notify = new UserNotificationDAO();
					Boolean isNotificationCommit =  notify.InsertNotification(comment,href,String.valueOf(uid)); 
					
					SessionDAO session = new SessionDAO();
					String name = session.GetAdvisorName(advisorId);
					String comment1 = name+" answered a question";
					String href1 = "answers?q="+qid;
					AdminNotificationDAO admin = new AdminNotificationDAO();
					admin.InsertNotification(comment1, href1);
					if(isNotificationCommit){
						 //Adding to the feeds table
						FeedDAO feed = new FeedDAO();
						int feedId = feed.InsertFeedType("answer");
						if(feedId != 0){
							
							//Getting question details
							FeedDAO questions = new FeedDAO();
							QuestionsDTO ques = questions.GetQuestionDetails(qid);

							//Getting question details
							SessionDAO advisor = new SessionDAO();
							AdvisorDTO adv = advisor.GetAdvisorDetails(Integer.valueOf(aid));
							
							//Inserting feed content
						    FeedDAO answerfeed = new FeedDAO();
						    Boolean isCommit1 = answerfeed.InsertAnswerFeed(feedId,ques,adv,answer);
						    if(isCommit1){
						    	response.getWriter().write("true");
						    }
						}
					}
                  response.sendRedirect("answers?q="+qid);
		     }
		}
		if(isError){
			response.sendRedirect("answers?q="+qid);
		}
		logger.info("Entered doGet method of AdvisorMyAccountAnswerQuestionController");
	}

}
