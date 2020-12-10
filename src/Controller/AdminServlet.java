package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.dao.Logindao;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phn = request.getParameter("phn");
		String pass1 = request.getParameter("psw");
		
		Logindao dao = new Logindao();
		if(dao.check_admin(phn, pass1))
		{
			HttpSession session = request.getSession();
			session.setAttribute("Admin_phone",phn);
			System.out.println("Admin phone number"+phn);
			response.sendRedirect("MainBank.html");
		}
		else
		{
			response.sendRedirect("Invalid_ad.jsp");
		}
		
		
	}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
