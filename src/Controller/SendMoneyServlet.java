package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.dao.SendMoneyDao1;

/**
 * Servlet implementation class SendMoneyServlet
 */
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amt = request.getParameter("amt");
		String acc = request.getParameter("acc1");
		String actype_re = request.getParameter("acctype_re");
		System.out.println("Account type of receiver is - "+actype_re);
		//int acc1 = Integer.parseInt(acc);
		SendMoneyDao1 dao = new SendMoneyDao1();
	/*	Cookie cookies[] = request.getCookies();
		String name = null;
		for(Cookie c : cookies){
			if(c.getName().equals("Name")){
				name = c.getValue();
			}
			break;
		}*/
		HttpSession session = request.getSession();
		session.setAttribute("amount_transfer", amt);
		session.setAttribute("receviver_num", acc);
		session.setAttribute("rec_acctype", actype_re);
		System.out.println("Receriver acc type from sendmoney servlet - "+actype_re);
		System.out.println("Checking set atrribuitr from sendmonru"+acc);
		
		String name  =	(String)session.getAttribute("name");
		System.out.println("name from check Servlet "+name);
		int account_number = dao.getAccNumber(name);
		System.out.println(amt + "" + acc+ "" + name);
		dao.transactMoney(amt, acc, account_number);
		response.sendRedirect("recepit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
