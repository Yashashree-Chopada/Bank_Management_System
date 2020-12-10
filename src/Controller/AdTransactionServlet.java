package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.dao.AdTransactionDao;
import Controller.model.Transaction;

/**
 * Servlet implementation class AdTransactionServlet
 */
public class AdTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		String Adname = (String)session.getAttribute("Username");
		System.out.println(Adname);*/
		AdTransactionDao dao = new AdTransactionDao();
		
		{
			System.out.println("All Transaction details passed:: ");
			List<Transaction> tlist= dao.getAllTrans();
			//out.print(tlist);
			//session.setAttribute("tlist", tlist);
			request.setAttribute("tlist", tlist);
			request.getRequestDispatcher("/Transaction.jsp").forward(request, response); 
			//response.sendRedirect("Cust_transaction.jsp");
		}
		
		
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
