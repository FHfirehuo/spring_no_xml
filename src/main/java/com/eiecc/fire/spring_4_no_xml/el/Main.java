package com.eiecc.fire.spring_4_no_xml.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
		ELConfig resourceService = context.getBean(ELConfig.class);
		
		resourceService.outputResource();
		
		context.close();

	}

}
