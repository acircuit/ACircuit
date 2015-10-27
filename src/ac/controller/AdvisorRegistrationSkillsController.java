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

import ac.dao.AdminNotificationDAO;
import ac.dao.RegistrationDAO;
import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.dto.CategoryDTO;

/**
 * Servlet implementation class AdvisorRegistrationSkillsController
 */
@WebServlet("/AdvisorRegistrationSkillsController")
public class AdvisorRegistrationSkillsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdvisorRegistrationSkillsController.class);    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doPost method of AdvisorRegistrationSkillsController");
		int advisorId = 0;
		Boolean isError = false;
		String email = "";
		String[] mbaindiaskills = null;
		String[] engineeringskills = null;
		String[] mbaabroadskills = null;
		String[] mastersindiaskills = null;
		String[] mastersabroadskills = null;
		String[] industryskills  = null;
		String[] startupskills  = null;
		Boolean isIndustry = false;
		try{
			advisorId = (int) request.getSession().getAttribute("advisorId");
			 email = (String) request.getSession().getAttribute("email");
		}catch(Exception e){
			isError = true;
		}
		if(advisorId != 0){
			String modephone = request.getParameter("modephone");
			String modevideo = request.getParameter("modevideo");
			String[] category = request.getParameterValues("category[]"); 
			String[] subcategory = request.getParameterValues("subcategory[]");
			String edit = request.getParameter("edit");
				for (int i = 0; i < subcategory.length; i++) {
					if(subcategory[i].equals("MBA India")){
						mbaindiaskills = request.getParameterValues("mbaindia"+i+"[]"); 
	
					}else if (subcategory[i].equals("Engineering")) {
						engineeringskills = request.getParameterValues("engineering"+i+"[]"); 
						
					}else if (subcategory[i].equals("MBA Abroad")) {
						mbaabroadskills = request.getParameterValues("mbaabroad"+i+"[]"); 
					}else if (subcategory[i].equals("Masters India")) {
						mastersindiaskills = request.getParameterValues("mastersindia"+i+"[]"); 
					}else if (subcategory[i].equals("Masters Abroad")) {
						mastersabroadskills = request.getParameterValues("mastersabroad"+i+"[]"); 
					}else if (subcategory[i].equals("industry")) {
						industryskills = request.getParameterValues("industry"+i+"[]"); 
						isIndustry = true;
					}else if (subcategory[i].equals("startup")) {
						startupskills = request.getParameterValues("startup"+i+"[]"); 
					}
				}
           
				//Updating the modes of the advisor
				RegistrationDAO modes = new RegistrationDAO();
				Boolean isCommit =  modes.UpdateModes(advisorId,modephone,modevideo);
				if(isCommit){
					//Getting the sub cat ids
					List<Integer> list = new ArrayList<Integer>();
					RegistrationDAO subcat = new RegistrationDAO();
					list = subcat.GetSubCategoryId(advisorId);
					Boolean isSkillDeleted = true;
					if(list.size() > 0){
						//Deleting category, subcategory and skills of the advisor
						//Deleting category
						RegistrationDAO cat = new RegistrationDAO();
						Boolean isDelete =  cat.DeleteCategory(advisorId);
						if(isDelete){
							//Delete Sub Category
							RegistrationDAO sub = new RegistrationDAO();
							Boolean isDeleted =  sub.DeleteSubCategory(advisorId);
							if(isDeleted){
								//Deleting skills
								RegistrationDAO skill = new RegistrationDAO();
								isSkillDeleted =  skill.DeleteSkills(list);
							}
						}
					}
					if(isSkillDeleted){
						//Entering category
						List<CategoryDTO> cats =new ArrayList<CategoryDTO>();
						RegistrationDAO cat = new RegistrationDAO();
						cats=  cat.InsertAdvisorCategory(category,advisorId);
						if(cats.size() > 0){
							String industry = "";
							if(isIndustry){
								RegistrationDAO indus = new RegistrationDAO();
								industry = indus.GetAdvisorIndustry(advisorId);
							}
							int i =0;
							for (CategoryDTO categoryDTO : cats) {
								if(subcategory[i].equals("industry")){
									categoryDTO.setSubcategory(industry);
								}else{
									categoryDTO.setSubcategory(subcategory[i]);
								}
								
								i++;
							}
							//inserting sub category
							List<Integer> id = new ArrayList<Integer>();
							RegistrationDAO sub = new RegistrationDAO();
							cats = sub.InsertAdvisorSubCategory(cats,advisorId);
							
							List<CategoryDTO> skill = new ArrayList<CategoryDTO>();
							for (CategoryDTO categoryDTO : cats) {
								if(categoryDTO.getSubcategory().equals("MBA India")){
									categoryDTO.setSkills(mbaindiaskills);
								}else if (categoryDTO.getSubcategory().equals("Engineering")) {
									categoryDTO.setSkills(engineeringskills);
								}else if (categoryDTO.getSubcategory().equals("MBA Abroad")) {
									categoryDTO.setSkills(mbaabroadskills);
								}else if (categoryDTO.getSubcategory().equals("Masters India")) {
									categoryDTO.setSkills(mastersindiaskills);
								}else if (categoryDTO.getSubcategory().equals("Masters Abroad")) {
									categoryDTO.setSkills(mastersabroadskills);
								}else if (categoryDTO.getSubcategory().equals("startup")) {
									categoryDTO.setSkills(startupskills);
								}else{
									categoryDTO.setSkills(industryskills);
								}
							}
							//Inserting Advisor Skills
							RegistrationDAO skills  =  new RegistrationDAO();
							Boolean isSkillsCommit =  skills.SetAdvisorSkills(cats);
							if(isSkillsCommit){
								if(edit != null && edit.equals("true")){
									response.sendRedirect("profile");
								}else{
									String status = "Complete";
									//Change the Registration Status in advisorregistrationprofiledetails table
									RegistrationDAO dao1 = new RegistrationDAO();	
									Boolean isRegistrationStatusCommit = dao1.setRegistrationStatus(advisorId, status);
									if(isRegistrationStatusCommit){
										
										SessionDAO adv = new SessionDAO();
										AdvisorDTO advisor =  adv.GetAdvisorDetails(advisorId);
										String comment = advisor.getName()+" has completed his profile";
				    					String href = "adminadvisor";
				    					AdminNotificationDAO notify = new AdminNotificationDAO();
				    					notify.InsertNotification(comment, href);
										response.sendRedirect("profile?action=create");
									}
								}
								
							}
						}
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
		logger.info("Entered doPost method of AdvisorRegistrationSkillsController");
	}

}
