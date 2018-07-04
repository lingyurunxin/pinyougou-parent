package cn.itcast.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 发布订阅模式（消息生产者）
 * @author Administrator
 *
 */
public class TopicProducer {

	public static void main(String[] args) throws JMSException {
		//1.创建连接工厂
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.25.135:61616");
		//2.创建连接
		Connection connection = connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.获取session(会话对象)  参数1：是否启动事务  参数2：消息确认方式
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.创建主题对象
		Topic topic = session.createTopic("test-topic");		
		//6.创建消息生产者对象
		MessageProducer producer = session.createProducer(topic);
		//7.创建消息对象（文本消息）
		TextMessage textMessage = session.createTextMessage("欢迎来到申请的品优购世界");
		//8.发送消息
		producer.send(textMessage);
		//9.关闭资源
		producer.close();
		session.close();
		connection.close();

	}

}
