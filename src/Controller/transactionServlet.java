package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.dao.Transactiondao;
import Controller.model.Transaction;

/**
 * Servlet implementation class transactionServlet
 */
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acc = request.getParameter("acc");
		PrintWriter out = response.getWriter();
		Transactiondao dao = new Transactiondao();
		HttpSession session = request.getSession();
		String name =(String) session.getAttribute("name");
		String phno = (String)session.getAttribute("phone_num");
		System.out.println(name+"From transaction1");
		
		
		if(dao.check(acc , phno) == true)
		{
			System.out.println("Acc passed succesfully!!");
			List<Transaction> tlist= dao.getAllTrans(acc);
			//out.print(tlist);
			//session.setAttribute("tlist", tlist);
			request.setAttribute("tlist", tlist);
			request.getRequestDispatcher("/Cust_transaction.jsp").forward(request, response); 
			//response.sendRedirect("Cust_transaction.jsp");
		}
		else
		{
			response.sendRedirect("Invalid.html");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
