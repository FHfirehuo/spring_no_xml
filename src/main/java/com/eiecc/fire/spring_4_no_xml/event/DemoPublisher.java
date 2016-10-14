package com.eiecc.fire.spring_4_no_xml.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

	@Autowired
	ApplicationContext applicationContext; //注入ApplicationContext用来发布事件
	
	public void publish(String msg){
		System.out.println("--------------------");
		applicationContext.publishEvent(new DemoEvent(this, msg)); //使用ApplicationContext的publishEvent方法来发布
		System.out.println("--------------------");
	}
}
