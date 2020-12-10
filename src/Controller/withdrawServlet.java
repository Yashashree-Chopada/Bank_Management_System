package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.dao.withdrawDao;

/**
 * Servlet implementation class withdrawServlet
 */
public class withdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String acc  = request.getParameter("acc");
		String amt = request.getParameter("amt");
		int acc1 = Integer.parseInt(acc);
		
		withdrawDao dao = new withdrawDao();
		dao.transactMoney(amt, acc1);
		response.sendRedirect("success.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
