import  javax.swing.*;

import  java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
public class MyFrame extends JFrame{
	public HashMap<String, JTextArea> jTextAreas = new HashMap<String, JTextArea>();
	public JTextArea myTextArea; 
	private User user;
	private int numUsers;
	private int largeurFrame;
	private ArrayList<String> names = new ArrayList<String>();
	
			MyFrame(String m, ArrayList<String> namesUser){
				this.names.addAll(namesUser);
				names.remove(m);
				this.user = new User(m,this, names);
				user.receiver.start();
		  		// arg numusers;
				numUsers = names.size();
				System.out.println(numUsers);
				largeurFrame = 1000;
				JFrame f = new JFrame(m);
				f.setBounds(100, 100, largeurFrame, 550);
	        	f.getContentPane().setLayout(null);
	        	Iterator<String> iter = names.iterator();
	        	int largeurText = largeurFrame / numUsers - 22;
	        	int i = 0;
	        	while (iter.hasNext()) {
	        		JTextArea jt = new JTextArea();
	        		JScrollPane s = new JScrollPane(jt);
	        		s.setBounds(11 + i + i * largeurText, 11, largeurText, 200);
	        		i++ ;
	        		f.getContentPane().add(s);
	        		jt.setEditable(false);
	        		jTextAreas.put(iter.next(),jt);
	        	}
	        
				myTextArea = new JTextArea();
				
				JScrollPane myScrollPane = new JScrollPane(myTextArea);
				myScrollPane.setBounds(largeurFrame / 2 - 200, 250, 400, 200);
				f.getContentPane().add(myScrollPane);
				f.show();
				myTextArea.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
					  JTextArea textArea = (JTextArea) e.getSource();
					  String text = textArea.getText();
					  user.sender.send(user.name + ' ' + text);
					}
					public void keyTyped(KeyEvent e) {
					}
			  
					public void keyPressed(KeyEvent e) {
					}
				  });
	
			  }
		}
