package Controller.model;

public class Transaction 
{
		private String t_id;
		private String from_acc;
		private String to_acc;
		private int amt;
		
		public Transaction(String t_id, String from_acc, String to_acc, int amt) {
			this.t_id = t_id;
			this.from_acc = from_acc;
			this.to_acc = to_acc;
			this.amt = amt;
		}
		public Transaction() {
			// TODO Auto-generated constructor stub
		}
		public String getT_id() {
			return t_id;
		}
		public void setT_id(String t_id) {
			this.t_id = t_id;
		}
		public String getFrom_acc() {
			return from_acc;
		}
		public void setFrom_acc(String from_acc) {
			this.from_acc = from_acc;
		}
		public String getTo_acc() {
			return to_acc;
		}
		public void setTo_acc(String to_acc) {
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
			return "Transaction [t_id=" + t_id + ", from_acc=" + from_acc
					+ ", to_acc=" + to_acc + "amt=" + amt + "]";
		}
		
		
}
