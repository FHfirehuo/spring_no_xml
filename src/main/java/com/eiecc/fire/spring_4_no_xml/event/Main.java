package com.eiecc.fire.spring_4_no_xml.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(EventConfig.class);
		
		DemoPublisher demoPublisher = applicationContext.getBean(DemoPublisher.class);
		demoPublisher.publish("hello liuyi");
		System.out.println("??????");
		applicationContext.close();

	}

}
