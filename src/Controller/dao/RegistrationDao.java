package Controller.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDao
{
	String sql = "Insert into customer_all(phone_num,customer_name,customer_street,customer_city,Password,account_type) values (?,?,?,?,?,?)";
	String getacc ="Insert into account_all (phone_num,customer_name,account_number,acc_type,balance) values (?,?,?,?,?)";
	String getMax = "select max(account_number) from account_all";
	int Newacc = 0;
	public boolean Insert(String phone_num ,String uname , String c_street,String c_city , String pass , String newBal, String acctype)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system","root","root");
			PreparedStatement pstat2 = con.prepareStatement(getMax);
			ResultSet rs = pstat2.executeQuery();
			while (rs.next()) {
				Newacc = rs.getInt(1);
				Newacc = Newacc +1;
			}
			int newbal = Integer.parseInt(newBal);
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, phone_num);
			pstat.setString(2, uname);
			pstat.setString(3, c_street);
			pstat.setString(4, c_city);
			pstat.setString(5, pass);
			pstat.setString(6,acctype);
			pstat.executeUpdate();
			PreparedStatement pstat1 = con.prepareStatement(getacc);
			pstat1.setString(1, phone_num);
			pstat1.setString(2,uname);
			pstat1.setInt(3,Newacc);
			pstat1.setString(4, acctype);
			pstat1.setInt(5,newbal);
			pstat1.executeUpdate();
			System.out.println("All tables updated successfully");
			
			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
}