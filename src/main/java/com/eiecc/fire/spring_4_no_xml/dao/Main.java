package com.eiecc.fire.spring_4_no_xml.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eiecc.fire.spring_4_no_xml.config.JDBCConfig;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
		
		UserDao userDao = context.getBean(UserDao.class);
		userDao.add("liuyi");
		context.close();
	}

}
