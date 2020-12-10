package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Controller.model.Transaction;

public class Transactiondao
{
	String name = null;
	String sql = "select * from transaction where From_acc = ?";
	String sql1 = "select *from account_all where account_number =? and phone_num = ?";
	public boolean check(String acc , String phnno)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			PreparedStatement pstat = con.prepareStatement(sql1);
			pstat.setString(1, acc);
			pstat.setString(2,phnno);
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
	public List<Transaction> getAllTrans(String acc) {
		List tlist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, acc);
		ResultSet rs = pstat.executeQuery();
		while(rs.next())
		{
			Transaction trans = new Transaction();
			trans.setT_id(rs.getString("T_id"));
			trans.setFrom_acc(rs.getString("From_acc"));
			trans.setTo_acc(rs.getString("To_acc"));
			trans.setAmt(rs.getInt("Amount"));
			tlist.add(trans);
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return tlist;
	}
}
