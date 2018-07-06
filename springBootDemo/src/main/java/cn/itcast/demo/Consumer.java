package cn.itcast.demo;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination="itcast")
	public void readMessage(String text){
		System.out.println("接收到消息:"+text);
	}
	
	@JmsListener(destination="itcast_map")
	public void readMapMessage(Map map){
		System.out.println(map);		
	}
	
}
