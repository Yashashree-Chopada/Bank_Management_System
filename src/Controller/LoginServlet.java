package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import Controller.dao.Logindao;
import Controller.dao.ProfileDao;
import Controller.model.Login;

import com.mysql.jdbc.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside servlet");
		// PrintWriter out = response.getWriter();
		String uname1 = request.getParameter("uname");
		String pass1 = request.getParameter("psw");
		String accnum = request.getParameter("accnum1");
		String phnno = request.getParameter("phnno");
		System.out.println("Login servlte recived data - ");
		System.out.println("username - "+uname1+"pass - "+pass1+"accnum - "+accnum+" phno -"+phnno);
		
		HttpSession session = request.getSession();
		session.setAttribute("name",uname1);
		session.setAttribute("Accountnum", accnum);
		session.setAttribute("phone_num", phnno);
		session.setAttribute("pass_se", pass1);

	/*	Cookie cookies = new Cookie("Name", uname1);
		response.addCookie(cookies);*/

		Logindao dao = new Logindao();

		if (dao.check(phnno, pass1)) {

			response.sendRedirect("welcome.jsp");
		} else {
			
			response.sendRedirect("Cust_Invalid.jsp");
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
