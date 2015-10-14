package ac.controller;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.dto.PromotionsDTO;
import ac.jdbc.ConnectionFactory;

/**
 * Servlet implementation class RaptorController
 */
@WebServlet("/RaptorController")
public class RaptorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RaptorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		String data = request.getParameter("data");
/*		StringBuffer sb=new StringBuffer();
		 sb.append("<pre>"+data+"</pre>");
		 data=data.toString();
		 System.out.println(data);*/
		List<String> list = new ArrayList<String>();
 	try {
 		conn = ConnectionFactory.getConnection();
		conn.setAutoCommit(false);
 		String query = "insert into data"
				+ "(data) values"
				+ "(?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, data);
		int result = pstmt.executeUpdate();
		if (result > 0) {
			conn.commit();
			conn.close();
System.out.println(true);
		}else{
			System.out.println(false);	
		}
		conn = ConnectionFactory.getConnection();
		conn.setAutoCommit(false);
			String query1 ="SELECT * FROM data";
			PreparedStatement pstmt1 = conn.prepareStatement(query1);
			ResultSet results = pstmt1.executeQuery();
			while(results.next()){
				list.add(results.getString("data"));
            }
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

		}
	
	request.setAttribute("list", list);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/raptor.jsp");
    rd.forward(request, response);
	}
}
