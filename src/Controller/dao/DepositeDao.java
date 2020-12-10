package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositeDao 
{
	public void transactMoney(String amt, int acc) 
	{
		String sql = "select balance from account_all where account_number = ?";
		String money = "update account_all set balance = ? where account_number = ?";
		String tran = "Insert into transaction (T_id,From_acc,To_acc,Amount) values (?,?,?,?)";
		String getMax = "select max(T_id) from transaction";
		int T_idMAX = 0;
		int balance = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System", "root", "root");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setInt(1, acc);
			//pstat.setString(2,uname);
			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				balance = rs.getInt("balance");
			}
			System.out.println("balance of "+"is"+balance);
			
			int newamt = balance + Integer.parseInt(amt);
			System.out.println("balance after Deposite is "+newamt);
			pstat = con.prepareStatement(money);
			pstat.setInt(1, newamt);
			pstat.setInt(2, acc);
			pstat.executeUpdate();
			
			
			
			PreparedStatement pstat1 = con.prepareStatement(getMax);
			ResultSet rs1 = pstat1.executeQuery();
			while (rs1.next()) {
				T_idMAX = rs1.getInt(1);
				T_idMAX = T_idMAX +1;
			}
			System.out.println(T_idMAX+"MAx T_id");
			int w = 0;
			PreparedStatement pstat11 = con.prepareStatement(tran);
			pstat11.setInt(1, T_idMAX);
			pstat11.setInt(2, w);
			pstat11.setInt(3, acc);
			pstat11.setString(4, amt);
			pstat11.executeUpdate();
			System.out.println("Susccess fully inserted details...in transaction table after deposite money");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
}
