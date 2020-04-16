import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.swing.JTextArea;

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
	  
	  public Receive(String message, MyFrame frame) {
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
	  }

	  public void run () {
		  
		  try {
				this.channel.queueDeclare(name, false, false, false, null);
				  DeliverCallback deliverCallback = (consumerTag, delivery) -> {
					     String message = new String(delivery.getBody(), "UTF-8");
					     String owner = message.split(" ")[0];
					     System.out.println(owner);
					     f.jTextAreas.get(owner).setText(message.substring(owner.length(),message.length()));
					};
					channel.basicConsume(name, true, deliverCallback, consumerTag -> { });
			  
		  
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
	  }

	  
}