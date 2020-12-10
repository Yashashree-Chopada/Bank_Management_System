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

import Controller.dao.SendMoneyDao;
import Controller.dao.SendMoneyDao1;
import Controller.dao.Transactiondao;
import Controller.model.Transaction;

/**
 * Servlet implementation class SendMoneyServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc = request.getParameter("acc");
		
		int acc1 = Integer.parseInt(acc);
		System.out.println("sender account number is:"+acc1);
		PrintWriter out = response.getWriter();
		SendMoneyDao1 dao = new SendMoneyDao1();
		Cookie cookies[] = request.getCookies();
		//String name = null;
		boolean test = false;
	/*	for(Cookie c : cookies){
			if(c.getName().equals("Name")){
				name = c.getValue();
				System.out.println("name from check Servlet "+name);
			}
			break;
		}*/
		HttpSession session = request.getSession();
	String name  =	(String)session.getAttribute("name");
		System.out.println("name from check Servlet "+name);
		
		int account_number = dao.getAccNumber(name);
		System.out.println("name releated account_number"+account_number);
		if(dao.check(acc1,account_number) == acc1)
		{
			test = true;
			System.out.println("Send Money Acc passed succesfully!!");
			request.setAttribute("acc", acc1);
			request.setAttribute("account_number", account_number);
			request.setAttribute("test", test);
			request.getRequestDispatcher("/SendMoney.jsp").forward(request, response);
		}
		else
		{
//			test = false;
			System.out.println("Check servlet else cond");
			response.sendRedirect("send_invalid.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
