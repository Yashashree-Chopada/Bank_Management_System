package Controller.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SendMoneyDao1 {
	
	public void transaction(String amt, int account_number , String acc )
	{
		String insert = "Insert into transaction (T_id,From_acc,To_acc,Amount) values (?,?,?,?)";
		String getMax = "select max(T_id) from transaction";
		int T_idMAX = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System", "root", "root");
			PreparedStatement pstat = con.prepareStatement(getMax);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				T_idMAX = rs.getInt(1);
				T_idMAX = T_idMAX +1;
			}
			System.out.println(T_idMAX+"MAx T_id");
			PreparedStatement pstat1 = con.prepareStatement(insert);
			pstat1.setInt(1, T_idMAX);
			pstat1.setInt(2, account_number);
			pstat1.setString(3, acc);
			pstat1.setString(4, amt);
			pstat1.executeUpdate();
			System.out.println("Susccess fully inserted details...in transaction table");
			

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int getAccNumber(String name) {
		String sql = "select account_number from account_all where customer_name = ?";
		int account_number = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System", "root", "root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, name);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				return account_number = rs.getInt("account_number");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public int check(int acc1, int account_number) {
		String sql = "select account_number from account_all where account_number = ? and account_number != ?";
		int recipientAcc = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System", "root", "root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, acc1);
			pstat.setInt(2, account_number);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				return recipientAcc = rs.getInt("account_number");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void transactMoney(String amt, String acc, int account_number) {
		String sql = "select balance from account_all where account_number = ?";
		String money = "update account_all set balance = ? where account_number = ?";
		int recipientAmt = 0;
		int senderAmt = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System", "root", "root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, acc);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				recipientAmt = rs.getInt("balance");
			}
			System.out.println(recipientAmt);

			pstat = con.prepareStatement(sql);
			pstat.setInt(1, account_number);
			rs = pstat.executeQuery();
			while (rs.next()) {
				senderAmt = rs.getInt("balance");
			}
			System.out.println(senderAmt);
			
			
			int fAmt = recipientAmt + Integer.parseInt(amt);
			pstat = con.prepareStatement(money);
			pstat.setInt(1, fAmt);
			pstat.setString(2, acc);
			pstat.executeUpdate();

			fAmt = senderAmt - Integer.parseInt(amt);
			System.out.println(fAmt);
			pstat = con.prepareStatement(money);
			pstat.setInt(1, fAmt);
			pstat.setInt(2, account_number);
			pstat.executeUpdate();
			this.transaction(amt, account_number , acc);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
