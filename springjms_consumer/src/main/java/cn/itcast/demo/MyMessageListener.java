package cn.itcast.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage textMessage=(TextMessage)message;
		try {
			System.out.println("接收到消息："+textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
