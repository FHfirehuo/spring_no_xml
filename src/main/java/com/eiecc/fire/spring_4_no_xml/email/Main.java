package com.eiecc.fire.spring_4_no_xml.email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eiecc.fire.spring_4_no_xml.email.domain.Order;
import com.eiecc.fire.spring_4_no_xml.email.service.SimpleOrderManager;

public class Main {
	
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailConfig.class);
		
		SimpleOrderManager manager =  context.getBean(SimpleOrderManager.class);
		Order order = context.getBean(Order.class);
		order.setEmail("511374191@qq.com");
		order.setFirstName("liu");
		order.setLastName("yi");
		order.setId(1);
		order.setMessage("hello world lalala");
		manager.placeOrder(order);
		context.close();
	}

}
