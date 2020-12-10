package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import javax.swing.JOptionPane;

import Controller.model.Login;

public class Logindao 
{

	
	
	String sql = "select * from customer_all where phone_num  = ? and Password = ?";
	public boolean check(String phno , String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, phno);
			pstat.setString(2, pass);
			ResultSet rs = pstat.executeQuery();
			if(rs.next())
			{
				System.out.println("Success!!");
				return true;
				
			}
			else
			{
				 
				System.out.println("Invalid");
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
		//Validate Admin
	}
		String sql1 = "select * from customer_all where phone_num  = ? and Password = ?";
		public boolean check_admin(String phno , String pass)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
				PreparedStatement pstat = con.prepareStatement(sql1);
				pstat.setString(1, phno);
				pstat.setString(2, pass);
				ResultSet rs = pstat.executeQuery();
				if(rs.next())
				{
					System.out.println("Success!!");
					return true;
					
				}
				else
				{
					 
					System.out.println("Invalid");
					return false;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return false;
		
	}
	
}
