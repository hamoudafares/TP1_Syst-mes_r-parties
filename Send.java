import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class Send {
		  private  ArrayList<String> QUEUE_NAME = new ArrayList<String>();
		  private   ConnectionFactory factory ;
		  private   Connection connection ;
		  private Channel channel ;
		  private String name;
		  
		  public Send(String name, ArrayList<String> names) {
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
			  QUEUE_NAME = names;
		  }
		  public void send (String msg) {
			  		
			        String message = msg;
			        for(int i=0;i<QUEUE_NAME.size();i++){
				        try {
							channel.basicPublish("", QUEUE_NAME.get(i), null,  message.getBytes());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
        
		  }
		 
	  
}