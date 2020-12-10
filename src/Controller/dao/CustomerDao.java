package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.model.Transaction;
//For Admin Show All Cutomers details:
public class CustomerDao {
	String sql = "select * from customer";
	public List getAllCustomer() {
		List custList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
		PreparedStatement pstat = con.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next())
		{
			custList.add(rs.getString("customer_name"));
			custList.add(rs.getString("customer_street"));
			custList.add(rs.getString("customer_city"));
	
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return custList;
	}
}
