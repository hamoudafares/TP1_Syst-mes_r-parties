import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class Send {
	
		  private  String[] QUEUE_NAME ;
		  private   ConnectionFactory factory ;
		  private   Connection connection ;
		  private Channel channel ;
		  private String name;
		  public Send(String name) {
			  this.name = name ; 
			  this.factory = new ConnectionFactory();
			  this.factory.setHost("localhost");
			  try {
				this.connection = this.factory.newConnection();
				 this.channel = this.connection.createChannel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  QUEUE_NAME = new String[]{"nouuur","marwen","faress"};
		  }
		  public void send (String msg) {
			  		
			        String message = msg;
			        for(int i=0;i<QUEUE_NAME.length;i++){
			        	 if(!QUEUE_NAME[i].equals(name)){
			        		 System.out.println(QUEUE_NAME[i]);
				        try {
							channel.basicPublish("", QUEUE_NAME[i], null,  message.getBytes());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        }
        
		  }
		 
	  
}