package com.eiecc.fire.spring_4_no_xml.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

	}

}
