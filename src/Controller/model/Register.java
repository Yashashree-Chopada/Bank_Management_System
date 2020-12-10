package Controller.model;

public class Register
{
	private String uname;
	private String Password;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "Register [uname=" + uname + ", Password=" + Password + "]";
	}

}
