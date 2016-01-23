package ac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.dao.AdminDAO;
import ac.dao.AdvisorNotificationDAO;
import ac.dao.FeedDAO;
import ac.dto.AdvisorDTO;
import ac.dto.QuestionsDTO;
import ac.dto.UserDetailsDTO;
import ac.util.SendNotificationToAdvisor;

/**
 * Servlet implementation class AdminMyAccountQuestionsController
 */
@WebServlet("/AdminMyAccountQuestionsController")
public class AdminMyAccountQuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdminMyAccountQuestionsController.class);
   


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountQuestionsController");

		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
				String url1 = url.toString();
				request.setAttribute("url1", url1);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
		        rd.forward(request, response);
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if(isError!= null &&  !isError){
			List<QuestionsDTO> questions = new ArrayList<QuestionsDTO>();
			List<Integer> user = new ArrayList<Integer>();
			List<AdvisorDTO> advisor = new ArrayList<AdvisorDTO>();
			List<Integer> questionPostedtoAdvisors = new ArrayList<Integer>();
			AdminDAO admin = new AdminDAO();
			questions = admin.GetQuestions();
			for(QuestionsDTO ques : questions){
				user.add(ques.getUser_id());
				if(!ques.getToForum()){
					questionPostedtoAdvisors.add(ques.getQuestionId());	
				}
			}
			AdminDAO adv = new AdminDAO();
			List<QuestionsDTO> advIds = adv.GetAdvisorIds(questionPostedtoAdvisors);
			
			AdminDAO name = new AdminDAO();
			advisor = name.GetAdvisorDetails(advIds);
			
			AdminDAO userName = new AdminDAO();
			List<UserDetailsDTO>  usr= userName.GetUserDetails(questions);	
			
			request.setAttribute("questions",questions);
			request.setAttribute("advIds",advIds);
			request.setAttribute("advisor",advisor);
			request.setAttribute("usr",usr);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminquestions.jsp");
	        rd.forward(request, response);
		}
		logger.info("Entered doGet method of AdminMyAccountQuestionsController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminMyAccountQuestionsController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try{
			isAdmin = (Boolean) request.getSession().getAttribute("admin"); 
			}catch(Exception e){
				response.sendRedirect("Error");
				isError = true;
			}
		if(isAdmin == null){
			isError = true;
			response.sendRedirect("Error");
		}
		if(isError!= null &&  !isError){
			String questionId = request.getParameter("questionId");
			String action = request.getParameter("action");
			String question = request.getParameter("question");
			String category = request.getParameter("category");
			String subcategory = request.getParameter("subcategory");
			if(action.equals("approve")){
				
				AdminDAO update = new AdminDAO();
				update.UpdateQuestionStatus(questionId,"APPROVED");
				 //Adding to the feeds table
				FeedDAO feed = new FeedDAO();
				int feedId = feed.InsertFeedType("question");
				if(feedId != 0){
					//Inserting feed content
				    FeedDAO questions = new FeedDAO();
				    Boolean isCommit = questions.InsertQuestionFeed(feedId,Integer.valueOf(questionId),question,category,subcategory);
				    if(isCommit){
				    	//Getting all the advisor id's to send notifications
				   		List<Integer> list = new ArrayList<Integer>();
				    	AdminDAO ids = new AdminDAO();
				    	list = ids.GetAdvisorIds(questionId); 
				    	String comment = "New Question posted on the forum.";
						String href = "advisorquestions";
						SendNotificationToAdvisor notify = new SendNotificationToAdvisor(comment, href, list);
						notify.start();
						response.getWriter().write("true");
				    }
				}
			}else{
				AdminDAO update = new AdminDAO();
				update.UpdateQuestionStatus(questionId,"REJECTED");
		    	response.getWriter().write("true");
			}
         }
		logger.info("Entered doGet method of AdminMyAccountQuestionsController");
	}

}
