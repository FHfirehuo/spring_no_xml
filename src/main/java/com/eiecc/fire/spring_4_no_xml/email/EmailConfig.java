package com.eiecc.fire.spring_4_no_xml.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@Configuration
@ComponentScan
public class EmailConfig {

	@Bean
	public JavaMailSenderImpl mailSender() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.sina.com");
		mailSender.setProtocol("smtp");
		mailSender.setPort(25);
		mailSender.setUsername("liu511374191@sina.com");
		mailSender.setPassword("xiaoyaomeng");

		return mailSender;

	}

	@Bean
	public SimpleMailMessage templateMessage() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("liu511374191@sina.com");
		message.setSubject("Your order");
		return message;
	}
	
	@Bean
	public VelocityEngineFactoryBean velocityEngin(){
		VelocityEngineFactoryBean engineFactoryBean = new VelocityEngineFactoryBean();
		
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engineFactoryBean.setVelocityProperties(p);
		return engineFactoryBean;
	}

}
