package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.model.Transaction;

public class AdTransactionDao 
{
	String sql = "select * from transaction";
	public List<Transaction> getAllTrans() {
		List tlist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
		PreparedStatement pstat = con.prepareStatement(sql);
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


