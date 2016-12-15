package com.eiecc.fire.spring_4_no_xml.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext();
		
		context.getEnvironment().setActiveProfiles("dev"); //先将活动的profile设置为dev
		context.register(ProfileConfig.class); //后注册bean配置类，不然会报bean未定义的错误
		context.refresh();//刷新容器
		
		DemoBean demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContent());	
	}

}
