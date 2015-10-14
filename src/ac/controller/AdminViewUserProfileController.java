/*************************************************************************************************
 * ********************************ADVISOR CIRCUIT*************************************************
 * ************************************************************************************************
 * @author AdvisorCircuit
 * @Date 10/12/2014
 * ************************************************************************************************/
package ac.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import ac.dao.AdminDAO;
import ac.dto.UserDetailsDTO;
import ac.util.CreateUserFormPDF;

/********************************CLASS SUMMARY*****************************************************
 * 
 * This class will get the email from the admin and get the userId from the userdetails table.
 * 
 *
 ***************************************************************************************************/
/**
 * Servlet implementation class AdminViewUserProfileController
 */
@WebServlet("/AdminViewUserProfileController")
public class AdminViewUserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(AdminViewUserProfileController.class);

	/**************************************
	 * COMMENTS*************************************************** This class
	 * will get the email from the admin and get the UserId from the userdetails
	 * table. and then fetch the user details
	 * 
	 * @return :None
	 * @param : HttpServletRequest request HttpServletResponse response
	 * 
	 *
	 ***************************************************************************************************/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("Entered doGet method of AdminViewUserProfileController");
		Boolean isAdmin = false;
		Boolean isError = false;
		try {
			isAdmin = (Boolean) request.getSession().getAttribute("admin");
		} catch (Exception e) {
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
			isError = true;
		}
		if (isAdmin == null) {
			isError = true;
			StringBuffer url =  request.getRequestURL().append('?').append(request.getQueryString());
			String url1 = url.toString();
			request.setAttribute("url1", url1);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/sessionerror.jsp");
	        rd.forward(request, response);
		}
		if (isError != null && !isError) {
			String email = request.getParameter("email");
			if (email != null) {
				UserDetailsDTO user = new UserDetailsDTO();
				AdminDAO userDetails = new AdminDAO();
				user = userDetails.GetUserDetails(email);
				if (user.getUserId() != 0 && user.getEmail() != null) {
					CreateUserFormPDF pdf = new CreateUserFormPDF();
					pdf.createPDF(response, user.getUserId(), user.getEmail(),
							user.getFullName(), user.getPhone(), 
						 user.getImage(),user.getDateOfRegistration(), user.getIsActive());

				}
			}

		}
		logger.info("Entered doGet method of AdminViewUserProfileController");
	}
}
