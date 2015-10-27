package ac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.dao.SessionDAO;
import ac.dto.AdvisorDTO;
import ac.util.GetRelativeImageURL;

/**
 * Servlet implementation class AdminProfileController
 */
@WebServlet("/AdminProfileController")
public class AdminProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aId = request.getParameter("a");
		SessionDAO adv = new SessionDAO();
		AdvisorDTO advisor =  adv.GetAdvisorDetails(Integer.valueOf(aId));
		request.getSession().setAttribute("email", advisor.getEmail());

		request.getSession().setAttribute("advisorId", Integer.valueOf(aId));
		response.sendRedirect("profile");
	}



}
