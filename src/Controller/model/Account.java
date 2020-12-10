package Controller.model;

public class Account
{
	private String customer_name;
	private int account_number;
	private int balance;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [customer_name=" + customer_name + ", account_number="
				+ account_number + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
	
}
