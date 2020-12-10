package Controller.model;

public class transaction2 {

	int T_id; 
	String Cutomer_name;
	int from_acc;
	int to_acc;
	int amt;
	public int getT_id() {
		return T_id;
	}
	public void setT_id(int t_id) {
		T_id = t_id;
	}
	public String getCutomer_name() {
		return Cutomer_name;
	}
	public void setCutomer_name(String cutomer_name) {
		Cutomer_name = cutomer_name;
	}
	public int getFrom_acc() {
		return from_acc;
	}
	public void setFrom_acc(int from_acc) {
		this.from_acc = from_acc;
	}
	public int getTo_acc() {
		return to_acc;
	}
	public void setTo_acc(int to_acc) {
		this.to_acc = to_acc;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "transaction2 [T_id=" + T_id + ", Cutomer_name=" + Cutomer_name
				+ ", from_acc=" + from_acc + ", to_acc=" + to_acc + ", amt="
				+ amt + "]";
	}
	
	
}
