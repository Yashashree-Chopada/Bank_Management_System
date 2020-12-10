package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Controller.dao.Accountdao;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		/*String uname1 = request.getParameter("uname");*/
		Cookie cookies[] = request.getCookies();
		String name = null;
		for(Cookie c : cookies)
		{
			if(c.getName().equals("Name"));
			{
				name = c.getValue();
				
			}
			break;
		}
		System.out.println("From account.."+name);
		String acc = request.getParameter("acc");
		session.setAttribute("Accountnumber", acc);
		String sql = "select balance from account where customer_name =? and account_number = ?";
		PrintWriter out = response.getWriter();
		Cookie cookies1 = new Cookie("Account",acc);
		response.addCookie(cookies1);
		//out.print("<html><body>");
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1,name);
			pstat.setString(2,acc);
			ResultSet rs = pstat.executeQuery();
			System.out.println("Outside if");
		
			while(rs.next())
			{
				System.out.println("Inside If from AccountServlet");
				int s = (rs.getInt(3));
				System.out.println("balance from servlet"+s);
				session.setAttribute("Balance1",s);
				System.out.println("Balance is from servlet "+s);
				response.sendRedirect("Cust_balance.jsp");
			}
			
			
		}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
