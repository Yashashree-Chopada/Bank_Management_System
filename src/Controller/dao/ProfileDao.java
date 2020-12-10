package Controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class ProfileDao
{
		String sql = "select * from customer_all where customer_name = ?";
	
		public List getAllCustomer(String uname) {
		
			List custList = new ArrayList<>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
			
			PreparedStatement pstat = con.prepareStatement(sql);
			
			pstat.setString(1, uname);
			ResultSet rs = pstat.executeQuery();
			while(rs.next())
			{
				
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
	public List getAccountDetails(String uname,String phno)
	{
		List accList = new ArrayList<>();
		System.out.println("uname"+uname+"phno"+phno);
		String getAcc = "select account_number , balance ,acc_type from account_all where customer_name = ? and phone_num = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
	
		PreparedStatement pstat1 = con.prepareStatement(getAcc);
		pstat1.setString(1,uname);//accept
		pstat1.setString(2, phno);
		ResultSet rs = pstat1.executeQuery();
		while(rs.next())
		{
			accList.add(rs.getString("account_number"));
			accList.add(rs.getString("acc_type"));
			accList.add(rs.getString("balance"));
			
		}
		
		System.out.println("Array list from profileDao is as");
		System.out.println(accList);
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accList;
	}
	public boolean checkLoan(String uname)
	{
		
		String loan = "Select * from Loan where Customer_name =? ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
	
		PreparedStatement pstat1 = con.prepareStatement(loan);
		pstat1.setString(1,uname);
		ResultSet rs = pstat1.executeQuery();
		if(rs.next())
		{
			System.out.println("The Customer have Loan");
			return true;
			
		}
		else
		{
			System.out.println("Customer dont have any loan");
			System.out.println("Invalid");
			return false;
		}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public List getLoanDetails(String uname)
	{
		List loanList = new ArrayList<>();
		String getloan = "select Loan_id , Amount from loan where customer_name = ?";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
	
		PreparedStatement pstat1 = con.prepareStatement(getloan);
		pstat1.setString(1,uname);
		ResultSet rs = pstat1.executeQuery();
		while(rs.next())
		{
			loanList.add(rs.getString("Loan_id"));
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
	public List get_Details(String name,String pass)
	{
		List get_details = new ArrayList<>();
		System.out.println("sender name "+name+" sender pass "+pass);
		String getAcc_details = "select * from customer_all where customer_name = ? and password = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
	
		PreparedStatement pstat1 = con.prepareStatement(getAcc_details);
		pstat1.setString(1,name);//accept
		pstat1.setString(2, pass);
		ResultSet rs = pstat1.executeQuery();
		while(rs.next())
		{
			get_details.add(rs.getString("customer_name"));
			get_details.add(rs.getString("customer_street"));
			get_details.add(rs.getString("customer_city"));
			
		}
		
		System.out.println("Array list from profileDao is as for sender accoutn detaisl - --- -");
		System.out.println(get_details);
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return get_details;
	}

		
	public List get_Details_re(String acc,String type)
	{
		List get_de_re = new ArrayList<>();
		System.out.println("receiver account number from get_details_re function "+acc);
		
		String sql = "select customer_name from account_all where account_number=?";
		String name = null;
		
		String get_det_re = "select * from customer_all where customer_name = ? and account_type=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_System","root","root");
		
		
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, acc);
		
		ResultSet rs1 = pstat.executeQuery();
		while(rs1.next())
		{
			name = rs1.getString("customer_name");
			
		}
		
		System.out.println("recevier cust name is "+name);
		System.out.println("Receiver acc type is "+type);
	
		PreparedStatement pstat1 = con.prepareStatement(get_det_re);
		pstat1.setString(1,name);//accept
		pstat1.setString(2,type);//accept
	ResultSet rs = pstat1.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("customer_name"));
			System.out.println(rs.getString("customer_street"));
			System.out.println(rs.getString("customer_city"));
			
			
			
			get_de_re.add(rs.getString("customer_name"));
			get_de_re.add(rs.getString("customer_street"));
			get_de_re.add(rs.getString("customer_city"));
			
		}
		
		System.out.println("Array list from profileDao is as for receiver accoutn detaisl - --- -");
		System.out.println(get_de_re);
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return get_de_re;
	}
		
	
	
		
	
		
		
}
