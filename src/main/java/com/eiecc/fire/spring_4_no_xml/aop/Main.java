package com.eiecc.fire.spring_4_no_xml.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AopConfig.class);
		
		UseActionByMethod useActionByMethod = acac.getBean(UseActionByMethod.class);
		UseActionByAnnotation actionByAnnotation = acac.getBean(UseActionByAnnotation.class);
		
		actionByAnnotation.add();
		useActionByMethod.update();
		acac.close();
	}

}
