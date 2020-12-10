package Controller.model;

public class loan 
{
	int Loan_id;
	String Customer_name;
	int Amount;
	public int getLoan_id() {
		return Loan_id;
	}
	public void setLoan_id(int loan_id) {
		Loan_id = loan_id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "loan [Loan_id=" + Loan_id + ", Customer_name=" + Customer_name
				+ ", Amount=" + Amount + "]";
	}
	
}
