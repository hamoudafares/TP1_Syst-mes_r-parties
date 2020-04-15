
public class User {
	public String name;
	public Send sender ; 
	public Receive receiver ; 
	
	public User(String m, MyFrame f) {
		this.name=m;
		this.sender = new Send(m);
		this.receiver = new Receive(m, f);
	}
	
}
