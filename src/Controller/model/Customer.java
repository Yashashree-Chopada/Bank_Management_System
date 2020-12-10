package Controller.model;

public class Customer
{
	String Customer_name;
	String Customer_Street;
	String Customer_city;
	String Password;
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getCustomer_Street() {
		return Customer_Street;
	}
	public void setCustomer_Street(String customer_Street) {
		Customer_Street = customer_Street;
	}
	public String getCustomer_city() {
		return Customer_city;
	}
	public void setCustomer_city(String customer_city) {
		Customer_city = customer_city;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Customer [Customer_name=" + Customer_name
				+ ", Customer_Street=" + Customer_Street + ", Customer_city="
				+ Customer_city + ", Password=" + Password + "]";
	}
	
}
