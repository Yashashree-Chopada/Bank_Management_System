package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.dao.RegistrationDao;

/**
 * Servlet implementation class registrationServlet
 */
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String psw3;
		String phn = request.getParameter("phn");
		String uname = request.getParameter("uname");
		String c_street = request.getParameter("c_street");
		String c_city  = request.getParameter("c_city");
		String bal = request.getParameter("bal");
		RegistrationDao r = new RegistrationDao();
		String psw = request.getParameter("psw");
		String psw2 = request.getParameter("psw-repeat");
		String acctype = request.getParameter("acctype");
		
		System.out.println(""+uname+""+psw+""+psw2+" "+acctype);
		
		if(psw.equals(psw2))
		{
			System.out.println("Password match");
			r.Insert(phn,uname,c_street,c_city,psw,bal,acctype);
			response.sendRedirect("created.jsp");
			
			
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("${document}.ready{function{} {");
			out.println("swal ( 'Oops' ,'Passwords not matched' ,'error' );");
			out.println("});");
			out.println("</script>");
			
			response.sendRedirect("registration.jsp");
			

			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
