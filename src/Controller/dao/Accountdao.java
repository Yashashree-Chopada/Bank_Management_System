package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class Accountdao 
{
	private int balance =0;
	String sql = "select balance from account where customer_name = ? and account_number = ?";
	//HttpSession session = request.getSession();
	//String uname1 =(String)session.getAttribute("Username"); 
	public boolean check(String uname , String acc)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, uname);
			pstat.setString(2, acc);
			ResultSet rs = pstat.executeQuery();
			if(rs.next())
			{
				//rs.getInt("balance");
				balance = rs.getInt("balance");
				Cookie cookie = new Cookie("balance",balance +"");
				
				System.out.println("Success!!");
				System.out.println(balance+"Balance is");
				return true;
				
			}
			else
			{
				 
				System.out.println("Invalid");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
}
