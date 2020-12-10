package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendMoneyDao {
	public String getAccNumber(String name) {
		String sql = "select account_number from account where customer_name = ?";
		String account_number= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, name);
			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				return account_number = rs.getString("account_number");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String check(String acc, String account_number) {
		String sql = "select account_number from account where account_number = ? and account_number != ?";
		String recipientAcc= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, acc);
			pstat.setString(2, account_number);
			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				return recipientAcc = rs.getString("account_number");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}





