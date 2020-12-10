package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Controller.model.loan;

public class AdLoan
{
	public List getLoanDetails(String uname)
	{
		List loanList = new ArrayList<>();
		String getloan = "select * from loan";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
	
		PreparedStatement pstat1 = con.prepareStatement(getloan);
		//pstat1.setString(1,uname);
		ResultSet rs = pstat1.executeQuery();
		while(rs.next())
		{
			loanList.add(rs.getString("Loan_id"));
			loanList.add(rs.getString("Customer_name"));
			loanList.add(rs.getString("Amount"));
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loanList;
	}
}



