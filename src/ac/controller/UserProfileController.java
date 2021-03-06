package ac.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ac.cache.MyCacheBuilder;
import ac.dao.QuestionsDAO;
import ac.dao.RegistrationDAO;
import ac.dao.SessionDAO;
import ac.dto.UserDetailsDTO;
import ac.util.GetRelativeImageURL;
import ac.util.SetFormImage;

/**
 * Servlet implementation class UserProfileController
 */
@WebServlet("/UserProfileController")
@MultipartConfig
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserProfileController.class);


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of UserProfileController");
		int userId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		//Getting the sessiondetails for the user
		if(userId != 0){
			 SessionDAO user = new SessionDAO();
			 UserDetailsDTO userDetails = user.GetUserDetails(userId);
			 GetRelativeImageURL images = new GetRelativeImageURL();
			 userDetails.setImage(images.getImageURL(userDetails.getImage()));
			 
			 
				//Getting Popular categories
				QuestionsDAO cats = new QuestionsDAO();
				List<String> popCats = cats.GetPopularCategories();
				
				//Getting the sub categories
				MyCacheBuilder higher = MyCacheBuilder.getCacheBuilder();
				List<String> higherStudiesSubCategory = higher.getHigherStudiesSubCategory();
				
				MyCacheBuilder industry = MyCacheBuilder.getCacheBuilder();
				List<String> industrySubCategory = industry.getIndustrySubCategory();
				
				MyCacheBuilder option = MyCacheBuilder.getCacheBuilder();
				List<String> optionsSubCategory = option.getOpionsSubCategory();
			 
				request.setAttribute("higherStudiesSubCategory", higherStudiesSubCategory);
				request.setAttribute("industrySubCategory", industrySubCategory);
				request.setAttribute("optionsSubCategory", optionsSubCategory);
			 request.setAttribute("userDetails", userDetails);
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/usereditprofile");
	         rd.forward(request, response);	
			
			
		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		logger.info("Entered doGet method of UserProfileController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of UserProfileController");
		int userId = 0;
		String advisorPhone="";
		
		Boolean isError =false;
		try{
			userId = (int) request.getSession().getAttribute("userId");
		}catch(Exception e){
			isError = true;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Getting the sessiondetails for the user
		if(userId != 0){
			if(request.getParameter("email") != null){
				String email = request.getParameter("email");
				SetFormImage image = new SetFormImage();
				String path = image.putImage(request, response, email, "USER");
				System.out.println(path);
				RegistrationDAO userImage = new RegistrationDAO();
				Boolean isCommit =  userImage.UpdateUserImage(userId,path);
				if(isCommit){
					GetRelativeImageURL images = new GetRelativeImageURL();
					request.getSession().setAttribute("path", images.getImageURL(path));
					doGet(request, response);
				}
			}else{
				String name = request.getParameter("name");
				String male = request.getParameter("radiomale");
				String female = request.getParameter("radiofemale");
				String occupation = request.getParameter("occupation");
		        String  phone = request.getParameter("phone");
		        String gender="";
		        if(male.equals("male")){
		        	gender = "male";
		        }else{
		        	gender = "female";
		        }
		        if(name != null && occupation != null){
		        	
		        	RegistrationDAO user = new RegistrationDAO();
		        	Boolean isUpdated = user.UpdateUserProfile(name,gender,occupation,phone,userId );
		        	if(isUpdated){
		        		 request.setAttribute("profileUpdate", "true");
		    			 doGet(request, response);
		        	}
		        	
		        }else{
		        	doGet(request, response);
		        }
			}

		}
		if(isError){
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		
		
		logger.info("Entered doPost method of UserProfileController");
	}

}
