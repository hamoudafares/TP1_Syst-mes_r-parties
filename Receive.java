import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
public class Receive extends Thread {
	  private  ConnectionFactory factory ;
	  private  Connection connection ;
	  private  Channel channel ;
	  private MyFrame f;
	  private String name;
	  ArrayList<String> Names = new ArrayList<>(Arrays.asList("nouuur", "marwen", "faress"));
	  
	  public Receive(String message, MyFrame frame ) {
		  f = frame;
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
		  name = message;
		  Names.remove(name);
	  }

	  public void run () {
		  
		  try {
			  

				this.channel.queueDeclare(name, false, false, false, null);
				  DeliverCallback deliverCallback = (consumerTag, delivery) -> {
					     String message = new String(delivery.getBody(), "UTF-8");
					     String owner = message.substring(message.length()-6);

					     if(owner.equals((String) Names.get(0))){
					    	 f.jt.setText(message.substring(0,message.length()-6));
					     }
					     else
					    	 f.jt_1.setText(message.substring(0,message.length()-6));
					     
					     
   
					};
					
					
					channel.basicConsume(name, true, deliverCallback, consumerTag -> { });
			  
		  
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	  }

	  
}