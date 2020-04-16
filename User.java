import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

public class User {
	public String name;
	public Send sender ; 
	public Receive receiver ; 
	
	public User(String m, MyFrame f, ArrayList<String> names) {
		this.name=m;
		this.sender = new Send(m, names);
		this.receiver = new Receive(m, f);
	}
	
}
