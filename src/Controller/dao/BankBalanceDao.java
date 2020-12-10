package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankBalanceDao
{
	public void check(String branch, String city) {
		String sql = "select assets from branch where branch_name = ? and branch_city = ?";
		int Balance;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, branch);
			pstat.setString(2, city);
			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				Balance = rs.getInt(3);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

