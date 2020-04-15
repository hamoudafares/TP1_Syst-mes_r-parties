import  javax.swing.*;

import  java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class MyFrame extends JFrame{

	public JTextArea jt,jt_1,jt_2; 
	private User user;
	
			MyFrame(String m){
				
				this.user = new User(m,this);
				user.receiver.start();
		  		  
				JFrame f = new JFrame("Text Field Examples");
				f.setBounds(100, 100, 491, 550);
	        	f.getContentPane().setLayout(null);
				jt = new JTextArea();
				jt_1 = new JTextArea();
				jt_2 = new JTextArea();
				jt_1.setEditable(false);
				jt.setEditable(false);
	
				JScrollPane s = new JScrollPane(jt);
				JScrollPane s_ = new JScrollPane(jt_1);
				JScrollPane s__ = new JScrollPane(jt_2);
				s_.setBounds(250, 11, 200, 200);
				s__.setBounds(35, 250, 400, 200);
	
				s.setBounds(10, 11, 200, 200);   
				                
	
				f.getContentPane().add(s);
				f.getContentPane().add(s_);
				f.getContentPane().add(s__);
				f.show();
	
	
				jt_2.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
					  JTextArea textArea = (JTextArea) e.getSource();
					  String text = textArea.getText();
					  user.sender.send(text+user.name);
					}
			  
					public void keyTyped(KeyEvent e) {
					}
			  
					public void keyPressed(KeyEvent e) {
					}
				  });
	
			  }
		}
