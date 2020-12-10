package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BankBalanceServlet
 */
public class BankBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBalanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String brname = request.getParameter("brname");
		String brcity = request.getParameter("brcity");
		
		HttpSession session = request.getSession();
			String sql = "select assets from branch where branch_name = ? and branch_city = ?";
			int Bal = 0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
				PreparedStatement pstat = con.prepareStatement(sql);
				pstat.setString(1, brname);
				pstat.setString(2, brcity);
				ResultSet rs = pstat.executeQuery();
				if (rs.next())
				{
					System.out.println("Checking.....");
					Bal = rs.getInt("assets");
					session.setAttribute("BankBalance",Bal);
					System.out.println("Balance is.."+Bal);
					response.sendRedirect("balance.jsp");
					
				}
				else
				{
					response.sendRedirect("Invalid.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
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
