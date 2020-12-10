package Controller.model;

public class Login
{
	private int u_id;
	private String Uname;
	private String Upass;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpass() {
		return Upass;
	}
	public void setUpass(String upass) {
		Upass = upass;
	}
	@Override
	public String toString() {
		return "Login [u_id=" + u_id + ", Uname=" + Uname + ", Upass=" + Upass
				+ "]";
	}
	
	
	
}
